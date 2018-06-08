package com.dominic.alliance.blocks;

import com.dominic.alliance.tileentity.TileEntityQuadChest;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class QuadChest extends BlockBase implements ITileEntityProvider {

	public QuadChest(String name, Material material) {
		super(name, material);
		
		// Custom properties
		setSoundType(SoundType.WOOD); // Sound that is made when walked on
		setHardness(2.5f); // How hard it is to mine this
		setHarvestLevel("axe", 0);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityQuadChest();
	}

}
