package com.dominic.alliance.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ContainerWithPlayerInv extends Container {
	
	public static final int playerInvSlotTotal = 36;
	
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
	
	// Allows you to shift-click items into the inventory [with default slot merge range]
	public ItemStack transferStackWithHandler(EntityPlayer playerIn, int fromSlot, IItemHandler handler) {
	    return this.transferStackWithHandler(playerIn, fromSlot, handler, 0, handler.getSlots());
	}
	
	// Shift-clicking with parameters for limited slots to merge into
	public ItemStack transferStackWithHandler(EntityPlayer playerIn, int fromSlot, IItemHandler handler, int minSlot, int maxSlot) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < handler.getSlots()) {
	            // From the player's inventory to the block's inventory
	        	System.out.println("Trying to merge from block's inventory into player inventory?");
	        	if (minSlot < 0 || maxSlot > handler.getSlots()) {
	        		throw new IllegalArgumentException("Given slot range for shift-click merging is not valid");
	        	}
	        	minSlot += playerInvSlotTotal;
	        	maxSlot += playerInvSlotTotal;
	        	System.out.println("Trying to merge into limited slot range with minSlot: " + minSlot + " and maxSlot: " + maxSlot);
//	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, false)) {
	        	if (!this.mergeItemStack(current, minSlot, maxSlot, false)) {
	                System.out.println("Successfully? merged INTO player inventory?");
	            	return ItemStack.EMPTY;
	            }
	        } else {
	            // From the block's inventory to the player's inventory
	        	if (!this.mergeItemStack(current, 0, handler.getSlots(), false)) {
	                System.out.println("Success(?)");
	            	return ItemStack.EMPTY;
	            }
	        }

	        if (current.getCount() == 0) {
	            slot.putStack(ItemStack.EMPTY);
	        } else {
	            slot.onSlotChanged();
	        }
	            
	        if (current.getCount() == previous.getCount()) {
	            return null;
	        }
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
	
	@Override
	public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
		if (slotIn instanceof UninteractableSlot) {
			return false;
		}
		return super.canMergeSlot(stack, slotIn);
	}

}
