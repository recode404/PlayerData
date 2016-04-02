package net.playerdata;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Used to edit player data files.
 */
public class PlayerData {
    private File dataFolder, file;
    private YamlConfiguration config;
    private UUID id = null;

    public PlayerData(UUID id) {
        this.id = id;
        load();
    }

    //creates players folder and player file if needed loads config
    private void load() {
        dataFolder = new File(Main.dataFolder() + File.separator + "players");
        file = new File(dataFolder + File.separator + id + ".yml");

        if(!dataFolder.exists())
            dataFolder.mkdirs();

        if(!file.exists())
            try {
                file.createNewFile();
                config = YamlConfiguration.loadConfiguration(file);
                loadDefaults();
            } catch (IOException e) {
                e.printStackTrace();
            }
        else
            config = YamlConfiguration.loadConfiguration(file);
    }

    //loads default for player's data
    private void loadDefaults() {
        config.set("name", Bukkit.getPlayer(id).getName());
        config.set("rank", 0);
        config.set("balance",0);
        save();
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return config.getString("name");
    }

    public void setName(String name) {
        config.set("name", name);
        save();
    }

    public int getRank() {
        return config.getInt("rank");
    }

    public void setRank(int rank) {
        config.set("rank", rank);
        save();
    }

    public long getBalance() {
        return config.getLong("balance");
    }

    public void setBalance(long balance) {
        config.set("balance", balance);
        save();
    }
}
