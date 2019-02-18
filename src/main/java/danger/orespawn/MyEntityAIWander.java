/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyEntityAIWander
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.RandomPositionGenerator
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.Vec3
 */
package danger.orespawn;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

public class MyEntityAIWander
extends EntityAIBase {
    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private float speed;

    public MyEntityAIWander(EntityCreature par1EntityCreature, float par2) {
        this.entity = par1EntityCreature;
        this.speed = par2;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.entity.getRNG().nextInt(90) != 0) {
            return false;
        }
        if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting()) {
            return false;
        }
        Vec3 var1 = RandomPositionGenerator.findRandomTarget((EntityCreature)this.entity, (int)10, (int)7);
        if (var1 == null) {
            return false;
        }
        this.xPosition = var1.xCoord;
        this.yPosition = var1.yCoord;
        this.zPosition = var1.zCoord;
        return true;
    }

    public boolean continueExecuting() {
        EntityLivingBase var1;
        EntityTameable gf;
        if (this.entity != null && this.entity instanceof EntityTameable && (var1 = (gf = (EntityTameable)this.entity).getOwner()) != null && (int)gf.posZ == (int)var1.posZ && (int)gf.posX == (int)var1.posX && (int)gf.posY < (int)var1.posY + 2 && (int)gf.posY > (int)var1.posY - 2) {
            return false;
        }
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, (double)this.speed);
    }
}

