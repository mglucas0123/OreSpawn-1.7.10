/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.CrystalGrass
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.IPlantable
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
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class CrystalGrass
extends Block {
    @SideOnly(value=Side.CLIENT)
    private IIcon[] field_94364_a;

    protected CrystalGrass(int par1, float f1, float f2) {
        super(Material.grass);
        this.setHardness(f1);
        this.setResistance(f2);
        this.setTickRandomly(false);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        if (this.field_94364_a == null) {
            return null;
        }
        return par1 == 1 ? this.field_94364_a[0] : (par1 == 0 ? this.field_94364_a[1] : this.field_94364_a[2]);
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (this.field_94364_a == null) {
            return null;
        }
        if (par5 == 1) {
            return this.field_94364_a[0];
        }
        if (par5 == 0) {
            return this.field_94364_a[1];
        }
        return this.field_94364_a[2];
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock((Block)this);
    }

    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
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

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.field_94364_a = new IIcon[3];
        this.field_94364_a[0] = par1IIconRegister.registerIcon("OreSpawn:crystalgrass_top");
        this.field_94364_a[1] = par1IIconRegister.registerIcon("OreSpawn:crystalgrass_bottom");
        this.field_94364_a[2] = par1IIconRegister.registerIcon("OreSpawn:crystalgrass_side");
    }
}

