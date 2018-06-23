package com.dominic.alliance.fluids;

import com.dominic.alliance.init.ModBlocks;
import com.dominic.alliance.init.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidBase extends BlockFluidClassic {

	public BlockFluidBase(String name, Fluid fluid, Material material) {
		super(fluid, material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.tabAllianceMod);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
}
