/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.SunspotUrchin
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFire
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package danger.orespawn;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SunspotUrchin
extends EntityThrowable {
    private float my_rotation = 0.0f;
    private int my_index = 50;

    public SunspotUrchin(World par1World) {
        super(par1World);
    }

    public SunspotUrchin(World par1World, int par2) {
        super(par1World);
    }

    public SunspotUrchin(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    public SunspotUrchin(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public SunspotUrchin(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public int getUrchinIndex() {
        return this.my_index;
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            float var2 = 3.0f;
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                var2 = 6.0f;
            }
            if (!(par1MovingObjectPosition.entityHit instanceof EntityPlayer)) {
                par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), var2);
                if (!par1MovingObjectPosition.entityHit.isImmuneToFire()) {
                    par1MovingObjectPosition.entityHit.setFire(5);
                }
            }
        } else {
            int i = par1MovingObjectPosition.blockX;
            int j = par1MovingObjectPosition.blockY;
            int k = par1MovingObjectPosition.blockZ;
            switch (par1MovingObjectPosition.sideHit) {
                case 0: {
                    --j;
                    break;
                }
                case 1: {
                    ++j;
                    break;
                }
                case 2: {
                    --k;
                    break;
                }
                case 3: {
                    ++k;
                    break;
                }
                case 4: {
                    --i;
                    break;
                }
                case 5: {
                    ++i;
                }
            }
            if (this.worldObj.isAirBlock(i, j, k)) {
                this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
            }
        }
        for (int var3 = 0; var3 < 5; ++var3) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, (double)this.worldObj.rand.nextFloat(), (double)this.worldObj.rand.nextFloat(), (double)this.worldObj.rand.nextFloat());
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, (double)this.worldObj.rand.nextFloat(), (double)this.worldObj.rand.nextFloat(), (double)this.worldObj.rand.nextFloat());
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.setFire(1);
        this.my_rotation += 30.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch = this.my_rotation;
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}

