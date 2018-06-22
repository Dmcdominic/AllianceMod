package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.blocks.*;
import com.dominic.alliance.blocks.miner.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	// ArrayList for all mod blocks
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	// ================ BLOCKS ================
	
	public static final Block PINK_RUBY_BLOCK = new BlockBase("pink_ruby_block", Material.IRON);
	public static final Block PACKED_DIRT = new PackedDirt("packed_dirt", Material.GROUND);
	public static final Block DOUBLE_PACKED_DIRT = new DoublePackedDirt("double_packed_dirt", Material.GROUND);
	
	public static final Block QUAD_CHEST = new QuadChest("quad_chest", Material.WOOD);
	
	// Miner
	public static final Block ORE_OSMIUM = new OreOsmium("ore_osmium", Material.ROCK);
	public static final Block BLOCK_OSMIUM = new BlockOsmium("block_osmium", Material.IRON);
}
