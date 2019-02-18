/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.CrystalCow
 *  danger.orespawn.EnchantedCow
 *  danger.orespawn.GoldCow
 *  danger.orespawn.RedCow
 *  danger.orespawn.RenderEnchantedCow
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelCow
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.CrystalCow;
import danger.orespawn.EnchantedCow;
import danger.orespawn.GoldCow;
import danger.orespawn.RedCow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEnchantedCow
extends RenderLiving {
    protected ModelCow model;
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "crystal_cow.png");
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "red_cow.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "gold_cow.png");

    public RenderEnchantedCow(ModelCow par1ModelBase, float par2) {
        super((ModelBase)par1ModelBase, par2);
        this.model = (ModelCow)this.mainModel;
    }

    public void renderEnchantedCow(RedCow par1EntityEnchantedCow, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityEnchantedCow, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderEnchantedCow((RedCow)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderEnchantedCow((RedCow)par1Entity, par2, par4, par6, par8, par9);
    }

    public int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
        if (par1EntityLiving instanceof EnchantedCow && par2 == 3) {
            this.setRenderPassModel((ModelBase)this.model);
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            return 31;
        }
        return -1;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        if (entity instanceof EnchantedCow) {
            return texture2;
        }
        if (entity instanceof GoldCow) {
            return texture2;
        }
        if (entity instanceof CrystalCow) {
            return texture3;
        }
        return texture1;
    }
}

