/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MapGenMoreVillages
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.WorldChunkManager
 *  net.minecraft.world.gen.structure.MapGenVillage
 */
package danger.orespawn;

import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.MapGenVillage;

public class MapGenMoreVillages
extends MapGenVillage {
    private int field_82665_g = 9;
    private int field_82666_h = 7;

    protected boolean canSpawnStructureAtCoords(int par1, int par2) {
        int var3 = par1;
        int var4 = par2;
        if (par1 < 0) {
            par1 -= this.field_82665_g - 1;
        }
        if (par2 < 0) {
            par2 -= this.field_82665_g - 1;
        }
        int var5 = par1 / this.field_82665_g;
        int var6 = par2 / this.field_82665_g;
        Random var7 = this.worldObj.setRandomSeed(var5, var6, 10387312);
        var5 *= this.field_82665_g;
        var6 *= this.field_82665_g;
        if (var3 == (var5 += var7.nextInt(this.field_82665_g - this.field_82666_h)) && var4 == (var6 += var7.nextInt(this.field_82665_g - this.field_82666_h))) {
            boolean var8 = this.worldObj.getWorldChunkManager().areBiomesViable(var3 * 16 + 8, var4 * 16 + 8, 0, villageSpawnBiomes);
            return true;
        }
        return false;
    }
}

