/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Fairy
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.GenericTargetSorter;
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
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Fairy
extends EntityAmbientCreature {
    private static final ResourceLocation texture0 = new ResourceLocation("orespawn", "fairytexture.png");
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "fairytexture2.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "fairytexture3.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "fairytexture4.png");
    private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "fairytexture5.png");
    private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "fairytexture6.png");
    private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "fairytexture7.png");
    private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "fairytexture8.png");
    private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "fairytexture9.png");
    int my_blink = 0;
    int blinker = 0;
    int myspace = 0;
    public int fairy_type = 0;
    private int force_sync = 10;
    private ChunkCoordinates currentFlightTarget = null;
    private String myowner = null;
    private GenericTargetSorter TargetSorter = null;

    public Fairy(World par1World) {
        super(par1World);
        this.my_blink = 20 + this.rand.nextInt(20);
        this.setSize(0.4f, 0.8f);
        if (par1World != null) {
            this.fairy_type = par1World.rand.nextInt(9);
        }
        this.getNavigator().setAvoidsWater(true);
        this.renderDistanceWeight = 3.0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0f));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
    }

    public ResourceLocation getTexture(Fairy a) {
        if (this.fairy_type == 8) {
            return texture8;
        }
        if (this.fairy_type == 7) {
            return texture7;
        }
        if (this.fairy_type == 6) {
            return texture6;
        }
        if (this.fairy_type == 5) {
            return texture5;
        }
        if (this.fairy_type == 4) {
            return texture4;
        }
        if (this.fairy_type == 3) {
            return texture3;
        }
        if (this.fairy_type == 2) {
            return texture2;
        }
        if (this.fairy_type == 1) {
            return texture1;
        }
        return texture0;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)this.fairy_type);
    }

    public void setOwner(EntityLivingBase e) {
        String s;
        EntityPlayer p = null;
        if (e != null && e instanceof EntityPlayer && (s = (p = (EntityPlayer)e).getDisplayName()) != null) {
            this.myowner = s;
        }
    }

    public float getBlink() {
        if (this.blinker < this.my_blink / 2) {
            return 240.0f;
        }
        return 0.0f;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 2.0f);
        return var4;
    }

    public int getTotalArmorValue() {
        return 4;
    }

    protected float getSoundVolume() {
        return 0.25f;
    }

    protected float getSoundPitch() {
        return 1.7f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:rat_hit";
    }

    protected String getDeathSound() {
        return "orespawn:big_splat";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    public int mygetMaxHealth() {
        return 40;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block)OreSpawnMain.CrystalTorch);
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.600000023841;
        ++this.blinker;
        if (this.blinker > this.my_blink) {
            this.blinker = 0;
        }
        --this.force_sync;
        if (this.force_sync < 0) {
            this.force_sync = 10;
            if (this.worldObj.isRemote) {
                this.fairy_type = this.dataWatcher.getWatchableObjectInt(20);
            } else {
                this.dataWatcher.updateObject(20, (Object)this.fairy_type);
            }
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 12000L) {
            return;
        }
        if (this.worldObj.isRemote && this.worldObj.rand.nextInt(5) == 0 && this.getBlink() > 1.0f) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.15000000596046448, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0f), (double)((- this.worldObj.rand.nextFloat()) / 8.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0f));
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.myowner == null) {
            this.myowner = "null";
        }
        par1NBTTagCompound.setString("MyOwner", this.myowner);
        par1NBTTagCompound.setInteger("FairyType", this.fairy_type);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.myowner = par1NBTTagCompound.getString("MyOwner");
        if (this.myowner != null && this.myowner.equals("null")) {
            this.myowner = null;
        }
        this.fairy_type = par1NBTTagCompound.getInteger("fairyType");
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
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 8.0, 8.0));
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

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.25), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    protected void updateAITasks() {
        EntityPlayer p;
        int keep_trying = 25;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.worldObj.rand.nextInt(200) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.5f) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                int zdir = this.worldObj.rand.nextInt(8);
                int xdir = this.worldObj.rand.nextInt(8);
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = - zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = - xdir;
                }
                this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.worldObj.rand.nextInt(5) - 2, (int)this.posZ + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
        } else if (this.worldObj.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0), (int)e.posZ);
                if (this.getDistanceSqToEntity((Entity)e) < 6.0) {
                    this.attackEntityAsMob((Entity)e);
                }
            }
        } else if (this.myowner != null && (p = this.worldObj.getPlayerEntityByName(this.myowner)) != null) {
            if (this.getDistanceSqToEntity((Entity)p) > 64.0) {
                this.currentFlightTarget.set((int)p.posX + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3), (int)(p.posY + 1.0), (int)p.posZ + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3));
            }
            if (this.getDistanceSqToEntity((Entity)p) > 256.0) {
                this.setPosition(p.posX + (double)this.worldObj.rand.nextFloat() - (double)this.worldObj.rand.nextFloat(), p.posY, p.posZ + (double)this.worldObj.rand.nextFloat() - (double)this.worldObj.rand.nextFloat());
            }
        }
        if (this.worldObj.rand.nextInt(250) == 1) {
            this.heal(1.0f);
        }
        double var1 = (double)this.currentFlightTarget.posX + 0.5 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.2 - this.motionX) * 0.1;
        this.motionY += (Math.signum(var3) * 0.699999988079071 - this.motionY) * 0.1;
        this.motionZ += (Math.signum(var5) * 0.2 - this.motionZ) * 0.1;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 0.2f;
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

    public boolean getCanSpawnHere() {
        int sc = 0;
        for (int k = -1; k <= 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY, (int)this.posZ + k);
                if (bid != Blocks.air) continue;
                ++sc;
            }
        }
        if (sc < 6) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        return true;
    }

    public void initCreature() {
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.myowner != null) {
            return false;
        }
        return true;
    }
}

