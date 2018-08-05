package com.dominic.alliance.items.armor;

import java.util.HashMap;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.util.ItemUtil;
import com.dominic.alliance.util.events.RoleUpdateEvent;

import akka.japi.Pair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class RoleIdentifierArmor extends ArmorBase {

	public static HashMap<Pair<Role, Integer>, RoleIdentifierArmor> identifierMap = new HashMap<Pair<Role, Integer>, RoleIdentifierArmor>();
	
	public Role role;
	public int tier;

	public RoleIdentifierArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, Role roleIn, int tierIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		role = roleIn;
		tier = tierIn;
		
		identifierMap.put(new Pair(role, tier), this);
	}

	// When a player changes their armor, check if their role has been affected
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();

			ItemStack itemEquipped = event.getTo();
			ItemStack itemRemoved = event.getFrom();
			
			Role oldRole = null;
			int oldTier = 0;
			Role newRole = null;
			int newTier = 0;

			if (itemRemoved.getItem() instanceof RoleIdentifierArmor) {
				RoleIdentifierArmor armorType = ((RoleIdentifierArmor) itemRemoved.getItem());
				oldRole = armorType.role;
				oldTier = armorType.tier;
			}
			if (itemEquipped.getItem() instanceof RoleIdentifierArmor) {
				RoleIdentifierArmor armorType = ((RoleIdentifierArmor) itemEquipped.getItem());
				newRole = armorType.role;
				newTier = armorType.tier;
			}
			if (oldRole != newRole || oldTier != newTier) {
				RoleUpdateEvent RUEvent = new RoleUpdateEvent(player, oldRole, oldTier, newRole, newTier);
				MinecraftForge.EVENT_BUS.post(RUEvent);
			}
		}
	}
	
	// When a player respawns, check to see if they are eligible for a RoleIdentifierArmor, but do not currently have one
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPlayeRespawn(PlayerEvent.PlayerRespawnEvent event) {
		System.out.println("PlayerRespawnEvent received!");
		int maxEligibleTier = 0;
		RoleIdentifierArmor maxTierArmor = null;
		for (RoleIdentifierArmor armor : identifierMap.values()) {
			if (Roles.eligibleForIdentifier(event.player, armor.role, armor.tier) && armor.tier >= maxEligibleTier) {
				maxEligibleTier = armor.tier;
				maxTierArmor = armor;
			}
		}
		
		if (maxTierArmor != null) {
			ItemStack currentStackInSlot = event.player.getItemStackFromSlot(maxTierArmor.getEquipmentSlot());
			boolean alreadyEquipped = (currentStackInSlot == null) ? false : (currentStackInSlot.getItem() == maxTierArmor);
			if (alreadyEquipped ) {
				return;
			}
			boolean alreadyInInventory = event.player.inventory.mainInventory.parallelStream().anyMatch(ItemUtil.isOfItemPredicate(maxTierArmor));
			if (alreadyInInventory) {
				return;
			}
			
			ItemStack identifierItemStack = new ItemStack(maxTierArmor);
			if (currentStackInSlot == null) {
				event.player.setItemStackToSlot(maxTierArmor.getEquipmentSlot(), identifierItemStack);
			} else {
				event.player.addItemStackToInventory(identifierItemStack);
			}
		}
	}
	
	// Get the RoleIdentifierArmor for a certain role and tier
	public static RoleIdentifierArmor getIdentifier(Role roleIn, int tierIn) {
		return identifierMap.get(new Pair(roleIn, tierIn));
	}
	
}
