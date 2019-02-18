/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.BetterFireball
 *  danger.orespawn.Dragonfly
 *  danger.orespawn.EntityMosquito
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.IceBall
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyEntityAIFollowOwner
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.PurplePower
 *  danger.orespawn.ThePrincess
 *  danger.orespawn.ThunderBolt
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSand
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveIndoors
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAITempt
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.BetterFireball;
import danger.orespawn.Dragonfly;
import danger.orespawn.EntityMosquito;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.IceBall;
import danger.orespawn.Mothra;
import danger.orespawn.MyEntityAIFollowOwner;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.PurplePower;
import danger.orespawn.ThunderBolt;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class ThePrincess
extends EntityTameable {
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter = null;
    public int activity = 1;
    private int owner_flying = 0;
    private float moveSpeed = 0.3f;
    private int syncit = 0;
    private int head1ext = 0;
    private int head2ext = 0;
    private int head3ext = 0;
    private int head1dir = 1;
    private int head2dir = 1;
    private int head3dir = 1;
    private int ok_to_grow = 0;
    private int kill_count = 0;
    private int fed_count = 0;
    private int day_count = 0;
    private int is_day = 0;
    private int attack_level = 1;
    private int ticker = 0;

    public ThePrincess(World par1World) {
        super(par1World);
        this.setSize(0.75f, 1.25f);
        this.moveSpeed = 0.32f;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.getNavigator().setAvoidsWater(true);
        this.setSitting(false);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner((EntityTameable)this, 1.15f, 12.0f, 2.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.beef, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 6.0f));
        this.tasks.addTask(5, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.experienceValue = 50;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.activity = 1;
        this.dataWatcher.addObject(22, (Object)0);
        this.dataWatcher.addObject(21, (Object)this.activity);
        this.dataWatcher.addObject(20, (Object)1);
        this.dataWatcher.addObject(23, (Object)this.attack_level);
        this.setSitting(false);
        this.setTamed(false);
        this.noClip = false;
    }

    public int getPower() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public void setPower(int par1) {
        this.dataWatcher.updateObject(23, (Object)par1);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
        par1NBTTagCompound.setInteger("SpyroGrow", this.ok_to_grow);
        par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
        par1NBTTagCompound.setInteger("SpyroFed", this.fed_count);
        par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
        this.dataWatcher.updateObject(21, (Object)this.activity);
        this.dataWatcher.updateObject(20, (Object)par1NBTTagCompound.getInteger("SpyroFire"));
        this.ok_to_grow = par1NBTTagCompound.getInteger("SpyroGrow");
        this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
        this.fed_count = par1NBTTagCompound.getInteger("SpyroFed");
        this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
    }

    public int getActivity() {
        int i;
        this.activity = i = this.dataWatcher.getWatchableObjectInt(21);
        return i;
    }

    public void setActivity(int par1) {
        this.activity = par1;
        this.dataWatcher.updateObject(21, (Object)0);
        this.dataWatcher.updateObject(21, (Object)par1);
    }

    public int getSpyroFire() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSpyroFire(int par1) {
        this.dataWatcher.updateObject(20, (Object)par1);
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setAttacking(int par1) {
        this.dataWatcher.updateObject(22, (Object)par1);
    }

    public int getHead1Ext() {
        return this.head1ext;
    }

    public int getHead2Ext() {
        return this.head2ext;
    }

    public int getHead3Ext() {
        return this.head3ext;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 400;
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.worldObj.isRemote) {
                this.setTamed(true);
                this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
                this.heal((float)this.mygetMaxHealth() - this.getHealth());
                this.ok_to_grow = 1;
                this.kill_count = 1000;
                this.fed_count = 1000;
                this.day_count = 1000;
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && var2.getItem() instanceof ItemFood) {
            if (!this.worldObj.isRemote) {
                ItemFood var3 = (ItemFood)var2.getItem();
                if ((float)this.mygetMaxHealth() > this.getHealth()) {
                    this.heal((float)(var3.func_150905_g(var2) * 10));
                }
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)6);
                this.setSpyroFire(0);
                String healthMessage = new String();
                healthMessage = String.format("Princess fireballs extinguished.", new Object[0]);
                par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)6);
                this.setSpyroFire(1);
                String healthMessage = new String();
                healthMessage = String.format("Princess fireballs lit!", new Object[0]);
                par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.isSitting()) {
                this.setSitting(true);
                this.setActivity(1);
            } else {
                this.setSitting(false);
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public void set_ok_to_grow() {
        this.ok_to_grow = 1;
        this.kill_count = 0;
        this.fed_count = 0;
        this.day_count = 0;
    }

    public boolean isWheat(ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.beef;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting()) {
            return null;
        }
        if (this.getAttacking() == 0) {
            return null;
        }
        return "orespawn:roar";
    }

    protected String getHurtSound() {
        return "orespawn:duck_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:cryo_death";
    }

    protected float getSoundVolume() {
        return 0.6f;
    }

    public int getTotalArmorValue() {
        return 14;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = 0;
        var3 = this.worldObj.rand.nextInt(4);
        for (int var4 = 0; var4 < ++var3; ++var4) {
            this.dropItem(Items.beef, 1);
        }
    }

    protected float getSoundPitch() {
        return (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f + 1.5f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    public float getAttackStrength(Entity par1Entity) {
        return 9.0f;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        EntityLivingBase el;
        float var2 = this.getAttackStrength(par1Entity);
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        if (par1Entity instanceof EntityLivingBase && (el = (EntityLivingBase)par1Entity).getHealth() <= 0.0f) {
            ++this.kill_count;
        }
        return var4;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType().equals("inWall")) {
            return false;
        }
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.setSitting(false);
            this.setActivity(2);
        }
        return ret;
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.75), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    public void onUpdate() {
        int i;
        super.onUpdate();
        this.noClip = this.getActivity() == 2;
        if (this.worldObj.rand.nextInt(10) == 1) {
            i = this.worldObj.rand.nextInt(3);
            if (i == 0) {
                this.head1dir = 2;
            }
            if (i == 1) {
                this.head1dir = -2;
            }
            if (i == 2) {
                this.head1dir = 0;
            }
        }
        if (this.worldObj.rand.nextInt(10) == 1) {
            i = this.worldObj.rand.nextInt(3);
            if (i == 0) {
                this.head2dir = 2;
            }
            if (i == 1) {
                this.head2dir = -2;
            }
            if (i == 2) {
                this.head2dir = 0;
            }
        }
        if (this.worldObj.rand.nextInt(10) == 1) {
            i = this.worldObj.rand.nextInt(3);
            if (i == 0) {
                this.head3dir = 2;
            }
            if (i == 1) {
                this.head3dir = -2;
            }
            if (i == 2) {
                this.head3dir = 0;
            }
        }
        this.head1ext += this.head1dir;
        if (this.head1ext < 0) {
            this.head1ext = 0;
        }
        if (this.head1ext > 60) {
            this.head1ext = 60;
        }
        this.head2ext += this.head2dir;
        if (this.head2ext < 0) {
            this.head2ext = 0;
        }
        if (this.head2ext > 60) {
            this.head2ext = 60;
        }
        this.head3ext += this.head3dir;
        if (this.head3ext < 0) {
            this.head3ext = 0;
        }
        if (this.head3ext > 60) {
            this.head3ext = 60;
        }
        if (this.worldObj.isRemote && this.getPower() > 400) {
            float f = 0.25f;
            if (this.worldObj.rand.nextInt(6) == 1) {
                for (i = 0; i < 2; ++i) {
                    this.worldObj.spawnParticle("fireworksSpark", this.posX - (double)f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + (double)f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                }
            }
        }
    }

    public void onLivingUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onLivingUpdate();
        if (this.isInWater()) {
            this.motionY += 0.07;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        ++this.syncit;
        if (this.syncit > 20) {
            this.syncit = 0;
            if (this.worldObj.isRemote) {
                this.getActivity();
            } else {
                int j = this.activity;
                this.setActivity(j);
            }
        }
        if (this.activity == 2) {
            this.motionY *= 0.6;
        }
    }

    protected void updateAITasks()
    {
      double xzoff = 1.5D;
      double yoff = 1.0D;
      EntityLiving newent = null;

      if (this.isDead) return;

      if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);

      if (this.activity != 2) {
        super.updateAITasks();
      }
      this.ticker += 1;
      if (this.ticker % 10 == 0) {
        setPower(this.attack_level);
      }

      if ((this.worldObj.rand.nextInt(200) == 1) && 
        (getHealth() < mygetMaxHealth())) {
        heal(1.0F);
      }

      if (!isTamed()) {
        EntityPlayer p = this.worldObj.getClosestPlayerToEntity(this, 10.0D);
        if (p != null) {
          setTamed(true);
          func_152115_b(p.getUniqueID().toString());
          playTameEffect(true);
          this.worldObj.setEntityState(this, (byte) 7);
          heal(mygetMaxHealth() - getHealth());
        }
      }

      this.attack_level += 1;
      if (getAttacking() != 0) {
        this.attack_level += 4;
      }

      if (getSpyroFire() == 0) this.attack_level = 0;

      if (this.attack_level > 500) {
        if (getAttacking() != 0) {
          int j = 3;
          for (int i = 0; i < j; i++) {
            Entity ppwr = spawnCreature(this.worldObj, "PurplePower", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));

            if (ppwr != null) {
              PurplePower p = (PurplePower)ppwr;
              p.motionX = (this.motionX * 3.0D);
              p.motionZ = (this.motionZ * 3.0D);
              p.setPurpleType(1 + this.worldObj.rand.nextInt(3));
            }
          }
        }

        if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
          for (int m = 0; m < 5; m++) {
            int i = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
            int k = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
            for (int j = -5; j < 5; j++) {
              Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k);
              if (bid == Blocks.grass) {
                if (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) != Blocks.air) break;
                int which = this.worldObj.rand.nextInt(8);
                if (which == 0) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.red_flower);
                if (which == 1) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.yellow_flower);
                if (which == 2) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerBlueBlock);
                if (which == 3) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerPinkBlock);
                if (which == 4) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerRedBlock);
                if (which == 5) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerGreenBlock);
                if (which == 6) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerBlueBlock);
                if (which != 7) break; this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerYellowBlock); break;
              }

              if ((bid == Blocks.dirt) && 
                (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air)) {
                this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, Blocks.grass);
                break;
              }

              if ((bid == Blocks.stone) && 
                (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air)) {
                this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.dirt);
                break;
              }

              if ((bid == Blocks.sand) && 
                (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air)) {
                if (this.worldObj.rand.nextInt(2) == 0) {
                  this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.cactus); break;
                }
                this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, Blocks.dirt);

                break;
              }

              if ((bid == Blocks.lava) && 
                (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air)) {
                this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, Blocks.water);
                break;
              }

              if ((bid == Blocks.flowing_lava) && 
                (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air)) {
                this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, Blocks.flowing_water);
                break;
              }

              if ((bid == Blocks.air) && (j > 0))
                break;
            }
          }
        }
        for (int m = 0; m < 2; m++) {
          int i = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
          int k = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
          int j = 1 + this.worldObj.rand.nextInt(4);
          Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k);
          if (bid == Blocks.air) {
            if (this.worldObj.rand.nextInt(2) == 0)
              newent = (EntityLiving)spawnCreature(this.worldObj, "Butterfly", this.posX + i, this.posY + j, this.posZ + k);
            else {
              newent = (EntityLiving)spawnCreature(this.worldObj, "Bird", this.posX + i, this.posY + j, this.posZ + k);
            }
          }
        }

        this.attack_level = 1;
      }

      if (!isSitting()) {
        if (this.activity == 0) {
          setActivity(1);
        }

        if (this.worldObj.rand.nextInt(100) == 1) {
          if (this.worldObj.rand.nextInt(20) == 1)
            setActivity(2);
          else {
            setActivity(1);
          }
        }

        this.owner_flying = 0;
        if ((isTamed()) && (getOwner() != null)) {
          EntityPlayer e = (EntityPlayer)getOwner();

          if (e.capabilities.isFlying) {
            this.owner_flying = 1;
            setActivity(2);
          }
        }

        if ((this.activity == 1) && (isTamed()) && (getOwner() != null)) {
          EntityLivingBase e = getOwner();

          if (getDistanceSqToEntity(e) > 256.0D)
          {
            setActivity(2);
          }
        }

        do_movement();
      }
      else if ((isTamed()) && (getOwner() != null)) {
        EntityLivingBase e = getOwner();

        if (getDistanceSqToEntity(e) > 256.0D)
        {
          setSitting(false);
          setActivity(2);
        }

      }

      if (this.is_day == 0) {
        this.is_day = 1;
        if (!this.worldObj.isDaytime()) this.is_day = -1; 
      }
      else {
        if ((this.is_day == -1) && 
          (this.worldObj.isDaytime()))
        {
          this.day_count += 1;
        }

        this.is_day = 1;
        if (!this.worldObj.isDaytime()) this.is_day = -1;
      }
    }


    private void do_movement() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 10;
        boolean do_new = false;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        boolean has_owner = false;
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        double pi = 3.1415926545;
        EntityLivingBase e = null;
        if (this.currentFlightTarget == null) {
            do_new = true;
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) {
            do_new = true;
        }
        if (this.isTamed() && this.getOwner() != null) {
            e = this.getOwner();
            has_owner = true;
            ox = e.posX;
            oy = e.posY + 1.0;
            oz = e.posZ;
            if (this.getDistanceSqToEntity((Entity)e) > 100.0) {
                do_new = true;
            }
            if (this.owner_flying != 0 && this.getDistanceSqToEntity((Entity)e) > 36.0) {
                do_new = true;
            }
        }
        if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                if (this.isTamed() && this.getHealth() / (float)this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(2);
                    this.setAttacking(0);
                    do_new = false;
                    this.currentFlightTarget.set((int)(this.posX + (this.posX - e.posX)), (int)(this.posY + 1.0), (int)(this.posZ + (this.posZ - e.posZ)));
                } else {
                    this.setActivity(2);
                    this.setAttacking(1);
                    this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0), (int)e.posZ);
                    do_new = false;
                    if (this.getDistanceSqToEntity((Entity)e) < (double)((3.0f + e.width / 2.0f) * (3.0f + e.width / 2.0f))) {
                        this.attackEntityAsMob((Entity)e);
                    } else if (!(this.getDistanceSqToEntity((Entity)e) <= 25.0 || this.getDistanceSqToEntity((Entity)e) >= 144.0 || this.isInWater() || this.getSpyroFire() == 0 || this.worldObj.rand.nextInt(3) != 0 && this.worldObj.rand.nextInt(4) != 1)) {
                        int which = this.worldObj.rand.nextInt(3);
                        if (which == 0) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rdd = Math.abs(rr - (rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f))) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            if ((rdd = Math.abs(rdd)) < 0.5) {
                                this.firecanon(e);
                            }
                        } else if (which == 1) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rdd = Math.abs(rr - (rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f))) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            if ((rdd = Math.abs(rdd)) < 0.5) {
                                this.firecanonl(e);
                            }
                        } else {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rdd = Math.abs(rr - (rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f))) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            if ((rdd = Math.abs(rdd)) < 0.5) {
                                this.firecanoni(e);
                            }
                        }
                    }
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.activity == 1) {
            return;
        }
        if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1f) {
            do_new = true;
        }
        if (do_new) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                int gox = (int)this.posX;
                int goy = (int)this.posY;
                int goz = (int)this.posZ;
                if (has_owner) {
                    gox = (int)ox;
                    goy = (int)oy;
                    goz = (int)oz;
                    if (this.owner_flying == 0) {
                        zdir = this.worldObj.rand.nextInt(4) + 6;
                        xdir = this.worldObj.rand.nextInt(4) + 6;
                    } else {
                        zdir = this.worldObj.rand.nextInt(8);
                        xdir = this.worldObj.rand.nextInt(8);
                    }
                } else {
                    zdir = this.worldObj.rand.nextInt(5) + 6;
                    xdir = this.worldObj.rand.nextInt(5) + 6;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = - zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = - xdir;
                }
                this.currentFlightTarget.set(gox + xdir, goy + (this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2), goz + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                --keep_trying;
            }
        }
        double speed_factor = 1.0;
        double var1 = (double)this.currentFlightTarget.posX + 0.5 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.5 - this.posZ;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.isTamed() && this.getOwner() != null && this.getDistanceSqToEntity((Entity)(e = this.getOwner())) > 49.0) {
                speed_factor = 3.5;
            }
        }
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.15 * speed_factor;
        this.motionY += (Math.signum(var3) * 0.7 - this.motionY) * 0.21 * speed_factor;
        this.motionZ += (Math.signum(var5) * 0.5 - this.motionZ) * 0.15 * speed_factor;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = (float)(0.75 * speed_factor);
        this.rotationYaw += var8 / 3.0f;
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
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (MyUtils.isRoyalty((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Dragonfly) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMosquito) {
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
            if (!this.isSuitableTarget(var4, false) || !this.canSeeTarget(var4.posX, var4.posY, var4.posZ)) continue;
            return var4;
        }
        return null;
    }

    private void firecanon(EntityLivingBase e) {
        double yoff = 1.0;
        double xzoff = 3.0;
        BetterFireball bf = null;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + (double)r1, e.posY + (double)(e.height / 2.0f) - (this.posY + yoff) + (double)r2, e.posZ - cz + (double)r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBig();
        if (this.worldObj.rand.nextInt(2) == 1) {
            bf.setSmall();
        }
        this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld((Entity)bf);
    }

    private void firecanonl(EntityLivingBase e) {
        double yoff = 1.0;
        double xzoff = 3.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
        var3 = e.posX - lb.posX;
        var5 = e.posY + 0.25 - lb.posY;
        var7 = e.posZ - lb.posZ;
        var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
        lb.setThrowableHeading(var3, var5 + (double)var9, var7, 1.4f, 4.0f);
        lb.motionX *= 3.0;
        lb.motionY *= 3.0;
        lb.motionZ *= 3.0;
        this.worldObj.spawnEntityInWorld((Entity)lb);
    }

    private void firecanoni(EntityLivingBase e) {
        double yoff = 1.0;
        double xzoff = 3.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
        lb.setIceMaker(1);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
        var3 = e.posX - lb.posX;
        var5 = e.posY + 0.25 - lb.posY;
        var7 = e.posZ - lb.posZ;
        var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
        lb.setThrowableHeading(var3, var5 + (double)var9, var7, 1.4f, 4.0f);
        lb.motionX *= 3.0;
        lb.motionY *= 3.0;
        lb.motionZ *= 3.0;
        this.worldObj.spawnEntityInWorld((Entity)lb);
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }
}

