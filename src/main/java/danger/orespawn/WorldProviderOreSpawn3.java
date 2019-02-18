/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.BiomeGenUtopianPlains
 *  danger.orespawn.ChunkProviderOreSpawn3
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WorldProviderOreSpawn3
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.WorldChunkManager
 *  net.minecraft.world.biome.WorldChunkManagerHell
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.BiomeManager
 *  net.minecraftforge.common.DimensionManager
 */
package danger.orespawn;

import danger.orespawn.BiomeGenUtopianPlains;
import danger.orespawn.ChunkProviderOreSpawn3;
import danger.orespawn.OreSpawnMain;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderOreSpawn3
extends WorldProvider {
    private BiomeGenUtopianPlains MyPlains = (BiomeGenUtopianPlains)new BiomeGenUtopianPlains(OreSpawnMain.BiomeVillageID).setColor(353825).setBiomeName("Villages").setTemperatureRainfall(0.7f, 0.5f);

    public String getDimensionName() {
        return "Dimension-VillageMania";
    }

    public boolean canRespawnHere() {
        return true;
    }

    public void registerWorldChunkManager() {
        this.MyPlains.setVillageCreatures();
        this.worldChunkMgr = new WorldChunkManagerHell((BiomeGenBase)this.MyPlains, 0.5f);
        this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.7f, 0.5f);
        this.dimensionId = OreSpawnMain.DimensionID3;
        BiomeManager.addVillageBiome((BiomeGenBase)this.MyPlains, (boolean)true);
    }

    public void setWorldTime(long time) {
        WorldServer ws = DimensionManager.getWorld((int)this.dimensionId);
        if (ws != null) {
            WorldInfo w = ws.getWorldInfo();
            if (w != null) {
                if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
                    long i = time + 24000L;
                    i -= i % 24000L;
                    for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j) {
                        MinecraftServer.getServer().worldServers[j].setWorldTime(i);
                    }
                } else {
                    super.setWorldTime(time);
                }
            } else {
                super.setWorldTime(time);
            }
        } else {
            super.setWorldTime(time);
        }
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderOreSpawn3(this.worldObj, this.worldObj.getSeed(), true);
    }
}

