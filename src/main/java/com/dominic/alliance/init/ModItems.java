package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.items.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {

	// Creative tab
	public static final CreativeTabs tabAllianceMod = (new CreativeTabs("tabAllianceMod") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PINK_RUBY);
		}
		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
	}).setBackgroundImageName("item_search.png");
	
	// ArrayList for all mod items
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	// Items
	public static final Item PINK_RUBY = new ItemBase("pink_ruby");
	
}
