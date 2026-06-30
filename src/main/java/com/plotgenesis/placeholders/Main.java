package com.plotgenesis.placeholders;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new GensPlaceholder(this).register();
            getLogger().info("PlotGenesisPlaceholders enabled!");
        } else {
            getLogger().severe("PlaceholderAPI not found! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("PlotGenesisPlaceholders disabled!");
    }
}
