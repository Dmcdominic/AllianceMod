package com.dominic.alliance.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityQuadChest extends TileEntityWithInventory {

	public static final int SIZE = 16;
	
	private int someCounter;
	
	// Constructor
	public TileEntityQuadChest() {
		super(SIZE);
		someCounter = 0;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("someCounter", this.someCounter);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.someCounter = compound.getInteger("someCounter");
	}
	
}
