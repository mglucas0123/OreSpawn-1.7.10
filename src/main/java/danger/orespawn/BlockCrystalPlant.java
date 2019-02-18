/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockCrystalPlant
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockReed
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCrystalPlant
extends BlockReed {
    protected BlockCrystalPlant(int par1) {
        float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        Block bid = par1World.getBlock(par2, par3 - 1, par4);
        if (bid == Blocks.air) {
            return false;
        }
        if (bid == Blocks.grass || bid == Blocks.dirt || bid == Blocks.farmland || bid == OreSpawnMain.CrystalGrass) {
            return true;
        }
        return false;
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.rand.nextInt(30) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 10; ++j1) {
            par1World.spawnParticle("happyVillager", (double)((float)par2 + par1World.rand.nextFloat()), (double)par3 + (double)par1World.rand.nextFloat(), (double)((float)par4 + par1World.rand.nextFloat()), 0.0, 0.0, 0.0);
        }
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.isRemote) {
            return;
        }
        if (par1World.rand.nextInt(5) != 1) {
            return;
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        if (this == OreSpawnMain.MyCrystalPlant) {
            this.TallCrystalTree(par1World, par2, par3, par4);
        }
        if (this == OreSpawnMain.MyCrystalPlant2) {
            this.ScragglyCrystalTreeWithBranches(par1World, par2, par3, par4);
        }
        if (this == OreSpawnMain.MyCrystalPlant3) {
            this.TallCrystalTreeBlue(par1World, par2, par3, par4);
        }
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        if (this == OreSpawnMain.MyCrystalPlant) {
            return Item.getItemFromBlock((Block)OreSpawnMain.MyCrystalPlant);
        }
        if (this == OreSpawnMain.MyCrystalPlant2) {
            Item.getItemFromBlock((Block)OreSpawnMain.MyCrystalPlant2);
        }
        return Item.getItemFromBlock((Block)OreSpawnMain.MyCrystalPlant3);
    }

    public int quantityDropped(Random par1Random) {
        return 1;
    }

    public int idPicked(World par1World, int par2, int par3, int par4) {
        return 0;
    }

    protected int getSeedItem() {
        return 0;
    }

    protected int getCropItem() {
        return 0;
    }

    public void TallCrystalTree(World world, int x, int y, int z) {
        int n;
        int m;
        int k;
        Block bid;
        int i = 10 + world.rand.nextInt(12);
        int j = i + world.rand.nextInt(18);
        for (k = 0; k < i; ++k) {
            bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves) {
                return;
            }
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)(y + k), (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
        }
        y += i - 1;
        for (k = i; k < j && ((bid = world.getBlock(x, ++y, z)) == Blocks.air || bid == OreSpawnMain.MyCrystalTreeLog || bid == OreSpawnMain.MyCrystalLeaves); ++k) {
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            if (k % 4 != 0) continue;
            for (m = -1; m < 2; ++m) {
                for (n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                    OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0, (int)2);
                }
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            }
        }
        for (m = -3; m < 4; ++m) {
            for (n = -3; n < 4; ++n) {
                bid = world.getBlock(x + m, y, z + n);
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0, (int)2);
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                bid = world.getBlock(x + m, y, z + n);
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0, (int)2);
            }
        }
    }

    public void makeScragglyCrystalBranch(World world, int x, int y, int z, int len, int biasx, int biasz) {
        for (int k = 0; k < len; ++k) {
            Block bid;
            int iy;
            int ix = world.rand.nextInt(2) - world.rand.nextInt(2) + biasx;
            int iz = world.rand.nextInt(2) - world.rand.nextInt(2) + biasz;
            if (ix > 1) {
                ix = 1;
            }
            if (ix < -1) {
                ix = -1;
            }
            if (iz > 1) {
                iz = 1;
            }
            if (iz < -1) {
                iz = -1;
            }
            if ((bid = world.getBlock(x += ix, y += (iy = world.rand.nextInt(3) > 0 ? 1 : 0), z += iz)) != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                    OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves2, (int)0, (int)2);
                }
            }
            if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x, y + 1, z)) != Blocks.air) continue;
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)(y + 1), (int)z, (Block)OreSpawnMain.MyCrystalLeaves2, (int)0, (int)2);
        }
    }

    public void ScragglyCrystalTreeWithBranches(World world, int x, int y, int z) {
        int k;
        Block bid;
        int i = 1 + world.rand.nextInt(2);
        int j = i + world.rand.nextInt(8);
        for (k = 0; k < i; ++k) {
            bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)(y + k), (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
        }
        y += i - 1;
        for (k = i; k < j; ++k) {
            int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
            int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
            int iy = world.rand.nextInt(4) > 0 ? 1 : 0;
            bid = world.getBlock(x += ix, y += iy, z += iz);
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) break;
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyCrystalBranch(world, x, y, z, world.rand.nextInt(1 + j - k), world.rand.nextInt(2) - world.rand.nextInt(2), world.rand.nextInt(2) - world.rand.nextInt(2));
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                    OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves2, (int)0, (int)2);
                }
            }
            if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x, y + 1, z)) != Blocks.air) continue;
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)(y + 1), (int)z, (Block)OreSpawnMain.MyCrystalLeaves2, (int)0, (int)2);
        }
    }

    public void TallCrystalTreeBlue(World world, int x, int y, int z) {
        int n;
        int m;
        int k;
        Block bid;
        int i = 5 + world.rand.nextInt(6);
        int j = 2 + i + world.rand.nextInt(12);
        for (k = 0; k < i; ++k) {
            bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves3) {
                return;
            }
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)(y + k), (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
        }
        y += i - 1;
        for (k = i; k < j && ((bid = world.getBlock(x, ++y, z)) == Blocks.air || bid == OreSpawnMain.MyCrystalTreeLog || bid == OreSpawnMain.MyCrystalLeaves3); ++k) {
            OreSpawnMain.setBlockFast((World)world, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            if (k % 3 != 0) continue;
            for (m = -1; m < 2; ++m) {
                for (n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                    OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves3, (int)0, (int)2);
                }
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                if (world.rand.nextInt(2) != 1 || (bid = world.getBlock(x + m, y, z + n)) != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalTreeLog, (int)0, (int)2);
            }
        }
        for (m = -3; m < 4; ++m) {
            for (n = -3; n < 4; ++n) {
                bid = world.getBlock(x + m, y, z + n);
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves3, (int)0, (int)2);
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                bid = world.getBlock(x + m, y, z + n);
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockFast((World)world, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves3, (int)0, (int)2);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

