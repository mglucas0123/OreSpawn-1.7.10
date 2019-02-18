/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyDispenserBehaviorWDCharge
 *  danger.orespawn.WaterBall
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.WaterBall;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

final class MyDispenserBehaviorWDCharge
extends BehaviorProjectileDispense {
    MyDispenserBehaviorWDCharge() {
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        WaterBall entityarrow = new WaterBall(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return entityarrow;
    }
}

