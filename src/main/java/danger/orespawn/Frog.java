/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Cricket
 *  danger.orespawn.EntityAnt
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.EntityMosquito
 *  danger.orespawn.Firefly
 *  danger.orespawn.Frog
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.MyEntityAIWander
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WormSmall
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIPanic
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import danger.orespawn.Cricket;
import danger.orespawn.EntityAnt;
import danger.orespawn.EntityButterfly;
import danger.orespawn.EntityMosquito;
import danger.orespawn.Firefly;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Girlfriend;
import danger.orespawn.MyEntityAIWander;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.WormSmall;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

/*
 * Exception performing whole class analysis ignored.
 */
public class Frog
extends EntityAnimal {
    private GenericTargetSorter TargetSorter = null;
    public double moveSpeed = 0.10000000149011612;
    private int singing = 0;
    private int jumpcount = 0;

    public Frog(World par1World) {
        super(par1World);
        this.setSize(0.75f, 0.75f);
        this.experienceValue = 5;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4));
        this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)0);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected boolean canDespawn() {
        if (this.isNoDespawnRequired()) {
            return false;
        }
        return true;
    }

    public int getSinging() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public void setSinging(int par1) {
        this.dataWatcher.updateObject(20, (Object)((byte)par1));
    }

    private void jumpAround() {
        this.motionY += (double)(0.75f + Math.abs(this.worldObj.rand.nextFloat() * 0.55f));
        this.posY += 0.3499999940395355;
        float f = 0.7f + Math.abs(this.worldObj.rand.nextFloat() * 0.75f);
        float d = (float)Math.toRadians(this.rotationYaw);
        this.motionX -= (double)f * Math.sin(d);
        this.motionZ += (double)f * Math.cos(d);
        this.isAirBorne = true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            if (this.singing != 0) {
                --this.singing;
                if (this.singing <= 0) {
                    this.setSinging(0);
                }
            }
            if (this.jumpcount > 0) {
                --this.jumpcount;
            }
            if (this.jumpcount == 0 && this.worldObj.rand.nextInt(70) == 1) {
                this.jumpAround();
                this.jumpcount = 50;
            }
        }
    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        block2 : {
            World world;
            block3 : {
                block4 : {
                    if (par1EntityPlayer == null || !par1EntityPlayer.isSneaking() || par1EntityPlayer.inventory.getCurrentItem() != null) break block2;
                    world = par1EntityPlayer.worldObj;
                    this.setDead();
                    par1EntityPlayer.worldObj.playSoundAtEntity((Entity)par1EntityPlayer, "random.explode", 1.0f, world.rand.nextFloat() * 0.2f + 0.9f);
                    if (world.isRemote) break block3;
                    if (world.rand.nextInt(2) != 0) break block4;
                    Boyfriend ent = null;
                    ent = (Boyfriend)Frog.spawnCreature((World)world, (String)"Boyfriend", (double)this.posX, (double)(this.posY + 0.01), (double)this.posZ);
                    if (ent != null) {
                        ent.setPrince(1 + world.rand.nextInt(2));
                    }
                    break block2;
                }
                Girlfriend ent = null;
                ent = (Girlfriend)Frog.spawnCreature((World)world, (String)"Girlfriend", (double)this.posX, (double)(this.posY + 0.01), (double)this.posZ);
                if (ent == null) break block2;
                ent.setPrincess(1 + world.rand.nextInt(2));
                break block2;
            }
            for (int var3 = 0; var3 < 16; ++var3) {
                world.spawnParticle("smoke", (double)((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)this.posY + world.rand.nextFloat()), (double)((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
                world.spawnParticle("explode", (double)((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)this.posY + world.rand.nextFloat()), (double)((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
                world.spawnParticle("reddust", (double)((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)this.posY + world.rand.nextFloat()), (double)((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
            }
        }
        return false;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int mygetMaxHealth() {
        return 8;
    }

    protected String getLivingSound() {
        if (!this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                return null;
            }
            this.singing = 35;
            this.setSinging(this.singing);
        }
        return "orespawn:frog";
    }

    protected String getHurtSound() {
        return "orespawn:scorpion_hit";
    }

    protected String getDeathSound() {
        return "orespawn:big_splat";
    }

    protected float getSoundVolume() {
        return 0.7f;
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    protected void playStepSound(int par1, int par2, int par3, int par4) {
    }

    private void dropItemRand(Item index, int par1) {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(2) - (double)OreSpawnMain.OreSpawnRand.nextInt(2), new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        for (int i = 0; i < 4; ++i) {
            this.dropItemRand(Items.slime_ball, 1);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 3.0f);
        if (par1Entity.isDead) {
            this.heal(1.0f);
        }
        return var4;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        boolean ret = false;
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (!this.worldObj.isRemote && this.jumpcount <= 0) {
            this.jumpAround();
            this.jumpcount = 25;
        }
        return ret;
    }

    public boolean canSeeTarget(double pX, double pY, double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 0.25), (double)this.posZ), Vec3.createVectorHelper((double)pX, (double)pY, (double)pZ), false) == null;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    private int findBuddies() {
        List var5 = this.worldObj.getEntitiesWithinAABB(Frog.class, this.boundingBox.expand(20.0, 8.0, 20.0));
        return var5.size();
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5 && this.worldObj.rand.nextInt(20) != 1) {
            return false;
        }
        if (this.findBuddies() > 5) {
            return false;
        }
        return true;
    }

    protected void updateAITasks() {
        boolean xdir = true;
        boolean zdir = true;
        int keep_trying = 50;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.25);
                if (this.getDistanceSqToEntity((Entity)e) < 6.0) {
                    this.attackEntityAsMob((Entity)e);
                }
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
        if (par1EntityLiving instanceof EntityAnt) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof Cricket) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMosquito) {
            return true;
        }
        if (par1EntityLiving instanceof Firefly) {
            return true;
        }
        if (par1EntityLiving instanceof WormSmall) {
            return true;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 3.0, 8.0));
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

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }
}

