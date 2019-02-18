/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Firefly
 *  danger.orespawn.ModelFirefly
 *  danger.orespawn.RenderFirefly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.Firefly;
import danger.orespawn.ModelFirefly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFirefly
extends RenderLiving {
    protected ModelFirefly model;
    private float scale = 1.0f;

    public RenderFirefly(ModelFirefly par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelFirefly)this.mainModel;
        this.scale = par3;
    }

    public void renderFirefly(Firefly par1EntityFirefly, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityFirefly, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderFirefly((Firefly)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderFirefly((Firefly)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(Firefly par1Entity, float par2) {
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((Firefly)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        Firefly a = (Firefly)entity;
        return a.getTexture(a);
    }
}

