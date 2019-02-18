/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.EntityLunaMoth
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Mothra
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.OreSpawnTeleporter
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.ServerConfigurationManager
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.Teleporter
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldServer
 */
package danger.orespawn;

import danger.orespawn.EntityLunaMoth;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Mothra;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.OreSpawnTeleporter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

public class EntityButterfly
extends EntityAmbientCreature {
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "butterfly.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "butterfly2.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "butterfly3.png");
    private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "butterfly4.png");
    private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "eyemoth.png");
    private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "lunamoth.png");
    private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "darkmoth.png");
    private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "firemoth.png");
    private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "vbutterfly1.png");
    public int butterfly_type = OreSpawnMain.OreSpawnRand.nextInt(4);
    private int attack_delay = 0;
    private GenericTargetSorter TargetSorter = null;
    private int force_sync = 25;
    private ChunkCoordinates currentFlightTarget = null;

    public EntityButterfly(World par1World) {
        super(par1World);
        this.setSize(0.4f, 0.4f);
        this.getNavigator().setAvoidsWater(true);
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0);
    }

    public ResourceLocation getTexture(EntityButterfly a) {
        if (a instanceof Mothra) {
            return texture5;
        }
        if (a instanceof EntityLunaMoth) {
            if (((EntityLunaMoth)a).moth_type == 1) {
                return texture5;
            }
            if (((EntityLunaMoth)a).moth_type == 2) {
                return texture7;
            }
            if (((EntityLunaMoth)a).moth_type == 3) {
                return texture8;
            }
            return texture6;
        }
        if (this.butterfly_type == 1) {
            if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
                return texture9;
            }
            return texture2;
        }
        if (this.butterfly_type == 2) {
            return texture3;
        }
        if (this.butterfly_type == 3) {
            return texture4;
        }
        return texture1;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)this.butterfly_type);
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    protected float getSoundVolume() {
        return 0.0f;
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
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    public int mygetMaxHealth() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void updateAITasks() {
        int keep_trying = 25;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.rand.nextInt(100) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0f) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                --keep_trying;
            }
        } else if (this.rand.nextInt(10) == 0 && this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4 && this.butterfly_type == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0), (int)e.posZ);
                if (this.getDistanceSqToEntity((Entity)e) < 6.0) {
                    this.attackEntityAsMob((Entity)e);
                }
            }
        }
        double var1 = (double)this.currentFlightTarget.posX + 0.5 - this.posX;
        double var3 = (double)this.currentFlightTarget.posY + 0.1 - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.10000000149011612;
        this.motionY += (Math.signum(var3) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
        this.motionZ += (Math.signum(var5) * 0.5 - this.motionZ) * 0.10000000149011612;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 0.5f;
        this.rotationYaw += var8;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        if (OreSpawnMain.OreSpawnRand.nextInt(2) != 0) {
            return false;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0f);
        return var4;
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
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            return true;
        }
        if (par1EntityLiving instanceof EntityHorse) {
            return true;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 5.0, 8.0));
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

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579;
        --this.force_sync;
        if (this.force_sync < 0) {
            this.force_sync = 25;
            if (this.worldObj.isRemote) {
                this.butterfly_type = this.dataWatcher.getWatchableObjectInt(20);
            } else {
                this.dataWatcher.updateObject(20, (Object)this.butterfly_type);
            }
        }
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

    public boolean interact(EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer == null) {
            return false;
        }
        if (!(par1EntityPlayer instanceof EntityPlayerMP)) {
            return false;
        }
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null) {
            return false;
        }
        if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID6) {
            MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID6, (Teleporter)new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(OreSpawnMain.DimensionID6), OreSpawnMain.DimensionID6, this.worldObj));
        } else {
            MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, (Teleporter)new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(0), 0, this.worldObj));
        }
        return true;
    }

    public boolean getCanSpawnHere() {
        Block bid;
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Butterfly")) continue;
                    this.butterfly_type = 1;
                    return true;
                }
            }
        }
        bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
        if (bid != Blocks.air) {
            return false;
        }
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

    public void initCreature() {
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ButterflyType", this.butterfly_type);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.butterfly_type = par1NBTTagCompound.getInteger("ButterflyType");
    }
}

