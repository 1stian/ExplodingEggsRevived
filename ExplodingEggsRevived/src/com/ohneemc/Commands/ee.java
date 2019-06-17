package com.ohneemc.Commands;

import java.util.List;

import com.ohneemc.ExplodingEggs;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ohneemc.Commands.resources.toggle;

public class ee implements CommandExecutor {
	
	List<?> worldList = ExplodingEggs.pluginST.getConfig().getList("ExplodingEggs.DisabledWorlds");

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		String cWorld = player.getWorld().getName();
		if(sender.hasPermission("ExplodingEggs.ee")){
			if(cmd.getName().equalsIgnoreCase("ee")){
				if(!(worldList.contains(cWorld))){
					toggle.togglePluginState(player.getPlayer());
				}else{
					player.sendMessage(ChatColor.AQUA + "ExplodingEggs is disabled in this world!");
				}
				return true;
			}
			return true;
		}
		return false;
	}

}
