package net.playerdata;

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

    private void load(UUID uuid) {
        file = new File(Main.dataFolder() + File.separator + uuid + ".yml");

        if(!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        config = YamlConfiguration.loadConfiguration(file);
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRank(UUID uuid) {
        load(uuid);
        return config.getInt("rank");
    }

    public void setRank(UUID uuid, int rank) {
        load(uuid);
        config.set("rank", rank);
        save();
    }

}
