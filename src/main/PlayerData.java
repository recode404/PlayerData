package main;

import events.EventPlayerJoin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * PlayerData by recurse404 created for Bukkit.
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
        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new EventPlayerJoin(), this);
    }

    private void registerCommands() {

    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
