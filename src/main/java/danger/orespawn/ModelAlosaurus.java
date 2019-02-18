/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Alosaurus
 *  danger.orespawn.ModelAlosaurus
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.Alosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAlosaurus
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer jaw;
    ModelRenderer leftleg;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer Shape11;
    ModelRenderer rightleg;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer leftleg4;
    ModelRenderer rightleg4;
    ModelRenderer Shape17;

    public ModelAlosaurus(float f1) {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.wingspeed = f1;
        this.Shape18 = new ModelRenderer((ModelBase)this, 91, 114);
        this.Shape18.addBox(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape18.setRotationPoint(3.3f, -25.0f, -27.0f);
        this.Shape18.setTextureSize(128, 128);
        this.Shape18.mirror = true;
        this.setRotation(this.Shape18, 0.5759587f, 0.0f, 0.5585054f);
        this.Shape19 = new ModelRenderer((ModelBase)this, 71, 114);
        this.Shape19.addBox(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape19.setRotationPoint(-4.0f, -24.0f, -28.0f);
        this.Shape19.setTextureSize(128, 128);
        this.Shape19.mirror = true;
        this.setRotation(this.Shape19, 0.5759587f, 0.0f, -0.5585054f);
        this.Shape20 = new ModelRenderer((ModelBase)this, 91, 30);
        this.Shape20.addBox(0.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape20.setRotationPoint(5.0f, -8.0f, -6.0f);
        this.Shape20.setTextureSize(128, 128);
        this.Shape20.mirror = true;
        this.setRotation(this.Shape20, 0.3839724f, 0.0f, 0.0f);
        this.Shape21 = new ModelRenderer((ModelBase)this, 93, 46);
        this.Shape21.addBox(-2.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape21.setRotationPoint(-4.0f, -8.0f, -6.0f);
        this.Shape21.setTextureSize(128, 128);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, 0.3839724f, 0.0f, 0.0f);
        this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Shape1.addBox(-7.0f, 0.0f, 0.0f, 10, 18, 31);
        this.Shape1.setRotationPoint(2.5f, -19.0f, -8.0f);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new ModelRenderer((ModelBase)this, 62, 0);
        this.Shape2.addBox(-5.0f, 0.0f, 0.0f, 10, 11, 11);
        this.Shape2.setRotationPoint(0.5f, -19.0f, 23.0f);
        this.Shape2.setTextureSize(128, 128);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new ModelRenderer((ModelBase)this, 10, 54);
        this.Shape3.addBox(-3.0f, 0.0f, 0.0f, 7, 7, 25);
        this.Shape3.setRotationPoint(0.0f, -19.0f, 34.0f);
        this.Shape3.setTextureSize(128, 128);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new ModelRenderer((ModelBase)this, 68, 88);
        this.Shape4.addBox(-5.0f, 0.0f, 0.0f, 8, 9, 16);
        this.Shape4.setRotationPoint(1.5f, -25.0f, -16.0f);
        this.Shape4.setTextureSize(128, 128);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, -0.4014257f, 0.0f, 0.0f);
        this.Shape5 = new ModelRenderer((ModelBase)this, 75, 65);
        this.Shape5.addBox(0.0f, 0.0f, 0.0f, 9, 9, 12);
        this.Shape5.setRotationPoint(-4.0f, -25.0f, -27.0f);
        this.Shape5.setTextureSize(128, 128);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape6 = new ModelRenderer((ModelBase)this, 0, 50);
        this.Shape6.addBox(0.0f, 0.0f, 0.0f, 7, 9, 9);
        this.Shape6.setRotationPoint(-3.0f, -25.0f, -36.0f);
        this.Shape6.setTextureSize(128, 128);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        this.jaw = new ModelRenderer((ModelBase)this, 0, 86);
        this.jaw.addBox(-5.0f, 0.0f, -10.0f, 7, 1, 13);
        this.jaw.setRotationPoint(2.0f, -15.0f, -24.0f);
        this.jaw.setTextureSize(128, 128);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.5201081f, 0.0f, 0.0f);
        this.leftleg = new ModelRenderer((ModelBase)this, 0, 0);
        this.leftleg.addBox(-1.0f, 0.0f, 0.0f, 3, 16, 10);
        this.leftleg.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, -0.1745329f, 0.0f, 0.0f);
        this.leftleg2 = new ModelRenderer((ModelBase)this, 0, 106);
        this.leftleg2.addBox(-1.0f, 12.0f, -8.0f, 3, 15, 5);
        this.leftleg2.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg2.setTextureSize(128, 128);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.5061455f, 0.0f, 0.0f);
        this.leftleg3 = new ModelRenderer((ModelBase)this, 112, 89);
        this.leftleg3.addBox(-1.0f, 19.0f, 16.0f, 3, 9, 3);
        this.leftleg3.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg3.setTextureSize(128, 128);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.4014257f, 0.0f, 0.0f);
        this.Shape11 = new ModelRenderer((ModelBase)this, 0, 72);
        this.Shape11.addBox(0.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape11.setRotationPoint(5.0f, -5.0f, -3.0f);
        this.Shape11.setTextureSize(128, 128);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, -0.5235988f, 0.0f, 0.0f);
        this.rightleg = new ModelRenderer((ModelBase)this, 54, 51);
        this.rightleg.addBox(0.0f, 0.0f, 0.0f, 3, 16, 10);
        this.rightleg.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, -0.1745329f, 0.0f, 0.0f);
        this.rightleg2 = new ModelRenderer((ModelBase)this, 23, 106);
        this.rightleg2.addBox(0.0f, 12.0f, -8.0f, 3, 15, 5);
        this.rightleg2.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg2.setTextureSize(128, 128);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.5061455f, 0.0f, 0.0f);
        this.rightleg3 = new ModelRenderer((ModelBase)this, 70, 90);
        this.rightleg3.addBox(0.0f, 19.0f, 16.0f, 3, 9, 3);
        this.rightleg3.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg3.setTextureSize(128, 128);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.4014257f, 0.0f, 0.0f);
        this.leftleg4 = new ModelRenderer((ModelBase)this, 42, 113);
        this.leftleg4.addBox(-1.0f, 31.0f, -1.0f, 3, 3, 8);
        this.leftleg4.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg4.setTextureSize(128, 128);
        this.leftleg4.mirror = true;
        this.setRotation(this.leftleg4, 0.0f, 0.0f, 0.0f);
        this.rightleg4 = new ModelRenderer((ModelBase)this, 44, 93);
        this.rightleg4.addBox(0.0f, 31.0f, -1.0f, 3, 3, 8);
        this.rightleg4.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg4.setTextureSize(128, 128);
        this.rightleg4.mirror = true;
        this.setRotation(this.rightleg4, 0.0f, 0.0f, 0.0f);
        this.Shape17 = new ModelRenderer((ModelBase)this, 112, 60);
        this.Shape17.addBox(-2.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape17.setRotationPoint(-4.0f, -3.533333f, -3.0f);
        this.Shape17.setTextureSize(128, 128);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, -0.5235988f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Alosaurus e = (Alosaurus)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = (double)f1 > 0.1 ? MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.25f * f1 : 0.0f;
        this.rightleg.rotateAngleX = -0.174f + newangle;
        this.rightleg2.rotateAngleX = 0.506f + newangle;
        this.rightleg3.rotateAngleX = -0.401f + newangle;
        this.rightleg4.rotateAngleX = newangle;
        this.leftleg.rotateAngleX = -0.174f - newangle;
        this.leftleg2.rotateAngleX = 0.506f - newangle;
        this.leftleg3.rotateAngleX = -0.401f - newangle;
        this.leftleg4.rotateAngleX = - newangle;
        this.jaw.rotateAngleX = e.getAttacking() != 0 ? 0.52f + MathHelper.cos((float)(f2 * 0.45f)) * 3.1415927f * 0.18f : 0.1f;
        this.Shape17.rotateAngleX = -0.523f + MathHelper.cos((float)(f2 * 0.1f)) * 3.1415927f * 0.05f;
        this.Shape11.rotateAngleX = -0.523f + MathHelper.cos((float)(f2 * 0.1f)) * 3.1415927f * 0.05f;
        this.Shape18.render(f5);
        this.Shape19.render(f5);
        this.Shape20.render(f5);
        this.Shape21.render(f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.jaw.render(f5);
        this.leftleg.render(f5);
        this.leftleg2.render(f5);
        this.leftleg3.render(f5);
        this.Shape11.render(f5);
        this.rightleg.render(f5);
        this.rightleg2.render(f5);
        this.rightleg3.render(f5);
        this.leftleg4.render(f5);
        this.rightleg4.render(f5);
        this.Shape17.render(f5);
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

