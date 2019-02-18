/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.InstantShelter
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockChest
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemEmptyMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEmptyMap;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class InstantShelter
extends Item {
    public InstantShelter(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
        int deltax = 0;
        int deltaz = 0;
        boolean bid = false;
        int dirx = 0;
        int dirz = 0;
        int stuffdir = 0;
        int length = 3;
        int width = 3;
        int height = 3;
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
            int y = pposy - 1;
            int z = cposz;
            if (x - pposx < 0) {
                deltax = -1;
                stuffdir = 3;
            }
            if (x - pposx > 0) {
                deltax = 1;
                stuffdir = 2;
            }
            if (z - pposz < 0) {
                deltaz = -1;
                stuffdir = 5;
            }
            if (z - pposz > 0) {
                deltaz = 1;
                stuffdir = 4;
            }
            if (deltax == 0 && deltaz == 0) {
                return false;
            }
            if (deltax != 0 && deltaz != 0) {
                return false;
            }
            x = pposx;
            z = pposz;
            Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0f, 1.5f);
            if (world.isRemote) {
                return true;
            }
            for (i = - width; i <= width; ++i) {
                for (j = - length; j <= length; ++j) {
                    for (k = 0; k <= height + 1; ++k) {
                        if (k == height + 1) {
                            world.setBlock(x + i, y + k, z + j, Blocks.planks);
                            continue;
                        }
                        if (k == 0) {
                            world.setBlock(x + i, y + k, z + j, Blocks.cobblestone);
                            continue;
                        }
                        if (i == width || j == length || i == - width || j == - length) {
                            if (k == height) {
                                world.setBlock(x + i, y + k, z + j, Blocks.glass);
                                continue;
                            }
                            if ((k == 1 || k == 2) && i == deltax * width && j == deltaz * length) {
                                world.setBlock(x + i, y + k, z + j, Blocks.air);
                                continue;
                            }
                            world.setBlock(x + i, y + k, z + j, Blocks.planks);
                            continue;
                        }
                        world.setBlock(x + i, y + k, z + j, Blocks.air);
                    }
                }
            }
            i = 2;
            k = 1;
            j = length - 1;
            world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.furnace);
            world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
            i = 1;
            world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.crafting_table);
            i = 0;
            world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)Blocks.chest);
            world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
            TileEntityChest chest = (TileEntityChest)world.getTileEntity(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
            if (chest != null) {
                chest.setInventorySlotContents(0, new ItemStack(Items.compass));
                chest.setInventorySlotContents(1, new ItemStack((Item)Items.map));
                chest.setInventorySlotContents(2, new ItemStack(Items.porkchop, 8));
                chest.setInventorySlotContents(3, new ItemStack(Blocks.torch, 32));
                chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16));
                chest.setInventorySlotContents(5, new ItemStack(Items.bed));
                chest.setInventorySlotContents(6, new ItemStack(Items.bed));
                chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
                chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe));
                chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword));
                chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe));
                chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
                chest.setInventorySlotContents(12, new ItemStack(OreSpawnMain.MyOreSaltBlock, 4));
                chest.setInventorySlotContents(13, new ItemStack((Block)Blocks.chest));
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

