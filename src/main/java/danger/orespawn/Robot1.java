/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.Robot1
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.MyUtils;
import java.util.Iterator;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RenderInfo;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class Robot1
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private float moveSpeed = 0.2f;

    public Robot1(World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.5f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 5;
        this.fireResistance = 5;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 5;
    }

    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }

    public int getTotalArmorValue() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        EntityLivingBase e;
        super.onLivingUpdate();
        if (this.worldObj.rand.nextInt(8) == 0 && (e = this.findSomethingToAttack()) != null) {
            if (this.getDistanceSqToEntity((Entity)e) < 5.0 && !this.worldObj.isRemote && this.worldObj.rand.nextInt(18) == 1) {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.5f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.setDead();
            }
            for (int i = 0; i < 2; ++i) {
                this.worldObj.spawnParticle("smoke", this.posX, this.posY + 1.0, this.posZ, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("lava", this.posX, this.posY + 1.0, this.posZ, 0.0, 0.0, 0.0);
            }
            this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.2);
        }
    }

    protected String getLivingSound() {
        return "orespawn:kyuubi_living";
    }

    protected String getHurtSound() {
        return "orespawn:scorpion_hit";
    }

    protected String getDeathSound() {
        return "orespawn:robot1_death";
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.gunpowder;
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
        }
        return ret;
    }

    private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
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
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack()
    {
      if (OreSpawnMain.PlayNicely != 0) return null;
      List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 3.0D, 8.0D));
      Collections.sort(var5, this.TargetSorter);
      Iterator var2 = var5.iterator();

      while (var2.hasNext())
      {
        Entity var3 = (Entity)var2.next();
        EntityLivingBase var4 = (EntityLivingBase)var3;

        if (isSuitableTarget(var4, false))
        {
          return var4;
        }
      }
      return null;
    }


    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public final void setAttacking(int par1) {
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        return true;
    }
}

