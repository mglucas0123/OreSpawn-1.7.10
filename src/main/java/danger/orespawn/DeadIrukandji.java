/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.DeadIrukandji
 *  danger.orespawn.LaserBall
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.LaserBall;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class DeadIrukandji
extends LaserBall {
    private int my_index = 86;

    public DeadIrukandji(World par1World) {
        super(par1World);
        super.setIrukandji();
    }

    public DeadIrukandji(World par1World, int par2) {
        super(par1World);
        super.setIrukandji();
    }

    public DeadIrukandji(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        super.setIrukandji();
    }

    public DeadIrukandji(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
        super.setIrukandji();
    }

    public DeadIrukandji(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        super.setIrukandji();
    }

    public int getIrukandjiIndex() {
        return this.my_index;
    }
}

