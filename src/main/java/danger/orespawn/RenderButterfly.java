/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.EntityLunaMoth
 *  danger.orespawn.ModelButterfly
 *  danger.orespawn.Mothra
 *  danger.orespawn.RenderButterfly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.EntityButterfly;
import danger.orespawn.EntityLunaMoth;
import danger.orespawn.ModelButterfly;
import danger.orespawn.Mothra;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderButterfly
extends RenderLiving {
    protected ModelButterfly model;
    private float scale = 1.0f;
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/creeper/creeper_armor.png");

    public RenderButterfly(ModelButterfly par1ModelBase, float par2, float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.model = (ModelButterfly)this.mainModel;
        this.scale = par3;
    }

    public void renderButterfly(EntityButterfly par1EntityButterfly, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityButterfly, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderButterfly((EntityButterfly)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderButterfly((EntityButterfly)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(EntityButterfly par1Entity, float par2) {
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((EntityButterfly)par1EntityLiving, par2);
    }

    public int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
        int doit = 0;
        if (par1EntityLiving instanceof Mothra) {
            ++doit;
        } else if (par1EntityLiving instanceof EntityLunaMoth) {
            EntityLunaMoth e = (EntityLunaMoth)par1EntityLiving;
            if (e.moth_type == 0) {
                ++doit;
            }
        }
        if (doit != 0) {
            GL11.glDepthMask((boolean)true);
            if (par2 == 1) {
                float var4 = (float)par1EntityLiving.ticksExisted + par3;
                this.bindTexture(texture);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float var5 = var4 * 0.01f;
                float var6 = var4 * 0.01f;
                GL11.glTranslatef((float)var5, (float)var6, (float)0.0f);
                this.setRenderPassModel((ModelBase)this.model);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float var7 = 0.5f;
                GL11.glColor4f((float)var7, (float)var7, (float)var7, (float)1.0f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
                return 1;
            }
            if (par2 == 2) {
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)2896);
                GL11.glDisable((int)3042);
            }
        }
        return -1;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        EntityButterfly a = (EntityButterfly)entity;
        return a.getTexture(a);
    }
}

