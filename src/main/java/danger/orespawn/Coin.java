/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Coin
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Coin
extends EntityAnimal {
    private float moveSpeed = 0.0f;

    public Coin(World par1World) {
        super(par1World);
        this.setSize(1.5f, 1.5f);
        this.experienceValue = 10;
        this.fireResistance = 100;
        this.tasks.addTask(0, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 1;
    }

    public int getTotalArmorValue() {
        return 0;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
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
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return null;
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int i = this.worldObj.rand.nextInt(10);
        Item j = OreSpawnMain.MyEmeraldSword;
        if (i == 0) {
            j = Items.diamond;
        }
        if (i == 1) {
            j = OreSpawnMain.UraniumNugget;
        }
        if (i == 2) {
            j = OreSpawnMain.TitaniumNugget;
        }
        if (i == 3) {
            j = Items.emerald;
        }
        if (i == 4) {
            j = OreSpawnMain.MyEmeraldAxe;
        }
        if (i == 5) {
            j = OreSpawnMain.MyEmeraldShovel;
        }
        if (i == 6) {
            j = OreSpawnMain.MyEmeraldPickaxe;
        }
        if (i == 7) {
            j = OreSpawnMain.MyEmeraldHoe;
        }
        if (i == 8) {
            j = OreSpawnMain.CoinEgg;
        }
        this.dropItemRand(j, 1);
    }

    public void initCreature() {
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean getCanSpawnHere() {
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        Coin target = null;
        target = (Coin)this.worldObj.findNearestEntityWithinAABB(Coin.class, this.boundingBox.expand(20.0, 8.0, 20.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    public EntityAgeable createChild(EntityAgeable entityageable) {
        return null;
    }
}

