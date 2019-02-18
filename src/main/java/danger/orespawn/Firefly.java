/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Firefly
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class Firefly
extends EntityAmbientCreature {
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Fireflytexture.png");
    int my_blink = 0;
    int blinker = 0;
    int myspace = 0;
    private ChunkCoordinates currentFlightTarget = null;

    public Firefly(World par1World) {
        super(par1World);
        this.my_blink = 20 + this.rand.nextInt(20);
        this.setSize(0.4f, 0.8f);
        this.getNavigator().setAvoidsWater(true);
        this.renderDistanceWeight = 3.0;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0);
    }

    public ResourceLocation getTexture(Firefly a) {
        return texture1;
    }

    protected void entityInit() {
        super.entityInit();
    }

    public float getBlink() {
        if (this.blinker < this.my_blink / 2) {
            return 240.0f;
        }
        return 0.0f;
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
        return 1;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block)OreSpawnMain.ExtremeTorch);
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
        if (this.isNoDespawnRequired()) {
            return;
        }
        long t = this.worldObj.getWorldTime();
        if ((t %= 24000L) > 11000L) {
            return;
        }
        if (this.worldObj.rand.nextInt(500) == 1) {
            this.setDead();
        }
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
        if (this.rand.nextInt(40) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0f) {
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(4) - this.rand.nextInt(4), (int)this.posY + this.rand.nextInt(4) - 2, (int)this.posZ + this.rand.nextInt(4) - this.rand.nextInt(4));
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                --keep_trying;
            }
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
        Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
        if (bid != Blocks.air) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.findBuddies() > 10) {
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

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(Firefly.class, this.boundingBox.expand(20.0, 8.0, 20.0));
        return var5.size();
    }

    public void initCreature() {
    }

    protected boolean canDespawn() {
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }
}

