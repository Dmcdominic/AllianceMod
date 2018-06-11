package com.dominic.alliance.client.gui;

import com.dominic.alliance.container.ContainerQuadChest;
import com.dominic.alliance.tileentity.TileEntityQuadChest;
import com.dominic.alliance.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiQuadChest extends GuiContainer {

	private TileEntityQuadChest te;
	private IInventory playerInv;
	
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/quad_chest.png");
	
	public GuiQuadChest(IInventory playerInv, TileEntityQuadChest te) {
		super(new ContainerQuadChest(playerInv, te));
		
		this.xSize = 10; // Fill these in!
		this.ySize = 10;
		
		this.te = te;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(background);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		String s = I18n.format("container.block_breaker"); // Gets the formatted name for the block breaker from the language file
		this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752); // Draws the block breaker name in the center on the top of the gui
		this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); // The player's inventory name
	}

}
