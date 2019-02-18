/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.Cephadrome
 *  danger.orespawn.GammaMetroid
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.ItemOreSpawnArmor
 *  danger.orespawn.Kraken
 *  danger.orespawn.Leon
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyEntityAIWanderALot
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderInfo
 *  danger.orespawn.WaterDragon
 *  net.minecraft.block.Block
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityDragonPart
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
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
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.GammaMetroid;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.ItemOreSpawnArmor;
import danger.orespawn.Kraken;
import danger.orespawn.Leon;
import danger.orespawn.Mothra;
import danger.orespawn.MyEntityAIWanderALot;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RenderInfo;
import danger.orespawn.WaterDragon;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Cephadrome
extends EntityCreature {
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private int damage_counter = 100;
    private int updateit = 1;
    private int color = 1;
    private int playing = 0;
    private GenericTargetSorter TargetSorter = null;
    private RenderInfo renderdata = new RenderInfo();
    private int hurt_timer = 0;
    private int wasfed;
    private int shouldattack = 0;
    private int wing_sound = 0;
    private int hit_by_player = 0;
    private int badmood = 0;
    private float moveSpeed = 0.25f;

    public Cephadrome(World par1World) {
        super(par1World);
        this.setSize(2.5f, 2.25f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 200;
        this.fireResistance = 100;
        this.isImmuneToFire = false;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 9.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.riddenByEntity = null;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }

    public Cephadrome(World par1World, double par2, double par4, double par6) {
        this(par1World);
        this.setPosition(par2, par4 + (double)this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(70.0);
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public int getTrackingRange() {
        return 128;
    }

    public int getUpdateFrequency() {
        return 10;
    }

    public boolean sendsVelocityUpdates() {
        return true;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
        this.dataWatcher.addObject(21, (Object)0);
        this.setActivity(0);
        this.setAttacking(0);
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

    public int mygetMaxHealth() {
        return 300;
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

    public int getTotalArmorValue() {
        return 16;
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.1;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public String getLivingSound() {
        if (this.getActivity() != 1 && this.rand.nextInt(6) == 1) {
            return "orespawn:MothraWings";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:alo_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:alo_death";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    public float getSoundPitch() {
        return 1.0f;
    }

    public boolean canBePushed() {
        return false;
    }

    public double getMountedYOffset() {
        return 2.5;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(5) - (double)OreSpawnMain.OreSpawnRand.nextInt(5), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        int i = 4 + this.worldObj.rand.nextInt(6);
        for (var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        i = 4 + this.worldObj.rand.nextInt(6);
        for (var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
        i = 1 + this.worldObj.rand.nextInt(5);
        block17 : for (var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(20);
            ItemStack is;
            switch (var3) 
            {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    continue block17;
                }
                case 1: {
                    is = this.dropItemRand(Items.diamond, 1);
                    continue block17;
                }
                case 2: {
                    is = this.dropItemRand(OreSpawnMain.MyThunderStaff, 1);
                    continue block17;
                }
                case 3: {
                    is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 4: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyShovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 5: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 6: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 7: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 8: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block17;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block17;
                }
                case 9: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block17;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block17;
                }
                case 10: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block17;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block17;
                }
                case 11: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block17;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block17;
                }
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: {
                    is = this.dropItemRand(OreSpawnMain.MyRuby, 1);
                    break;
                }
            }
        }
    }

    public int getCephadromeHealth() {
        return (int)this.getHealth();
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        double ks = 2.5;
        double inair = 0.35;
        float iskraken = 1.0f;
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource((Explosion)null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(6) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 70.0f);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 70.0f);
            }
            ret = true;
        } else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof Kraken) {
                iskraken = 1.5f;
            }
            ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 70.0f);
            float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return ret;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.hurt_timer = 25;
            Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase) {
                this.setAttackTarget((EntityLivingBase)e);
                this.setTarget(e);
                this.getNavigator().tryMoveToEntityLiving((Entity)((EntityLivingBase)e), 1.2);
                ret = true;
            }
            if (e != null && e instanceof EntityPlayer && this.getHealth() < this.getMaxHealth() * 9.0f / 10.0f) {
                this.hit_by_player = 1;
            }
        }
        return ret;
    }

    public double getHorizontalDistanceSqToEntity(Entity par1Entity) {
        double d0 = this.posX - par1Entity.posX;
        double d2 = this.posZ - par1Entity.posZ;
        return d0 * d0 + d2 * d2;
    }

    public void updateAITasks() {
        EntityLivingBase e = null;
        double maxdist = 10.0;
        if (this.isDead) {
            return;
        }
        if (this.updateit > 0) {
            --this.updateit;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.updateit <= 0 && !this.worldObj.isRemote) {
            this.updateit = 30;
            if (this.riddenByEntity != null) {
                this.setActivity(1);
            } else {
                this.setActivity(0);
            }
        }
        if (this.worldObj.rand.nextInt(100) == 1 && this.getHealth() < (float)this.mygetMaxHealth()) {
            this.heal(2.0f);
        }
        if (this.getActivity() == 0) {
            super.updateAITasks();
        }
        if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                if (this.getActivity() == 0) {
                    this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.7);
                    maxdist = 6.0;
                }
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                this.setAttacking(1);
                if (this.getDistanceSqToEntity((Entity)e) < (maxdist + (double)(e.width / 2.0f)) * (maxdist + (double)(e.width / 2.0f))) {
                    this.attackEntityAsMob((Entity)e);
                } else if (e instanceof Kraken && this.getHorizontalDistanceSqToEntity((Entity)e) < (maxdist + (double)(e.width / 2.0f)) * (maxdist + (double)(e.width / 2.0f))) {
                    this.attackEntityAsMob((Entity)e);
                }
            } else if (this.getAttacking() != 0) {
                this.setAttacking(0);
            }
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
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Cephadrome) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Leon) {
            EntityTameable et = (EntityTameable)par1EntityLiving;
            if (et.isTamed()) {
                return false;
            }
            return true;
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            EntityTameable et = (EntityTameable)par1EntityLiving;
            if (et.isTamed()) {
                return false;
            }
            return true;
        }
        if (par1EntityLiving instanceof WaterDragon) {
            EntityTameable et = (EntityTameable)par1EntityLiving;
            if (et.isTamed()) {
                return false;
            }
            return true;
        }
        if (par1EntityLiving instanceof EntityDragon) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            if (this.hit_by_player != 0) {
                return true;
            }
            if (this.badmood != 0) {
                return true;
            }
            if (this.shouldattack > 0) {
                this.shouldattack = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 20.0, 16.0));
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
                    if (s == null || !s.equals("Cephadrome")) continue;
                    this.badmood = 1;
                    return true;
                }
            }
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        for (k = -2; k < 2; ++k) {
            for (j = -2; j < 2; ++j) {
                for (i = 1; i < 5; ++i) {
                    bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
                    if (bid == Blocks.air) continue;
                    return false;
                }
            }
        }
        Cephadrome target = null;
        target = (Cephadrome)this.worldObj.findNearestEntityWithinAABB(Cephadrome.class, this.boundingBox.expand(16.0, 6.0, 16.0), (Entity)this);
        if (target != null) {
            return false;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
        super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
        this.boatPosRotationIncrements = par9;
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.boatYawHead = par7;
    }

    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double par1, double par3, double par5) {
        super.setVelocity(par1, par3, par5);
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 22) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5f, 1.0f);
                }
                this.wing_sound = 0;
            }
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.wasfed = 1;
        }
    }

    public void onLivingUpdate() {
        List list = null;
        Entity listEntity = null;
        double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        double d7 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 1.15;
        double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
        if (this.getActivity() == 0) {
            super.onLivingUpdate();
        } else if (this.isDead) {
            super.onLivingUpdate();
            return;
        }
        if (this.isDead) {
            return;
        }
        if (this.worldObj.isRemote) {
            if (this.boatPosRotationIncrements > 0 && this.getActivity() != 0) {
                double d4 = this.posX + (this.boatX - this.posX) / (double)this.boatPosRotationIncrements;
                double d5 = this.posY + (this.boatY - this.posY) / (double)this.boatPosRotationIncrements;
                double d11 = this.posZ + (this.boatZ - this.posZ) / (double)this.boatPosRotationIncrements;
                this.setPosition(d4, d5, d11);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.boatPitch - (double)this.rotationPitch) / (double)this.boatPosRotationIncrements);
                double d10 = MathHelper.wrapAngleTo180_double((double)(this.boatYaw - (double)this.rotationYaw));
                if (this.riddenByEntity != null) {
                    d10 = MathHelper.wrapAngleTo180_double((double)((double)this.riddenByEntity.rotationYaw - (double)this.rotationYaw));
                }
                this.rotationYaw = (float)((double)this.rotationYaw + d10 / (double)this.boatPosRotationIncrements);
                this.setRotation(this.rotationYaw, this.rotationPitch);
                --this.boatPosRotationIncrements;
            }
        } else if (this.getActivity() != 0) {
            if (this.riddenByEntity != null) {
                double rdv;
                EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
                if (this.motionX < -2.0) {
                    this.motionX = -2.0;
                }
                if (this.motionX > 2.0) {
                    this.motionX = 2.0;
                }
                if (this.motionZ < -2.0) {
                    this.motionZ = -2.0;
                }
                if (this.motionZ > 2.0) {
                    this.motionZ = 2.0;
                }
                double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                gh = 1.55;
                Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
                if (bid != Blocks.air) {
                    this.motionY += 0.07;
                    this.posY += 0.1;
                } else {
                    this.motionY -= 0.018;
                }
                obstruction_factor = 0.0;
                dist = 2;
                for (int k = 1; k < (dist += (int)(velocity * 6.0)); ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        double dz;
                        double dx = (double)i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                        bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + (dz = (double)i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f)))));
                        if (bid == Blocks.air) continue;
                        obstruction_factor += 0.04;
                    }
                }
                this.motionY += obstruction_factor * 0.09;
                this.posY += obstruction_factor * 0.09;
                if (this.motionY > 2.0) {
                    this.motionY = 2.0;
                }
                double d4 = this.riddenByEntity.rotationYaw;
                d4 %= 360.0;
                while (d4 < 0.0) {
                    d4 += 360.0;
                }
                double d5 = this.rotationYaw;
                d5 %= 360.0;
                while (d5 < 0.0) {
                    d5 += 360.0;
                }
                for (relative_g = (d4 - d5) % 180.0; relative_g < 0.0; relative_g += 180.0) {
                }
                if (relative_g > 90.0) {
                    relative_g -= 180.0;
                }
                if (velocity > 0.1) {
                    d4 = 1.5 - velocity;
                    if ((d4 = Math.abs(d4)) < 0.01) {
                        d4 = 0.01;
                    }
                    if (d4 > 0.9) {
                        d4 = 0.9;
                    }
                    this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
                } else {
                    this.rotationYaw = this.riddenByEntity.rotationYaw;
                }
                relative_g = Math.abs(relative_g) * velocity;
                if (relative_g > 50.0) {
                    relative_g = 0.0;
                }
                this.rotationPitch = this.motionY > 0.0 ? 360.0f - 2.0f * (float)velocity : 2.0f * (float)velocity;
                this.setRotation(this.rotationYaw, this.rotationPitch);
                double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
                double rhm = Math.atan2(this.motionZ, this.motionX);
                double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
                rt = 0.0;
                pi = 3.1415926545;
                deltav = 0.0;
                double im = pp.moveForward;
                if (OreSpawnMain.flyup_keystate != 0) {
                    this.motionY += 0.04;
                    this.motionY += velocity * 0.05;
                }
                if ((rdv = Math.abs(rhm - rhdir) % (pi * 2.0)) > pi) {
                    rdv -= pi * 2.0;
                }
                rdv = Math.abs(rdv);
                if (Math.abs(newvelocity) < 0.01) {
                    rdv = 0.0;
                }
                if (rdv > 1.5) {
                    newvelocity = - newvelocity;
                }
                if (Math.abs(im) > 0.0010000000474974513) {
                    if (im > 0.0) {
                        deltav = 0.03;
                        if (max_speed > 0.85) {
                            deltav += 0.05;
                        }
                    } else {
                        max_speed = 0.35;
                        deltav = -0.03;
                    }
                    if ((newvelocity += deltav) >= 0.0) {
                        if (newvelocity > max_speed) {
                            newvelocity = max_speed;
                        }
                        this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                        this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                    } else {
                        if (newvelocity < - max_speed) {
                            newvelocity = - max_speed;
                        }
                        newvelocity = - newvelocity;
                        this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                        this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                    }
                } else if (newvelocity >= 0.0) {
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                } else {
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.985;
            this.motionY *= 0.94;
            this.motionZ *= 0.985;
            if (!this.worldObj.isRemote && (list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(2.25, 2.0, 2.25))) != null && !list.isEmpty()) {
                for (int l = 0; l < list.size(); ++l) {
                    listEntity = (Entity)list.get(l);
                    if (listEntity == this.riddenByEntity || listEntity.isDead || !listEntity.canBePushed()) continue;
                    listEntity.applyEntityCollision((Entity)this);
                }
            }
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                this.riddenByEntity = null;
            }
        }
        if (this.getActivity() == 1) {
            this.updateAITasks();
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            float f = 0.75f;
            this.riddenByEntity.setPosition(this.posX - (double)f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + (double)f * Math.cos(Math.toRadians(this.rotationYaw)));
        }
    }

    protected void playTameEffect(boolean par1) {
        String s = "heart";
        if (!par1) {
            s = "smoke";
        }
        for (int i = 0; i < 20; ++i) {
            double d0 = this.rand.nextGaussian() * 0.08;
            double d1 = this.rand.nextGaussian() * 0.08;
            double d2 = this.rand.nextGaussian() * 0.08;
            this.worldObj.spawnParticle(s, this.posX + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f), this.posY + 0.5 + (double)this.rand.nextFloat() * 1.5, this.posZ + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f), d0, d1, d2);
        }
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && (var2.getItem() == Items.beef || var2.getItem() == Items.chicken || var2.getItem() == Items.porkchop) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0) {
            if (!this.worldObj.isRemote) {
                this.heal((float)this.mygetMaxHealth() - this.getHealth());
            }
            this.wasfed = 1;
            this.shouldattack = 0;
            this.playTameEffect(true);
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    var2 = null;
                }
            }
        } else {
            if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer) {
                return true;
            }
            if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0 && !this.worldObj.isRemote) {
                if (this.wasfed == 0) {
                    this.getNavigator().tryMoveToEntityLiving((Entity)par1EntityPlayer, 1.2);
                    this.shouldattack = 1;
                    return false;
                }
                par1EntityPlayer.mountEntity((Entity)this);
                this.wasfed = 0;
            }
            return true;
        }
        return false;
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public void setAttacking(int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    public int getActivity() {
        return this.dataWatcher.getWatchableObjectByte(21);
    }

    public void setActivity(int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(21, (Object)((byte)par1));
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        if (this.riddenByEntity != null) {
            return false;
        }
        return true;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("CephaWasFed", this.wasfed);
        par1NBTTagCompound.setInteger("CephaAttacking", this.getAttacking());
        par1NBTTagCompound.setInteger("CephaActivity", this.getActivity());
        par1NBTTagCompound.setInteger("CephaHitByPlayer", this.hit_by_player);
        par1NBTTagCompound.setInteger("CephaBadMood", this.badmood);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wasfed = par1NBTTagCompound.getInteger("CephaWasFed");
        this.hit_by_player = par1NBTTagCompound.getInteger("CephaHitByPlayer");
        this.badmood = par1NBTTagCompound.getInteger("CephaBadMood");
        this.setAttacking(par1NBTTagCompound.getInteger("CephaAttacking"));
        this.setActivity(par1NBTTagCompound.getInteger("CephaActivity"));
    }
}

