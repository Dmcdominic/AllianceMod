package com.dominic.alliance.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DoublePackedDirt extends BlockBase {

	public DoublePackedDirt(String name, Material material) {
		super(name, material);
		
		// Custom properties
		setSoundType(SoundType.GROUND); // Sound that is made when walked on
		setHardness(0.9f); // How hard it is to mine this
		setResistance(7.5f); // Explosive resistance
		setHarvestLevel("shovel", 0); // spade?
	}

}
