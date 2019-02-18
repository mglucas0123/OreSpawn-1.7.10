/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.BiomeGenUtopianPlains
 *  danger.orespawn.ChunkProviderOreSpawn5
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.WorldProviderOreSpawn5
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$Height
 *  net.minecraft.world.biome.WorldChunkManager
 *  net.minecraft.world.biome.WorldChunkManagerHell
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.DimensionManager
 */
package danger.orespawn;

import danger.orespawn.BiomeGenUtopianPlains;
import danger.orespawn.ChunkProviderOreSpawn5;
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
import net.minecraftforge.common.DimensionManager;

public class WorldProviderOreSpawn5
extends WorldProvider {
    private BiomeGenUtopianPlains MyPlains = (BiomeGenUtopianPlains)new BiomeGenUtopianPlains(OreSpawnMain.BiomeCrystalID).setColor(353825).setBiomeName("Crystal").setTemperatureRainfall(0.7f, 0.5f);

    public String getDimensionName() {
        return "Dimension-Crystal";
    }

    public boolean canRespawnHere() {
        return true;
    }

    public void registerWorldChunkManager() {
        this.MyPlains.setCrystalCreatures();
        this.MyPlains.setHeight(new BiomeGenBase.Height(0.1f, 0.5f));
        this.worldChunkMgr = new WorldChunkManagerHell((BiomeGenBase)this.MyPlains, 0.01f);
        this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.8f, 0.01f);
        this.dimensionId = OreSpawnMain.DimensionID5;
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
        return new ChunkProviderOreSpawn5(this.worldObj, this.worldObj.getSeed(), true);
    }
}

