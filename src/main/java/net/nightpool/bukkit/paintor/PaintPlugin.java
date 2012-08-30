package net.nightpool.bukkit.paintor;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PaintPlugin extends JavaPlugin {
	
	public Set<Player> painters;
	public PaintCommand pc;
	public PaintEvent pe;
	
	
	@Override
	public void onEnable(){
		pc = new PaintCommand(this);
		pe = new PaintEvent(this);
		
		painters = new HashSet<Player>();
		
		getCommand("paintor").setExecutor(pc);
		getServer().getPluginManager().registerEvents(pe, this);

		getLogger().info("Enabled!");
	}
	
	@Override
	public void onDisable(){
		for(Player p : painters){
			p.sendMessage(ChatColor.DARK_RED+"Plugin disabled. You have stopped painting.");
		}
		getLogger().info("Disabled :(");
	}
}
