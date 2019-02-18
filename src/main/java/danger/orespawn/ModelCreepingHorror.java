/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelCreepingHorror
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCreepingHorror
extends ModelBase {
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg1part2;
    ModelRenderer leg2;
    ModelRenderer leg2part2;
    ModelRenderer leg3;
    ModelRenderer leg3part2;
    ModelRenderer leg4;
    ModelRenderer leg4part2;
    ModelRenderer tailseg1;
    ModelRenderer tailseg2;
    ModelRenderer tailseg3;
    ModelRenderer pincer1;
    ModelRenderer pincer1part2;
    ModelRenderer pincer2;
    ModelRenderer pincer2part2;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer insides1;
    ModelRenderer insides2;
    ModelRenderer insides3;
    ModelRenderer insides4;
    ModelRenderer insides5;

    public ModelCreepingHorror() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer((ModelBase)this, 0, 30);
        this.body.addBox(-4.0f, -5.0f, -4.0f, 8, 8, 8);
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 65, 0);
        this.leg1.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2);
        this.leg1.setRotationPoint(4.0f, 18.0f, -2.0f);
        this.leg1.setTextureSize(128, 128);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0f, 0.5759587f, 0.1919862f);
        this.leg1part2 = new ModelRenderer((ModelBase)this, 37, 5);
        this.leg1part2.addBox(13.01f, -1.01f, -1.0f, 2, 5, 2);
        this.leg1part2.setRotationPoint(4.0f, 18.0f, -2.0f);
        this.leg1part2.setTextureSize(128, 128);
        this.leg1part2.mirror = true;
        this.setRotation(this.leg1part2, 0.0f, 0.5759587f, 0.1919862f);
        this.leg2 = new ModelRenderer((ModelBase)this, 65, 0);
        this.leg2.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2);
        this.leg2.setRotationPoint(4.0f, 18.0f, 2.0f);
        this.leg2.setTextureSize(128, 128);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0f, -0.5759587f, 0.1919862f);
        this.leg2part2 = new ModelRenderer((ModelBase)this, 37, 5);
        this.leg2part2.addBox(13.01f, -1.01f, -1.0f, 2, 5, 2);
        this.leg2part2.setRotationPoint(4.0f, 18.0f, 2.0f);
        this.leg2part2.setTextureSize(128, 128);
        this.leg2part2.mirror = true;
        this.setRotation(this.leg2part2, 0.0f, -0.5759587f, 0.1919862f);
        this.leg3 = new ModelRenderer((ModelBase)this, 28, 0);
        this.leg3.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2);
        this.leg3.setRotationPoint(-4.0f, 18.0f, -2.0f);
        this.leg3.setTextureSize(128, 128);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0f, -0.5759587f, -0.1919862f);
        this.leg3part2 = new ModelRenderer((ModelBase)this, 28, 5);
        this.leg3part2.addBox(-15.01f, -1.01f, -1.0f, 2, 5, 2);
        this.leg3part2.setRotationPoint(-4.0f, 18.0f, -2.0f);
        this.leg3part2.setTextureSize(128, 128);
        this.leg3part2.mirror = true;
        this.setRotation(this.leg3part2, 0.0f, -0.5759587f, -0.1919862f);
        this.leg4 = new ModelRenderer((ModelBase)this, 28, 0);
        this.leg4.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2);
        this.leg4.setRotationPoint(-4.0f, 18.0f, 2.0f);
        this.leg4.setTextureSize(128, 128);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0f, 0.5759587f, -0.1919862f);
        this.leg4part2 = new ModelRenderer((ModelBase)this, 28, 5);
        this.leg4part2.addBox(-15.01f, -1.01f, -1.0f, 2, 5, 2);
        this.leg4part2.setRotationPoint(-4.0f, 18.0f, 2.0f);
        this.leg4part2.setTextureSize(128, 128);
        this.leg4part2.mirror = true;
        this.setRotation(this.leg4part2, 0.0f, 0.5759587f, -0.1919862f);
        this.tailseg1 = new ModelRenderer((ModelBase)this, 0, 13);
        this.tailseg1.addBox(-2.0f, -1.0f, 0.0f, 4, 2, 7);
        this.tailseg1.setRotationPoint(0.0f, 17.0f, 3.0f);
        this.tailseg1.setTextureSize(128, 128);
        this.tailseg1.mirror = true;
        this.setRotation(this.tailseg1, -0.5576792f, 0.0f, 0.0f);
        this.tailseg2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tailseg2.addBox(-1.0f, 3.0f, 7.0f, 2, 1, 11);
        this.tailseg2.setRotationPoint(0.0f, 17.0f, 3.0f);
        this.tailseg2.setTextureSize(128, 128);
        this.tailseg2.mirror = true;
        this.setRotation(this.tailseg2, -0.0349066f, 0.0f, 0.0f);
        this.tailseg3 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tailseg3.addBox(-1.5f, 1.0f, 6.0f, 3, 2, 2);
        this.tailseg3.setRotationPoint(0.0f, 17.0f, 3.0f);
        this.tailseg3.setTextureSize(128, 128);
        this.tailseg3.mirror = true;
        this.setRotation(this.tailseg3, -0.2230717f, 0.0f, 0.0f);
        this.pincer1 = new ModelRenderer((ModelBase)this, 26, 30);
        this.pincer1.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5);
        this.pincer1.setRotationPoint(-3.0f, 19.0f, -3.0f);
        this.pincer1.setTextureSize(128, 128);
        this.pincer1.mirror = true;
        this.setRotation(this.pincer1, 0.0f, -0.2230717f, 0.0f);
        this.pincer1part2 = new ModelRenderer((ModelBase)this, 26, 30);
        this.pincer1part2.addBox(-0.5f, -0.5f, -5.01f, 2, 1, 0);
        this.pincer1part2.setRotationPoint(-3.0f, 19.0f, -3.0f);
        this.pincer1part2.setTextureSize(128, 128);
        this.pincer1part2.mirror = true;
        this.setRotation(this.pincer1part2, 0.0f, -0.2230717f, 0.0f);
        this.pincer2 = new ModelRenderer((ModelBase)this, 26, 30);
        this.pincer2.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5);
        this.pincer2.setRotationPoint(3.0f, 19.0f, -3.0f);
        this.pincer2.setTextureSize(128, 128);
        this.pincer2.mirror = true;
        this.setRotation(this.pincer2, 0.0f, 0.2230705f, 0.0f);
        this.pincer2part2 = new ModelRenderer((ModelBase)this, 26, 28);
        this.pincer2part2.addBox(-1.5f, -0.5f, -5.01f, 2, 1, 0);
        this.pincer2part2.setRotationPoint(3.0f, 19.0f, -3.0f);
        this.pincer2part2.setTextureSize(128, 128);
        this.pincer2part2.mirror = true;
        this.setRotation(this.pincer2part2, 0.0f, 0.2230705f, 0.0f);
        this.spike1 = new ModelRenderer((ModelBase)this, 26, 13);
        this.spike1.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 6);
        this.spike1.setRotationPoint(-3.0f, 16.0f, -2.0f);
        this.spike1.setTextureSize(128, 128);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, 0.7063936f, -0.2602503f, 0.0f);
        this.spike2 = new ModelRenderer((ModelBase)this, 26, 13);
        this.spike2.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 6);
        this.spike2.setRotationPoint(-1.0f, 16.0f, 1.0f);
        this.spike2.setTextureSize(128, 128);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, 0.7063936f, -0.111544f, 0.0f);
        this.spike3 = new ModelRenderer((ModelBase)this, 26, 13);
        this.spike3.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 6);
        this.spike3.setRotationPoint(1.0f, 16.0f, 1.0f);
        this.spike3.setTextureSize(128, 128);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, 0.7063936f, 0.1115358f, 0.0f);
        this.spike4 = new ModelRenderer((ModelBase)this, 26, 13);
        this.spike4.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 6);
        this.spike4.setRotationPoint(3.0f, 16.0f, -2.0f);
        this.spike4.setTextureSize(128, 128);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, 0.7063936f, 0.260246f, 0.0f);
        this.spike5 = new ModelRenderer((ModelBase)this, 26, 13);
        this.spike5.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 6);
        this.spike5.setRotationPoint(0.0f, 16.0f, -3.0f);
        this.spike5.setTextureSize(128, 128);
        this.spike5.mirror = true;
        this.setRotation(this.spike5, 0.7063936f, 0.0f, 0.0f);
        this.insides1 = new ModelRenderer((ModelBase)this, 0, 30);
        this.insides1.addBox(-2.0f, -3.0f, -3.0f, 4, 4, 0);
        this.insides1.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.insides1.setTextureSize(128, 128);
        this.insides1.mirror = true;
        this.setRotation(this.insides1, 0.0f, 0.0f, 0.0f);
        this.insides2 = new ModelRenderer((ModelBase)this, -1, 29);
        this.insides2.addBox(-2.0f, -3.0f, -4.0f, 4, 0, 1);
        this.insides2.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.insides2.setTextureSize(128, 128);
        this.insides2.mirror = true;
        this.setRotation(this.insides2, 0.0f, 0.0f, 0.0f);
        this.insides3 = new ModelRenderer((ModelBase)this, -1, 29);
        this.insides3.addBox(-2.0f, 1.0f, -4.0f, 4, 0, 1);
        this.insides3.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.insides3.setTextureSize(128, 128);
        this.insides3.mirror = true;
        this.setRotation(this.insides3, 0.0f, 0.0f, 0.0f);
        this.insides4 = new ModelRenderer((ModelBase)this, 0, 29);
        this.insides4.addBox(-2.0f, -3.0f, -4.0f, 0, 4, 1);
        this.insides4.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.insides4.setTextureSize(128, 128);
        this.insides4.mirror = true;
        this.setRotation(this.insides4, 0.0f, 0.0f, 0.0f);
        this.insides5 = new ModelRenderer((ModelBase)this, 0, 29);
        this.insides5.addBox(2.0f, -3.0f, -4.0f, 0, 4, 1);
        this.insides5.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.insides5.setTextureSize(128, 128);
        this.insides5.mirror = true;
        this.setRotation(this.insides5, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.cos((float)(f2 * 1.25f)) * 3.1415927f * 0.35f * f1;
        this.leg1part2.rotateAngleY = this.leg1.rotateAngleY = 0.576f + newangle;
        this.leg2part2.rotateAngleY = this.leg2.rotateAngleY = -0.576f - newangle;
        this.leg3part2.rotateAngleY = this.leg3.rotateAngleY = -0.576f - newangle;
        this.leg4part2.rotateAngleY = this.leg4.rotateAngleY = 0.576f + newangle;
        this.pincer1.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 0.48f)) * 3.1415927f * 0.15f;
        this.pincer1part2.rotateAngleY = newangle;
        this.pincer2.rotateAngleY = - newangle;
        this.pincer2part2.rotateAngleY = - newangle;
        newangle = MathHelper.cos((float)(f2 * 0.11f)) * 3.1415927f * 0.25f;
        newangle = Math.abs(newangle);
        this.tailseg1.rotateAngleX = -0.55f + newangle;
        this.tailseg3.rotateAngleX = -0.22f + newangle;
        this.tailseg2.rotateAngleX = newangle;
        newangle = MathHelper.cos((float)(f2 * 0.81f)) * 3.1415927f * 0.08f;
        this.spike1.rotateAngleX = 0.7f + newangle;
        newangle = MathHelper.cos((float)(f2 * 0.87f)) * 3.1415927f * 0.08f;
        this.spike2.rotateAngleX = 0.7f + newangle;
        newangle = MathHelper.cos((float)(f2 * 0.99f)) * 3.1415927f * 0.08f;
        this.spike3.rotateAngleX = 0.7f + newangle;
        newangle = MathHelper.cos((float)(f2 * 0.103f)) * 3.1415927f * 0.08f;
        this.spike4.rotateAngleX = 0.7f + newangle;
        newangle = MathHelper.cos((float)(f2 * 0.107f)) * 3.1415927f * 0.08f;
        this.spike5.rotateAngleX = 0.7f + newangle;
        this.spike1.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.11f)) * 3.1415927f * 0.08f;
        this.spike2.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.17f)) * 3.1415927f * 0.08f;
        this.spike3.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.25f)) * 3.1415927f * 0.08f;
        this.spike4.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.28f)) * 3.1415927f * 0.08f;
        this.spike5.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.31f)) * 3.1415927f * 0.08f;
        this.spike1.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.41f)) * 3.1415927f * 0.08f;
        this.spike2.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.47f)) * 3.1415927f * 0.08f;
        this.spike3.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.55f)) * 3.1415927f * 0.08f;
        this.spike4.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.58f)) * 3.1415927f * 0.08f;
        this.spike5.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.61f)) * 3.1415927f * 0.08f;
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg1part2.render(f5);
        this.leg2.render(f5);
        this.leg2part2.render(f5);
        this.leg3.render(f5);
        this.leg3part2.render(f5);
        this.leg4.render(f5);
        this.leg4part2.render(f5);
        this.tailseg1.render(f5);
        this.tailseg2.render(f5);
        this.tailseg3.render(f5);
        this.pincer1.render(f5);
        this.pincer1part2.render(f5);
        this.pincer2.render(f5);
        this.pincer2part2.render(f5);
        this.spike1.render(f5);
        this.spike2.render(f5);
        this.spike3.render(f5);
        this.spike4.render(f5);
        this.spike5.render(f5);
        this.insides1.render(f5);
        this.insides2.render(f5);
        this.insides3.render(f5);
        this.insides4.render(f5);
        this.insides5.render(f5);
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

