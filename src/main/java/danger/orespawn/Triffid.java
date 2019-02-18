/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Dragon
 *  danger.orespawn.EnderReaper
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.LurkingTerror
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.PitchBlack
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.TerribleTerror
 *  danger.orespawn.Triffid
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Dragon;
import danger.orespawn.EnderReaper;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.LurkingTerror;
import danger.orespawn.MobStats;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.PitchBlack;
import danger.orespawn.RenderInfo;
import danger.orespawn.TerribleTerror;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Triffid
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private int hurt_timer = 0;
    private float moveSpeed = 0.13f;

    public Triffid(World par1World) {
        super(par1World);
        this.setSize(2.0f, 4.0f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 50;
        this.fireResistance = 75;
        this.isImmuneToFire = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
        this.dataWatcher.addObject(21, (Object)0);
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Triffid_stats.attack);
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
        if (this.worldObj.rand.nextInt(100) == 1) {
            Block bid;
            int k;
            int ix = (int)this.posX;
            int iz = (int)this.posZ;
            for (k = -5; k <= 5; ++k) {
                bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ + k);
                if (bid == Blocks.air) continue;
                if (k < 0) {
                    --iz;
                }
                if (k <= 0) continue;
                ++iz;
            }
            for (k = -5; k <= 5; ++k) {
                bid = this.worldObj.getBlock((int)this.posX + k, (int)this.posY - 1, (int)this.posZ);
                if (bid == Blocks.air) continue;
                if (k < 0) {
                    --ix;
                }
                if (k <= 0) continue;
                ++ix;
            }
            this.getNavigator().tryMoveToXYZ((double)ix, this.posY, (double)iz, 1.0);
        }
        if (this.hurt_timer <= 0 && (e = this.findSomethingToAttack()) != null) {
            this.rotationYaw = (float)Math.toDegrees(Math.atan2(e.posZ - this.posZ, e.posX - this.posX)) - 90.0f;
            while (this.rotationYaw < 0.0f) {
                this.rotationYaw += 360.0f;
            }
        }
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Triffid_stats.health;
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
        return OreSpawnMain.Triffid_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && this.hurt_timer > 0) {
            this.motionZ = 0.0;
            this.motionX = 0.0;
        }
    }

    public int getTriffidHealth() {
        return (int)this.getHealth();
    }

    protected String getLivingSound() {
        return "orespawn:triffid_living";
    }

    protected String getHurtSound() {
        return "orespawn:triffid_hit";
    }

    protected String getDeathSound() {
        return "orespawn:triffid_dead";
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        int i = this.worldObj.rand.nextInt(3);
        if (i == 0) {
            return Items.gold_nugget;
        }
        return null;
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(3) - (double)OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(3) - (double)OreSpawnMain.OreSpawnRand.nextInt(3), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int i = 4 + this.worldObj.rand.nextInt(6);
        for (int var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.GreenGoo, 1);
        }
        this.dropItemRand(Items.item_frame, 1);
    }

    public boolean canBePushed() {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean ret = super.attackEntityAsMob(par1Entity);
        return ret;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (this.hurt_timer > 0 || this.getOpenClosed() == 0) {
            this.hurt_timer = 300;
            this.setAttacking(0);
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        this.hurt_timer = 300;
        this.setOpenClosed(0);
        this.setAttacking(0);
        return ret;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
            this.setFire(0);
            this.setOpenClosed(0);
        }
        if (this.worldObj.rand.nextInt(250) == 1 && this.getHealth() < (float)this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
        if (this.worldObj.rand.nextInt(80) == 2 && this.hurt_timer <= 0) {
            if (this.worldObj.rand.nextInt(8) == 1) {
                this.setOpenClosed(1);
            } else {
                this.setOpenClosed(0);
            }
        }
        if (this.worldObj.rand.nextInt(10) == 1 && this.hurt_timer <= 0) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.setOpenClosed(1);
                if (this.getDistanceSqToEntity((Entity)e) < 25.0) {
                    this.rotationYaw = (float)Math.toDegrees(Math.atan2(e.posZ - this.posZ, e.posX - this.posX)) - 90.0f;
                    while (this.rotationYaw < 0.0f) {
                        this.rotationYaw += 360.0f;
                    }
                    this.setAttacking(1);
                    this.attackEntityAsMob((Entity)e);
                } else {
                    this.setAttacking(0);
                }
            } else {
                this.setAttacking(0);
            }
        }
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
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EnderReaper) {
            return false;
        }
        if (par1EntityLiving instanceof Triffid) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof PitchBlack) {
            return false;
        }
        if (par1EntityLiving instanceof Dragon) {
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

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 8.0, 10.0));
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

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public final void setAttacking(int par1) {
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    public final int getOpenClosed() {
        return this.dataWatcher.getWatchableObjectByte(21);
    }

    public final void setOpenClosed(int par1) {
        this.dataWatcher.updateObject(21, (Object)((byte)par1));
    }

    public boolean getCanSpawnHere() {
        return true;
    }
}

