/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockDuctTape
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
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
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDuctTape
extends Block {
    @SideOnly(value=Side.CLIENT)
    private IIcon DuctTapeTopIcon;
    @SideOnly(value=Side.CLIENT)
    private IIcon DuctTapeBottomIcon;
    @SideOnly(value=Side.CLIENT)
    private IIcon field_94382_c;

    protected BlockDuctTape(int par1) {
        super(Material.anvil);
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
        return par1 == 1 ? this.DuctTapeTopIcon : (par1 == 0 ? this.DuctTapeBottomIcon : (par2 > 0 && par1 == 4 ? this.field_94382_c : this.blockIcon));
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_side");
        this.field_94382_c = par1IconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_inner");
        this.DuctTapeTopIcon = par1IconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_top");
        this.DuctTapeBottomIcon = par1IconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5) + "_bottom");
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        this.eatDuctTapeSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        this.eatDuctTapeSlice(par1World, par2, par3, par4, par5EntityPlayer);
    }

    private void eatDuctTapeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        ItemStack var2;
        if (par5EntityPlayer != null && (var2 = par5EntityPlayer.inventory.getCurrentItem()) != null && var2.stackSize == 1) {
            int cd = var2.getMaxDamage();
            int fd = 0;
            if (cd > 0) {
                if ((cd /= 6) < 1) {
                    cd = 1;
                }
                if ((fd = var2.getItemDamage()) > 0) {
                    fd = fd > cd ? (fd -= cd) : 0;
                    var2.setItemDamage(fd);
                    int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
                    if (l >= 6) {
                        par1World.setBlockToAir(par2, par3, par4);
                    } else {
                        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                    }
                }
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
        return par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid();
    }

    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return OreSpawnMain.MyDuctTapeItem;
    }
}

