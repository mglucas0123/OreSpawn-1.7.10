/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.BasiliskMaze
 *  danger.orespawn.DungeonSpawnerBlock
 *  danger.orespawn.GenericDungeon
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RubyBirdDungeon
 *  danger.orespawn.Trees
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockReed
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.BasiliskMaze;
import danger.orespawn.GenericDungeon;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RubyBirdDungeon;
import danger.orespawn.Trees;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class DungeonSpawnerBlock
extends BlockReed {
    protected DungeonSpawnerBlock(int par1) {
        float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        if (par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid()) {
            return true;
        }
        return false;
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        for (int j1 = 0; j1 < 5; ++j1) {
            par1World.spawnParticle("fireworksSpark", (double)((float)par2 + par1World.rand.nextFloat()), (double)par3 + (double)par1World.rand.nextFloat(), (double)((float)par4 + par1World.rand.nextFloat()), (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0, (double)par1World.rand.nextFloat() / 2.0, (double)(par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0);
        }
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        if (world.isRemote) {
            return;
        }
        world.scheduleBlockUpdate(x, y, z, (Block)this, 400);
    }

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    public void updateTick(World world, int clickedX, int clickedY, int clickedZ, Random par5Random) {
        if (world.isRemote) {
            return;
        }
        world.setBlock(clickedX, clickedY, clickedZ, Blocks.air, 0, 2);
        world.setBlock(clickedX, clickedY + 1, clickedZ, Blocks.air, 0, 2);
        int type = world.rand.nextInt(50);
        if (type == 0) {
            OreSpawnMain.OreSpawnTrees.FairyTree(world, clickedX, clickedY, clickedZ);
        }
        if (type == 1) {
            OreSpawnMain.OreSpawnTrees.FairyCastleTree(world, clickedX, clickedY, clickedZ);
        }
        if (type == 2) {
            OreSpawnMain.MyDungeon.makeEnormousCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 3) {
            OreSpawnMain.MyDungeon.makeRotatorStation(world, clickedX, clickedY, clickedZ);
        }
        if (type == 4) {
            OreSpawnMain.MyDungeon.makeBeeHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 5) {
            OreSpawnMain.MyDungeon.makeHauntedHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 6) {
            OreSpawnMain.MyDungeon.makeMantisHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 7) {
            OreSpawnMain.MyDungeon.makeKyuubiDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 8) {
            OreSpawnMain.MyDungeon.makeSmallBeeHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 9) {
            OreSpawnMain.MyDungeon.makeShadowDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 10) {
            OreSpawnMain.MyDungeon.makeAlienWTFDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 11) {
            OreSpawnMain.MyDungeon.makeEnderKnightDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 12) {
            OreSpawnMain.MyDungeon.makePlayPool(world, clickedX, clickedY, clickedZ);
        }
        if (type == 13) {
            OreSpawnMain.MyDungeon.makeWaterDragonLair(world, clickedX, clickedY, clickedZ);
        }
        if (type == 14) {
            OreSpawnMain.MyDungeon.makeCloudSharkDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 15) {
            OreSpawnMain.MyDungeon.makeLeafMonsterDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 16) {
            OreSpawnMain.MyDungeon.makeMiniDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 17) {
            OreSpawnMain.MyDungeon.makeGoldFishBowl(world, clickedX, clickedY, clickedZ);
        }
        if (type == 18) {
            OreSpawnMain.MyDungeon.makeEnderReaperGraveyard(world, clickedX, clickedY, clickedZ);
        }
        if (type == 19) {
            OreSpawnMain.MyDungeon.makeSpitBugLair(world, clickedX, clickedY, clickedZ);
        }
        if (type == 20) {
            OreSpawnMain.MyDungeon.makeIgloo(world, clickedX, clickedY, clickedZ);
        }
        if (type == 21) {
            OreSpawnMain.MyDungeon.makeDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 22) {
            OreSpawnMain.RubyDungeon.makeDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 23) {
            OreSpawnMain.BMaze.buildBasiliskMaze(world, clickedX, clickedY, clickedZ);
        }
        if (type == 24) {
            OreSpawnMain.MyDungeon.makeEnderDragonHospital(world, clickedX, clickedY, clickedZ);
        }
        if (type == 25) {
            OreSpawnMain.MyDungeon.makeCrystalHauntedHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 26) {
            OreSpawnMain.MyDungeon.makeBouncyCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 27) {
            OreSpawnMain.MyDungeon.makeEnderCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 28) {
            OreSpawnMain.MyDungeon.makeDamselInDistress(world, clickedX, clickedY, clickedZ);
        }
        if (type == 29) {
            OreSpawnMain.MyDungeon.makeIncaPyramid(world, clickedX, clickedY, clickedZ);
        }
        if (type == 30) {
            OreSpawnMain.MyDungeon.makeRobotLab(world, clickedX, clickedY, clickedZ);
        }
        if (type == 31) {
            OreSpawnMain.MyDungeon.makeKingAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 32) {
            OreSpawnMain.MyDungeon.makeLeonNest(world, clickedX, clickedY, clickedZ);
        }
        if (type == 33) {
            OreSpawnMain.MyDungeon.makeCrystalBattleTower(world, clickedX, clickedY, clickedZ);
        }
        if (type == 34) {
            OreSpawnMain.MyDungeon.makeCephadromeAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 35) {
            OreSpawnMain.MyDungeon.makeGirlfriendIsland(world, clickedX, clickedY, clickedZ);
        }
        if (type == 36) {
            OreSpawnMain.MyDungeon.makeGreenhouseDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 37) {
            OreSpawnMain.MyDungeon.makeMonsterIsland(world, clickedX, clickedY, clickedZ);
        }
        if (type == 38) {
            OreSpawnMain.MyDungeon.makeNightmareRookery(world, clickedX, clickedY, clickedZ);
        }
        if (type == 39) {
            OreSpawnMain.MyDungeon.makeStinkyHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 40) {
            OreSpawnMain.MyDungeon.makeRubberDuckyPond(world, clickedX, clickedY, clickedZ);
        }
        if (type == 41) {
            OreSpawnMain.MyDungeon.makeWhiteHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 42) {
            OreSpawnMain.MyDungeon.makeQueenAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 43) {
            OreSpawnMain.MyDungeon.makeFrogPond(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 44) {
            OreSpawnMain.MyDungeon.makePumpkin(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 45) {
            OreSpawnMain.MyDungeon.makeRoundRotator(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 46) {
            OreSpawnMain.MyDungeon.makeRainbow(world, clickedX, clickedY, clickedZ);
        }
        if (type == 47) {
            OreSpawnMain.MyDungeon.makeEnormousCastleQ(world, clickedX, clickedY, clickedZ);
        }
        if (type == 48) {
            OreSpawnMain.MyDungeon.makeSpiderHangout(world, clickedX, clickedY, clickedZ);
        }
        if (type == 49) {
            OreSpawnMain.MyDungeon.makeRedAntHangout(world, clickedX, clickedY, clickedZ);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return OreSpawnMain.RandomDungeon;
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return OreSpawnMain.RandomDungeon;
    }

    public int quantityDropped(Random par1Random) {
        return 1;
    }

    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

