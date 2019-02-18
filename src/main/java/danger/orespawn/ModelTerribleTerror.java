/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelTerribleTerror
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

public class ModelTerribleTerror
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Horn1;
    ModelRenderer Horn2;
    ModelRenderer Snout;
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer FL11;
    ModelRenderer FL12;
    ModelRenderer FL21;
    ModelRenderer FL22;
    ModelRenderer BL21;
    ModelRenderer BL22;
    ModelRenderer BL11;
    ModelRenderer BL12;

    public ModelTerribleTerror() {
        this.textureWidth = 119;
        this.textureHeight = 72;
        this.Horn1 = new ModelRenderer((ModelBase)this, 90, 0);
        this.Horn1.addBox(1.0f, -4.0f, 0.0f, 0, 2, 2);
        this.Horn1.setRotationPoint(0.0f, 17.0f, -6.0f);
        this.Horn1.setTextureSize(119, 72);
        this.Horn1.mirror = true;
        this.setRotation(this.Horn1, 0.0f, 0.0f, 0.0f);
        this.Horn2 = new ModelRenderer((ModelBase)this, 102, 0);
        this.Horn2.addBox(-1.0f, -4.0f, 0.0f, 0, 2, 2);
        this.Horn2.setRotationPoint(0.0f, 17.0f, -6.0f);
        this.Horn2.setTextureSize(119, 72);
        this.Horn2.mirror = true;
        this.setRotation(this.Horn2, 0.0f, 0.0f, 0.0f);
        this.Snout = new ModelRenderer((ModelBase)this, 64, 0);
        this.Snout.addBox(-2.0f, -1.0f, -4.0f, 4, 1, 4);
        this.Snout.setRotationPoint(0.0f, 17.0f, -6.0f);
        this.Snout.setTextureSize(119, 72);
        this.Snout.mirror = true;
        this.setRotation(this.Snout, 0.0f, 0.0f, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 41, 0);
        this.Head.addBox(-2.0f, -2.0f, -2.0f, 4, 1, 2);
        this.Head.setRotationPoint(0.0f, 17.0f, -6.0f);
        this.Head.setTextureSize(119, 72);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Jaw = new ModelRenderer((ModelBase)this, 42, 5);
        this.Jaw.addBox(-2.0f, 0.0f, -4.0f, 4, 1, 4);
        this.Jaw.setRotationPoint(0.0f, 17.0f, -6.0f);
        this.Jaw.setTextureSize(119, 72);
        this.Jaw.mirror = true;
        this.setRotation(this.Jaw, 0.0f, 0.0f, 0.0f);
        this.Neck = new ModelRenderer((ModelBase)this, 30, 0);
        this.Neck.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.Neck.setRotationPoint(-1.0f, 18.0f, -2.0f);
        this.Neck.setTextureSize(119, 72);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, -2.082002f, 0.0f, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this, 38, 16);
        this.Body.addBox(0.0f, 0.0f, 0.0f, 2, 3, 10);
        this.Body.setRotationPoint(-1.0f, 17.0f, -4.0f);
        this.Body.setTextureSize(119, 72);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        this.Wing1 = new ModelRenderer((ModelBase)this, 36, 37);
        this.Wing1.addBox(0.0f, 0.0f, 0.0f, 0, 11, 15);
        this.Wing1.setRotationPoint(0.0f, 18.0f, -1.0f);
        this.Wing1.setTextureSize(119, 72);
        this.Wing1.mirror = true;
        this.setRotation(this.Wing1, -0.3490659f, 0.0f, -2.356194f);
        this.Wing2 = new ModelRenderer((ModelBase)this, 0, 37);
        this.Wing2.addBox(0.0f, 0.0f, 0.0f, 0, 11, 15);
        this.Wing2.setRotationPoint(0.0f, 18.0f, -1.0f);
        this.Wing2.setTextureSize(119, 72);
        this.Wing2.mirror = true;
        this.setRotation(this.Wing2, -0.3490659f, 0.0f, 2.356194f);
        this.Tail1 = new ModelRenderer((ModelBase)this, 14, 0);
        this.Tail1.addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Tail1.setRotationPoint(-0.5f, 17.0f, 6.0f);
        this.Tail1.setTextureSize(119, 72);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, -0.5235988f, 0.0f, 0.0f);
        this.Tail2 = new ModelRenderer((ModelBase)this, 14, 8);
        this.Tail2.addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Tail2.setRotationPoint(-0.5f, 20.0f, 11.0f);
        this.Tail2.setTextureSize(119, 72);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.Tail3 = new ModelRenderer((ModelBase)this, 17, 16);
        this.Tail3.addBox(0.0f, 0.0f, 0.0f, 1, 1, 4);
        this.Tail3.setRotationPoint(-0.5f, 20.0f, 17.0f);
        this.Tail3.setTextureSize(119, 72);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, -0.6320364f, 0.0f);
        this.Tail4 = new ModelRenderer((ModelBase)this, 16, 23);
        this.Tail4.addBox(-1.0f, 0.5f, 4.0f, 3, 0, 2);
        this.Tail4.setRotationPoint(-0.5f, 20.0f, 17.0f);
        this.Tail4.setTextureSize(119, 72);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, -0.6320364f, 0.0f);
        this.FL11 = new ModelRenderer((ModelBase)this, 0, 9);
        this.FL11.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.FL11.setRotationPoint(-2.0f, 19.0f, -4.0f);
        this.FL11.setTextureSize(119, 72);
        this.FL11.mirror = true;
        this.setRotation(this.FL11, 0.3490659f, 0.0f, 0.1745329f);
        this.FL12 = new ModelRenderer((ModelBase)this, 0, 13);
        this.FL12.addBox(-0.5f, 1.0f, 1.0f, 1, 2, 1);
        this.FL12.setRotationPoint(-2.0f, 19.0f, -4.0f);
        this.FL12.setTextureSize(119, 72);
        this.FL12.mirror = true;
        this.setRotation(this.FL12, -0.2617994f, 0.0f, 0.0f);
        this.FL21 = new ModelRenderer((ModelBase)this, 5, 9);
        this.FL21.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.FL21.setRotationPoint(1.0f, 19.0f, -4.0f);
        this.FL21.setTextureSize(119, 72);
        this.FL21.mirror = true;
        this.setRotation(this.FL21, 0.3490659f, 0.0f, -0.1745329f);
        this.FL22 = new ModelRenderer((ModelBase)this, 5, 13);
        this.FL22.addBox(0.5f, 1.0f, 1.0f, 1, 2, 1);
        this.FL22.setRotationPoint(1.0f, 19.0f, -4.0f);
        this.FL22.setTextureSize(119, 72);
        this.FL22.mirror = true;
        this.setRotation(this.FL22, -0.2617994f, 0.0f, 0.0f);
        this.BL21 = new ModelRenderer((ModelBase)this, 0, 18);
        this.BL21.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.BL21.setRotationPoint(1.0f, 18.0f, 4.0f);
        this.BL21.setTextureSize(119, 72);
        this.BL21.mirror = true;
        this.setRotation(this.BL21, -0.3490659f, 0.0f, -0.1745329f);
        this.BL22 = new ModelRenderer((ModelBase)this, 0, 22);
        this.BL22.addBox(0.5f, 2.0f, -1.0f, 1, 2, 1);
        this.BL22.setRotationPoint(1.0f, 18.0f, 4.0f);
        this.BL22.setTextureSize(119, 72);
        this.BL22.mirror = true;
        this.setRotation(this.BL22, 0.1745329f, 0.0f, 0.0f);
        this.BL11 = new ModelRenderer((ModelBase)this, 5, 18);
        this.BL11.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.BL11.setRotationPoint(-2.0f, 18.0f, 4.0f);
        this.BL11.setTextureSize(119, 72);
        this.BL11.mirror = true;
        this.setRotation(this.BL11, -0.3490659f, 0.0f, 0.1745329f);
        this.BL12 = new ModelRenderer((ModelBase)this, 5, 22);
        this.BL12.addBox(-0.5f, 2.0f, -1.0f, 1, 2, 1);
        this.BL12.setRotationPoint(-2.0f, 18.0f, 4.0f);
        this.BL12.setTextureSize(119, 72);
        this.BL12.mirror = true;
        this.setRotation(this.BL12, 0.1745329f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.25f;
        this.Wing1.rotateAngleZ = -2.0f + newangle;
        this.Wing2.rotateAngleZ = 2.0f - newangle;
        newangle = MathHelper.cos((float)(f2 * 0.3f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.Jaw.rotateAngleX = Math.abs(newangle);
        newangle = MathHelper.cos((float)(f2 * 1.25f)) * 3.1415927f * 0.35f;
        this.FL21.rotateAngleX = 0.349f + newangle;
        this.FL22.rotateAngleX = -0.296f + newangle;
        this.BL21.rotateAngleX = -0.349f - newangle;
        this.BL22.rotateAngleX = 0.174f - newangle;
        this.FL11.rotateAngleX = 0.349f - newangle;
        this.FL12.rotateAngleX = -0.296f - newangle;
        this.BL11.rotateAngleX = -0.349f + newangle;
        this.BL12.rotateAngleX = 0.174f + newangle;
        this.Tail1.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.71f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.Tail1.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 0.77f * this.wingspeed)) * 3.1415927f * 0.1f;
        float dist = 6.0f;
        dist = (float)((double)dist * Math.cos(this.Tail1.rotateAngleX));
        this.Tail2.rotationPointY = (float)((double)this.Tail1.rotationPointY - Math.sin(this.Tail1.rotateAngleX) * (double)dist);
        this.Tail2.rotationPointX = (float)((double)this.Tail1.rotationPointX + Math.sin(this.Tail1.rotateAngleY) * (double)dist);
        this.Tail2.rotateAngleX = newangle = MathHelper.cos((float)(f2 * 0.81f * this.wingspeed)) * 3.1415927f * 0.15f;
        this.Tail2.rotateAngleY = newangle = MathHelper.cos((float)(f2 * 0.87f * this.wingspeed)) * 3.1415927f * 0.15f;
        dist = 6.0f;
        dist = (float)((double)dist * Math.cos(this.Tail2.rotateAngleX));
        this.Tail3.rotationPointY = this.Tail4.rotationPointY = (float)((double)this.Tail2.rotationPointY - Math.sin(this.Tail2.rotateAngleX) * (double)dist);
        this.Tail3.rotationPointX = this.Tail4.rotationPointX = (float)((double)this.Tail2.rotationPointX + Math.sin(this.Tail2.rotateAngleY) * (double)dist);
        this.Tail3.rotateAngleX = this.Tail4.rotateAngleX = (newangle = MathHelper.cos((float)(f2 * 0.91f * this.wingspeed)) * 3.1415927f * 0.2f);
        this.Tail3.rotateAngleY = this.Tail4.rotateAngleY = (newangle = MathHelper.cos((float)(f2 * 0.97f * this.wingspeed)) * 3.1415927f * 0.2f);
        this.Horn1.render(f5);
        this.Horn2.render(f5);
        this.Snout.render(f5);
        this.Head.render(f5);
        this.Jaw.render(f5);
        this.Neck.render(f5);
        this.Body.render(f5);
        this.Wing1.render(f5);
        this.Wing2.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Tail4.render(f5);
        this.FL11.render(f5);
        this.FL12.render(f5);
        this.FL21.render(f5);
        this.FL22.render(f5);
        this.BL21.render(f5);
        this.BL22.render(f5);
        this.BL11.render(f5);
        this.BL12.render(f5);
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

