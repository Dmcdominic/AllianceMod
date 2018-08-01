package com.dominic.alliance.util.events;

import javax.annotation.Nullable;

import com.dominic.alliance.player.Roles.Role;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class RoleUpdateEvent extends PlayerEvent {

	private final Role oldRole;
	private final int oldTier;
	
	private final Role newRole;
	private final int newTier;
	
	public RoleUpdateEvent(EntityPlayer player, @Nullable Role oldRoleIn, int oldTierIn, @Nullable Role newRoleIn, int newTierIn) {
		super(player);
		oldRole = oldRoleIn;
		oldTier = oldTierIn;
		newRole = newRoleIn;
		newTier = newTierIn;
	}
	
	public Role getOldRole() { return oldRole; };
	public int getOldTier() { return oldTier; };
	public Role getNewRole() { return newRole; };
	public int getNewTier() { return newTier; };
	
	public boolean roleChanged() { return oldRole != newRole; };
	public boolean tierChanged() { return oldTier != newTier; };
	
}
