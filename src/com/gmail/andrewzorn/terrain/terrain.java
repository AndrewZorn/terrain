package com.gmail.andrewzorn.terrain;

import java.util.logging.Logger;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class terrain extends JavaPlugin {
	private Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		this.logMessage("Enabled.");
	}
	public void onDisable() {
		this.logMessage("Disabled.");
	}
	
	public void logMessage(String msg) {
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName()+" "+pdFile.getVersion()+": "+msg);
	}
	
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String uid) {
		return new terrainGenerator(this);
	}
}