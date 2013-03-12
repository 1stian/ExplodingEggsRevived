package pro.homiecraft;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pro.homiecraft.Commands.ee;

public class ExplodingEggs extends JavaPlugin {
	public static ExplodingEggs pluginST;
	public Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Egg(), this);
		pm.registerEvents(new Explode(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerLeave(), this);
		pm.registerEvents(new WorldChange(), this);
		
		ExplodingEggs.pluginST = this;
		
		getCommands(this);
		
		initMetrics();
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.reloadConfig();
	}
	
	public void getCommands(ExplodingEggs ExplodingEggs){
		this.getCommand("ee").setExecutor(new ee());
	}
	
	public void initMetrics(){
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
			log.info("Metrics RealEstate " + e);
		}
	}
}
