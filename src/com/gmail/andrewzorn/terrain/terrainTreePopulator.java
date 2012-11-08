package com.gmail.andrewzorn.terrain;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class terrainTreePopulator extends BlockPopulator {
	public void populate(World world, Random random, Chunk chunk) {
		if(random.nextInt(10)<2) {
			TreeType type = (random.nextInt(10)<3) ? TreeType.BIG_TREE : TreeType.TREE;
			world.generateTree(chunk.getBlock(6+random.nextInt(4),21,6+random.nextInt(4)).getLocation(),type);
		}
	}
}
