/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockPizza
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.FoodStats
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPizza
extends Block {
    @SideOnly(value=Side.CLIENT)
    private IIcon pizzaTopIcon;
    @SideOnly(value=Side.CLIENT)
    private IIcon pizzaBottomIcon;
    @SideOnly(value=Side.CLIENT)
    private IIcon field_94382_c;

    protected BlockPizza(int par1) {
        super(Material.cake);
        this.setTickRandomly(true);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        float f = 0.0625f;
        float f1 = (float)(1 + l * 2) / 16.0f;
        float f2 = 0.25f;
        this.setBlockBounds(f1, 0.0f, f, 1.0f - f, f2, 1.0f - f);
    }

    public void setBlockBoundsForItemRender() {
        float f = 0.0625f;
        float f1 = 0.25f;
        this.setBlockBounds(f, 0.0f, f, 1.0f - f, f1, 1.0f - f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = 0.0625f;
        float f1 = (float)(1 + l * 2) / 16.0f;
        float f2 = 0.25f;
        return AxisAlignedBB.getBoundingBox((double)((float)par2 + f1), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)par3 + f2 - f), (double)((float)(par4 + 1) - f));
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = 0.0625f;
        float f1 = (float)(1 + l * 2) / 16.0f;
        float f2 = 0.25f;
        return AxisAlignedBB.getBoundingBox((double)((float)par2 + f1), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)par3 + f2), (double)((float)(par4 + 1) - f));
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return par1 == 1 ? this.pizzaTopIcon : (par1 == 0 ? this.pizzaBottomIcon : (par2 > 0 && par1 == 4 ? this.field_94382_c : this.blockIcon));
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_side");
        this.field_94382_c = par1IIconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_inner");
        this.pizzaTopIcon = par1IIconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_top");
        this.pizzaBottomIcon = par1IIconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_bottom");
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        this.eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        this.eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
    }

    private void eatPizzaSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        if (par5EntityPlayer.canEat(false)) {
            par5EntityPlayer.getFoodStats().addStats(4, 0.2f);
            int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
            if (l >= 6) {
                par1World.setBlockToAir(par2, par3, par4);
            } else {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
            }
        }
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : this.canBlockStay(par1World, par2, par3, par4);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        return par1World.getBlock(par2, par3 - 1, par4).isNormalCube();
    }

    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return OreSpawnMain.MyPizzaItem;
    }
}

