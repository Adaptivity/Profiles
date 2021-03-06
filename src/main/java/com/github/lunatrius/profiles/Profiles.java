package com.github.lunatrius.profiles;

import com.github.lunatrius.core.version.VersionChecker;
import com.github.lunatrius.profiles.command.ProfileCommand;
import com.github.lunatrius.profiles.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.ClientCommandHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME)
public class Profiles {
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		VersionChecker.registerMod(event.getModMetadata());

		Reference.logger = event.getModLog();

		Reference.config = event.getSuggestedConfigurationFile();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new ProfileCommand());
	}
}
