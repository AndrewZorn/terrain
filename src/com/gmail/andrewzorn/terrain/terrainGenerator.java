package com.gmail.andrewzorn.terrain;

import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class terrainGenerator extends ChunkGenerator {
	@SuppressWarnings("unused")
	private terrain plugin;
	
	public terrainGenerator(terrain instance) {
		this.plugin = instance;
	}
	
	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		populators.add(new terrainTreePopulator());
		
		return populators;
	}
	
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world,0,5,0);
	}
	
	private int coordsToInt(int x, int y, int z) {
		return (x*16+z)*128+y;
	}
	
	public byte[] generate(World world, Random rand, int chunkX, int chunkZ) {
		byte[] blocks = new byte[32768];
		int x,y,z;
		
		for(x=0; x<16; x++) {
			for(z=0; z<16; z++) {
				blocks[this.coordsToInt(x,0,z)] = (byte) Material.BEDROCK.getId();
				
				for(y=1; y<20; y++) {
					blocks[this.coordsToInt(x,y,z)] = (byte) Material.DIRT.getId();
				}
				
				if((x+z)%2 == 1)
					blocks[this.coordsToInt(x,20,z)] = (byte) Material.OBSIDIAN.getId();
				else
					blocks[this.coordsToInt(x,20,z)] = (byte) Material.WOOL.getId();
				
				blocks[this.coordsToInt(x,40,z)] = (byte) Material.GLASS.getId();
				blocks[this.coordsToInt(x,41,z)] = (byte) Material.LAVA.getId();
			}
		}
		
		return blocks;
	}
}
