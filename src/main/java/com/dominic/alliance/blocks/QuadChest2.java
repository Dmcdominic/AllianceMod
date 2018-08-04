package com.dominic.alliance.blocks;

import com.dominic.alliance.Main;
import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.tileentity.TileEntityQuadChest2;
import com.dominic.alliance.util.handlers.GuiHandler;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class QuadChest2 extends BlockBase implements ITileEntityProvider {

	public QuadChest2(String name, Material material) {
		super(name, material);
		
		// Custom properties
		setSoundType(SoundType.WOOD); // Sound that is made when walked on
		setHardness(2.5f); // How hard it is to mine this
		setHarvestLevel("axe", 0);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityQuadChest2();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// Only execute on the server
		if (worldIn.isRemote) {
			return true;
		}
		TileEntity te = worldIn.getTileEntity(pos);
		if (!(te instanceof TileEntityQuadChest2)) {
			return false;
		}
		if (Roles.getRole(playerIn) != null) {
			playerIn.openGui(Main.instance, GuiHandler.QUAD_CHEST_2, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		// TODO - message about role requirement here
		playerIn.sendStatusMessage(new TextComponentString("This chest is accessible only once you have reached tier 1 of an Alliance class"), false);
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityQuadChest2 te = (TileEntityQuadChest2) worldIn.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int slot = 0; slot < handler.getSlots(); slot++) {
			ItemStack stack = handler.getStackInSlot(slot);
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack));
		}
		
		super.breakBlock(worldIn, pos, state);
	}

}