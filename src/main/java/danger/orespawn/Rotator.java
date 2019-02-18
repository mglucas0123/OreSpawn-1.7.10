/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Bee
 *  danger.orespawn.CloudShark
 *  danger.orespawn.CrystalCow
 *  danger.orespawn.DungeonBeast
 *  danger.orespawn.Flounder
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Irukandji
 *  danger.orespawn.LurkingTerror
 *  danger.orespawn.Mantis
 *  danger.orespawn.MobStats
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Peacock
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.Rotator
 *  danger.orespawn.Skate
 *  danger.orespawn.Termite
 *  danger.orespawn.TerribleTerror
 *  danger.orespawn.Urchin
 *  danger.orespawn.Vortex
 *  danger.orespawn.Whale
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Bee;
import danger.orespawn.CloudShark;
import danger.orespawn.CrystalCow;
import danger.orespawn.DungeonBeast;
import danger.orespawn.Flounder;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Irukandji;
import danger.orespawn.LurkingTerror;
import danger.orespawn.Mantis;
import danger.orespawn.MobStats;
import danger.orespawn.Mothra;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Peacock;
import danger.orespawn.RenderInfo;
import danger.orespawn.Skate;
import danger.orespawn.Termite;
import danger.orespawn.TerribleTerror;
import danger.orespawn.Urchin;
import danger.orespawn.Vortex;
import danger.orespawn.Whale;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Rotator
extends EntityMob {
    private ChunkCoordinates currentFlightTarget = null;
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private int busy_fighting = 0;
    private int was_spawnered = 0;

    public Rotator(World par1World) {
        super(par1World);
        this.setSize(1.0f, 2.0f);
        this.experienceValue = 35;
        this.isImmuneToFire = true;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Rotator_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
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

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.busy_fighting != 0) {
            return false;
        }
        if (this.was_spawnered != 0) {
            return false;
        }
        return true;
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return "vortexlive";
    }

    protected String getHurtSound() {
        return "orespawn:glasshit";
    }

    protected String getDeathSound() {
        return "orespawn:glassdead";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Rotator_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        if (this.worldObj.isRemote && this.worldObj.rand.nextInt(10) == 1) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f));
        }
        this.busy_fighting = 0;
        e = this.findSomethingToAttack();
        if (e != null) {
            double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(a));
            this.busy_fighting = 1;
        }
        if (this.isNoDespawnRequired()) {
            return;
        }
        if (this.busy_fighting != 0) {
            return;
        }
        if (this.was_spawnered != 0) {
            return;
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 12000L && this.worldObj.rand.nextInt(400) == 1) {
            this.setDead();
        }
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.75), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
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
                this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(6) - 3, (int)this.posZ + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget((double)this.currentFlightTarget.posX, (double)this.currentFlightTarget.posY, (double)this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
        } else if (this.rand.nextInt(9) == 2 && (e = this.findSomethingToAttack()) != null) {
            double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
            this.currentFlightTarget.set((int)(e.posX + 2.5 * Math.cos(a)), (int)e.posY, (int)(e.posZ + 2.5 * Math.sin(a += 1.5707963267948966)));
            if (this.getDistanceSqToEntity((Entity)e) < 9.0) {
                this.attackEntityAsMob((Entity)e);
            }
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
        return true;
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
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
        }
        return ret;
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
                    if (s == null || !s.equals("Rotator")) continue;
                    this.was_spawnered = 1;
                    return true;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        for (k = -1; k <= 1; ++k) {
            for (j = -1; j <= 1; ++j) {
                for (i = 1; i < 3; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 12000L) {
            return false;
        }
        return true;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Rotator_stats.defense;
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
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        if (par1EntityLiving instanceof Termite) {
            return false;
        }
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        if (par1EntityLiving instanceof Rotator) {
            return false;
        }
        if (par1EntityLiving instanceof DungeonBeast) {
            return false;
        }
        if (par1EntityLiving instanceof Peacock) {
            return false;
        }
        if (par1EntityLiving instanceof CrystalCow) {
            return false;
        }
        if (par1EntityLiving instanceof Irukandji) {
            return false;
        }
        if (par1EntityLiving instanceof Skate) {
            return false;
        }
        if (par1EntityLiving instanceof Whale) {
            return false;
        }
        if (par1EntityLiving instanceof Flounder) {
            return false;
        }
        if (par1EntityLiving instanceof Urchin) {
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
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof Bee) {
            return false;
        }
        if (par1EntityLiving instanceof Mantis) {
            return false;
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 10.0, 12.0));
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

    protected Item getDropItem() {
        int i = this.worldObj.rand.nextInt(4);
        if (i == 0) {
            return OreSpawnMain.MyCrystalPinkIngot;
        }
        if (i == 1) {
            return OreSpawnMain.MyTigersEyeIngot;
        }
        if (i == 2) {
            return Item.getItemFromBlock((Block)OreSpawnMain.CrystalCoal);
        }
        if (i == 3) {
            return Items.iron_ingot;
        }
        return null;
    }
}

