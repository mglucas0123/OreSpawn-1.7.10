/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.MyEntityAIDance
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.init.Blocks
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import java.util.List;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class MyEntityAIDance
extends EntityAIBase {
    private Girlfriend thePet;
    World theWorld;
    public int ticker = 0;
    public int dance_move = 0;
    public int is_dancing = 0;

    public MyEntityAIDance(Girlfriend par1EntityTameable) {
        this.thePet = par1EntityTameable;
        this.theWorld = par1EntityTameable.worldObj;
    }

    public boolean is_dance_block(Block bid) {
        if (bid == Blocks.gold_block || bid == Blocks.diamond_block || bid == Blocks.emerald_block || bid == OreSpawnMain.MyBlockRubyBlock || bid == OreSpawnMain.MyBlockAmethystBlock || bid == OreSpawnMain.MyBlockTitaniumBlock || bid == OreSpawnMain.MyBlockUraniumBlock) {
            return true;
        }
        return false;
    }

    public boolean shouldExecute() {
        if (this.thePet.isSitting()) {
            return false;
        }
        long t = this.theWorld.getWorldTime();
        if ((t %= 24000L) < 14000L || t > 22000L) {
            return false;
        }
        int ic = 0;
        int iz = 0;
        int ix = 0;
        for (int i = -3; i < 4; ++i) {
            for (int j = -3; j < 4; ++j) {
                Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
                if (!this.is_dance_block(bid)) continue;
                ++ic;
                ix += i;
                iz += j;
            }
        }
        if (ic == 0) {
            return false;
        }
        return true;
    }

    public boolean continueExecuting() {
        if (this.thePet.isSitting()) {
            return false;
        }
        long t = this.theWorld.getWorldTime();
        if ((t %= 24000L) < 14000L || t > 22000L) {
            return false;
        }
        int ic = 0;
        int iz = 0;
        int ix = 0;
        for (int i = -3; i < 4; ++i) {
            for (int j = -3; j < 4; ++j) {
                Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
                if (!this.is_dance_block(bid)) continue;
                ++ic;
                ix += i;
                iz += j;
            }
        }
        if (ic == 0) {
            return false;
        }
        ix /= ic;
        iz /= ic;
        if (ic < 40) {
            this.thePet.getNavigator().tryMoveToXYZ((double)((int)this.thePet.posX + ix), (double)((int)this.thePet.posY), (double)((int)this.thePet.posZ + iz), 1.0);
        } else if (this.theWorld.rand.nextInt(3) == 1) {
            this.thePet.getNavigator().tryMoveToXYZ((double)((int)this.thePet.posX), (double)((int)this.thePet.posY), (double)((int)this.thePet.posZ), 1.0);
        }
        this.is_dancing = 1;
        return true;
    }

    public void startExecuting() {
        this.thePet.setSneaking(false);
        this.ticker = 0;
        this.dance_move = 0;
        this.is_dancing = 1;
        int ic = 0;
        int iz = 0;
        int ix = 0;
        for (int i = -3; i < 4; ++i) {
            for (int j = -3; j < 4; ++j) {
                Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
                if (!this.is_dance_block(bid)) continue;
                ++ic;
                ix += i;
                iz += j;
            }
        }
        if (ic > 0) {
            ix /= ic;
            iz /= ic;
            if (ic < 40) {
                this.thePet.getNavigator().tryMoveToXYZ((double)((int)this.thePet.posX + ix), (double)((int)this.thePet.posY), (double)((int)this.thePet.posZ + iz), 1.0);
            }
        }
    }

    public void resetTask() {
        this.thePet.setSneaking(false);
        this.ticker = 0;
        this.dance_move = 0;
        this.is_dancing = 0;
    }


    public void updateTask()
    {
      int cycle = 20;
      int halfc = cycle / 2;
      int mover = cycle * 8;
      int tempid = this.thePet.getEntityId();

      AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(this.thePet.posX - 4.0D, this.thePet.posY - 3.0D, this.thePet.posZ - 4.0D, this.thePet.posX + 4.0D, this.thePet.posY + 3.0D, this.thePet.posZ + 4.0D);
      List var5 = this.theWorld.getEntitiesWithinAABB(Girlfriend.class, bb);
      Iterator var2 = var5.iterator();
      while (var2.hasNext())
      {
        Girlfriend var3 = (Girlfriend)var2.next();
        if (var3.getEntityId() < tempid)
        {
          if (var3.Dance.is_dancing == 1) {
            this.ticker = var3.Dance.ticker;
            this.dance_move = var3.Dance.dance_move;
          }
          tempid = var3.getEntityId();
        }
      }

      this.ticker += 1;

      if (this.dance_move == 0) {
        this.dance_move = (1 + this.theWorld.rand.nextInt(10));
        this.thePet.motionX = 0.0D;
        this.thePet.motionZ = 0.0D;
        this.ticker = 0;
        this.thePet.setSneaking(false);
      }

      switch (this.dance_move) {
      case 1:
        move_it(this.thePet, this.ticker, cycle, 0);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 2:
        move_it(this.thePet, this.ticker, cycle, 1);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 3:
        if (this.ticker % cycle < halfc)
          this.thePet.setSneaking(false);
        else {
          this.thePet.setSneaking(true);
        }
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 4:
        if (this.ticker % halfc == 1) {
          this.thePet.swingItem();
          this.thePet.motionY = 0.25D;
        }

        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 5:
        if (this.ticker % halfc == 1) {
          this.thePet.swingItem();
        }
        move_it(this.thePet, this.ticker, cycle, 0);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 6:
        if (this.ticker % halfc == 1) {
          this.thePet.swingItem();
        }
        move_it(this.thePet, this.ticker, cycle, 1);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 7:
        if (this.ticker % cycle < halfc)
          this.thePet.setSneaking(false);
        else {
          this.thePet.setSneaking(true);
        }
        move_it(this.thePet, this.ticker, cycle, 0);
        move_it(this.thePet, this.ticker, cycle, 2);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 8:
        if (this.ticker % cycle < halfc)
          this.thePet.setSneaking(false);
        else {
          this.thePet.setSneaking(true);
        }
        move_it(this.thePet, this.ticker, cycle, 1);
        move_it(this.thePet, this.ticker, cycle, 2);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 9:
        if (this.ticker % cycle < halfc)
          this.thePet.setSneaking(false);
        else {
          this.thePet.setSneaking(true);
        }
        if (this.ticker % halfc == 1) {
          this.thePet.swingItem();
        }
        move_it(this.thePet, this.ticker, cycle, 0);
        move_it(this.thePet, this.ticker, cycle, 3);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      case 10:
        if (this.ticker % cycle < halfc) {
          this.thePet.setSneaking(false);
          this.thePet.motionY = 0.25D;
        } else {
          this.thePet.setSneaking(true);
        }
        if (this.ticker % halfc == 1) {
          this.thePet.swingItem();
        }
        move_it(this.thePet, this.ticker, cycle, 1);
        move_it(this.thePet, this.ticker, cycle, 3);
        if (this.ticker <= mover) break; this.dance_move = 0; break;
      default:
        this.dance_move = 0;
      }
    }

    private void move_it(EntityTameable et, int t, int cycle, int dir) {
        float dirx = 0.0f;
        float dirz = 0.0f;
        float dirYaw = 0.0f;
        float dirYawH = 0.0f;
        switch (dir) {
            case 0: {
                dirx = 0.02f;
                dirz = 0.0f;
                dirYaw = 0.0f;
                dirYawH = 0.0f;
                break;
            }
            case 1: {
                dirx = 0.0f;
                dirz = 0.02f;
                dirYaw = 0.0f;
                dirYawH = 0.0f;
                break;
            }
            case 2: {
                dirx = 0.0f;
                dirz = 0.0f;
                dirYaw = 10.0f;
                dirYawH = 0.0f;
                break;
            }
            case 3: {
                dirx = 0.0f;
                dirz = 0.0f;
                dirYaw = 0.0f;
                dirYawH = 10.0f;
                break;
            }
        }
        if ((t %= cycle) >= cycle / 2) {
            dirx = - dirx;
            dirz = - dirz;
            dirYaw = - dirYaw;
            dirYawH = - dirYawH;
        }
        if ((t %= cycle / 2) >= cycle / 4) {
            dirYaw = - dirYaw;
            dirYawH = - dirYawH;
        }
        et.motionX += (double)dirx;
        et.motionZ += (double)dirz;
        et.rotationYaw += dirYaw;
        et.rotationYawHead += dirYawH;
    }
}

