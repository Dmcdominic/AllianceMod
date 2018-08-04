package com.dominic.alliance.client.gui;

import com.dominic.alliance.container.ContainerQuadChest2;
import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.tileentity.TileEntityQuadChest2;
import com.dominic.alliance.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiQuadChest2 extends GuiContainer {

	private static final int xSize = 176;
	private static final int ySize = 231;
	
	private TileEntityQuadChest2 te;
	private IInventory playerInv;
	
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_quad_chest.png");
	
	public GuiQuadChest2(IInventory playerInv, TileEntityQuadChest2 te, EntityPlayer player) {
		super(new ContainerQuadChest2(playerInv, te, player));
		
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
		this.drawDefaultBackground();
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(background);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.quad_chest"); // Gets the formatted name from the language file 
		this.fontRenderer.drawString(s, (xSize - this.mc.fontRenderer.getStringWidth(s)) / 2, 6, 4210752); // Draws the block name in the top-center of the gui
		
		int x = ContainerQuadChest2.playerInvX;
		int y = ContainerQuadChest2.playerInvY - 11;
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), x, y, 4210752); // Draws the player's inventory name
		
	}

}
