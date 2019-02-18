/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RenderGirlfriend
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.entity.RenderBiped
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGirlfriend
extends RenderBiped {
    protected ModelBiped model;

    public RenderGirlfriend(ModelBiped par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelBiped)this.mainModel;
    }

    public void renderGirlfriend(Girlfriend par1EntityGirlfriend, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityGirlfriend, par2, par4, par6, par8, par9);
    }

    public void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        if (OreSpawnMain.valentines_day != 0 && p_77041_1_ != null && p_77041_1_ instanceof Girlfriend) {
            Girlfriend gf = (Girlfriend)p_77041_1_;
            if (gf.feelingBetter == 0) {
                GL11.glScalef((float)5.0f, (float)5.0f, (float)5.0f);
            }
        }
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderGirlfriend((Girlfriend)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderGirlfriend((Girlfriend)par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        Girlfriend g = (Girlfriend)entity;
        return g.getTexture();
    }
}

