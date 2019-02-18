/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockCrystalTreeLog
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockRotatedPillar
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.IBlockAccess
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockCrystalTreeLog
extends BlockRotatedPillar {
    @SideOnly(value=Side.CLIENT)
    private IIcon field_111052_c;
    @SideOnly(value=Side.CLIENT)
    private IIcon tree_top;

    protected BlockCrystalTreeLog(int par1, int par2) {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(Item.getItemFromBlock((Block)this), 1, 0);
    }

    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    public boolean isWood(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock((Block)OreSpawnMain.MyCrystalTreeLog);
    }

    @SideOnly(value=Side.CLIENT)
    protected IIcon getSideIcon(int par1) {
        return this.field_111052_c;
    }

    @SideOnly(value=Side.CLIENT)
    protected IIcon getTopIcon(int par1) {
        return this.tree_top;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.field_111052_c = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
        this.tree_top = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_top");
    }
}

