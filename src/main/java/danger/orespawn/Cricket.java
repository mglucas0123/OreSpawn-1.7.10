/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Cricket
 *  danger.orespawn.MyEntityAIWanderALot
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.MyEntityAIWanderALot;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Cricket
extends EntityAnimal {
    public double moveSpeed = 0.15000000596046448;
    private int singing = 0;
    private int jumpcount = 0;

    public Cricket(World par1World) {
        super(par1World);
        this.setSize(0.1f, 0.1f);
        this.experienceValue = 1;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 8, 1.0));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public int getSinging() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public void setSinging(int par1) {
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    private void jumpAround() {
        this.motionY += (double)(0.55f + Math.abs(this.worldObj.rand.nextFloat() * 0.35f));
        this.posY += 0.25;
        float f = 0.3f + Math.abs(this.worldObj.rand.nextFloat() * 0.25f);
        float d = (float)((double)this.worldObj.rand.nextFloat() * 3.141592653589793 * 2.0);
        this.motionX += (double)f * Math.sin(d);
        this.motionZ += (double)f * Math.cos(d);
        this.isAirBorne = true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            if (this.singing != 0) {
                --this.singing;
                if (this.singing <= 0) {
                    this.setSinging(0);
                }
            }
            if (this.jumpcount > 0) {
                --this.jumpcount;
            }
            if (this.jumpcount == 0 && this.worldObj.rand.nextInt(50) == 1) {
                this.jumpAround();
                this.jumpcount = 50;
            }
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int mygetMaxHealth() {
        return 3;
    }

    protected String getLivingSound() {
        if (!this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                return null;
            }
            this.singing = 40;
            this.setSinging(this.singing);
        }
        return "orespawn:cricket";
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected float getSoundVolume() {
        return 0.7f;
    }

    protected void playStepSound(int par1, int par2, int par3, int par4) {
    }

    protected void dropFewItems(boolean par1, int par2) {
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 30.0) {
            return false;
        }
        if (this.findBuddies() > 5) {
            return false;
        }
        return true;
    }

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(Cricket.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}

