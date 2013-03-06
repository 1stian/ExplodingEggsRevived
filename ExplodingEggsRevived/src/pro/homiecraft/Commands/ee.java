package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.Commands.resources.toggle;

public class ee implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender.hasPermission("ExplodingEggs.ee")){
			if(cmd.getName().equalsIgnoreCase("ee")){
				Player player = (Player) sender;
				toggle.togglePluginState(player.getPlayer());
				return true;
			}
			return true;
		}
		return false;
	}

}
