package com.dominic.alliance.items.armor;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.util.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);

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
