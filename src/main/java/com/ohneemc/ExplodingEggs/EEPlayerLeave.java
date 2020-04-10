package com.ohneemc.ExplodingEggs;

import com.ohneemc.ExplodingEggs.Commands.resources.toggleMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.logging.Level;

public class EEPlayerLeave implements Listener {
	@EventHandler
	public void EEonPlayerLeave(PlayerQuitEvent event){
		try{
			toggleMap.ee.remove(event.getPlayer().getName());
		}catch(Exception e){
			ExplodingEggs.pluginST.log.log(Level.SEVERE, "Error on player leave - ExplodingEggs");
		}
	}
}
