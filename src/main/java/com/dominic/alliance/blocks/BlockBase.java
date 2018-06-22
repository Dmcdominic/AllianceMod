package com.dominic.alliance.blocks;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModBlocks;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.tabAllianceMod);
		
		// Set the default values here
		setHardness(0.5f);
		setResistance(10f);
		setLightLevel(0f); // Light emitted
		setLightOpacity(15); // Scale: 0 - 15
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
