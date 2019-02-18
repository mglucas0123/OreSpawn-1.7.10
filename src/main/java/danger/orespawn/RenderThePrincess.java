/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelThePrincess
 *  danger.orespawn.RenderThePrincess
 *  danger.orespawn.ThePrincess
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.ModelThePrincess;
import danger.orespawn.ThePrincess;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderThePrincess
extends RenderLiving {
    protected ModelThePrincess model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "ThePrincesstexture.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "ThePrincesstexture2.png");

    public RenderThePrincess(ModelThePrincess par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelThePrincess)this.mainModel;
        this.scale = par3;
    }

    public void renderThePrincess(ThePrincess par1EntityThePrincess, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityThePrincess, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderThePrincess((ThePrincess)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderThePrincess((ThePrincess)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(ThePrincess par1Entity, float par2) {
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((ThePrincess)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        ThePrincess t = (ThePrincess)entity;
        if (t.getAttacking() != 0) {
            return texture2;
        }
        return texture;
    }
}

