/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Bee
 *  danger.orespawn.BetterFireball
 *  danger.orespawn.Brutalfly
 *  danger.orespawn.CloudShark
 *  danger.orespawn.Cryolophosaurus
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.LurkingTerror
 *  danger.orespawn.Mantis
 *  danger.orespawn.MobStats
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Rotator
 *  danger.orespawn.TerribleTerror
 *  danger.orespawn.VelocityRaptor
 *  danger.orespawn.Vortex
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
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

import danger.orespawn.Bee;
import danger.orespawn.BetterFireball;
import danger.orespawn.Brutalfly;
import danger.orespawn.CloudShark;
import danger.orespawn.Cryolophosaurus;
import danger.orespawn.EntityButterfly;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.LurkingTerror;
import danger.orespawn.Mantis;
import danger.orespawn.MobStats;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Rotator;
import danger.orespawn.TerribleTerror;
import danger.orespawn.VelocityRaptor;
import danger.orespawn.Vortex;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class Mothra
extends EntityButterfly
implements IMob {
    private ChunkCoordinates currentFlightTarget = null;
    private int lastX = 0;
    private int lastZ = 0;
    private int lastY = 0;
    private int stuck_count = 0;
    private int wing_sound = 0;
    private int health_ticker = 100;
    private GenericTargetSorter TargetSorter = null;
    private float moveSpeed = 0.35f;

    public Mothra(World par1World) {
        super(par1World);
        this.setSize(5.0f, 2.0f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 100;
        this.isImmuneToFire = true;
        this.fireResistance = 500;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Mothra_stats.attack);
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Mothra_stats.defense;
    }

    public int getMothraHealth() {
        return (int)this.getHealth();
    }

    protected float getSoundVolume() {
        return 1.5f;
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
        return "random.explode";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Mothra_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 1.0f, 1.0f);
            }
            this.wing_sound = 0;
        }
        --this.health_ticker;
        if (this.health_ticker <= 0) {
            if (this.getHealth() < (float)this.mygetMaxHealth()) {
                this.heal(1.0f);
            }
            this.health_ticker = 200;
        }
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.75), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        int shoot = 3;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.lastX == (int)this.posX && this.lastY == (int)this.posY && this.lastZ == (int)this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int)this.posX;
            this.lastY = (int)this.posY;
            this.lastZ = (int)this.posZ;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            shoot = 2;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.stuck_count > 50 || this.worldObj.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0f) {
            Block bid;
            int down = 0;
            int dist = 20;
            for (int i = -5; i <= 5; i += 5) {
                block1 : for (int j = -5; j <= 5; j += 5) {
                    for (int k = 1; k < 20; ++k) {
                        bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY - k, (int)this.posZ + i);
                        if (bid == Blocks.air) continue;
                        if (k >= dist) continue block1;
                        dist = k;
                        continue block1;
                    }
                }
            }
            if (dist > 10) {
                down = dist - 10 + 1;
            }
            bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                xdir = 1;
                zdir = 1;
                if (this.rand.nextInt(2) == 0) {
                    xdir = -1;
                }
                if (this.rand.nextInt(2) == 0) {
                    zdir = -1;
                }
                int newz = this.rand.nextInt(20) + 8;
                int newx = this.rand.nextInt(20) + 8;
                this.currentFlightTarget.set((int)this.posX + (newx *= xdir), (int)this.posY + this.rand.nextInt(7) - 1 - down, (int)this.posZ + (newz *= zdir));
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
            this.stuck_count = 0;
        } else if (this.worldObj.rand.nextInt(10) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && OreSpawnMain.MothraPeaceful == 0) {
            EntityPlayer target = null;
            target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(25.0, 20.0, 25.0), (Entity)this);
            if (target != null) {
                if (!target.capabilities.isCreativeMode) {
                    if (this.getEntitySenses().canSee((Entity)target)) {
                        this.currentFlightTarget.set((int)target.posX, (int)target.posY + 4, (int)target.posZ);
                        if (this.rand.nextInt(shoot) == 0) {
                            this.attackWithSomething((EntityLivingBase)target);
                        }
                    }
                } else {
                    target = null;
                }
            }
            if (target == null && this.worldObj.rand.nextInt(3) == 0) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null) {
                    this.currentFlightTarget.set((int)e.posX, (int)e.posY + 5, (int)e.posZ);
                    if (this.worldObj.rand.nextInt(shoot) == 0) {
                        this.attackWithSomething(e);
                    }
                }
            }
        }
        double var1 = (double)this.currentFlightTarget.posX + 0.5 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.30001;
        this.motionY += (Math.signum(var3) * 0.7 - this.motionY) * 0.20001;
        this.motionZ += (Math.signum(var5) * 0.5 - this.motionZ) * 0.30001;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 1.0f;
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
        if (e != null && e instanceof Mothra) {
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int)e.posX, (int)e.posY + 2, (int)e.posZ);
        }
        return ret;
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public boolean getCanSpawnHere() {
        Block bid;
        int j;
        int i;
        int k;
        for (k = -2; k <= 2; ++k) {
            for (j = -2; j <= 2; ++j) {
                for (i = 1; i < 4; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Mothra")) continue;
                    return true;
                }
            }
        }
        if (this.posY < 70.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (k = -4; k < 4; ++k) {
            for (j = -3; j < 3; ++j) {
                for (i = 1; i < 10; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        Mothra target = null;
        target = (Mothra)this.worldObj.findNearestEntityWithinAABB(Mothra.class, this.boundingBox.expand(64.0, 32.0, 64.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    public void initCreature() {
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(8) - (double)OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(8) - (double)OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        this.dropItemRand(Items.item_frame, 1);
        for (int i = 0; i < 20; ++i) {
            float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)var1, this.posY + 2.0 + (double)var2, this.posZ + (double)var3, 0.0, 0.0, 0.0);
        }
        for (var4 = 0; var4 < 53; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (var4 = 0; var4 < 25; ++var4) {
            this.dropItemRand(OreSpawnMain.MyMothScale, 1);
        }
        for (var4 = 0; var4 < 3; ++var4) {
            this.dropItemRand(Items.blaze_rod, 1);
        }
        this.dropItemRand(Items.nether_star, 1);
        for (var4 = 0; var4 < 20; ++var4) {
            Mothra.spawnCreature((World)this.worldObj, (String)"Moth", (double)(this.posX + 0.5), (double)(this.posY + 1.0), (double)(this.posZ + 0.5));
        }
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        if (par0World == null) {
            return null;
        }
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    private void attackWithSomething(EntityLivingBase par1) {
        double xzoff = 2.25;
        double yoff = 0.0;
        if (OreSpawnMain.MothraPeaceful != 0) {
            return;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return;
        }
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55 - (this.posY + yoff), par1.posZ - cz);
            sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            sf.setPosition(cx, this.posY + yoff, cz);
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)sf);
        } else if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55 - (this.posY + yoff), par1.posZ - cz);
                sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                sf.setPosition(cx, this.posY + yoff, cz);
                this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)sf);
            } else {
                BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55 - (this.posY + yoff), par1.posZ - cz);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                bf.setNotMe();
                this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)bf);
            }
        } else {
            BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55 - (this.posY + yoff), par1.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setNotMe();
            this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)bf);
        }
        if (this.getHealth() < (float)this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
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
        if (MyUtils.isIgnoreable((EntityLivingBase)par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof Brutalfly) {
            return false;
        }
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        if (par1EntityLiving instanceof VelocityRaptor) {
            return false;
        }
        if (par1EntityLiving instanceof Cryolophosaurus) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof CloudShark) {
            return false;
        }
        if (par1EntityLiving instanceof Rotator) {
            return false;
        }
        if (par1EntityLiving instanceof Bee) {
            return false;
        }
        if (par1EntityLiving instanceof Mantis) {
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

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(15.0, 20.0, 15.0));
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
}

