package unstableLocation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {

	static boolean start = false;
	static String tagPlugin = ChatColor.RESET + "[" + ChatColor.BLUE + "UnstableLocation" + ChatColor.RESET + "] ";
	
	public void onEnable() {
		
		Bukkit.getScheduler().runTaskLater(this, new timer(), 600);
		this.getCommand("start").setExecutor((CommandExecutor)new commands());
		this.getLogger().info("Started!");
		
		commands.plugin = this;
		
		timer.waitTP.add("Ваша локация нестабильна...");
		timer.waitTP.add("Что-то не так...");
		timer.waitTP.add("Вы потихоньку изчезаете...");
		timer.waitTP.add("Вы чувствуете себя странно...");
		
		timer.tp.add("Вы телепортировались!");
		timer.tp.add("Локация поменялась!");
		timer.tp.add("Вы появились в другом месте.");
		timer.tp.add("Все прошло и Вы непонятно где.");
		
	}
	
}
