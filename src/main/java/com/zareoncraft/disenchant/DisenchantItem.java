package com.zareoncraft.disenchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class DisenchantItem {

	public void removeAllEnchants(Player player) {
		int xpCost;
		ItemMeta itemMeta;
		ItemStack itemStack;
		Map<Enchantment, Integer> enchants;

		itemStack = player.getInventory().getItemInMainHand();

		if (itemStack.getType() != Material.AIR) {
			itemMeta = itemStack.getItemMeta();
			enchants = itemMeta.getEnchants();
			if (enchants.size() >= 1) {
				xpCost = calcXpCost(enchants, itemMeta);
//				player.sendMessage("Valor de XP " + xpCost);
				if (player.getLevel() >= xpCost) {
					for (Enchantment ench : enchants.keySet()) {
//						player.sendMessage(ChatColor.AQUA + "removido " + ench.getName() + " Level " + itemMeta.getEnchantLevel(ench));
						itemStack.removeEnchantment(ench);
					}
					debitaXp(player, xpCost);
					player.sendMessage(ChatColor.GREEN + "Removido " + enchants.size() + " encantamento(s).");
				} else {
					player.sendMessage(ChatColor.GREEN + "Você não possui xp sufuciente. É necessário " + xpCost + " niveis.");
				}
			} else {
				player.sendMessage(ChatColor.GREEN + "Este item não possui encantamentos.");
			}
		} else {
			player.sendMessage(ChatColor.GREEN + "Selecione um item para remover o encantamento.");
		}
	}

	private int calcXpCost(Map<Enchantment, Integer> enchants, ItemMeta itemMeta) {
		int value = 0;
		int multiplier = Disenchant.getPluginConfig().getMultiplicador();
		int base = Disenchant.getPluginConfig().getBase();

		for (Enchantment ench : enchants.keySet()) {
			value += base + (itemMeta.getEnchantLevel(ench) * multiplier);
		}

		return value;
	}

	private void debitaXp(Player player, int value) {
		player.setLevel(player.getLevel() - value);
	}
}