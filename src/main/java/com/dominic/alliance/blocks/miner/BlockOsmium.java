package com.dominic.alliance.blocks.miner;

import com.dominic.alliance.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockOsmium extends BlockBase {

	public BlockOsmium(String name, Material material) {
		super(name, material);
		
		// Custom properties
		setSoundType(SoundType.STONE); // Sound that is made when walked on
		setHardness(5f); // How hard it is to mine this
		setResistance(30f); // Explosive resistance
		setHarvestLevel("pickaxe", 1);
		setLightLevel(0f); // Light emitted
		setLightOpacity(15); // Scale: 0 - 15
		//setBlockUnbreakable();
	}
	
	
}
