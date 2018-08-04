package com.dominic.alliance.container;

import com.dominic.alliance.util.Reference;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

@Mod.EventBusSubscriber
public class UninteractableSlot extends SlotItemHandler {

	public UninteractableSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		this.setBackgroundLocation(new ResourceLocation(Reference.MOD_ID, "textures/gui/uninteractable_slot_background.png"));
		this.setBackgroundName("alliance/textures/gui/uninteractable_slot_background.png");
	}
	
	// Prevent the player from taking the itemStack
	@Override
	public boolean canTakeStack(EntityPlayer playerIn) {
		return false;
	}
	
	// Prevent the player from placing any items into the slot
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	
	// Trying to remove white mouse-over highlight
	// Or at least change background
	@SubscribeEvent
	public static void onTextureStitch(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(new ResourceLocation(Reference.MOD_ID, "gui/uninteractable_slot_background"));
	}
	
}
