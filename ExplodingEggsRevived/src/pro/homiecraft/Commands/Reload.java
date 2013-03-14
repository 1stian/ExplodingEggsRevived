package pro.homiecraft.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pro.homiecraft.ExplodingEggs;



public class Reload implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {		
		if(sender.hasPermission("ExplodingEggs.admin")){
			if(cmd.getName().equalsIgnoreCase("explodingeggs")){
				if(args.length < 1){
					sender.sendMessage(ChatColor.AQUA + "Plugin Name: " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getName().toString());
					sender.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getVersion().toString());
					sender.sendMessage(ChatColor.AQUA + "Author(s): " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getAuthors().toString());
				}else{
					if(args[0].equalsIgnoreCase("reload")){
						ExplodingEggs.pluginST.reloadConfig();
						sender.sendMessage(ChatColor.AQUA + "ExplodingEggs config has been " + ChatColor.DARK_RED + "reloaded!");
					}
				}
			}
		}
		return true;
	}
}
