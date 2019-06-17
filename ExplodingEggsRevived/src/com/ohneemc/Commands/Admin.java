package com.ohneemc.Commands;

import java.util.regex.Pattern;

import com.ohneemc.ExplodingEggs;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Admin implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {		
		if(sender.hasPermission("ExplodingEggs.admin")){
			if(cmd.getName().equalsIgnoreCase("explodingeggs")){
				if(args.length < 1){
					sender.sendMessage(ChatColor.AQUA + "Plugin Name: " + ChatColor.RED + ExplodingEggs.pluginST.getDescription().getName().toString());
					sender.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.RED + ExplodingEggs.pluginST.getDescription().getVersion().toString());
					sender.sendMessage(ChatColor.AQUA + "Author(s): " + ChatColor.RED + ExplodingEggs.pluginST.getDescription().getAuthors().toString());
					sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.AQUA + "ExplodingEggs help" + ChatColor.DARK_GRAY + "-----");
					sender.sendMessage(ChatColor.AQUA + "/explodingeggs reload - " + ChatColor.RED + "This will reload the config from file.");
					sender.sendMessage(ChatColor.AQUA + "/explodingeggs config - " + ChatColor.RED + "Edit the config from in-game");
				}else{
					if(!(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("config"))){
						sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
						sender.sendMessage(ChatColor.AQUA + "/explodingeggs " + ChatColor.RED + "config|reload");
					}else{
						if(args[0].equalsIgnoreCase("reload")){
							ExplodingEggs.pluginST.reloadConfig();
							sender.sendMessage(ChatColor.AQUA + "ExplodingEggs config has been " + ChatColor.RED + "reloaded!");
						}
						
						if(args[0].equalsIgnoreCase("config")){
							if (args.length > 1){
								if (args[1].equalsIgnoreCase("random")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Random-Explode", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Random explosion is set to: " + ChatColor.RED + arg);
										}else{
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
											sender.sendMessage(ChatColor.AQUA + "/explodingeggs config random " + ChatColor.RED + "true|false");
										}
									}else{
										sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config random " + ChatColor.RED + "true|false");
									}
								}
								
								if (args[1].equalsIgnoreCase("blockdmg")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Damage.Block-Damage", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Block damage is set to: " + ChatColor.RED + arg);
										}else{
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
											sender.sendMessage(ChatColor.AQUA + "/explodingeggs config blockdmg " + ChatColor.RED + "true|false");
										}
									}else{
										sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config blockdmg " + ChatColor.RED + "true|false");
									}
								}
								
								if (args[1].equalsIgnoreCase("enbdefault")){
									if (args.length == 3){
										if (args[2].equalsIgnoreCase("false") || args[2].equalsIgnoreCase("true")){
											String arg = args[2];
											ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Enabled-By-Default", Boolean.parseBoolean(arg));
											ExplodingEggs.pluginST.saveConfig();
											ExplodingEggs.pluginST.reloadConfig();
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Enabled by default is set to: " + ChatColor.RED + arg);
										}else{
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
											sender.sendMessage(ChatColor.AQUA + "/explodingeggs config enbdefault" + ChatColor.RED + "true|false");
										}
									}else{
										sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config enbdefault " + ChatColor.RED + "true|false");
									}
								}
								
//								if(args[1].equalsIgnoreCase("dedworlds")){
//									if (args.length == 3){
//										List<?> worldList = ExplodingEggs.pluginST.getConfig().getList("ExplodingEggs.DisabledWorlds");
//										if (args.length == 4){
//											if (args[2].equalsIgnoreCase("add")){
//												worldList.add(args[3]);
//												ExplodingEggs.pluginST.saveConfig();
//												ExplodingEggs.pluginST.reloadConfig();
//												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] World: " + ChatColor.RED + args[3] + ChatColor.AQUA + " is now added to disabled worlds.");
//											}
//											if (args[2].equalsIgnoreCase("remove")){
//												worldList.remove(args[3]);
//												ExplodingEggs.pluginST.saveConfig();
//												ExplodingEggs.pluginST.reloadConfig();
//												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] World: " + ChatColor.RED + args[3] + ChatColor.AQUA + " is now removed from disabled worlds.");
//											}
//										}
//										if (args[2].equalsIgnoreCase("list")){
//											String dedWorlds = worldList.toString();
//											sender.sendMessage(dedWorlds);
//										}
//									}else{
//										sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
//										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config dedworlds add|remove " + ChatColor.RED + "<worldName>");
//										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config dedworlds list - " + ChatColor.RED + "Prints the disabled worlds.");
//									}
//								}
								
								if (args[1].equalsIgnoreCase("chance")){
									if (args.length == 3){
											String arg = args[2];
											if (!(Pattern.matches("[a-zA-Z]+", arg) == false)){
												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
												sender.sendMessage(ChatColor.AQUA + "/explodingeggs config chance " + ChatColor.RED + "<number>");
											}else{
												ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Chance-For-Explosion", Integer.parseInt(arg));
												ExplodingEggs.pluginST.saveConfig();
												ExplodingEggs.pluginST.reloadConfig();
												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Random explosion chance set to: " + ChatColor.RED + arg + "%");
											}
										}else{
											sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
											sender.sendMessage(ChatColor.AQUA + "/explodingeggs config chance " + ChatColor.RED + "<number>");
										}
									}
								
								if (args[1].equalsIgnoreCase("radius")){
									if (args.length == 3){
											String arg = args[2];
											if (!(Pattern.matches("[a-zA-Z]+", arg) == false)){
												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
												sender.sendMessage(ChatColor.AQUA + "/explodingeggs config radius " + ChatColor.RED + "<number>");
											}else{
												ExplodingEggs.pluginST.getConfig().set("ExplodingEggs.Explosion.Explosion-radius", Integer.parseInt(arg));
												ExplodingEggs.pluginST.saveConfig();
												ExplodingEggs.pluginST.reloadConfig();
												sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Random explosion chance set to: " + ChatColor.RED + arg);
											}
									}else{
										sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
										sender.sendMessage(ChatColor.AQUA + "/explodingeggs config radius " + ChatColor.RED + "<number>");
									}
								}
							}else{
								sender.sendMessage(ChatColor.AQUA + "[ExplodingEggs] Usage:");
								sender.sendMessage(ChatColor.AQUA + "/explodingeggs config " + ChatColor.RED + "random|blockdmg|enbdefault|chance|radius");
							}
						}
					}
				}
			}
		}
		return true;
	}
}
