/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.CrystalCow
 *  danger.orespawn.Flounder
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Irukandji
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Peacock
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.Rotator
 *  danger.orespawn.Skate
 *  danger.orespawn.Urchin
 *  danger.orespawn.Vortex
 *  danger.orespawn.Whale
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
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.CrystalCow;
import danger.orespawn.Flounder;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Irukandji;
import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Peacock;
import danger.orespawn.RenderInfo;
import danger.orespawn.Rotator;
import danger.orespawn.Skate;
import danger.orespawn.Vortex;
import danger.orespawn.Whale;
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Urchin
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private float moveSpeed = 0.3f;
    private int was_spawnered = 0;

    public Urchin(World par1World) {
        super(par1World);
        this.setSize(1.35f, 2.1f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 20;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Urchin_stats.attack);
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
        if (this.was_spawnered != 0) {
            return false;
        }
        return true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
        if (this.isNoDespawnRequired()) {
            return;
        }
        if (this.was_spawnered != 0) {
            return;
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 12000L && this.worldObj.rand.nextInt(400) == 1) {
            this.setDead();
        }
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Urchin_stats.health;
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
        return OreSpawnMain.Urchin_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.rand.nextInt(3) == 1) {
            this.worldObj.spawnParticle("flame", this.posX, this.posY + 0.75, this.posZ, 0.0, (double)(this.worldObj.rand.nextFloat() / 10.0f), 0.0);
            if (this.isInWater() && this.worldObj.rand.nextInt(5) == 1) {
                this.attackEntityAsMob((Entity)this);
                this.worldObj.spawnParticle("smoke", this.posX, this.posY + 1.75, this.posZ, 0.0, (double)(this.worldObj.rand.nextFloat() / 10.0f), 0.0);
                this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 1.75, this.posZ, 0.0, (double)(this.worldObj.rand.nextFloat() / 10.0f), 0.0);
                this.worldObj.spawnParticle("smoke", this.posX, this.posY + 2.0, this.posZ, 0.0, (double)(this.worldObj.rand.nextFloat() / 10.0f), 0.0);
                this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 2.0, this.posZ, 0.0, (double)(this.worldObj.rand.nextFloat() / 10.0f), 0.0);
            }
        }
    }

    protected String getLivingSound() {
        return "orespawn:kyuubi_living";
    }

    protected String getHurtSound() {
        return "orespawn:glasshit";
    }

    protected String getDeathSound() {
        return "orespawn:glassdead";
    }

    protected float getSoundVolume() {
        return 1.1f;
    }

    protected float getSoundPitch() {
        return 1.25f;
    }

    protected Item getDropItem() {
        int i = this.worldObj.rand.nextInt(3);
        if (i == 1) {
            return OreSpawnMain.MyCrystalPinkIngot;
        }
        if (i == 2) {
            return OreSpawnMain.MyCrystalApple;
        }
        return null;
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        par1Entity.setFire(5);
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(8) == 0) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.getDistanceSqToEntity((Entity)e) < 8.0) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(7) == 0 || this.worldObj.rand.nextInt(8) == 1) {
                        this.attackEntityAsMob((Entity)e);
                    }
                } else {
                    this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.2);
                }
            } else {
                this.setAttacking(0);
            }
        }
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
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        if (par1EntityLiving instanceof Rotator) {
            return false;
        }
        if (par1EntityLiving instanceof Peacock) {
            return false;
        }
        if (par1EntityLiving instanceof CrystalCow) {
            return false;
        }
        if (par1EntityLiving instanceof Irukandji) {
            return false;
        }
        if (par1EntityLiving instanceof Skate) {
            return false;
        }
        if (par1EntityLiving instanceof Whale) {
            return false;
        }
        if (par1EntityLiving instanceof Flounder) {
            return false;
        }
        if (par1EntityLiving instanceof Urchin) {
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
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 3.0, 16.0));
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

    public boolean getCanSpawnHere() {
        Block bid;
        int j;
        int k;
        int sc = 0;
        for (k = -2; k <= 2; ++k) {
            for (j = -2; j <= 2; ++j) {
                for (int i = 1; i < 4; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Crystal Urchin")) continue;
                    this.was_spawnered = 1;
                    return true;
                }
            }
        }
        for (k = -1; k <= 1; ++k) {
            for (j = -1; j <= 1; ++j) {
                bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + 1, (int)this.posZ + k);
                if (bid != Blocks.air) continue;
                ++sc;
            }
        }
        if (sc < 6) {
            return false;
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 13000L) {
            return false;
        }
        return true;
    }
}

