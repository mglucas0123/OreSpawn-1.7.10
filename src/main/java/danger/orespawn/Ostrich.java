/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.EntityCannonFodder
 *  danger.orespawn.MyEntityAIAvoidEntity
 *  danger.orespawn.MyEntityAIFollowOwner
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Ostrich
 *  danger.orespawn.RenderInfo
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockSand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMate
 *  net.minecraft.entity.ai.EntityAIMoveIndoors
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAITempt
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
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
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.EntityCannonFodder;
import danger.orespawn.MyEntityAIAvoidEntity;
import danger.orespawn.MyEntityAIFollowOwner;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RenderInfo;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Ostrich
extends EntityCannonFodder {
    private float moveSpeed = 0.2f;
    private RenderInfo renderdata = new RenderInfo();
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    float deltasmooth = 0.0f;
    private int didjump = 0;

    public Ostrich(World par1World) {
        super(par1World);
        this.setSize(0.85f, 2.1f);
        this.moveSpeed = 0.38f;
        this.fireResistance = 100;
        this.getNavigator().setAvoidsWater(true);
        this.setSitting(false);
        this.experienceValue = 10;
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner((EntityTameable)this, 2.0f, 10.0f, 2.0f));
        this.tasks.addTask(3, (EntityAIBase)new MyEntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0f, 1.0, 1.899999976158142));
        this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158, Items.apple, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 5.0f));
        this.tasks.addTask(8, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.setSitting(false);
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

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            super.attackEntityFrom(par1DamageSource, par2);
        }
        return false;
    }

    protected void updateAITick() {
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(250) == 0) {
            this.heal(1.0f);
        }
        if (this.riddenByEntity != null) {
            return;
        }
        super.updateAITick();
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public int mygetMaxHealth() {
        return 25;
    }

    public int getOstrichHealth() {
        return (int)this.getHealth();
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(2) == 0) {
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
        if (var2 != null && this.isTamed() && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.worldObj.isRemote) {
                if (!this.isSitting()) {
                    Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ);
                    if (bid == Blocks.sand || bid == Blocks.gravel || bid == Blocks.dirt || bid == Blocks.farmland || bid == Blocks.grass) {
                        this.setSitting(true);
                    }
                } else {
                    this.setSitting(false);
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
        if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.worldObj.isRemote) {
                par1EntityPlayer.mountEntity((Entity)this);
                this.setSitting(false);
            }
            return true;
        }
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting()) {
            return null;
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:cryo_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:cryo_death";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return Items.feather;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = 0;
        if (this.isTamed()) {
            var3 = this.rand.nextInt(5);
            for (int var4 = 0; var4 < (var3 += 2); ++var4) {
                this.dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
            }
        } else {
            super.dropFewItems(par1, par2);
        }
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 1.5f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 1.0f;
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public int getTrackingRange() {
        return 128;
    }

    public int getUpdateFrequency() {
        return 10;
    }

    public boolean sendsVelocityUpdates() {
        return true;
    }

    protected void jump() {
        this.motionY += 0.25;
        super.jump();
    }

    public double getMountedYOffset() {
        return 1.4;
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.rand.nextInt(4) != 1) {
            return false;
        }
        Ostrich target = null;
        target = (Ostrich)this.worldObj.findNearestEntityWithinAABB(Ostrich.class, this.boundingBox.expand(16.0, 6.0, 16.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.boatPosRotationIncrements = 10;
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.boatYawHead = par9;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double par1, double par3, double par5) {
        this.velocityX = this.motionX = par1;
        this.velocityY = this.motionY = par3;
        this.velocityZ = this.motionZ = par5;
    }

    public void onLivingUpdate() {
        Object list = null;
        Object listEntity = null;
        double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        double d7 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.75;
        double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
        if (this.riddenByEntity == null && !this.worldObj.isRemote) {
            super.onLivingUpdate();
            return;
        }
        if (this.isDead) {
            return;
        }
        if (this.riddenByEntity == null) {
            float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
            float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
            this.rotationYaw += var8 / 5.0f;
        }
        if (this.worldObj.isRemote) {
            if (this.boatPosRotationIncrements > 0) {
                double d4 = this.posX + (this.boatX - this.posX) / (double)this.boatPosRotationIncrements;
                double d5 = this.posY + (this.boatY - this.posY) / (double)this.boatPosRotationIncrements;
                double d11 = this.posZ + (this.boatZ - this.posZ) / (double)this.boatPosRotationIncrements;
                this.setPosition(d4, d5, d11);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.boatPitch - (double)this.rotationPitch) / (double)this.boatPosRotationIncrements);
                double d10 = MathHelper.wrapAngleTo180_double((double)(this.boatYaw - (double)this.rotationYaw));
                if (this.riddenByEntity != null) {
                    d10 = MathHelper.wrapAngleTo180_double((double)((double)this.riddenByEntity.rotationYaw - (double)this.rotationYaw));
                }
                this.rotationYaw = (float)((double)this.rotationYaw + d10 / (double)this.boatPosRotationIncrements);
                this.setRotation(this.rotationYaw, this.rotationPitch);
                --this.boatPosRotationIncrements;
            }
        } else if (this.riddenByEntity != null) {
            double rdv;
            EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
            if (this.motionX < -2.0) {
                this.motionX = -2.0;
            }
            if (this.motionX > 2.0) {
                this.motionX = 2.0;
            }
            if (this.motionZ < -2.0) {
                this.motionZ = -2.0;
            }
            if (this.motionZ > 2.0) {
                this.motionZ = 2.0;
            }
            double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            obstruction_factor = 0.0;
            dist = 1 + (int)(velocity * 10.0);
            for (int k = 0; k < dist; ++k) {
                for (int i = 1; i < dist * 2; ++i) {
                    double dz;
                    double dx = (double)i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                    Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - 1 + k, (int)(this.posZ + (dz = (double)i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f)))));
                    if (bid == Blocks.air) continue;
                    obstruction_factor += 0.075;
                }
            }
            this.motionY += obstruction_factor;
            this.posY += obstruction_factor;
            if (this.motionY > 4.0) {
                this.motionY = 4.0;
            }
            double d4 = this.riddenByEntity.rotationYaw;
            d4 %= 360.0;
            while (d4 < 0.0) {
                d4 += 360.0;
            }
            double d5 = this.rotationYaw;
            d5 %= 360.0;
            while (d5 < 0.0) {
                d5 += 360.0;
            }
            for (relative_g = (d4 - d5) % 180.0; relative_g < 0.0; relative_g += 180.0) {
            }
            if (relative_g > 90.0) {
                relative_g -= 180.0;
            }
            if (velocity > 0.01) {
                d4 = 1.85 - velocity;
                if ((d4 = Math.abs(d4)) < 0.01) {
                    d4 = 0.01;
                }
                if (d4 > 0.9) {
                    d4 = 0.9;
                }
                this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
            } else {
                this.rotationYaw = this.riddenByEntity.rotationYaw;
            }
            this.rotationPitch = 2.0f * (float)velocity;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
            double rhm = Math.atan2(this.motionZ, this.motionX);
            double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
            rt = 0.0;
            pi = 3.1415926545;
            deltav = 0.0;
            float im = pp.moveForward;
            if (OreSpawnMain.flyup_keystate != 0) {
                if (this.didjump == 0) {
                    this.motionY += 1.0;
                    this.motionY += velocity * 6.0;
                    this.didjump = 20;
                }
            } else if (this.didjump > 0) {
                --this.didjump;
            }
            if ((rdv = Math.abs(rhm - rhdir) % (pi * 2.0)) > pi) {
                rdv -= pi * 2.0;
            }
            rdv = Math.abs(rdv);
            if (Math.abs(newvelocity) < 0.01) {
                rdv = 0.0;
            }
            if (rdv > 1.5) {
                newvelocity = - newvelocity;
            }
            if (Math.abs(im) > 0.001f) {
                if (im > 0.0f) {
                    deltav = 0.045;
                    if (this.deltasmooth < 0.0f) {
                        this.deltasmooth = 0.0f;
                    }
                    this.deltasmooth = (float)((double)this.deltasmooth + deltav / 10.0);
                    if ((double)this.deltasmooth > deltav) {
                        this.deltasmooth = (float)deltav;
                    }
                } else {
                    max_speed = 0.25;
                    deltav = -0.03;
                    if (this.deltasmooth > 0.0f) {
                        this.deltasmooth = 0.0f;
                    }
                    this.deltasmooth = (float)((double)this.deltasmooth + deltav / 10.0);
                    if ((double)this.deltasmooth < deltav) {
                        this.deltasmooth = (float)deltav;
                    }
                }
                if ((newvelocity += (double)this.deltasmooth) >= 0.0) {
                    if (newvelocity > max_speed) {
                        newvelocity = max_speed;
                    }
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                } else {
                    if (newvelocity < - max_speed) {
                        newvelocity = - max_speed;
                    }
                    newvelocity = - newvelocity;
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                }
            } else if (newvelocity >= 0.0) {
                this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
            } else {
                this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionY -= 0.25;
            this.motionX *= 0.95;
            this.motionY *= 0.85;
            this.motionZ *= 0.95;
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                this.riddenByEntity = null;
            }
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            float f = -0.15f;
            this.riddenByEntity.setPosition(this.posX - (double)f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + (double)f * Math.cos(Math.toRadians(this.rotationYaw)));
        }
    }

    protected void playTameEffect(boolean par1) {
        String s = "heart";
        if (!par1) {
            s = "smoke";
        }
        for (int i = 0; i < 20; ++i) {
            double d0 = this.rand.nextGaussian() * 0.08;
            double d1 = this.rand.nextGaussian() * 0.08;
            double d2 = this.rand.nextGaussian() * 0.08;
            this.worldObj.spawnParticle(s, this.posX + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f), this.posY + 0.5 + (double)this.rand.nextFloat() * 1.5, this.posZ + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f), d0, d1, d2);
        }
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        if (this.riddenByEntity != null) {
            return false;
        }
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.isTamed()) {
            return false;
        }
        return true;
    }

    public EntityAgeable createChild(EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    public Ostrich spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
        return new Ostrich(this.worldObj);
    }

    public boolean isWheat(ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}

