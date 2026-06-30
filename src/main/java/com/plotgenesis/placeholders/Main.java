package com.plotgenesis.placeholders;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new GensPlaceholder(this).register();
        getLogger().info("PlotGenesisPlaceholders enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlotGenesisPlaceholders disabled");
    }
}
