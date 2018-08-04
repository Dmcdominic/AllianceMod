package com.dominic.alliance.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityQuadChest2 extends TileEntityWithInventory {

	public static final int SIZE = 36;
	
//	private int someCounter;
	
	// Constructor
	public TileEntityQuadChest2() {
		super(SIZE);
//		someCounter = 0;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
//		compound.setInteger("someCounter", this.someCounter);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
//		this.someCounter = compound.getInteger("someCounter");
	}
	
}
