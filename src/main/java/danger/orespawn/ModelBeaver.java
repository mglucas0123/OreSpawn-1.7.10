/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelBeaver
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

public class ModelBeaver
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer teeth;
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer rff;
    ModelRenderer lff;
    ModelRenderer rrf;
    ModelRenderer lrf;

    public ModelBeaver(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 3);
        this.head.addBox(0.0f, 0.0f, 0.0f, 6, 5, 5);
        this.head.setRotationPoint(0.0f, 15.0f, -8.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.nose = new ModelRenderer((ModelBase)this, 6, 0);
        this.nose.addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.nose.setRotationPoint(2.0f, 18.0f, -8.5f);
        this.nose.setTextureSize(64, 32);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        this.teeth = new ModelRenderer((ModelBase)this, 0, 0);
        this.teeth.addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.teeth.setRotationPoint(2.0f, 19.0f, -8.2f);
        this.teeth.setTextureSize(64, 32);
        this.teeth.mirror = true;
        this.setRotation(this.teeth, 0.0f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 13);
        this.body.addBox(0.0f, 0.0f, 0.0f, 8, 8, 10);
        this.body.setRotationPoint(-1.0f, 14.0f, -3.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 22, 0);
        this.tail.addBox(0.0f, -1.0f, 0.0f, 5, 1, 8);
        this.tail.setRotationPoint(0.5f, 21.0f, 7.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        this.rff = new ModelRenderer((ModelBase)this, 22, 9);
        this.rff.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.rff.setRotationPoint(-0.5f, 22.0f, -2.5f);
        this.rff.setTextureSize(64, 32);
        this.rff.mirror = true;
        this.setRotation(this.rff, 0.0f, 0.0f, 0.0f);
        this.lff = new ModelRenderer((ModelBase)this, 22, 9);
        this.lff.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.lff.setRotationPoint(4.5f, 22.0f, -2.5f);
        this.lff.setTextureSize(64, 32);
        this.lff.mirror = true;
        this.setRotation(this.lff, 0.0f, 0.0f, 0.0f);
        this.rrf = new ModelRenderer((ModelBase)this, 22, 9);
        this.rrf.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.rrf.setRotationPoint(-0.5f, 22.0f, 4.5f);
        this.rrf.setTextureSize(64, 32);
        this.rrf.mirror = true;
        this.setRotation(this.rrf, 0.0f, 0.0f, 0.0f);
        this.lrf = new ModelRenderer((ModelBase)this, 22, 9);
        this.lrf.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.lrf.setRotationPoint(4.5f, 22.0f, 4.5f);
        this.lrf.setTextureSize(64, 32);
        this.lrf.mirror = true;
        this.setRotation(this.lrf, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.rff.rotateAngleX = this.lrf.rotateAngleX = (newangle = MathHelper.cos((float)(f2 * 3.7f * this.wingspeed)) * 3.1415927f * 0.45f * f1);
        this.lff.rotateAngleX = this.rrf.rotateAngleX = - newangle;
        this.teeth.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 2.7f * this.wingspeed)) * 3.1415927f * 0.25f;
        this.tail.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.5f * this.wingspeed)) * 3.1415927f * 0.05f;
        this.head.render(f5);
        this.nose.render(f5);
        this.teeth.render(f5);
        this.body.render(f5);
        this.tail.render(f5);
        this.rff.render(f5);
        this.lff.render(f5);
        this.rrf.render(f5);
        this.lrf.render(f5);
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

