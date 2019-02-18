/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.IceBall
 *  danger.orespawn.LaserBall
 *  danger.orespawn.MyUtils
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.LaserBall;
import danger.orespawn.MyUtils;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class IceBall
extends LaserBall {
    private int my_index = 84;
    private int icemaker = 0;

    public IceBall(World par1World) {
        super(par1World);
        super.setIceBall();
    }

    public IceBall(World par1World, int par2) {
        super(par1World);
        super.setIceBall();
    }

    public IceBall(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        super.setIceBall();
    }

    public IceBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
        super.setIceBall();
    }

    public IceBall(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        super.setIceBall();
    }

    public int getIceBallIndex() {
        return this.my_index;
    }

    public void setIceMaker(int i) {
        this.icemaker = i;
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null && MyUtils.isRoyalty((Entity)par1MovingObjectPosition.entityHit)) {
            this.setDead();
            return;
        }
        super.onImpact(par1MovingObjectPosition);
        if (this.icemaker != 0) {
            for (int i = 0; i < 5; ++i) {
                int x = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    x = - x;
                }
                int y = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    y = - y;
                }
                int z = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    z = - z;
                }
                x = (int)((double)x + par1MovingObjectPosition.hitVec.xCoord);
                y = (int)((double)y + par1MovingObjectPosition.hitVec.yCoord);
                z = (int)((double)z + par1MovingObjectPosition.hitVec.zCoord);
                this.worldObj.setBlock(x, y, z, Blocks.ice);
            }
        }
        this.setDead();
    }
}

