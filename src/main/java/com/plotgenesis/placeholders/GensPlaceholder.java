package com.plotgenesis.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GensPlaceholder extends PlaceholderExpansion {

    private final JavaPlugin plugin;

    public GensPlaceholder(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "plotgen";
    }

    @Override
    public String getAuthor() {
        return "CoolSun";
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
    public String onPlaceholderRequest(Player player, String params) {

        if (player == null) return "0/0";

        if (params.equalsIgnoreCase("gens")) {
            // We'll add the actual Skript variable reading next
            return "0/15";
        }

        return null;
    }
}
