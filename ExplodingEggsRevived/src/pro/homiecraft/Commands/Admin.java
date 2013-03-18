package pro.homiecraft.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pro.homiecraft.ExplodingEggs;



public class Admin implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {		
		if(sender.hasPermission("ExplodingEggs.admin")){
			if(cmd.getName().equalsIgnoreCase("explodingeggs")){
				if(args.length < 1){
					sender.sendMessage(ChatColor.AQUA + "Plugin Name: " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getName().toString());
					sender.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getVersion().toString());
					sender.sendMessage(ChatColor.AQUA + "Author(s): " + ChatColor.DARK_RED + ExplodingEggs.pluginST.getDescription().getAuthors().toString());
				}else{
					if(!(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("config"))){
						sender.sendMessage("[ExplodingEggs] Usage:");
						sender.sendMessage("/explodingeggs config|reload");
					}else{
						if(args[0].equalsIgnoreCase("reload")){
							ExplodingEggs.pluginST.reloadConfig();
							sender.sendMessage(ChatColor.AQUA + "ExplodingEggs config has been " + ChatColor.DARK_RED + "reloaded!");
						}
						
						if(args[0].equalsIgnoreCase("config")){
							if (args.length > 2){
								if (args[1].equalsIgnoreCase("random")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Random-Explode", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage("[ExplodingEggs] Random explosion is set to: " + arg);
										}else{
											sender.sendMessage("ExplodingEggs Usage:");
											sender.sendMessage("/explodingeggs config random true|false");
										}
									}else{
										sender.sendMessage("ExplodingEggs Usage:");
										sender.sendMessage("/explodingeggs config random true|false");
									}
								}
								
								if (args[1].equalsIgnoreCase("blockdmg")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Damage.Block-Damage", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage("[ExplodingEggs] Block damage is set to: " + arg);
										}else{
											sender.sendMessage("ExplodingEggs Usage:");
											sender.sendMessage("/explodingeggs config blockdmg true|false");
										}
									}else{
										sender.sendMessage("ExplodingEggs Usage:");
										sender.sendMessage("/explodingeggs config blockdmg true|false");
									}
								}
								
								if (args[1].equalsIgnoreCase("enbdefault")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Enabled-By-Default", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage("[ExplodingEggs] Enabled by default is set to: " + arg);
										}else{
											sender.sendMessage("ExplodingEggs Usage:");
											sender.sendMessage("/explodingeggs config enbdefault true|false");
										}
									}else{
										sender.sendMessage("ExplodingEggs Usage:");
										sender.sendMessage("/explodingeggs config enbdefault true|false");
									}
								}
							}else{
								sender.sendMessage("ExplodingEggs Usage:");
								sender.sendMessage("/explodingeggs config random|blockdmg|enbdefault");
							}
						}
					}
				}
			}
		}
		return true;
	}
}
