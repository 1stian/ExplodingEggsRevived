package com.ohneemc.ExplodingEggs;

import com.ohneemc.ExplodingEggs.Commands.resources.toggleMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		boolean enabledDef = ExplodingEggs.pluginST.getConfig().getBoolean("ExplodingEggs.Explosion.Enabled-By-Default", false);
		if (enabledDef){
			if(player.hasPermission("ExplodingEggs.ee")){
				toggleMap.ee.put(player, true);
			}
		}
	}
}
