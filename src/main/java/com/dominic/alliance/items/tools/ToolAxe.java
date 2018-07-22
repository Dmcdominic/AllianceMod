package com.dominic.alliance.items.tools;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.util.IHasModel;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.tabAllianceMod);
		
		ModItems.ITEMS.add(this);
	}
	
	public ToolAxe(String name, ToolMaterial material) {
		this(name, material, 4.0f * material.getAttackDamage(), -0.517f * material.getEfficiency());
		// Iron "ItemAxe" damage is 8.0f and speed -3.1f
		// Iron material damage is 2.0f and efficiency is 6.0f
		// Thus, values for "ItemAxe" are computed in proportion to those of iron
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
