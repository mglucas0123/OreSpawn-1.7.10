package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TheKing extends EntityMob
{
  private ChunkCoordinates currentFlightTarget = null;
  private GenericTargetSorter TargetSorter = null;
  private EntityLivingBase rt = null;
  private double attdam = 250.0D;
  private int hurt_timer = 0;
  private int homex = 0;
  private int homez = 0;
  private int stream_count = 0;
  private int stream_count_l = 0;
  private int stream_count_i = 0;
  private int ticker = 0;
  private int player_hit_count = 0;
  private int backoff_timer = 0;
  private int guard_mode = 0;
  private volatile int head_found = 0;
  private int wing_sound = 0;
  private int large_unknown_detected = 0;
  private int isEnd = 0;
  private int endCounter = 0;

  public TheKing(World par1World) {
    super(par1World);
    if (OreSpawnMain.PlayNicely == 0)
      setSize(22.0F, 24.0F);
    else {
      setSize(5.5F, 6.0F);
    }
    getNavigator().setAvoidsWater(false);
    this.experienceValue = 25000;
    this.isImmuneToFire = true;
    this.fireResistance = 5000;
    this.noClip = true;
    this.TargetSorter = new GenericTargetSorter(this);
    this.renderDistanceWeight = 12.0D;
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(1, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
  }

  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6200000047683716D);

    this.attdam = OreSpawnMain.TheKing_stats.attack;
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.attdam);
  }

  protected void entityInit()
  {
    super.entityInit();
    this.dataWatcher.addObject(20, Byte.valueOf((byte) 0));
    this.dataWatcher.addObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
    this.dataWatcher.addObject(22, Integer.valueOf(this.isEnd));
  }

  public int getPlayNicely() {
    return this.dataWatcher.getWatchableObjectInt(21);
  }

  @SideOnly(Side.CLIENT)
  public boolean isInRangeToRenderDist(double par1)
  {
    return true;
  }

  @SideOnly(Side.CLIENT)
  public boolean isInRangeToRenderVec3D(Vec3 par1Vec3)
  {
    return true;
  }

  protected boolean canDespawn() {
    return false;
  }

  public final int getAttacking()
  {
    return this.dataWatcher.getWatchableObjectByte(20);
  }

  public final void setAttacking(int par1)
  {
    this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
  }

  protected float getSoundVolume()
  {
    return 1.35F;
  }

  protected float getSoundPitch()
  {
    return 1.0F;
  }

  protected String getLivingSound()
  {
    return "orespawn:king_living";
  }

  protected String getHurtSound()
  {
    return "orespawn:king_hit";
  }

  protected String getDeathSound()
  {
    return "orespawn:trex_death";
  }

  public boolean canBePushed()
  {
    return false;
  }

  protected void collideWithEntity(Entity par1Entity) {
  }

  public int mygetMaxHealth() {
    return OreSpawnMain.TheKing_stats.health;
  }

  protected Item getDropItem()
  {
    return Item.getItemFromBlock(Blocks.yellow_flower);
  }

  private void dropItemRand(Item index, int par1)
  {
    EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), this.posY + 12.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), new ItemStack(index, par1, 0));

    this.worldObj.spawnEntityInWorld(var3);
  }

  protected void dropFewItems(boolean par1, int par2) {
      int k;
      Item it = null;
      Block bl = null;
      TheKing.spawnCreature((World)this.worldObj, (String)"The Prince", (double)this.posX, (double)(this.posY + 10.0), (double)this.posZ);
      this.dropItemRand((Item)OreSpawnMain.RoyalBody, 1);
      this.dropItemRand((Item)OreSpawnMain.RoyalHelmet, 1);
      this.dropItemRand((Item)OreSpawnMain.RoyalLegs, 1);
      this.dropItemRand((Item)OreSpawnMain.RoyalBoots, 1);
      this.dropItemRand(OreSpawnMain.MyRoyal, 1);
      Iterator ilist = Item.itemRegistry.iterator();
      int icount = 0;
      while (ilist.hasNext()) {
          it = (Item)ilist.next();
          if (it == null) continue;
          ++icount;
      }
      int j = 0;
      while (j < 150) {
          ilist = Item.itemRegistry.iterator();
          for (k = 1 + this.worldObj.rand.nextInt((int)icount); k > 0 && ilist.hasNext(); --k) {
              it = (Item)ilist.next();
          }
          if (it == null) continue;
          ++j;
          this.dropItemRand(it, 1);
      }
      Iterator blist = Block.blockRegistry.iterator();
      int bcount = 0;
      while (blist.hasNext()) {
          bl = (Block)blist.next();
          if (bl == null) continue;
          ++bcount;
      }
      j = 0;
      while (j < 150) {
          blist = Block.blockRegistry.iterator();
          for (k = 1 + this.worldObj.rand.nextInt((int)bcount); k > 0 && blist.hasNext(); --k) {
              bl = (Block)blist.next();
          }
          if (bl == null) continue;
          ++j;
          this.dropItemRand(Item.getItemFromBlock((Block)bl), 1);
      }
  }

  protected boolean isAIEnabled()
  {
    return true;
  }

  public void onUpdate()
  {
    super.onUpdate();

    this.wing_sound += 1;
    if (this.wing_sound > 30)
    {
      if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "orespawn:MothraWings", 1.75F, 0.75F);
      this.wing_sound = 0;
    }

    this.noClip = true;
    this.motionY *= 0.6D;
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() * 2 / 3)) this.attdam = (OreSpawnMain.TheKing_stats.attack * 2);
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 2)) this.attdam = (OreSpawnMain.TheKing_stats.attack * 4);
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 4)) this.attdam = (OreSpawnMain.TheKing_stats.attack * 8);
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 8)) this.attdam = (OreSpawnMain.TheKing_stats.attack * 16);

    if (this.worldObj.isRemote) {
      float f = 7.0F;
      this.isEnd = this.dataWatcher.getWatchableObjectInt(22);

      if ((this.isEnd != 0) && (this.worldObj.rand.nextInt(3) == 1))
      {
        for (int i = 0; i < 10; i++)
          this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 14.0D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 4.0D + this.motionX * 6.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 4.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 4.0D + this.motionZ * 6.0D);
      }
    }
  }

  public boolean attackEntityAsMob(Entity par1Entity)
  {
    if ((par1Entity != null) && ((par1Entity instanceof EntityLivingBase)))
    {
      float s = par1Entity.height * par1Entity.width;
      if ((s > 30.0F) && 
        (!MyUtils.isRoyalty(par1Entity)) && (!(par1Entity instanceof Godzilla)) && (!(par1Entity instanceof GodzillaHead)) && (!(par1Entity instanceof PitchBlack)) && (!(par1Entity instanceof Kraken)))
      {
        EntityLivingBase e = (EntityLivingBase)par1Entity;
        e.setHealth(e.getHealth() / 2.0F);
        e.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.attdam * 10.0F);
        this.large_unknown_detected = 1;
      }

    }

    if ((par1Entity != null) && ((par1Entity instanceof EntityDragon))) {
      EntityDragon dr = (EntityDragon)par1Entity;
      DamageSource var21 = null;
      var21 = DamageSource.setExplosionSource(null);
      var21.setExplosion();
      if (this.worldObj.rand.nextInt(6) == 1)
        dr.attackEntityFromPart(dr.dragonPartHead, var21, (float)this.attdam);
      else {
        dr.attackEntityFromPart(dr.dragonPartBody, var21, (float)this.attdam);
      }
    }

    boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.attdam);
    if (var4) {
      double ks = 3.3D;
      double inair = 0.25D;
      float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
      inair += this.worldObj.rand.nextFloat() * 0.25F;
      if ((par1Entity.isDead) || ((par1Entity instanceof EntityPlayer))) inair *= 1.5D;
      par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
    }

    return var4;
  }

  public boolean canSeeTarget(double pX, double pY, double pZ)
  {
    return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 8.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null;
  }

  private boolean tooFarFromHome()
  {
    float d1 = (float)(this.posX - this.homex);
    float d2 = (float)(this.posZ - this.homez);

    d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    return d1 > 120.0F;
  }

  private void msgToPlayers(String s)
  {
    List var5 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0D, 64.0D, 80.0D));
    Collections.sort(var5, this.TargetSorter);
    Iterator var2 = var5.iterator();
    Entity var3 = null;
    EntityPlayer var4 = null;

    while (var2.hasNext())
    {
      var3 = (Entity)var2.next();
      var4 = (EntityPlayer)var3;
      var4.addChatComponentMessage(new ChatComponentText(s));
    }
  }

  private EntityPlayer findNearestPlayer()
  {
    List var5 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0D, 64.0D, 80.0D));
    Collections.sort(var5, this.TargetSorter);
    Iterator var2 = var5.iterator();
    Entity var3 = null;
    EntityPlayer var4 = null;

    while (var2.hasNext())
    {
      var3 = (Entity)var2.next();
      if ((var3 instanceof EntityPlayer)) var4 = (EntityPlayer)var3;
      if (var4 == null)
        continue;
    }
    return var4;
  }

  protected void updateAITasks()
  {
    int xdir = 1;
    int zdir = 1;

    int attrand = 5;
    int updown = 0;
    int which = 0;
    EntityLivingBase e = null;
    EntityLivingBase f = null;

    double rr = 0.0D;
    double rhdir = 0.0D;
    double rdd = 0.0D;
    double pi = 3.1415926545D;
    double var1 = 0.0D;
    double var3 = 0.0D;
    double var5 = 0.0D;
    float var7 = 0.0F;
    float var8 = 0.0F;

    EntityPlayer p = null;

    if (this.isDead) return;
    super.updateAITasks();
    this.dataWatcher.updateObject(22, Integer.valueOf(this.isEnd));
    this.dataWatcher.updateObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));

    if (this.isEnd == 1) {
      this.endCounter += 1;
      this.noClip = true;
      this.motionX = 0.0D;
      this.motionY = 0.0D;
      this.motionZ = 0.0D;
      this.hurt_timer = 10;

      if (this.isDead) return;

      p = findNearestPlayer();
      if (p != null) {
        faceEntity(p, 10.0F, 10.0F);
        p.motionX = 0.0D;
        p.motionY = 0.0D;
        p.motionZ = 0.0D;
        double dd0 = this.posX - p.posX;
        double dd1 = this.posZ - p.posZ;
        float f2 = (float)(Math.atan2(dd1, dd0) * 180.0D / 3.141592653589793D) - 90.0F;
        p.rotationYaw = f2;
        p.setHealth(1.0F);
      }

      if (this.endCounter == 10) {
        msgToPlayers("The King: Enough of this charade. I am done. You have shown me what I wanted to know.");
        return;
      }
      if (this.endCounter == 80) {
        msgToPlayers("The King: That's right my little pet. It has all been a game. You never killed me. You can't.");
        return;
      }
      if (this.endCounter == 160) {
        msgToPlayers("The King: I am the one. The only. The many. I exist within both space and time. Everywhere and always.");
        return;
      }
      if (this.endCounter == 240) {
        msgToPlayers("The King: I used you to learn your ways, and I have reached my conclusion on your species.");
        return;
      }
      if (this.endCounter == 300) {
        msgToPlayers("The King: You have 10 seconds to run...");
        return;
      }
      if (this.endCounter == 320) {
        msgToPlayers("9.");
        return;
      }
      if (this.endCounter == 340) {
        msgToPlayers("8.");
        return;
      }
      if (this.endCounter == 360) {
        msgToPlayers("7.");
        return;
      }
      if (this.endCounter == 380) {
        msgToPlayers("6.");
        return;
      }
      if (this.endCounter == 400) {
        msgToPlayers("5.");
        return;
      }
      if (this.endCounter == 420) {
        msgToPlayers("4.");
        return;
      }
      if (this.endCounter == 440) {
        msgToPlayers("3.");
        return;
      }
      if (this.endCounter == 460) {
        msgToPlayers("2.");
        return;
      }
      if (this.endCounter == 480) {
        msgToPlayers("1.");
        return;
      }
      if (this.endCounter == 500) {
        msgToPlayers("The King: Prepare to die!");
        this.isEnd = 2;
        return;
      }

      return;
    }

    if (this.isEnd == 2) {
      this.hurt_timer = 10;
      this.player_hit_count = 0;
      this.stream_count = 10;
      this.stream_count_l = 10;
      this.stream_count_i = 10;
      attrand = 3;
      this.guard_mode = 0;
      this.large_unknown_detected = 1;
      if (this.backoff_timer > 0) this.backoff_timer -= 1;
    }

    if (this.hurt_timer > 0) this.hurt_timer -= 1;
    if (((this.homex == 0) && (this.homez == 0)) || (this.guard_mode == 0)) {
      this.homex = (int)this.posX;
      this.homez = (int)this.posZ;
    }

    this.ticker += 1;
    if (this.ticker > 30000) this.ticker = 0;
    if (this.ticker % 80 == 0) this.stream_count = 10;
    if (this.ticker % 90 == 0) this.stream_count_l = 5;
    if (this.ticker % 70 == 0) this.stream_count_i = 8;
    if (this.backoff_timer > 0) this.backoff_timer -= 1;

    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 2)) attrand = 3;
    this.noClip = true;

    if (this.currentFlightTarget == null) {
      this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
    }

    if ((tooFarFromHome()) || (this.worldObj.rand.nextInt(200) == 0) || (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1F))
    {
      zdir = this.worldObj.rand.nextInt(120);
      xdir = this.worldObj.rand.nextInt(120);
      if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir;
      if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir;

      int dist = 0;
      for (int i = -5; i <= 5; i += 5) {
        for (int j = -5; j <= 5; j += 5) {
          Block bid = this.worldObj.getBlock(this.homex + j, (int)this.posY, this.homez + i);
          if (bid != Blocks.air)
            for (int k = 1; k < 20; k++) {
              bid = this.worldObj.getBlock(this.homex + j, (int)this.posY + k, this.homez + i);
              dist++;
              if (bid == Blocks.air)
                break;
            }
          for (int k = 1; k < 20; k++) {
            bid = this.worldObj.getBlock(this.homex + j, (int)this.posY - k, this.homez + i);
            dist--;
            if (bid != Blocks.air)
              break;
          }
        }
      }
      dist = dist / 9 + 2;
      if ((int)(this.posY + dist) > 230) dist = 230 - (int)this.posY;
      this.currentFlightTarget.set(this.homex + xdir, (int)(this.posY + dist), this.homez + zdir);
    }
    else if (this.worldObj.rand.nextInt(attrand) == 0)
    {
      e = this.rt;
      if (OreSpawnMain.PlayNicely != 0) e = null;
      if ((e != null) && (
        ((e instanceof TheKing)) || ((e instanceof KingHead)))) {
        this.rt = null;
        e = null;
      }

      if (e != null)
      {
        float d1 = (float)(e.posX - this.homex);
        float d2 = (float)(e.posZ - this.homez);
        d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
        if ((e.isDead) || (this.worldObj.rand.nextInt(250) == 1) || ((d1 > 128.0F) && (this.guard_mode == 1))) {
          e = null;
          this.rt = null;
        }
        if ((e != null) && 
          (!MyCanSee(e))) {
          e = null;
        }

      }

      f = findSomethingToAttack();
      if (this.head_found == 0)
      {
        EntityLiving localEntityLiving = (EntityLiving)spawnCreature(this.worldObj, "KingHead", this.posX, this.posY + 20.0D, this.posZ);
      }

      if (e == null) {
        e = f;
      }

      if (e != null)
      {
        setAttacking(1);
        if (this.backoff_timer == 0) {
          int dist = (int)(e.posY + e.height / 2.0F + 1.0D);
          if (dist > 230) dist = 230;
          this.currentFlightTarget.set((int)e.posX, dist, (int)e.posZ);
          if (this.worldObj.rand.nextInt(70) == 1) this.backoff_timer = (80 + this.worldObj.rand.nextInt(80));
        }
        else if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1F)
        {
          zdir = this.worldObj.rand.nextInt(20) + 30;
          xdir = this.worldObj.rand.nextInt(20) + 30;
          if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir;
          if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir;

          int dist = 0;
          for (int i = -5; i <= 5; i += 5) {
            for (int j = -5; j <= 5; j += 5) {
              Block bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY, (int)e.posZ + i);
              if (bid != Blocks.air)
                for (int k = 1; k < 20; k++) {
                  bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY + k, (int)e.posZ + i);
                  dist++;
                  if (bid == Blocks.air)
                    break;
                }
              for (int k = 1; k < 20; k++) {
                bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY - k, (int)e.posZ + i);
                dist--;
                if (bid != Blocks.air)
                  break;
              }
            }
          }
          dist = dist / 9 + 2;
          if ((int)(this.posY + dist) > 230) dist = 230 - (int)this.posY;
          this.currentFlightTarget.set((int)e.posX + xdir, (int)(this.posY + dist), (int)e.posZ + zdir);
        }

        if (getDistanceSqToEntity(e) < 900.0D) {
          if (this.worldObj.rand.nextInt(2) == 1) doJumpDamage(this.posX, this.posY, this.posZ, 15.0D, OreSpawnMain.TheKing_stats.attack / 4, 0);
          attackEntityAsMob(e);
        }

        double dx = this.posX + 20.0D * Math.sin(Math.toRadians(this.rotationYawHead));
        double dz = this.posZ - 20.0D * Math.cos(Math.toRadians(this.rotationYawHead));
        if (this.worldObj.rand.nextInt(3) == 1) doJumpDamage(dx, this.posY + 10.0D, dz, 15.0D, OreSpawnMain.TheKing_stats.attack / 2, 1);

        if (getHorizontalDistanceSqToEntity(e) > 900.0D) {
          which = this.worldObj.rand.nextInt(3);
          if (which == 0)
          {
            if (this.stream_count > 0) {
              setAttacking(1);

              rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
              rhdir = Math.toRadians((this.rotationYawHead + 90.0F) % 360.0F);

              rdd = Math.abs(rr - rhdir) % (pi * 2.0D);
              if (rdd > pi) rdd -= pi * 2.0D;
              rdd = Math.abs(rdd);

              if (rdd < 0.5D) {
                firecanon(e);
              }
            }
          }
          else if (which == 1) {
            if (this.stream_count_l > 0) {
              setAttacking(1);

              rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
              rhdir = Math.toRadians((this.rotationYawHead + 90.0F) % 360.0F);

              rdd = Math.abs(rr - rhdir) % (pi * 2.0D);
              if (rdd > pi) rdd -= pi * 2.0D;
              rdd = Math.abs(rdd);

              if (rdd < 0.5D) {
                firecanonl(e);
              }
            }

          }
          else if (this.stream_count_i > 0) {
            setAttacking(1);

            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
            rhdir = Math.toRadians((this.rotationYawHead + 90.0F) % 360.0F);

            rdd = Math.abs(rr - rhdir) % (pi * 2.0D);
            if (rdd > pi) rdd -= pi * 2.0D;
            rdd = Math.abs(rdd);

            if (rdd < 0.5D) {
              firecanoni(e);
            }
          }
        }
      }
      else
      {
        setAttacking(0);
        this.stream_count = 10;
        this.stream_count_l = 5;
        this.stream_count_i = 8;
      }
    }

    if ((getAttacking() != 0) && (this.isEnd == 2)) {
      double xzoff = 10.0D;
      double yoff = 14.0D;
      Entity ppwr = spawnCreature(this.worldObj, "PurplePower", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));

      if (ppwr != null) {
        PurplePower pwr = (PurplePower)ppwr;
        pwr.motionX = (this.motionX * 3.0D);
        pwr.motionZ = (this.motionZ * 3.0D);
        pwr.setPurpleType(10);
      }
    }

    var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
    var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
    var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;

    this.motionX += (Math.signum(var1) * 0.7D - this.motionX) * 0.35D;
    this.motionY += (Math.signum(var3) * 0.69999D - this.motionY) * 0.3D;
    this.motionZ += (Math.signum(var5) * 0.7D - this.motionZ) * 0.35D;

    var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.141592653589793D) - 90.0F;
    var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
    this.moveForward = 1.0F;
    this.rotationYaw += var8 / 8.0F;

    if ((this.worldObj.rand.nextInt(30) == 1) && 
      (getHealth() < mygetMaxHealth()))
    {
      heal(5.0F);
      if (this.large_unknown_detected != 0) heal(200.0F);
    }

    if ((this.player_hit_count < 10) && (getHealth() < 2000.0F)) heal(2000.0F - getHealth());
  }

  private double getHorizontalDistanceSqToEntity(Entity e)
  {
    double d1 = e.posZ - this.posZ;
    double d2 = e.posX - this.posX;
    return d1 * d1 + d2 * d2;
  }

  private void firecanon(EntityLivingBase e)
  {
    double yoff = 14.0D;
    double xzoff = 32.0D;

    BetterFireball bf = null;

    double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
    double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
    if (this.stream_count > 0)
    {
      bf = new BetterFireball(this.worldObj, this, e.posX - cx, e.posY + e.height / 2.0F - (this.posY + yoff), e.posZ - cz);
      bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
      bf.setPosition(cx, this.posY + yoff, cz);
      bf.setReallyBig();
      this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
      this.worldObj.spawnEntityInWorld(bf);
      for (int i = 0; i < 6; i++) {
        float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireball(this.worldObj, this, e.posX - cx + r1, e.posY + e.height / 2.0F - (this.posY + yoff) + r2, e.posZ - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBig();
        if (this.worldObj.rand.nextInt(2) == 1) bf.setSmall();
        this.worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(bf);
      }
      this.stream_count -= 1;
    }
  }

  private void firecanonl(EntityLivingBase e)
  {
    double yoff = 14.0D;
    double xzoff = 32.0D;

    double var3 = 0.0D;
    double var5 = 0.0D;
    double var7 = 0.0D;
    float var9 = 0.0F;
    double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
    double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
    if (this.stream_count_l > 0) {
      this.worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
      for (int i = 0; i < 3; i++) {
        float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
        var3 = e.posX - lb.posX;
        var5 = e.posY + 0.25D - lb.posY;
        var7 = e.posZ - lb.posZ;
        var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
        lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
        lb.motionX *= 3.0D;
        lb.motionY *= 3.0D;
        lb.motionZ *= 3.0D;
        this.worldObj.spawnEntityInWorld(lb);
      }
      this.stream_count_l -= 1;
    }
  }

  private void firecanoni(EntityLivingBase e)
  {
    double yoff = 14.0D;
    double xzoff = 32.0D;

    double var3 = 0.0D;
    double var5 = 0.0D;
    double var7 = 0.0D;
    float var9 = 0.0F;
    double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
    double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
    if (this.stream_count_i > 0) {
      this.worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
      for (int i = 0; i < 5; i++) {
        float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
        lb.setIceMaker(1);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
        var3 = e.posX - lb.posX;
        var5 = e.posY + 0.25D - lb.posY;
        var7 = e.posZ - lb.posZ;
        var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
        lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
        lb.motionX *= 3.0D;
        lb.motionY *= 3.0D;
        lb.motionZ *= 3.0D;
        this.worldObj.spawnEntityInWorld(lb);
      }
      this.stream_count_i -= 1;
    }
  }

  protected boolean canTriggerWalking()
  {
    return true;
  }

  protected void fall(float par1)
  {
  }

  protected void updateFallState(double par1, boolean par3)
  {
  }

  public boolean doesEntityNotTriggerPressurePlate()
  {
    return false;
  }

  public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
  {
    boolean ret = false;
    float dm = par2;

    if (this.hurt_timer > 0) return false;
    if (dm > 750.0F) dm = 750.0F;

    if (par1DamageSource.getDamageType().equals("inWall")) {
      return false;
    }

    Entity e = par1DamageSource.getEntity();
    if ((e != null) && ((e instanceof EntityLivingBase)))
    {
      EntityLivingBase enl = (EntityLivingBase)e;
      float s = enl.height * enl.width;
      if ((s > 30.0F) && 
        (!MyUtils.isRoyalty(enl)) && (!(enl instanceof Godzilla)) && (!(enl instanceof GodzillaHead)) && (!(enl instanceof PitchBlack)) && (!(enl instanceof Kraken)))
      {
        dm /= 10.0F;
        this.hurt_timer = 50;
        this.large_unknown_detected = 1;
      }

      if (((e instanceof EntityMob)) && 
        (s < 3.0F)) {
        e.setDead();
        return false;
      }

    }

    if (!par1DamageSource.getDamageType().equals("cactus")) {
      this.hurt_timer = 20;
      ret = super.attackEntityFrom(par1DamageSource, dm);

      if ((e != null) && ((e instanceof EntityPlayer)))
      {
        this.player_hit_count += 1;
      }

      if ((e != null) && ((e instanceof EntityLivingBase)) && (this.currentFlightTarget != null))
      {
        if (!MyUtils.isRoyalty(e)) {
          this.rt = ((EntityLivingBase)e);
          int dist = (int)e.posY;
          if (dist > 230) dist = 230;
          this.currentFlightTarget.set((int)e.posX, dist, (int)e.posZ);
        }
      }
    }
    return ret;
  }

  public boolean getCanSpawnHere()
  {
    return true;
  }

  public int getTotalArmorValue()
  {
    if (this.large_unknown_detected != 0) return 25;
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() * 2 / 3)) return OreSpawnMain.TheKing_stats.defense + 1;
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 2)) return OreSpawnMain.TheKing_stats.defense + 2;
    if ((this.player_hit_count < 10) && (getHealth() < mygetMaxHealth() / 4)) return OreSpawnMain.TheKing_stats.defense + 3;
    return OreSpawnMain.TheKing_stats.defense;
  }

  public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
  {
  }

  public void initCreature()
  {
  }

  public boolean MyCanSee(EntityLivingBase e)
  {
    double xzoff = 22.0D;

    int nblks = 20;

    double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
    double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
    float startx = (float)cx;
    float starty = (float)(this.posY + this.height * 7.0F / 8.0F);
    float startz = (float)cz;
    float dx = (float)((e.posX - startx) / 20.0D);
    float dy = (float)((e.posY + e.height / 2.0F - starty) / 20.0D);
    float dz = (float)((e.posZ - startz) / 20.0D);

    if (Math.abs(dx) > 1.0D) {
      dy /= Math.abs(dx);
      dz /= Math.abs(dx);
      nblks = (int)(nblks * Math.abs(dx));
      if (dx > 1.0F) dx = 1.0F;
      if (dx < -1.0F) dx = -1.0F;
    }
    if (Math.abs(dy) > 1.0D) {
      dx /= Math.abs(dy);
      dz /= Math.abs(dy);
      nblks = (int)(nblks * Math.abs(dy));
      if (dy > 1.0F) dy = 1.0F;
      if (dy < -1.0F) dy = -1.0F;
    }
    if (Math.abs(dz) > 1.0D) {
      dy /= Math.abs(dz);
      dx /= Math.abs(dz);
      nblks = (int)(nblks * Math.abs(dz));
      if (dz > 1.0F) dz = 1.0F;
      if (dz < -1.0F) dz = -1.0F;
    }

    for (int i = 0; i < nblks; i++) {
      startx += dx;
      starty += dy;
      startz += dz;
      Block bid = this.worldObj.getBlock((int)startx, (int)starty, (int)startz);
      if ((bid != Blocks.flowing_water) && (bid != Blocks.water) && (bid != Blocks.leaves) && (bid != Blocks.vine) && 
        (bid != Blocks.air)) return false;

    }

    return true;
  }

  private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2)
  {
    if (par1EntityLiving == null)
    {
      return false;
    }

    if (par1EntityLiving == this)
    {
      return false;
    }
    if (!par1EntityLiving.isEntityAlive())
    {
      return false;
    }

    if ((par1EntityLiving instanceof KingHead))
    {
      this.head_found = 1;
      return false;
    }
    if (MyUtils.isRoyalty(par1EntityLiving))
    {
      return false;
    }

    float d1 = (float)(par1EntityLiving.posX - this.homex);
    float d2 = (float)(par1EntityLiving.posZ - this.homez);
    d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    if (d1 > 144.0F) return false;

    if (MyUtils.isIgnoreable(par1EntityLiving)) return false;

    if (this.isEnd == 2) {
      if ((par1EntityLiving instanceof EntityPlayer))
      {
        EntityPlayer p = (EntityPlayer)par1EntityLiving;

        return p.capabilities.isCreativeMode != true;
      }

      if ((par1EntityLiving instanceof Girlfriend))
      {
        return true;
      }
      if ((par1EntityLiving instanceof Boyfriend))
      {
        return true;
      }
      if ((par1EntityLiving instanceof EntityVillager))
      {
        return true;
      }

    }

    if (!MyCanSee(par1EntityLiving))
    {
      return false;
    }

    if ((par1EntityLiving instanceof EntityPlayer))
    {
      EntityPlayer p = (EntityPlayer)par1EntityLiving;

      return p.capabilities.isCreativeMode != true;
    }

    if ((par1EntityLiving instanceof EntityHorse))
    {
      return true;
    }
    if ((par1EntityLiving instanceof EntityMob))
    {
      return true;
    }

    if ((par1EntityLiving instanceof EntityDragon))
    {
      return true;
    }

    return MyUtils.isAttackableNonMob(par1EntityLiving);
  }

  private EntityLivingBase findSomethingToAttack()
  {
    if (OreSpawnMain.PlayNicely != 0) {
      this.head_found = 1;
      return null;
    }

    if (this.isEnd == 2) {
      List var5p = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0D, 64.0D, 80.0D));
      Collections.sort(var5p, this.TargetSorter);
      Iterator var2p = var5p.iterator();
      Entity var3p = null;
      EntityLivingBase var4p = null;
      EntityLivingBase retp = null;
      this.head_found = 1;
      while (var2p.hasNext())
      {
        var3p = (Entity)var2p.next();
        var4p = (EntityLivingBase)var3p;

        if (isSuitableTarget(var4p, false))
        {
          return var4p;
        }
      }
    }
    List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(80.0D, 64.0D, 80.0D));
    Collections.sort(var5, this.TargetSorter);
    Iterator var2 = var5.iterator();
    Entity var3 = null;
    EntityLivingBase var4 = null;
    EntityLivingBase ret = null;

    this.head_found = 0;
    while (var2.hasNext())
    {
      var3 = (Entity)var2.next();
      var4 = (EntityLivingBase)var3;

      if (isSuitableTarget(var4, false))
      {
        if (ret == null) ret = var4;
      }
      if ((ret == null) || (this.head_found == 0)) continue;
    }
    return ret;
  }

  public void setGuardMode(int i)
  {
    this.guard_mode = i;
  }

  public void setFree()
  {
    this.isEnd = 1;
  }

  public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeEntityToNBT(par1NBTTagCompound);

    par1NBTTagCompound.setInteger("KingHomeX", this.homex);
    par1NBTTagCompound.setInteger("KingHomeZ", this.homez);
    par1NBTTagCompound.setInteger("GuardMode", this.guard_mode);
    par1NBTTagCompound.setInteger("PlayerHits", this.player_hit_count);
    par1NBTTagCompound.setInteger("IsEnd", this.isEnd);
    par1NBTTagCompound.setInteger("EndCounter", this.endCounter);
  }

  public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readEntityFromNBT(par1NBTTagCompound);

    this.homex = par1NBTTagCompound.getInteger("KingHomeX");
    this.homez = par1NBTTagCompound.getInteger("KingHomeZ");
    this.guard_mode = par1NBTTagCompound.getInteger("GuardMode");
    this.player_hit_count = par1NBTTagCompound.getInteger("PlayerHits");
    this.isEnd = par1NBTTagCompound.getInteger("IsEnd");
    this.endCounter = par1NBTTagCompound.getInteger("EndCounter");
  }

  public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6)
  {
    Entity var8 = null;
    var8 = EntityList.createEntityByName(par1, par0World);
    if (var8 != null)
    {
      var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);

      par0World.spawnEntityInWorld(var8);
    }
    return var8;
  }

  private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock)
  {
    AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - dist, Y - 10.0D, Z - dist, X + dist, Y + 10.0D, Z + dist);
    List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
    Collections.sort(var5, this.TargetSorter);
    Iterator var2 = var5.iterator();
    Entity var3 = null;
    EntityLivingBase var4 = null;

    while (var2.hasNext())
    {
      var3 = (Entity)var2.next();
      var4 = (EntityLivingBase)var3;

      if ((var4 == null) || 
        (var4 == this) || 
        (!var4.isEntityAlive()) || 
        (MyUtils.isRoyalty(var4)) || 
        ((var4 instanceof Ghost)) || 
        ((var4 instanceof GhostSkelly)))
        continue;
      DamageSource var21 = null;
      var21 = DamageSource.setExplosionSource(null);
      var21.setExplosion();
      var4.attackEntityFrom(var21, (float)damage / 2.0F);
      var4.attackEntityFrom(DamageSource.fall, (float)damage / 2.0F);
      this.worldObj.playSoundAtEntity(var4, "random.explode", 0.65F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
      if (knock != 0) {
        double ks = 2.75D;
        double inair = 0.65D;
        float f3 = (float)Math.atan2(var4.posZ - this.posZ, var4.posX - this.posX);
        var4.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
      }
    }

    return null;
  }
}