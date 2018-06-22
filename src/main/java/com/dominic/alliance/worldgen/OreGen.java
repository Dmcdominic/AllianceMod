package com.dominic.alliance.worldgen;

import java.util.Random;

import com.dominic.alliance.init.ModBlocks;
import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	
	// ================= ORE/BLOCK WORLD-GENERATION =================
	
	// OVERWORLD ore generation
	private void genOverworldOres(Random random, int chunkX, int chunkZ, World world) {
		// 4, 6, 12, 60
		//runGenerator(ModBlocks.PINK_RUBY_BLOCK.getDefaultState(), 10, 10, 0, 256, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
		runGenerator(ModBlocks.ORE_OSMIUM.getDefaultState(), 6, 10, 16, 52, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
	}
	
	// NETHER ore generation
	private void genNetherOres(Random random, int chunkX, int chunkZ, World world) {
		//Nether ores go here
	}
	
	// END ore generation
	private void genEndOres(Random random, int chunkX, int chunkZ, World world) {
		// End ores go here
	}
	
	// ALL OTHER DIMENSIONS ore generation
	private void genOtherOres(Random random, int chunkX, int chunkZ, World world) {
		// Ores for random dimensions go here
	}
	
	
	
	// Generate ores by dimension
		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
			switch(world.provider.getDimension()) {
			case 0:		// Overworld
				genOverworldOres(random, chunkX, chunkZ, world);
				break;
				
			case -1:	// Nether
				genNetherOres(random, chunkX, chunkZ, world);
				break;
			
			case 1:		// End
				genEndOres(random, chunkX, chunkZ, world);
				break;

			default:	// All other dimensions
				genOtherOres(random, chunkX, chunkZ, world);
				break;
			}
		}
	
	// Generate some number of ore veins in a given dimension and chunk.
	// Tries to generate a vein "chancesToSpawn" times, with an amount randomly chosen between 1 and blockAmount.
	private void runGenerator(IBlockState blockToGen, int blockAmount, int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
			throw new IllegalArgumentException("Illegal height arguments for WorldGenerator");
		}
		
		WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

}
