package com.dominic.alliance.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOre extends BlockBase {
	
	// Properties
	public Item toDrop;
	public int minDropAmount = 1;
	public int maxDropAmount = 1;
	
	// Abbreviated constructors
	public BlockOre(String name, Material material) {
		this(name, material, null, 1, 1);
	}
	
	public BlockOre(String name, Material material, Item toDrop) {
		this(name, material, toDrop, 1, 1);
	}
	
	public BlockOre(String name, Material material, Item toDrop, int dropAmount) {
		this(name, material, toDrop, dropAmount, dropAmount);
	}
	
	// Full constructor
	public BlockOre(String name, Material material, Item toDrop, int minDropAmount, int maxDropAmount) {
		super(name, material);
		
		this.toDrop = toDrop;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
		
		setSoundType(SoundType.STONE); // Sound that is made when walked on
		setHardness(3f); // How hard it is to mine this
		setResistance(15f); // Explosive resistance
		setHarvestLevel("pickaxe", 0);
	}
	
	// Return what item should be dropped by this block
	@Override
	public Item getItemDropped(IBlockState blockState, Random random, int fortuneLvl) {
		if (toDrop == null) {
			return Item.getItemFromBlock(this);
		} else {
			return toDrop;
		}
	}
	
	// Return how many items should be dropped, without fortune
	@Override
	public int quantityDropped(Random random) {
		// Check that the min and max make sense
		if (this.minDropAmount > this.maxDropAmount) {
			int newMax = this.minDropAmount;
			this.minDropAmount = this.maxDropAmount;
			this.maxDropAmount = newMax;
		}
		
		return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
	}
	
	// Return how many items should be dropped, with fortune
	@Override
	public int quantityDroppedWithBonus(int fortuneLvl, Random random) {
		if (fortuneLvl > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortuneLvl)) {
			int i = random.nextInt(fortuneLvl + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
	
}
