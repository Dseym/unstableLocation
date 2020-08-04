package unstableLocation;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class timer implements Runnable {
	
	static List<String> waitTP = new ArrayList<String>();
	static List<String> tp = new ArrayList<String>();

	@Override
	public void run() {
		
		if(!main.start) {
			
			return;
			
		}
		
		int random = (int)Math.floor(Math.random()*waitTP.size());
		
		for(Player p: Bukkit.getOnlinePlayers()) {
			
			p.sendMessage(main.tagPlugin + waitTP.get(random));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 8*20, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 8*20, 1));
			
		}
		
		Bukkit.getScheduler().runTaskLater(commands.plugin, new teleport(random), 100);

	}

}
