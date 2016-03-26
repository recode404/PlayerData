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

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        player = event.getPlayer();
        PlayerData pd = new PlayerData(player.getUniqueId());
        player.sendMessage("you are rank " + pd.getRank());
    }
}
