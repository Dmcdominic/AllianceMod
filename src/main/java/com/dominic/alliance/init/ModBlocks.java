package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.blocks.*;
import com.dominic.alliance.blocks.machines.*;
import com.dominic.alliance.blocks.miner.*;
import com.dominic.alliance.fluids.BlockFluidBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import scala.Console;

public class ModBlocks {

	// ArrayList for all mod blocks
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	// ================ BLOCKS ================
	
	public static final Block PINK_RUBY_BLOCK = new BlockBase("pink_ruby_block", Material.IRON);
	public static final Block PACKED_DIRT = new PackedDirt("packed_dirt", Material.GROUND);
	public static final Block DOUBLE_PACKED_DIRT = new DoublePackedDirt("double_packed_dirt", Material.GROUND);
	
	public static final Block QUAD_CHEST = new QuadChest("quad_chest", Material.WOOD);
	public static final Block QUAD_CHEST_2 = new QuadChest2("quad_chest_2", Material.WOOD);
	
	// Miner
	public static final Block ORE_OSMIUM = new OreOsmium("ore_osmium", Material.ROCK);
	public static final Block BLOCK_OSMIUM = new BlockOsmium("block_osmium", Material.IRON);
	
	// Wizard
	public static final Block LIQUIFIER_LOCKED = new Liquifier("liquifier_locked", Material.IRON, true);
	public static final Block LIQUIFIER_UNLOCKED = new Liquifier("liquifier_unlocked", Material.IRON, false);
	
	
	// ================ FLUID BLOCKS ================
	
	public static Block BLOCK_NON_NEWTONIAN_FLUID;
	
	public static void generateFluidBlocks() {
		BLOCK_NON_NEWTONIAN_FLUID = new BlockFluidBase("non_newtonian_fluid", ModFluids.NON_NEWTONIAN_FLUID, ModMaterials.LIQUID_BLACK);
	}
	
}
