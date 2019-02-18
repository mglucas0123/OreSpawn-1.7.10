/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BlockExtremeTorch
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockTorch
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class BlockExtremeTorch
extends BlockTorch {
    public BlockExtremeTorch(int par1) {
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        double var7 = (float)par2 + 0.5f;
        double var9 = (float)par3 + 0.7f;
        double var11 = (float)par4 + 0.5f;
        double var13 = 0.213;
        double var15 = 0.271;
        if (var6 == 1) {
            par1World.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7 - var15, var9 + var13, var11, 0.0, 0.0, 0.0);
        } else if (var6 == 2) {
            par1World.spawnParticle("smoke", var7 + var15, var9 + var13, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7 + var15, var9 + var13, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7 + var15, var9 + var13, var11, 0.0, 0.0, 0.0);
        } else if (var6 == 3) {
            par1World.spawnParticle("smoke", var7, var9 + var13, var11 - var15, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var9 + var13, var11 - var15, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var9 + var13, var11 - var15, 0.0, 0.0, 0.0);
        } else if (var6 == 4) {
            par1World.spawnParticle("smoke", var7, var9 + var13, var11 + var15, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var9 + var13, var11 + var15, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var9 + var13, var11 + var15, 0.0, 0.0, 0.0);
        } else {
            par1World.spawnParticle("smoke", var7, var9, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var9, var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var9, var11, 0.0, 0.0, 0.0);
        }
        this.onBlockPlacedBy(par1World, par2, par3, par4, null, null);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    public void onBlockPlacedBy(World world, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
        int x = par2;
        int y = par3;
        int z = par4;
        boolean found = false;
        if (world.getBlock(x, y - 1, z) == OreSpawnMain.MyEyeOfEnderBlock) {
            block0 : for (int tries = 0; tries < 100 && !found; ++tries) {
                x = world.rand.nextInt(2) == 0 ? par2 + 4 + world.rand.nextInt(3) - world.rand.nextInt(3) : par2 - 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                z = world.rand.nextInt(2) == 0 ? par4 + 4 + world.rand.nextInt(3) - world.rand.nextInt(3) : par4 - 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                for (y = par3 - 2; y <= par3 + 2; ++y) {
                    if (!world.getBlock(x, y - 1, z).getMaterial().isSolid() || world.getBlock(x, y, z) != Blocks.air || world.getBlock(x, y + 1, z) != Blocks.air) continue;
                    found = true;
                    continue block0;
                }
            }
            if (found) {
                if (!world.isRemote) {
                    Entity ent = null;
                    ent = BlockExtremeTorch.spawnCreature((World)world, (String)"Cephadrome", (double)((double)x + 0.5), (double)((double)y + 0.01), (double)((double)z + 0.5));
                } else {
                    for (int var3 = 0; var3 < 16; ++var3) {
                        world.spawnParticle("smoke", (double)((float)par2 + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)par3 + world.rand.nextFloat()), (double)((float)par4 + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
                        world.spawnParticle("explode", (double)((float)par2 + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)par3 + world.rand.nextFloat()), (double)((float)par4 + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
                        world.spawnParticle("reddust", (double)((float)par2 + world.rand.nextFloat() - world.rand.nextFloat()), (double)((float)par3 + world.rand.nextFloat()), (double)((float)par4 + world.rand.nextFloat() - world.rand.nextFloat()), 0.0, 0.0, 0.0);
                    }
                }
                if (par5EntityLiving != null) {
                    par5EntityLiving.worldObj.playSoundAtEntity((Entity)par5EntityLiving, "random.explode", 1.0f, world.rand.nextFloat() * 0.2f + 0.9f);
                } else {
                    world.playSound((double)par2, (double)par3, (double)par4, "random.explode", 1.0f, world.rand.nextFloat() * 0.2f + 0.9f, false);
                }
                world.setBlock(par2, par3, par4, Blocks.air);
            }
        }
        super.onBlockPlacedBy(world, par2, par3, par4, par5EntityLiving, par6ItemStack);
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
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

