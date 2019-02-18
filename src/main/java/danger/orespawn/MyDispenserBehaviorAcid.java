/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Acid
 *  danger.orespawn.MyDispenserBehaviorAcid
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Acid;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

final class MyDispenserBehaviorAcid
extends BehaviorProjectileDispense {
    MyDispenserBehaviorAcid() {
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        Acid entityarrow = new Acid(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return entityarrow;
    }
}

