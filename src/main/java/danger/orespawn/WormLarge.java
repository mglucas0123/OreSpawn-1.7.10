/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MobStats
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WormLarge
 *  danger.orespawn.WormMedium
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
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
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.MobStats;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.WormMedium;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class WormLarge
extends EntityMob {
    private int wormsSpawned = 0;

    public WormLarge(World par1World) {
        super(par1World);
        this.setSize(1.55f, 2.5f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 2050;
        this.noClip = true;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.WormLarge_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        return false;
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:big_splat";
    }

    protected String getDeathSound() {
        return "orespawn:alo_death";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(Entity par1Entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.WormLarge_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.WormLarge_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void pointAtEntity(EntityLivingBase e) {
        float f2;
        double d1 = e.posX - this.posX;
        double d2 = e.posZ - this.posZ;
        float d = (float)Math.atan2(d2, d1);
        this.rotationYaw = this.rotationYawHead = (f2 = (float)((double)d * 180.0 / 3.141592653589793) - 90.0f);
    }

    public void onLivingUpdate() {
        Block bid;
        EntityPlayer target = null;
        WormMedium worms = null;
        EntityCreature newent = null;
        super.onLivingUpdate();
        worms = (WormMedium)this.worldObj.findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0, 8.0, 8.0), (Entity)this);
        if (worms == null) {
            target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 8.0, 8.0), (Entity)this);
        }
        if (worms == null && target != null || OreSpawnMain.PlayNicely != 0) {
            if (target != null) {
                this.pointAtEntity((EntityLivingBase)target);
            }
            if ((bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ)) == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                this.motionY += 0.25;
                this.posY += 0.10000000149011612;
            } else {
                this.noClip = false;
            }
        } else {
            this.noClip = true;
            bid = this.worldObj.getBlock((int)this.posX, (int)(this.posY + 3.5), (int)this.posZ);
            if (bid == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                this.motionY += 0.10000000149011612;
                this.posY += 0.05000000074505806;
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                    this.setDead();
                }
            }
        }
        if (this.noClip) {
            this.motionY -= 0.01;
            this.motionX = 0.0;
            this.motionZ = 0.0;
            this.moveForward = 0.0f;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.wormsSpawned != 0) {
            return;
        }
        this.wormsSpawned = 1;
        for (int i = 0; i < 20; ++i) {
            newent = (EntityCreature)WormLarge.spawnCreature((World)this.worldObj, (String)"Small Worm", (double)(this.posX + (double)this.worldObj.rand.nextInt(6) - (double)this.worldObj.rand.nextInt(6)), (double)this.posY, (double)(this.posZ + (double)this.worldObj.rand.nextInt(6) - (double)this.worldObj.rand.nextInt(6)));
            newent = (EntityCreature)WormLarge.spawnCreature((World)this.worldObj, (String)"Medium Worm", (double)(this.posX + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5)), (double)this.posY, (double)(this.posZ + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5)));
        }
    }

    public void onUpdate() {
        if (this.isNoDespawnRequired()) {
            this.noClip = false;
        }
        super.onUpdate();
        this.motionY *= 0.85;
    }

    protected void updateAITasks() {
        int bid = 0;
        EntityPlayer target = null;
        WormMedium worms = null;
        if (this.isDead) {
            return;
        }
        if (!this.noClip) {
            super.updateAITasks();
        }
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        worms = (WormMedium)this.worldObj.findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0, 8.0, 8.0), (Entity)this);
        if (worms != null) {
            return;
        }
        target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 6.0, 8.0), (Entity)this);
        if (target != null && target.capabilities.isCreativeMode) {
            target = null;
        }
        if (target != null) {
            this.pointAtEntity((EntityLivingBase)target);
            this.getNavigator().tryMoveToXYZ(target.posX, target.posY, target.posZ, 1.0);
            if (this.worldObj.rand.nextInt(10) == 1 && (double)this.getDistanceToEntity((Entity)target) < 3.0) {
                EntityItem var3;
                ItemStack boots;
                super.attackEntityAsMob((Entity)target);
                if (this.worldObj.rand.nextInt(4) == 1) {
                    boots = target.getEquipmentInSlot(4);
                    if (boots != null) {
                        target.setCurrentItemOrArmor(4, null);
                        bid = boots.getMaxDamage() - boots.getItemDamage();
                        bid = bid > 10 ? (bid /= 10) : 1;
                        boots.damageItem(bid, (EntityLivingBase)this);
                        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                        this.worldObj.spawnEntityInWorld((Entity)var3);
                    } else {
                        boots = target.getEquipmentInSlot(3);
                        if (boots != null) {
                            target.setCurrentItemOrArmor(3, null);
                            bid = boots.getMaxDamage() - boots.getItemDamage();
                            bid = bid > 10 ? (bid /= 10) : 1;
                            boots.damageItem(bid, (EntityLivingBase)this);
                            var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                            this.worldObj.spawnEntityInWorld((Entity)var3);
                        }
                    }
                }
                if (this.worldObj.rand.nextInt(4) == 1 && (boots = target.getEquipmentInSlot(0)) != null) {
                    target.setCurrentItemOrArmor(0, null);
                    bid = boots.getMaxDamage() - boots.getItemDamage();
                    bid = bid > 10 ? (bid /= 10) : 1;
                    boots.damageItem(bid, (EntityLivingBase)this);
                    var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                    this.worldObj.spawnEntityInWorld((Entity)var3);
                }
            }
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(float par1) {
        if (!this.noClip) {
            super.fall(par1);
        }
    }

    protected void updateFallState(double par1, boolean par3) {
        if (!this.noClip) {
            super.updateFallState(par1, par3);
        }
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
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
                    if (s == null || !s.equals("Large Worm")) continue;
                    this.wormsSpawned = 1;
                    return true;
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        WormLarge target = null;
        target = (WormLarge)this.worldObj.findNearestEntityWithinAABB(WormLarge.class, this.boundingBox.expand(32.0, 8.0, 32.0), (Entity)this);
        if (target != null) {
            return false;
        }
        for (i = -6; i <= 6; ++i) {
            for (j = -6; j <= 6; ++j) {
                for (k = -2; k >= -8; --k) {
                    bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
                    if (bid != Blocks.air) continue;
                    return false;
                }
            }
        }
        for (i = -6; i <= 6; ++i) {
            for (j = -6; j <= 6; ++j) {
                for (k = 2; k <= 8; ++k) {
                    bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        return true;
    }

    public void initCreature() {
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType().equals("inWall")) {
            return ret;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        return ret;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("wormsSpawned", this.wormsSpawned);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wormsSpawned = par1NBTTagCompound.getInteger("wormsSpawned");
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.5 + (double)this.worldObj.rand.nextInt(4), this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(4) - (double)OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        this.dropItemRand(OreSpawnMain.WormTooth, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.rotten_flesh, 1);
        }
        for (var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.leather, 1);
        }
        for (var4 = 0; var4 < 8; ++var4) {
            this.dropItemRand(Item.getItemFromBlock((Block)Blocks.dirt), 1);
        }
        for (var4 = 0; var4 < 16; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (var4 = 0; var4 < 5; ++var4) {
            this.dropItemRand(Items.diamond, 1);
        }
        for (var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        for (var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
    }
}

