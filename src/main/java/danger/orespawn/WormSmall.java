/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MobStats
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WormSmall
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.MobStats;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class WormSmall
extends EntityMob {
    public int upcount = 50;
    public int downcount = 0;

    public WormSmall(World par1World) {
        super(par1World);
        this.setSize(0.25f, 1.0f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 0;
        this.noClip = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.WormSmall_stats.attack);
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
        return 1.5f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:little_splat";
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
        return OreSpawnMain.WormSmall_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.WormSmall_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        EntityPlayer target = null;
        super.onLivingUpdate();
        target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 8.0, 8.0), (Entity)this);
        if (target != null || OreSpawnMain.PlayNicely != 0) {
            if (this.upcount > 0) {
                Block bid;
                --this.upcount;
                if (this.upcount == 0) {
                    this.downcount = 100 + this.worldObj.rand.nextInt(150);
                }
                if (target != null) {
                    this.pointAtEntity((EntityLivingBase)target);
                }
                if ((bid = this.worldObj.getBlock((int)this.posX, (int)(this.posY + 0.25), (int)this.posZ)) == Blocks.tallgrass) {
                    bid = Blocks.air;
                }
                if (bid != Blocks.air) {
                    if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                        this.setDead();
                    }
                    this.motionY += 0.15000000596046448;
                    this.posY += 0.10000000149011612;
                }
            } else {
                if (this.downcount > 0) {
                    --this.downcount;
                } else {
                    this.upcount = 25 + this.worldObj.rand.nextInt(50);
                }
                Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 2, (int)this.posZ);
                if (bid == Blocks.tallgrass) {
                    bid = Blocks.air;
                }
                if (bid != Blocks.air) {
                    if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                        this.setDead();
                    }
                    this.motionY += 0.20000000298023224;
                    this.posY += 0.05000000074505806;
                }
            }
        } else {
            this.upcount = this.worldObj.rand.nextInt(50);
            this.downcount = 0;
            Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 2, (int)this.posZ);
            if (bid == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                    this.setDead();
                }
                this.motionY += 0.10000000149011612;
                this.posY += 0.05000000074505806;
            }
        }
        this.motionY -= 0.01;
        this.motionX = 0.0;
        this.motionZ = 0.0;
        this.moveForward = 0.0f;
    }

    public void onUpdate() {
        if (this.isNoDespawnRequired()) {
            this.noClip = false;
        }
        super.onUpdate();
        this.motionY *= 0.75;
    }

    public void pointAtEntity(EntityLivingBase e) {
        float f2;
        double d1 = e.posX - this.posX;
        double d2 = e.posZ - this.posZ;
        float d = (float)Math.atan2(d2, d1);
        this.rotationYaw = this.rotationYawHead = (f2 = (float)((double)d * 180.0 / 3.141592653589793) - 90.0f);
    }

    protected void updateAITasks() {
        int bid = 0;
        EntityPlayer target = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(1.5, 4.0, 1.5), (Entity)this);
        if (target != null && target.capabilities.isCreativeMode) {
            target = null;
        }
        if (target != null) {
            this.pointAtEntity((EntityLivingBase)target);
            if (this.upcount > 0 && this.worldObj.rand.nextInt(15) == 1 && !target.capabilities.isCreativeMode) {
                ItemStack boots;
                super.attackEntityAsMob((Entity)target);
                if (this.worldObj.rand.nextInt(6) == 1 && (boots = target.getEquipmentInSlot(1)) != null) {
                    target.setCurrentItemOrArmor(1, null);
                    bid = boots.getMaxDamage() - boots.getItemDamage();
                    bid = bid > 20 ? (bid /= 20) : 1;
                    boots.damageItem(bid, (EntityLivingBase)this);
                    EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                    this.worldObj.spawnEntityInWorld((Entity)var3);
                }
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

    public boolean getCanSpawnHere() {
        if (this.worldObj.isDaytime()) {
            return false;
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

    protected Item getDropItem() {
        return null;
    }
}

