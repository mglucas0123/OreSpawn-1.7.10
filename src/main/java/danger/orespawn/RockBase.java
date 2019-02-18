/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RockBase
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class RockBase
extends EntityLiving {
    public int rock_type = 0;
    private double dx;
    private double dz;

    public RockBase(World par1World) {
        super(par1World);
        this.setSize(0.25f, 0.15f);
        this.fireResistance = 100000;
        this.isImmuneToFire = true;
        this.dz = 0.0;
        this.dx = 0.0;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity e = par1DamageSource.getEntity();
        if (par1DamageSource.getDamageType().equals("inWall")) {
            return false;
        }
        if (e != null && e instanceof EntityLivingBase) {
            this.playSound("random.pop", 0.75f, 2.25f);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public int getRockType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setRockType(int par1) {
        if (this.worldObj == null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(20, (Object)par1);
    }

    public void placeRock(int par1) {
        this.rock_type = par1;
        this.setRockType(par1);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(1 + this.rock_type / 4));
        this.setHealth((float)(1 + this.rock_type / 4));
    }

    public int getTotalArmorValue() {
        return 0;
    }

    protected void fall(float par1) {
    }

    public void onUpdate() {
        if (this.dx == 0.0 && this.dz == 0.0) {
            this.dx = this.posX;
            this.dz = this.posZ;
        }
        super.onUpdate();
        this.rotationPitch = 0.0f;
        this.rotationYawHead = 0.0f;
        this.rotationYaw = 0.0f;
        if (this.worldObj.isRemote) {
            this.rock_type = this.getRockType();
        }
        if (!this.worldObj.isRemote && this.rock_type == 0) {
            if (this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID5) {
                this.rock_type = 1;
                if (this.worldObj.rand.nextInt(10) == 0) {
                    this.rock_type = 2;
                }
                if (this.worldObj.rand.nextInt(20) == 0) {
                    this.rock_type = 3;
                }
                if (this.worldObj.rand.nextInt(30) == 0) {
                    this.rock_type = 4;
                }
                if (this.worldObj.rand.nextInt(40) == 0) {
                    this.rock_type = 5;
                }
                if (this.worldObj.rand.nextInt(50) == 0) {
                    this.rock_type = 6;
                }
                if (this.worldObj.rand.nextInt(100) == 0) {
                    this.rock_type = 7;
                }
                if (this.worldObj.rand.nextInt(200) == 0) {
                    this.rock_type = 8;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 9;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 10;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 11;
                }
                if (this.worldObj.rand.nextInt(1000) == 0) {
                    this.rock_type = 12;
                }
            } else {
                this.rock_type = 9;
                if (this.worldObj.rand.nextInt(3) == 0) {
                    this.rock_type = 10;
                }
                if (this.worldObj.rand.nextInt(5) == 0) {
                    this.rock_type = 11;
                }
                if (this.worldObj.rand.nextInt(10) == 0) {
                    this.rock_type = 12;
                }
            }
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(1 + this.rock_type / 4));
            this.setHealth((float)(1 + this.rock_type / 4));
        }
        if (!this.worldObj.isRemote) {
            this.setRockType(this.rock_type);
        }
        if (this.worldObj.isRemote) {
            if (this.rock_type == 9 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f), (double)(this.worldObj.rand.nextFloat() / 10.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 10 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle("happyVillager", this.posX, this.posY + 0.25, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f), (double)(this.worldObj.rand.nextFloat() / 2.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 11 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f), (double)(this.worldObj.rand.nextFloat() / 10.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 12 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 0.25, this.posZ, (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f), (double)(this.worldObj.rand.nextFloat() / 5.0f), (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
        }
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

    protected float getSoundVolume() {
        return 0.65f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return null;
    }

    public boolean canDespawn() {
        return false;
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        return true;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean canBePushed() {
        return true;
    }

    public void performHurtAnimation() {
        this.maxHurtTime = 0;
        this.hurtTime = 0;
        this.attackedAtYaw = 0.0f;
    }

    protected void onDeathUpdate() {
        this.setDead();
    }

    public void onDeath(DamageSource par1DamageSource) {
        this.setDead();
        if (this.rock_type == 1) {
            this.dropItemRand(OreSpawnMain.MySmallRock, 1);
        }
        if (this.rock_type == 2) {
            this.dropItemRand(OreSpawnMain.MyRock, 1);
        }
        if (this.rock_type == 3) {
            this.dropItemRand(OreSpawnMain.MyRedRock, 1);
        }
        if (this.rock_type == 4) {
            this.dropItemRand(OreSpawnMain.MyGreenRock, 1);
        }
        if (this.rock_type == 5) {
            this.dropItemRand(OreSpawnMain.MyBlueRock, 1);
        }
        if (this.rock_type == 6) {
            this.dropItemRand(OreSpawnMain.MyPurpleRock, 1);
        }
        if (this.rock_type == 7) {
            this.dropItemRand(OreSpawnMain.MySpikeyRock, 1);
        }
        if (this.rock_type == 8) {
            this.dropItemRand(OreSpawnMain.MyTNTRock, 1);
        }
        if (this.rock_type == 9) {
            this.dropItemRand(OreSpawnMain.MyCrystalRedRock, 1);
        }
        if (this.rock_type == 10) {
            this.dropItemRand(OreSpawnMain.MyCrystalGreenRock, 1);
        }
        if (this.rock_type == 11) {
            this.dropItemRand(OreSpawnMain.MyCrystalBlueRock, 1);
        }
        if (this.rock_type == 12) {
            this.dropItemRand(OreSpawnMain.MyCrystalTNTRock, 1);
        }
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)((OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0f), this.posY + 0.25, this.posZ + (double)((OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0f), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ButterflyType", this.rock_type);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.rock_type = par1NBTTagCompound.getInteger("ButterflyType");
    }
}

