package com.dominic.alliance.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmeltingRecipes {
	
	public static void init() {
		// Int value = output total ... Float value = experience multiplier
		GameRegistry.addSmelting(Items.EMERALD, new ItemStack(ModItems.PINK_RUBY, 1), 1.0f);
		GameRegistry.addSmelting(ModBlocks.ORE_OSMIUM, new ItemStack(ModItems.INGOT_OSMIUM, 1), 1.0f);
	}
	
}
