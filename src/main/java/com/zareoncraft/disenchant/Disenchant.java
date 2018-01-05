package com.zareoncraft.disenchant;

import com.zareoncraft.disenchant.commands.DisenchantCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Disenchant extends JavaPlugin {
	private static PluginConfig pluginConfig;

	@Override
	public void onEnable() {
		pluginConfig = new PluginConfig(this);

		//Commands
		getCommand("disenchant").setExecutor(new DisenchantCommand());
	}

	@Override
	public void onDisable() {

	}

	static PluginConfig getPluginConfig() {
		return pluginConfig;
	}
}
