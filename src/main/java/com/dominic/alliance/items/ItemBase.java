package com.dominic.alliance.items;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.util.HasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements HasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS); // TODO - Change this later? Make own tab? Or just use this as default
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
