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
	
	
	
	public PaintPlugin(){
		pc = new PaintCommand(this);
		getCommand("paintor").setExecutor(pc);
		
		pe = new PaintEvent(this);
		getServer().getPluginManager().registerEvents(pe, this);
		
	}
	
	@Override
	public void onEnable(){
		getLogger().info("Enabled!");
		painters = new HashSet<Player>();
	}
	
	@Override
	public void onDisable(){
		for(Player p : painters){
			p.sendMessage(ChatColor.DARK_RED+"Plugin disabled. You have stopped painting.");
		}
		getLogger().info("Disabled :(");
	}
}
