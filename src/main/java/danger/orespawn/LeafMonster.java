/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EntityAnt
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.EntityLunaMoth
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.LeafMonster
 *  danger.orespawn.MobStats
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.EntityAnt;
import danger.orespawn.EntityButterfly;
import danger.orespawn.EntityLunaMoth;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MobStats;
import danger.orespawn.OreSpawnMain;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class LeafMonster
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private float moveSpeed = 0.25f;

    public LeafMonster(World par1World) {
        super(par1World);
        this.setSize(1.0f, 2.5f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 5;
        this.fireResistance = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.LeafMonster_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public final void setAttacking(int par1) {
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.LeafMonster_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.LeafMonster_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void fall(float par1) {
        float i = MathHelper.ceiling_float_int((float)(par1 - 3.0f));
        if (i > 0.0f) {
            if (i > 2.0f) {
                this.playSound("damage.fallbig", 1.0f, 1.0f);
                i = 2.0f;
            } else {
                this.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, i);
        }
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
        if (this.getAttacking() == 0) {
            int px = (int)this.posX;
            int py = (int)this.posY;
            int pz = (int)this.posZ;
            this.posX = px;
            this.posY = py;
            this.posZ = pz;
            if (this.posX > 0.0) {
                this.posX += 0.5;
            }
            if (this.posZ > 0.0) {
                this.posZ += 0.5;
            }
            if (this.posX < 0.0) {
                this.posX -= 0.5;
            }
            if (this.posZ < 0.0) {
                this.posZ -= 0.5;
            }
            this.rotationPitch = 0.0f;
            px = (int)this.rotationYawHead;
            this.rotationYaw = this.rotationYawHead = (float)((px /= 90) * 90);
        }
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:leaves_hit";
    }

    protected String getDeathSound() {
        return "orespawn:leaves_death";
    }

    protected float getSoundVolume() {
        return 0.65f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        int i = this.worldObj.rand.nextInt(3);
        if (i == 0) {
            return Item.getItemFromBlock((Block)Blocks.log);
        }
        if (i == 1) {
            return Item.getItemFromBlock((Block)Blocks.leaves);
        }
        return Items.rotten_flesh;
    }

    protected void updateAITasks() {
        super.updateAITasks();
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(100) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(4) == 1) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                this.setAttacking(1);
                this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.25);
                if (this.getDistanceSqToEntity((Entity)e) < 5.0 && (this.rand.nextInt(8) == 0 || this.rand.nextInt(10) == 1)) {
                    this.attackEntityAsMob((Entity)e);
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
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityAnt) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof EntityLunaMoth) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (!p.capabilities.isCreativeMode) {
                return true;
            }
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(4.0, 6.0, 4.0));
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
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Leaf Monster")) continue;
                    return true;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4 ? this.posY > 20.0 : this.posY < 50.0) {
            return false;
        }
        if (this.findBuddies() > 4) {
            return false;
        }
        return true;
    }

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(LeafMonster.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }
}

