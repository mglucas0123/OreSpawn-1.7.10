/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Dragon
 *  danger.orespawn.GiantRobot
 *  danger.orespawn.LaserBall
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Robot2
 *  danger.orespawn.Robot3
 *  danger.orespawn.Robot4
 *  danger.orespawn.Robot5
 *  danger.orespawn.SpitBug
 *  danger.orespawn.TrooperBug
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Dragon;
import danger.orespawn.GiantRobot;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Robot2;
import danger.orespawn.Robot3;
import danger.orespawn.Robot4;
import danger.orespawn.Robot5;
import danger.orespawn.SpitBug;
import danger.orespawn.TrooperBug;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class LaserBall
extends EntityThrowable {
    private float my_rotation = 0.0f;
    private int my_index = 81;
    private int is_special = 0;
    private int is_iceball = 0;
    private int is_acid = 0;
    private int is_irukandji = 0;
    private int ticksalive = 0;

    public LaserBall(World par1World) {
        super(par1World);
    }

    public LaserBall(World par1World, int par2) {
        super(par1World);
    }

    public LaserBall(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    public LaserBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public LaserBall(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public int getLaserBallIndex() {
        return this.my_index;
    }

    public void setSpecial() {
        this.is_special = 1;
    }

    public void setIceBall() {
        this.is_iceball = 1;
    }

    public void setAcid() {
        this.is_acid = 1;
    }

    public void setIrukandji() {
        this.is_irukandji = 1;
        this.is_acid = 1;
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
      if (par1MovingObjectPosition.entityHit != null)
      {
        float var2 = 16.0F;

        if (this.is_irukandji != 0) {
          par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 100.0F);
          setDead();
          return;
        }

        if (this.is_acid != 0) {
          if ((par1MovingObjectPosition.entityHit instanceof TrooperBug))
          {
            setDead();
            return;
          }
          if ((par1MovingObjectPosition.entityHit instanceof SpitBug))
          {
            setDead();
            return;
          }
        }
        if ((this.is_iceball == 0) && (this.is_acid == 0)) {
          if ((par1MovingObjectPosition.entityHit instanceof Robot2))
          {
            setDead();
            return;
          }
          if ((par1MovingObjectPosition.entityHit instanceof Robot3))
          {
            setDead();
            return;
          }
          if ((par1MovingObjectPosition.entityHit instanceof Robot4))
          {
            setDead();
            return;
          }
          if ((par1MovingObjectPosition.entityHit instanceof Robot5))
          {
            setDead();
            return;
          }
          if ((par1MovingObjectPosition.entityHit instanceof GiantRobot))
          {
            setDead();
            return;
          }
        }
        if (((par1MovingObjectPosition.entityHit instanceof Dragon)) && (this.is_acid == 0))
        {
          Dragon d = (Dragon)par1MovingObjectPosition.entityHit;
          if (d.riddenByEntity != null) {
            setDead();
            return;
          }

          if ((d.getDragonType() != 0) && (this.is_iceball != 0)) {
            setDead();
            return;
          }
        }

        if (((par1MovingObjectPosition.entityHit instanceof EntityPlayer)) && (this.is_acid == 0))
        {
          EntityPlayer d = (EntityPlayer)par1MovingObjectPosition.entityHit;
          if (d.ridingEntity != null) {
            setDead();
            return;
          }
        }

        par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), var2);
        if (this.is_iceball == 0) par1MovingObjectPosition.entityHit.setFire(1);

      }
      else if ((this.is_irukandji != 0) && 
        (!this.worldObj.isRemote)) {
        dropItem(OreSpawnMain.MyIrukandji, 1);
      }

      if (this.is_acid == 0) {
        int mx = 10;
        if (this.is_special != 0) mx = 20;
        for (int var3 = 0; var3 < mx; var3++)
        {
          this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
          this.worldObj.spawnParticle("largesmoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
          this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
        }

        playSound("random.explode", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
        if ((!this.worldObj.isRemote) && ((this.is_special != 0) || (this.is_iceball != 0))) {
          this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        }
      }
      setDead();
    }

    public void onUpdate() {
        ++this.ticksalive;
        if (this.ticksalive > 200) {
            this.setDead();
            return;
        }
        super.onUpdate();
        this.my_rotation += 50.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch = this.my_rotation;
        if (this.is_acid != 0) {
            return;
        }
        int mx = 4;
        if (this.is_special != 0) {
            mx = 10;
        }
        if (this.is_iceball != 0 && this.is_special == 0) {
            mx = 2;
        }
        for (int i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 2.0, this.worldObj.rand.nextGaussian() / 2.0, this.worldObj.rand.nextGaussian() / 2.0);
            if (this.is_iceball != 0) continue;
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0);
        }
    }
}

