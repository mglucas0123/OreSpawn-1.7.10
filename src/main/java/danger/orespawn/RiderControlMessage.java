/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  danger.orespawn.RiderControlMessage
 *  io.netty.buffer.ByteBuf
 */
package danger.orespawn;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class RiderControlMessage
implements IMessage {
    public int keystate = 0;
    private int previous;

    public void fromBytes(ByteBuf buf) {
        this.fromInteger((int)buf.readUnsignedByte());
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.toInteger());
    }

    public void fromInteger(int value) {
        this.keystate = value;
    }

    public int toInteger() {
        return this.keystate;
    }

    public boolean hasChanged() {
        int current = this.keystate;
        boolean changed = this.previous != current;
        this.previous = current;
        return changed;
    }
}

