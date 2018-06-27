package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.fluids.FluidBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import scala.Console;

public class ModFluids {

	// ArrayList for all mod fluids
	public static final List<Fluid> FLUIDS = new ArrayList<Fluid>();
	
	// For registering the fluids
	public static final void registerFluids() {
		for (Fluid fluid : FLUIDS) {
			FluidRegistry.registerFluid(fluid);
			FluidRegistry.addBucketForFluid(fluid);
		}
	}
	
	
	// ================ FLUIDS ================
	
	public static final Fluid NON_NEWTONIAN_FLUID = new FluidBase("non_newtonian_fluid",
			new ResourceLocation("alliance", "fluids/non_newtonian_fluid_still"),
			new ResourceLocation("alliance", "fluids/non_newtonian_fluid_flow"),
			0xFFFFFFFF, 0.2f)
			.setMaterial(ModMaterials.LIQUID_BLACK).setDensity(1400).setLuminosity(2).setRarity(EnumRarity.RARE).setTemperature(200).setViscosity(1400);
	
}
