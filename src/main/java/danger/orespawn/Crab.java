/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Crab
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.Lizard
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RubberDucky
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
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
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Girlfriend;
import danger.orespawn.Lizard;
import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RubberDucky;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class Crab
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private int hurt_timer = 0;
    private float moveSpeed = 0.55f;
    private int closest = 99999;
    private int tx = 0;
    private int ty = 0;
    private int tz = 0;

    public Crab(World par1World) {
        super(par1World);
        this.setSize(1.25f, 2.5f);
        this.getNavigator().setAvoidsWater(false);
        this.experienceValue = 150;
        this.fireResistance = 30;
        this.isImmuneToFire = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)(this.moveSpeed * this.getCrabScale()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)((float)OreSpawnMain.Crab_stats.attack * this.getCrabScale()));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
        this.dataWatcher.addObject(21, (Object)0);
        float t = 0.25f;
        if (this.worldObj != null) {
            if (this.worldObj.rand.nextInt(4) == 1) {
                t = 0.5f;
            }
            if (this.worldObj.rand.nextInt(8) == 2) {
                t = 1.0f;
            }
        } else {
            if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) {
                t = 0.5f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) {
                t = 1.0f;
            }
        }
        this.setCrabScale(t);
        this.experienceValue = (int)(400.0f * t);
        this.fireResistance = (int)(10.0f * t);
        this.setSize(3.75f * this.getCrabScale(), 3.5f * this.getCrabScale());
    }

    public float getCrabScale() {
        int i = this.dataWatcher.getWatchableObjectInt(21);
        float f = i;
        return f / 100.0f;
    }

    public void setCrabScale(float par1) {
        float f = par1 * 100.0f;
        int i = (int)f;
        this.dataWatcher.updateObject(21, (Object)i);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setCrabScale(par1NBTTagCompound.getFloat("Fscale"));
        this.setSize(3.75f * this.getCrabScale(), 3.5f * this.getCrabScale());
        this.experienceValue = (int)(400.0f * this.getCrabScale());
        this.fireResistance = (int)(10.0f * this.getCrabScale());
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setFloat("Fscale", this.getCrabScale());
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public void onUpdate() {
        this.moveSpeed = this.isInWater() ? 0.95f : 0.55f;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)(this.moveSpeed * this.getCrabScale()));
        super.onUpdate();
        this.setSize(2.5f * this.getCrabScale(), 3.5f * this.getCrabScale());
    }

    public int mygetMaxHealth() {
        return (int)((float)OreSpawnMain.PitchBlack_stats.health * this.getCrabScale());
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Crab_stats.defense + (int)(2.0f * this.getCrabScale());
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public int getCrabHealth() {
        return (int)this.getHealth();
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:leaves_hit";
    }

    protected String getDeathSound() {
        return null;
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 2.0f - 0.3f * (1.0f / this.getCrabScale());
    }

    protected Item getDropItem() {
        return Items.fish;
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        Object is = null;
        int var5 = 4 + this.worldObj.rand.nextInt(8);
        if ((var5 = (int)((float)var5 * this.getCrabScale())) < 1) {
            var5 = 1;
        }
        for (int var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(OreSpawnMain.MyRawCrabMeat, 1);
        }
    }

    public void initCreature() {
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)OreSpawnMain.Crab_stats.attack * this.getCrabScale());
        if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
            double ks = 1.15 * (double)this.getCrabScale();
            double inair = 0.48 * (double)this.getCrabScale();
            float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var4;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType().equals("cactus")) {
            return false;
        }
        Entity e = par1DamageSource.getEntity();
        if (this.hurt_timer <= 0) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.hurt_timer = 8;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof Crab) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase)((EntityLiving)e));
            this.setTarget(e);
            this.getNavigator().tryMoveToEntityLiving((Entity)((EntityLiving)e), 1.2);
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
                if ((bid == Blocks.water || bid == Blocks.flowing_water) && (d = dx * dx + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + dx;
                    this.ty = y + i;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x - dx, y + i, z + j)) != Blocks.water && bid != Blocks.flowing_water || (d = dx * dx + j * j + i * i) >= this.closest) continue;
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
                if ((bid == Blocks.water || bid == Blocks.flowing_water) && (d = dy * dy + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + dy;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y - dy, z + j)) != Blocks.water && bid != Blocks.flowing_water || (d = dy * dy + j * j + i * i) >= this.closest) continue;
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
                if ((bid == Blocks.water || bid == Blocks.flowing_water) && (d = dz * dz + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + j;
                    this.tz = z + dz;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y + j, z - dz)) != Blocks.water && bid != Blocks.flowing_water || (d = dz * dz + j * j + i * i) >= this.closest) continue;
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
        if (!this.isInWater() && this.worldObj.rand.nextInt(25) == 0) {
            this.closest = 99999;
            this.tz = 0;
            this.ty = 0;
            this.tx = 0;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 10) {
                    j = 10;
                }
                if (this.scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i)) break;
                if (i < 5) continue;
                ++i;
            }
            if (this.closest < 99999) {
                this.getNavigator().tryMoveToXYZ((double)this.tx, (double)(this.ty - 1), (double)this.tz, 1.33);
            } else {
                if (this.worldObj.rand.nextInt(100) == 1) {
                    this.heal(-1.0f * this.getCrabScale());
                }
                if (this.getHealth() <= 0.0f) {
                    this.setDead();
                    return;
                }
            }
        }
        if (this.worldObj.rand.nextInt(5) == 1) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(100) == 1) {
                this.setAttackTarget(null);
            }
            if ((e = this.getAttackTarget()) != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity)e) < (double)((6.0f + e.width / 2.0f) * (6.0f + e.width / 2.0f) * this.getCrabScale())) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob((Entity)e);
                        if (!this.worldObj.isRemote) {
                            if (this.worldObj.rand.nextInt(3) == 1) {
                                this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 0.75f, 1.5f);
                            } else {
                                this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_living", 0.75f, 1.5f);
                            }
                        }
                    }
                } else {
                    this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.0);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(120) == 1 && this.isInWater() && this.getHealth() < (float)this.mygetMaxHealth()) {
            this.playSound("splash", 1.5f, this.worldObj.rand.nextFloat() * 0.2f + 0.9f);
            this.heal(4.0f * this.getCrabScale());
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
        if (par1EntityLiving instanceof Crab) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Lizard) {
            return true;
        }
        if (par1EntityLiving instanceof RubberDucky) {
            return true;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return true;
        }
        if (par1EntityLiving instanceof Girlfriend) {
            return true;
        }
        if (par1EntityLiving instanceof Boyfriend) {
            return true;
        }
        if (MyUtils.isAttackableNonMob((EntityLivingBase)par1EntityLiving)) {
            return true;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 6.0, 16.0));
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

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(Crab.class, this.boundingBox.expand(24.0, 8.0, 24.0));
        return var5.size();
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Crab")) continue;
                    this.setCrabScale(0.35f);
                    return true;
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5) {
            if (this.worldObj.rand.nextInt(40) != 1) {
                return false;
            }
            if (this.findBuddies() > 3) {
                return false;
            }
        }
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }
}

