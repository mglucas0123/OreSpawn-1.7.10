/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelCloudShark
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

public class ModelCloudShark
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer topfin;
    ModelRenderer bbody;
    ModelRenderer fins;
    ModelRenderer leftfin;
    ModelRenderer rightfin;

    public ModelCloudShark(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(0.0f, 0.0f, 0.0f, 6, 8, 15);
        this.body.setRotationPoint(-4.0f, 11.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 51);
        this.head.addBox(-2.5f, 0.0f, -8.0f, 5, 5, 8);
        this.head.setRotationPoint(-1.0f, 11.0f, 0.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.jaw = new ModelRenderer((ModelBase)this, 42, 0);
        this.jaw.addBox(-2.5f, 0.0f, -6.0f, 5, 2, 6);
        this.jaw.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.jaw.setTextureSize(64, 64);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.5056291f, 0.0f, 0.0f);
        this.topfin = new ModelRenderer((ModelBase)this, 0, 0);
        this.topfin.addBox(0.0f, 0.0f, 0.0f, 1, 3, 6);
        this.topfin.setRotationPoint(-1.5f, 11.0f, 5.0f);
        this.topfin.setTextureSize(64, 64);
        this.topfin.mirror = true;
        this.setRotation(this.topfin, 0.935765f, 0.0f, 0.0f);
        this.bbody = new ModelRenderer((ModelBase)this, 0, 9);
        this.bbody.addBox(-2.0f, 0.0f, 0.0f, 4, 8, 6);
        this.bbody.setRotationPoint(-1.0f, 11.0f, 15.0f);
        this.bbody.setTextureSize(64, 64);
        this.bbody.mirror = true;
        this.setRotation(this.bbody, 0.0f, 0.0f, 0.0f);
        this.fins = new ModelRenderer((ModelBase)this, 0, 24);
        this.fins.addBox(0.0f, 0.0f, 0.0f, 0, 10, 10);
        this.fins.setRotationPoint(-1.0f, 16.0f, 16.0f);
        this.fins.setTextureSize(64, 64);
        this.fins.mirror = true;
        this.setRotation(this.fins, 0.9220296f, 0.0f, 0.0f);
        this.leftfin = new ModelRenderer((ModelBase)this, 0, 0);
        this.leftfin.addBox(0.0f, 0.0f, 0.0f, 0, 3, 7);
        this.leftfin.setRotationPoint(2.0f, 16.0f, 6.0f);
        this.leftfin.setTextureSize(64, 64);
        this.leftfin.mirror = true;
        this.setRotation(this.leftfin, -0.6108652f, 1.134464f, -0.6108652f);
        this.rightfin = new ModelRenderer((ModelBase)this, 0, 0);
        this.rightfin.addBox(0.0f, 0.0f, 0.0f, 0, 3, 7);
        this.rightfin.setRotationPoint(-4.0f, 16.0f, 6.0f);
        this.rightfin.setTextureSize(64, 64);
        this.rightfin.mirror = true;
        this.setRotation(this.rightfin, -0.6283185f, -1.134464f, 0.6108652f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos((float)(f2 * 0.7f * this.wingspeed)) * 3.1415927f * 0.15f;
        this.leftfin.rotateAngleY = 1.15f + newangle;
        newangle = MathHelper.cos((float)(f2 * 1.5f * this.wingspeed)) * 3.1415927f * 0.15f;
        this.rightfin.rotateAngleY = -0.9f + newangle;
        this.fins.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 1.5f * this.wingspeed)) * 3.1415927f * 0.25f;
        newangle = MathHelper.cos((float)(f2 * 0.5f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.jaw.rotateAngleX = 0.5f + newangle;
        this.body.render(f5);
        this.head.render(f5);
        this.jaw.render(f5);
        this.topfin.render(f5);
        this.bbody.render(f5);
        this.fins.render(f5);
        this.leftfin.render(f5);
        this.rightfin.render(f5);
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

