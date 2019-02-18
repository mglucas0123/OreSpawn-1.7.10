/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.RenderBoyfriend
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.entity.RenderBiped
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.util.ResourceLocation
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBoyfriend
extends RenderBiped {
    protected ModelBiped model;

    public RenderBoyfriend(ModelBiped par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelBiped)this.mainModel;
    }

    public void renderBoyfriend(Boyfriend par1EntityBoyfriend, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityBoyfriend, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderBoyfriend((Boyfriend)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderBoyfriend((Boyfriend)par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        Boyfriend g = (Boyfriend)entity;
        return g.getTexture();
    }
}

