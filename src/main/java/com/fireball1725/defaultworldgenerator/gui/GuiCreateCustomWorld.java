package com.fireball1725.defaultworldgenerator.gui;

import com.fireball1725.defaultworldgenerator.config.ConfigGeneralSettings;
import com.fireball1725.defaultworldgenerator.lib.Log;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.WorldType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GuiCreateCustomWorld extends GuiCreateWorld {
    public GuiCreateCustomWorld(GuiScreen screen) {
        super(screen);
    }

    @Override
    public void initGui() {
        super.initGui();

        try {
            Field field_146331_K = GuiCreateWorld.class.getDeclaredField("field_146331_K");
            field_146331_K.setAccessible(true);

            Method func_146319_h = GuiCreateWorld.class.getDeclaredMethod("func_146319_h");
            func_146319_h.setAccessible(true);

            int WorldGenerator = 0;

            for (int i = 0; i < WorldType.worldTypes.length; i++) {
                if (WorldType.worldTypes[i] != null && WorldType.worldTypes[i].getCanBeCreated()) {
                    if (WorldType.worldTypes[i].getWorldTypeName().equalsIgnoreCase(ConfigGeneralSettings.generalWorldGenerator)) {
                        WorldGenerator = WorldType.worldTypes[i].getWorldTypeID();
                        Log.info("Changed world type to " + WorldType.worldTypes[i].getTranslateName());
                    }
                }
            }


            field_146331_K.setInt(this, WorldGenerator);

            Field field_146344_y = GuiCreateWorld.class.getDeclaredField("field_146344_y");
            field_146344_y.setAccessible(true);

            this.field_146334_a = "";

            func_146319_h.invoke(this);

        } catch (Exception ex) {
            Log.fatal("Fatal Error:");
            Log.fatal(ex);
        }

    }
}
