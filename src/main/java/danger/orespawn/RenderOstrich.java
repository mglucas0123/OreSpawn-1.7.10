/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EntityCannonFodder
 *  danger.orespawn.ModelOstrich
 *  danger.orespawn.Ostrich
 *  danger.orespawn.RenderOstrich
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.EntityCannonFodder;
import danger.orespawn.ModelOstrich;
import danger.orespawn.Ostrich;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOstrich
extends RenderLiving {
    protected ModelOstrich model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "Ostrichtexture.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Ostrichtexture2.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "Ostrichtexture3.png");

    public RenderOstrich(ModelOstrich par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelOstrich)this.mainModel;
        this.scale = par3;
    }

    public void renderOstrich(Ostrich par1EntityOstrich, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityOstrich, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderOstrich((Ostrich)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderOstrich((Ostrich)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(Ostrich par1Entity, float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef((float)(this.scale / 2.0f), (float)(this.scale / 2.0f), (float)(this.scale / 2.0f));
            return;
        }
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((Ostrich)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        EntityCannonFodder c;
        if (entity instanceof EntityCannonFodder && (c = (EntityCannonFodder)entity).get_is_activated() != 0) {
            if (c.getHatColor() == 2) {
                return texture2;
            }
            if (c.getHatColor() == 3) {
                return texture3;
            }
        }
        return texture;
    }
}

