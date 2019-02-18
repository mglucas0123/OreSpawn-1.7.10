/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.IrukandjiArrow
 *  danger.orespawn.MyDispenserBehaviorArrow
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.IrukandjiArrow;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

final class MyDispenserBehaviorArrow
extends BehaviorProjectileDispense {
    MyDispenserBehaviorArrow() {
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        IrukandjiArrow entityarrow = new IrukandjiArrow(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        entityarrow.canBePickedUp = 1;
        return entityarrow;
    }
}

