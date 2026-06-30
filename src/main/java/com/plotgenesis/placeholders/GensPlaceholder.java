package com.plotgenesis.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.Collection;
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
        return "PlotGenesis";
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
    public String onRequest(OfflinePlayer player, String params) {

        if (player == null || !player.isOnline()) {
            return "0/0";
        }

        Player p = player.getPlayer();
        if (p == null) return "0/0";

        int placed = 0;
        int limit = getLimit(p);

        return placed + "/" + limit;
    }

    private int getLimit(Player p) {

        for (PermissionAttachmentInfo perm : p.getEffectivePermissions()) {
            if (!perm.getValue()) continue;

            switch (perm.getPermission().toLowerCase()) {
                case "2ram": return 25;
                case "4ram": return 50;
                case "8ram": return 65;
                case "16ram": return 90;
                case "24ram": return 120;
            }
        }

        return 15;
    }
}
