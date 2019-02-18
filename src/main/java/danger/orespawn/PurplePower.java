/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.PurplePower
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class PurplePower
extends EntityLiving {
    private ChunkCoordinates currentFlightTarget = null;
    private GenericTargetSorter TargetSorter = null;
    private int purple_type = 0;

    public PurplePower(World par1World) {
        super(par1World);
        this.setSize(0.75f, 0.75f);
        this.experienceValue = 35;
        this.isImmuneToFire = true;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.noClip = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(500.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
    }

    public void setPurpleType(int par1) {
        if (this.worldObj == null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        this.purple_type = par1;
        this.dataWatcher.updateObject(20, (Object)par1);
    }

    public int getPurpleType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    public int mygetMaxHealth() {
        return 1000;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        Object e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        if (this.getPurpleType() == 0) {
            if (this.worldObj.isRemote && this.worldObj.rand.nextInt(4) == 1) {
                this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.25, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
            }
        } else if (this.worldObj.isRemote && this.worldObj.rand.nextInt(6) == 1) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 0.6499999761581421, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f));
        }
        if (this.worldObj.isRemote) {
            this.purple_type = this.getPurpleType();
        } else {
            this.setPurpleType(this.purple_type);
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2500) == 1) {
            if (this.getPurpleType() == 10) {
                this.worldObj.newExplosion((Entity)null, this.posX, this.posY + 0.25, this.posZ, 9.1f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            }
            this.setDead();
        }
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.55), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1f) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                zdir = this.rand.nextInt(10) + 8;
                xdir = this.rand.nextInt(10) + 8;
                if (this.rand.nextInt(2) == 0) {
                    zdir = - zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = - xdir;
                }
                this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(20) - 10, (int)this.posZ + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
        } else if (this.rand.nextInt(7) == 2 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && (e = this.findSomethingToAttack()) != null) {
            this.currentFlightTarget.set((int)e.posX, (int)(e.posY + (double)(e.height / 2.0f)), (int)e.posZ);
            if (this.getDistanceSqToEntity((Entity)e) < (double)((4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f))) {
                this.attackEntityAsMob((Entity)e);
                this.setDead();
            }
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        double var1 = (double)this.currentFlightTarget.posX + 0.5 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.2;
        this.motionY += (Math.signum(var3) * 0.699999988079071 - this.motionY) * 0.20000000149011612;
        this.motionZ += (Math.signum(var5) * 0.4 - this.motionZ) * 0.2;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 0.75f;
        this.rotationYaw += var8 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        Entity e = par1DamageSource.getEntity();
        float dm = par2;
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        if (dm > 10.0f) {
            dm = 10.0f;
        }
        ret = super.attackEntityFrom(par1DamageSource, dm);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int)e.posX, (int)(e.posY + (double)(e.height / 2.0f)), (int)e.posZ);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    public int getTotalArmorValue() {
        return 25;
    }

    private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
        EntityTameable e;
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
        if (MyUtils.isIgnoreable((EntityLivingBase)par1EntityLiving)) {
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
            if (this.getPurpleType() > 0 && this.getPurpleType() != 10) {
                return false;
            }
            return true;
        }
        if (this.getPurpleType() != 0 && this.getPurpleType() != 10 && par1EntityLiving instanceof EntityTameable && (e = (EntityTameable)par1EntityLiving).isTamed()) {
            return false;
        }
        if (MyUtils.isRoyalty((Entity)par1EntityLiving)) {
            return false;
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0, 24.0, 32.0));
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

    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            EntityLivingBase e = (EntityLivingBase)par1Entity;
            if (this.getPurpleType() == 0 || this.getPurpleType() == 10) {
                e.setHealth(e.getHealth() / 4.0f - 1.0f);
                var4 = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), e.getMaxHealth() / 8.0f);
                if (this.getPurpleType() == 10) {
                    this.worldObj.newExplosion((Entity)null, e.posX, e.posY - 0.25, e.posZ, 9.1f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                }
            } else {
                e.setHealth(e.getHealth() * 15.0f / 16.0f);
                var4 = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0f);
                if (this.getPurpleType() == 1) {
                    e.setFire(10);
                }
                if (this.getPurpleType() == 2) {
                    e.addPotionEffect(new PotionEffect(Potion.poison.id, 50, 0));
                }
                if (this.getPurpleType() == 3) {
                    e.addPotionEffect(new PotionEffect(Potion.weakness.id, 50, 0));
                }
            }
        }
        return var4;
    }

    protected Item getDropItem() {
        return null;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("PurpleType", this.purple_type);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.purple_type = par1NBTTagCompound.getInteger("PurpleType");
    }
}

