package com.dominic.alliance.blocks.machines;

import com.dominic.alliance.blocks.BlockBase;
import com.dominic.alliance.blocks.BlockOrientableBase;
import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public abstract class MachineBase extends BlockOrientableBase {

	public Role roleRequired;
	public int tierRequired;
	public boolean lockedToRole;
	
	public MachineBase(String name, Material material, Role role, int tier, boolean locked) {
		super(name, material);
		
		// Default block properties for machines
		setSoundType(SoundType.METAL); // Sound that is made when walked on
		setHardness(2f); // How hard it is to mine this
		setResistance(20f); // Explosive resistance
		setHarvestLevel("pickaxe", 1);
		
		this.roleRequired = role;
		this.tierRequired = tier;
		this.lockedToRole = locked;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (lockedToRole && !Roles.isRole(playerIn, this.roleRequired, this.tierRequired)) {
			playerIn.sendStatusMessage(new TextComponentString("Requires a tier " + this.tierRequired + " " + this.roleRequired.toString().toLowerCase()), false);
			return true;
		}
		
		return this.onValidActivation(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	public abstract boolean onValidActivation(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ);

}
