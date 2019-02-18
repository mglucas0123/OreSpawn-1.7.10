/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.registry.ClientRegistry
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.gameevent.InputEvent
 *  cpw.mods.fml.common.gameevent.InputEvent$KeyInputEvent
 *  danger.orespawn.KeyHandler
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.settings.KeyBinding
 */
package danger.orespawn;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeyHandler {
    private final Minecraft mc = Minecraft.getMinecraft();
    public static final String KEY_CATEGORY = "key.categories.orespawn";
    public static final KeyBinding KEY_FLY_UP = new KeyBinding("OreSpawn UP/FAST", 56, "key.categories.orespawn");

    public KeyHandler() {
        ClientRegistry.registerKeyBinding((KeyBinding)KEY_FLY_UP);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
    }
}

