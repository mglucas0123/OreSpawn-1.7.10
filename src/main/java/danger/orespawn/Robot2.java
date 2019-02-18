/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.Robot2
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockChest
 *  net.minecraft.block.BlockPistonBase
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
 *  net.minecraft.entity.ai.EntitySenses
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
import danger.orespawn.RenderInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockPistonBase;
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
import net.minecraft.entity.ai.EntitySenses;
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

public class Robot2
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private int just_for_fun = 0;
    private float moveSpeed = 0.3f;

    public Robot2(World par1World) {
        super(par1World);
        this.setSize(3.0f, 6.2f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 100;
        this.fireResistance = 200;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Robot2_stats.attack);
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
        return OreSpawnMain.Robot2_stats.health;
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
        return OreSpawnMain.Robot2_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void jump() {
        this.motionY += 0.25;
        super.jump();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return "orespawn:robot_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:robot_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:robot_death";
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block)Blocks.iron_block);
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
        int var4;
        ItemStack is = null;
        int var5 = 2 + this.worldObj.rand.nextInt(8);
        for (var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Item.getItemFromBlock((Block)Blocks.iron_block), 1);
        }
        var5 = 5 + this.worldObj.rand.nextInt(6);
        for (var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.iron_ingot, 1);
        }
        int i = 5 + this.worldObj.rand.nextInt(10);
        block14 : for (var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(15);
            switch (var3) {
                case 0: {
                    is = this.dropItemRand(Items.redstone, 1);
                    continue block14;
                }
                case 1: {
                    is = this.dropItemRand(Items.repeater, 1);
                    continue block14;
                }
                case 2: {
                    is = this.dropItemRand(Items.comparator, 1);
                    continue block14;
                }
                case 3: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.redstone_block), 1);
                    continue block14;
                }
                case 4: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.dispenser), 1);
                    continue block14;
                }
                case 5: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
                    continue block14;
                }
                case 6: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
                    continue block14;
                }
                case 7: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.lever), 1);
                    continue block14;
                }
                case 8: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.redstone_block), 1);
                    continue block14;
                }
                case 9: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.light_weighted_pressure_plate), 1);
                    break;
                }
            }
        }
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void destroyBlock(EntityLivingBase e) {
        double z;
        double y;
        double x = e.posX + (double)this.worldObj.rand.nextFloat() - (double)this.worldObj.rand.nextFloat();
        Block bid = this.worldObj.getBlock((int)x, (int)(y = e.posY - 1.0), (int)(z = e.posZ + (double)this.worldObj.rand.nextFloat() - (double)this.worldObj.rand.nextFloat()));
        if (bid == Blocks.obsidian) {
            return;
        }
        if (bid == Blocks.bedrock) {
            return;
        }
        if (bid == Blocks.quartz_block) {
            return;
        }
        if (bid == Blocks.mob_spawner) {
            return;
        }
        if (bid == Blocks.redstone_block) {
            return;
        }
        if (bid == Blocks.iron_block) {
            return;
        }
        if (bid == Blocks.chest) {
            return;
        }
        if (bid != Blocks.air && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
            this.worldObj.setBlock((int)x, (int)y, (int)z, Blocks.air);
        }
    }

    protected void destroyNearbyBlocks() {
        for (int i = 0; i < 50; ++i) {
            double y;
            double z;
            double x = this.posX + (double)this.worldObj.rand.nextFloat() * 6.5 - (double)this.worldObj.rand.nextFloat() * 6.5;
            Block bid = this.worldObj.getBlock((int)x, (int)(y = this.posY + 0.1 + (double)this.worldObj.rand.nextFloat() * 8.5), (int)(z = this.posZ + (double)this.worldObj.rand.nextFloat() * 6.5 - (double)this.worldObj.rand.nextFloat() * 6.5));
            if (bid == Blocks.obsidian || bid == Blocks.bedrock || bid == Blocks.quartz_block || bid == Blocks.mob_spawner || bid == Blocks.redstone_block || bid == Blocks.iron_block || bid == Blocks.chest || bid == Blocks.air || !this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) continue;
            this.worldObj.setBlock((int)x, (int)y, (int)z, Blocks.air);
        }
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(6) == 1 && OreSpawnMain.PlayNicely == 0) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(50) == 1) {
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
                double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                double rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                double pi = 3.1415926545;
                double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                if (rdd > pi) {
                    rdd -= pi * 2.0;
                }
                rdd = Math.abs(rdd);
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (rdd < 1.25) {
                    if (this.getDistanceSqToEntity((Entity)e) < (double)((5.0f + e.width / 2.0f) * (5.0f + e.width / 2.0f))) {
                        this.setAttacking(1);
                        if (this.worldObj.rand.nextInt(5) == 0 || this.worldObj.rand.nextInt(6) == 1) {
                            this.attackEntityAsMob((Entity)e);
                            for (int i = 0; i < 6; ++i) {
                                this.destroyBlock(e);
                            }
                        }
                        this.destroyNearbyBlocks();
                    }
                } else {
                    this.setAttacking(0);
                }
                this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.0);
            } else {
                this.setAttacking(0);
            }
        }
        if (this.getAttacking() == 0 && OreSpawnMain.PlayNicely == 0) {
            if (this.worldObj.rand.nextInt(450) == 1) {
                this.just_for_fun = 50;
            }
            if (this.just_for_fun > 0) {
                --this.just_for_fun;
            }
            if (this.just_for_fun > 0) {
                this.setAttacking(1);
                if (this.worldObj.rand.nextInt(3) == 1) {
                    this.destroyNearbyBlocks();
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
            Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase)((EntityLiving)e));
                this.setTarget(e);
                this.getNavigator().tryMoveToEntityLiving((Entity)((EntityLiving)e), 1.2);
            }
            return ret;
        }
        return false;
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
      List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(14.0D, 3.0D, 14.0D));
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
                    if (s == null || !s.equals("Robo-Pounder")) continue;
                    return true;
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (k = -1; k < 1; ++k) {
            for (j = -1; j <= 1; ++j) {
                for (i = 1; i < 6; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air || bid == Blocks.tallgrass) continue;
                    return false;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        return true;
    }
}

