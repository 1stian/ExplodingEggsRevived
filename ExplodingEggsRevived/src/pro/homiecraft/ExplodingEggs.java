package pro.homiecraft;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pro.homiecraft.Commands.ee;

public class ExplodingEggs extends JavaPlugin {
	public static ExplodingEggs pluginST;

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Egg(), this);
		pm.registerEvents(new Explode(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerLeave(), this);
		
		ExplodingEggs.pluginST = this;
		
		getCommands(this);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.reloadConfig();
	}
	
	public void getCommands(ExplodingEggs ExplodingEggs){
		this.getCommand("ee").setExecutor(new ee());
	}
}
