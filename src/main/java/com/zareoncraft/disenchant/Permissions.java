package com.zareoncraft.disenchant;

import org.bukkit.command.CommandSender;

public enum Permissions {

	DISENCHANT("Disenchant.disenchant");

	private final String permission;

	Permissions(String permission) {
		this.permission = permission;
	}

	public static boolean has(CommandSender sender, Permissions permission) {
		return has(sender, permission.permission);
	}

	public static boolean has(CommandSender sender, String node) {
		return sender.hasPermission(node) || sender.hasPermission(node.toLowerCase());
	}
}