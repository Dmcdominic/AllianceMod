package com.dominic.alliance.util.handlers;

import com.dominic.alliance.client.gui.GuiQuadChest;
import com.dominic.alliance.client.gui.GuiQuadChest2;
import com.dominic.alliance.container.ContainerQuadChest;
import com.dominic.alliance.container.ContainerQuadChest2;
import com.dominic.alliance.tileentity.TileEntityQuadChest;
import com.dominic.alliance.tileentity.TileEntityQuadChest2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int QUAD_CHEST = 0;
	public static final int QUAD_CHEST_2 = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (ID == QUAD_CHEST && te instanceof TileEntityQuadChest) {
			return new ContainerQuadChest(player.inventory, (TileEntityQuadChest) te);
		} else if (ID == QUAD_CHEST_2 && te instanceof TileEntityQuadChest2) {
			// TODO - populate role arg based on the player
			return new ContainerQuadChest2(player.inventory, (TileEntityQuadChest2) te, player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (ID == QUAD_CHEST && te instanceof TileEntityQuadChest) {
			return new GuiQuadChest(player.inventory, (TileEntityQuadChest) te);
		} else if (ID == QUAD_CHEST_2 && te instanceof TileEntityQuadChest2) {
			return new GuiQuadChest2(player.inventory, (TileEntityQuadChest2) te, player);
		}
		return null;
	}

}
