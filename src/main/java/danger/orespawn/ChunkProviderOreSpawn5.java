/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ChunkProviderOreSpawn5
 *  danger.orespawn.CrystalMaze
 *  danger.orespawn.OreGenericEgg
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFalling
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.IProgressUpdate
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.ChunkPosition
 *  net.minecraft.world.SpawnerAnimals
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldType
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.WorldChunkManager
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.NoiseGenerator
 *  net.minecraft.world.gen.NoiseGeneratorOctaves
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.event.terraingen.TerrainGen
 */
package danger.orespawn;

import danger.orespawn.CrystalMaze;
import danger.orespawn.OreGenericEgg;
import danger.orespawn.OreSpawnMain;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderOreSpawn5
implements IChunkProvider {
    private Random rand;
    private NoiseGeneratorOctaves field_147431_j;
    private NoiseGeneratorOctaves field_147432_k;
    private NoiseGeneratorOctaves field_147429_l;
    private NoiseGeneratorPerlin field_147430_m;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private WorldType field_147435_p;
    private final double[] field_147434_q;
    private final float[] parabolicField;
    private double[] stoneNoise = new double[256];
    private BiomeGenBase[] biomesForGeneration;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j = new int[32][32];

    public ChunkProviderOreSpawn5(World par1World, long par2, boolean par4) {
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.field_147435_p = par1World.getWorldInfo().getTerrainType();
        this.rand = new Random(par2);
        this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147434_q = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                float f;
                this.parabolicField[j + 2 + (k + 2) * 5] = f = 10.0f / MathHelper.sqrt_float((float)((float)(j * j + k * k) + 0.2f));
            }
        }
        NoiseGenerator[] noiseGens = new NoiseGenerator[]{this.field_147431_j, this.field_147432_k, this.field_147429_l, this.field_147430_m, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise};
        noiseGens = TerrainGen.getModdedNoiseGenerators((World)par1World, (Random)this.rand, (NoiseGenerator[])noiseGens);
        this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
        this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
        this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
        this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
    }

    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
        int b0 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
        this.func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
        for (int k = 0; k < 4; ++k) {
            int l = k * 5;
            int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;
                for (int k2 = 0; k2 < 32; ++k2) {
                    double d0 = 0.125;
                    double d1 = this.field_147434_q[k1 + k2];
                    double d2 = this.field_147434_q[l1 + k2];
                    double d3 = this.field_147434_q[i2 + k2];
                    double d4 = this.field_147434_q[j2 + k2];
                    double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
                    for (int l2 = 0; l2 < 8; ++l2) {
                        double d9 = 0.25;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                            int short1 = 256;
                            j3 -= short1;
                            double d14 = 0.25;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;
                            for (int k3 = 0; k3 < 4; ++k3) {
                                p_147424_3_[j3 += short1] = (d15 += d16) > 0.0 ? OreSpawnMain.CrystalStone : (k2 * 8 + l2 < b0 ? Blocks.water : null);
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_) {
        double d0 = 0.03125;
        this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, (double)(p_147422_1_ * 16), (double)(p_147422_2_ * 16), 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                this.MygenTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
            }
        }
    }

    private void MygenTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
        this.MygenBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }

    private final void MygenBiomeTerrain(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_) {
        boolean flag = true;
        Block block = OreSpawnMain.CrystalGrass;
        byte b0 = 0;
        Block block1 = OreSpawnMain.CrystalStone;
        int k = -1;
        int l = (int)(p_150560_7_ / 3.0 + 3.0 + p_150560_2_.nextDouble() * 0.25);
        int i1 = p_150560_5_ & 15;
        int j1 = p_150560_6_ & 15;
        int k1 = p_150560_3_.length / 256;
        for (int l1 = 255; l1 >= 0; --l1) {
            int i2 = (j1 * 16 + i1) * k1 + l1;
            if (l1 <= 0 + p_150560_2_.nextInt(5)) {
                p_150560_3_[i2] = Blocks.bedrock;
                continue;
            }
            Block block2 = p_150560_3_[i2];
            if (block2 != null && block2.getMaterial() != Material.air) {
                if (block2 != OreSpawnMain.CrystalStone) continue;
                if (k == -1) {
                    if (l <= 0) {
                        block = null;
                        b0 = 0;
                        block1 = OreSpawnMain.CrystalStone;
                    } else if (l1 >= 59 && l1 <= 64) {
                        block = OreSpawnMain.CrystalGrass;
                        b0 = 0;
                        block1 = OreSpawnMain.CrystalStone;
                    }
                    if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
                        block = Blocks.water;
                        b0 = 0;
                    }
                    k = l;
                    if (l1 >= 62) {
                        p_150560_3_[i2] = block;
                        p_150560_4_[i2] = b0;
                        continue;
                    }
                    p_150560_3_[i2] = block1;
                    continue;
                }
                if (k <= 0) continue;
                --k;
                p_150560_3_[i2] = block1;
                continue;
            }
            k = -1;
        }
    }

    public Chunk loadChunk(int par1, int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(int par1, int par2) {
        this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
        Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        CrystalMaze cm = new CrystalMaze();
        cm.buildCrystalMaze(this.worldObj, par1 * 16, 25, par2 * 16, chunk);
        this.generateCrystals(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addCrystalTrees(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.generateCrystalOres(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addCrystalFlowers(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addRice(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addQuinoa(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        chunk.generateSkylightMap();
        return chunk;
    }

    private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
        double d0 = 684.412;
        double d1 = 684.412;
        double d2 = 512.0;
        double d3 = 512.0;
        this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0, 200.0, 0.5);
        this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        boolean flag1 = false;
        boolean flag = false;
        int l = 0;
        int i1 = 0;
        double d4 = 8.5;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f1 = 0.0f;
                float f2 = 0.0f;
                int b0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l1 = - b0; l1 <= b0; ++l1) {
                    for (int i2 = - b0; i2 <= b0; ++i2) {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                        float f3 = biomegenbase1.rootHeight;
                        float f4 = biomegenbase1.heightVariation;
                        if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0f) {
                            f3 = 1.0f + f3 * 2.0f;
                            f4 = 1.0f + f4 * 4.0f;
                        }
                        float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0f);
                        if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
                            f5 /= 2.0f;
                        }
                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;
                    }
                }
                f /= f2;
                f1 /= f2;
                f = f * 0.9f + 0.1f;
                f1 = (f1 * 4.0f - 1.0f) / 8.0f;
                double d13 = this.field_147426_g[i1] / 8000.0;
                if (d13 < 0.0) {
                    d13 = (- d13) * 0.3;
                }
                if ((d13 = d13 * 3.0 - 2.0) < 0.0) {
                    if ((d13 /= 2.0) < -1.0) {
                        d13 = -1.0;
                    }
                    d13 /= 1.4;
                    d13 /= 2.0;
                } else {
                    if (d13 > 1.0) {
                        d13 = 1.0;
                    }
                    d13 /= 8.0;
                }
                ++i1;
                double d12 = f1;
                double d14 = f;
                d12 += d13 * 0.2;
                d12 = d12 * 8.5 / 8.0;
                double d5 = 8.5 + d12 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d6 = ((double)j2 - d5) * 12.0 * 128.0 / 256.0 / d14;
                    if (d6 < 0.0) {
                        d6 *= 4.0;
                    }
                    double d7 = this.field_147428_e[l] / 512.0;
                    double d8 = this.field_147425_f[l] / 512.0;
                    double d9 = (this.field_147427_d[l] / 10.0 + 1.0) / 2.0;
                    double d10 = MathHelper.denormalizeClamp((double)d7, (double)d8, (double)d9) - d6;
                    if (j2 > 29) {
                        double d11 = (float)(j2 - 29) / 3.0f;
                        d10 = d10 * (1.0 - d11) + -10.0 * d11;
                    }
                    this.field_147434_q[l] = d10;
                    ++l;
                }
            }
        }
    }

    public boolean chunkExists(int par1, int par2) {
        return true;
    }

    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
        BlockFalling.fallInstantly = true;
        int k = par2 * 16;
        int l = par3 * 16;
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
        boolean flag = false;
        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        SpawnerAnimals.performWorldGenSpawning((World)this.worldObj, (BiomeGenBase)biomegenbase, (int)(k + 8), (int)(l + 8), (int)16, (int)16, (Random)this.rand);
        BlockFalling.fallInstantly = false;
    }

    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
        return true;
    }

    public void saveExtraData() {
    }

    public boolean unloadQueuedChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "CrystalDimension";
    }

    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return biomegenbase.getSpawnableList(par1EnumCreatureType);
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(int par1, int par2) {
    }

    public void generateCrystals(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        this.addPinkTourmaline(world, random, chunkX, chunkZ, chunk);
        this.addTigersEye(world, random, chunkX, chunkZ, chunk);
    }

    public void addPinkTourmaline(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(30) != 1) {
            return;
        }
        int randPosX = 3 + chunkX + random.nextInt(10);
        int randPosY = 30 + random.nextInt(5);
        int randPosZ = 3 + chunkZ + random.nextInt(10);
        int patchy = 1 + random.nextInt(10);
        for (int i = 0; i < patchy; ++i) {
            float dx = random.nextFloat() - random.nextFloat();
            float dz = random.nextFloat() - random.nextFloat();
            float dy = 0.5f + random.nextFloat() / 2.0f;
            int width = random.nextInt(2);
            int length = 1 + width * 3 + random.nextInt(15);
            float rx = randPosX;
            float ry = randPosY;
            float rz = randPosZ;
            for (int iy = 0; iy <= length; ++iy) {
                for (int ix = 0; ix <= width; ++ix) {
                    for (int iz = 0; iz <= width; ++iz) {
                        OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)((int)(rx + (float)ix)), (int)((int)ry), (int)((int)(rz + (float)iz)), (Block)OreSpawnMain.CrystalCrystal, (int)0);
                    }
                }
                ry += dy;
                rx += dx;
                rz += dz;
            }
        }
    }

    public void addTigersEye(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(30) != 1) {
            return;
        }
        int randPosX = 3 + chunkX + random.nextInt(10);
        int randPosY = 5 + random.nextInt(5);
        int randPosZ = 3 + chunkZ + random.nextInt(10);
        int patchy = 1 + random.nextInt(5);
        for (int i = 0; i < patchy; ++i) {
            float dx = random.nextFloat() - random.nextFloat();
            float dz = random.nextFloat() - random.nextFloat();
            float dy = 0.5f + random.nextFloat() / 2.0f;
            int width = 0;
            int length = width * 3 + random.nextInt(6);
            float rx = randPosX;
            float ry = randPosY;
            float rz = randPosZ;
            for (int iy = 0; iy <= length; ++iy) {
                for (int ix = 0; ix <= width; ++ix) {
                    for (int iz = 0; iz <= width; ++iz) {
                        OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)((int)(rx + (float)ix)), (int)((int)ry), (int)((int)(rz + (float)iz)), (Block)OreSpawnMain.TigersEye, (int)0);
                    }
                }
                ry += dy;
                rx += dx;
                rz += dz;
            }
        }
    }

    public void addCrystalTrees(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(5) != 0) {
            return;
        }
        int howmany = 0;
        int what = random.nextInt(5);
        howmany = random.nextInt(8);
        if (what != 0) {
            howmany *= 2;
        }
        block0 : for (int i = 0; i < howmany; ++i) {
            int posX = 4 + chunkX + random.nextInt(8);
            int posZ = 4 + chunkZ + random.nextInt(8);
            for (int posY = 128; posY > 40; --posY) {
                if (OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ) != Blocks.air || OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)(posY - 1), (int)posZ) != OreSpawnMain.CrystalGrass) continue;
                if (what == 0) {
                    this.TallCrystalTree(world, posX, posY, posZ, chunk);
                    continue block0;
                }
                this.ScragglyCrystalTreeWithBranches(world, posX, posY, posZ, chunk);
                continue block0;
            }
        }
    }

    public void makeScragglyCrystalBranch(World world, int x, int y, int z, int len, int biasx, int biasz, Chunk chunk) {
        for (int k = 0; k < len; ++k) {
            int iy;
            Block bid;
            int ix = world.rand.nextInt(2) - world.rand.nextInt(2) + biasx;
            int iz = world.rand.nextInt(2) - world.rand.nextInt(2) + biasz;
            if (ix > 1) {
                ix = 1;
            }
            if (ix < -1) {
                ix = -1;
            }
            if (iz > 1) {
                iz = 1;
            }
            if (iz < -1) {
                iz = -1;
            }
            if ((bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x += ix), (int)(y += (iy = world.rand.nextInt(3) > 0 ? 1 : 0)), (int)(z += iz))) != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n))) != Blocks.air) continue;
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves2, (int)0);
                }
            }
            if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)x, (int)(y + 1), (int)z)) != Blocks.air) continue;
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)(y + 1), (int)z, (Block)OreSpawnMain.MyCrystalLeaves2, (int)0);
        }
    }

    public void ScragglyCrystalTreeWithBranches(World world, int x, int y, int z, Chunk chunk) {
        int k;
        Block bid;
        int i = 1 + world.rand.nextInt(2);
        int j = i + world.rand.nextInt(8);
        for (k = 0; k < i; ++k) {
            bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)x, (int)(y + k), (int)z);
            if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)(y + k), (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
        }
        y += i - 1;
        for (k = i; k < j; ++k) {
            int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
            int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
            int iy = world.rand.nextInt(4) > 0 ? 1 : 0;
            bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x += ix), (int)(y += iy), (int)(z += iz));
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) break;
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyCrystalBranch(world, x, y, z, world.rand.nextInt(1 + j - k), world.rand.nextInt(2) - world.rand.nextInt(2), world.rand.nextInt(2) - world.rand.nextInt(2), chunk);
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n))) != Blocks.air) continue;
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves2, (int)0);
                }
            }
            if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)x, (int)(y + 1), (int)z)) != Blocks.air) continue;
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)(y + 1), (int)z, (Block)OreSpawnMain.MyCrystalLeaves2, (int)0);
        }
    }

    public void TallCrystalTree(World world, int x, int y, int z, Chunk chunk) {
        int m;
        Block bid;
        int n;
        int k;
        int i = 10 + world.rand.nextInt(12);
        if (OreSpawnMain.LessLag == 1) {
            i -= 2;
        }
        if (OreSpawnMain.LessLag == 2) {
            i -= 4;
        }
        int j = i + world.rand.nextInt(18 - OreSpawnMain.LessLag * 2);
        for (k = 0; k < i; ++k) {
            bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)x, (int)(y + k), (int)z);
            if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)(y + k), (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
        }
        y += i - 1;
        for (k = i; k < j && ((bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)x, (int)(++y), (int)z)) == Blocks.air || bid == OreSpawnMain.MyCrystalTreeLog || bid == OreSpawnMain.MyCrystalLeaves); ++k) {
            OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)x, (int)y, (int)z, (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
            if (k % 4 != 0) continue;
            for (m = -1; m < 2; ++m) {
                for (n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n))) != Blocks.air) continue;
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0);
                }
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                if (world.rand.nextInt(2) != 1 || (bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n))) != Blocks.air) continue;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalTreeLog, (int)0);
            }
        }
        for (m = -3; m < 4; ++m) {
            for (n = -3; n < 4; ++n) {
                bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n));
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0);
            }
        }
        ++y;
        for (m = -1; m < 2; ++m) {
            for (n = -1; n < 2; ++n) {
                bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n));
                if (bid != Blocks.air) continue;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)(x + m), (int)y, (int)(z + n), (Block)OreSpawnMain.MyCrystalLeaves, (int)0);
            }
        }
    }

    public void generateCrystalOres(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        int i;
        int randPosY;
        int randPosX;
        int randPosZ;
        int patchy = 25 + random.nextInt(30);
        if (random.nextInt(20) == 0) {
            patchy += 30;
        }
        for (i = 0; i < patchy; ++i) {
            randPosX = 2 + chunkX + random.nextInt(12);
            randPosY = random.nextInt(128);
            randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY <= 45) continue;
            int j = random.nextInt(11);
            Block b = Blocks.air;
            switch (j) {
                case 0: {
                    b = OreSpawnMain.MyUrchinSpawnBlock;
                    break;
                }
                case 1: {
                    b = OreSpawnMain.MyFlounderSpawnBlock;
                    break;
                }
                case 2: {
                    b = OreSpawnMain.MySkateSpawnBlock;
                    break;
                }
                case 3: {
                    b = OreSpawnMain.MyRotatorSpawnBlock;
                    break;
                }
                case 4: {
                    b = OreSpawnMain.MyPeacockSpawnBlock;
                    break;
                }
                case 5: {
                    b = OreSpawnMain.MyFairySpawnBlock;
                    break;
                }
                case 6: {
                    b = OreSpawnMain.MyDungeonBeastSpawnBlock;
                    break;
                }
                case 7: {
                    b = OreSpawnMain.MyVortexSpawnBlock;
                    break;
                }
                case 8: {
                    b = OreSpawnMain.MyRatSpawnBlock;
                    break;
                }
                case 9: {
                    b = OreSpawnMain.MyWhaleSpawnBlock;
                    break;
                }
                case 10: {
                    b = OreSpawnMain.MyIrukandjiSpawnBlock;
                    break;
                }
            }
            this.generateOre(world, random, randPosX, randPosY, randPosZ, chunk, b, 4, OreSpawnMain.CrystalStone);
        }
        patchy = 3 + random.nextInt(8);
        for (i = 0; i < patchy; ++i) {
            randPosX = 2 + chunkX + random.nextInt(12);
            randPosY = random.nextInt(128);
            randPosZ = 2 + chunkZ + random.nextInt(12);
            this.generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalCoal, 6, OreSpawnMain.CrystalStone);
        }
        patchy = 15 + random.nextInt(20);
        for (i = 0; i < patchy; ++i) {
            randPosX = 2 + chunkX + random.nextInt(12);
            randPosY = random.nextInt(128);
            randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY >= 25) continue;
            this.generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalRat, 6, OreSpawnMain.CrystalStone);
        }
        patchy = 12 + random.nextInt(20);
        for (i = 0; i < patchy; ++i) {
            randPosX = 2 + chunkX + random.nextInt(12);
            randPosY = random.nextInt(128);
            randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY >= 25) continue;
            this.generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalFairy, 6, OreSpawnMain.CrystalStone);
        }
    }

    public boolean generateOre(World par1World, Random par2Random, int par3, int par4, int par5, Chunk chunk, Block newbid, int numberOfBlocks, Block oldbid) {
        float f = par2Random.nextFloat() * 3.1415927f;
        double d0 = (float)(par3 + 8) + MathHelper.sin((float)f) * (float)numberOfBlocks / 8.0f;
        double d1 = (float)(par3 + 8) - MathHelper.sin((float)f) * (float)numberOfBlocks / 8.0f;
        double d2 = (float)(par5 + 8) + MathHelper.cos((float)f) * (float)numberOfBlocks / 8.0f;
        double d3 = (float)(par5 + 8) - MathHelper.cos((float)f) * (float)numberOfBlocks / 8.0f;
        double d4 = par4 + par2Random.nextInt(3) - 2;
        double d5 = par4 + par2Random.nextInt(3) - 2;
        for (int l = 0; l <= numberOfBlocks; ++l) {
            double d6 = d0 + (d1 - d0) * (double)l / (double)numberOfBlocks;
            double d7 = d4 + (d5 - d4) * (double)l / (double)numberOfBlocks;
            double d8 = d2 + (d3 - d2) * (double)l / (double)numberOfBlocks;
            double d9 = par2Random.nextDouble() * (double)numberOfBlocks / 16.0;
            double d10 = (double)(MathHelper.sin((float)((float)l * 3.1415927f / (float)numberOfBlocks)) + 1.0f) * d9 + 1.0;
            double d11 = (double)(MathHelper.sin((float)((float)l * 3.1415927f / (float)numberOfBlocks)) + 1.0f) * d9 + 1.0;
            int i1 = MathHelper.floor_double((double)(d6 - d10 / 2.0));
            int j1 = MathHelper.floor_double((double)(d7 - d11 / 2.0));
            int k1 = MathHelper.floor_double((double)(d8 - d10 / 2.0));
            int l1 = MathHelper.floor_double((double)(d6 + d10 / 2.0));
            int i2 = MathHelper.floor_double((double)(d7 + d11 / 2.0));
            int j2 = MathHelper.floor_double((double)(d8 + d10 / 2.0));
            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double)k2 + 0.5 - d6) / (d10 / 2.0);
                if (d12 * d12 >= 1.0) continue;
                for (int l2 = j1; l2 <= i2; ++l2) {
                    double d13 = ((double)l2 + 0.5 - d7) / (d11 / 2.0);
                    if (d12 * d12 + d13 * d13 >= 1.0) continue;
                    for (int i3 = k1; i3 <= j2; ++i3) {
                        double d14 = ((double)i3 + 0.5 - d8) / (d10 / 2.0);
                        Block bid = OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)k2, (int)l2, (int)i3);
                        if (d12 * d12 + d13 * d13 + d14 * d14 >= 1.0 || bid != oldbid) continue;
                        OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)k2, (int)l2, (int)i3, (Block)newbid, (int)0);
                    }
                }
            }
        }
        return true;
    }

    public void addRice(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(10) != 0) {
            return;
        }
        block0 : for (int i = 0; i < 5; ++i) {
            int posX = chunkX + random.nextInt(16);
            int posZ = chunkZ + random.nextInt(16);
            for (int posY = 128; posY > 40; --posY) {
                if (OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ) != Blocks.air || OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)(posY - 1), (int)posZ) != OreSpawnMain.CrystalGrass) continue;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.MyRicePlant, (int)0);
                continue block0;
            }
        }
    }

    public void addQuinoa(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(20) != 0) {
            return;
        }
        block0 : for (int i = 0; i < 5; ++i) {
            int posX = chunkX + random.nextInt(16);
            int posZ = chunkZ + random.nextInt(16);
            for (int posY = 128; posY > 40; --posY) {
                if (OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ) != Blocks.air || OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)(posY - 1), (int)posZ) != OreSpawnMain.CrystalGrass) continue;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.MyQuinoaPlant1, (int)0);
                continue block0;
            }
        }
    }

    public void addCrystalFlowers(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
        if (random.nextInt(3) != 0) {
            return;
        }
        int howmany = 0;
        howmany = 1 + random.nextInt(13);
        int what = random.nextInt(4);
        block0 : for (int i = 0; i < howmany; ++i) {
            int posX = chunkX + random.nextInt(16);
            int posZ = chunkZ + random.nextInt(16);
            for (int posY = 128; posY > 40; --posY) {
                if (OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ) != Blocks.air || OreSpawnMain.getBlockIDInChunk((Chunk)chunk, (int)posX, (int)(posY - 1), (int)posZ) != OreSpawnMain.CrystalGrass) continue;
                if (what == 0) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.CrystalFlowerRedBlock, (int)0);
                    continue block0;
                }
                if (what == 1) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.CrystalFlowerGreenBlock, (int)0);
                    continue block0;
                }
                if (what == 2) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.CrystalFlowerBlueBlock, (int)0);
                    continue block0;
                }
                if (what != 3) continue block0;
                OreSpawnMain.setBlockIDWithMetadataInChunk((Chunk)chunk, (int)posX, (int)posY, (int)posZ, (Block)OreSpawnMain.CrystalFlowerYellowBlock, (int)0);
                continue block0;
            }
        }
    }

    public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
        return null;
    }
}

