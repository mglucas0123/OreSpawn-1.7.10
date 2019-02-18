/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.GiantRobot
 *  danger.orespawn.LaserBall
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderGiantRobotInfo
 *  net.minecraft.block.Block
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
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.LaserBall;
import java.util.Iterator;
import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RenderGiantRobotInfo;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GiantRobot
extends EntityMob {
    private GenericTargetSorter TargetSorter = null;
    private RenderGiantRobotInfo renderdata = new RenderGiantRobotInfo();
    private int reload_ticker = 0;
    private float moveSpeed = 0.55f;

    public GiantRobot(World par1World) {
        super(par1World);
        this.setSize(3.0f, 9.75f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = OreSpawnMain.Jeffery_stats.health / 2;
        this.fireResistance = 40;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderGiantRobotInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Jeffery_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
        this.initLegData();
    }

    private void initLegData() {
        if (this.renderdata == null) {
            this.renderdata = new RenderGiantRobotInfo();
        }
        this.renderdata.hipydisplayangle = 0.0f;
        this.renderdata.hipxdisplayangle = 0.0f;
        this.renderdata.gpcounter = 2000000;
        this.renderdata.thighdisplayangle[0] = 0.0f;
        this.renderdata.thighdisplayangle[1] = 0.0f;
        this.renderdata.shindisplayangle[0] = 0.0f;
        this.renderdata.shindisplayangle[1] = 0.0f;
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
        return OreSpawnMain.Jeffery_stats.health;
    }

    public RenderGiantRobotInfo getRenderGiantRobotInfo() {
        return this.renderdata;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Jeffery_stats.defense;
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
        return Items.iron_ingot;
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
        int var5 = 15 + this.worldObj.rand.nextInt(15);
        for (var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(OreSpawnMain.MyLaserBall, 4);
        }
        int i = 10 + this.worldObj.rand.nextInt(10);
        block13 : for (var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(12);
            switch (var3) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.SpiderRobotKit, 1);
                    continue block13;
                }
                case 1: {
                    is = this.dropItemRand(OreSpawnMain.AntRobotKit, 1);
                    continue block13;
                }
                case 2: {
                    is = this.dropItemRand(OreSpawnMain.MyRayGun, 1);
                    continue block13;
                }
                case 3: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.redstone_block), 1);
                    continue block13;
                }
                case 4: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.dispenser), 1);
                    continue block13;
                }
                case 5: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
                    continue block13;
                }
                case 6: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
                    continue block13;
                }
                case 7: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.lever), 1);
                    continue block13;
                }
                case 8: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.iron_block), 1);
                    continue block13;
                }
                case 9: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.detector_rail), 1);
                    break;
                }
            }
        }
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        double ks = 2.2;
        double inair = 0.25;
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
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
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.reload_ticker > 0) {
            --this.reload_ticker;
        }
        if (this.worldObj.rand.nextInt(5) == 0) {
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
                if (this.getDistanceSqToEntity((Entity)e) < 256.0) {
                    double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                    double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                    double pi = 3.1415926545;
                    double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                    if (rdd > pi) {
                        rdd -= pi * 2.0;
                    }
                    if ((rdd = Math.abs(rdd)) < 0.5) {
                        if (this.reload_ticker == 0) {
                            double yoff = 10.0;
                            double xzoff = 3.75;
                            LaserBall var2 = new LaserBall(this.worldObj, e.posX - this.posX, e.posY - (this.posY + yoff), e.posZ - this.posZ);
                            var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)), this.rotationYawHead, this.rotationPitch);
                            double var3 = e.posX - var2.posX;
                            double var5 = e.posY - var2.posY;
                            double var7 = e.posZ - var2.posZ;
                            float var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
                            var2.setThrowableHeading(var3, var5 + (double)var9, var7, 2.0f, 4.0f);
                            if (this.getDistanceSqToEntity((Entity)e) > 100.0) {
                                var2.setSpecial();
                                this.reload_ticker = 25;
                                this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 3.5f, 0.5f);
                            } else {
                                this.reload_ticker = 10;
                                this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 2.5f, 1.0f);
                            }
                            this.worldObj.spawnEntityInWorld((Entity)var2);
                        }
                        if (this.getDistanceSqToEntity((Entity)e) < (double)((8.0f + e.width / 2.0f) * (8.0f + e.width / 2.0f))) {
                            this.setAttacking(1);
                            this.attackEntityAsMob((Entity)e);
                        } else {
                            this.setAttacking(0);
                        }
                    }
                    this.getNavigator().tryMoveToEntityLiving((Entity)e, 0.5);
                } else {
                    this.setAttacking(0);
                }
            } else {
                this.setAttacking(0);
            }
        }
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity e;
        boolean ret = false;
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
        }
        if ((e = par1DamageSource.getEntity()) != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase)((EntityLiving)e));
            this.setTarget(e);
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
      List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 12.0D, 16.0D));
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
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 6; ++i) {
                    Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
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

