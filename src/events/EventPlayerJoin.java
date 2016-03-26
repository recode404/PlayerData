package events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * handles when player joins server.
 */
public class EventPlayerJoin implements Listener {

    private Player player;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        player = event.getPlayer();

        player.sendMessage("PlayerData is running...");
    }
}
