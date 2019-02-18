/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Cockateil
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class Cockateil
extends EntityAnimal {
    private ChunkCoordinates currentFlightTarget = null;
    public int birdtype;
    private boolean killedByPlayer = false;
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Bird1.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Bird2.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "Bird3.png");
    private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "Bird4.png");
    private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "Bird5.png");
    private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "Bird6.png");
    private int stuck_count = 0;
    private int lastX = 0;
    private int lastZ = 0;
    private int flyup = 0;

    public Cockateil(World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.5f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 2;
        this.isImmuneToFire = false;
        this.fireResistance = 2;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000001311302185);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
    }

    public ResourceLocation getTexture() {
        this.birdtype = this.getBirdType();
        switch (this.birdtype) {
            case 0: {
                return texture1;
            }
            case 1: {
                return texture2;
            }
            case 2: {
                return texture3;
            }
            case 3: {
                return texture4;
            }
            case 4: {
                return texture5;
            }
            case 5: {
                return texture6;
            }
        }
        return null;
    }

    protected void entityInit() {
        super.entityInit();
        this.birdtype = this.rand.nextInt(6);
        this.dataWatcher.addObject(22, (Object)this.birdtype);
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public int getBirdType() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setBirdType(int par1) {
        this.dataWatcher.updateObject(22, (Object)par1);
    }

    protected float getSoundVolume() {
        return 0.55f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
            return "orespawn:birds";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:duck_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:duck_hurt";
    }

    public boolean canBePushed() {
        return true;
    }

    public int mygetMaxHealth() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityPlayer) {
            this.killedByPlayer = true;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        } else {
            this.motionY = this.posY < (double)this.currentFlightTarget.posY ? (this.motionY *= 0.7) : (this.motionY *= 0.5);
        }
    }

    public int getAttackStrength(Entity par1Entity) {
        return 1;
    }

    public void setFlyUp() {
        this.flyup = 2;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.75), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 35;
        int stayup = 0;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
            stayup = 2;
        }
        if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int)this.posX;
            this.lastZ = (int)this.posZ;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.stuck_count > 40 || this.rand.nextInt(250) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.1f) {
            Block bid = Blocks.stone;
            this.stuck_count = 0;
            while (bid != Blocks.air && keep_trying != 0) {
                zdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
                xdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
                if (this.rand.nextInt(2) == 0) {
                    zdir = - zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = - xdir;
                }
                this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(9 + stayup) - 5 + this.flyup, (int)this.posZ + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
        }
        double var1 = (double)this.currentFlightTarget.posX + 0.3 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.3 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.3 - this.motionX) * 0.25;
        this.motionY += (Math.signum(var3) * 0.699999 - this.motionY) * 0.200000001;
        this.motionZ += (Math.signum(var5) * 0.3 - this.motionZ) * 0.25;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 0.8f;
        this.rotationYaw += var8 / 3.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
            return true;
        }
        if (this.posY < 50.0) {
            return false;
        }
        return true;
    }

    protected Item getDropItem() {
        this.birdtype = this.getBirdType();
        if (this.birdtype == 5 && this.killedByPlayer && this.worldObj.rand.nextInt(3) == 1) {
            return OreSpawnMain.MyRuby;
        }
        return Items.feather;
    }

    public void initCreature() {
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("BirdType", this.getBirdType());
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.birdtype = par1NBTTagCompound.getInteger("BirdType");
        this.setBirdType(this.birdtype);
    }
}

