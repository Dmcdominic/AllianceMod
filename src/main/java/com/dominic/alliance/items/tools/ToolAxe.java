package com.dominic.alliance.items.tools;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.util.IHasModel;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.tabAllianceMod);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
