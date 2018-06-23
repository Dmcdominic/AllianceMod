package com.dominic.alliance;

import com.dominic.alliance.init.ModFluids;
import com.dominic.alliance.init.ModSmeltingRecipes;
import com.dominic.alliance.proxy.CommonProxy;
import com.dominic.alliance.tileentity.TileEntityQuadChest;
import com.dominic.alliance.util.Reference;
import com.dominic.alliance.worldgen.OreGen;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.Console;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		ModFluids.registerFluids();
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		proxy.init();
		ModSmeltingRecipes.init();
		
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		RegisterTileEntities();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
	
	// Register all tile-entities here
	private static void RegisterTileEntities() {
		GameRegistry.registerTileEntity(TileEntityQuadChest.class, Reference.MOD_ID + "TileEntityQuadChest");
	}
	
}
