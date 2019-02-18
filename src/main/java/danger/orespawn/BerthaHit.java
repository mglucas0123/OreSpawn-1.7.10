/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.BerthaHit
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WeaponStats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.WeaponStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class BerthaHit
extends EntityThrowable {
    private int hit_type = 0;

    public BerthaHit(World par1World) {
        super(par1World);
    }

    public BerthaHit(World par1World, int par2) {
        super(par1World);
    }

    public BerthaHit(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.setSize(0.33f, 0.33f);
        this.setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight(), par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch);
        this.posX -= (double)(MathHelper.cos((float)(this.rotationYaw / 180.0f * 3.1415927f)) * 0.16f);
        this.posY -= 0.1;
        this.posZ -= (double)(MathHelper.sin((float)(this.rotationYaw / 180.0f * 3.1415927f)) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        float f = 0.4f;
        this.motionX = (- MathHelper.sin((float)(this.rotationYaw / 180.0f * 3.1415927f))) * MathHelper.cos((float)(this.rotationPitch / 180.0f * 3.1415927f)) * f;
        this.motionZ = MathHelper.cos((float)(this.rotationYaw / 180.0f * 3.1415927f)) * MathHelper.cos((float)(this.rotationPitch / 180.0f * 3.1415927f)) * f;
        this.motionY = (- MathHelper.sin((float)((this.rotationPitch + this.func_70183_g()) / 180.0f * 3.1415927f))) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 0.1f);
    }

    public BerthaHit(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public BerthaHit(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setHitType(int i) {
        this.hit_type = i;
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (this.isDead) {
            return;
        }
        if (par1MovingObjectPosition.entityHit != null && this.getThrower() != null) {
            double inair;
            EntityTameable t;
            float f3;
            Entity e = par1MovingObjectPosition.entityHit;
            if (OreSpawnMain.big_bertha_pvp == 0 && e instanceof EntityPlayer || e instanceof Girlfriend || e instanceof Boyfriend) {
                this.setDead();
                return;
            }
            if (OreSpawnMain.big_bertha_pvp == 0 && e instanceof EntityTameable && (t = (EntityTameable)e).isTamed()) {
                this.setDead();
                return;
            }
            if (this.hit_type == 0 && this.getDistanceSqToEntity((Entity)this.getThrower()) < 81.0 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)((EntityPlayer)this.getThrower())), (float)OreSpawnMain.bertha_stats.damage);
                e.setFire(10);
                double ks = 2.25;
                inair = 0.35;
                f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 2 && this.getDistanceSqToEntity((Entity)this.getThrower()) < 101.0 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)((EntityPlayer)this.getThrower())), (float)OreSpawnMain.royal_stats.damage);
                double ks = 1.5;
                inair = 0.25;
                f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 3 && this.getDistanceSqToEntity((Entity)this.getThrower()) < 64.0 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)((EntityPlayer)this.getThrower())), (float)OreSpawnMain.hammy_stats.damage);
                double ks = 1.25;
                inair = 0.65;
                f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (!this.worldObj.isRemote && this.hit_type == 3 && this.getDistanceSqToEntity((Entity)this.getThrower()) < 64.0) {
                    this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.5f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                }
            }
        } else if (!this.worldObj.isRemote && this.hit_type == 3 && this.getDistanceSqToEntity((Entity)this.getThrower()) < 64.0) {
            this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 2.1f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        }
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
    }
}

