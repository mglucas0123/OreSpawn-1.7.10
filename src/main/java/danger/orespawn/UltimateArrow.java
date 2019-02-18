package danger.orespawn;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class UltimateArrow extends EntityArrow
{
  private int xTile = -1;
  private int yTile = -1;
  private int zTile = -1;
  private Block inTile = Blocks.air;
  private int inData = 0;
  private boolean inGround = false;
  private int ticksInGround;
  private int ticksInAir = 0;
  private int knockbackStrength;

  public UltimateArrow(World par1World)
  {
    super(par1World);
  }

  public UltimateArrow(World par1World, double par2, double par4, double par6)
  {
    super(par1World, par2, par4, par6);
  }

  public UltimateArrow(World par1World, EntityLiving par2EntityLiving, EntityLivingBase par3EntityLiving, float par4, float par5)
  {
    super(par1World, par2EntityLiving, par3EntityLiving, par4, par5);
  }

  public UltimateArrow(World par1World, EntityPlayer par3EntityPlayer, float par3)
  {
    super(par1World, par3EntityPlayer, par3);
  }

  protected void entityInit()
  {
    this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
  }

  public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8)
  {
    float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
    par1 /= var9;
    par3 /= var9;
    par5 /= var9;

    par1 *= par7;
    par3 *= par7;
    par5 *= par7;
    this.motionX = par1;
    this.motionY = par3;
    this.motionZ = par5;
    float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
    this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
    this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(par3, var10) * 180.0D / 3.141592653589793D));
    this.ticksInGround = 0;
  }

  public void onUpdate()
  {
    super.onEntityUpdate();

    if ((this.prevRotationPitch == 0.0F) && (this.prevRotationYaw == 0.0F))
    {
      float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
      this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D));
      this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(this.motionY, var1) * 180.0D / 3.141592653589793D));
    }

    Block var16 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);

    if (var16 != Blocks.air)
    {
      var16.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
      AxisAlignedBB var2 = var16.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

      if ((var2 != null) && (var2.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))))
      {
        this.inGround = true;
      }
    }

    if (this.arrowShake > 0)
    {
      this.arrowShake -= 1;
    }

    if (this.inGround)
    {
      Block var18 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
      int var19 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

      if (var18 != Blocks.air)
      {
        this.ticksInGround += 1;

        if (this.ticksInGround == 500)
        {
          setDead();
        }
      }
      else
      {
        this.inGround = false;
        this.motionX *= this.rand.nextFloat() * 0.2F;
        this.motionY *= this.rand.nextFloat() * 0.2F;
        this.motionZ *= this.rand.nextFloat() * 0.2F;
        this.ticksInGround = 0;
        this.ticksInAir = 0;
      }
    }
    else
    {
      this.ticksInAir += 1;
      Vec3 var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
      Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
      MovingObjectPosition var4 = this.worldObj.rayTraceBlocks(var17, var3, true);
      var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
      var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

      if (var4 != null)
      {
        var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
      }

      Entity var5 = null;
      List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
      double var7 = 0.0D;

      for (int var9 = 0; var9 < var6.size(); var9++)
      {
        Entity var10 = (Entity)var6.get(var9);

        if ((!var10.canBeCollidedWith()) || ((var10 == this.shootingEntity) && (this.ticksInAir < 5)) || ((var10 instanceof Elevator)))
          continue;
        if ((var10 instanceof Cephadrome)) {
          Cephadrome c = (Cephadrome)var10;
          if (c.riddenByEntity != null) continue;
        }
        if ((var10 instanceof Dragon)) {
          Dragon c = (Dragon)var10;
          if (c.riddenByEntity != null) continue;
        }
        if ((var10 instanceof EntityHorse)) {
          EntityHorse c = (EntityHorse)var10;
          if (c.riddenByEntity != null) continue;
        }
        float var11 = 0.3F;
        AxisAlignedBB var12 = var10.boundingBox.expand(var11, var11, var11);
        MovingObjectPosition var13 = var12.calculateIntercept(var17, var3);

        if (var13 == null)
          continue;
        double var14 = var17.distanceTo(var13.hitVec);

        if ((var14 >= var7) && (var7 != 0.0D))
          continue;
        var5 = var10;
        var7 = var14;
      }

      if (var5 != null)
      {
        var4 = new MovingObjectPosition(var5);
      }

      if (var4 != null)
      {
        if (var4.entityHit != null)
        {
          float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
          float var23 = MathHelper.ceiling_double_int(var20 * OreSpawnMain.UltimateBowDamage);

          if (OreSpawnMain.ultimate_sword_pvp == 0) {
            if (((var4.entityHit instanceof EntityPlayer)) || ((var4.entityHit instanceof Girlfriend)) || ((var4.entityHit instanceof Boyfriend)))
            {
              EntityLivingBase e = (EntityLivingBase)var4.entityHit;

              playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
              e.heal(1.0F);
              setDead();
              return;
            }
            if ((var4.entityHit instanceof EntityTameable))
            {
              EntityTameable t = (EntityTameable)var4.entityHit;
              if (t.isTamed()) {
                playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                t.heal(1.0F);
                setDead();
                return;
              }
            }

          }

          if (getIsCritical())
          {
            var23 += this.rand.nextInt((int)var23 / 2 + 2);
          }

          DamageSource var21 = null;

          if (this.shootingEntity == null)
          {
            var21 = DamageSource.causeArrowDamage(this, this);
          }
          else
          {
            var21 = DamageSource.causeArrowDamage(this, this.shootingEntity);
          }

          if (isBurning())
          {
            var4.entityHit.setFire(5);
          }

          if (var4.entityHit.attackEntityFrom(var21, var23))
          {
            if ((var4.entityHit instanceof EntityLiving))
            {
              EntityLiving var24 = (EntityLiving)var4.entityHit;

              if (!this.worldObj.isRemote)
              {
                var24.setArrowCountInEntity(var24.getArrowCountInEntity() + 1);
              }

              if (this.knockbackStrength > 0)
              {
                float var26 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                if (var26 > 0.0F)
                {
                  var4.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579D / var26, 0.1D, this.motionZ * this.knockbackStrength * 0.6000000238418579D / var26);
                }

              }

              if ((this.shootingEntity != null) && (var4.entityHit != this.shootingEntity) && ((var4.entityHit instanceof EntityPlayer)) && ((this.shootingEntity instanceof EntityPlayerMP)))
              {
                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
              }
            }

            playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

            setDead();
          }
          else
          {
            this.motionX *= -0.10000000149D;
            this.motionY *= -0.10000000149D;
            this.motionZ *= -0.10000000149D;
            this.rotationYaw += 180.0F;
            this.prevRotationYaw += 180.0F;
            this.ticksInAir = 0;
          }
        }
        else
        {
          this.xTile = var4.blockX;
          this.yTile = var4.blockY;
          this.zTile = var4.blockZ;
          this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
          this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
          this.motionX = (float)(var4.hitVec.xCoord - this.posX);
          this.motionY = (float)(var4.hitVec.yCoord - this.posY);
          this.motionZ = (float)(var4.hitVec.zCoord - this.posZ);
          float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
          this.posX -= this.motionX / var20 * 0.05D;
          this.posY -= this.motionY / var20 * 0.05D;
          this.posZ -= this.motionZ / var20 * 0.05D;
          playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
          this.inGround = true;
          this.arrowShake = 7;
          setIsCritical(false);

          if (this.inTile != Blocks.air)
          {
            this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
          }
        }
      }
      if (this.getIsCritical()) {
          for (int var9 = 0; var9 < 4; ++var9) {
              this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)var9 / 4.0, this.posY + this.motionY * (double)var9 / 4.0, this.posZ + this.motionZ * (double)var9 / 4.0, - this.motionX, - this.motionY + 0.2, - this.motionZ);
          }
      }

      this.posX += this.motionX;
      this.posY += this.motionY;
      this.posZ += this.motionZ;
      float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
      this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D);

      for (this.rotationPitch = (float)(Math.atan2(this.motionY, var20) * 180.0D / 3.141592653589793D); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
      while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
      {
        this.prevRotationPitch += 360.0F;
      }

      while (this.rotationYaw - this.prevRotationYaw < -180.0F)
      {
        this.prevRotationYaw -= 360.0F;
      }

      while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
      {
        this.prevRotationYaw += 360.0F;
      }

      this.rotationPitch = (this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F);
      this.rotationYaw = (this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F);
      float var22 = 0.99F;
      float var11 = 0.05F;

      if (isInWater())
      {
        for (int var25 = 0; var25 < 4; var25++)
        {
          float var26 = 0.25F;
          this.worldObj.spawnParticle("bubble", this.posX - this.motionX * var26, this.posY - this.motionY * var26, this.posZ - this.motionZ * var26, this.motionX, this.motionY, this.motionZ);
        }

        var22 = 0.8F;
      }

      this.motionX *= var22;
      this.motionY *= var22;
      this.motionZ *= var22;
      this.motionY -= var11;
      setPosition(this.posX, this.posY, this.posZ);
      func_145775_I();
    }
  }

  public void setKnockbackStrength(int par1)
  {
    this.knockbackStrength = par1;
  }

  public void setDamage(double par1)
  {
  }

  public double getDamage()
  {
    return OreSpawnMain.UltimateBowDamage;
  }
}