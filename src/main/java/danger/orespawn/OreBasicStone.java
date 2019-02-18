/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.OreBasicStone
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 *  net.minecraftforge.common.util.ForgeDirection
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/*
 * Exception performing whole class analysis ignored.
 */
public class OreBasicStone
extends Block {
    public OreBasicStone(int par1, float f1, float f2) {
        super(Material.rock);
        this.setHardness(f1);
        this.setResistance(f2);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(false);
    }

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        int i;
        int num;
        if (!par1World.isRemote && this == OreSpawnMain.CrystalRat) {
            num = 1 + par1World.rand.nextInt(10);
            for (i = 0; i < num; ++i) {
                OreBasicStone.spawnCreature((World)par1World, (int)0, (String)"Rat", (double)((double)par2 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2), (double)((double)par3 + 0.01), (double)((double)par4 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2));
            }
        }
        if (!par1World.isRemote && this == OreSpawnMain.CrystalFairy) {
            num = 1 + par1World.rand.nextInt(6);
            for (i = 0; i < num; ++i) {
                OreBasicStone.spawnCreature((World)par1World, (int)0, (String)"Fairy", (double)((double)par2 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2), (double)((double)par3 + 0.01), (double)((double)par4 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2));
            }
        }
        if (!par1World.isRemote && this == OreSpawnMain.RedAntTroll) {
            num = 15 + par1World.rand.nextInt(6);
            for (i = 0; i < num; ++i) {
                OreBasicStone.spawnCreature((World)par1World, (int)0, (String)"Red Ant", (double)((double)par2 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2), (double)((double)par3 + 0.01), (double)((double)par4 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2));
            }
        }
        if (!par1World.isRemote && this == OreSpawnMain.TermiteTroll) {
            num = 15 + par1World.rand.nextInt(6);
            for (i = 0; i < num; ++i) {
                OreBasicStone.spawnCreature((World)par1World, (int)0, (String)"Termite", (double)((double)par2 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2), (double)((double)par3 + 0.01), (double)((double)par4 + 0.5 + (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2));
            }
        }
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    public boolean isOpaqueCube() {
        if (OreSpawnMain.current_dimension != OreSpawnMain.DimensionID5) {
            return false;
        }
        return true;
    }

    public boolean renderAsNormalBlock() {
        if (OreSpawnMain.current_dimension != OreSpawnMain.DimensionID5) {
            return false;
        }
        return true;
    }

    public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = name == null ? EntityList.createEntityByID((int)par1, (World)par0World) : EntityList.createEntityByName((String)name, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

