package unstableLocation;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class teleport implements Runnable {
	
	int random = 0;
	
	teleport(int random) {
		
		this.random = random;
		
	}

	@Override
	public void run() {
		
		for(Player p: Bukkit.getOnlinePlayers()) {
			
			p.sendMessage(main.tagPlugin + timer.tp.get(random));
			
			Location loc = p.getLocation();
			List<Location> blocksLoc = new ArrayList<Location>();
			for(int x = -15; x < 15; x++) {
				
				for(int y = -15; y < 15; y++) {
					
					for(int z = -15; z < 15; z++) {
						
						Location block = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y-1, loc.getZ()+z);
						
						if(block.getBlock().getType() == Material.AIR) {
							
							continue;
							
						}
						if(block.getBlock().getType() == Material.LAVA) {
							
							continue;
							
						}
						if(block.getBlock().getType() == Material.WATER) {
							
							continue;
							
						}
						
						block = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
						Location block2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y+1, loc.getZ()+z);
						if(block.getBlock().getType() != Material.AIR || block2.getBlock().getType() != Material.AIR) {
							
							continue;
							
						}
						
						blocksLoc.add(block);
						
					}
					
				}
				
			}
			
			if(blocksLoc.size() == 0) {
				
				p.sendMessage(main.tagPlugin + "Ничего не произошло...");
				continue;
				
			}
			
			p.teleport(blocksLoc.get((int)Math.floor(Math.random()*blocksLoc.size())));
			
		}
		
		Bukkit.getScheduler().runTaskLater(commands.plugin, new timer(), 600);

	}
	
}
