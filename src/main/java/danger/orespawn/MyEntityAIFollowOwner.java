/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.MyEntityAIFollowOwner
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityLookHelper
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MyEntityAIFollowOwner
extends EntityAIBase {
    private EntityTameable thePet;
    private EntityLivingBase theOwner;
    World theWorld;
    private float field_75336_f;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;

    public MyEntityAIFollowOwner(EntityTameable par1EntityTameable, float par2, float par3, float par4) {
        this.thePet = par1EntityTameable;
        this.theWorld = par1EntityTameable.worldObj;
        this.field_75336_f = par2;
        this.petPathfinder = par1EntityTameable.getNavigator();
        this.minDist = par4;
        this.maxDist = par3;
        this.setMutexBits(3);
    }

    public boolean shouldExecute() {
        EntityLivingBase var1 = this.thePet.getOwner();
        if (var1 == null) {
            return false;
        }
        this.theOwner = var1;
        if (this.thePet.isSitting()) {
            return false;
        }
        if (this.thePet instanceof Girlfriend && OreSpawnMain.valentines_day != 0) {
            return false;
        }
        if (!(this.thePet == null || this.thePet.posY >= 60.0 && this.thePet.worldObj.isDaytime() || this.thePet.getDistanceSqToEntity((Entity)var1) <= (double)(this.maxDist / 2.0f * (this.maxDist / 2.0f)))) {
            return true;
        }
        if (this.thePet.getDistanceSqToEntity((Entity)var1) < (double)(this.maxDist * this.maxDist)) {
            return false;
        }
        return true;
    }

    public boolean continueExecuting() {
        EntityLivingBase var1;
        EntityTameable gf;
        if (this.thePet.isSitting()) {
            return false;
        }
        if (this.petPathfinder.noPath()) {
            return false;
        }
        if (this.thePet != null && this.thePet instanceof EntityTameable && (var1 = (gf = this.thePet).getOwner()) != null && (int)gf.posZ == (int)var1.posZ && (int)gf.posX == (int)var1.posX && (int)gf.posY < (int)var1.posY + 2 && (int)gf.posY > (int)var1.posY - 2) {
            return false;
        }
        return this.thePet.getDistanceSqToEntity((Entity)this.theOwner) > (double)(this.minDist * this.minDist);
    }

    public void startExecuting() {
        this.field_75343_h = 0;
        this.field_75344_i = this.thePet.getNavigator().getAvoidsWater();
        this.thePet.getNavigator().setAvoidsWater(false);
    }

    public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        this.thePet.getNavigator().setAvoidsWater(this.field_75344_i);
    }

    public void updateTask() {
        this.thePet.getLookHelper().setLookPositionWithEntity((Entity)this.theOwner, 10.0f, (float)this.thePet.getVerticalFaceSpeed());
        if (!this.thePet.isSitting() && --this.field_75343_h <= 0) {
            this.field_75343_h = 10;
            if (!this.petPathfinder.tryMoveToEntityLiving((Entity)this.theOwner, (double)this.field_75336_f) && this.thePet.getDistanceSqToEntity((Entity)this.theOwner) >= 144.0) {
                int var1 = MathHelper.floor_double((double)this.theOwner.posX) - 2;
                int var2 = MathHelper.floor_double((double)this.theOwner.posZ) - 2;
                int var3 = MathHelper.floor_double((double)this.theOwner.boundingBox.minY);
                for (int var4 = 0; var4 <= 4; ++var4) {
                    for (int var5 = 0; var5 <= 4; ++var5) {
                        if (var4 >= 1 && var5 >= 1 && var4 <= 3 && var5 <= 3 || !World.doesBlockHaveSolidTopSurface((IBlockAccess)this.theWorld, (int)(var1 + var4), (int)(var3 - 1), (int)(var2 + var5)) || this.theWorld.getBlock(var1 + var4, var3, var2 + var5).isNormalCube() || this.theWorld.getBlock(var1 + var4, var3 + 1, var2 + var5).isNormalCube()) continue;
                        this.thePet.setLocationAndAngles((double)((float)(var1 + var4) + 0.5f), (double)var3, (double)((float)(var2 + var5) + 0.5f), this.thePet.rotationYaw, this.thePet.rotationPitch);
                        this.petPathfinder.clearPathEntity();
                        return;
                    }
                }
            }
        }
    }
}

