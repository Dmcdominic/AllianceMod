package com.dominic.alliance.blocks.machines;

import java.util.HashMap;
import java.util.Map;

import com.dominic.alliance.init.ModBlocks;
import com.dominic.alliance.player.Roles.Role;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Liquifier extends MachineBase {
	
	private static Map<Block, Block> liquifications = new HashMap<Block, Block>();
	
	public Liquifier(String name, Material material, boolean locked) {
		super(name, material, Role.WIZARD, 1, locked);	// Role and tier required
		
		// Fill in liquifications here
		liquifications.put(Blocks.ICE, Blocks.WATER);
		liquifications.put(Blocks.COBBLESTONE, Blocks.LAVA);
		
		liquifications.put(ModBlocks.BLOCK_OSMIUM, ModBlocks.BLOCK_NON_NEWTONIAN_FLUID); // Osmium block is a placeholder: replace with something cooler
	}
	
	@Override
	public boolean onValidActivation(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		BlockPos toLiquifyPos = pos.down();
		Block toLiquify = worldIn.getBlockState(toLiquifyPos).getBlock();
		System.out.println(worldIn.getBlockState(toLiquifyPos));
		System.out.println(toLiquify);
		Block outcome = liquifications.get(toLiquify);
		System.out.println(outcome);
		
		if (outcome != null) {
			IBlockState newBlockState = outcome.getDefaultState();
			worldIn.destroyBlock(toLiquifyPos, false);
			worldIn.setBlockState(toLiquifyPos, newBlockState);
		}
		
		return true;
	}

}
