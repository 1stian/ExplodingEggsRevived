package pro.homiecraft.Commands.resources;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class toggle {
	public static void togglePluginState(Player player) {
		if (toggleMap.ee.containsKey(player)) {
			if (toggleMap.ee.get(player)) {
				toggleMap.ee.remove(player);
				player.sendMessage(ChatColor.AQUA + "Egg explosion " + ChatColor.DARK_RED + "disabled");
			} else {
				toggleMap.ee.put(player, true);
				player.sendMessage(ChatColor.AQUA + "Egg explosion " + ChatColor.DARK_RED + "enabled");

			}
		} else {
			toggleMap.ee.put(player, true);
			player.sendMessage(ChatColor.AQUA + "Egg explosion " + ChatColor.DARK_RED + "enabled");
		}

	}
}
