/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ItemOreSpawnArmor
 *  danger.orespawn.NightmareDungeon
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockChest
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.Item
 *  net.minecraft.tileentity.MobSpawnerBaseLogic
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.WeightedRandomChestContent
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.ItemOreSpawnArmor;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class NightmareDungeon {
    private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[]{new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyExperienceSword, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateShovel, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateHoe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateAxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyBertha, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MySlice, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5)};

    private void setThisBlock(World world, int cposx, int cposy, int cposz) {
        if (world.rand.nextInt(2) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.bedrock);
        } else {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.obsidian);
        }
    }

    public void makeDungeon(World world, int cposx, int cposy, int cposz) {
        int i;
        int k;
        int j;
        int width = 25;
        int height = 12;
        for (i = 0; i < width; ++i) {
            for (j = 0; j < height; ++j) {
                for (k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (i = 0; i < width; ++i) {
            j = 0;
            for (k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, OreSpawnMain.MyRTPBlock);
            }
        }
        for (i = 0; i < width; ++i) {
            j = height - 1;
            for (k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (i = 0; i < width; ++i) {
            for (j = 0; j < height; ++j) {
                k = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                k = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (k = 0; k < width; ++k) {
            for (j = 0; j < height; ++j) {
                i = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                i = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(cposx + width / 2, cposy + 1, cposz + width / 2);
        if (tileentitymobspawner != null) {
            if (world.rand.nextInt(2) == 1) {
                tileentitymobspawner.func_145881_a().setEntityName("Emperor Scorpion");
            } else {
                tileentitymobspawner.func_145881_a().setEntityName("Nightmare");
            }
        }
        TileEntityChest chest = null;
        world.setBlock(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, (Block)Blocks.chest, 0, 2);
        chest = (TileEntityChest)world.getTileEntity(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents((Random)world.rand, (WeightedRandomChestContent[])this.chestContentsList, (IInventory)chest, (int)(4 + world.rand.nextInt(7)));
        }
        world.setBlock(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, (Block)Blocks.chest, 0, 2);
        chest = (TileEntityChest)world.getTileEntity(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents((Random)world.rand, (WeightedRandomChestContent[])this.chestContentsList, (IInventory)chest, (int)(4 + world.rand.nextInt(7)));
        }
    }

    public void FastSetBlock(World world, int ix, int iy, int iz, Block id) {
        OreSpawnMain.setBlockFast((World)world, (int)ix, (int)iy, (int)iz, (Block)id, (int)0, (int)3);
    }
}

