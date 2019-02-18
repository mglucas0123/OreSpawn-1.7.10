/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Island
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.Triffid
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockBush
 *  net.minecraft.block.BlockMycelium
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import danger.orespawn.Triffid;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockMycelium;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class Island
extends EntityAnimal {
    private float dir = 0.0f;
    private float speed = 0.1f;
    private int radius = 5;
    private int depth = 3;
    private int timer = 73;
    private int just_spawned = 1;
    private int ticker = 0;
    private int once = 1;
    private double myX;
    private double myY;
    private double myZ;
    private int dirchange;

    public Island(World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.5f);
        this.ticker = par1World.rand.nextInt(50);
        this.dirchange = this.worldObj.rand.nextInt(2500);
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.once != 0) {
            this.myX = this.posX;
            this.myY = this.posY;
            this.myZ = this.posZ;
            this.once = 0;
        }
        if (this.just_spawned != 0) {
            this.dir = this.worldObj.rand.nextFloat() * 3.1415927f;
            if (this.worldObj.rand.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
            if (this.worldObj.rand.nextInt(40) != 1) {
                this.radius = 3 + this.worldObj.rand.nextInt(4);
                this.depth = 2 + this.worldObj.rand.nextInt(3);
                this.speed = this.worldObj.rand.nextFloat() / 50.0f * (float)OreSpawnMain.IslandSpeedFactor;
            } else {
                this.radius = 6 + this.worldObj.rand.nextInt(5);
                this.depth = 3 + this.worldObj.rand.nextInt(4);
                this.speed = this.worldObj.rand.nextFloat() / 200.0f * (float)OreSpawnMain.IslandSpeedFactor;
            }
            this.create_island();
            this.ticker = this.worldObj.rand.nextInt(50);
            this.dirchange = this.worldObj.rand.nextInt(10000);
        }
        ++this.ticker;
        if (this.ticker >= this.timer) {
            this.update_island();
            this.ticker = 0;
        }
        --this.dirchange;
        if (this.dirchange <= 0) {
            this.dirchange = this.worldObj.rand.nextInt(5000);
            this.dir = this.worldObj.rand.nextFloat() * 3.1415927f;
            if (this.worldObj.rand.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
        }
        this.just_spawned = 0;
    }

    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            super.onLivingUpdate();
        }
    }

    protected void updateAITick() {
    }

    protected void updateAITasks() {
    }

    protected void fall(float par1) {
    }

    protected boolean canDespawn() {
        return false;
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.just_spawned = par1NBTTagCompound.getInteger("JustSpawned");
        this.depth = par1NBTTagCompound.getInteger("Idepth");
        this.radius = par1NBTTagCompound.getInteger("Iradius");
        this.speed = par1NBTTagCompound.getFloat("Ispeed");
        this.dir = par1NBTTagCompound.getFloat("Idir");
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("JustSpawned", this.just_spawned);
        par1NBTTagCompound.setInteger("Idepth", this.depth);
        par1NBTTagCompound.setInteger("Iradius", this.radius);
        par1NBTTagCompound.setFloat("Ispeed", this.speed);
        par1NBTTagCompound.setFloat("Idir", this.dir);
    }

    public EntityAgeable createChild(EntityAgeable entityageable) {
        return null;
    }

    private void create_island() {
        double deltadir = 0.10471975333333333;
        double deltamag = 0.3499999940395355;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        for (int i = 0; i < this.depth; ++i) {
            izlast = 0;
            ixlast = 0;
            for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                double tradius = this.radius;
                for (double h = 0.75; h < (tradius /= (double)(i + 1)); h += deltamag) {
                    int ix = (int)(this.posX + Math.cos(curdir + (double)this.dir) * h);
                    int iz = (int)(this.posZ + Math.sin(curdir + (double)this.dir) * h);
                    if (ix == ixlast && iz == izlast) continue;
                    ixlast = ix;
                    izlast = iz;
                    if (i == 0) {
                        Block bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz);
                        if (bid == Blocks.air) {
                            if (this.worldObj.rand.nextInt(5000) == 1) {
                                this.worldObj.setBlock(ix, (int)this.posY - i + 1, iz, Blocks.lava);
                                continue;
                            }
                            this.FastSetBlock(ix, (int)this.posY - i + 1, iz, (Block)Blocks.mycelium);
                            if (this.worldObj.rand.nextInt(20) != 1 || this.worldObj.getBlock(ix, (int)this.posY - i + 2, iz) != Blocks.air) continue;
                            if (this.worldObj.rand.nextInt(2) == 1) {
                                this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.brown_mushroom);
                                continue;
                            }
                            this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.red_mushroom);
                            continue;
                        }
                        if (bid != Blocks.bedrock) continue;
                        this.setDead();
                        return;
                    }
                    if (this.worldObj.rand.nextInt(10) == 1) {
                        this.FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.diamond_ore);
                        continue;
                    }
                    this.FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.end_stone);
                }
            }
        }
        if (this.posX < 0.0) {
            xoff = -1;
        }
        if (this.posZ < 0.0) {
            zoff = -1;
        }
        this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
        this.FastSetBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
    }

    private void update_island() {
        AxisAlignedBB bb;
        Iterator var2;
        List var5;
        double deltadir = 0.10471975333333333;
        double deltamag = 0.3499999940395355;
        double pi2 = 1.57079632675;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        this.myX += (double)this.speed * Math.cos(this.dir);
        this.myZ += (double)this.speed * Math.sin(this.dir);
        int mx = (int)this.myX;
        int mz = (int)this.myZ;
        int px = (int)this.posX;
        int pz = (int)this.posZ;
        if (mx != px || mz != pz) {
            double h;
            int ix;
            int i;
            double curdir;
            int iz;
            Block bid;
            double tradius;
            for (i = 0; i < this.depth; ++i) {
                izlast = 0;
                ixlast = 0;
                for (curdir = -3.3; curdir < 3.3; curdir += deltadir / 2.0) {
                    tradius = this.radius;
                    for (h = 0.75; h < (tradius /= (double)(i + 1)); h += deltamag) {
                    }
                    if ((h -= deltamag) < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius + deltamag) {
                        ix = (int)(this.posX + Math.cos(curdir + (double)this.dir) * h);
                        iz = (int)(this.posZ + Math.sin(curdir + (double)this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0 && ((bid = this.worldObj.getBlock(ix, (int)this.posY + 1 + 1, iz)) == Blocks.red_mushroom || bid == Blocks.brown_mushroom)) {
                                this.FastSetBlock(ix, (int)this.posY + 1 + 1, iz, Blocks.air);
                            }
                            this.FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.air);
                        }
                        h += deltamag / 2.0;
                    }
                }
            }
            if (this.posX < 0.0) {
                xoff = -1;
            }
            if (this.posZ < 0.0) {
                zoff = -1;
            }
            this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.end_stone);
            this.posX = (int)this.myX;
            this.posX = this.myX < 0.0 ? (this.posX -= 0.5) : (this.posX += 0.5);
            this.posZ = (int)this.myZ;
            this.posZ = this.myZ < 0.0 ? (this.posZ -= 0.5) : (this.posZ += 0.5);
            for (i = 0; i < this.depth; ++i) {
                izlast = 0;
                ixlast = 0;
                for (curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                    tradius = this.radius;
                    for (h = 0.75; h < (tradius /= (double)(i + 1)); h += deltamag) {
                    }
                    if ((h -= deltamag * 3.0) < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius) {
                        ix = (int)(this.posX + Math.cos(curdir + (double)this.dir) * h);
                        iz = (int)(this.posZ + Math.sin(curdir + (double)this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0) {
                                bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz);
                                if (bid == Blocks.air) {
                                    if (this.worldObj.rand.nextInt(5000) == 1) {
                                        this.worldObj.setBlock(ix, (int)this.posY - i + 1, iz, Blocks.lava);
                                    } else {
                                        this.FastSetBlock(ix, (int)this.posY - i + 1, iz, (Block)Blocks.mycelium);
                                        if (this.worldObj.rand.nextInt(20) == 1 && this.worldObj.getBlock(ix, (int)this.posY - i + 2, iz) == Blocks.air) {
                                            if (this.worldObj.rand.nextInt(2) == 1) {
                                                this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.brown_mushroom);
                                            } else {
                                                this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.red_mushroom);
                                            }
                                        }
                                    }
                                } else if (bid == Blocks.bedrock) {
                                    this.setDead();
                                    return;
                                }
                            } else {
                                bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz);
                                if (bid == Blocks.stone) {
                                    if (!this.worldObj.isRemote) {
                                        this.worldObj.createExplosion((Entity)this, (double)ix, this.posY - (double)i + 1.0, (double)iz, 5.0f, true);
                                    }
                                } else if (this.worldObj.rand.nextInt(10) == 1) {
                                    this.FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.diamond_ore);
                                } else {
                                    this.FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.end_stone);
                                }
                            }
                        }
                        h += deltamag;
                    }
                }
            }
            xoff = 0;
            if (this.posX < 0.0) {
                xoff = -1;
            }
            zoff = 0;
            if (this.posZ < 0.0) {
                zoff = -1;
            }
            this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
            this.FastSetBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
        }
        if (this.worldObj.rand.nextInt(2 + 2000 / this.timer) == 1 && !(var2 = (var5 = this.worldObj.getEntitiesWithinAABB(Triffid.class, bb = AxisAlignedBB.getBoundingBox((double)(this.posX - 10.0), (double)(this.posY - 5.0), (double)(this.posZ - 10.0), (double)(this.posX + 10.0), (double)(this.posY + 5.0), (double)(this.posZ + 10.0)))).iterator()).hasNext()) {
            EntityCreature newent = (EntityCreature)Island.spawnCreature((World)this.worldObj, (String)"Triffid", (double)this.posX, (double)(this.posY + 2.01), (double)this.posZ);
        }
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

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block)OreSpawnMain.MyIslandBlock);
    }

    public void FastSetBlock(int ix, int iy, int iz, Block id) {
        OreSpawnMain.setBlockFast((World)this.worldObj, (int)ix, (int)iy, (int)iz, (Block)id, (int)0, (int)3);
    }
}

