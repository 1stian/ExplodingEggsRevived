package com.ohneemc;

import java.util.List;

import com.ohneemc.Commands.resources.toggleMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChange implements Listener {
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e){
		List<?> worldList = ExplodingEggs.pluginST.getConfig().getList("ExplodingEggs.DisabledWorlds");
		Player player = e.getPlayer();
		String cWorld = player.getWorld().getName();
		if (worldList.contains(cWorld)){
			if (toggleMap.ee.containsKey(player)) {
				toggleMap.ee.remove(player);
				player.sendMessage(ChatColor.AQUA + "Egg explosion disabled. use /ee to reenable it");
			}
		}
	}
}
