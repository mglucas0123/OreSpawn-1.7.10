/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemMagicApple
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.TheKing
 *  danger.orespawn.TheQueen
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockChest
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.WeightedRandomChestContent
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.TheKing;
import danger.orespawn.TheQueen;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IIcon;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class ItemMagicApple
extends Item {
    public int tree_radius = 6;
    public boolean no_critters = false;
    Random rand = OreSpawnMain.OreSpawnRand;
    private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 2, 3), new WeightedRandomChestContent(Items.diamond, 0, 1, 5, 15), new WeightedRandomChestContent(Items.blaze_rod, 0, 1, 3, 10), new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 1, 10, 7), new WeightedRandomChestContent(OreSpawnMain.CagedGirlfriend, 0, 1, 2, 6), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 10, 16), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 6, 16), new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 1, 6, 6), new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 1, 4, 6), new WeightedRandomChestContent(Items.bread, 0, 1, 8, 20), new WeightedRandomChestContent(Items.apple, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cookie, 0, 1, 16, 20), new WeightedRandomChestContent(Items.cooked_beef, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_chicken, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_fished, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_porkchop, 0, 1, 8, 20), new WeightedRandomChestContent(Items.pumpkin_pie, 0, 1, 4, 20), new WeightedRandomChestContent(Items.carrot, 0, 1, 16, 20), new WeightedRandomChestContent(Items.potato, 0, 1, 16, 20), new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 1, 4, 6), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 1, 8, 6), new WeightedRandomChestContent(OreSpawnMain.MyPopcornBag, 0, 1, 4, 16), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 20), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 20), new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.bow, 0, 1, 1, 20), new WeightedRandomChestContent(Items.arrow, 0, 1, 64, 20), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 1), new WeightedRandomChestContent(OreSpawnMain.MyUltimateFishingRod, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.iron_chestplate, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_helmet, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_leggings, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_boots, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.diamond_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_helmet, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_leggings, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 5)};

    public ItemMagicApple(int i) {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.fortune, 2);
    }

    private Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByID((int)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.fortune.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.fortune, 2);
        }
    }

    public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
        this.onUsingTick(stack, (EntityPlayer)null, 0);
    }

    private Boolean isBoringBlock(World world, int x, int y, int z) {
        Block var1 = world.getBlock(x, y, z);
        if (var1 == Blocks.tallgrass) {
            return true;
        }
        if (var1 == Blocks.cactus) {
            return true;
        }
        if (var1 == Blocks.red_flower) {
            return true;
        }
        if (var1 == Blocks.yellow_flower) {
            return true;
        }
        if (var1 == Blocks.leaves) {
            return true;
        }
        if (var1 == Blocks.snow) {
            return true;
        }
        if (var1 == OreSpawnMain.MyStrawberryPlant) {
            return true;
        }
        if (var1 == OreSpawnMain.MyAppleLeaves) {
            return true;
        }
        if (world.isAirBlock(x, y, z)) {
            return true;
        }
        if (var1 == null) {
            return true;
        }
        return false;
    }

    private Boolean isBoringBaseBlock(World world, int x, int y, int z) {
        if (world.isAirBlock(x, y, z)) {
            return true;
        }
        Block var1 = world.getBlock(x, y, z);
        if (var1 == Blocks.stone) {
            return false;
        }
        if (var1 == Blocks.bedrock) {
            return false;
        }
        return true;
    }

    private void growVines(World world, int par2, int par3, int par4, int par5, int par6, Chunk chunk) {
        if (world.getBlock(par2, par3, par4) != Blocks.air) {
            return;
        }
        this.FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
        while (par6 > 0) {
            if (world.getBlock(par2, --par3, par4) != Blocks.air) {
                return;
            }
            this.FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
            --par6;
        }
    }

    private void make_branch(World world, int x, int y, int z, int this_width, int dirx, int dirz, Block ID, Block leafID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
        int current_width = this_width;
        int last_branch = 0;
        int branch_side = 1;
        int leaf_depth = 0;
        int leaf_width = 0;
        int xaccum = dirx;
        int zaccum = dirz;
        if (this.rand.nextInt(2) == 0) {
            branch_side = -1;
        }
        while (current_width >= 0) {
            int length = this_width * 3 + this.rand.nextInt(this_width + 3);
            for (int i = 0; i < length; ++i) {
                int realx;
                int realz;
                int j;
                for (j = - current_width; j <= current_width; ++j) {
                    realx = x + j * dirz + xaccum;
                    realz = z + j * dirx + zaccum;
                    if (this.isBoringBlock(world, realx, y, realz).booleanValue()) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, realx, y, realz, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, realx, y, realz, ID, 0, 2, chunk);
                        }
                    }
                    if (i <= 0 || j != 0 || current_width < 3) continue;
                    if (tree_type >= 0 && this.rand.nextInt(75) == 0 || tree_type < 0 && this.rand.nextInt(50) == 0) {
                        if (bad_critters || !world.isAirBlock(realx, y + 1, realz)) continue;
                        this.FastSetBlock(world, realx, y + 1, realz, (Block)Blocks.chest, 0, 2, chunk);
                        TileEntityChest chest = (TileEntityChest)world.getTileEntity(realx, y + 1, realz);
                        if (chest == null) continue;
                        WeightedRandomChestContent.generateChestContents((Random)this.rand, (WeightedRandomChestContent[])this.chestContentsList, (IInventory)chest, (int)(1 + this.rand.nextInt(8)));
                        continue;
                    }
                    if (this.rand.nextInt(50) != 0 || bad_critters || !world.isAirBlock(realx, y + 1, realz) || !world.isAirBlock(realx, y + 2, realz) || !world.isAirBlock(realx, y + 3, realz)) continue;
                    Entity ent = null;
                    ent = this.spawnCreature(world, 99, (double)realx + 0.5, (double)y + 1.01, (double)realz + 0.5);
                }
                if (current_width < 3 || this_width <= 1) {
                    leaf_depth = 2 + this.rand.nextInt(2);
                    leaf_width = 2 + this.rand.nextInt(3);
                    for (int n = 0; n < leaf_depth; ++n) {
                        int lw = current_width + leaf_width - n;
                        if (current_width == 0 && length - i <= 2 && lw >= length - i) {
                            lw = length - i - 1;
                        }
                        if (lw < 0) {
                            lw = 0;
                        }
                        for (j = - lw; j <= lw; ++j) {
                            realx = x + j * Math.abs(dirz) + xaccum + dirx;
                            if (!this.isBoringBlock(world, realx, y + n, realz = z + j * Math.abs(dirx) + zaccum + dirz).booleanValue()) continue;
                            if (tree_type >= 0) {
                                this.FastSetBlock(world, realx, y + n, realz, leafID, tree_type, 2, chunk);
                                if (n != 0 || tree_type != 3 || lw == 0 || j != lw && j != - lw || this.rand.nextInt(5) != 0) continue;
                                if (dirx == 0) {
                                    if (j == lw) {
                                        this.growVines(world, realx + 1, y, realz, 2, this.rand.nextInt(10), chunk);
                                        continue;
                                    }
                                    this.growVines(world, realx - 1, y, realz, 8, this.rand.nextInt(10), chunk);
                                    continue;
                                }
                                if (j == lw) {
                                    this.growVines(world, realx, y, realz + 1, 4, this.rand.nextInt(10), chunk);
                                    continue;
                                }
                                this.growVines(world, realx, y, realz - 1, 1, this.rand.nextInt(10), chunk);
                                continue;
                            }
                            Block local_leaf_type = leafID;
                            if (this.rand.nextInt(20) == 1) {
                                if (this.rand.nextInt(3) != 0) {
                                    local_leaf_type = Blocks.redstone_block;
                                } else {
                                    int ilt = this.rand.nextInt(4);
                                    if (ilt == 0) {
                                        local_leaf_type = OreSpawnMain.MyBlockUraniumBlock;
                                    }
                                    if (ilt == 1) {
                                        local_leaf_type = OreSpawnMain.MyBlockTitaniumBlock;
                                    }
                                    if (ilt == 2) {
                                        local_leaf_type = OreSpawnMain.MyBlockRubyBlock;
                                    }
                                    if (ilt == 3) {
                                        local_leaf_type = OreSpawnMain.MyBlockAmethystBlock;
                                    }
                                }
                            }
                            this.FastSetBlock(world, realx, y + n, realz, local_leaf_type, 0, 2, chunk);
                        }
                    }
                }
                if (current_width > 0 && last_branch > current_width && current_width != this_width && this.rand.nextInt(current_width + 1) == 0) {
                    int subdirx = branch_side;
                    int subdirz = 0;
                    if (dirx != 0) {
                        subdirx = 0;
                        subdirz = branch_side;
                    }
                    this.make_branch(world, x + xaccum + current_width * subdirx, y, z + zaccum + current_width * subdirz, current_width - 1, subdirx, subdirz, ID, leafID, tree_type, t_radius, bad_critters, chunk);
                    last_branch = 0;
                    branch_side = branch_side < 0 ? 1 : -1;
                }
                xaccum += dirx;
                zaccum += dirz;
                ++last_branch;
            }
            --current_width;
        }
    }

    public void MakeBigSquareTree(World world, int x, int y, int z, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
        int i;
        int j;
        int this_height = t_radius + this.rand.nextInt(t_radius);
        int this_width = t_radius;
        int base_height = t_radius * 3;
        int spiral = 0;
        int current_y = 0;
        boolean branch = false;
        boolean do_floor = false;
        int platform_looper = 1;
        int last = -1;
        int last_last = -1;
        block6 : for (i = - t_radius; i <= t_radius; ++i) {
            if (this.isBoringBaseBlock(world, x + i, y, z - t_radius).booleanValue()) {
                for (j = 0; j < 20; ++j) {
                    if (y - j <= 0) continue;
                    if (!this.isBoringBaseBlock(world, x + i, y - j, z - t_radius).booleanValue()) break;
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x + i, y - j, z - t_radius, ID, tree_type, 2, chunk);
                        continue;
                    }
                    this.FastSetBlock(world, x + i, y - j, z - t_radius, ID, 0, 2, chunk);
                }
            }
            if (this.isBoringBaseBlock(world, x + i, y, z + t_radius).booleanValue()) {
                for (j = 0; j < 20; ++j) {
                    if (y - j <= 0) continue;
                    if (!this.isBoringBaseBlock(world, x + i, y - j, z + t_radius).booleanValue()) break;
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x + i, y - j, z + t_radius, ID, tree_type, 2, chunk);
                        continue;
                    }
                    this.FastSetBlock(world, x + i, y - j, z + t_radius, ID, 0, 2, chunk);
                }
            }
            if (this.isBoringBaseBlock(world, x - t_radius, y, z + i).booleanValue()) {
                for (j = 0; j < 20; ++j) {
                    if (y - j <= 0) continue;
                    if (!this.isBoringBaseBlock(world, x - t_radius, y - j, z + i).booleanValue()) break;
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x - t_radius, y - j, z + i, ID, tree_type, 2, chunk);
                        continue;
                    }
                    this.FastSetBlock(world, x - t_radius, y - j, z + i, ID, 0, 2, chunk);
                }
            }
            if (!this.isBoringBaseBlock(world, x + t_radius, y, z + i).booleanValue()) continue;
            for (j = 0; j < 20; ++j) {
                if (y - j <= 0) continue;
                if (!this.isBoringBaseBlock(world, x + t_radius, y - j, z + i).booleanValue()) continue block6;
                if (tree_type >= 0) {
                    this.FastSetBlock(world, x + t_radius, y - j, z + i, ID, tree_type, 2, chunk);
                    continue;
                }
                this.FastSetBlock(world, x + t_radius, y - j, z + i, ID, 0, 2, chunk);
            }
        }
        current_y = y;
        do_floor = false;
        spiral = - this_width;
        while (this_width >= 0) {
            if (this_width != t_radius) {
                base_height = 0;
            }
            for (j = 0; j < this_height + base_height; ++j) {
                do_floor = false;
                for (i = - this_width; i <= this_width; ++i) {
                    if (this.isBoringBaseBlock(world, x + i, current_y, z - this_width).booleanValue()) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, current_y, z - this_width, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, current_y, z - this_width, ID, 0, 2, chunk);
                        }
                    }
                    if (this.isBoringBaseBlock(world, x + i, current_y, z + this_width).booleanValue()) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, current_y, z + this_width, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, current_y, z + this_width, ID, 0, 2, chunk);
                        }
                    }
                    if (this.isBoringBaseBlock(world, x - this_width, current_y, z + i).booleanValue()) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x - this_width, current_y, z + i, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x - this_width, current_y, z + i, ID, 0, 2, chunk);
                        }
                    }
                    if (!this.isBoringBaseBlock(world, x + this_width, current_y, z + i).booleanValue()) continue;
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x + this_width, current_y, z + i, ID, tree_type, 2, chunk);
                        continue;
                    }
                    this.FastSetBlock(world, x + this_width, current_y, z + i, ID, 0, 2, chunk);
                }
                if (this_width != 0 || j < this_height / 2) {
                    platform_looper = 1;
                    if (spiral == 0 && this_width >= 2 || spiral == this_width || spiral == this_width - 1 && j == this_height + base_height - 1) {
                        ++platform_looper;
                        if (spiral != 0 && this_width >= 3) {
                            ++platform_looper;
                        }
                        if (spiral == 0) {
                            do_floor = true;
                        }
                    }
                    for (int k = 0; k < platform_looper; ++k) {
                        if (this.isBoringBlock(world, x - spiral, current_y, z - this_width - 1).booleanValue()) {
                            this.FastSetBlock(world, x - spiral, current_y, z - this_width - 1, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x + spiral, current_y, z + this_width + 1).booleanValue()) {
                            this.FastSetBlock(world, x + spiral, current_y, z + this_width + 1, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x - this_width - 1, current_y, z + spiral).booleanValue()) {
                            this.FastSetBlock(world, x - this_width - 1, current_y, z + spiral, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x + this_width + 1, current_y, z - spiral).booleanValue()) {
                            this.FastSetBlock(world, x + this_width + 1, current_y, z - spiral, stepID, 0, 2, chunk);
                        }
                        if (this_width >= 3) {
                            if (this.isBoringBlock(world, x - spiral, current_y, z - this_width - 2).booleanValue()) {
                                this.FastSetBlock(world, x - spiral, current_y, z - this_width - 2, stepID, 0, 2, chunk);
                            }
                            if (this.isBoringBlock(world, x + spiral, current_y, z + this_width + 2).booleanValue()) {
                                this.FastSetBlock(world, x + spiral, current_y, z + this_width + 2, stepID, 0, 2, chunk);
                            }
                            if (this.isBoringBlock(world, x - this_width - 2, current_y, z + spiral).booleanValue()) {
                                this.FastSetBlock(world, x - this_width - 2, current_y, z + spiral, stepID, 0, 2, chunk);
                            }
                            if (this.isBoringBlock(world, x + this_width + 2, current_y, z - spiral).booleanValue()) {
                                this.FastSetBlock(world, x + this_width + 2, current_y, z - spiral, stepID, 0, 2, chunk);
                            }
                        }
                        if (platform_looper == 1) continue;
                        ++spiral;
                    }
                    if (do_floor) {
                        for (int m = - this_width; m <= this_width; ++m) {
                            for (int n = - this_width; n <= this_width; ++n) {
                                if (!this.isBoringBlock(world, x + m, current_y, z + n).booleanValue()) continue;
                                if (tree_type >= 0) {
                                    this.FastSetBlock(world, x + m, current_y, z + n, ID, tree_type, 2, chunk);
                                } else {
                                    this.FastSetBlock(world, x + m, current_y, z + n, ID, 0, 2, chunk);
                                }
                                if (m != 0 || n != 0 || this.rand.nextInt(2) != 0 || bad_critters || !world.isAirBlock(x, current_y + 1, z)) continue;
                                this.FastSetBlock(world, x, current_y + 1, z, (Block)Blocks.chest, 0, 2, chunk);
                                TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, current_y + 1, z);
                                if (chest == null) continue;
                                WeightedRandomChestContent.generateChestContents((Random)this.rand, (WeightedRandomChestContent[])this.chestContentsList, (IInventory)chest, (int)(t_radius - this_width + this.rand.nextInt(10)));
                            }
                        }
                    }
                }
                if (this_width != t_radius) {
                    int next = this.rand.nextInt(4 + this_width);
                    while (next == last || next == last_last) {
                        next = this.rand.nextInt(4 + this_width);
                    }
                    if (next < 4) {
                        last_last = last;
                        last = next;
                    }
                    switch (next) {
                        case 0: {
                            this.make_branch(world, x + this_width, current_y, z, this_width, 1, 0, ID, leafID, tree_type, t_radius, bad_critters, chunk);
                            break;
                        }
                        case 1: {
                            this.make_branch(world, x - this_width, current_y, z, this_width, -1, 0, ID, leafID, tree_type, t_radius, bad_critters, chunk);
                            break;
                        }
                        case 2: {
                            this.make_branch(world, x, current_y, z + this_width, this_width, 0, 1, ID, leafID, tree_type, t_radius, bad_critters, chunk);
                            break;
                        }
                        case 3: {
                            this.make_branch(world, x, current_y, z - this_width, this_width, 0, -1, ID, leafID, tree_type, t_radius, bad_critters, chunk);
                            break;
                        }
                    }
                }
                ++current_y;
                if (!do_floor) {
                    ++spiral;
                }
                if (spiral <= this_width) continue;
                spiral = - this_width;
            }
            if (Math.abs(spiral) > --this_width) {
                spiral = - this_width;
            }
            this_height += this.rand.nextInt(t_radius);
        }
        if (this.isBoringBaseBlock(world, x, current_y, z).booleanValue()) {
            Entity var8;
            this.FastSetBlock(world, x, current_y, z, Blocks.emerald_block, 0, 2, chunk);
            this.FastSetBlock(world, x, current_y + 1, z, Blocks.emerald_block, 0, 2, chunk);
            if (stepID == Blocks.diamond_block) {
                var8 = null;
                var8 = EntityList.createEntityByName((String)"The King", (World)world);
                if (var8 != null) {
                    var8.setLocationAndAngles((double)x, (double)(current_y + 4), (double)z, world.rand.nextFloat() * 360.0f, 0.0f);
                    world.spawnEntityInWorld(var8);
                    ((EntityLiving)var8).playLivingSound();
                    ((TheKing)var8).setGuardMode(1);
                }
            }
            if (stepID == OreSpawnMain.MyBlockAmethystBlock) {
                var8 = null;
                var8 = EntityList.createEntityByName((String)"The Queen", (World)world);
                if (var8 != null) {
                    var8.setLocationAndAngles((double)x, (double)(current_y + 4), (double)z, world.rand.nextFloat() * 360.0f, 0.0f);
                    world.spawnEntityInWorld(var8);
                    ((EntityLiving)var8).playLivingSound();
                    ((TheQueen)var8).setGuardMode(1);
                    ((TheQueen)var8).setBadMood(1);
                }
            }
        }
    }

    private void MakeCirclularBranch(World world, int iangle, int branchlen, int width, int startx, int starty, int startz, int twist, Block ID, Block leafID, int tree_type, Chunk chunk) {
        double curlen = 0.0;
        int curangle = iangle;
        double curx = startx;
        double curz = startz;
        for (curlen = 0.0; curlen < (double)branchlen; curlen += 0.5) {
            curx += 0.5 * Math.sin(Math.toRadians(curangle));
            curz += 0.5 * Math.cos(Math.toRadians(curangle));
            double tw = (double)width - (double)width * curlen / (double)branchlen;
            for (double wd = 0.0; wd <= tw; wd += 0.5) {
                int ta;
                double wz;
                double wx;
                Block id = leafID;
                if (wd < tw / 2.0) {
                    id = ID;
                }
                if (tw < 0.9) {
                    id = leafID;
                }
                if ((ta = curangle + 90) > 360) {
                    ta -= 360;
                }
                if (this.isBoringBlock(world, (int)(wx = curx + wd * Math.sin(Math.toRadians(ta))), starty, (int)(wz = curz + wd * Math.cos(Math.toRadians(ta)))).booleanValue()) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int)wx, starty, (int)wz, id, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int)wx, starty, (int)wz, id, 0, 2, chunk);
                    }
                }
                if (id == ID && this.isBoringBlock(world, (int)wx, starty + 1, (int)wz).booleanValue()) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, 0, 2, chunk);
                    }
                }
                if ((ta = curangle - 90) < 0) {
                    ta += 360;
                }
                if (this.isBoringBlock(world, (int)(wx = curx + wd * Math.sin(Math.toRadians(ta))), starty, (int)(wz = curz + wd * Math.cos(Math.toRadians(ta)))).booleanValue()) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int)wx, starty, (int)wz, id, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int)wx, starty, (int)wz, id, 0, 2, chunk);
                    }
                }
                if (id != ID || !this.isBoringBlock(world, (int)wx, starty + 1, (int)wz).booleanValue()) continue;
                if (tree_type >= 0) {
                    this.FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, tree_type, 2, chunk);
                    continue;
                }
                this.FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, 0, 2, chunk);
            }
            if ((curangle += twist) < 0) {
                curangle += 360;
            }
            if (curangle < 360) continue;
            curangle -= 360;
        }
    }

    public void MakeBigCircularTree(World world, int x, int y, int z, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
        int i;
        double dt;
        double rad = t_radius;
        int curx = 0;
        int cury = 0;
        int curz = 0;
        int stepindex = this.rand.nextInt(360);
        int ibranch = 0;
        cury = y;
        block0 : for (i = 0; i < 360; ++i) {
            dt = rad * Math.sin(Math.toRadians(i)) + 0.5;
            curx = (int)dt;
            dt = rad * Math.cos(Math.toRadians(i)) + 0.5;
            curz = (int)dt;
            if (!this.isBoringBaseBlock(world, x + curx, cury, z + curz).booleanValue()) continue;
            for (int j = 0; j < 20; ++j) {
                if (cury - j <= 0) continue;
                if (!this.isBoringBaseBlock(world, x + curx, cury - j, z + curz).booleanValue()) continue block0;
                if (tree_type >= 0) {
                    this.FastSetBlock(world, x + curx, cury - j, z + curz, ID, tree_type, 2, chunk);
                    continue;
                }
                this.FastSetBlock(world, x + curx, cury - j, z + curz, ID, 0, 2, chunk);
            }
        }
        cury = 1;
        while (rad > 0.0) {
            for (i = 0; i < 360; ++i) {
                dt = rad * Math.sin(Math.toRadians(i)) + 0.5;
                curx = (int)dt;
                dt = rad * Math.cos(Math.toRadians(i)) + 0.5;
                curz = (int)dt;
                if (this.isBoringBaseBlock(world, x + curx, y + cury, z + curz).booleanValue()) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
                    }
                }
                if (i < stepindex - 1 || i > stepindex + 1 || rad <= 1.0) continue;
                dt = (rad + 1.9) * Math.sin(Math.toRadians(i)) + 0.5;
                curx = (int)dt;
                dt = (rad + 1.9) * Math.cos(Math.toRadians(i)) + 0.5;
                curz = (int)dt;
                for (int m = -1; m <= 1; ++m) {
                    for (int n = -1; n <= 1; ++n) {
                        if (!this.isBoringBaseBlock(world, x + curx + m, y + cury, z + curz + n).booleanValue()) continue;
                        this.FastSetBlock(world, x + curx + m, y + cury, z + curz + n, stepID, 0, 2, chunk);
                    }
                }
            }
            if (cury > (int)rad) {
                if ((ibranch += 80 + this.rand.nextInt(80)) > 360) {
                    ibranch -= 360;
                }
                int ibranchlen = (int)(rad * 5.0) + this.rand.nextInt((int)rad + 2);
                dt = rad * Math.sin(Math.toRadians(ibranch)) + 0.5;
                curx = (int)dt;
                dt = rad * Math.cos(Math.toRadians(ibranch)) + 0.5;
                curz = (int)dt;
                this.MakeCirclularBranch(world, ibranch, ibranchlen, (int)rad + 1, x + curx, y + cury, z + curz, this.rand.nextInt(2) * (this.rand.nextInt(2) == 0 ? -1 : 1), ID, leafID, tree_type, chunk);
            }
            if (cury % 6 == 0 && rad > 3.0) {
                for (double dr = rad - 0.25; dr > 0.0; dr -= 0.25) {
                    for (i = 0; i < 360; ++i) {
                        dt = dr * Math.sin(Math.toRadians(i)) + 0.5;
                        curx = (int)dt;
                        dt = dr * Math.cos(Math.toRadians(i)) + 0.5;
                        curz = (int)dt;
                        if (!this.isBoringBaseBlock(world, x + curx, y + cury, z + curz).booleanValue()) continue;
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
                            continue;
                        }
                        this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
                    }
                }
                if (this.rand.nextInt(2) == 0 && !bad_critters && world.isAirBlock(x, y + cury + 1, z)) {
                    this.FastSetBlock(world, x, y + cury + 1, z, (Block)Blocks.chest, 0, 2, chunk);
                    TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y + cury + 1, z);
                    if (chest != null) {
                        WeightedRandomChestContent.generateChestContents((Random)this.rand, (WeightedRandomChestContent[])this.chestContentsList, (IInventory)chest, (int)(t_radius - (int)rad + this.rand.nextInt(10)));
                    }
                }
            }
            if ((stepindex += 15 + (int)(((double)t_radius - rad) * 3.0)) > 360) {
                stepindex -= 360;
            }
            if ((rad -= 0.01 * (double)this.rand.nextInt(15)) > 0.0 || !this.isBoringBaseBlock(world, x, y + ++cury, z).booleanValue()) continue;
            this.FastSetBlock(world, x, y + cury, z, Blocks.diamond_block, 0, 2, chunk);
        }
    }

    public void MakeBigRoundTree(World world, int inx, int y, int inz, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, Chunk chunk) {
        int i;
        double dt;
        float fcurx;
        float fcurz;
        double rad = t_radius;
        int cury = 0;
        int ibranch = 0;
        float fx = inx;
        fx += 0.5f;
        float fz = inz;
        fz += 0.5f;
        cury = y;
        block0 : for (i = 0; i < 360; ++i) {
            dt = rad * Math.sin(Math.toRadians(i));
            fcurx = (float)dt;
            dt = rad * Math.cos(Math.toRadians(i));
            fcurz = (float)dt;
            if (!this.isBoringBaseBlock(world, (int)(fx + fcurx), cury, (int)(fz + fcurz)).booleanValue()) continue;
            for (int j = 0; j < 20; ++j) {
                if (cury - j <= 0) continue;
                if (!this.isBoringBaseBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz)).booleanValue()) continue block0;
                if (tree_type >= 0) {
                    this.FastSetBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz), ID, tree_type, 2, chunk);
                    continue;
                }
                this.FastSetBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz), ID, 0, 2, chunk);
            }
        }
        cury = 1;
        while (rad > 0.0) {
            for (i = 0; i < 360; ++i) {
                dt = rad * Math.sin(Math.toRadians(i));
                fcurx = (float)dt;
                dt = rad * Math.cos(Math.toRadians(i));
                fcurz = (float)dt;
                if (!this.isBoringBaseBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz)).booleanValue()) continue;
                if (tree_type >= 0) {
                    this.FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, tree_type, 2, chunk);
                    continue;
                }
                this.FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, 0, 2, chunk);
            }
            if (cury > (int)rad) {
                if ((ibranch += 80 + world.rand.nextInt(80)) > 360) {
                    ibranch -= 360;
                }
                int ibranchlen = (int)(rad * 5.0) + world.rand.nextInt((int)rad + 2);
                dt = rad * Math.sin(Math.toRadians(ibranch));
                fcurx = (float)dt;
                dt = rad * Math.cos(Math.toRadians(ibranch));
                fcurz = (float)dt;
                this.MakeRoundBranch(world, ibranch, ibranchlen, (int)rad + 1, fx + fcurx, y + cury, fz + fcurz, ID, leafID, tree_type, chunk);
            }
            if (cury % 6 == 0 && rad > 3.0) {
                for (double dr = rad - 0.25; dr > 0.0; dr -= 0.25) {
                    for (i = 0; i < 360; ++i) {
                        dt = dr * Math.sin(Math.toRadians(i));
                        fcurx = (float)dt;
                        dt = dr * Math.cos(Math.toRadians(i));
                        fcurz = (float)dt;
                        if (!this.isBoringBaseBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz)).booleanValue()) continue;
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, tree_type, 2, chunk);
                            continue;
                        }
                        this.FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, 0, 2, chunk);
                    }
                }
            }
            if ((rad -= 0.01 * (double)world.rand.nextInt(15)) > 0.0 || !this.isBoringBaseBlock(world, (int)fx, y + ++cury, (int)fz).booleanValue()) continue;
            this.FastSetBlock(world, (int)fx, y + cury, (int)fz, Blocks.diamond_block, 0, 2, chunk);
        }
    }

    private void MakeRoundBranch(World world, int iangle, int branchlen, int width, float startx, int starty, float startz, Block ID, Block leafID, int tree_type, Chunk chunk) {
        double deltadir = 0.06283185200000001;
        double deltamag = 0.3499999940395355;
        int ixlast = 0;
        int izlast = 0;
        boolean xoff = false;
        boolean zoff = false;
        int radius = branchlen / 2;
        float centerx = (float)((double)startx + (double)radius * Math.sin(Math.toRadians(iangle)));
        float centerz = (float)((double)startz + (double)radius * Math.cos(Math.toRadians(iangle)));
        izlast = 0;
        ixlast = 0;
        for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
            for (double h = 0.75; h < (double)radius; h += deltamag) {
                int ix = (int)((double)centerx + Math.cos(curdir) * h);
                int iz = (int)((double)centerz + Math.sin(curdir) * h);
                if (ix == ixlast && iz == izlast) continue;
                ixlast = ix;
                izlast = iz;
                Block id = ID;
                if ((double)radius - h < 2.0) {
                    id = leafID;
                }
                if (!this.isBoringBlock(world, ix, starty, iz).booleanValue()) continue;
                this.FastSetBlock(world, ix, starty, iz, id, tree_type, 2, chunk);
            }
        }
    }

    public void FastSetBlock(World world, int ix, int iy, int iz, Block id, int im, int iflg, Chunk chunk) {
        OreSpawnMain.setBlockSuperFast((World)world, (int)ix, (int)iy, (int)iz, (Block)id, (int)im, (int)2, (Chunk)chunk);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int clickedX, int clickedY, int clickedZ, int par7, float par8, float par9, float par10)
    {
      Block var1 = world.getBlock(clickedX, clickedY, clickedZ);
      if ((var1 != Blocks.grass) && (var1 != Blocks.farmland) && (var1 != Blocks.dirt)) {
        return false;
      }

      int tree_type = this.rand.nextInt(4);

      Block leaf_type = Blocks.leaves;

      this.no_critters = true;
      if (this.rand.nextInt(2) == 1) this.no_critters = false;

      if (!world.isRemote) {
        world.setBlock(clickedX, clickedY, clickedZ, Blocks.gold_block, 0, 2);
      }
      for (int var3 = 0; var3 < 6; var3++)
      {
        par2EntityPlayer.worldObj.spawnParticle("largesmoke", clickedX + 0.5F, clickedY + 1 + 0.25F, clickedZ + 0.5F, 0.0D, 0.0D, 0.0D);
        par2EntityPlayer.worldObj.spawnParticle("largeexplode", clickedX + 0.5F, clickedY + 1 + 0.25F, clickedZ + 0.5F, 0.0D, 0.0D, 0.0D);
        par2EntityPlayer.worldObj.spawnParticle("reddust", clickedX + 0.5F, clickedY + 1 + 0.25F, clickedZ + 0.5F, 0.0D, 0.0D, 0.0D);
      }

      par2EntityPlayer.worldObj.playSoundAtEntity(par2EntityPlayer, "random.explode", 2.8F, 1.5F);

      if (!world.isRemote)
      {
        int rand_treetype = this.rand.nextInt(100);

        if (rand_treetype >= 20) {
          if (rand_treetype >= 40) {
            if ((tree_type != 3) && (this.rand.nextInt(10) == 1)) leaf_type = OreSpawnMain.MyAppleLeaves;
            MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.log, leaf_type, Blocks.mossy_cobblestone, tree_type, this.tree_radius, this.no_critters, null);
          } else {
            MakeBigRoundTree(world, clickedX, clickedY, clickedZ, Blocks.log, leaf_type, Blocks.mossy_cobblestone, tree_type, this.tree_radius, null);
          }
        } else if (rand_treetype == 1) {
          if (OreSpawnMain.GinormousEmeraldTreeEnable != 0) {
            if (this.rand.nextInt(2) == 0)
              MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.gold_block, Blocks.emerald_block, Blocks.diamond_block, -1, this.tree_radius, true, null);
            else
              MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.obsidian, OreSpawnMain.MyBlockRubyBlock, OreSpawnMain.MyBlockAmethystBlock, -1, this.tree_radius, true, null);
          }
          else
            MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.log, leaf_type, Blocks.iron_ore, tree_type, this.tree_radius, this.no_critters, null);
        }
        else {
          MakeBigCircularTree(world, clickedX, clickedY, clickedZ, Blocks.log, leaf_type, Blocks.mossy_cobblestone, tree_type, this.tree_radius, this.no_critters, null);
        }
      }

      if (!par2EntityPlayer.capabilities.isCreativeMode)
      {
        par1ItemStack.stackSize -= 1;
      }

      return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

