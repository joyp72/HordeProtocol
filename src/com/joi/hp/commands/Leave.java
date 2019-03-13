package com.joi.hp.commands;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.joi.hp.commands.MessageManager.MessageType;
import com.joi.hp.maps.Map;
import com.joi.hp.maps.MapManager;

public class Leave extends Commands {

	public Leave() {
		super("plugin.default", "Leave a map", "", new String[] { "l" });
	}

	@Override
	public void onCommand(Player sender, String[] args) {
		Player p = sender;
		UUID id = p.getUniqueId();
		Map m = MapManager.get().getMap(p);
		if (m == null) {
			MessageManager.get().message(p, "You are not in a map.", MessageType.BAD);
			return;
		}
		m.kickPlayer(p);
	}

}
