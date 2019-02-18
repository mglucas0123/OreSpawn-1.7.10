/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelElevator
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package danger.orespawn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelElevator
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public ModelElevator() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Shape2 = new ModelRenderer((ModelBase)this, 0, 18);
        this.Shape2.addBox(-3.0f, 0.0f, -9.0f, 6, 1, 1);
        this.Shape2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape2.setTextureSize(64, 64);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new ModelRenderer((ModelBase)this, 0, 21);
        this.Shape3.addBox(-1.0f, 0.0f, -10.0f, 2, 1, 1);
        this.Shape3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape3.setTextureSize(64, 64);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new ModelRenderer((ModelBase)this, 17, 18);
        this.Shape4.addBox(-3.0f, 0.0f, 8.0f, 6, 1, 1);
        this.Shape4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape4.setTextureSize(64, 64);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new ModelRenderer((ModelBase)this, 17, 21);
        this.Shape5.addBox(-1.0f, 0.0f, 9.0f, 2, 1, 1);
        this.Shape5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape5.setTextureSize(64, 64);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Shape1.addBox(-4.0f, 0.0f, -8.0f, 8, 1, 16);
        this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape1.setTextureSize(64, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
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

