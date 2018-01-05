package com.zareoncraft.disenchant.commands;

import com.zareoncraft.disenchant.DisenchantItem;
import com.zareoncraft.disenchant.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisenchantCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			if (Permissions.has((Player)sender, Permissions.DISENCHANT)) {
				DisenchantItem disenchantItem = new DisenchantItem();
				disenchantItem.removeAllEnchants((Player) sender);
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Você não possui acesso a este comando.");
			}
		} else {
			Bukkit.getConsoleSender().sendMessage("Esse comando não está disponível para uso no console");
		}
		return true;
	}
}
