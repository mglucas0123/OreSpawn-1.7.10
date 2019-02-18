/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.MyEntityAIJealousy
 *  danger.orespawn.MyEntityAINearestAttackableTarget
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.passive.EntityTameable
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import danger.orespawn.Girlfriend;
import danger.orespawn.MyEntityAINearestAttackableTarget;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;

public class MyEntityAIJealousy
extends MyEntityAINearestAttackableTarget {
    private EntityTameable theTameable;

    public MyEntityAIJealousy(EntityTameable par1EntityTameable, Class par2Class, float par3, int par4, boolean par5) {
        super((EntityLiving)par1EntityTameable, par2Class, par3, par4, par5);
        this.theTameable = par1EntityTameable;
    }

    public boolean shouldExecute() {
        EntityTameable te = (EntityTameable)this.taskOwner;
        Girlfriend gf = null;
        Boyfriend bf = null;
        EntityLivingBase ep = null;
        if (te == null) {
            return false;
        }
        if (!te.isTamed()) {
            return false;
        }
        if (te.isSitting()) {
            return false;
        }
        if (!super.shouldExecute()) {
            return false;
        }
        EntityLiving victim = this.targetEntity;
        if (victim == null) {
            return false;
        }
        if (te instanceof Girlfriend ? victim instanceof Girlfriend && (gf = (Girlfriend)victim).isTamed() : victim instanceof Boyfriend && (bf = (Boyfriend)victim).isTamed()) {
            return false;
        }
        ep = te.getOwner();
        if (ep == null) {
            return false;
        }
        return true;
    }
}

