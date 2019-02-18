/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelPurplePower
 *  danger.orespawn.PurplePower
 *  danger.orespawn.RenderPurplePower
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.ModelPurplePower;
import danger.orespawn.PurplePower;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPurplePower
extends RenderLiving {
    protected ModelPurplePower model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "PurplePowertexture.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "PurplePowertexture2.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "PurplePowertexture3.png");
    private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "PurplePowertexture4.png");
    private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "PurplePowertexture10.png");

    public RenderPurplePower(ModelPurplePower par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelPurplePower)this.mainModel;
        this.scale = par3;
    }

    public void renderPurplePower(PurplePower par1EntityPurplePower, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityPurplePower, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderPurplePower((PurplePower)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(PurplePower par1Entity, float par2) {
        float localscale = this.scale;
        if (par1Entity.getPurpleType() != 0) {
            localscale = 0.55f;
        }
        GL11.glScalef((float)localscale, (float)localscale, (float)localscale);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        PurplePower p = (PurplePower)entity;
        int i = p.getPurpleType();
        if (i == 1) {
            return texture2;
        }
        if (i == 2) {
            return texture3;
        }
        if (i == 3) {
            return texture4;
        }
        if (i == 10) {
            return texture10;
        }
        return texture;
    }
}

