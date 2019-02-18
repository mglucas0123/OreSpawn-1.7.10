/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelSkate
 *  danger.orespawn.Skate
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.Skate;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSkate
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer tail1;
    ModelRenderer Shape1;

    public ModelSkate(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 13);
        this.body.addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.body.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.7853982f, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tail1.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 11);
        this.tail1.setRotationPoint(0.0f, 22.0f, 3.0f);
        this.tail1.setTextureSize(64, 32);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        this.Shape1 = new ModelRenderer((ModelBase)this, 0, 21);
        this.Shape1.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 4);
        this.Shape1.setRotationPoint(0.0f, 22.0f, 5.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.7853982f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Skate e = (Skate)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = (double)f1 > 0.1 ? MathHelper.cos((float)(f2 * 1.2f)) * 3.1415927f * 0.15f * f1 : MathHelper.cos((float)(f2 * 0.4f)) * 3.1415927f * 0.05f;
        this.Shape1.rotateAngleX = 0.785f + newangle;
        this.body.render(f5);
        this.tail1.render(f5);
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

