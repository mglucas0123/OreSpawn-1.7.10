/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyUtils
 *  danger.orespawn.ThunderBolt
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.MyUtils;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class ThunderBolt
extends EntityThrowable {
    public ThunderBolt(World par1World) {
        super(par1World);
    }

    public ThunderBolt(World par1World, EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public ThunderBolt(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public ThunderBolt(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            float var2 = 40.0f;
            if (MyUtils.isRoyalty((Entity)par1MovingObjectPosition.entityHit)) {
                this.setDead();
                return;
            }
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), var2 / 2.0f);
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.getThrower()), var2 / 2.0f);
            par1MovingObjectPosition.entityHit.setFire(1);
        }
        int mx = 20;
        for (int var3 = 0; var3 < mx; ++var3) {
            this.worldObj.spawnParticle("smoke", this.posX + (double)this.rand.nextFloat() - (double)this.rand.nextFloat(), this.posY + (double)this.rand.nextFloat() - (double)this.rand.nextFloat(), this.posZ + (double)this.rand.nextFloat(), 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("largesmoke", this.posX + (double)this.rand.nextFloat() - (double)this.rand.nextFloat(), this.posY + (double)this.rand.nextFloat() - (double)this.rand.nextFloat(), this.posZ + (double)this.rand.nextFloat() - (double)this.rand.nextFloat(), 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
        }
        this.playSound("random.explode", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        }
        this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY + 1.0, this.posZ));
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        int mx = 4;
        for (int i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0);
        }
    }
}

