/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.CrystalCow
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RedCow
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import danger.orespawn.RedCow;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CrystalCow
extends RedCow {
    public CrystalCow(World world) {
        super(world);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(OreSpawnMain.MyCrystalApple, 1);
        }
        this.dropItem(Items.apple, 1);
        super.dropFewItems(par1, par2);
    }

    public EntityCow createChild(EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    public CrystalCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
        return new CrystalCow(this.worldObj);
    }
}

