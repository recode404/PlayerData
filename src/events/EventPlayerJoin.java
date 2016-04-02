package events;

import net.playerdata.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Handles when player joins server.
 */
public class EventPlayerJoin implements Listener {

    private Player player;
    private PlayerData pd;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        player = event.getPlayer();
        pd = new PlayerData(player.getUniqueId());

        currentDataCheck();
    }

    //updates any information that may have changed while player was offline
    private void currentDataCheck() {
        if(!pd.getName().equals(player.getName()))
            pd.setName(player.getName());
    }
}
