/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemMinersDream
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
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
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
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
import net.minecraft.world.WorldProvider;

public class ItemMinersDream
extends Item {
    public ItemMinersDream(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
        int deltax = 0;
        int deltaz = 0;
        int dirx = 0;
        int dirz = 0;
        int height = 5;
        int width = 5;
        int length = 64;
        int torches = 5;
        int solid_count = 0;
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
            Block bid;
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
            for (int i = 0; i < height; ++i) {
                for (k = 0; k < length; ++k) {
                    int j;
                    solid_count = 0;
                    for (j = - width; j <= width; ++j) {
                        bid = world.getBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax);
                        if (bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.flowing_water || bid == Blocks.water || bid == Blocks.flowing_lava || bid == Blocks.lava || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == OreSpawnMain.CrystalStone) {
                            world.setBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                        }
                        if (i != height - 1) continue;
                        bid = world.getBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax);
                        if (bid != Blocks.air) {
                            ++solid_count;
                        }
                        if (bid != Blocks.air && bid != Blocks.gravel && bid != Blocks.sand && bid != Blocks.flowing_water && bid != Blocks.water && bid != Blocks.flowing_lava && bid != Blocks.lava) continue;
                        if (world.provider.dimensionId == OreSpawnMain.DimensionID5) {
                            world.setBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax, OreSpawnMain.CrystalStone, 0, 2);
                            continue;
                        }
                        world.setBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                    }
                    if (i != height - 1 || solid_count != 0) continue;
                    for (j = - width; j <= width; ++j) {
                        world.setBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                    }
                }
            }
            for (k = 0; k < length; k += torches) {
                bid = world.getBlock(x + k * deltax, y - 1, z + k * deltaz);
                if ((bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == Blocks.bedrock) && world.isAirBlock(x + k * deltax, y, z + k * deltaz)) {
                    world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.ExtremeTorch, 0, 2);
                }
                if (bid != OreSpawnMain.CrystalStone || !world.isAirBlock(x + k * deltax, y, z + k * deltaz)) continue;
                world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.CrystalTorch, 0, 2);
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

