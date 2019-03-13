package com.joi.hp;

import org.bukkit.plugin.java.JavaPlugin;

import com.joi.hp.commands.CommandsManager;
import com.joi.hp.maps.MapListener;
import com.joi.hp.maps.MapManager;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public static Main get() {
		return instance;
	}
	
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin Enabled!");
		CommandsManager.get().setup();
		Settings.get().setup(this);
		MapManager.get().setupMaps();
		MapListener.get().setup();
	}
	
	public void onDisable() {
		getLogger().info("Disabled!");
	}

}
