package com.dominic.alliance.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class Roles {
	
	public static enum Role {WIZARD, MINER, HUNTER, HERBALIST}
	
	public static boolean isRole(EntityPlayer player, Role role) {
		return isRole(player, role, 0);
	}
	
	public static boolean isRole(EntityPlayer player, Role role, int tier) {
		switch (role) {
			case WIZARD: return isWizard(player, tier);
			case MINER: return isMiner(player, tier);
			case HUNTER: return isHunter(player, tier);
			case HERBALIST: return isHerbalist(player, tier);
		}
		return false;
	}
	
	// Player predicates for each role
	public static boolean isWizard(EntityPlayer player) {
		return isWizard(player, 0);
	}
	
	public static boolean isMiner(EntityPlayer player) {
		return isMiner(player, 0);
	}
	
	public static boolean isHunter(EntityPlayer player) {
		return isHunter(player, 0);
	}
	
	public static boolean isHerbalist(EntityPlayer player) {
		return isHerbalist(player, 0);
	}
	
	// Player predicates for each role, with tiers
	public static boolean isWizard(EntityPlayer player, int tier) {
		ItemStack headEquipment = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		//List<ItemStack> armorList2 = ArrayList<ItemStack>(armorList);
		// Need a data type that I can use to check for the right helmet? some kind of "contains"?
		System.out.println(headEquipment);
		System.out.println(headEquipment.getItem());
		System.out.println(Items.GOLDEN_HELMET);
		if (headEquipment.getItem() == Items.GOLDEN_HELMET) {
			System.out.println("SUCCESS!");
			return true;
		}
		return true;
	}
	
	public static boolean isMiner(EntityPlayer player, int tier) {
		return true;
	}
	
	public static boolean isHunter(EntityPlayer player, int tier) {
		return true;
	}
	
	public static boolean isHerbalist(EntityPlayer player, int tier) {
		return true;
	}
	
}
