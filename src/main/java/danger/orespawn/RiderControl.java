/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.gameevent.TickEvent
 *  cpw.mods.fml.common.gameevent.TickEvent$ClientTickEvent
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  danger.orespawn.KeyHandler
 *  danger.orespawn.RiderControl
 *  danger.orespawn.RiderControlMessage
 *  net.minecraft.client.settings.KeyBinding
 */
package danger.orespawn;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import danger.orespawn.KeyHandler;
import danger.orespawn.RiderControlMessage;
import net.minecraft.client.settings.KeyBinding;

public class RiderControl {
    private final RiderControlMessage rcm = new RiderControlMessage();
    private final SimpleNetworkWrapper network;
    private int keystate = 0;

    public RiderControl(SimpleNetworkWrapper network) {
        this.network = network;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent evt) {
        int newkeystate = 0;
        if (KeyHandler.KEY_FLY_UP.getIsKeyPressed()) {
            newkeystate = 1;
        }
        if (this.keystate != newkeystate) {
            this.rcm.keystate = newkeystate;
            this.network.sendToServer((IMessage)this.rcm);
            this.keystate = newkeystate;
        }
    }
}

