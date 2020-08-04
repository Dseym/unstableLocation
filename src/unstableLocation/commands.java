package unstableLocation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commands implements CommandExecutor {
	
	static main plugin;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		main.start = true;
		
		return true;
		
	}

}
