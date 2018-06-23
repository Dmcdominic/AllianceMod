package com.dominic.alliance.fluids;

import com.dominic.alliance.init.ModFluids;

import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidBase extends Fluid {

	protected int mapColor = 0xFFFFFFFF;
	protected float overlayAlpha = 0.2f;
	protected SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
	protected SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
	protected Material material = Material.WATER;
	
	// Constructors
	public FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		
		ModFluids.FLUIDS.add(this);
	}
	
	public FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor) {
        this(fluidName, still, flowing);
        setColor(mapColor);
    }

	public FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor, float overlayAlpha) {
        this(fluidName, still, flowing, mapColor);
        setAlpha(overlayAlpha);
    }
	
	
	// Setters and getters
	public FluidBase setColor(int parColor) {
		mapColor = parColor;
		return this;
	}
	@Override
	public int getColor() {
		return mapColor;
	}
	
	public FluidBase setAlpha(float parOverlayAlpha) {
		overlayAlpha = parOverlayAlpha;
		return this;
	}
	public float getAlpha() {
		return overlayAlpha;
	}
	
	@Override
	public FluidBase setEmptySound(SoundEvent parSound) {
		emptySound = parSound;
		return this;
	}
	@Override
	public SoundEvent getEmptySound() {
		return emptySound;
	}
	
	@Override
	public FluidBase setFillSound(SoundEvent parSound) {
		fillSound = parSound;
		return this;
	}
	@Override
	public SoundEvent getFillSound() {
		return fillSound;
	}
	
	public FluidBase setMaterial(Material parMaterial) {
		material = parMaterial;
		return this;
	}
	public Material getMaterial() {
		return material;
	}
	
	@Override
	public boolean doesVaporize(FluidStack fluidStack) {
		if (block == null) {
			return false;
		}
		return block.getDefaultState().getMaterial() == getMaterial();
	}
	
}
