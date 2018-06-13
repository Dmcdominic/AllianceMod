package com.dominic.alliance.client.gui;

import com.dominic.alliance.container.ContainerQuadChest;
import com.dominic.alliance.tileentity.TileEntityQuadChest;
import com.dominic.alliance.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiQuadChest extends GuiContainer {

	private static final int xSize = 176;
	private static final int ySize = 231;
	
	private TileEntityQuadChest te;
	private IInventory playerInv;
	
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_quad_chest.png");
	
	public GuiQuadChest(IInventory playerInv, TileEntityQuadChest te) {
		super(new ContainerQuadChest(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		int yPosOffset = -(ySize - 166) / 2;
		this.guiTop += yPosOffset;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(background);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.quad_chest"); // Gets the formatted name for the block breaker from the language file 
		this.fontRenderer.drawString(s, (xSize - this.mc.fontRenderer.getStringWidth(s)) / 2, 6, 4210752); // Draws the block name in the top-center of the gui
		
		int x = ContainerQuadChest.playerInvX;
		int y = ContainerQuadChest.playerInvY - 9;
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), x, y, 4210752); // Draws the player's inventory name
		
	}

}
