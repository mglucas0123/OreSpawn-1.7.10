/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemAppleSeed
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class ItemAppleSeed
extends Item {
    public ItemAppleSeed(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                return false;
            }
            if (this == OreSpawnMain.MyAppleSeed) {
                this.makeTree(world, x, y, z, OreSpawnMain.MyAppleLeaves, null);
            } else if (this == OreSpawnMain.MyCherrySeed) {
                this.makeTree(world, x, y, z, OreSpawnMain.MyCherryLeaves, null);
            } else {
                this.makeTree(world, x, y, z, OreSpawnMain.MyPeachLeaves, null);
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public void makeTree(World world, int x, int y, int z, Block blkid, Chunk chunk) {
        int j;
        Block bid = world.getBlock(x, y, z);
        if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
            return;
        }
        int h1 = 12;
        int h2 = 6;
        int h3 = 9;
        int h4 = 6;
        int h5 = 14;
        int w1 = 5;
        int w2 = 3;
        if (blkid == OreSpawnMain.MyPeachLeaves) {
            h1 = 10;
            h2 = 5;
            h3 = 7;
            h4 = 5;
            h5 = 12;
            w1 = 4;
            w2 = 2;
        }
        if (blkid == OreSpawnMain.MyCherryLeaves) {
            h1 = 8;
            h2 = 3;
            h3 = 5;
            h4 = 3;
            h5 = 10;
            w1 = 3;
            w2 = 1;
        }
        for (j = 1; j < h1; ++j) {
            world.setBlock(x, y + j, z, Blocks.log, 0, 2);
        }
        for (j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)(x + j), (int)(y + h2), (int)z, (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)(x - j), (int)(y + h2), (int)z, (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)x, (int)(y + h2), (int)(z + j), (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)x, (int)(y + h2), (int)(z - j), (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)(x + j), (int)(y + h3), (int)z, (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)(x - j), (int)(y + h3), (int)z, (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)x, (int)(y + h3), (int)(z + j), (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast((World)world, (int)x, (int)(y + h3), (int)(z - j), (Block)Blocks.log, (int)0, (int)2, (Chunk)chunk);
        }
        for (int i = h4; i < h5; ++i) {
            int width = 6;
            if (i > 8) {
                width = 5;
            }
            if (i > 10) {
                width = 4;
            }
            if (blkid != OreSpawnMain.MyAppleLeaves) {
                --width;
            }
            for (j = - width; j <= width; ++j) {
                for (int k = - width; k <= width; ++k) {
                    bid = world.getBlock(x + k, y + i, z + j);
                    if (bid != Blocks.air) continue;
                    OreSpawnMain.setBlockSuperFast((World)world, (int)(x + k), (int)(y + i), (int)(z + j), (Block)blkid, (int)0, (int)2, (Chunk)chunk);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

