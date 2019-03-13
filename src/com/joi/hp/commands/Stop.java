package com.joi.hp.commands;

import org.bukkit.entity.Player;

import com.joi.hp.commands.MessageManager.MessageType;
import com.joi.hp.maps.Map;
import com.joi.hp.maps.MapManager;

public class Stop extends Commands {
	
	public Stop() {
		super("plugin.admin", "Stop a game", "", new String[] { "" });
	}
	
	@Override
	public void onCommand(Player sender, String[] args) {
		Map m = MapManager.get().getMap(sender);
		if (m == null) {
			MessageManager.get().message(sender, "You are not in an arena.", MessageType.BAD);
			return;
		}
		if (!m.isStarted()) {
			MessageManager.get().message(sender, "The game has not started yet.", MessageType.BAD);
			return;
		}
		m.stop();
		MessageManager.get().message(sender, "Round ended.");
	}
}
