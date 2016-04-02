package net.playerdata;

import events.EventPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * PlayerData by recode404 created for Bukkit.
 */
public class Main extends JavaPlugin {

    private static File dir;

    @Override
    public void onEnable() {
        registerListeners();
        loadFiles();
    }

    @Override
    public void onDisable() {
        dir = null;
    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new EventPlayerJoin(), this);
    }

    private void loadFiles() {
        //load data folder
        dir = this.getDataFolder();
        if(!dir.exists())
            dir.mkdirs();

    }

    public static File dataFolder() { return dir;}
}
