package com.dominic.alliance.util;

import java.util.function.Predicate;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemUtil {
	
	// HOF - Returns a predicate which returns true iff the itemStack is of the given item
	public static Predicate<ItemStack> isOfItemPredicate(Item item) {
		return (ItemStack i) -> i.getItem() == item;
	}
	
	// Returns stack.getTagCompound() if it has one
	// Creates, sets, and returns a new NBT tag compound if it doesn't
	public static NBTTagCompound getTagCompoundSafe(ItemStack stack) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			return nbt;
		}
		NBTTagCompound nbt = stack.getTagCompound();
		return nbt;
	}
}
