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
    private File file;
    private YamlConfiguration config;
    private UUID id = null;

    public PlayerData(UUID id) {
        this.id = id;
    }

    private void load() {
        file = new File(Main.dataFolder() + File.separator + id + ".yml");

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

    private void loadDefaults() {
        config.set("name", Bukkit.getPlayer(id).getName());
        config.set("rank", 0);
        save();
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
