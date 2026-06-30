package me.plotgen;

import org.bukkit.plugin.java.JavaPlugin;

public class PlotGenPlaceholder extends JavaPlugin {

    private static PlotGenPlaceholder instance;

    @Override
    public void onEnable() {
        instance = this;

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("PlaceholderAPI not found! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        new GensPlaceholder(this).register();

        getLogger().info("PlotGenPlaceholder enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlotGenPlaceholder disabled.");
    }

    public static PlotGenPlaceholder getInstance() {
        return instance;
    }
}
