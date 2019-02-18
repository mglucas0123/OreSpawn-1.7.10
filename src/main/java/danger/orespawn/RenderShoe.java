/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.RenderShoe
 *  danger.orespawn.RenderSpinner
 *  danger.orespawn.Shoes
 *  net.minecraft.entity.Entity
 */
package danger.orespawn;

import danger.orespawn.RenderSpinner;
import danger.orespawn.Shoes;
import net.minecraft.entity.Entity;

public class RenderShoe
extends RenderSpinner {
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        if (par1Entity instanceof Shoes) {
            Shoes var2 = (Shoes)par1Entity;
            this.spinItemIconIndex = var2.getShoeId();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}

