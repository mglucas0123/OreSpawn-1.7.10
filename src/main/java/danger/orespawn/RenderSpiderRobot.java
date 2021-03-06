/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelSpiderRobot
 *  danger.orespawn.RenderSpiderRobot
 *  danger.orespawn.SpiderRobot
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.ModelSpiderRobot;
import danger.orespawn.SpiderRobot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSpiderRobot
extends RenderLiving {
    protected ModelSpiderRobot model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "SpiderRobottexture.png");

    public RenderSpiderRobot(ModelSpiderRobot par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelSpiderRobot)this.mainModel;
        this.scale = par3;
    }

    public void renderSpiderRobot(SpiderRobot par1EntitySpiderRobot, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glRotatef((float)(180.0f - par8), (float)0.0f, (float)1.0f, (float)0.0f);
        this.bindTexture(texture);
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        this.model.render((Entity)par1EntitySpiderRobot, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderSpiderRobot((SpiderRobot)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderSpiderRobot((SpiderRobot)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(SpiderRobot par1Entity, float par2) {
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((SpiderRobot)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}

