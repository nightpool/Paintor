package net.nightpool.bukkit.paintor;

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
		Player pl = ev.getPlayer();
		if(p.painters.contains(pl) && !p.builds.contains(ev.getBlock().getType())){
			ev.getBlockAgainst().setTypeIdAndData(ev.getBlock().getTypeId(), ev.getBlock().getData(), true);
			ev.setCancelled(true);
		}
	}

}
