/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Acid
 *  danger.orespawn.LaserBall
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.LaserBall;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class Acid
extends LaserBall {
    private int my_index = 85;

    public Acid(World par1World) {
        super(par1World);
        super.setAcid();
    }

    public Acid(World par1World, int par2) {
        super(par1World);
        super.setAcid();
    }

    public Acid(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        super.setAcid();
    }

    public Acid(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
        super.setAcid();
    }

    public Acid(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        super.setAcid();
    }

    public int getAcidIndex() {
        return this.my_index;
    }
}

