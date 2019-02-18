/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Brutalfly
 *  danger.orespawn.CrystalCow
 *  danger.orespawn.Flounder
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Irukandji
 *  danger.orespawn.MobStats
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Peacock
 *  danger.orespawn.Rotator
 *  danger.orespawn.Skate
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
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
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

import danger.orespawn.Brutalfly;
import danger.orespawn.CrystalCow;
import danger.orespawn.Flounder;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Irukandji;
import danger.orespawn.MobStats;
import danger.orespawn.Mothra;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Peacock;
import danger.orespawn.Rotator;
import danger.orespawn.Skate;
import danger.orespawn.Urchin;
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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class Vortex
extends EntityMob {
    private ChunkCoordinates currentFlightTarget = null;
    private GenericTargetSorter TargetSorter = null;
    private int winded = 0;
    private int busy_fighting = 0;
    private int was_spawnered = 0;

    public Vortex(World par1World) {
        super(par1World);
        this.setSize(2.0f, 4.0f);
        this.experienceValue = 200;
        this.isImmuneToFire = true;
        this.fireResistance = 250;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3499999940395355);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Vortex_stats.attack);
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
        return "orespawn:vortexlive";
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return "orespawn:vortexlive";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Vortex_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        this.busy_fighting = 0;
        e = this.findSomethingToAttack();
        if (e != null) {
            this.busy_fighting = 1;
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double d = this.worldObj.rand.nextDouble() * 3.5;
                    d *= d;
                    double dir = this.worldObj.rand.nextDouble() * 2.0 * 3.141592653589793;
                    double dx = Math.cos(dir -= 3.141592653589793) * d / 2.0;
                    double dz = Math.sin(dir) * d / 2.0;
                    this.worldObj.spawnParticle("smoke", this.posX + dx, this.posY + 0.75 + d, this.posZ + dz, Math.cos(dir) * (double)this.worldObj.rand.nextFloat() / 4.0, (double)(this.worldObj.rand.nextFloat() / 2.0f), Math.sin(dir += 1.5707963267948966) * (double)this.worldObj.rand.nextFloat() / 4.0);
                }
            }
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.heal(1.0f);
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
        if ((t %= 24000L) < 12000L && this.worldObj.rand.nextInt(500) == 1) {
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
        if (this.winded > 0) {
            --this.winded;
        }
        if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1f) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                zdir = this.rand.nextInt(14) + 10;
                xdir = this.rand.nextInt(14) + 10;
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
        }
        if ((e = this.findSomethingToAttack()) != null) {
            this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
            double d = this.getDistanceSqToEntity((Entity)e);
            if (d < 81.0 && this.winded == 0) {
                double a = Math.atan2(this.posZ - e.posZ, this.posX - e.posX);
                double pm = 1.0;
                if (e instanceof EntityPlayer) {
                    pm = 2.0;
                }
                e.addVelocity(Math.cos(a) * (10.0 - Math.sqrt(d)) * 0.10000000149011612, (10.0 - Math.sqrt(d)) * 0.05000000074505806 * pm, Math.sin(a) * (10.0 - Math.sqrt(d)) * 0.10000000149011612);
            }
            if (this.getDistanceSqToEntity((Entity)e) < (double)((4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f)) && this.rand.nextInt(8) == 2) {
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
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
        }
        this.winded = 20;
        return ret;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Vortex_stats.defense;
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
                    if (s == null || !s.equals("Vortex")) continue;
                    this.was_spawnered = 1;
                    return true;
                }
            }
        }
        for (k = -2; k <= 2; ++k) {
            for (j = -2; j <= 2; ++j) {
                for (i = 1; i < 4; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) < 12000L) {
            return false;
        }
        if (this.worldObj.rand.nextInt(2) != 1) {
            return false;
        }
        Vortex target = null;
        target = (Vortex)this.worldObj.findNearestEntityWithinAABB(Vortex.class, this.boundingBox.expand(20.0, 16.0, 20.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
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
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        if (par1EntityLiving instanceof Rotator) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof Brutalfly) {
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
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 10.0, 16.0));
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

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(6) - (double)OreSpawnMain.OreSpawnRand.nextInt(6), this.posY + 1.0 + (double)this.worldObj.rand.nextInt(10), this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(6) - (double)OreSpawnMain.OreSpawnRand.nextInt(6), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        this.dropItemRand(OreSpawnMain.VortexEye, 1);
        this.dropItemRand(Items.item_frame, 1);
        int i = 5 + this.worldObj.rand.nextInt(7);
        for (int var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(10);
            if (var3 == 0) {
                this.dropItemRand(Items.stick, 1);
            }
            if (var3 == 1) {
                this.dropItemRand(OreSpawnMain.MyTigersEyeIngot, 1);
            }
            if (var3 == 2) {
                this.dropItemRand(OreSpawnMain.MyCrystalPinkIngot, 1);
            }
            if (var3 == 3) {
                this.dropItemRand(Items.iron_ingot, 1);
            }
            if (var3 == 4) {
                this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
            }
            if (var3 == 6) {
                this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
            }
            if (var3 == 7) {
                this.dropItemRand(OreSpawnMain.MyIrukandji, 1);
            }
            if (var3 != 8) continue;
            this.dropItemRand(Item.getItemFromBlock((Block)OreSpawnMain.CrystalCoal), 1);
        }
    }

    protected Item getDropItem() {
        return OreSpawnMain.FairyEgg;
    }
}

