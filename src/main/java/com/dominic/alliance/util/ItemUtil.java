package com.dominic.alliance.util;

import java.util.function.Predicate;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemUtil {
	// HOF - Returns a predicate which returns true iff the itemStack is of the given item
	public static Predicate<ItemStack> isOfItemPredicate(Item item) {
		return (ItemStack i) -> i.getItem() == item;
	}
}
