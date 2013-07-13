package net.nightpool.bukkit.paintor;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PaintEvent implements Listener {

	private PaintPlugin p;

	public PaintEvent(PaintPlugin plugin) {
		this.p = plugin;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void HandleBlock(BlockPlaceEvent ev){
		Player player = ev.getPlayer();
		Block block = ev.getBlock();
		if(p.painters.contains(player) &&
				!p.builds.contains(block.getType()) &&
				!player.isSneaking()){
			ev.getBlockAgainst().setTypeIdAndData(block.getTypeId(), block.getData(), true);
			ev.setCancelled(true);
		}
	}

}
