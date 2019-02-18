/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelTshirt
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

public class ModelTshirt
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public ModelTshirt(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 256;
        this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Shape1.addBox(-128.0f, -64.0f, 0.0f, 256, 64, 1);
        this.Shape1.setRotationPoint(0.0f, -128.0f, 0.0f);
        this.Shape1.setTextureSize(512, 256);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new ModelRenderer((ModelBase)this, 0, 64);
        this.Shape2.addBox(-64.0f, 0.0f, 0.0f, 128, 128, 1);
        this.Shape2.setRotationPoint(0.0f, -128.0f, 0.0f);
        this.Shape2.setTextureSize(512, 256);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        this.Shape1.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 0.05f * this.wingspeed)) * 3.1415927f;
        this.Shape2.rotateAngleY = newangle;
        this.Shape1.render(f5);
        this.Shape2.render(f5);
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

