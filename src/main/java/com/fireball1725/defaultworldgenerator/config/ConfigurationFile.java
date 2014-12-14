package com.fireball1725.defaultworldgenerator.config;

import com.fireball1725.defaultworldgenerator.helper.ConfigurationHelper;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationFile {
    public static Configuration configuration;

    public static Configuration init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
        return configuration;
    }

    public static void loadConfiguration() {
        ConfigGeneralSettings.generalWorldGenerator = ConfigurationHelper.getString(configuration, "World Generator", "general", "default", "The world generator to select by default", true);
        ConfigGeneralSettings.generalShowDebugWorldGenerators = ConfigurationHelper.getBoolean(configuration, "Show World Generators in Log", "general", false, "Enabling this will display all world generators installed, useful for debug");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
