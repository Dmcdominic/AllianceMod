package com.dominic.alliance.items.armor;

import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.util.events.RoleUpdateEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RoleIdentifierArmor extends ArmorBase {
	
	public Role role;
	public int tier;

	public RoleIdentifierArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, Role roleIn, int tierIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		role = roleIn;
		tier = tierIn;
	}
	
	@SubscribeEvent(priority=EventPriority.HIGH)
	public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			ItemStack itemEquipped = event.getTo();
			ItemStack itemRemoved = event.getFrom();
			
			boolean roleChanged = false;
			Role oldRole = null;
			int oldTier = 0;
			Role newRole = null;
			int newTier = 0;
			
			if (itemRemoved.getItem() instanceof RoleIdentifierArmor) {
				roleChanged = true;
				RoleIdentifierArmor armorType = ((RoleIdentifierArmor) itemRemoved.getItem());
				oldRole = armorType.role;
				oldTier = armorType.tier;
			}
			if (itemEquipped.getItem() instanceof RoleIdentifierArmor) {
				roleChanged = true;
				RoleIdentifierArmor armorType = ((RoleIdentifierArmor) itemEquipped.getItem());
				newRole = armorType.role;
				newTier = armorType.tier;
			}
			if (roleChanged) {
				RoleUpdateEvent RUEvent = new RoleUpdateEvent(player, oldRole, oldTier, newRole, newTier);
				MinecraftForge.EVENT_BUS.post(RUEvent);
			}
		}
	}
}
