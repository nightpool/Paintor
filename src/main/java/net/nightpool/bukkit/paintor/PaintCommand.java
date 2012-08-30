package net.nightpool.bukkit.paintor;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaintCommand implements CommandExecutor {

	private PaintPlugin p;

	public PaintCommand(PaintPlugin plugin) {
		this.p = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("Sorry, this is a player command."); return true;}
		Player player = (Player) sender;
		
		if(args.length > 0){
			if(args[0].equals("on")){
				on(player); return true;
			}else if(args[0].equals("off")){
				off(player); return true;
			}else if(Material.matchMaterial(args[0]) != null){
				for (String s : args){
					if(Material.matchMaterial(s) != null){
						p.builds.add(Material.matchMaterial(s));
					} else{
						player.sendMessage(ChatColor.RED + "No material "+s+" found.");
					}
				}
			} else{
				return false;
			}
		}
		
		toggle(player);
		 
		return true;
	}

	private void toggle(Player player) {
		if(p.painters.contains(player)){
			off(player);
		} else{
			on(player);
		}
		
	}

	private void off(Player player) {
		p.painters.remove(player);
		player.sendMessage(ChatColor.AQUA + "Painting stopped.");
	}

	private void on(Player player) {
		p.painters.add(player);
		player.sendMessage(ChatColor.AQUA + "Painting started.");
	}

}
