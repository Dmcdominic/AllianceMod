package com.dominic.alliance.blocks.miner;

import com.dominic.alliance.blocks.BlockOre;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class OreOsmium extends BlockOre {

	public OreOsmium(String name, Material material) {
		super(name, material);
		
		setHarvestLevel("pickaxe", 1);
	}
	
}
