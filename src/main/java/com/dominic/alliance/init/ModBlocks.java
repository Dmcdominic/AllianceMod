package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// Blocks
	public static final Block PINK_RUBY_BLOCK = new BlockBase("pink_ruby_block", Material.IRON);
}