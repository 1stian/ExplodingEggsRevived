package com.ohneemc.ExplodingEggs;

import java.util.Random;

import com.ohneemc.ExplodingEggs.Commands.resources.toggleMap;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class Explode implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void ex(PlayerEggThrowEvent event) {
		Egg egg = event.getEgg();
		
		boolean randomEx = ExplodingEggs.pluginST.getConfig().getBoolean("ExplodingEggs.Explosion.Random-Explode", false);
		boolean blockDmg = ExplodingEggs.pluginST.getConfig().getBoolean("ExplodingEggs.Damage.Block-Damage", false);
		int exRad = ExplodingEggs.pluginST.getConfig().getInt("ExplodingEggs.Explosion.Explosion-radius", 2);
		int chance = ExplodingEggs.pluginST.getConfig().getInt("ExplodingEggs.Explosion.Chance-For-Explosion", 40);
		
		if (randomEx == true){
			event.setHatching(false);
			Random gen = new Random();
			int r = gen.nextInt(100);
			if (r < chance){
				if (toggleMap.ee.containsKey(event.getPlayer())){
					if (toggleMap.ee.containsValue(true)){
						
						if (blockDmg == true){
							egg.getWorld().createExplosion(egg.getLocation(), exRad, false);
						}
						else if (blockDmg == false){
							egg.getWorld().createExplosion(egg.getLocation().getX(), egg.getLocation().getY(), egg.getLocation().getZ(), exRad, false, false);
						}
					}
				}
			}
		}
		else if(randomEx == false){
			event.setHatching(false);
			if (toggleMap.ee.containsKey(event.getPlayer())){
					
				if (blockDmg == true){
					egg.getWorld().createExplosion(egg.getLocation(), exRad, false);
				}
				else if (blockDmg == false){
					egg.getWorld().createExplosion(egg.getLocation().getX(), egg.getLocation().getY(), egg.getLocation().getZ(), exRad, false, false);
				}
			}
		}
	}
}
