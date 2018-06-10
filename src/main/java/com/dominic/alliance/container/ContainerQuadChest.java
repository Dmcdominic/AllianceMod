package com.dominic.alliance.container;

import com.dominic.alliance.tileentity.TileEntityQuadChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerQuadChest extends ContainerWithPlayerInv {
	
	private IItemHandler handler;
	private TileEntityQuadChest te;
	
	public ContainerQuadChest(IInventory playerInv, TileEntityQuadChest te) {
		super(playerInv);
		
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		// Add inventory slots here, with their indices and positions in the GUI
		int index = 0;
		int xPos = 62;
		int yPos = 17;
		this.addSlotToContainer(new SlotItemHandler(handler, index, xPos, yPos));
	}
	
	// Allows you to shift-click items into the inventory
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    return super.transferStackWithHandler(playerIn, fromSlot, this.handler);
	}

}
