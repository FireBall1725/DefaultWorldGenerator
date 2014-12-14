package com.fireball1725.defaultworldgenerator.events;

import com.fireball1725.defaultworldgenerator.gui.GuiCreateCustomWorld;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraftforge.client.event.GuiScreenEvent;

public class GuiEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onButtonClickPre(GuiScreenEvent.ActionPerformedEvent.Pre event) {
        if (event.gui instanceof GuiSelectWorld) {
            if (event.button.id == 3) {
                GuiCreateCustomWorld guiCreateWorld = new GuiCreateCustomWorld(Minecraft.getMinecraft().currentScreen);
                event.gui.mc.displayGuiScreen(guiCreateWorld);
                event.setCanceled(true);
            }
        }
    }
}
