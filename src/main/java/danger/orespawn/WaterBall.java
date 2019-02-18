package danger.orespawn;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WaterBall extends EntityThrowable
{
  private float my_rotation = 0.0F;
  private int my_index = 49;

  public WaterBall(World par1World)
  {
    super(par1World);
  }

  public WaterBall(World par1World, EntityLivingBase par2EntityLiving)
  {
    super(par1World, par2EntityLiving);
  }

  public WaterBall(World worldObj, double d, double e, double f)
  {
    super(worldObj, d, e, f);
  }

  public int getWaterBallIndex()
  {
    return this.my_index;
  }

  protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
  {
    if (par1MovingObjectPosition.entityHit != null)
    {
      float var2 = 2.0F;

      if ((par1MovingObjectPosition.entityHit instanceof EntityCreeper))
      {
        var2 = 5.0F;
      }
      if ((par1MovingObjectPosition.entityHit instanceof WaterDragon))
      {
        return;
      }
      if ((par1MovingObjectPosition.entityHit instanceof AttackSquid))
      {
        return;
      }
      if ((par1MovingObjectPosition.entityHit instanceof Dragon))
      {
        Dragon d = (Dragon)par1MovingObjectPosition.entityHit;
        if (d.getDragonType() != 0) {
          return;
        }
      }
      if ((par1MovingObjectPosition.entityHit instanceof EntityPlayer))
      {
        EntityPlayer d = (EntityPlayer)par1MovingObjectPosition.entityHit;
        if (d.ridingEntity != null) {
          return;
        }
      }
      par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), var2);
      if (this.worldObj.rand.nextInt(10) == 1) par1MovingObjectPosition.entityHit.dropItem(OreSpawnMain.MyWaterBall, 1);
      par1MovingObjectPosition.entityHit.extinguish();
    }

    for (int var3 = 0; var3 < 8; var3++)
    {
      this.worldObj.spawnParticle("bubble", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
      this.worldObj.spawnParticle("splash", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
    }
    playSound("random.splash", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);

    if (!this.worldObj.isRemote)
    {
      setDead();
    }
  }

  public void onUpdate()
  {
    super.onUpdate();
    this.my_rotation += 30.0F;

    while (this.my_rotation > 360.0F) {
      this.my_rotation -= 360.0F;
    }

    this.rotationPitch = (this.prevRotationPitch = this.my_rotation);

    this.worldObj.spawnParticle("splash", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
  }
}