/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.OreCrystal
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class OreCrystal
extends Block {
    public OreCrystal(int par1, float lv, float f1, float f2) {
        super(Material.rock);
        this.setHardness(f1);
        this.setResistance(f2);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightLevel(lv);
        this.setTickRandomly(true);
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.rand.nextInt(5) == 0) {
            this.sparkle(par1World, par2, par3, par4);
        }
    }

    private void sparkle(World par1World, int par2, int par3, int par4) {
        int which = 0;
        float dx = 0.5f;
        float dz = 0.5f;
        float dy = 0.5f;
        for (int j1 = 0; j1 < 5; ++j1) {
            which = par1World.rand.nextInt(3);
            if (which == 0) {
                par1World.spawnParticle("flame", (double)((float)par2 + dx), (double)par3 + (double)dy, (double)((float)par4 + dz), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f));
            }
            if (which == 1) {
                par1World.spawnParticle("smoke", (double)((float)par2 + dx), (double)par3 + (double)dy, (double)((float)par4 + dz), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f));
            }
            if (which != 2) continue;
            par1World.spawnParticle("reddust", (double)((float)par2 + dx), (double)par3 + (double)dy, (double)((float)par4 + dz), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f), (double)((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f));
        }
    }

    public int getRenderType() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.isRemote && par1World.rand.nextInt(3) == 1) {
            par1World.newExplosion((Entity)null, (double)((float)par2 + 0.5f), (double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), 1.5f, true, par1World.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        }
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
        if (par3 < 40) {
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

