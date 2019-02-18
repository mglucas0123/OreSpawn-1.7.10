/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Irukandji
 *  danger.orespawn.ModelIrukandji
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.Irukandji;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelIrukandji
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer t11;
    ModelRenderer t12;
    ModelRenderer t21;
    ModelRenderer t22;
    ModelRenderer t31;
    ModelRenderer t32;
    ModelRenderer t41;
    ModelRenderer t42;

    public ModelIrukandji(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 9);
        this.body.addBox(-2.0f, 0.0f, -2.0f, 4, 4, 4);
        this.body.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.t11 = new ModelRenderer((ModelBase)this, 25, 0);
        this.t11.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t11.setRotationPoint(1.0f, 10.0f, -2.0f);
        this.t11.setTextureSize(64, 32);
        this.t11.mirror = true;
        this.setRotation(this.t11, 0.0f, 0.0f, 0.0f);
        this.t12 = new ModelRenderer((ModelBase)this, 5, 0);
        this.t12.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t12.setRotationPoint(1.0f, 17.0f, -2.0f);
        this.t12.setTextureSize(64, 32);
        this.t12.mirror = true;
        this.setRotation(this.t12, 0.0f, 0.0f, 0.0f);
        this.t21 = new ModelRenderer((ModelBase)this, 0, 0);
        this.t21.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t21.setRotationPoint(-2.0f, 10.0f, -2.0f);
        this.t21.setTextureSize(64, 32);
        this.t21.mirror = true;
        this.setRotation(this.t21, 0.0f, 0.0f, 0.0f);
        this.t22 = new ModelRenderer((ModelBase)this, 20, 0);
        this.t22.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t22.setRotationPoint(-2.0f, 17.0f, -2.0f);
        this.t22.setTextureSize(64, 32);
        this.t22.mirror = true;
        this.setRotation(this.t22, 0.0f, 0.0f, 0.0f);
        this.t31 = new ModelRenderer((ModelBase)this, 30, 0);
        this.t31.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t31.setRotationPoint(1.0f, 10.0f, 1.0f);
        this.t31.setTextureSize(64, 32);
        this.t31.mirror = true;
        this.setRotation(this.t31, 0.0f, 0.0f, 0.0f);
        this.t32 = new ModelRenderer((ModelBase)this, 10, 0);
        this.t32.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t32.setRotationPoint(1.0f, 17.0f, 1.0f);
        this.t32.setTextureSize(64, 32);
        this.t32.mirror = true;
        this.setRotation(this.t32, 0.0f, 0.0f, 0.0f);
        this.t41 = new ModelRenderer((ModelBase)this, 35, 0);
        this.t41.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t41.setRotationPoint(-2.0f, 10.0f, 1.0f);
        this.t41.setTextureSize(64, 32);
        this.t41.mirror = true;
        this.setRotation(this.t41, 0.0f, 0.0f, 0.0f);
        this.t42 = new ModelRenderer((ModelBase)this, 15, 0);
        this.t42.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t42.setRotationPoint(-2.0f, 17.0f, 1.0f);
        this.t42.setTextureSize(64, 32);
        this.t42.mirror = true;
        this.setRotation(this.t42, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Irukandji e = (Irukandji)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        this.t11.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.55f)) * 3.1415927f * 0.15f;
        float d1 = (float)(Math.sin(newangle) * 7.0);
        float d2 = (float)(Math.cos(newangle) * 7.0);
        this.t12.rotationPointZ = this.t11.rotationPointZ + d1;
        this.t11.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.35f)) * 3.1415927f * 0.1f;
        float d3 = (float)(Math.cos(newangle) * (double)d2);
        float d4 = (float)(Math.sin(newangle) * (double)d2);
        this.t12.rotationPointX = this.t11.rotationPointX - d4;
        this.t12.rotationPointY = this.t11.rotationPointY + d3;
        this.t12.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.45f)) * 3.1415927f * 0.15f;
        this.t12.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.25f)) * 3.1415927f * 0.1f;
        this.t21.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.65f)) * 3.1415927f * 0.15f;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t22.rotationPointZ = this.t21.rotationPointZ + d1;
        this.t21.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.45f)) * 3.1415927f * 0.1f;
        d3 = (float)(Math.cos(newangle) * (double)d2);
        d4 = (float)(Math.sin(newangle) * (double)d2);
        this.t22.rotationPointX = this.t21.rotationPointX - d4;
        this.t22.rotationPointY = this.t21.rotationPointY + d3;
        this.t22.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.55f)) * 3.1415927f * 0.15f;
        this.t22.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.35f)) * 3.1415927f * 0.1f;
        this.t31.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.5f)) * 3.1415927f * 0.15f;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t32.rotationPointZ = this.t31.rotationPointZ + d1;
        this.t31.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.3f)) * 3.1415927f * 0.1f;
        d3 = (float)(Math.cos(newangle) * (double)d2);
        d4 = (float)(Math.sin(newangle) * (double)d2);
        this.t32.rotationPointX = this.t31.rotationPointX - d4;
        this.t32.rotationPointY = this.t31.rotationPointY + d3;
        this.t32.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.4f)) * 3.1415927f * 0.15f;
        this.t32.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.2f)) * 3.1415927f * 0.1f;
        this.t41.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.57f)) * 3.1415927f * 0.15f;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t42.rotationPointZ = this.t41.rotationPointZ + d1;
        this.t41.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.37f)) * 3.1415927f * 0.1f;
        d3 = (float)(Math.cos(newangle) * (double)d2);
        d4 = (float)(Math.sin(newangle) * (double)d2);
        this.t42.rotationPointX = this.t41.rotationPointX - d4;
        this.t42.rotationPointY = this.t41.rotationPointY + d3;
        this.t42.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.48f)) * 3.1415927f * 0.15f;
        this.t42.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.29f)) * 3.1415927f * 0.1f;
        this.body.render(f5);
        this.t11.render(f5);
        this.t12.render(f5);
        this.t21.render(f5);
        this.t22.render(f5);
        this.t31.render(f5);
        this.t32.render(f5);
        this.t41.render(f5);
        this.t42.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    }
}

