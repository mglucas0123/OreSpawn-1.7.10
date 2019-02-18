/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Alien
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderInfo
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
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemEmptyMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RenderInfo;
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
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEmptyMap;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class Alien
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private int hurt_timer = 0;
    private double moveSpeed = 0.65;
    private int closest = 99999;
    private int tx = 0;
    private int ty = 0;
    private int tz = 0;

    public Alien(World par1World) {
        super(par1World);
        this.setSize(1.1f, 3.25f);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setBreakDoors(true);
        this.experienceValue = 100;
        this.fireResistance = 30;
        this.isImmuneToFire = false;
        this.jumpMovementFactor = 0.6f;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Alien_stats.attack);
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

    public int mygetMaxHealth() {
        return OreSpawnMain.Alien_stats.health;
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
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
        return OreSpawnMain.Alien_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {
            float f = 1.7f + Math.abs(this.worldObj.rand.nextFloat() * 0.75f);
            if (this.worldObj.rand.nextInt(20) == 1) {
                this.worldObj.spawnParticle("dripLava", this.posX - (double)f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 1.6, this.posZ + (double)f * Math.cos(Math.toRadians(this.rotationYawHead)), 0.0, 0.0, 0.0);
            }
        }
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int getAlienHealth() {
        return (int)this.getHealth();
    }

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(4) == 0) {
            return "orespawn:alien_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:alien_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:alien_death";
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.spider_eye;
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        int var5 = 5 + this.worldObj.rand.nextInt(6);
        for (var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.spider_eye, 1);
        }
        var5 = 5 + this.worldObj.rand.nextInt(6);
        for (var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.flint, 1);
        }
        this.dropItemRand((Item)Items.map, 1);
        this.dropItemRand(Items.clock, 1);
        this.dropItemRand(Items.compass, 1);
    }

    public void initCreature() {
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                int var2 = 6;
                if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
                    var2 = 8;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        var2 = 10;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        var2 = 12;
                    }
                }
                if (par1Entity instanceof EntityLivingBase && this.worldObj.rand.nextInt(5) == 1) {
                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 5, 0));
                }
                double ks = 1.1;
                double inair = 0.1;
                float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity e;
        boolean ret = false;
        if (par1DamageSource.getDamageType().equals("cactus")) {
            return false;
        }
        if (this.hurt_timer <= 0) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
        }
        if ((e = par1DamageSource.getEntity()) != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase)((EntityLiving)e));
            this.setTarget(e);
            this.getNavigator().tryMoveToEntityLiving((Entity)((EntityLiving)e), 1.2);
            ret = true;
        }
        return ret;
    }

    private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) {
        int i;
        Block bid;
        int d;
        int j;
        int found = 0;
        for (i = - dy; i <= dy; ++i) {
            for (j = - dz; j <= dz; ++j) {
                bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if ((bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) && (d = dx * dx + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + dx;
                    this.ty = y + i;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x - dx, y + i, z + j)) != Blocks.torch && bid != OreSpawnMain.ExtremeTorch || (d = dx * dx + j * j + i * i) >= this.closest) continue;
                this.closest = d;
                this.tx = x - dx;
                this.ty = y + i;
                this.tz = z + j;
                ++found;
            }
        }
        for (i = - dx; i <= dx; ++i) {
            for (j = - dz; j <= dz; ++j) {
                bid = this.worldObj.getBlock(x + i, y + dy, z + j);
                if ((bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) && (d = dy * dy + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + dy;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y - dy, z + j)) != Blocks.torch && bid != OreSpawnMain.ExtremeTorch || (d = dy * dy + j * j + i * i) >= this.closest) continue;
                this.closest = d;
                this.tx = x + i;
                this.ty = y - dy;
                this.tz = z + j;
                ++found;
            }
        }
        for (i = - dx; i <= dx; ++i) {
            for (j = - dy; j <= dy; ++j) {
                bid = this.worldObj.getBlock(x + i, y + j, z + dz);
                if ((bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) && (d = dz * dz + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + j;
                    this.tz = z + dz;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y + j, z - dz)) != Blocks.torch && bid != OreSpawnMain.ExtremeTorch || (d = dz * dz + j * j + i * i) >= this.closest) continue;
                this.closest = d;
                this.tx = x + i;
                this.ty = y + j;
                this.tz = z - dz;
                ++found;
            }
        }
        if (found != 0) {
            return true;
        }
        return false;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.worldObj.rand.nextInt(8) == 0) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity)e) < 16.0) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob((Entity)e);
                    }
                }
                this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.2);
            } else {
                this.setAttacking(0);
            }
        } else if (this.rand.nextInt(30) == 0 && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            this.tz = 0;
            this.ty = 0;
            this.tx = 0;
            for (int i = 2; i < 15 && !this.scan_it((int)this.posX, (int)this.posY, (int)this.posZ, i, i, i); ++i) {
                if (i < 10) continue;
                ++i;
            }
            if (this.closest < 99999) {
                this.getNavigator().tryMoveToXYZ((double)this.tx, (double)this.ty, (double)this.tz, 1.0);
                if (this.closest < 27 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                }
            }
        }
        if (this.worldObj.rand.nextInt(40) == 1 && this.getHealth() < (float)this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
    }

    private boolean isSuitableTarget(EntityLivingBase var4, boolean par2) {
        if (var4 == null) {
            return false;
        }
        if (var4 == this) {
            return false;
        }
        if (!var4.isEntityAlive()) {
            return false;
        }
        if (var4 instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)var4;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            return true;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 4.0, 12.0));
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
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
        int i;
        int k;
        for (k = -3; k < 3; ++k) {
            for (j = -3; j < 3; ++j) {
                for (i = 0; i < 5; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Alien")) continue;
                    return true;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
            return true;
        }
        if (this.posY > 50.0) {
            return false;
        }
        for (k = -1; k < 2; ++k) {
            for (j = -1; j < 2; ++j) {
                for (i = 1; i < 4; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        return true;
    }
}

