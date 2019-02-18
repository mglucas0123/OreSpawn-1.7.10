/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.MyValentineTarget
 *  danger.orespawn.MyValentineTargetSorter
 *  net.minecraft.entity.Entity
 */
package danger.orespawn;

import danger.orespawn.MyValentineTarget;
import java.util.Comparator;
import net.minecraft.entity.Entity;

public class MyValentineTargetSorter
implements Comparator {
    private Entity theEntity;
    final MyValentineTarget parent;

    public MyValentineTargetSorter(MyValentineTarget par1EntityAINearestAttackableTarget, Entity par2Entity) {
        this.parent = par1EntityAINearestAttackableTarget;
        this.theEntity = par2Entity;
    }

    public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
        double var5;
        double var3 = this.theEntity.getDistanceSqToEntity(par1Entity);
        return var3 < (var5 = this.theEntity.getDistanceSqToEntity(par2Entity)) ? -1 : (var3 > var5 ? 1 : 0);
    }

    public int compare(Object par1Obj, Object par2Obj) {
        return this.compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
    }
}

