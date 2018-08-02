package com.dominic.alliance.init;

import java.util.ArrayList;
import java.util.List;

import com.dominic.alliance.items.*;
import com.dominic.alliance.items.armor.ArmorBase;
import com.dominic.alliance.items.armor.RoleIdentifierArmor;
import com.dominic.alliance.items.tools.*;
import com.dominic.alliance.player.Roles.Role;
import com.dominic.alliance.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	// Creative tab
	public static final CreativeTabs tabAllianceMod = (new CreativeTabs("tabAllianceMod") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PINK_RUBY);
		}
		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
	}).setBackgroundImageName("item_search.png");
	
	// ArrayList for all mod items
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	// ================ ITEMS ================
	
	public static final Item PINK_RUBY = new ItemBase("pink_ruby");
	
	
	
	// ============ CLASS HATS =============
	public static final ArmorMaterial ARMOR_CLASS_IDENTIFIERS = EnumHelper.addArmorMaterial("armor_class_identifiers", Reference.MOD_ID + ":class_identifiers", -1, new int[]{1, 1, 1, 1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	public static final Item WIZARD_HAT_T1 = new RoleIdentifierArmor("wizard_hat_t1", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.WIZARD, 1);
	public static final Item WIZARD_HAT_T2 = new RoleIdentifierArmor("wizard_hat_t2", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.WIZARD, 2);
	public static final Item WIZARD_HAT_T3 = new RoleIdentifierArmor("wizard_hat_t3", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.WIZARD, 3);
	public static final Item WIZARD_HAT_T4 = new RoleIdentifierArmor("wizard_hat_t4", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.WIZARD, 4);
	
	public static final Item MINER_HAT_T1 = new RoleIdentifierArmor("miner_hat_t1", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.MINER, 1);
	public static final Item MINER_HAT_T2 = new RoleIdentifierArmor("miner_hat_t2", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.MINER, 2);
	public static final Item MINER_HAT_T3 = new RoleIdentifierArmor("miner_hat_t3", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.MINER, 3);
	public static final Item MINER_HAT_T4 = new RoleIdentifierArmor("miner_hat_t4", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.MINER, 4);
	
	public static final Item HUNTER_HAT_T1 = new RoleIdentifierArmor("hunter_hat_t1", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HUNTER, 1);
	public static final Item HUNTER_HAT_T2 = new RoleIdentifierArmor("hunter_hat_t2", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HUNTER, 2);
	public static final Item HUNTER_HAT_T3 = new RoleIdentifierArmor("hunter_hat_t3", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HUNTER, 3);
	public static final Item HUNTER_HAT_T4 = new RoleIdentifierArmor("hunter_hat_t4", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HUNTER, 4);
	
	public static final Item HERBALIST_HAT_T1 = new RoleIdentifierArmor("herablist_hat_t1", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HERBALIST, 1);
	public static final Item HERBALIST_HAT_T2 = new RoleIdentifierArmor("herablist_hat_t2", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HERBALIST, 2);
	public static final Item HERBALIST_HAT_T3 = new RoleIdentifierArmor("herablist_hat_t3", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HERBALIST, 3);
	public static final Item HERBALIST_HAT_T4 = new RoleIdentifierArmor("herablist_hat_t4", ARMOR_CLASS_IDENTIFIERS, 1, EntityEquipmentSlot.HEAD, Role.HERBALIST, 4);
	
	
	
	// ============ CLASS ITEMS ============
	// Wizard
	public static final Item DUST_ASHEN = new ItemBase("dust_ashen");
	
	
	// Miner
	public static final Item INGOT_OSMIUM = new ItemBase("ingot_osmium");
	
	
	// Hunter
	public static final Item FLESH_TAME = new ItemBase("flesh_tame");
	
	// Mountaineer
	
	
	// ============ TOOLS & ARMOR ============
	// Materials
	public static final ToolMaterial TOOL_OSMIUM = EnumHelper.addToolMaterial("tool_osmium", 2, 200, 5.5f, 1.75f, 6);
	public static final ArmorMaterial ARMOR_OSMIUM = EnumHelper.addArmorMaterial("armor_osmium", Reference.MOD_ID + ":osmium", 17, new int[]{2, 5, 7, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	// Tools
	public static final Item AXE_OSMIUM = new ToolAxe("axe_osmium", TOOL_OSMIUM, 8.0f, -3.0f);
	public static final Item HOE_OSMIUM = new ToolHoe("hoe_osmium", TOOL_OSMIUM);
	public static final Item PICKAXE_OSMIUM = new ToolPickaxe("pickaxe_osmium", TOOL_OSMIUM);
	public static final Item SHOVEL_OSMIUM = new ToolShovel("shovel_osmium", TOOL_OSMIUM);
	public static final Item SWORD_OSMIUM = new ToolSword("sword_osmium", TOOL_OSMIUM);
	
	// Armor
	public static final Item HELMET_OSMIUM = new ArmorBase("helmet_osmium", ARMOR_OSMIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_OSMIUM = new ArmorBase("chestplate_osmium", ARMOR_OSMIUM, 1, EntityEquipmentSlot.CHEST, Role.WIZARD, 0);
	public static final Item LEGGINGS_OSMIUM = new ArmorBase("leggings_osmium", ARMOR_OSMIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_OSMIUM = new ArmorBase("boots_osmium", ARMOR_OSMIUM, 1, EntityEquipmentSlot.FEET);
}
