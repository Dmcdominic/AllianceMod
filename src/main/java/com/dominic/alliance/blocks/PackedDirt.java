package com.dominic.alliance.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PackedDirt extends BlockBase {

	public PackedDirt(String name, Material material) {
		super(name, material);
		
		// Custom properties
		setSoundType(SoundType.GROUND); // Sound that is made when walked on
		setHardness(0.7f); // How hard it is to mine this
		setResistance(5f); // Explosive resistance
		setHarvestLevel("shovel", 0);
		setLightLevel(0f); // Light emitted
		setLightOpacity(15); // Scale: 0 - 15
		//setBlockUnbreakable();
	}
	
	
}
