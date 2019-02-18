/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.KingSpawnerBlock
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.TheKing
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockReed
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.TheKing;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class KingSpawnerBlock
extends BlockReed {
    protected KingSpawnerBlock(int par1) {
        float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        if (par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid()) {
            return true;
        }
        return false;
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            this.updateTick(par1World, par2, par3, par4, par5Random);
            return;
        }
        if (par1World.rand.nextInt(20) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 20; ++j1) {
            par1World.spawnParticle("fireworksSpark", (double)((float)par2 + par1World.rand.nextFloat()), (double)par3 + (double)par1World.rand.nextFloat(), (double)((float)par4 + par1World.rand.nextFloat()), 0.0, 0.0, 0.0);
        }
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        if (world.isRemote) {
            return;
        }
        world.scheduleBlockUpdate(x, y, z, (Block)this, 100);
    }

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        this.updateTick(par1World, par2, par3, par4, null);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.isRemote) {
            return;
        }
        if (OreSpawnMain.TheKingEnable != 0) {
            KingSpawnerBlock.spawnTheKing((World)par1World, (double)par2, (double)(par3 + 8), (double)par4);
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        par1World.setBlock(par2, par3 + 1, par4, Blocks.air, 0, 2);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock((Block)OreSpawnMain.MyKingSpawnerBlock);
    }

    public int quantityDropped(Random par1Random) {
        return 1;
    }

    public static Entity spawnTheKing(World par0World, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)"The King", (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
            ((TheKing)var8).setGuardMode(1);
        }
        return var8;
    }

    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        this.updateTick(par1World, par2, par3, par4, null);
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

