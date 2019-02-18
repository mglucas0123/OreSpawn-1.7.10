/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GiantRobot
 *  danger.orespawn.ModelGiantRobot
 *  danger.orespawn.RenderGiantRobotInfo
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package danger.orespawn;

import danger.orespawn.GiantRobot;
import danger.orespawn.RenderGiantRobotInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGiantRobot
extends ModelBase {
    private float wingspeed = 1.0f;
    private float hipy = 0.0f;
    ModelRenderer Hip;
    ModelRenderer Thigh;
    ModelRenderer Shin;
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Foot3;
    ModelRenderer Thigh2;
    ModelRenderer Thigh3;
    ModelRenderer Back1;
    ModelRenderer Back2;
    ModelRenderer Back3;
    ModelRenderer Shoulders;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Knuckles;

    public ModelGiantRobot(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 512;
        this.Hip = new ModelRenderer((ModelBase)this, 0, 0);
        this.Hip.addBox(-4.0f, -4.0f, -15.0f, 8, 8, 30);
        this.Hip.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Hip.setTextureSize(64, 32);
        this.Hip.mirror = true;
        this.setRotation(this.Hip, 0.0f, 0.0f, 0.0f);
        this.Thigh = new ModelRenderer((ModelBase)this, 0, 115);
        this.Thigh.addBox(-3.0f, -3.0f, -3.0f, 6, 43, 6);
        this.Thigh.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh.setTextureSize(64, 32);
        this.Thigh.mirror = true;
        this.setRotation(this.Thigh, 0.0f, 0.0f, 0.0f);
        this.Shin = new ModelRenderer((ModelBase)this, 0, 167);
        this.Shin.addBox(-3.0f, -3.0f, -3.0f, 6, 43, 6);
        this.Shin.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Shin.setTextureSize(64, 32);
        this.Shin.mirror = true;
        this.setRotation(this.Shin, 0.0f, 0.0f, 0.0f);
        this.Foot1 = new ModelRenderer((ModelBase)this, 0, 282);
        this.Foot1.addBox(-7.0f, 38.0f, -11.0f, 14, 4, 17);
        this.Foot1.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot1.setTextureSize(64, 32);
        this.Foot1.mirror = true;
        this.setRotation(this.Foot1, 0.0f, 0.0f, 0.0f);
        this.Foot2 = new ModelRenderer((ModelBase)this, 0, 246);
        this.Foot2.addBox(-6.0f, 19.0f, -8.0f, 12, 19, 13);
        this.Foot2.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot2.setTextureSize(64, 32);
        this.Foot2.mirror = true;
        this.setRotation(this.Foot2, 0.0f, 0.0f, 0.0f);
        this.Foot3 = new ModelRenderer((ModelBase)this, 0, 219);
        this.Foot3.addBox(-5.0f, 5.0f, -5.0f, 10, 14, 9);
        this.Foot3.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot3.setTextureSize(64, 32);
        this.Foot3.mirror = true;
        this.setRotation(this.Foot3, 0.0f, 0.0f, 0.0f);
        this.Thigh2 = new ModelRenderer((ModelBase)this, 0, 43);
        this.Thigh2.addBox(-7.0f, -8.0f, -7.0f, 14, 24, 14);
        this.Thigh2.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh2.setTextureSize(64, 32);
        this.Thigh2.mirror = true;
        this.setRotation(this.Thigh2, 0.0f, 0.0f, 0.0f);
        this.Thigh3 = new ModelRenderer((ModelBase)this, 0, 84);
        this.Thigh3.addBox(-5.0f, 16.0f, -5.0f, 10, 17, 10);
        this.Thigh3.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh3.setTextureSize(64, 32);
        this.Thigh3.mirror = true;
        this.setRotation(this.Thigh3, 0.0f, 0.0f, 0.0f);
        this.Back1 = new ModelRenderer((ModelBase)this, 125, 138);
        this.Back1.addBox(-4.0f, -20.0f, -4.0f, 8, 24, 8);
        this.Back1.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back1.setTextureSize(64, 32);
        this.Back1.mirror = true;
        this.setRotation(this.Back1, 0.0f, 0.0f, 0.0f);
        this.Back2 = new ModelRenderer((ModelBase)this, 125, 95);
        this.Back2.addBox(-13.0f, -42.0f, -10.0f, 26, 24, 16);
        this.Back2.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back2.setTextureSize(64, 32);
        this.Back2.mirror = true;
        this.setRotation(this.Back2, 0.0f, 0.0f, 0.0f);
        this.Back3 = new ModelRenderer((ModelBase)this, 125, 43);
        this.Back3.addBox(-17.0f, -68.0f, -13.0f, 34, 26, 20);
        this.Back3.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back3.setTextureSize(64, 32);
        this.Back3.mirror = true;
        this.setRotation(this.Back3, 0.0f, 0.0f, 0.0f);
        this.Shoulders = new ModelRenderer((ModelBase)this, 60, 200);
        this.Shoulders.addBox(-22.0f, -64.0f, -4.0f, 44, 8, 8);
        this.Shoulders.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Shoulders.setTextureSize(64, 32);
        this.Shoulders.mirror = true;
        this.setRotation(this.Shoulders, 0.0f, 0.0f, 0.0f);
        this.Neck = new ModelRenderer((ModelBase)this, 125, 29);
        this.Neck.addBox(-4.0f, -70.0f, -4.0f, 8, 2, 8);
        this.Neck.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 127, 0);
        this.Head.addBox(-7.0f, -82.0f, -7.0f, 14, 12, 14);
        this.Head.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Arm1 = new ModelRenderer((ModelBase)this, 77, 250);
        this.Arm1.addBox(-6.0f, -6.0f, -6.0f, 12, 21, 12);
        this.Arm1.setRotationPoint(28.0f, -120.0f, 0.0f);
        this.Arm1.setTextureSize(64, 32);
        this.Arm1.mirror = true;
        this.setRotation(this.Arm1, 0.0f, 0.0f, 0.0f);
        this.Arm2 = new ModelRenderer((ModelBase)this, 73, 300);
        this.Arm2.addBox(-4.0f, 15.0f, -4.0f, 8, 24, 8);
        this.Arm2.setRotationPoint(28.0f, -120.0f, 0.0f);
        this.Arm2.setTextureSize(64, 32);
        this.Arm2.mirror = true;
        this.setRotation(this.Arm2, 0.0f, 0.0f, 0.0f);
        this.Arm3 = new ModelRenderer((ModelBase)this, 61, 350);
        this.Arm3.addBox(-3.0f, -3.0f, -3.0f, 6, 33, 6);
        this.Arm3.setRotationPoint(28.0f, -81.0f, 0.0f);
        this.Arm3.setTextureSize(64, 32);
        this.Arm3.mirror = true;
        this.setRotation(this.Arm3, 0.0f, 0.0f, 0.0f);
        this.Knuckles = new ModelRenderer((ModelBase)this, 56, 400);
        this.Knuckles.addBox(-7.0f, 30.0f, -5.0f, 14, 12, 10);
        this.Knuckles.setRotationPoint(28.0f, -81.0f, 0.0f);
        this.Knuckles.setTextureSize(256, 512);
        this.Knuckles.mirror = true;
        this.setRotation(this.Knuckles, 0.0f, 0.0f, 0.0f);
        this.hipy = this.Hip.rotationPointY;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float b2angle;
        float a2angle;
        GiantRobot e = (GiantRobot)entity;
        RenderGiantRobotInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderGiantRobotInfo();
        float movescale = f1 * 0.65f;
        if (movescale > 1.0f) {
            movescale = 1.0f;
        }
        r.hipxdisplayangle = (float)(Math.cos((- f2) * this.wingspeed) * 3.141592653589793 * 0.10000000149011612 * (double)movescale);
        r.hipydisplayangle = (float)(Math.sin((- f2) * this.wingspeed) * 3.141592653589793 * 0.10000000149011612 * (double)movescale);
        r.thighdisplayangle[0] = (float)(Math.cos((double)((- f2) * this.wingspeed) + 1.5707963267948966) * 3.141592653589793 * 0.15000000596046448 * (double)movescale) - (float)(0.19634954084936207 * (double)movescale);
        r.thighdisplayangle[1] = (float)(Math.cos((double)((- f2) * this.wingspeed) + 3.141592653589793 + 1.5707963267948966) * 3.141592653589793 * 0.15000000596046448 * (double)movescale) - (float)(0.19634954084936207 * (double)movescale);
        r.shindisplayangle[0] = (float)((double)((float)(Math.cos((double)((- f2) * this.wingspeed) + 3.141592653589793) * 3.141592653589793 * 0.20000000298023224 * (double)movescale)) + 0.6283185400806344 * (double)movescale);
        r.shindisplayangle[1] = (float)((double)((float)(Math.cos((- f2) * this.wingspeed) * 3.141592653589793 * 0.20000000298023224 * (double)movescale)) + 0.6283185400806344 * (double)movescale);
        float newangle = (float)(Math.cos((- f2) * this.wingspeed * 2.0f) * (double)movescale);
        this.Hip.rotationPointY = this.hipy + newangle * 4.0f;
        this.Hip.rotateAngleX = r.hipxdisplayangle;
        this.Hip.rotateAngleY = (float)((double)r.hipydisplayangle + 1.5707963267948966);
        this.Hip.render(f5);
        this.Thigh2.rotateAngleX = this.Thigh3.rotateAngleX = r.thighdisplayangle[0];
        this.Thigh.rotateAngleX = this.Thigh3.rotateAngleX;
        this.Thigh2.rotationPointY = this.Thigh3.rotationPointY = this.Hip.rotationPointY - (float)Math.sin(this.Hip.rotateAngleX) * 13.0f;
        this.Thigh.rotationPointY = this.Thigh3.rotationPointY;
        this.Thigh2.rotationPointZ = this.Thigh3.rotationPointZ = this.Hip.rotationPointZ + (float)Math.cos(this.Hip.rotateAngleX) * (float)Math.cos(this.Hip.rotateAngleY) * 13.0f;
        this.Thigh.rotationPointZ = this.Thigh3.rotationPointZ;
        this.Thigh2.rotationPointX = this.Thigh3.rotationPointX = this.Hip.rotationPointX + (float)Math.cos(this.Hip.rotateAngleX) * (float)Math.sin(this.Hip.rotateAngleY) * 13.0f;
        this.Thigh.rotationPointX = this.Thigh3.rotationPointX;
        this.Thigh.render(f5);
        this.Thigh2.render(f5);
        this.Thigh3.render(f5);
        this.Shin.rotateAngleX = r.shindisplayangle[0];
        this.Shin.rotationPointY = this.Thigh.rotationPointY + (float)Math.cos(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointZ = this.Thigh.rotationPointZ + (float)Math.sin(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointX = this.Thigh.rotationPointX;
        this.Shin.render(f5);
        this.Foot2.rotateAngleX = this.Foot3.rotateAngleX = r.shindisplayangle[0];
        this.Foot1.rotateAngleX = this.Foot3.rotateAngleX;
        this.Foot2.rotationPointY = this.Foot3.rotationPointY = this.Shin.rotationPointY;
        this.Foot1.rotationPointY = this.Foot3.rotationPointY;
        this.Foot2.rotationPointZ = this.Foot3.rotationPointZ = this.Shin.rotationPointZ;
        this.Foot1.rotationPointZ = this.Foot3.rotationPointZ;
        this.Foot2.rotationPointX = this.Foot3.rotationPointX = this.Shin.rotationPointX;
        this.Foot1.rotationPointX = this.Foot3.rotationPointX;
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Foot3.render(f5);
        this.Thigh2.rotateAngleX = this.Thigh3.rotateAngleX = r.thighdisplayangle[1];
        this.Thigh.rotateAngleX = this.Thigh3.rotateAngleX;
        this.Thigh2.rotationPointY = this.Thigh3.rotationPointY = this.Hip.rotationPointY + (float)Math.sin(this.Hip.rotateAngleX) * 13.0f;
        this.Thigh.rotationPointY = this.Thigh3.rotationPointY;
        this.Thigh2.rotationPointZ = this.Thigh3.rotationPointZ = this.Hip.rotationPointZ - (float)Math.cos(this.Hip.rotateAngleX) * (float)Math.cos(this.Hip.rotateAngleY) * 13.0f;
        this.Thigh.rotationPointZ = this.Thigh3.rotationPointZ;
        this.Thigh2.rotationPointX = this.Thigh3.rotationPointX = this.Hip.rotationPointX - (float)Math.cos(this.Hip.rotateAngleX) * (float)Math.sin(this.Hip.rotateAngleY) * 13.0f;
        this.Thigh.rotationPointX = this.Thigh3.rotationPointX;
        this.Thigh.render(f5);
        this.Thigh2.render(f5);
        this.Thigh3.render(f5);
        this.Shin.rotateAngleX = r.shindisplayangle[1];
        this.Shin.rotationPointY = this.Thigh.rotationPointY + (float)Math.cos(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointZ = this.Thigh.rotationPointZ + (float)Math.sin(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointX = this.Thigh.rotationPointX;
        this.Shin.render(f5);
        this.Foot2.rotateAngleX = this.Foot3.rotateAngleX = r.shindisplayangle[1];
        this.Foot1.rotateAngleX = this.Foot3.rotateAngleX;
        this.Foot2.rotationPointY = this.Foot3.rotationPointY = this.Shin.rotationPointY;
        this.Foot1.rotationPointY = this.Foot3.rotationPointY;
        this.Foot2.rotationPointZ = this.Foot3.rotationPointZ = this.Shin.rotationPointZ;
        this.Foot1.rotationPointZ = this.Foot3.rotationPointZ;
        this.Foot2.rotationPointX = this.Foot3.rotationPointX = this.Shin.rotationPointX;
        this.Foot1.rotationPointX = this.Foot3.rotationPointX;
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Foot3.render(f5);
        float shoulderangle = - r.hipydisplayangle;
        float a1angle = a2angle = r.thighdisplayangle[1];
        float b1angle = b2angle = r.thighdisplayangle[0];
        if (e.getAttacking() != 0) {
            shoulderangle = (float)(- Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 * 0.20000000298023224);
            a1angle = (float)((double)((float)(Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 / 5.0)) - 0.7853981633974483);
            a2angle = (float)((double)(- a1angle) + 3.141592653589793);
            a1angle = (float)((double)a1angle + 0.6283185307179586);
            a2angle = (float)((double)a2angle + 0.6283185307179586);
            b1angle = (float)((double)((float)(- Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 / 5.0)) - 0.7853981633974483);
            b2angle = (float)((double)(- b1angle) + 3.141592653589793);
            b1angle = (float)((double)b1angle + 0.6283185307179586);
            b2angle = (float)((double)b2angle + 0.6283185307179586);
        }
        this.Back3.rotateAngleY = shoulderangle / 2.0f;
        this.Shoulders.rotateAngleY = shoulderangle;
        this.Arm1.rotationPointY = this.Arm2.rotationPointY = this.Hip.rotationPointY - 60.0f;
        this.Arm1.rotationPointX = this.Arm2.rotationPointX = this.Hip.rotationPointX + 26.0f;
        this.Arm1.rotationPointZ = this.Arm2.rotationPointZ = this.Shoulders.rotationPointZ - (float)Math.sin(this.Shoulders.rotateAngleY) * 26.0f;
        this.Arm1.rotateAngleX = this.Arm2.rotateAngleX = a1angle;
        this.Arm1.render(f5);
        this.Arm2.render(f5);
        this.Arm3.rotateAngleX = this.Knuckles.rotateAngleX = (float)((double)a2angle - 0.19634954084936207);
        this.Arm3.rotationPointY = this.Knuckles.rotationPointY = this.Arm1.rotationPointY + (float)Math.cos(this.Arm1.rotateAngleX) * 41.0f;
        this.Arm3.rotationPointZ = this.Knuckles.rotationPointZ = this.Arm1.rotationPointZ + (float)Math.sin(this.Arm1.rotateAngleX) * 41.0f;
        this.Arm3.rotationPointX = this.Knuckles.rotationPointX = this.Arm1.rotationPointX;
        this.Arm3.render(f5);
        this.Knuckles.render(f5);
        this.Arm1.rotationPointY = this.Arm2.rotationPointY = this.Hip.rotationPointY - 60.0f;
        this.Arm1.rotationPointX = this.Arm2.rotationPointX = this.Hip.rotationPointX - 26.0f;
        this.Arm1.rotationPointZ = this.Arm2.rotationPointZ = this.Shoulders.rotationPointZ + (float)Math.sin(this.Shoulders.rotateAngleY) * 26.0f;
        this.Arm1.rotateAngleX = this.Arm2.rotateAngleX = b1angle;
        this.Arm1.render(f5);
        this.Arm2.render(f5);
        this.Arm3.rotateAngleX = this.Knuckles.rotateAngleX = (float)((double)b2angle - 0.19634954084936207);
        this.Arm3.rotationPointY = this.Knuckles.rotationPointY = this.Arm1.rotationPointY + (float)Math.cos(this.Arm1.rotateAngleX) * 41.0f;
        this.Arm3.rotationPointZ = this.Knuckles.rotationPointZ = this.Arm1.rotationPointZ + (float)Math.sin(this.Arm1.rotateAngleX) * 41.0f;
        this.Arm3.rotationPointX = this.Knuckles.rotationPointX = this.Arm1.rotationPointX;
        this.Arm3.render(f5);
        this.Knuckles.render(f5);
        this.Back2.rotationPointY = this.Back3.rotationPointY = this.Hip.rotationPointY;
        this.Back1.rotationPointY = this.Back3.rotationPointY;
        this.Neck.rotationPointY = this.Head.rotationPointY = this.Hip.rotationPointY;
        this.Shoulders.rotationPointY = this.Head.rotationPointY;
        this.Head.rotateAngleY = (float)Math.toRadians(f3);
        this.Head.rotateAngleX = (float)Math.toRadians(f4) / 3.0f;
        this.Back1.render(f5);
        this.Back2.render(f5);
        this.Back3.render(f5);
        this.Shoulders.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
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

