package com.joi.hp.commands;

import org.bukkit.entity.Player;

import com.joi.hp.commands.MessageManager.MessageType;
import com.joi.hp.maps.Map;
import com.joi.hp.maps.MapManager;

public class Start extends Commands {
	
	public Start() {
		super("plugin.default", "Start a game", "", new String[] { "s" });
	}
	
	@Override
	public void onCommand(Player sender, String[] args) {
		Map m = MapManager.get().getMap(sender);
		if (m == null) {
			MessageManager.get().message(sender, "You are not in a map.", MessageType.BAD);
			return;
		}
		if (m.isStarted()) {
			MessageManager.get().message(sender, "The game has already been started.", MessageType.BAD);
			return;
		}
		m.start();
		MessageManager.get().message(sender, "You voted to start the game!");
	}

}
