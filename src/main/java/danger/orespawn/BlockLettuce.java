/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockLettuce
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockReed
 *  net.minecraft.client.renderer.texture.IIconRegister
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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockLettuce
extends BlockReed {
    protected BlockLettuce(int par1) {
        float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        Block bid = par1World.getBlock(par2, par3 - 1, par4);
        if (bid == Blocks.air) {
            return false;
        }
        if (bid == OreSpawnMain.MyLettucePlant1 || bid == OreSpawnMain.MyLettucePlant2 || bid == OreSpawnMain.MyLettucePlant3 || bid == OreSpawnMain.MyLettucePlant4 || bid == Blocks.grass || bid == Blocks.dirt || bid == Blocks.farmland) {
            return true;
        }
        return false;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        boolean dontGrow = false;
        if (par1World.isRemote) {
            return;
        }
        int var7 = par1World.getBlockMetadata(par2, par3, par4);
        if ((var7 &= 255) >= 4) {
            Block bid = par1World.getBlock(par2, par3, par4);
            if (bid == OreSpawnMain.MyLettucePlant1) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant2, 0, 2);
            } else if (bid == OreSpawnMain.MyLettucePlant2) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant3, 0, 2);
            } else if (bid == OreSpawnMain.MyLettucePlant3) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant4, 0, 2);
            }
        } else {
            Block bid = par1World.getBlock(par2, par3, par4);
            par1World.setBlock(par2, par3, par4, bid, var7 + 1, 2);
        }
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return OreSpawnMain.MyLettuce;
    }

    public int quantityDropped(Random par1Random) {
        if (this == OreSpawnMain.MyLettucePlant4) {
            return 2 + par1Random.nextInt(3);
        }
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

