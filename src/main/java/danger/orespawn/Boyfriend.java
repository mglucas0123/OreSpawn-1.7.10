/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Elevator
 *  danger.orespawn.ItemOreSpawnArmor
 *  danger.orespawn.MyEntityAIFollowOwner
 *  danger.orespawn.MyEntityAIJealousy
 *  danger.orespawn.MyEntityAINearestAttackableTarget
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Shoes
 *  danger.orespawn.UltimateArrow
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIArrowAttack
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveIndoors
 *  net.minecraft.entity.ai.EntityAIOpenDoor
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntityAITempt
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Elevator;
import danger.orespawn.ItemOreSpawnArmor;
import danger.orespawn.MyEntityAIFollowOwner;
import danger.orespawn.MyEntityAIJealousy;
import danger.orespawn.MyEntityAINearestAttackableTarget;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.Shoes;
import danger.orespawn.UltimateArrow;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Boyfriend
extends EntityTameable
implements IRangedAttackMob {
    public int which_guy = 0;
    public int which_wet_guy = 0;
    public int wet_count = 0;
    private int auto_heal = 200;
    private int force_sync = 50;
    private int fight_sound_ticker = 0;
    private int taunt_sound_ticker = 0;
    private int had_target = 0;
    private int voice = 0;
    private float moveSpeed = 0.3f;
    private int voice_enable = 1;
    public int passenger = 0;
    private int is_prince = 0;
    private static final ResourceLocation DryTexture0 = new ResourceLocation("orespawn", "boyfriend0.png");
    private static final ResourceLocation DryTexture1 = new ResourceLocation("orespawn", "boyfriend1.png");
    private static final ResourceLocation DryTexture2 = new ResourceLocation("orespawn", "boyfriend2.png");
    private static final ResourceLocation DryTexture3 = new ResourceLocation("orespawn", "boyfriend3.png");
    private static final ResourceLocation DryTexture4 = new ResourceLocation("orespawn", "boyfriend4.png");
    private static final ResourceLocation DryTexture5 = new ResourceLocation("orespawn", "boyfriend5.png");
    private static final ResourceLocation DryTexture6 = new ResourceLocation("orespawn", "boyfriend6.png");
    private static final ResourceLocation DryTexture7 = new ResourceLocation("orespawn", "boyfriend7.png");
    private static final ResourceLocation DryTexture8 = new ResourceLocation("orespawn", "boyfriend8.png");
    private static final ResourceLocation DryTexture9 = new ResourceLocation("orespawn", "boyfriend9.png");
    private static final ResourceLocation DryTexture10 = new ResourceLocation("orespawn", "boyfriend10.png");
    private static final ResourceLocation DryTexture11 = new ResourceLocation("orespawn", "boyfriend11.png");
    private static final ResourceLocation DryTexture12 = new ResourceLocation("orespawn", "boyfriend12.png");
    private static final ResourceLocation DryTexture13 = new ResourceLocation("orespawn", "boyfriend13.png");
    private static final ResourceLocation DryTexture14 = new ResourceLocation("orespawn", "boyfriend14.png");
    private static final ResourceLocation DryTexture15 = new ResourceLocation("orespawn", "boyfriend15.png");
    private static final ResourceLocation DryTexture16 = new ResourceLocation("orespawn", "boyfriend16.png");
    private static final ResourceLocation DryTexture17 = new ResourceLocation("orespawn", "boyfriend17.png");
    private static final ResourceLocation DryTexture18 = new ResourceLocation("orespawn", "boyfriend18.png");
    private static final ResourceLocation DryTexture19 = new ResourceLocation("orespawn", "boyfriend19.png");
    private static final ResourceLocation DryTexture20 = new ResourceLocation("orespawn", "boyfriend20.png");
    private static final ResourceLocation DryTexture21 = new ResourceLocation("orespawn", "boyfriend21.png");
    private static final ResourceLocation DryTexture22 = new ResourceLocation("orespawn", "boyfriend22.png");
    private static final ResourceLocation DryTexture23 = new ResourceLocation("orespawn", "boyfriend23.png");
    private static final ResourceLocation DryTexture24 = new ResourceLocation("orespawn", "boyfriend24.png");
    private static final ResourceLocation DryTexture25 = new ResourceLocation("orespawn", "boyfriend25.png");
    private static final ResourceLocation DryTexture26 = new ResourceLocation("orespawn", "boyfriend26.png");
    private static final ResourceLocation DryTexture27 = new ResourceLocation("orespawn", "boyfriend27.png");
    private static final ResourceLocation WetTexture0 = new ResourceLocation("orespawn", "swimshorts0.png");
    private static final ResourceLocation WetTexture1 = new ResourceLocation("orespawn", "swimshorts1.png");
    private static final ResourceLocation WetTexture2 = new ResourceLocation("orespawn", "swimshorts2.png");
    private static final ResourceLocation WetTexture3 = new ResourceLocation("orespawn", "swimshorts3.png");
    private static final ResourceLocation WetTexture4 = new ResourceLocation("orespawn", "swimshorts4.png");
    private static final ResourceLocation WetTexture5 = new ResourceLocation("orespawn", "swimshorts5.png");
    private static final ResourceLocation WetTexture6 = new ResourceLocation("orespawn", "swimshorts6.png");
    private static final ResourceLocation WetTexture7 = new ResourceLocation("orespawn", "swimshorts7.png");
    private static final ResourceLocation WetTexture8 = new ResourceLocation("orespawn", "swimshorts8.png");
    private static final ResourceLocation WetTexture9 = new ResourceLocation("orespawn", "swimshorts9.png");
    private static final ResourceLocation WetTexture10 = new ResourceLocation("orespawn", "swimshorts10.png");
    private static final ResourceLocation WetTexture11 = new ResourceLocation("orespawn", "swimshorts11.png");
    private static final ResourceLocation WetTexture12 = new ResourceLocation("orespawn", "swimshorts12.png");
    private static final ResourceLocation WetTexture13 = new ResourceLocation("orespawn", "swimshorts13.png");
    private static final ResourceLocation WetTexture14 = new ResourceLocation("orespawn", "swimshorts14.png");
    private static final ResourceLocation WetTexture15 = new ResourceLocation("orespawn", "swimshorts15.png");
    private static final ResourceLocation WetTexture16 = new ResourceLocation("orespawn", "swimshorts16.png");
    private static final ResourceLocation WetTexture17 = new ResourceLocation("orespawn", "swimshorts17.png");
    private static final ResourceLocation PrinceTexture1 = new ResourceLocation("orespawn", "FrogPrince.png");
    private static final ResourceLocation PrinceTexture2 = new ResourceLocation("orespawn", "FrogPrince2.png");

    public Boyfriend(World par1World) {
        super(par1World);
        this.which_guy = this.rand.nextInt(28);
        this.voice = this.rand.nextInt(10);
        this.which_wet_guy = this.rand.nextInt(18);
        this.setSize(0.5f, 1.6f);
        this.isImmuneToFire = true;
        this.fireResistance = 100;
        this.getNavigator().setAvoidsWater(false);
        this.setSitting(false);
        this.tasks.addTask(1, (EntityAIBase)new MyEntityAIFollowOwner((EntityTameable)this, 1.4f, 12.0f, 1.5f));
        this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.cooked_beef, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.tasks.addTask(5, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(10, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
        this.tasks.addTask(11, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(2, (EntityAIBase)new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityCreeper.class, 20.0f, 0, true, true, IMob.mobSelector));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(3, (EntityAIBase)new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityLiving.class, 15.0f, 0, true, true, IMob.mobSelector));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(4, (EntityAIBase)new MyEntityAIJealousy((EntityTameable)this, Boyfriend.class, 6.0f, 5, true));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(5, (EntityAIBase)new MyEntityAIJealousy((EntityTameable)this, Boyfriend.class, 3.0f, 15, true));
        }
        this.experienceValue = 0;
    }

    protected void entityInit() {
        super.entityInit();
        this.which_guy = this.rand.nextInt(28);
        this.dataWatcher.addObject(20, (Object)this.which_guy);
        this.wet_count = 0;
        this.which_wet_guy = this.rand.nextInt(18);
        this.dataWatcher.addObject(22, (Object)this.which_wet_guy);
        this.voice = this.rand.nextInt(10);
        this.dataWatcher.addObject(21, (Object)this.voice);
        this.dataWatcher.addObject(23, (Object)this.voice_enable);
        this.dataWatcher.addObject(24, (Object)this.is_prince);
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.setSitting(false);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
    }

    public int getTotalArmorValue() {
        int i = 0;
        for (ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack == null || !(itemstack.getItem() instanceof ItemArmor)) continue;
            int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
            i += l;
        }
        if (i < 8) {
            i = 8;
        }
        if (i > 23) {
            i = 23;
        }
        return i;
    }

    public void onUpdate() {
        EntityLivingBase e;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onUpdate();
        this.passenger = 0;
        if (this.isTamed() && !this.isSitting() && (e = this.getOwner()) != null && e instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)e;
            Entity r = e.ridingEntity;
            if (r != null && r instanceof Elevator) {
                float f = -0.45f;
                this.setPosition(r.posX - (double)f * Math.sin(Math.toRadians(r.rotationYaw)), r.posY, r.posZ + (double)f * Math.cos(Math.toRadians(r.rotationYaw)));
                this.rotationYaw = r.rotationYaw;
                this.rotationPitch = r.rotationPitch;
                this.limbSwingAmount = 0.0f;
                this.limbSwing = 0.0f;
                this.fallDistance = 0.0f;
                this.passenger = 1;
            }
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("GirlType", this.getTameSkin());
        par1NBTTagCompound.setInteger("WetGirlType", this.getWetTameSkin());
        par1NBTTagCompound.setInteger("GirlVoice", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("GirlVoiceEnable", this.dataWatcher.getWatchableObjectInt(23));
        par1NBTTagCompound.setInteger("IsPrince", this.dataWatcher.getWatchableObjectInt(24));
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.which_guy = par1NBTTagCompound.getInteger("GirlType");
        this.setTameSkin(this.which_guy);
        this.which_wet_guy = par1NBTTagCompound.getInteger("WetGirlType");
        this.setWetTameSkin(this.which_wet_guy);
        this.voice = par1NBTTagCompound.getInteger("GirlVoice");
        this.dataWatcher.updateObject(21, (Object)this.voice);
        this.voice_enable = par1NBTTagCompound.getInteger("GirlVoiceEnable");
        this.dataWatcher.updateObject(23, (Object)this.voice_enable);
        this.is_prince = par1NBTTagCompound.getInteger("IsPrince");
        this.dataWatcher.updateObject(24, (Object)this.is_prince);
    }

    protected void updateAITick() {
        super.updateAITick();
        ItemStack stack = this.getCurrentEquippedItem();
        EntityLivingBase victim = this.getAttackTarget();
        if (OreSpawnMain.PlayNicely != 0) {
            victim = null;
        }
        if (this.worldObj.rand.nextInt(100) == 1) {
            this.setRevengeTarget(null);
        }
        if (stack != null && !this.isSitting()) {
            if (victim != null) {
                if (victim instanceof EntityLivingBase && this.getHeldItem() != null) {
                    if (this.getDistanceToEntity((Entity)victim) < 4.0f || stack.getItem() == OreSpawnMain.MyBertha && this.getDistanceToEntity((Entity)victim) < 10.0f) {
                        --this.attackTime;
                        if (this.attackTime <= 0) {
                            this.attackTime = 25;
                            this.swingItem();
                            this.attackTargetEntityWithCurrentItem((Entity)victim);
                            --this.fight_sound_ticker;
                            if (this.fight_sound_ticker <= 0) {
                                if (!this.worldObj.isRemote && this.voice_enable != 0) {
                                    this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_fight", 0.5f, this.getSoundPitch());
                                }
                                this.fight_sound_ticker = 3;
                            }
                            this.had_target = 1;
                        }
                    } else if (this.getDistanceToEntity((Entity)victim) < 7.0f && stack.getItem() != OreSpawnMain.MyUltimateBow) {
                        --this.taunt_sound_ticker;
                        if (this.taunt_sound_ticker <= 0) {
                            if (!this.worldObj.isRemote && this.voice_enable != 0) {
                                this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_taunt", 0.5f, this.getSoundPitch());
                            }
                            this.taunt_sound_ticker = 300;
                        }
                        this.getNavigator().tryMoveToEntityLiving((Entity)victim, 1.25);
                    }
                }
            } else {
                this.fight_sound_ticker = 0;
                this.attackTime = 0;
                if (this.had_target != 0) {
                    this.had_target = 0;
                    if (!this.worldObj.isRemote && this.voice_enable != 0) {
                        this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_woohoo", 0.4f, this.getSoundPitch());
                    }
                }
            }
        }
    }

    public void setPrince(int par1) {
        this.is_prince = par1;
    }

    public ResourceLocation getTexture() {
        if (this.wet_count <= 0) {
            int txture = this.getTameSkin();
            if (this.is_prince == 1) {
                return PrinceTexture1;
            }
            if (this.is_prince == 2) {
                return PrinceTexture2;
            }
            if (txture == 0) {
                return DryTexture0;
            }
            if (txture == 1) {
                return DryTexture1;
            }
            if (txture == 2) {
                return DryTexture2;
            }
            if (txture == 3) {
                return DryTexture3;
            }
            if (txture == 4) {
                return DryTexture4;
            }
            if (txture == 5) {
                return DryTexture5;
            }
            if (txture == 6) {
                return DryTexture6;
            }
            if (txture == 7) {
                return DryTexture7;
            }
            if (txture == 8) {
                return DryTexture8;
            }
            if (txture == 9) {
                return DryTexture9;
            }
            if (txture == 10) {
                return DryTexture10;
            }
            if (txture == 11) {
                return DryTexture11;
            }
            if (txture == 12) {
                return DryTexture12;
            }
            if (txture == 13) {
                return DryTexture13;
            }
            if (txture == 14) {
                return DryTexture14;
            }
            if (txture == 15) {
                return DryTexture15;
            }
            if (txture == 16) {
                return DryTexture16;
            }
            if (txture == 17) {
                return DryTexture17;
            }
            if (txture == 18) {
                return DryTexture18;
            }
            if (txture == 19) {
                return DryTexture19;
            }
            if (txture == 20) {
                return DryTexture20;
            }
            if (txture == 21) {
                return DryTexture21;
            }
            if (txture == 22) {
                return DryTexture22;
            }
            if (txture == 23) {
                return DryTexture23;
            }
            if (txture == 24) {
                return DryTexture24;
            }
            if (txture == 25) {
                return DryTexture25;
            }
            if (txture == 26) {
                return DryTexture26;
            }
            if (txture == 27) {
                return DryTexture27;
            }
        } else {
            int temp = this.getWetTameSkin();
            if (temp == 0) {
                return WetTexture0;
            }
            if (temp == 1) {
                return WetTexture1;
            }
            if (temp == 2) {
                return WetTexture2;
            }
            if (temp == 3) {
                return WetTexture3;
            }
            if (temp == 4) {
                return WetTexture4;
            }
            if (temp == 5) {
                return WetTexture5;
            }
            if (temp == 6) {
                return WetTexture6;
            }
            if (temp == 7) {
                return WetTexture7;
            }
            if (temp == 8) {
                return WetTexture8;
            }
            if (temp == 9) {
                return WetTexture9;
            }
            if (temp == 10) {
                return WetTexture10;
            }
            if (temp == 11) {
                return WetTexture11;
            }
            if (temp == 12) {
                return WetTexture12;
            }
            if (temp == 13) {
                return WetTexture13;
            }
            if (temp == 14) {
                return WetTexture14;
            }
            if (temp == 15) {
                return WetTexture15;
            }
            if (temp == 16) {
                return WetTexture16;
            }
            if (temp == 17) {
                return WetTexture17;
            }
        }
        return null;
    }

    public int getTameSkin() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public int getVoice() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setTameSkin(int par1) {
        this.dataWatcher.updateObject(20, (Object)par1);
        this.which_guy = par1;
    }

    public int getWetTameSkin() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setWetTameSkin(int par1) {
        this.dataWatcher.updateObject(22, (Object)par1);
        this.which_wet_guy = par1;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void fall(float par1) {
        float i = MathHelper.ceiling_float_int((float)(par1 - 3.0f));
        if (i > 0.0f) {
            if (i > 3.0f) {
                this.playSound("damage.fallbig", 1.0f, 1.0f);
                i = 3.0f;
            } else {
                this.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, i);
        }
    }

    public int mygetMaxHealth() {
        return 80;
    }

    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
        if (this.isInWater() || this.handleLavaMovement()) {
            this.wet_count = 500;
        } else if (this.wet_count > 0) {
            --this.wet_count;
        }
        --this.auto_heal;
        if (this.auto_heal <= 0) {
            if (this.mygetMaxHealth() > this.getBoyfriendHealth()) {
                this.heal(1.0f);
            }
            this.auto_heal = 150;
        }
        --this.force_sync;
        if (this.force_sync <= 0) {
            this.force_sync = 20;
            if (!this.worldObj.isRemote) {
                this.dataWatcher.updateObject(21, (Object)this.voice);
                this.dataWatcher.updateObject(23, (Object)this.voice_enable);
                this.dataWatcher.updateObject(24, (Object)this.is_prince);
                this.setSitting(this.isSitting());
            } else {
                this.voice = this.getVoice();
                this.voice_enable = this.dataWatcher.getWatchableObjectInt(23);
                this.is_prince = this.dataWatcher.getWatchableObjectInt(24);
            }
        }
    }

    public int getBoyfriendHealth() {
        return (int)this.getHealth();
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && (var2.getItem() == Items.cooked_beef || var2.getItem() == OreSpawnMain.MyPeacock) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.worldObj.rand.nextInt(3) == 0) {
                        this.setTamed(true);
                        this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState((Entity)this, (byte)7);
                        this.heal((float)this.mygetMaxHealth() - this.getHealth());
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState((Entity)this, (byte)6);
                    }
                }
            } else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                if ((float)this.mygetMaxHealth() > this.getHealth()) {
                    this.heal((float)this.mygetMaxHealth() - this.getHealth());
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.func_152115_b("");
                this.playTameEffect(false);
                this.worldObj.setEntityState((Entity)this, (byte)6);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyRuby && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.voice_enable = 0;
                this.dataWatcher.updateObject(23, (Object)this.voice_enable);
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyAmethyst && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.voice_enable = 1;
                this.dataWatcher.updateObject(23, (Object)this.voice_enable);
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && (var2.getItem() == Items.leather || var2.getItem() == OreSpawnMain.MyPeacockFeather) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                if (this.wet_count > 0 || this.isInWater() || this.handleLavaMovement()) {
                    ++this.which_wet_guy;
                    if (this.which_wet_guy > 17) {
                        this.which_wet_guy = 0;
                    }
                    this.setWetTameSkin(this.which_wet_guy);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                    if (this.isInWater() || this.handleLavaMovement()) {
                        this.wet_count = 500;
                    }
                } else {
                    ++this.which_guy;
                    if (this.which_guy > 27) {
                        this.which_guy = 0;
                    }
                    this.setTameSkin(this.which_guy);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (var2.getItem() instanceof ItemFood) {
                if (!this.worldObj.isRemote) {
                    ItemFood var3 = (ItemFood)var2.getItem();
                    if ((float)this.mygetMaxHealth() > this.getHealth()) {
                        this.heal((float)(var3.func_150905_g(var2) * 5));
                    }
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    --var2.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
                }
            } else {
                if (!this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                ItemStack var3 = this.getCurrentEquippedItem();
                this.setCurrentItemOrArmor(0, var2);
                if (var2.getItem() == Items.diamond) {
                    this.setSitting(true);
                } else {
                    this.setSitting(false);
                }
                if (var3 != null) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
                } else {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    Item itm = var2.getItem();
                    if (itm instanceof ItemOreSpawnArmor) {
                        ItemStack v4;
                        if (itm == OreSpawnMain.EmeraldHelmet || itm == OreSpawnMain.AmethystHelmet || itm == OreSpawnMain.UltimateHelmet) {
                            v4 = this.getEquipmentInSlot(4);
                            this.setCurrentItemOrArmor(4, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBody || itm == OreSpawnMain.AmethystBody || itm == OreSpawnMain.UltimateBody) {
                            v4 = this.getEquipmentInSlot(3);
                            this.setCurrentItemOrArmor(3, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldLegs || itm == OreSpawnMain.AmethystLegs || itm == OreSpawnMain.UltimateLegs) {
                            v4 = this.getEquipmentInSlot(2);
                            this.setCurrentItemOrArmor(2, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBoots || itm == OreSpawnMain.AmethystBoots || itm == OreSpawnMain.UltimateBoots) {
                            v4 = this.getEquipmentInSlot(1);
                            this.setCurrentItemOrArmor(1, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                    }
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            this.setSitting(false);
            this.setTamed(true);
            this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
            this.playTameEffect(true);
            this.worldObj.setEntityState((Entity)this, (byte)7);
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            ItemStack var3 = this.getEquipmentInSlot(0);
            int it = 0;
            if (var3 == null) {
                var3 = this.getEquipmentInSlot(++it);
            }
            if (var3 == null) {
                var3 = this.getEquipmentInSlot(++it);
            }
            if (var3 == null) {
                var3 = this.getEquipmentInSlot(++it);
            }
            if (var3 == null) {
                var3 = this.getEquipmentInSlot(++it);
            }
            if (var3 != null) {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
                this.setCurrentItemOrArmor(it, null);
                this.setSitting(false);
                if (!this.worldObj.isRemote) {
                    this.worldObj.setEntityState((Entity)this, (byte)6);
                }
            } else if (!this.worldObj.isRemote) {
                this.setSitting(false);
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
                String healthMessage = new String();
                healthMessage = String.format("I have %d health. Thanks for asking!", this.getBoyfriendHealth());
                par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean isWheat(ItemStack par1ItemStack) {
        if (par1ItemStack != null && (par1ItemStack.getItem() == Items.cooked_beef || par1ItemStack.getItem() == OreSpawnMain.MyPeacock)) {
            return true;
        }
        return false;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting() || this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) {
            return null;
        }
        if (this.worldObj.rand.nextInt(11) == 1) {
            EntityLivingBase victim = this.getAttackTarget();
            if (victim != null) {
                return null;
            }
            if (this.isInWater() || this.handleLavaMovement()) {
                return "orespawn:b_water";
            }
            if (this.worldObj.rand.nextInt(4) != 0) {
                if (this.posY < 60.0) {
                    return null;
                }
                if (this.worldObj.isThundering()) {
                    return "orespawn:b_thunder";
                }
                if (this.worldObj.isRaining()) {
                    return "orespawn:b_rain";
                }
                if (!this.worldObj.isDaytime() && this.worldObj.canBlockSeeTheSky((int)this.posX, (int)this.posY, (int)this.posZ)) {
                    if (this.worldObj.rand.nextInt(3) == 0) {
                        return "orespawn:b_dark";
                    }
                    return null;
                }
            }
            if (this.isTamed()) {
                if ((float)this.mygetMaxHealth() > this.getHealth()) {
                    return "orespawn:b_hurt";
                }
                if (OreSpawnMain.bro_mode != 0) {
                    return "orespawn:bb_happy";
                }
                return "orespawn:b_happy";
            }
            return null;
        }
        return null;
    }

    protected String getHurtSound() {
        if (this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) {
            return null;
        }
        return "orespawn:b_ow";
    }

    protected String getDeathSound() {
        if (OreSpawnMain.bro_mode != 0) {
            return null;
        }
        return this.isTamed() ? "orespawn:b_death_boyfriend" : "orespawn:b_death_single";
    }

    protected float getSoundVolume() {
        return 0.3f;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block)Blocks.red_flower);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = 0;
        if (this.isTamed()) {
            var3 = this.rand.nextInt(5);
            for (int var4 = 0; var4 < (var3 += 2); ++var4) {
                this.dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
            }
        }
        Item v6 = OreSpawnMain.MyItemGameController;
        var3 = this.worldObj.rand.nextInt(26);
        for (int var4 = 0; var4 < (var3 += 10); ++var4) {
            this.dropItem(v6, 1);
        }
        if (this.isTamed()) {
            ItemStack var5 = this.getCurrentEquippedItem();
            if (var5 != null && var5.stackSize > 0) {
                this.dropItem(var5.getItem(), var5.stackSize);
            }
            if ((var5 = this.getEquipmentInSlot(1)) != null && var5.stackSize > 0) {
                this.dropItem(var5.getItem(), var5.stackSize);
            }
            if ((var5 = this.getEquipmentInSlot(2)) != null && var5.stackSize > 0) {
                this.dropItem(var5.getItem(), var5.stackSize);
            }
            if ((var5 = this.getEquipmentInSlot(3)) != null && var5.stackSize > 0) {
                this.dropItem(var5.getItem(), var5.stackSize);
            }
            if ((var5 = this.getEquipmentInSlot(4)) != null && var5.stackSize > 0) {
                this.dropItem(var5.getItem(), var5.stackSize);
            }
        }
    }

    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving) {
        ItemStack it = null;
        if (this.isSwingInProgress) {
            return;
        }
        it = this.getCurrentEquippedItem();
        if (it != null && it.getItem() == OreSpawnMain.MyUltimateBow) {
            int var10;
            UltimateArrow var8 = new UltimateArrow(this.worldObj, (EntityLiving)this, par1EntityLiving, 2.0f, 10.0f);
            if (this.worldObj.rand.nextInt(4) == 1) {
                var8.setIsCritical(true);
            }
            if ((var10 = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)it)) > 0) {
                var8.setKnockbackStrength(var10);
            }
            if (EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)it) > 0) {
                var8.setFire(100);
            }
            it.damageItem(1, (EntityLivingBase)this);
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.worldObj.rand.nextFloat() * 0.4f + 1.2f) + 0.5f);
            var8.canBePickedUp = 2;
            this.worldObj.spawnEntityInWorld((Entity)var8);
        } else {
            Shoes var2 = new Shoes(this.worldObj, (EntityLivingBase)this, 6);
            double var3 = par1EntityLiving.posX - this.posX;
            double var5 = par1EntityLiving.posY + (double)par1EntityLiving.getEyeHeight() - 1.1 - var2.posY;
            double var7 = par1EntityLiving.posZ - this.posZ;
            float var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
            var2.setThrowableHeading(var3, var5 + (double)var9, var7, 1.8f, 4.0f);
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)var2);
        }
        this.swingItem();
    }

    public ItemStack getCurrentEquippedItem() {
        return this.getEquipmentInSlot(0);
    }

    public void attackTargetEntityWithCurrentItem(Entity par1Entity) {
        ItemStack stack = this.getCurrentEquippedItem();
        if (stack != null) {
            float var2 = 0.0f;
            if (this.isPotionActive(Potion.damageBoost)) {
                var2 += (float)(3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier());
            }
            if (this.isPotionActive(Potion.weakness)) {
                var2 -= (float)(2 << this.getActivePotionEffect(Potion.weakness).getAmplifier());
            }
            int var3 = 0;
            float var4 = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            if (par1Entity instanceof EntityLiving) {
                var4 += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)par1Entity));
                var3 += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)((EntityLiving)par1Entity));
            }
            if (this.isSprinting()) {
                ++var3;
            }
            if (var2 > 0.0f || var4 > 0.0f) {
                int var8;
                boolean var6;
                boolean var5;
                boolean bl = var5 = this.fallDistance > 0.0f && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.handleLavaMovement() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && par1Entity instanceof EntityLiving;
                if (var5) {
                    var2 += (float)this.worldObj.rand.nextInt((int)var2 / 2 + 2);
                }
                if ((var6 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2 += var4)) && var3 > 0) {
                    par1Entity.addVelocity((double)((- MathHelper.sin((float)(this.rotationYaw * 3.1415927f / 180.0f))) * (float)var3 * 0.5f), 0.1, (double)(MathHelper.cos((float)(this.rotationYaw * 3.1415927f / 180.0f)) * (float)var3 * 0.5f));
                    this.motionX *= 0.6;
                    this.motionZ *= 0.6;
                    this.setSprinting(false);
                }
                ItemStack var7 = this.getCurrentEquippedItem();
                if (par1Entity instanceof EntityLiving && (var8 = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.fireAspect.effectId, (ItemStack)var7)) > 0 && var6) {
                    par1Entity.setFire(var8 * 4);
                }
            }
        }
    }

    protected float getSoundPitch() {
        return (float)(this.voice - 5) * 0.02f + 1.0f;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase entityliving, float f) {
        this.attackEntityWithRangedAttack(entityliving);
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        float p2 = par2;
        if (p2 > 10.0f) {
            p2 = 10.0f;
        }
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, p2);
        }
        return ret;
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
                    if (s == null || !s.equals("Boyfriend")) continue;
                    return true;
                }
            }
        }
        return super.getCanSpawnHere();
    }
}

