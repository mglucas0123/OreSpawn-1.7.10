/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.DeadIrukandji
 *  danger.orespawn.MyDispenserBehaviorDeadIrukandji
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.DeadIrukandji;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

final class MyDispenserBehaviorDeadIrukandji
extends BehaviorProjectileDispense {
    MyDispenserBehaviorDeadIrukandji() {
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        DeadIrukandji entityarrow = new DeadIrukandji(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return entityarrow;
    }
}

