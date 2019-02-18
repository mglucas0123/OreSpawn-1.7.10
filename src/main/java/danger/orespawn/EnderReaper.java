/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EnderReaper
 *  danger.orespawn.MobStats
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntityDamageSourceIndirect
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.MobStats;
import danger.orespawn.OreSpawnMain;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EnderReaper
extends EntityMob {
    private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier attackingSpeedBoostModifier = new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137, 0).setSaved(false);
    private int teleportDelay;
    private int stareTimer;
    private Entity lastEntityToAttack;

    public EnderReaper(World par1World) {
        super(par1World);
        this.setSize(0.7f, 2.9f);
        this.stepHeight = 1.0f;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)OreSpawnMain.EnderReaper_stats.health);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.37);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.EnderReaper_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, (Object)new Byte((byte) 0));
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    protected Entity findPlayerToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 81.0);
        if (entityplayer != null) {
            if (this.shouldAttackPlayer(entityplayer)) {
                if (this.stareTimer == 0) {
                    this.worldObj.playSoundAtEntity((Entity)entityplayer, "mob.endermen.stare", 1.0f, 1.0f);
                }
                if (this.stareTimer++ == 5) {
                    this.stareTimer = 0;
                }
                this.setScreaming(true);
                return entityplayer;
            }
            this.stareTimer = 0;
            this.setScreaming(false);
        }
        return null;
    }

    private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer) {
        ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[3];
        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock((Block)Blocks.pumpkin)) {
            return false;
        }
        Vec3 vec3 = par1EntityPlayer.getLook(1.0f).normalize();
        Vec3 vec31 = Vec3.createVectorHelper((double)(this.posX - par1EntityPlayer.posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight())), (double)(this.posZ - par1EntityPlayer.posZ));
        double d0 = vec31.lengthVector();
        double d1 = vec3.dotProduct(vec31 = vec31.normalize());
        return d1 > 1.0 - 0.025 / d0 ? par1EntityPlayer.canEntityBeSeen((Entity)this) : false;
    }

    public void onLivingUpdate() {
        float f;
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.lastEntityToAttack != this.entityToAttack) {
            IAttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            attributeinstance.removeModifier(attackingSpeedBoostModifier);
            if (this.entityToAttack != null) {
                attributeinstance.applyModifier(attackingSpeedBoostModifier);
            }
        }
        this.lastEntityToAttack = this.entityToAttack;
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, - this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
        }
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && (f = this.getBrightness(1.0f)) > 0.5f && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ)) && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.teleportRandomly();
        }
        if (this.isWet() || this.isBurning()) {
            this.setScreaming(false);
            this.teleportRandomly();
        }
        this.isJumping = false;
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0f, 100.0f);
        }
        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            if (this.entityToAttack != null) {
                if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack)) {
                    if (this.entityToAttack.getDistanceSqToEntity((Entity)this) < 16.0) {
                        this.teleportRandomly();
                    }
                    this.teleportDelay = 0;
                } else if (this.entityToAttack.getDistanceSqToEntity((Entity)this) > 256.0 && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack)) {
                    this.teleportDelay = 0;
                }
            } else {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }
        super.onLivingUpdate();
    }

    protected boolean teleportRandomly() {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d0, d1, d2);
    }

    protected boolean teleportToEntity(Entity par1Entity) {
        Vec3 vec3 = Vec3.createVectorHelper((double)(this.posX - par1Entity.posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - par1Entity.posY + (double)par1Entity.getEyeHeight()), (double)(this.posZ - par1Entity.posZ));
        vec3 = vec3.normalize();
        double d0 = 16.0;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.xCoord * d0;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.zCoord * d0;
        return this.teleportTo(d1, d2, d3);
    }

    protected boolean teleportTo(double par1, double par3, double par5) {
        int j;
        int k;
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        boolean flag = false;
        int i = MathHelper.floor_double((double)this.posX);
        if (this.worldObj.blockExists(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)this.posZ))) {
            boolean flag1 = false;
            while (!flag1 && j > 0) {
                Block l = this.worldObj.getBlock(i, j - 1, k);
                if (l != Blocks.air && l.getMaterial().blocksMovement()) {
                    flag1 = true;
                    continue;
                }
                this.posY -= 1.0;
                --j;
            }
            if (flag1) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.setPosition(d3, d4, d5);
            return false;
        }
        int short1 = 128;
        for (int lx = 0; lx < short1; ++lx) {
            double d6 = (double)lx / ((double)short1 - 1.0);
            float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
            double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
        }
        this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }

    protected String getLivingSound() {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }

    protected String getHurtSound() {
        return "mob.endermen.hit";
    }

    protected String getDeathSound() {
        return "mob.endermen.death";
    }

    protected Item getDropItem() {
        return Items.ender_eye;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.EnderReaper_stats.defense;
    }

    protected void dropFewItems(boolean par1, int par2) {
        Item j = this.getDropItem();
        if (j != null) {
            int k = this.rand.nextInt(2 + par2);
            for (int l = 0; l < k; ++l) {
                this.dropItem(j, 1);
            }
        }
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setScreaming(true);
        if (par1DamageSource instanceof EntityDamageSourceIndirect) {
            for (int i = 0; i < 16; ++i) {
                if (!this.teleportRandomly()) continue;
                return true;
            }
            return super.attackEntityFrom(par1DamageSource, par2);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid != Blocks.mob_spawner) continue;
                    TileEntityMobSpawner tileentitymobspawner = null;
                    tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    String s = tileentitymobspawner.func_145881_a().getEntityNameToSpawn();
                    if (s == null || !s.equals("Ender Reaper")) continue;
                    return true;
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.posY < 30.0) {
            return false;
        }
        EnderReaper target = null;
        target = (EnderReaper)this.worldObj.findNearestEntityWithinAABB(EnderReaper.class, this.boundingBox.expand(16.0, 8.0, 16.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    public boolean isScreaming() {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }

    public void setScreaming(boolean par1) {
        this.dataWatcher.updateObject(18, (Object)((byte)(par1 ? 1 : 0)));
    }
}

