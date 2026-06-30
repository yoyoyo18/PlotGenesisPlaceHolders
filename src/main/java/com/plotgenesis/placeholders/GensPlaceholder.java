package me.plotgen;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.Set;

public class GensPlaceholder extends PlaceholderExpansion {

    private final PlotGenPlaceholder plugin;

    public GensPlaceholder(PlotGenPlaceholder plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "plotgen";
    }

    @Override
    public String getAuthor() {
        return "PlotGen";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, String params) {

        if (offlinePlayer == null || !offlinePlayer.isOnline()) {
            return "0/0";
        }

        Player player = offlinePlayer.getPlayer();
        if (player == null) return "0/0";

        // === GET PLACED GENERATORS FROM SKRIPT ===
        // Change this path if your Skript variable is different
        int placed = getPlacedGenerators(player);

        // === GET LIMIT FROM PERMISSIONS ===
        int limit = getGeneratorLimit(player);

        return placed + "/" + limit;
    }

    /**
     * Reads Skript variable for placed gens
     * EDIT THIS LINE IF YOUR VARIABLE NAME IS DIFFERENT
     */
    private int getPlacedGenerators(Player player) {
        try {
            // This requires Skript API being accessible
            Object result = ch.njol.skript.variables.Variables.getVariable(
                    "gens::" + player.getUniqueId() + "::placed-list",
                    player,
                    false
            );

            if (result instanceof java.util.Collection<?>) {
                return ((java.util.Collection<?>) result).size();
            }

            if (result == null) return 0;

        } catch (Exception e) {
            plugin.getLogger().warning("Failed to read Skript gens for " + player.getName());
        }

        return 0;
    }

    /**
     * Determines limit from permission ranks
     */
    private int getGeneratorLimit(Player player) {

        Set<PermissionAttachmentInfo> perms = player.getEffectivePermissions();

        int limit = 15; // default

        for (PermissionAttachmentInfo perm : perms) {
            String p = perm.getPermission();

            if (!perm.getValue()) continue;

            switch (p.toLowerCase()) {
                case "2ram": return 25;
                case "4ram": return 50;
                case "8ram": return 65;
                case "16ram": return 90;
                case "24ram": return 120;
            }
        }

        return limit;
    }
}
