package com.dominic.alliance.player;

import javax.annotation.Nullable;

import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.items.armor.RoleIdentifierArmor;

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
		ItemStack headEquipment = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		if (headEquipment.getItem() instanceof RoleIdentifierArmor) {
			RoleIdentifierArmor armorType = (RoleIdentifierArmor) headEquipment.getItem();
			return (role == null || (armorType.role == role)) && armorType.tier >= tier;
		}
		return false;
		
//		switch (role) {
//			case WIZARD: return isWizard(player, tier);
//			case MINER: return isMiner(player, tier);
//			case HUNTER: return isHunter(player, tier);
//			case HERBALIST: return isHerbalist(player, tier);
//			default: return isWizard(player, tier) || isMiner(player, tier) || isHunter(player, tier) || isHerbalist(player, tier);
//		}
	}
	
	// Convenience methods for player predicates for each role
	public static boolean isWizard(EntityPlayer player, int tier) {
		return isRole(player, Role.WIZARD, tier);
	}

	public static boolean isMiner(EntityPlayer player, int tier) {
		return isRole(player, Role.MINER, tier);
	}

	public static boolean isHunter(EntityPlayer player, int tier) {
		return isRole(player, Role.HUNTER, tier);
	}

	public static boolean isHerbalist(EntityPlayer player, int tier) {
		return isRole(player, Role.HERBALIST, tier);
	}
	
	// Predicate to check a player's eligibility for a RoleIdentifierArmor
	// I.e. The player has achieved the necessary advancements for a given class & tier
	public static boolean eligibleForIdentifier(EntityPlayer playerIn, Role roleIn, int tierIn) {
		// TODO
		return false;
	}
	
	// Predicate to check a player's eligibility to tier up
	// I.e. The player is the correct class, exactly one tier below nextTierIn, and meets all other requirements
	public static boolean eligibleForTierUp(EntityPlayer playerIn, Role roleIn, int nextTierIn) {
		// TODO
		return false;
	}
	
}
