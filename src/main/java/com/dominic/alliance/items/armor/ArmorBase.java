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
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (!lockedToRole || roleRequired == null) {
			return;
		}
		if (!Roles.isRole(player, roleRequired, tierRequired)) {
			player.setItemStackToSlot(this.getEquipmentSlot(), ItemStack.EMPTY);
			player.addItemStackToInventory(itemStack);
			player.sendStatusMessage(new TextComponentString("This armor is only equippable by a tier " + this.tierRequired + " " + this.roleRequired.toString().toLowerCase()), false);
		}
	}
	
}
