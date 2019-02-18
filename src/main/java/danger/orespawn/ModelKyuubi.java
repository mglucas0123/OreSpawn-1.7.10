/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Kyuubi
 *  danger.orespawn.ModelKyuubi
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.Kyuubi;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelKyuubi
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer rtHorn5;
    ModelRenderer lfHorn5;
    ModelRenderer tail9;
    ModelRenderer tail8;
    ModelRenderer tail7;
    ModelRenderer tail6;
    ModelRenderer tail5;
    ModelRenderer tail2;
    ModelRenderer tail1;
    ModelRenderer tail0;
    ModelRenderer lfLegLower;
    ModelRenderer rtLegLower;
    ModelRenderer head;
    ModelRenderer chest;
    ModelRenderer lfArmUpper;
    ModelRenderer rtArmLower;
    ModelRenderer lfLegUpper;
    ModelRenderer rtLegUpper;
    ModelRenderer body;
    ModelRenderer rtArmUpper;
    ModelRenderer lfArmLower;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer lfHorn2;
    ModelRenderer rtHorn1;
    ModelRenderer rtHorn2;
    ModelRenderer lfHorn1;
    ModelRenderer lfHorn3;
    ModelRenderer rtHorn3;
    ModelRenderer lfHorn4;
    ModelRenderer rtHorn4;
    ModelRenderer headFire;
    ModelRenderer lfArmUpperFire;
    ModelRenderer chestFire;
    ModelRenderer bodyFire;
    ModelRenderer lfArmLowerFire;
    ModelRenderer rtArmUpperFire;
    ModelRenderer rtArmLowerFire;
    ModelRenderer lfLegUppperFire;
    ModelRenderer lfLegLowerFire;
    ModelRenderer rtLegUpperFire;
    ModelRenderer rtLegLowerFire;

    public ModelKyuubi(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 256;
        this.rtHorn5 = new ModelRenderer((ModelBase)this, 56, 8);
        this.rtHorn5.addBox(-0.5f, -0.5f, -2.0f, 1, 1, 2);
        this.rtHorn5.setRotationPoint(3.0f, -11.5f, -7.0f);
        this.rtHorn5.setTextureSize(512, 256);
        this.rtHorn5.mirror = false;
        this.setRotation(this.rtHorn5, -0.4461433f, 0.0f, 0.0f);
        this.lfHorn5 = new ModelRenderer((ModelBase)this, 56, 24);
        this.lfHorn5.addBox(-0.5f, -0.5f, -2.0f, 1, 1, 2);
        this.lfHorn5.setRotationPoint(-3.0f, -11.5f, -7.0f);
        this.lfHorn5.setTextureSize(512, 256);
        this.lfHorn5.mirror = false;
        this.setRotation(this.lfHorn5, -0.4461433f, 0.0f, 0.0f);
        this.tail9 = new ModelRenderer((ModelBase)this, 145, 47);
        this.tail9.addBox(-0.5f, -0.5f, -1.0f, 1, 1, 1);
        this.tail9.setRotationPoint(0.0f, 9.0f, -26.0f);
        this.tail9.setTextureSize(512, 256);
        this.tail9.mirror = false;
        this.setRotation(this.tail9, 2.007645f, 0.0f, 0.0f);
        this.tail8 = new ModelRenderer((ModelBase)this, 135, 45);
        this.tail8.addBox(-1.0f, -1.0f, -2.0f, 2, 2, 2);
        this.tail8.setRotationPoint(0.0f, 7.0f, -25.75f);
        this.tail8.setTextureSize(512, 256);
        this.tail8.mirror = false;
        this.setRotation(this.tail8, 1.524323f, 0.0f, 0.0f);
        this.tail7 = new ModelRenderer((ModelBase)this, 122, 44);
        this.tail7.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.tail7.setRotationPoint(0.0f, 5.0f, -24.0f);
        this.tail7.setTextureSize(512, 256);
        this.tail7.mirror = false;
        this.setRotation(this.tail7, 0.8922867f, 0.0f, 0.0f);
        this.tail6 = new ModelRenderer((ModelBase)this, 105, 43);
        this.tail6.addBox(-2.0f, -2.0f, -4.0f, 4, 4, 4);
        this.tail6.setRotationPoint(0.0f, 3.0f, -21.0f);
        this.tail6.setTextureSize(512, 256);
        this.tail6.mirror = false;
        this.setRotation(this.tail6, 0.6320364f, 0.0f, 0.0f);
        this.tail5 = new ModelRenderer((ModelBase)this, 84, 42);
        this.tail5.addBox(-2.5f, -2.5f, -5.0f, 5, 5, 5);
        this.tail5.setRotationPoint(0.0f, 2.0f, -17.0f);
        this.tail5.setTextureSize(512, 256);
        this.tail5.mirror = false;
        this.setRotation(this.tail5, 0.2230717f, 0.0f, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 20, 43);
        this.tail2.addBox(-2.0f, -2.0f, -5.0f, 4, 4, 5);
        this.tail2.setRotationPoint(0.0f, 10.0f, -7.0f);
        this.tail2.setTextureSize(512, 256);
        this.tail2.mirror = false;
        this.setRotation(this.tail2, -0.7807508f, 0.0f, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 9, 36);
        this.tail1.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.tail1.setRotationPoint(0.0f, 10.0f, -4.333333f);
        this.tail1.setTextureSize(512, 256);
        this.tail1.mirror = false;
        this.setRotation(this.tail1, -0.2602503f, 0.0f, 0.0f);
        this.tail0 = new ModelRenderer((ModelBase)this, 0, 46);
        this.tail0.addBox(-1.0f, -1.0f, -3.0f, 4, 4, 3);
        this.tail0.setRotationPoint(-1.0f, 9.0f, -2.0f);
        this.tail0.setTextureSize(512, 256);
        this.tail0.mirror = false;
        this.setRotation(this.tail0, 0.0f, 0.0f, 0.0f);
        this.lfLegLower = new ModelRenderer((ModelBase)this, 205, 55);
        this.lfLegLower.addBox(-2.0f, 0.0f, -3.0f, 4, 6, 4);
        this.lfLegLower.setRotationPoint(-3.0f, 18.0f, 2.0f);
        this.lfLegLower.setTextureSize(512, 256);
        this.lfLegLower.mirror = false;
        this.setRotation(this.lfLegLower, -0.4461433f, 0.0f, 0.0f);
        this.rtLegLower = new ModelRenderer((ModelBase)this, 149, 53);
        this.rtLegLower.addBox(-2.0f, -1.0f, -3.0f, 4, 7, 4);
        this.rtLegLower.setRotationPoint(3.0f, 18.0f, 4.0f);
        this.rtLegLower.setTextureSize(512, 256);
        this.rtLegLower.mirror = false;
        this.setRotation(this.rtLegLower, -0.1487144f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 168, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.head.setRotationPoint(0.0f, 0.0f, 6.0f);
        this.head.setTextureSize(512, 256);
        this.head.mirror = false;
        this.setRotation(this.head, 0.2230705f, 3.141593f, 0.0f);
        this.chest = new ModelRenderer((ModelBase)this, 170, 17);
        this.chest.addBox(-4.0f, 0.0f, -2.0f, 8, 7, 6);
        this.chest.setRotationPoint(0.0f, 0.0f, 5.0f);
        this.chest.setTextureSize(512, 256);
        this.chest.mirror = false;
        this.setRotation(this.chest, -0.8551081f, 0.0f, 0.0f);
        this.lfArmUpper = new ModelRenderer((ModelBase)this, 205, 16);
        this.lfArmUpper.addBox(-3.0f, -2.0f, -2.0f, 4, 7, 4);
        this.lfArmUpper.setRotationPoint(-5.0f, 2.0f, 3.0f);
        this.lfArmUpper.setTextureSize(512, 256);
        this.lfArmUpper.mirror = false;
        this.setRotation(this.lfArmUpper, 0.0f, 0.0f, 0.3020292f);
        this.rtArmLower = new ModelRenderer((ModelBase)this, 136, 29);
        this.rtArmLower.addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
        this.rtArmLower.setRotationPoint(7.0f, 6.0f, 2.0f);
        this.rtArmLower.setTextureSize(512, 256);
        this.rtArmLower.mirror = false;
        this.setRotation(this.rtArmLower, 0.4833219f, 0.0f, 0.0f);
        this.lfLegUpper = new ModelRenderer((ModelBase)this, 188, 46);
        this.lfLegUpper.addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
        this.lfLegUpper.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.lfLegUpper.setTextureSize(512, 256);
        this.lfLegUpper.mirror = false;
        this.setRotation(this.lfLegUpper, 0.260246f, 0.0f, 0.2602503f);
        this.rtLegUpper = new ModelRenderer((ModelBase)this, 168, 46);
        this.rtLegUpper.addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
        this.rtLegUpper.setRotationPoint(2.0f, 12.0f, 0.0f);
        this.rtLegUpper.setTextureSize(512, 256);
        this.rtLegUpper.mirror = false;
        this.setRotation(this.rtLegUpper, 0.5948578f, 0.0f, -0.260246f);
        this.body = new ModelRenderer((ModelBase)this, 170, 31);
        this.body.addBox(-4.0f, 0.0f, -3.0f, 8, 7, 6);
        this.body.setRotationPoint(0.0f, 5.0f, 1.0f);
        this.body.setTextureSize(512, 256);
        this.body.mirror = false;
        this.setRotation(this.body, -0.2974289f, 0.0f, 0.0f);
        this.rtArmUpper = new ModelRenderer((ModelBase)this, 142, 16);
        this.rtArmUpper.addBox(-1.0f, -2.0f, -2.0f, 4, 7, 4);
        this.rtArmUpper.setRotationPoint(5.0f, 2.0f, 2.0f);
        this.rtArmUpper.setTextureSize(512, 256);
        this.rtArmUpper.mirror = false;
        this.setRotation(this.rtArmUpper, 0.0f, 0.0f, -0.302028f);
        this.lfArmLower = new ModelRenderer((ModelBase)this, 208, 31);
        this.lfArmLower.addBox(-2.0f, 0.0f, -2.0f, 4, 7, 4);
        this.lfArmLower.setRotationPoint(-7.0f, 6.0f, 2.0f);
        this.lfArmLower.setTextureSize(512, 256);
        this.lfArmLower.mirror = false;
        this.setRotation(this.lfArmLower, 0.4833219f, 0.0f, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 38, 42);
        this.tail3.addBox(-2.5f, -2.0f, -5.0f, 5, 5, 5);
        this.tail3.setRotationPoint(0.0f, 6.5f, -10.0f);
        this.tail3.setTextureSize(512, 256);
        this.tail3.mirror = false;
        this.setRotation(this.tail3, -0.96f, 0.0f, 0.0f);
        this.tail4 = new ModelRenderer((ModelBase)this, 59, 41);
        this.tail4.addBox(-3.0f, -3.0f, -6.0f, 6, 6, 6);
        this.tail4.setRotationPoint(0.0f, 3.0f, -12.0f);
        this.tail4.setTextureSize(512, 256);
        this.tail4.mirror = false;
        this.setRotation(this.tail4, -0.22f, 0.0f, 0.0f);
        this.lfHorn2 = new ModelRenderer((ModelBase)this, 13, 5);
        this.lfHorn2.addBox(-2.0f, -2.0f, -4.0f, 4, 4, 4);
        this.lfHorn2.setRotationPoint(-3.0f, -10.0f, 2.0f);
        this.lfHorn2.setTextureSize(512, 256);
        this.lfHorn2.mirror = false;
        this.setRotation(this.lfHorn2, -0.2230705f, 0.0f, 0.0f);
        this.rtHorn1 = new ModelRenderer((ModelBase)this, 0, 22);
        this.rtHorn1.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.rtHorn1.setRotationPoint(3.0f, -8.7f, 4.0f);
        this.rtHorn1.setTextureSize(512, 256);
        this.rtHorn1.mirror = false;
        this.setRotation(this.rtHorn1, -0.5576792f, 0.0f, 0.0f);
        this.rtHorn2 = new ModelRenderer((ModelBase)this, 13, 21);
        this.rtHorn2.addBox(-2.0f, -2.0f, -4.0f, 4, 4, 4);
        this.rtHorn2.setRotationPoint(3.0f, -10.0f, 2.0f);
        this.rtHorn2.setTextureSize(512, 256);
        this.rtHorn2.mirror = false;
        this.setRotation(this.rtHorn2, -0.2230705f, 0.0f, 0.0f);
        this.lfHorn1 = new ModelRenderer((ModelBase)this, 0, 6);
        this.lfHorn1.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.lfHorn1.setRotationPoint(-3.0f, -8.7f, 4.0f);
        this.lfHorn1.setTextureSize(512, 256);
        this.lfHorn1.mirror = false;
        this.setRotation(this.lfHorn1, -0.5576792f, 0.0f, 0.0f);
        this.lfHorn3 = new ModelRenderer((ModelBase)this, 31, 6);
        this.lfHorn3.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.lfHorn3.setRotationPoint(-3.0f, -11.0f, -2.0f);
        this.lfHorn3.setTextureSize(512, 256);
        this.lfHorn3.mirror = false;
        this.setRotation(this.lfHorn3, -0.0371786f, 0.0f, 0.0f);
        this.rtHorn3 = new ModelRenderer((ModelBase)this, 31, 22);
        this.rtHorn3.addBox(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.rtHorn3.setRotationPoint(3.0f, -11.0f, -2.0f);
        this.rtHorn3.setTextureSize(512, 256);
        this.rtHorn3.mirror = false;
        this.setRotation(this.rtHorn3, -0.0371786f, 0.0f, 0.0f);
        this.lfHorn4 = new ModelRenderer((ModelBase)this, 45, 23);
        this.lfHorn4.addBox(-1.0f, -1.0f, -2.0f, 2, 2, 2);
        this.lfHorn4.setRotationPoint(-3.0f, -11.0f, -5.0f);
        this.lfHorn4.setTextureSize(512, 256);
        this.lfHorn4.mirror = false;
        this.setRotation(this.lfHorn4, -0.2230717f, 0.0f, 0.0f);
        this.rtHorn4 = new ModelRenderer((ModelBase)this, 45, 7);
        this.rtHorn4.addBox(-1.0f, -1.0f, -2.0f, 2, 2, 2);
        this.rtHorn4.setRotationPoint(3.0f, -11.0f, -5.0f);
        this.rtHorn4.setTextureSize(512, 256);
        this.rtHorn4.mirror = false;
        this.setRotation(this.rtHorn4, -0.2230717f, 0.0f, 0.0f);
        this.headFire = new ModelRenderer((ModelBase)this, 168, 84);
        this.headFire.addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10);
        this.headFire.setRotationPoint(0.0f, 1.0f, 6.0f);
        this.headFire.setTextureSize(512, 256);
        this.headFire.mirror = false;
        this.setRotation(this.headFire, -0.2230717f, 0.0f, 0.0f);
        this.lfArmUpperFire = new ModelRenderer((ModelBase)this, 209, 108);
        this.lfArmUpperFire.addBox(-6.0f, -1.0f, -3.0f, 6, 9, 6);
        this.lfArmUpperFire.setRotationPoint(-3.0f, 1.0f, 3.0f);
        this.lfArmUpperFire.setTextureSize(512, 256);
        this.lfArmUpperFire.mirror = false;
        this.setRotation(this.lfArmUpperFire, 0.0f, 0.0f, 0.3020292f);
        this.chestFire = new ModelRenderer((ModelBase)this, 170, 105);
        this.chestFire.addBox(-5.0f, 0.0f, -3.0f, 10, 9, 8);
        this.chestFire.setRotationPoint(0.0f, -1.0f, 6.0f);
        this.chestFire.setTextureSize(512, 256);
        this.chestFire.mirror = false;
        this.setRotation(this.chestFire, -0.8551081f, 0.0f, 0.0f);
        this.bodyFire = new ModelRenderer((ModelBase)this, 170, 125);
        this.bodyFire.addBox(-5.0f, 0.0f, -4.0f, 10, 9, 8);
        this.bodyFire.setRotationPoint(0.0f, 4.0f, 1.0f);
        this.bodyFire.setTextureSize(512, 256);
        this.bodyFire.mirror = false;
        this.setRotation(this.bodyFire, -0.2974289f, 0.0f, 0.0f);
        this.lfArmLowerFire = new ModelRenderer((ModelBase)this, 208, 126);
        this.lfArmLowerFire.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6);
        this.lfArmLowerFire.setRotationPoint(-7.333333f, 5.0f, 1.5f);
        this.lfArmLowerFire.setTextureSize(512, 256);
        this.lfArmLowerFire.mirror = false;
        this.setRotation(this.lfArmLowerFire, 0.4833219f, 0.0f, 0.0f);
        this.rtArmUpperFire = new ModelRenderer((ModelBase)this, 142, 105);
        this.rtArmUpperFire.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6);
        this.rtArmUpperFire.setRotationPoint(5.0f, -1.0f, 2.0f);
        this.rtArmUpperFire.setTextureSize(512, 256);
        this.rtArmUpperFire.mirror = false;
        this.setRotation(this.rtArmUpperFire, 0.0f, 0.0f, -0.302028f);
        this.rtArmLowerFire = new ModelRenderer((ModelBase)this, 136, 122);
        this.rtArmLowerFire.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6);
        this.rtArmLowerFire.setRotationPoint(7.0f, 5.0f, 1.0f);
        this.rtArmLowerFire.setTextureSize(512, 256);
        this.rtArmLowerFire.mirror = false;
        this.setRotation(this.rtArmLowerFire, 0.4833219f, 0.0f, 0.0f);
        this.lfLegUppperFire = new ModelRenderer((ModelBase)this, 188, 146);
        this.lfLegUppperFire.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6);
        this.lfLegUppperFire.setRotationPoint(-2.0f, 11.0f, 0.0f);
        this.lfLegUppperFire.setTextureSize(512, 256);
        this.lfLegUppperFire.mirror = false;
        this.setRotation(this.lfLegUppperFire, 0.260246f, 0.0f, 0.2602503f);
        this.lfLegLowerFire = new ModelRenderer((ModelBase)this, 205, 163);
        this.lfLegLowerFire.addBox(-3.0f, 0.0f, -3.0f, 6, 8, 6);
        this.lfLegLowerFire.setRotationPoint(-3.0f, 16.0f, 2.0f);
        this.lfLegLowerFire.setTextureSize(512, 256);
        this.lfLegLowerFire.mirror = false;
        this.setRotation(this.lfLegLowerFire, -0.4461433f, 0.0f, 0.0f);
        this.rtLegUpperFire = new ModelRenderer((ModelBase)this, 160, 146);
        this.rtLegUpperFire.addBox(-3.0f, 0.0f, -4.0f, 6, 9, 6);
        this.rtLegUpperFire.setRotationPoint(2.0f, 11.0f, 0.0f);
        this.rtLegUpperFire.setTextureSize(512, 256);
        this.rtLegUpperFire.mirror = false;
        this.setRotation(this.rtLegUpperFire, 0.5948578f, 0.0f, -0.260246f);
        this.rtLegLowerFire = new ModelRenderer((ModelBase)this, 150, 167);
        this.rtLegLowerFire.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6);
        this.rtLegLowerFire.setRotationPoint(3.0f, 15.0f, 4.0f);
        this.rtLegLowerFire.setTextureSize(512, 256);
        this.rtLegLowerFire.mirror = false;
        this.setRotation(this.rtLegLowerFire, -0.1487144f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Kyuubi e = (Kyuubi)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = (double)f1 > 0.1 ? MathHelper.cos((float)(f2 * 1.1f * this.wingspeed)) * 3.1415927f * 0.2f * f1 : 0.0f;
        this.rtLegUpper.rotateAngleX = 0.59f + newangle;
        this.rtLegUpperFire.rotateAngleX = 0.59f + newangle;
        this.rtLegLower.rotateAngleX = -0.15f + newangle;
        this.rtLegLowerFire.rotateAngleX = -0.15f + newangle;
        this.rtLegLower.rotationPointZ = (float)(Math.sin(this.rtLegUpperFire.rotateAngleX) * 8.0);
        this.rtLegLowerFire.rotationPointZ = (float)(Math.sin(this.rtLegUpperFire.rotateAngleX) * 8.0);
        this.lfLegUpper.rotateAngleX = 0.26f - newangle;
        this.lfLegUppperFire.rotateAngleX = 0.26f - newangle;
        this.lfLegLower.rotateAngleX = -0.44f - newangle;
        this.lfLegLowerFire.rotateAngleX = -0.44f - newangle;
        this.lfLegLower.rotationPointZ = (float)(Math.sin(this.lfLegUppperFire.rotateAngleX) * 8.0);
        this.lfLegLowerFire.rotationPointZ = (float)(Math.sin(this.lfLegUppperFire.rotateAngleX) * 8.0);
        newangle = MathHelper.cos((float)(f2 * 1.1f * this.wingspeed)) * 3.1415927f * 0.08f * f1;
        this.rtArmUpper.rotateAngleX = newangle += MathHelper.cos((float)(f2 * 0.5f * this.wingspeed)) * 3.1415927f * 0.01f;
        this.rtArmUpperFire.rotateAngleX = newangle;
        this.rtArmLower.rotateAngleX = 0.48f + newangle;
        this.rtArmLowerFire.rotateAngleX = 0.48f + newangle;
        this.rtArmLower.rotationPointZ = (float)(Math.sin(this.rtArmUpperFire.rotateAngleX) * 8.0);
        this.rtArmLowerFire.rotationPointZ = (float)(Math.sin(this.rtArmUpperFire.rotateAngleX) * 8.0);
        this.lfArmUpper.rotateAngleX = - newangle;
        this.lfArmUpperFire.rotateAngleX = - newangle;
        this.lfArmLower.rotateAngleX = 0.48f - newangle;
        this.lfArmLowerFire.rotateAngleX = 0.48f - newangle;
        this.lfArmLower.rotationPointZ = (float)(Math.sin(this.lfArmUpperFire.rotateAngleX) * 8.0);
        this.lfArmLowerFire.rotationPointZ = (float)(Math.sin(this.lfArmUpperFire.rotateAngleX) * 8.0);
        float pi4 = 0.7853975f;
        this.head.rotateAngleY = (float)Math.toRadians(f3) + pi4 * 4.0f;
        this.headFire.rotateAngleY = (float)Math.toRadians(f3);
        float fc = (float)Math.cos(this.headFire.rotateAngleY + pi4);
        float fs = (float)Math.sin(this.headFire.rotateAngleY + pi4);
        this.lfHorn1.rotationPointZ = this.headFire.rotationPointZ - fc * 3.6f;
        this.lfHorn1.rotationPointX = this.headFire.rotationPointX - fs * 3.6f;
        this.lfHorn1.rotateAngleY = this.headFire.rotateAngleY + 0.244f + MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.lfHorn2.rotationPointZ = this.lfHorn1.rotationPointZ - (float)Math.cos(this.lfHorn1.rotateAngleY) * 2.0f;
        this.lfHorn2.rotationPointX = this.lfHorn1.rotationPointX - (float)Math.sin(this.lfHorn1.rotateAngleY) * 2.0f;
        this.lfHorn2.rotateAngleY = this.headFire.rotateAngleY + 0.244f + MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - pi4)) * 3.1415927f * 0.1f;
        this.lfHorn3.rotationPointZ = this.lfHorn2.rotationPointZ - (float)Math.cos(this.lfHorn2.rotateAngleY) * 4.0f;
        this.lfHorn3.rotationPointX = this.lfHorn2.rotationPointX - (float)Math.sin(this.lfHorn2.rotateAngleY) * 4.0f;
        this.lfHorn3.rotateAngleY = this.headFire.rotateAngleY + 0.244f + MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 2.0f * pi4)) * 3.1415927f * 0.1f;
        this.lfHorn4.rotationPointZ = this.lfHorn3.rotationPointZ - (float)Math.cos(this.lfHorn3.rotateAngleY) * 3.0f;
        this.lfHorn4.rotationPointX = this.lfHorn3.rotationPointX - (float)Math.sin(this.lfHorn3.rotateAngleY) * 3.0f;
        this.lfHorn4.rotateAngleY = this.headFire.rotateAngleY + 0.244f + MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 3.0f * pi4)) * 3.1415927f * 0.1f;
        this.lfHorn5.rotationPointZ = this.lfHorn4.rotationPointZ - (float)Math.cos(this.lfHorn4.rotateAngleY) * 2.0f;
        this.lfHorn5.rotationPointX = this.lfHorn4.rotationPointX - (float)Math.sin(this.lfHorn4.rotateAngleY) * 2.0f;
        this.lfHorn5.rotateAngleY = this.headFire.rotateAngleY + 0.244f + MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 4.0f * pi4)) * 3.1415927f * 0.1f;
        fc = (float)Math.cos(this.headFire.rotateAngleY - pi4);
        fs = (float)Math.sin(this.headFire.rotateAngleY - pi4);
        this.rtHorn1.rotationPointZ = this.headFire.rotationPointZ - fc * 3.6f;
        this.rtHorn1.rotationPointX = this.headFire.rotationPointX - fs * 3.6f;
        this.rtHorn1.rotateAngleY = this.headFire.rotateAngleY + -0.244f - MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.rtHorn2.rotationPointZ = this.rtHorn1.rotationPointZ - (float)Math.cos(this.rtHorn1.rotateAngleY) * 2.0f;
        this.rtHorn2.rotationPointX = this.rtHorn1.rotationPointX - (float)Math.sin(this.rtHorn1.rotateAngleY) * 2.0f;
        this.rtHorn2.rotateAngleY = this.headFire.rotateAngleY + -0.244f - MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - pi4)) * 3.1415927f * 0.1f;
        this.rtHorn3.rotationPointZ = this.rtHorn2.rotationPointZ - (float)Math.cos(this.rtHorn2.rotateAngleY) * 4.0f;
        this.rtHorn3.rotationPointX = this.rtHorn2.rotationPointX - (float)Math.sin(this.rtHorn2.rotateAngleY) * 4.0f;
        this.rtHorn3.rotateAngleY = this.headFire.rotateAngleY + -0.244f - MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 2.0f * pi4)) * 3.1415927f * 0.1f;
        this.rtHorn4.rotationPointZ = this.rtHorn3.rotationPointZ - (float)Math.cos(this.rtHorn3.rotateAngleY) * 3.0f;
        this.rtHorn4.rotationPointX = this.rtHorn3.rotationPointX - (float)Math.sin(this.rtHorn3.rotateAngleY) * 3.0f;
        this.rtHorn4.rotateAngleY = this.headFire.rotateAngleY + -0.244f - MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 3.0f * pi4)) * 3.1415927f * 0.1f;
        this.rtHorn5.rotationPointZ = this.rtHorn4.rotationPointZ - (float)Math.cos(this.rtHorn4.rotateAngleY) * 2.0f;
        this.rtHorn5.rotationPointX = this.rtHorn4.rotationPointX - (float)Math.sin(this.rtHorn4.rotateAngleY) * 2.0f;
        this.rtHorn5.rotateAngleY = this.headFire.rotateAngleY + -0.244f - MathHelper.cos((float)(f2 * 1.3f * this.wingspeed - 4.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail1.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed)) * 3.1415927f * 0.2f;
        this.tail2.rotationPointX = this.tail1.rotationPointX - (float)Math.sin(this.tail1.rotateAngleY) * 3.0f;
        this.tail2.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - pi4)) * 3.1415927f * 0.2f;
        this.tail3.rotationPointX = this.tail2.rotationPointX - (float)Math.sin(this.tail2.rotateAngleY) * 4.0f;
        this.tail3.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 2.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail4.rotationPointX = this.tail3.rotationPointX - (float)Math.sin(this.tail3.rotateAngleY) * 3.5f;
        this.tail4.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 3.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail5.rotationPointX = this.tail4.rotationPointX - (float)Math.sin(this.tail4.rotateAngleY) * 5.0f;
        this.tail5.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 4.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail6.rotationPointX = this.tail5.rotationPointX - (float)Math.sin(this.tail5.rotateAngleY) * 4.0f;
        this.tail6.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 5.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail7.rotationPointX = this.tail6.rotationPointX - (float)Math.sin(this.tail6.rotateAngleY) * 3.0f;
        this.tail7.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 6.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail8.rotationPointX = this.tail7.rotationPointX - (float)Math.sin(this.tail7.rotateAngleY) * 2.0f;
        this.tail8.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 7.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail9.rotationPointX = this.tail8.rotationPointX - (float)Math.sin(this.tail8.rotateAngleY) * 1.0f;
        this.tail9.rotateAngleY = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed - 8.0f * pi4)) * 3.1415927f * 0.2f;
        this.tail1.rotateAngleX = -0.26f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed)) * 3.1415927f * 0.1f;
        this.tail2.rotationPointY = this.tail1.rotationPointY + (float)Math.sin(this.tail1.rotateAngleX) * 3.0f;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ - (float)Math.cos(this.tail1.rotateAngleX) * 3.0f;
        this.tail2.rotateAngleX = -0.78f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - pi4)) * 3.1415927f * 0.1f;
        this.tail3.rotationPointY = this.tail2.rotationPointY + (float)Math.sin(this.tail2.rotateAngleX) * 4.0f;
        this.tail3.rotationPointZ = this.tail2.rotationPointZ - (float)Math.cos(this.tail2.rotateAngleX) * 4.0f;
        this.tail3.rotateAngleX = -1.11f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 2.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail4.rotationPointY = this.tail3.rotationPointY + (float)Math.sin(this.tail3.rotateAngleX) * 3.5f;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ - (float)Math.cos(this.tail3.rotateAngleX) * 3.5f;
        this.tail4.rotateAngleX = -0.18f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 3.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail5.rotationPointY = this.tail4.rotationPointY + (float)Math.sin(this.tail4.rotateAngleX) * 5.0f;
        this.tail5.rotationPointZ = this.tail4.rotationPointZ - (float)Math.cos(this.tail4.rotateAngleX) * 5.0f;
        this.tail5.rotateAngleX = 0.22f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 4.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail6.rotationPointY = this.tail5.rotationPointY + (float)Math.sin(this.tail5.rotateAngleX) * 4.0f;
        this.tail6.rotationPointZ = this.tail5.rotationPointZ - (float)Math.cos(this.tail5.rotateAngleX) * 4.0f;
        this.tail6.rotateAngleX = 0.63f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 5.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail7.rotationPointY = this.tail6.rotationPointY + (float)Math.sin(this.tail6.rotateAngleX) * 3.0f;
        this.tail7.rotationPointZ = this.tail6.rotationPointZ - (float)Math.cos(this.tail6.rotateAngleX) * 3.0f;
        this.tail7.rotateAngleX = 0.89f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 6.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail8.rotationPointY = this.tail7.rotationPointY + (float)Math.sin(this.tail7.rotateAngleX) * 2.0f;
        this.tail8.rotationPointZ = this.tail7.rotationPointZ - (float)Math.cos(this.tail7.rotateAngleX) * 2.0f;
        this.tail8.rotateAngleX = 1.52f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 7.0f * pi4)) * 3.1415927f * 0.1f;
        this.tail9.rotationPointY = this.tail8.rotationPointY + (float)Math.sin(this.tail8.rotateAngleX) * 2.0f;
        this.tail9.rotationPointZ = this.tail8.rotationPointZ - (float)Math.cos(this.tail8.rotateAngleX) * 2.0f;
        this.tail9.rotateAngleX = 2.0f + MathHelper.cos((float)(f2 * 0.5f * this.wingspeed - 8.0f * pi4)) * 3.1415927f * 0.1f;
        GL11.glPushMatrix();
        GL11.glEnable((int)2977);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)0.0f);
        this.lfLegLower.render(f5);
        this.rtLegLower.render(f5);
        this.head.render(f5);
        this.chest.render(f5);
        this.lfArmUpper.render(f5);
        this.rtArmLower.render(f5);
        this.lfLegUpper.render(f5);
        this.rtLegUpper.render(f5);
        this.body.render(f5);
        this.rtArmUpper.render(f5);
        this.lfArmLower.render(f5);
        this.rtHorn5.render(f5);
        this.lfHorn5.render(f5);
        this.tail9.render(f5);
        this.tail8.render(f5);
        this.tail7.render(f5);
        this.tail6.render(f5);
        this.tail5.render(f5);
        this.tail2.render(f5);
        this.tail1.render(f5);
        this.tail0.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
        this.lfHorn2.render(f5);
        this.rtHorn1.render(f5);
        this.rtHorn2.render(f5);
        this.lfHorn1.render(f5);
        this.lfHorn3.render(f5);
        this.rtHorn3.render(f5);
        this.lfHorn4.render(f5);
        this.rtHorn4.render(f5);
        this.headFire.render(f5);
        this.lfArmUpperFire.render(f5);
        this.chestFire.render(f5);
        this.bodyFire.render(f5);
        this.lfArmLowerFire.render(f5);
        this.rtArmUpperFire.render(f5);
        this.rtArmLowerFire.render(f5);
        this.lfLegUppperFire.render(f5);
        this.lfLegLowerFire.render(f5);
        this.rtLegUpperFire.render(f5);
        this.rtLegLowerFire.render(f5);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
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
