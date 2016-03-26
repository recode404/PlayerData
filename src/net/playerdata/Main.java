package net.playerdata;

import events.EventPlayerJoin;
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
        loadDataFolder();
    }

    @Override
    public void onDisable() {
        dir = null;
    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new EventPlayerJoin(), this);
    }

    private void loadDataFolder() {
        dir = this.getDataFolder();
        if(!dir.exists())
            dir.mkdirs();
    }

    public static File dataFolder() { return dir;}
}
