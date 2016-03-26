package main;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Taylor on 3/25/16.
 */
public class PlayerData extends JavaPlugin {

    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerListeners() {

    }

    private void registerCommands() {

    }
}
