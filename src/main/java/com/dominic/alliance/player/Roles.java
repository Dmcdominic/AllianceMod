package com.dominic.alliance.player;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class Roles {
	
	public static enum Role {WIZARD, MINER, HUNTER, HERBALIST}
	
	// Open ended predicates for any role
	public static boolean isRole(EntityPlayer player, Role role) {
		return isRole(player, role, 0);
	}
	
	public static boolean isRole(EntityPlayer player, @Nullable Role role, int tier) {
		switch (role) {
			case WIZARD: return isWizard(player, tier);
			case MINER: return isMiner(player, tier);
			case HUNTER: return isHunter(player, tier);
			case HERBALIST: return isHerbalist(player, tier);
			default: return isWizard(player, tier) || isMiner(player, tier) || isHunter(player, tier) || isHerbalist(player, tier);
		}
	}
	
	// Player predicates for each role
	public static boolean isWizard(EntityPlayer player, int tier) {
		ItemStack headEquipment = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		if (headEquipment.getItem() == Items.GOLDEN_HELMET) {
			System.out.println("SUCCESS!");
			return true;
		}
		return false;
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
	
	// Predicate to check a player's eligibility for a RoleIdentifierArmor
	public static boolean eligibleForIdentifier(EntityPlayer playerIn, Role roleIn, int tierIn) {
		// TODO
		return false;
	}
	
	// Predicate to check a player's eligibility to tier up
	public static boolean eligibleForTierUp(EntityPlayer playerIn, Role roleIn, int nextTierIn) {
		// TODO
		return false;
	}
	
}
