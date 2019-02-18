/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelVortex
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package danger.orespawn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVortex
extends ModelBase {
    float wingspeed = 1.0f;
    ModelRenderer Shape1;

    public ModelVortex(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Shape1.addBox(-64.0f, -64.0f, 0.0f, 128, 64, 0);
        this.Shape1.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.Shape1.setTextureSize(256, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
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

