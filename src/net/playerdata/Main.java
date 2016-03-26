package net.playerdata;

import events.EventPlayerJoin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * PlayerData by recurse404 created for Bukkit.
 */
public class Main extends JavaPlugin {

    private static File dir;

    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();
        loadDataFolder();
    }

    @Override
    public void onDisable() {
        dir = null;
    }

    private void registerListeners() {
        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new EventPlayerJoin(), this);
    }

    private void registerCommands() {

    }

    private void loadDataFolder() {
        dir = this.getDataFolder();
        if(!dir.exists())
            dir.mkdirs();
    }

    public static File dataFolder() {
        return dir;
    }
}
