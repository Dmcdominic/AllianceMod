package com.dominic.alliance.items.armor;

import com.dominic.alliance.Main;
import com.dominic.alliance.init.ModItems;
import com.dominic.alliance.player.Roles;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ArmorBase extends ItemArmor implements IHasModel {

	public Role roleRequired;
	public int tierRequired;
	public boolean lockedToRole;
	
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, Role roleRequiredIn, int tierRequiredIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.tabAllianceMod);
		ModItems.ITEMS.add(this);
		
		roleRequired = roleRequiredIn;
		tierRequired = tierRequiredIn;
		lockedToRole = true;
	}
	
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		this(name, materialIn, renderIndexIn, equipmentSlotIn, null, 0);
		lockedToRole = false;
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
//	@Override
//	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//		if (!lockedToRole || roleRequired == null) {
//			return;
//		}
//		if (!Roles.isRole(player, roleRequired, tierRequired)) {
//			player.setItemStackToSlot(this.getEquipmentSlot(), ItemStack.EMPTY);
//			player.addItemStackToInventory(itemStack);
//			player.sendStatusMessage(new TextComponentString("This armor is only equippable by a tier " + this.tierRequired + " " + this.roleRequired.toString().toLowerCase()), false);
//		}
//	}
	
	@SubscribeEvent(priority=EventPriority.HIGHEST)
	public static void LivingEquipmentChange(LivingEquipmentChangeEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			ItemStack itemEquipped = event.getTo();
			if (itemEquipped.getItem() instanceof ArmorBase) {
				((ArmorBase) itemEquipped.getItem()).onArmorEquipped(player, itemEquipped, event.getSlot());
			}

			ItemStack itemRemoved = event.getFrom();
			if (itemRemoved.getItem() instanceof ArmorBase) {
				((ArmorBase) itemRemoved.getItem()).onArmorRemoved(player, itemRemoved, event.getSlot());
			}
		}
	}
	
	// Returns true if the armor should be equipped normally
	// Retruns false if the armor is unequipped by this method
	public boolean onArmorEquipped(EntityPlayer player, ItemStack armor, EntityEquipmentSlot slot) {
		// If this is locked to a role, but the predicate is not met, remove the armor
		if (lockedToRole && !Roles.isRole(player, roleRequired, tierRequired) && slot == this.getEquipmentSlot()) {
			player.setItemStackToSlot(this.getEquipmentSlot(), ItemStack.EMPTY);
			player.addItemStackToInventory(armor);
			player.sendStatusMessage(new TextComponentString("This armor is only equippable by a tier " + this.tierRequired + " " + this.roleRequired.toString().toLowerCase()), false);
			return false;
		}
		return true;
	}
	
	public void onArmorRemoved(EntityPlayer player, ItemStack armor, EntityEquipmentSlot slot) {
	}
	
}
