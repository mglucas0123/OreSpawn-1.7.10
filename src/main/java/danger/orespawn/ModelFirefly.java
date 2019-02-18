/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Firefly
 *  danger.orespawn.ModelFirefly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.Firefly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelFirefly
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer wing_left;
    ModelRenderer wing_right;
    ModelRenderer head;
    ModelRenderer mouth;
    ModelRenderer eye_left;
    ModelRenderer eye_right;
    ModelRenderer front_leg_left_;
    ModelRenderer front_leg_right;
    ModelRenderer back_leg_left;
    ModelRenderer back_leg_right;
    ModelRenderer TailLight;

    public ModelFirefly(float f1) {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.wingspeed = f1;
        this.body = new ModelRenderer((ModelBase)this, 38, 12);
        this.body.addBox(-3.0f, -3.0f, -3.0f, 5, 5, 5);
        this.body.setRotationPoint(-1.0f, 9.0f, -1.0f);
        this.body.setTextureSize(64, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.wing_left = new ModelRenderer((ModelBase)this, 46, 0);
        this.wing_left.addBox(0.0f, -6.0f, 0.0f, 0, 6, 2);
        this.wing_left.setRotationPoint(1.0f, 6.0f, -2.0f);
        this.wing_left.setTextureSize(64, 128);
        this.wing_left.mirror = true;
        this.setRotation(this.wing_left, 0.0f, 0.0174533f, 0.6981317f);
        this.wing_right = new ModelRenderer((ModelBase)this, 53, 0);
        this.wing_right.addBox(0.0f, -6.0f, 0.0f, 0, 6, 2);
        this.wing_right.setRotationPoint(-4.0f, 6.0f, -2.0f);
        this.wing_right.setTextureSize(64, 128);
        this.wing_right.mirror = true;
        this.setRotation(this.wing_right, 0.0f, 0.0f, -0.6981317f);
        this.head = new ModelRenderer((ModelBase)this, 3, 14);
        this.head.addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.head.setRotationPoint(-3.0f, 7.0f, -7.0f);
        this.head.setTextureSize(64, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.2230717f, 0.0f, 0.0f);
        this.mouth = new ModelRenderer((ModelBase)this, 26, 15);
        this.mouth.addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.mouth.setRotationPoint(-2.0f, 9.0f, -8.0f);
        this.mouth.setTextureSize(64, 128);
        this.mouth.mirror = true;
        this.setRotation(this.mouth, 0.2117115f, 0.0f, 0.0f);
        this.eye_left = new ModelRenderer((ModelBase)this, 18, 12);
        this.eye_left.addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.eye_left.setRotationPoint(-1.0f, 6.5f, -6.0f);
        this.eye_left.setTextureSize(64, 128);
        this.eye_left.mirror = true;
        this.setRotation(this.eye_left, 0.0174533f, 0.2602503f, -0.2230717f);
        this.eye_right = new ModelRenderer((ModelBase)this, 18, 18);
        this.eye_right.addBox(1.0f, -0.6f, -0.6f, 1, 2, 2);
        this.eye_right.setRotationPoint(-4.0f, 6.5f, -6.0f);
        this.eye_right.setTextureSize(64, 128);
        this.eye_right.mirror = true;
        this.setRotation(this.eye_right, 0.0f, -0.2602503f, 0.2230717f);
        this.front_leg_left_ = new ModelRenderer((ModelBase)this, 32, 0);
        this.front_leg_left_.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.front_leg_left_.setRotationPoint(-1.0f, 10.0f, -3.0f);
        this.front_leg_left_.setTextureSize(64, 128);
        this.front_leg_left_.mirror = true;
        this.setRotation(this.front_leg_left_, -0.2792527f, 0.0f, -0.2792527f);
        this.front_leg_right = new ModelRenderer((ModelBase)this, 22, 0);
        this.front_leg_right.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.front_leg_right.setRotationPoint(-3.0f, 10.0f, -3.0f);
        this.front_leg_right.setTextureSize(64, 128);
        this.front_leg_right.mirror = true;
        this.setRotation(this.front_leg_right, -0.2792527f, 0.0f, 0.2792527f);
        this.back_leg_left = new ModelRenderer((ModelBase)this, 11, 0);
        this.back_leg_left.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.back_leg_left.setRotationPoint(-1.0f, 10.0f, -1.0f);
        this.back_leg_left.setTextureSize(64, 128);
        this.back_leg_left.mirror = true;
        this.setRotation(this.back_leg_left, 0.2792527f, 0.0f, -0.2792527f);
        this.back_leg_right = new ModelRenderer((ModelBase)this, 2, 0);
        this.back_leg_right.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.back_leg_right.setRotationPoint(-3.0f, 10.0f, -1.0f);
        this.back_leg_right.setTextureSize(64, 128);
        this.back_leg_right.mirror = true;
        this.setRotation(this.back_leg_right, 0.2792527f, 0.0f, 0.2792527f);
        this.TailLight = new ModelRenderer((ModelBase)this, 10, 27);
        this.TailLight.addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.TailLight.setRotationPoint(-3.0f, 6.0f, 1.0f);
        this.TailLight.setTextureSize(64, 128);
        this.TailLight.mirror = true;
        this.setRotation(this.TailLight, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Firefly fly = (Firefly)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float onoff = 0.0f;
        this.wing_left.rotateAngleZ = 1.11f + MathHelper.cos((float)(f2 * this.wingspeed)) * 3.1415927f * 0.35f;
        this.wing_right.rotateAngleZ = -1.11f - MathHelper.cos((float)(f2 * this.wingspeed)) * 3.1415927f * 0.35f;
        this.body.render(f5);
        this.wing_left.render(f5);
        this.wing_right.render(f5);
        this.head.render(f5);
        this.mouth.render(f5);
        this.eye_left.render(f5);
        this.eye_right.render(f5);
        this.front_leg_left_.render(f5);
        this.front_leg_right.render(f5);
        this.back_leg_left.render(f5);
        this.back_leg_right.render(f5);
        onoff = fly.getBlink();
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)onoff, (float)240.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.TailLight.render(f5);
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

