/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GenericTargetSorter
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.EntityCreeper
 */
package danger.orespawn;

import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;

public class GenericTargetSorter
implements Comparator {
    private Entity theEntity;

    public GenericTargetSorter(Entity par2Entity) {
        this.theEntity = par2Entity;
    }

    public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
        double weight = 0.0;
        double var3 = this.theEntity.getDistanceSqToEntity(par1Entity);
        if (par1Entity instanceof EntityCreeper) {
            var3 /= 2.0;
        }
        if ((weight = (double)(par1Entity.height * par1Entity.width)) > 1.0) {
            var3 /= weight;
        }
        double var5 = this.theEntity.getDistanceSqToEntity(par2Entity);
        if (par2Entity instanceof EntityCreeper) {
            var5 /= 2.0;
        }
        if ((weight = (double)(par2Entity.height * par2Entity.width)) > 1.0) {
            var5 /= weight;
        }
        return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
    }

    public int compare(Object par1Obj, Object par2Obj) {
        return this.compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
    }
}

