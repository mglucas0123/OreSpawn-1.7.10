/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.MyBlockFlower
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.EnumPlantType
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.common.util.ForgeDirection
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class MyBlockFlower
extends Block
implements IPlantable {
    protected MyBlockFlower(int par1, Material par2Material) {
        super(par2Material);
        this.setTickRandomly(true);
        float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    protected MyBlockFlower(int par1) {
        this(par1, Material.plants);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }

    protected boolean canPlaceBlockOn(Block par1) {
        return par1 == Blocks.grass || par1 == Blocks.dirt || par1 == Blocks.farmland || par1 == OreSpawnMain.CrystalGrass;
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        this.checkFlowerChange(par1World, par2, par3, par4);
    }

    protected final void checkFlowerChange(World par1World, int par2, int par3, int par4) {
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            return;
        }
        long t = par1World.getWorldTime();
        if ((t %= 24000L) > 12000L) {
            if (this == OreSpawnMain.MyFlowerPinkBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlackBlock);
            }
            if (this == OreSpawnMain.MyFlowerBlueBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerScaryBlock);
            }
        } else {
            if (this == OreSpawnMain.MyFlowerBlackBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerPinkBlock);
            }
            if (this == OreSpawnMain.MyFlowerScaryBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlueBlock);
            }
        }
    }

    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
        return p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).canSustainPlant((IBlockAccess)p_149718_1_, p_149718_2_, p_149718_3_ - 1, p_149718_4_, ForgeDirection.UP, (IPlantable)this);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }

    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Plains;
    }

    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return this;
    }

    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z);
    }
}

