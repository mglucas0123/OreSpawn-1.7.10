/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyDispenserBehaviorSunspotUrchin
 *  danger.orespawn.SunspotUrchin
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.SunspotUrchin;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

final class MyDispenserBehaviorSunspotUrchin
extends BehaviorProjectileDispense {
    MyDispenserBehaviorSunspotUrchin() {
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        SunspotUrchin entityarrow = new SunspotUrchin(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return entityarrow;
    }
}

