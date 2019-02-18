/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Cockateil
 *  danger.orespawn.RubyBird
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Cockateil;
import net.minecraft.world.World;

public class RubyBird
extends Cockateil {
    public RubyBird(World par1World) {
        super(par1World);
    }

    protected void entityInit() {
        super.entityInit();
        this.birdtype = 5;
        this.setBirdType(this.birdtype);
        this.setFlyUp();
    }

    protected String getLivingSound() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
            return "orespawn:rubybird";
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        return true;
    }
}

