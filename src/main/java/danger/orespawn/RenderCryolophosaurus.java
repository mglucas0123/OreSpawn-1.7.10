/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Cryolophosaurus
 *  danger.orespawn.ModelCryolophosaurus
 *  danger.orespawn.RenderCryolophosaurus
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.Cryolophosaurus;
import danger.orespawn.ModelCryolophosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCryolophosaurus
extends RenderLiving {
    protected ModelCryolophosaurus model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "cryolophosaurus.png");

    public RenderCryolophosaurus(ModelCryolophosaurus par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelCryolophosaurus)this.mainModel;
        this.scale = par3;
    }

    public void renderCryolophosaurus(Cryolophosaurus par1EntityCryolophosaurus, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityCryolophosaurus, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderCryolophosaurus((Cryolophosaurus)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderCryolophosaurus((Cryolophosaurus)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(Cryolophosaurus par1Entity, float par2) {
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((Cryolophosaurus)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}

