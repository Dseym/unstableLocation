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
		
		timer.waitTP.add("���� ������� �����������...");
		timer.waitTP.add("���-�� �� ���...");
		timer.waitTP.add("�� ���������� ���������...");
		timer.waitTP.add("�� ���������� ���� �������...");
		
		timer.tp.add("�� �����������������!");
		timer.tp.add("������� ����������!");
		timer.tp.add("�� ��������� � ������ �����.");
		timer.tp.add("��� ������ � �� ��������� ���.");
		
	}
	
}
