/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyEntityAITarget
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.pathfinding.PathEntity
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.pathfinding.PathPoint
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.Mothra;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public abstract class MyEntityAITarget
extends EntityAIBase {
    protected EntityLiving taskOwner;
    protected float targetDistance;
    protected boolean shouldCheckSight;
    private boolean nearbyOnly;
    private int targetSearchStatus = 0;
    private int targetSearchDelay = 0;
    private int field_75298_g = 0;

    public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3) {
        this(par1EntityLiving, par2, par3, false);
    }

    public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3, boolean par4) {
        this.taskOwner = par1EntityLiving;
        this.targetDistance = par2;
        this.shouldCheckSight = par3;
        this.nearbyOnly = par4;
    }

    public boolean continueExecuting() {
        EntityLivingBase var1 = this.taskOwner.getAttackTarget();
        if (var1 == null) {
            return false;
        }
        if (!var1.isEntityAlive()) {
            this.taskOwner.setAttackTarget(null);
            return false;
        }
        if (this.taskOwner.getDistanceSqToEntity((Entity)var1) > (double)(this.targetDistance * this.targetDistance)) {
            return false;
        }
        if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed() && var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed()) {
            return false;
        }
        if (this.shouldCheckSight) {
            if (this.taskOwner.getEntitySenses().canSee((Entity)var1)) {
                this.field_75298_g = 0;
            } else if (++this.field_75298_g > 60) {
                return false;
            }
        }
        return true;
    }

    public void startExecuting() {
        this.targetSearchStatus = 0;
        this.targetSearchDelay = 0;
        this.field_75298_g = 0;
    }

    public void resetTask() {
        this.taskOwner.setAttackTarget((EntityLivingBase)null);
    }

    protected boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this.taskOwner) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed()) {
            if (par1EntityLiving instanceof EntityTameable && ((EntityTameable)par1EntityLiving).isTamed()) {
                return false;
            }
            if (par1EntityLiving == ((EntityTameable)this.taskOwner).getOwner()) {
                return false;
            }
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            if (OreSpawnMain.valentines_day != 0) {
                return true;
            }
            return false;
        }
        if (par1EntityLiving instanceof EntityPigZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (this.shouldCheckSight && !this.taskOwner.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return true;
        }
        if (par1EntityLiving instanceof EntityGhast) {
            return true;
        }
        if (this.nearbyOnly) {
            if (--this.targetSearchDelay <= 0) {
                this.targetSearchStatus = 0;
            }
            if (this.targetSearchStatus == 0) {
                int n = this.targetSearchStatus = this.canEasilyReach(par1EntityLiving) ? 1 : 2;
            }
            if (this.targetSearchStatus == 2) {
                return false;
            }
        }
        return true;
    }

    private boolean canEasilyReach(EntityLivingBase par1EntityLiving) {
        int var5;
        this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
        PathEntity var2 = this.taskOwner.getNavigator().getPathToEntityLiving((Entity)par1EntityLiving);
        if (var2 == null) {
            return false;
        }
        PathPoint var3 = var2.getFinalPathPoint();
        if (var3 == null) {
            return false;
        }
        int var4 = var3.xCoord - MathHelper.floor_double((double)par1EntityLiving.posX);
        return (double)(var4 * var4 + (var5 = var3.zCoord - MathHelper.floor_double((double)par1EntityLiving.posZ)) * var5) <= 2.25;
    }
}

