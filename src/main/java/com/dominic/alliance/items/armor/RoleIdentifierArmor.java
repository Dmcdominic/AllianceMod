package com.dominic.alliance.items.armor;

import com.dominic.alliance.player.Roles.Role;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class RoleIdentifierArmor extends ArmorBase {
	
	public Role role;
	public int tier;

	public RoleIdentifierArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, Role roleIn, int tierIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		role = roleIn;
		tier = tierIn;
	}

	@Override
	public boolean onArmorEquipped(EntityPlayer player, ItemStack armor, EntityEquipmentSlot slot) {
		if (super.onArmorEquipped(player, armor, slot)) {
			// TODO - Anything on role armor equipped?
			return true;
		}
		return false;
	}
	
	@Override
	public void onArmorRemoved(EntityPlayer player, ItemStack armor, EntityEquipmentSlot slot) {
		// TODO - Role changed event?
	}
}
