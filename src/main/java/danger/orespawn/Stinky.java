/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyEntityAIFollowOwner
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Stinky
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockSand
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAvoidEntity
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveIndoors
 *  net.minecraft.entity.ai.EntityAIPanic
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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Mothra;
import danger.orespawn.MyEntityAIFollowOwner;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.OreSpawnMain;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIPanic;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Stinky
extends EntityTameable {
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter = null;
    public int activity = 1;
    private int owner_flying = 0;
    private float moveSpeed = 0.3f;
    private int skin_color = -1;
    private int syncit = 0;
    private int closest = 99999;
    private int tx = 0;
    private int ty = 0;
    private int tz = 0;

    public Stinky(World par1World) {
        super(par1World);
        this.setSize(0.75f, 0.75f);
        this.moveSpeed = 0.3f;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.getNavigator().setAvoidsWater(true);
        this.setSitting(false);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0f, 0.30000001192092896, 0.4000000059604645));
        this.tasks.addTask(3, (EntityAIBase)new MyEntityAIFollowOwner((EntityTameable)this, 1.15f, 12.0f, 2.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.beef, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.experienceValue = 35;
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
        this.setSitting(false);
        this.setTamed(false);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
        par1NBTTagCompound.setInteger("StinkySkin", this.dataWatcher.getWatchableObjectInt(22));
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
        this.dataWatcher.updateObject(21, (Object)this.activity);
        this.dataWatcher.updateObject(20, (Object)par1NBTTagCompound.getInteger("SpyroFire"));
        this.skin_color = par1NBTTagCompound.getInteger("StinkySkin");
        this.dataWatcher.updateObject(22, (Object)this.skin_color);
    }

    public int getActivity() {
        int i;
        this.activity = i = this.dataWatcher.getWatchableObjectInt(21);
        return i;
    }

    public void setActivity(int par1) {
        this.activity = par1;
        this.dataWatcher.updateObject(21, (Object)par1);
    }

    public int getSpyroFire() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSpyroFire(int par1) {
        this.dataWatcher.updateObject(20, (Object)par1);
    }

    public int getSkin() {
        int i;
        this.skin_color = i = this.dataWatcher.getWatchableObjectInt(22);
        return i;
    }

    public void setSkin(int par1) {
        this.skin_color = par1;
        this.dataWatcher.updateObject(22, (Object)0);
        this.dataWatcher.updateObject(22, (Object)par1);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 100;
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        this.setTamed(true);
                        this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState((Entity)this, (byte)7);
                        this.heal((float)this.mygetMaxHealth() - this.getHealth());
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState((Entity)this, (byte)6);
                    }
                }
            } else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                if ((float)this.mygetMaxHealth() > this.getHealth()) {
                    this.heal((float)this.mygetMaxHealth() - this.getHealth());
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.setHealth((float)this.mygetMaxHealth());
                this.func_152115_b("");
                this.playTameEffect(false);
                this.worldObj.setEntityState((Entity)this, (byte)6);
            }
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

    public boolean isWheat(ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.beef;
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.isTamed()) {
            return false;
        }
        return true;
    }

    protected String getLivingSound() {
        return null;
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
        return 6;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = 0;
        if (this.isTamed()) {
            var3 = this.worldObj.rand.nextInt(4);
            for (int var4 = 0; var4 < ++var3; ++var4) {
                this.dropItem(Items.beef, 1);
            }
        }
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1f + 1.5f : (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1f + 1.0f;
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
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.findBuddies() > 2) {
            return false;
        }
        return true;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    public float getAttackStrength(Entity par1Entity) {
        return 10.0f;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        float var2 = this.getAttackStrength(par1Entity);
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        return var4;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
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

    private void dropItemFront(Item index, int par1) {
        float f = 0.75f + Math.abs(this.worldObj.rand.nextFloat() * 0.75f);
        EntityItem var3 = new EntityItem(this.worldObj, this.posX - (double)f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 0.9, this.posZ + (double)f * Math.cos(Math.toRadians(this.rotationYawHead)), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    private void dropItemRear(Item index, int par1) {
        float f = 0.55f + Math.abs(this.worldObj.rand.nextFloat() * 0.55f);
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 0.25, this.posZ - (double)f * Math.cos(Math.toRadians(this.rotationYawHead)), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(1750) == 1) {
            this.playSound("random.burp", 1.0f, 1.0f);
            this.dropItemFront(Items.coal, 1);
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 2) {
            this.playSound("orespawn:fart", 1.0f, 1.5f);
            if (this.skin_color == 0) {
                this.dropItemRear(Items.blaze_powder, 1);
            }
            if (this.skin_color == 1) {
                this.dropItemRear(Items.rotten_flesh, 1);
            }
            if (this.skin_color == 2) {
                this.dropItemRear(Items.melon_seeds, 1);
            }
            if (this.skin_color == 3) {
                this.dropItemRear(OreSpawnMain.UraniumNugget, 1);
            }
            if (this.skin_color == 4) {
                this.dropItemRear(Items.wheat, 1);
            }
            if (this.skin_color == 5) {
                this.dropItemRear(Items.brick, 1);
            }
            if (this.skin_color == 6) {
                this.dropItemRear(Item.getItemFromBlock((Block)Blocks.torch), 1);
            }
            if (this.skin_color == 7) {
                this.dropItemRear(Items.emerald, 1);
            }
            if (this.skin_color == 8) {
                this.dropItemRear(Items.gold_ingot, 1);
            }
            if (this.skin_color == 9) {
                this.dropItemRear(Item.getItemFromBlock((Block)Blocks.leaves), 1);
            }
            if (this.skin_color == 10) {
                this.dropItemRear(OreSpawnMain.TitaniumNugget, 1);
            }
            if (this.skin_color == 11) {
                this.dropItemRear(OreSpawnMain.MyAppleSeed, 1);
            }
            if (this.skin_color == 12) {
                this.dropItemRear(Items.diamond, 1);
            }
            if (this.skin_color == 13) {
                this.dropItemRear(Item.getItemFromBlock((Block)Blocks.sand), 1);
            }
            if (this.skin_color == 14) {
                this.dropItemRear(Item.getItemFromBlock((Block)Blocks.cobblestone), 1);
            }
            if (this.skin_color == 15) {
                this.dropItemRear(Items.bone, 1);
            }
            if (this.skin_color == 16) {
                this.dropItemRear(Items.string, 1);
            }
            if (this.skin_color == 17) {
                this.dropItemRear(OreSpawnMain.MyCherrySeed, 1);
            }
            if (this.skin_color == 18) {
                this.dropItemRear(OreSpawnMain.MyPeachSeed, 1);
            }
        }
    }

    public void onLivingUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onLivingUpdate();
        if (this.isInWater()) {
            this.motionY += 0.07;
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 1) {
            int i = this.worldObj.rand.nextInt(19);
            this.setSkin(i);
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.skin_color < 0) {
            this.skin_color = this.worldObj.rand.nextInt(19);
        }
        ++this.syncit;
        if (this.syncit > 20) {
            this.syncit = 0;
            if (this.worldObj.isRemote) {
                this.getActivity();
                this.getSkin();
            } else {
                int j = this.activity;
                this.setActivity(j);
                j = this.skin_color;
                this.setSkin(j);
            }
        }
        if (this.activity == 2) {
            this.motionY *= 0.6;
        }
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
                if (bid == Blocks.coal_ore && (d = dx * dx + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + dx;
                    this.ty = y + i;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x - dx, y + i, z + j)) != Blocks.coal_ore || (d = dx * dx + j * j + i * i) >= this.closest) continue;
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
                if (bid == Blocks.coal_ore && (d = dy * dy + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + dy;
                    this.tz = z + j;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y - dy, z + j)) != Blocks.coal_ore || (d = dy * dy + j * j + i * i) >= this.closest) continue;
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
                if (bid == Blocks.coal_ore && (d = dz * dz + j * j + i * i) < this.closest) {
                    this.closest = d;
                    this.tx = x + i;
                    this.ty = y + j;
                    this.tz = z + dz;
                    ++found;
                }
                if ((bid = this.worldObj.getBlock(x + i, y + j, z - dz)) != Blocks.coal_ore || (d = dz * dz + j * j + i * i) >= this.closest) continue;
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

    protected void updateAITasks()
    {
      if (this.isDead) return;

      if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);

      if (this.activity != 2) {
        super.updateAITasks();
      }

      if ((this.worldObj.rand.nextInt(100) == 1) && 
        (getHealth() < mygetMaxHealth())) {
        heal(1.0F);
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
    }
    private void do_movement() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        boolean do_new = false;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        boolean has_owner = false;
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
            oy = e.posY;
            oz = e.posZ;
            if (this.getDistanceSqToEntity((Entity)e) > 100.0) {
                do_new = true;
            }
            if (this.owner_flying != 0 && this.getDistanceSqToEntity((Entity)e) > 36.0) {
                do_new = true;
            }
        }
        if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && (e = this.findSomethingToAttack()) != null) {
            if (this.isTamed() && this.getHealth() / (float)this.mygetMaxHealth() < 0.25f) {
                this.setActivity(2);
                do_new = false;
                this.currentFlightTarget.set((int)(this.posX + (this.posX - e.posX)), (int)(this.posY + 1.0), (int)(this.posZ + (this.posZ - e.posZ)));
            } else {
                this.setActivity(2);
                this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0), (int)e.posZ);
                do_new = false;
                if (this.getDistanceSqToEntity((Entity)e) < (double)((3.0f + e.width / 2.0f) * (3.0f + e.width / 2.0f))) {
                    this.attackEntityAsMob((Entity)e);
                }
            }
        }
        if (this.activity == 1) {
            if (this.worldObj.rand.nextInt(50) == 0 && OreSpawnMain.PlayNicely == 0) {
                this.closest = 99999;
                this.tz = 0;
                this.ty = 0;
                this.tx = 0;
                for (int i = 1; i < 9; ++i) {
                    int j = i;
                    if (j > 2) {
                        j = 2;
                    }
                    if (this.scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i)) break;
                    if (i < 4) continue;
                    ++i;
                }
                if (this.closest < 99999) {
                    this.getNavigator().tryMoveToXYZ((double)this.tx, (double)this.ty, (double)this.tz, 1.25);
                    if (this.closest < 12) {
                        this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                        this.heal(1.0f);
                        this.playSound("random.burp", 0.5f, this.worldObj.rand.nextFloat() * 0.2f + 1.5f);
                    }
                }
            }
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
                this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2, goz + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
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
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMob) {
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

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(Stinky.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}

