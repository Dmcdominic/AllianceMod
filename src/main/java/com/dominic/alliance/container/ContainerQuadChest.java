package com.dominic.alliance.container;

import com.dominic.alliance.tileentity.TileEntityQuadChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerQuadChest extends ContainerWithPlayerInv {
	
	public static final int invX = 28;
	public static final int invY = 16;
	public static final int playerInvX = 8;
	public static final int playerInvY = 149;
	
	private IItemHandler handler;
	private TileEntityQuadChest te;
	
	public ContainerQuadChest(IInventory playerInv, TileEntityQuadChest te) {
		super(playerInv, playerInvX, playerInvY);
		
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		// Add inventory slots here, with their indices and positions in the GUI
		for (int bigY = 0; bigY < 2; bigY++) {
			for (int bigX = 0; bigX < 2; bigX++) {
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						int index = x + (y * 3) + (bigX * 9) + (bigY * 18);
						int xPos = invX + 18 * x + (bigX * 68);
						int yPos = invY + 18 * y + (bigY * 67);
						this.addSlotToContainer(new SlotItemHandler(handler, index, xPos, yPos));
					}
				}
			}
		}
	}
	
	// Allows you to shift-click items into the inventory
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    return super.transferStackWithHandler(playerIn, fromSlot, this.handler);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.canInteractWith(player);
	}

}
