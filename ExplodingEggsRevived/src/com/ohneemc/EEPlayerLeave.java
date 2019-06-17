package com.ohneemc;

import com.ohneemc.Commands.resources.toggleMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EEPlayerLeave implements Listener {
	@EventHandler
	public void EEonPlayerLeave(PlayerQuitEvent event){
		try{
			toggleMap.ee.remove(event.getPlayer().getName());
		}catch(Exception e){
			
		}
	}
}
