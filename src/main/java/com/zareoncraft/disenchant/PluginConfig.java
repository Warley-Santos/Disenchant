package com.zareoncraft.disenchant;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class PluginConfig {
	private final int base, multiplicador;
	private static JavaPlugin PLUGIN;

	PluginConfig(JavaPlugin plugin) {
		PLUGIN = plugin;
		readConfig();

		base = PLUGIN.getConfig().getInt("base");
		multiplicador = PLUGIN.getConfig().getInt("multiplicador");
	}

	private void readConfig() {
		try {
			if (!PLUGIN.getDataFolder().exists()) {
				PLUGIN.getDataFolder().mkdirs();
			}

			File file = new File(PLUGIN.getDataFolder(), "config.yml");

			if (!file.exists()) {
				PLUGIN.saveDefaultConfig();
			} else {
				PLUGIN.reloadConfig();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	int getBase() {
		return base;
	}

	int getMultiplicador() {
		return multiplicador;
	}

	public static JavaPlugin getPLUGIN() {
		return PLUGIN;
	}
}
