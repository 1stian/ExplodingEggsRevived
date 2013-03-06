package pro.homiecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pro.homiecraft.Commands.resources.toggleMap;

public class PlayerJoin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		boolean enabledDef = ExplodingEggs.pluginST.getConfig().getBoolean("ExplodingEggs.Explosion.Enabled-By-Default", false);
		if (enabledDef == true){
			toggleMap.ee.put(player, true);
		}
	}
}
