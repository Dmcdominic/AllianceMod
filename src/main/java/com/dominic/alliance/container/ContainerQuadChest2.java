package com.dominic.alliance.container;

import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.tileentity.TileEntityQuadChest2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerQuadChest2 extends ContainerWithPlayerInv {
	
	public static final int invX = 28;
	public static final int invY = 16;
	public static final int playerInvX = 8;
	public static final int playerInvY = 149;
	
	public static final Role[] roleRegions = {	Role.WIZARD,	Role.MINER,
												Role.HUNTER,	Role.HERBALIST};
	
	private IItemHandler handler;
	private TileEntityQuadChest2 te;
	
	public final Role role;
	
	public ContainerQuadChest2(IInventory playerInv, TileEntityQuadChest2 te, EntityPlayer player) {
		super(playerInv, playerInvX, playerInvY);
		
		this.te = te;
		this.role = Roles.getRole(player);
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		// Add inventory slots here, with their indices and positions in the GUI
		for (int bigY = 0; bigY < 2; bigY++) {
			for (int bigX = 0; bigX < 2; bigX++) {
				
				// Create a 3x3 region
				boolean interactableRegion = (this.role == roleRegions[bigY * 2 + bigX]);
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						int index = x + (y * 3) + (bigX * 9) + (bigY * 18);
						int xPos = invX + 18 * x + (bigX * 68);
						int yPos = invY + 18 * y + (bigY * 67);
						if (interactableRegion) {
							this.addSlotToContainer(new SlotItemHandler(handler, index, xPos, yPos));
						} else {
							this.addSlotToContainer(new UninteractableSlot(handler, index, xPos, yPos));
						}
					}
				}
				
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.canInteractWith(player);
	}
	
	// Allows you to shift-click items into the inventory
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		Role role = Roles.getRole(playerIn);
		System.out.println("getMinSlot: " + getMinSlot(role));
		System.out.println("getMaxSlot: " + getMaxSlot(role));
	    return super.transferStackWithHandler(playerIn, fromSlot, this.handler, getMinSlot(role), getMaxSlot(role));
//	    return super.transferStackWithHandler(playerIn, fromSlot, this.handler);
	}

	// Methods to find the range of interactable slots (for shift-clicking)
	private int getMinSlot(Role role) {
		for (int i = 0; i < 4; i++) {
			if (roleRegions[i] == role) {
				return i * 9;
			}
		}
		return 0;
	}
	
	private int getMaxSlot(Role role) {
		for (int i = 0; i < 4; i++) {
			if (roleRegions[i] == role) {
				return (i + 1) * 9;
			}
		}
		return handler.getSlots();
	}
	
}