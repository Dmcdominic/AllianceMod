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
			case WIZARD:	return isWizard(player, tier);
			case MINER:		return isMiner(player, tier);
			case HUNTER:	return isHunter(player, tier);
			case HERBALIST:	return isHerbalist(player, tier);
		}
		return false;
	}
	
	// Player predicates for each role
	private static boolean isWizard(EntityPlayer player, int tier) {
		ItemStack headEquipment = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		if (headEquipment.getItem() == Items.GOLDEN_HELMET) {
			System.out.println("SUCCESS!");
			return true;
		}
		return false;
	}

	private static boolean isMiner(EntityPlayer player, int tier) {
		return true;
	}

	private static boolean isHunter(EntityPlayer player, int tier) {
		return true;
	}

	private static boolean isHerbalist(EntityPlayer player, int tier) {
		return true;
	}
	
	// Convenience methods for each role predicate without tier requirement
	private static boolean isWizard(EntityPlayer player) {
		return isWizard(player, 0);
	}
	private static boolean isMiner(EntityPlayer player) {
		return isMiner(player, 0);
	}
	private static boolean isHunter(EntityPlayer player) {
		return isHunter(player, 0);
	}
	private static boolean isHerbalist(EntityPlayer player) {
		return isHerbalist(player, 0);
	}
	
}
