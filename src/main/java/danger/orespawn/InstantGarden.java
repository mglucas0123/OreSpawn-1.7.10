/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.InstantGarden
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockSand
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class InstantGarden
extends Item {
    public InstantGarden(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
        int deltax = 0;
        int deltaz = 0;
        boolean bid = false;
        int dirx = 0;
        int dirz = 0;
        int height = 10;
        int width = 7;
        int length = 18;
        if (cposx < 0) {
            dirx = -1;
        }
        if (cposz < 0) {
            dirz = -1;
        }
        int pposx = (int)(Player.posX + 0.99 * (double)dirx);
        int pposy = (int)Player.posY;
        int pposz = (int)(Player.posZ + 0.99 * (double)dirz);
        if (cposx - pposx == 0 || cposz - pposz == 0) {
            int j;
            int i;
            int k;
            int x = cposx;
            int y = pposy;
            int z = cposz;
            if (x - pposx < 0) {
                deltax = -1;
            }
            if (x - pposx > 0) {
                deltax = 1;
            }
            if (z - pposz < 0) {
                deltaz = -1;
            }
            if (z - pposz > 0) {
                deltaz = 1;
            }
            if (deltax == 0 && deltaz == 0) {
                return false;
            }
            if (deltax != 0 && deltaz != 0) {
                return false;
            }
            Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0f, 1.5f);
            if (world.isRemote) {
                return true;
            }
            for (i = 0; i < height; ++i) {
                for (k = 0; k < length; ++k) {
                    for (j = - width; j <= width; ++j) {
                        world.setBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                        if (i != 0) continue;
                        world.setBlock(x + k * deltax + j * deltaz, y + i - 1, z + k * deltaz + j * deltax, (Block)Blocks.grass, 0, 2);
                    }
                }
            }
            for (k = 1; k < length - 1; ++k) {
                i = 0;
                for (j = - width; j <= width; ++j) {
                    if (i == 1) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyRadishPlant, 0, 2);
                    }
                    if (i == 2) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyLettucePlant1, 0, 2);
                    }
                    if (i == 3) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.carrots, 0, 2);
                    }
                    if (i == 4) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                    }
                    if (i == 5) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.potatoes, 0, 2);
                    }
                    if (i == 6) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.wheat, 0, 2);
                    }
                    if (i == 7) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyTomatoPlant1, 0, 2);
                    }
                    if (i == 8) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                    }
                    if (i == 9) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyCornPlant1, 0, 2);
                    }
                    if (i == 10) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyStrawberryPlant, 0, 2);
                    }
                    if (i == 11) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, (Block)Blocks.sand, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.reeds, 0, 2);
                    }
                    if (i == 12) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                    }
                    if (i == 13) {
                        world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.farmland, 0, 2);
                        world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.melon_stem, 0, 2);
                    }
                    ++i;
                }
            }
            if (!Player.capabilities.isCreativeMode) {
                --par1ItemStack.stackSize;
            }
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

