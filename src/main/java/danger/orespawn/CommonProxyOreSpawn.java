/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  cpw.mods.fml.relauncher.Side
 *  danger.orespawn.CommonProxyOreSpawn
 *  danger.orespawn.RiderControlMessage
 *  danger.orespawn.RiderControlMessageHandler
 */
package danger.orespawn;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import danger.orespawn.RiderControlMessage;
import danger.orespawn.RiderControlMessageHandler;

public class CommonProxyOreSpawn {
    private SimpleNetworkWrapper network;

    public SimpleNetworkWrapper getNetwork() {
        return this.network;
    }

    public void registerRenderThings() {
    }

    public void registerSoundThings() {
    }

    public void registerKeyboardInput() {
    }

    public void registerNetworkStuff() {
        this.network = NetworkRegistry.INSTANCE.newSimpleChannel("RiderControls");
        this.network.registerMessage(RiderControlMessageHandler.class, RiderControlMessage.class, 0, Side.SERVER);
    }

    public int setArmorPrefix(String string) {
        return 0;
    }
}

