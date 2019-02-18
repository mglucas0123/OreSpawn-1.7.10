/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.SpiderDriver
 *  danger.orespawn.SpiderRobot
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.SpiderRobot;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class SpiderDriver
extends EntitySpider {
    private GenericTargetSorter TargetSorter = null;

    public SpiderDriver(World par1World) {
        super(par1World);
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.tasks.addTask(3, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.65f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.ridingEntity != null) {
            return false;
        }
        return true;
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected Entity findPlayerToAttack() {
        double d0 = 16.0;
        return this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, d0);
    }

    protected void updateAITasks() {
        EntityLivingBase e;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0 && this.ridingEntity == null && (e = this.findSpiderRobot()) != null) {
            this.faceEntity((Entity)e, 10.0f, 10.0f);
            if (this.getDistanceSqToEntity((Entity)e) < (double)((4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f))) {
                this.mountEntity((Entity)e);
            } else {
                this.getNavigator().tryMoveToEntityLiving((Entity)e, 0.55);
            }
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(4) == 0 && this.ridingEntity != null && (e = this.findSomethingToAttack()) != null) {
            this.faceEntity((Entity)e, 10.0f, 10.0f);
            if (this.getDistanceSqToEntity((Entity)e) >= (double)((11.0f + e.width / 2.0f) * (11.0f + e.width / 2.0f)) && this.ridingEntity instanceof SpiderRobot) {
                SpiderRobot sp = (SpiderRobot)this.ridingEntity;
                double d1 = e.posZ - this.posZ;
                double d2 = e.posX - this.posX;
                double dd = Math.atan2(d1, d2);
                sp.goThisWay(0.35 * Math.cos(dd), 0.35 * Math.sin(dd));
            }
        }
    }

    protected void attackEntity(Entity par1Entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0f && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 16;
            this.attackEntityAsMob(par1Entity);
            if (this.worldObj.rand.nextInt(2) == 0) {
                ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 0));
            }
        }
    }

    public int getTotalArmorValue() {
        if (this.ridingEntity != null) {
            return 8;
        }
        return 20;
    }

    private EntityLivingBase findSpiderRobot() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(SpiderRobot.class, this.boundingBox.expand(25.0, 15.0, 25.0));
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (var4.riddenByEntity != null) continue;
            return var4;
        }
        return null;
    }

    private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (MyUtils.isIgnoreable((EntityLivingBase)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof SpiderRobot) {
            return false;
        }
        if (par1EntityLiving instanceof SpiderDriver) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return false;
        }
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            return true;
        }
        if (this.getDistanceSqToEntity((Entity)par1EntityLiving) < 36.0) {
            return false;
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(35.0, 15.0, 35.0));
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (!this.isSuitableTarget(var4, false)) continue;
            return var4;
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        SpiderRobot target = null;
        target = (SpiderRobot)this.worldObj.findNearestEntityWithinAABB(SpiderRobot.class, this.boundingBox.expand(24.0, 12.0, 24.0), (Entity)this);
        if (target != null) {
            return true;
        }
        return super.getCanSpawnHere();
    }
}

