/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MobStats
 *  danger.orespawn.Molenoid
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockSand
 *  net.minecraft.block.BlockTallGrass
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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
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
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class Molenoid
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private float moveSpeed = 0.35f;

    public Molenoid(World par1World) {
        super(par1World);
        this.setSize(3.9f, 2.6f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 40;
        this.fireResistance = 100;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Molenoid_stats.attack);
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

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Molenoid_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Molenoid_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(3) == 0) {
            return "orespawn:molenoid_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:molenoid_hit";
    }

    protected String getDeathSound() {
        return "orespawn:molenoid_death";
    }

    protected float getSoundVolume() {
        return 1.1f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        this.dropItemRand(OreSpawnMain.MolenoidNose, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.beef, 1);
        }
    }

    public void initCreature() {
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (par1DamageSource.getDamageType().equals("inWall")) {
            return false;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                double ks = 0.8;
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

    protected void updateAITasks() {
        double dx;
        double dz;
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(4) == 0) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity)e) < (double)((6.0f + e.width / 2.0f) * (6.0f + e.width / 2.0f))) {
                    this.setAttacking(1);
                    if (this.getDistanceSqToEntity((Entity)e) < 16.0 && (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)) {
                        this.attackEntityAsMob((Entity)e);
                    } else if (OreSpawnMain.PlayNicely == 0) {
                        int j = 1 + this.worldObj.rand.nextInt(4);
                        block0 : for (int k = 0; k < j; ++k) {
                            dx = e.posX;
                            dz = e.posZ;
                            dx += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                            dz += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                            for (int i = 4; i > -3; --i) {
                                if (this.worldObj.getBlock((int)dx, (int)e.posY + i + 1, (int)dz) != Blocks.air || this.worldObj.getBlock((int)dx, (int)e.posY + i, (int)dz) == Blocks.air) continue;
                                this.worldObj.setBlock((int)dx, (int)e.posY + i + 1, (int)dz, OreSpawnMain.MyMoleDirtBlock);
                                continue block0;
                            }
                        }
                    }
                } else {
                    this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.25);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.worldObj.rand.nextInt(2) == 0) {
            int odds;
            double spd = 0.0;
            spd = this.motionX * this.motionX + this.motionZ * this.motionZ;
            if ((spd = Math.sqrt(spd)) > (double)this.moveSpeed) {
                spd = this.moveSpeed;
            }
            if ((odds = (int)(100.0 * spd / (double)this.moveSpeed)) > 0 && this.worldObj.rand.nextInt(100) < odds && OreSpawnMain.PlayNicely == 0) {
                dx = this.posX + 6.0 * Math.sin(Math.toRadians(this.rotationYawHead));
                dz = this.posZ - 6.0 * Math.cos(Math.toRadians(this.rotationYawHead));
                dx += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
                dz += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
                for (int i = 4; i > -4; --i) {
                    if (this.worldObj.getBlock((int)dx, (int)this.posY + i + 1, (int)dz) != Blocks.air || this.worldObj.getBlock((int)dx, (int)this.posY + i, (int)dz) == Blocks.air) continue;
                    this.worldObj.setBlock((int)dx, (int)this.posY + i + 1, (int)dz, OreSpawnMain.MyMoleDirtBlock);
                    break;
                }
            }
        }
        dx = this.posX - 3.0 * Math.sin(Math.toRadians(this.rotationYawHead));
        dz = this.posZ + 3.0 * Math.cos(Math.toRadians(this.rotationYawHead));
        dx += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
        dz += (double)(this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
        int dir = 1;
        if (e != null) {
            if ((int)e.posY > (int)this.posY) {
                dir = 2;
            }
            if ((int)e.posY < (int)this.posY) {
                dir = 0;
            }
        }
        if (OreSpawnMain.PlayNicely == 0) {
            for (int i = dir; i < dir + 3; ++i) {
                Block bid = this.worldObj.getBlock((int)dx, (int)this.posY + i, (int)dz);
                if ((bid == Blocks.dirt || bid == Blocks.grass || bid == Blocks.gravel || bid == Blocks.sand || bid == Blocks.leaves) && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    this.worldObj.setBlock((int)dx, (int)this.posY + i, (int)dz, Blocks.air);
                }
                if (bid != OreSpawnMain.MyMoleDirtBlock) continue;
                this.worldObj.setBlock((int)dx, (int)this.posY + i, (int)dz, Blocks.air);
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
        if (!this.MyCanSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            return true;
        }
        if (par1EntityLiving instanceof Molenoid) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
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
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 6.0, 12.0));
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
                    if (s == null || !s.equals("Molenoid")) continue;
                    return true;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (k = -1; k < 1; ++k) {
            for (j = -1; j < 1; ++j) {
                for (i = 1; i < 4; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        Molenoid target = null;
        target = (Molenoid)this.worldObj.findNearestEntityWithinAABB(Molenoid.class, this.boundingBox.expand(16.0, 8.0, 16.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    public boolean MyCanSee(EntityLivingBase e) {
        double xzoff = 2.0;
        int nblks = 10;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        float startx = (float)cx;
        float starty = (float)(this.posY + 1.0);
        float startz = (float)cz;
        float dx = (float)((e.posX - (double)startx) / 10.0);
        float dy = (float)((e.posY + (double)(e.height / 2.0f) - (double)starty) / 10.0);
        float dz = (float)((e.posZ - (double)startz) / 10.0);
        if ((double)Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks = (int)((float)nblks * Math.abs(dx));
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if ((double)Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks = (int)((float)nblks * Math.abs(dy));
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if ((double)Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks = (int)((float)nblks * Math.abs(dz));
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            Block bid = this.worldObj.getBlock((int)(startx += dx), (int)(starty += dy), (int)(startz += dz));
            if (bid == Blocks.air || bid == OreSpawnMain.MyMoleDirtBlock || bid == Blocks.dirt || bid == Blocks.grass || bid == Blocks.tallgrass || bid == Blocks.sand || bid == Blocks.gravel) continue;
            return false;
        }
        return true;
    }
}

