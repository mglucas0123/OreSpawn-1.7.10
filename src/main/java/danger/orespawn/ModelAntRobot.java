/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.AntRobot
 *  danger.orespawn.ModelAntRobot
 *  danger.orespawn.RenderSpiderRobotInfo
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.AntRobot;
import danger.orespawn.RenderSpiderRobotInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAntRobot
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Foot3;
    ModelRenderer Foot4;
    ModelRenderer Foot5;
    ModelRenderer Foot6;
    ModelRenderer Foot7;
    ModelRenderer Body;
    ModelRenderer Abdomen;
    ModelRenderer Head;
    ModelRenderer Jet1;
    ModelRenderer Jet2;
    ModelRenderer Hip1;
    ModelRenderer Hip2;
    ModelRenderer LJaw1;
    ModelRenderer RJaw1;
    ModelRenderer LJaw2;
    ModelRenderer RJaw2;
    ModelRenderer LAntenna;
    ModelRenderer RAntenna;
    ModelRenderer Hip3;
    ModelRenderer Hip4;
    ModelRenderer Hip5;
    ModelRenderer Hip6;

    public ModelAntRobot(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 128;
        this.textureHeight = 256;
        this.Leg1 = new ModelRenderer((ModelBase)this, 19, 40);
        this.Leg1.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 50);
        this.Leg1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.7853982f, 0.0f, 0.0f);
        this.Leg2 = new ModelRenderer((ModelBase)this, 19, 41);
        this.Leg2.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 50);
        this.Leg2.setRotationPoint(0.0f, -35.0f, 35.0f);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, 0.0f, 0.0f);
        this.Leg3 = new ModelRenderer((ModelBase)this, 20, 42);
        this.Leg3.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 50);
        this.Leg3.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, -0.7853982f, 0.0f, 0.0f);
        this.Foot1 = new ModelRenderer((ModelBase)this, 28, 0);
        this.Foot1.addBox(-2.5f, -0.5f, 50.0f, 5, 1, 2);
        this.Foot1.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot1.setTextureSize(64, 32);
        this.Foot1.mirror = true;
        this.setRotation(this.Foot1, -0.7853982f, 0.0f, 0.0f);
        this.Foot2 = new ModelRenderer((ModelBase)this, 30, 4);
        this.Foot2.addBox(1.5f, -0.5f, 52.0f, 1, 1, 3);
        this.Foot2.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot2.setTextureSize(64, 32);
        this.Foot2.mirror = true;
        this.setRotation(this.Foot2, -0.7853982f, 0.0f, 0.0f);
        this.Foot3 = new ModelRenderer((ModelBase)this, 44, 0);
        this.Foot3.addBox(-0.5f, -0.5f, 52.0f, 1, 1, 5);
        this.Foot3.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot3.setTextureSize(64, 32);
        this.Foot3.mirror = true;
        this.setRotation(this.Foot3, -0.7853982f, 0.0f, 0.0f);
        this.Foot4 = new ModelRenderer((ModelBase)this, 30, 9);
        this.Foot4.addBox(-2.5f, -0.5f, 52.0f, 1, 1, 3);
        this.Foot4.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot4.setTextureSize(64, 32);
        this.Foot4.mirror = true;
        this.setRotation(this.Foot4, -0.7853982f, 0.0f, 0.0f);
        this.Foot5 = new ModelRenderer((ModelBase)this, 40, 8);
        this.Foot5.addBox(-0.5f, -2.5f, 50.0f, 1, 5, 2);
        this.Foot5.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot5.setTextureSize(64, 32);
        this.Foot5.mirror = true;
        this.setRotation(this.Foot5, -0.7853982f, 0.0f, 0.0f);
        this.Foot6 = new ModelRenderer((ModelBase)this, 48, 9);
        this.Foot6.addBox(-0.5f, -2.5f, 52.0f, 1, 1, 2);
        this.Foot6.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot6.setTextureSize(64, 32);
        this.Foot6.mirror = true;
        this.setRotation(this.Foot6, -0.7853982f, 0.0f, 0.0f);
        this.Foot7 = new ModelRenderer((ModelBase)this, 48, 14);
        this.Foot7.addBox(-0.5f, 1.5f, 52.0f, 1, 1, 2);
        this.Foot7.setRotationPoint(0.0f, -35.0f, 85.0f);
        this.Foot7.setTextureSize(64, 32);
        this.Foot7.mirror = true;
        this.setRotation(this.Foot7, -0.7853982f, 0.0f, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this, 0, 151);
        this.Body.addBox(-11.0f, 0.0f, -16.0f, 22, 14, 32);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        this.Abdomen = new ModelRenderer((ModelBase)this, 0, 199);
        this.Abdomen.addBox(-15.0f, -10.0f, 16.0f, 30, 22, 34);
        this.Abdomen.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Abdomen.setTextureSize(64, 32);
        this.Abdomen.mirror = true;
        this.setRotation(this.Abdomen, 0.0f, 0.0f, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 120);
        this.Head.addBox(-7.0f, 4.0f, -34.0f, 14, 11, 18);
        this.Head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Jet1 = new ModelRenderer((ModelBase)this, 78, 0);
        this.Jet1.addBox(0.0f, 0.0f, 0.0f, 6, 6, 18);
        this.Jet1.setRotationPoint(8.0f, -12.0f, 35.0f);
        this.Jet1.setTextureSize(64, 32);
        this.Jet1.mirror = true;
        this.setRotation(this.Jet1, 0.0f, 0.0f, 0.0f);
        this.Jet2 = new ModelRenderer((ModelBase)this, 78, 0);
        this.Jet2.addBox(0.0f, 0.0f, 0.0f, 6, 6, 18);
        this.Jet2.setRotationPoint(-14.0f, -12.0f, 35.0f);
        this.Jet2.setTextureSize(64, 32);
        this.Jet2.mirror = true;
        this.setRotation(this.Jet2, 0.0f, 0.0f, 0.0f);
        this.Hip1 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip1.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip1.setRotationPoint(11.0f, 9.0f, -3.0f);
        this.Hip1.setTextureSize(128, 256);
        this.Hip1.mirror = true;
        this.setRotation(this.Hip1, 0.0f, 0.0f, 0.0f);
        this.Hip2 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip2.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip2.setRotationPoint(-17.0f, 9.0f, -3.0f);
        this.Hip2.setTextureSize(128, 256);
        this.Hip2.mirror = true;
        this.setRotation(this.Hip2, 0.0f, 0.0f, 0.0f);
        this.LJaw1 = new ModelRenderer((ModelBase)this, 0, 33);
        this.LJaw1.addBox(-2.0f, 0.0f, -2.0f, 17, 1, 4);
        this.LJaw1.setRotationPoint(5.0f, 13.0f, -33.0f);
        this.LJaw1.setTextureSize(128, 256);
        this.LJaw1.mirror = true;
        this.setRotation(this.LJaw1, 0.0f, 0.8901179f, 0.0f);
        this.RJaw1 = new ModelRenderer((ModelBase)this, 0, 33);
        this.RJaw1.addBox(-2.0f, 0.0f, -2.0f, 17, 1, 4);
        this.RJaw1.setRotationPoint(-5.0f, 13.0f, -33.0f);
        this.RJaw1.setTextureSize(128, 256);
        this.RJaw1.mirror = true;
        this.setRotation(this.RJaw1, 0.0f, 2.216568f, 0.0f);
        this.LJaw2 = new ModelRenderer((ModelBase)this, 0, 27);
        this.LJaw2.addBox(12.0f, 0.0f, 5.0f, 17, 1, 3);
        this.LJaw2.setRotationPoint(5.0f, 13.0f, -33.0f);
        this.LJaw2.setTextureSize(128, 256);
        this.LJaw2.mirror = true;
        this.setRotation(this.LJaw2, 0.0f, 1.37881f, 0.0f);
        this.RJaw2 = new ModelRenderer((ModelBase)this, 0, 27);
        this.RJaw2.addBox(12.0f, 0.0f, -8.0f, 17, 1, 3);
        this.RJaw2.setRotationPoint(-5.0f, 13.0f, -33.0f);
        this.RJaw2.setTextureSize(128, 256);
        this.RJaw2.mirror = true;
        this.setRotation(this.RJaw2, 0.0f, 1.745329f, 0.0f);
        this.LAntenna = new ModelRenderer((ModelBase)this, 70, 0);
        this.LAntenna.addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.LAntenna.setRotationPoint(0.0f, 4.0f, -32.0f);
        this.LAntenna.setTextureSize(128, 256);
        this.LAntenna.mirror = true;
        this.setRotation(this.LAntenna, 0.0f, 0.0f, 0.5410521f);
        this.RAntenna = new ModelRenderer((ModelBase)this, 70, 0);
        this.RAntenna.addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.RAntenna.setRotationPoint(0.0f, 4.0f, -32.0f);
        this.RAntenna.setTextureSize(128, 256);
        this.RAntenna.mirror = true;
        this.setRotation(this.RAntenna, 0.0f, 0.0f, -0.5410521f);
        this.Hip3 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip3.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip3.setRotationPoint(-17.0f, 9.0f, 10.0f);
        this.Hip3.setTextureSize(128, 256);
        this.Hip3.mirror = true;
        this.setRotation(this.Hip3, 0.0f, 0.0f, 0.0f);
        this.Hip4 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip4.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip4.setRotationPoint(11.0f, 9.0f, 10.0f);
        this.Hip4.setTextureSize(128, 256);
        this.Hip4.mirror = true;
        this.setRotation(this.Hip4, 0.0f, 0.0f, 0.0f);
        this.Hip5 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip5.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip5.setRotationPoint(11.0f, 9.0f, -16.0f);
        this.Hip5.setTextureSize(128, 256);
        this.Hip5.mirror = true;
        this.setRotation(this.Hip5, 0.0f, 0.0f, 0.0f);
        this.Hip6 = new ModelRenderer((ModelBase)this, 0, 96);
        this.Hip6.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Hip6.setRotationPoint(-17.0f, 9.0f, -16.0f);
        this.Hip6.setTextureSize(128, 256);
        this.Hip6.mirror = true;
        this.setRotation(this.Hip6, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        AntRobot e = (AntRobot)entity;
        RenderSpiderRobotInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderSpiderRobotInfo();
        for (int i = 0; i < 6; ++i) {
            this.Leg2.rotateAngleY = this.Leg3.rotateAngleY = r.ydisplayangle[i];
            this.Leg1.rotateAngleY = this.Leg3.rotateAngleY;
            this.Foot1.rotateAngleY = r.ydisplayangle[i];
            this.Foot2.rotateAngleY = r.ydisplayangle[i];
            this.Foot3.rotateAngleY = r.ydisplayangle[i];
            this.Foot4.rotateAngleY = r.ydisplayangle[i];
            this.Foot5.rotateAngleY = r.ydisplayangle[i];
            this.Foot6.rotateAngleY = r.ydisplayangle[i];
            this.Foot7.rotateAngleY = r.ydisplayangle[i];
            this.Leg1.rotateAngleX = (float)r.p1xangle[i] + r.uddisplayangle[i];
            this.Leg2.rotateAngleX = (float)r.p2xangle[i] + r.uddisplayangle[i];
            this.Foot1.rotateAngleX = this.Leg3.rotateAngleX = (float)r.p3xangle[i] + r.uddisplayangle[i];
            this.Foot2.rotateAngleX = this.Leg3.rotateAngleX;
            this.Foot3.rotateAngleX = this.Leg3.rotateAngleX;
            this.Foot4.rotateAngleX = this.Leg3.rotateAngleX;
            this.Foot5.rotateAngleX = this.Leg3.rotateAngleX;
            this.Foot6.rotateAngleX = this.Leg3.rotateAngleX;
            this.Foot7.rotateAngleX = this.Leg3.rotateAngleX;
            this.Leg1.rotationPointX = (- (float)Math.cos(r.ymid[i])) * r.legoff[i] * 16.0f;
            this.Leg1.rotationPointZ = (float)Math.sin(r.ymid[i]) * r.legoff[i] * 16.0f;
            this.Leg1.rotationPointY = r.yoff[i] * -16.0f;
            this.Leg2.rotationPointY = this.Leg1.rotationPointY - (float)Math.sin(this.Leg1.rotateAngleX) * 49.0f;
            this.Leg2.rotationPointZ = this.Leg1.rotationPointZ + (float)Math.cos(this.Leg1.rotateAngleX) * (float)Math.cos(this.Leg1.rotateAngleY) * 49.0f;
            this.Leg2.rotationPointX = this.Leg1.rotationPointX + (float)Math.cos(this.Leg1.rotateAngleX) * (float)Math.sin(this.Leg1.rotateAngleY) * 49.0f;
            this.Leg3.rotationPointY = this.Leg2.rotationPointY - (float)Math.sin(this.Leg2.rotateAngleX) * 49.0f;
            this.Leg3.rotationPointZ = this.Leg2.rotationPointZ + (float)Math.cos(this.Leg2.rotateAngleX) * (float)Math.cos(this.Leg2.rotateAngleY) * 49.0f;
            this.Foot1.rotationPointX = this.Leg3.rotationPointX = this.Leg2.rotationPointX + (float)Math.cos(this.Leg2.rotateAngleX) * (float)Math.sin(this.Leg2.rotateAngleY) * 49.0f;
            this.Foot1.rotationPointY = this.Leg3.rotationPointY;
            this.Foot1.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot2.rotationPointX = this.Leg3.rotationPointX;
            this.Foot2.rotationPointY = this.Leg3.rotationPointY;
            this.Foot2.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot3.rotationPointX = this.Leg3.rotationPointX;
            this.Foot3.rotationPointY = this.Leg3.rotationPointY;
            this.Foot3.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot4.rotationPointX = this.Leg3.rotationPointX;
            this.Foot4.rotationPointY = this.Leg3.rotationPointY;
            this.Foot4.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot5.rotationPointX = this.Leg3.rotationPointX;
            this.Foot5.rotationPointY = this.Leg3.rotationPointY;
            this.Foot5.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot6.rotationPointX = this.Leg3.rotationPointX;
            this.Foot6.rotationPointY = this.Leg3.rotationPointY;
            this.Foot6.rotationPointZ = this.Leg3.rotationPointZ;
            this.Foot7.rotationPointX = this.Leg3.rotationPointX;
            this.Foot7.rotationPointY = this.Leg3.rotationPointY;
            this.Foot7.rotationPointZ = this.Leg3.rotationPointZ;
            this.Leg1.render(f5);
            this.Leg2.render(f5);
            this.Leg3.render(f5);
            this.Foot1.render(f5);
            this.Foot2.render(f5);
            this.Foot3.render(f5);
            this.Foot4.render(f5);
            this.Foot5.render(f5);
            this.Foot6.render(f5);
            this.Foot7.render(f5);
        }
        if (e.getAttacking() == 0) {
            this.LJaw1.rotateAngleY = 0.89f;
            this.LJaw2.rotateAngleY = 1.378f;
            this.RJaw1.rotateAngleY = 2.216f;
            this.RJaw2.rotateAngleY = 1.745f;
            this.LAntenna.rotateAngleX = MathHelper.cos((float)((float)r.gpcounter * 0.35f)) * 3.1415927f * 0.05f;
            this.LAntenna.rotateAngleZ = 0.54f + MathHelper.cos((float)((float)r.gpcounter * 0.25f)) * 3.1415927f * 0.05f;
            this.RAntenna.rotateAngleX = MathHelper.cos((float)((float)r.gpcounter * 0.3f)) * 3.1415927f * 0.05f;
            this.RAntenna.rotateAngleZ = -0.54f + MathHelper.cos((float)((float)r.gpcounter * 0.45f)) * 3.1415927f * 0.05f;
        } else {
            float newangle = MathHelper.cos((float)((float)r.gpcounter * 0.25f)) * 3.1415927f * 0.22f;
            this.LJaw1.rotateAngleY = newangle + 0.89f;
            this.LJaw2.rotateAngleY = newangle + 1.378f;
            this.RJaw1.rotateAngleY = - newangle + 2.216f;
            this.RJaw2.rotateAngleY = 1.745f - newangle;
            this.LAntenna.rotateAngleX = MathHelper.cos((float)((float)r.gpcounter * 0.45f)) * 3.1415927f * 0.1f;
            this.LAntenna.rotateAngleZ = 0.54f + MathHelper.cos((float)((float)r.gpcounter * 0.35f)) * 3.1415927f * 0.1f;
            this.RAntenna.rotateAngleX = MathHelper.cos((float)((float)r.gpcounter * 0.4f)) * 3.1415927f * 0.1f;
            this.RAntenna.rotateAngleZ = -0.54f + MathHelper.cos((float)((float)r.gpcounter * 0.55f)) * 3.1415927f * 0.1f;
        }
        this.Body.render(f5);
        this.Abdomen.render(f5);
        this.Head.render(f5);
        this.Jet1.render(f5);
        this.Jet2.render(f5);
        this.Hip1.render(f5);
        this.Hip2.render(f5);
        this.Hip3.render(f5);
        this.Hip4.render(f5);
        this.Hip5.render(f5);
        this.Hip6.render(f5);
        this.LJaw1.render(f5);
        this.RJaw1.render(f5);
        this.LJaw2.render(f5);
        this.RJaw2.render(f5);
        this.LAntenna.render(f5);
        this.RAntenna.render(f5);
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

