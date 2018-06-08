package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.blocks.BlockBase;
import com.dominic.alliance.blocks.DoublePackedDirt;
import com.dominic.alliance.blocks.PackedDirt;
import com.dominic.alliance.blocks.QuadChest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// Blocks
	public static final Block PINK_RUBY_BLOCK = new BlockBase("pink_ruby_block", Material.IRON);
	public static final Block PACKED_DIRT = new PackedDirt("packed_dirt", Material.GROUND);
	public static final Block DOUBLE_PACKED_DIRT = new DoublePackedDirt("double_packed_dirt", Material.GROUND);
	
	public static final Block QUAD_CHEST = new QuadChest("quad_chest", Material.WOOD);
}
