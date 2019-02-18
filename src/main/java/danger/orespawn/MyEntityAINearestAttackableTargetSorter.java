/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyEntityAINearestAttackableTarget
 *  danger.orespawn.MyEntityAINearestAttackableTargetSorter
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.EntityCreeper
 */
package danger.orespawn;

import danger.orespawn.MyEntityAINearestAttackableTarget;
import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;

public class MyEntityAINearestAttackableTargetSorter
implements Comparator {
    private Entity theEntity;
    final MyEntityAINearestAttackableTarget parent;

    public MyEntityAINearestAttackableTargetSorter(MyEntityAINearestAttackableTarget par1EntityAINearestAttackableTarget, Entity par2Entity) {
        this.parent = par1EntityAINearestAttackableTarget;
        this.theEntity = par2Entity;
    }

    public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
        double var3 = this.theEntity.getDistanceSqToEntity(par1Entity);
        if (par1Entity instanceof EntityCreeper) {
            var3 /= 2.0;
        }
        double var5 = this.theEntity.getDistanceSqToEntity(par2Entity);
        if (par2Entity instanceof EntityCreeper) {
            var5 /= 2.0;
        }
        return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
    }

    public int compare(Object par1Obj, Object par2Obj) {
        return this.compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
    }
}

