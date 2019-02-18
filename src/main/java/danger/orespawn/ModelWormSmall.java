/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelWormSmall
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

public class ModelWormSmall
extends ModelBase {
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tail;

    public ModelWormSmall() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.head.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 6, 0);
        this.body.addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.body.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 12, 0);
        this.tail.addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.tail.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float newangle;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.tail.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.55f)) * 3.1415927f * 0.15f;
        float d1 = (float)(Math.sin(newangle) * 5.0);
        float d2 = (float)(Math.cos(newangle) * 5.0);
        this.body.rotationPointZ = this.tail.rotationPointZ - d1;
        this.tail.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.35f)) * 3.1415927f * 0.1f;
        float d3 = (float)(Math.cos(newangle) * (double)d2);
        float d4 = (float)(Math.sin(newangle) * (double)d2);
        this.body.rotationPointX = this.tail.rotationPointX + d4;
        this.body.rotationPointY = (float)((double)this.tail.rotationPointY - 5.0 + (5.0 - (double)d3));
        this.body.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.45f)) * 3.1415927f * 0.15f;
        d1 = (float)(Math.sin(newangle) * 5.0);
        d2 = (float)(Math.cos(newangle) * 5.0);
        this.head.rotationPointZ = this.body.rotationPointZ - d1;
        this.body.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 0.25f)) * 3.1415927f * 0.1f;
        d3 = (float)(Math.cos(newangle) * (double)d2);
        d4 = (float)(Math.sin(newangle) * (double)d2);
        this.head.rotationPointX = this.body.rotationPointX + d4;
        this.head.rotationPointY = (float)((double)this.body.rotationPointY - 5.0 + (5.0 - (double)d3));
        this.head.rotateAngleX = 0.62f + MathHelper.cos((float)(f2 * 0.65f)) * 3.1415927f * 0.15f;
        this.head.rotateAngleZ = MathHelper.cos((float)(f2 * 0.3f)) * 3.1415927f * 0.05f;
        this.head.render(f5);
        this.body.render(f5);
        this.tail.render(f5);
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

