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

    private void load(UUID id) {
        file = new File(Main.dataFolder() + File.separator + id + ".yml");

        if(!file.exists())
            try {
                file.createNewFile();
                config = YamlConfiguration.loadConfiguration(file);
                loadDefaults(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        else
            config = YamlConfiguration.loadConfiguration(file);
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDefaults(UUID id) {
        config.set("name", Bukkit.getPlayer(id).getName());
        config.set("rank", 0);
        save();
    }

    public int getRank(UUID id) {
        load(id);
        return config.getInt("rank");
    }

    public void setRank(UUID id, int rank) {
        load(id);
        config.set("rank", rank);
        save();
    }

}
