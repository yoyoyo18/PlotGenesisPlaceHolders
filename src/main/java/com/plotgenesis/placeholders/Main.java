package com.plotgenesis.placeholders;

import org.bukkit.plugin.java.JavaPlugin;

public class PlotGenPlaceholder extends JavaPlugin {

    @Override
    public void onEnable() {
        new GensPlaceholder(this).register();
    }

    @Override
    public void onDisable() {
    }
}
