package com.dominic.alliance.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ContainerWithPlayerInv extends Container {
	
	public ContainerWithPlayerInv(IInventory playerInv, int xOffset, int yOffset) {
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xOffset + x * 18, yOffset + y * 18));
			}
		}
				
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xOffset + x * 18, yOffset + 58));
		}
	}
	
	// Constructor with default GUI x and y positions
	public ContainerWithPlayerInv(IInventory playerInv) {		
		this(playerInv, 8, 84);
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return !player.isSpectator();
	}
	
	// Allows you to shift-click items into the inventory
	public ItemStack transferStackWithHandler(EntityPlayer playerIn, int fromSlot, IItemHandler handler) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < handler.getSlots()) {
	            // From the block's inventory to player's inventory
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, false))
	                return ItemStack.EMPTY;
	        } else {
	            // From the player's inventory to block's inventory
	            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
	                return ItemStack.EMPTY;
	        }

	        if (current.getCount() == 0)
	            slot.putStack(ItemStack.EMPTY);
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}

}
