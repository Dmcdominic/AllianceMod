package com.dominic.alliance.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlockOrientableBase extends BlockBase {

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	// ============== Util functions ==============
	
	public static BlockPos getOrientedOffset(BlockPos posFrom, Vec3d offset, EnumFacing facingDirection) {
		Vec3d trueOffset = offset;
		switch (facingDirection) {
			case NORTH: trueOffset = offset;
				break;
			case EAST: 	trueOffset = offset.rotateYaw((float) Math.toRadians(90));
				break;
			case SOUTH: trueOffset = offset.rotateYaw((float) Math.toRadians(180));
				break;
			case WEST: 	trueOffset = offset.rotateYaw((float) Math.toRadians(-90));
				break;
			case UP: 	trueOffset = offset.rotatePitch((float) Math.toRadians(-90));
				break;
			case DOWN: 	trueOffset = offset.rotatePitch((float) Math.toRadians(90));
				break;
		}
		
		return posFrom.add(trueOffset.x, trueOffset.y, trueOffset.z);
	}
	
	public static BlockPos getOrientedOffset(BlockPos posFrom, Vec3d offset, IBlockState state) {
		if (state.getBlock() instanceof BlockOrientableBase) {
			EnumFacing facingDirection = state.getValue(FACING);
			return getOrientedOffset(posFrom, offset, facingDirection);
		} else {
			System.out.println("ERROR: Expected a BlockOrientableBase at that position");
			return posFrom;
		}
	}
	
	public static EnumFacing getOrientedFacing(IBlockState state, EnumFacing desiredDirection) {
		switch (state.getValue(FACING)) {
			case NORTH: return desiredDirection;
			case EAST: 	return desiredDirection.rotateY();
			case SOUTH: return desiredDirection.rotateY().rotateY();
			case WEST: 	return desiredDirection.rotateYCCW();
			case UP: 	return desiredDirection.rotateAround(Axis.Z);
			case DOWN: 	return desiredDirection.rotateAround(Axis.Z).rotateAround(Axis.Z).rotateAround(Axis.Z);
			default: 	return desiredDirection;
		}
	}
	
	
	// ========== BlockState management ==========
	
	public BlockOrientableBase(String name, Material material) {
		super(name, material);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}
	
}
