/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.LurkingTerror
 *  danger.orespawn.ModelLurkingTerror
 *  danger.orespawn.RenderInfo
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.LurkingTerror;
import danger.orespawn.RenderInfo;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModelLurkingTerror
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg1part2;
    ModelRenderer leg1part3;
    ModelRenderer leg2;
    ModelRenderer leg2part2;
    ModelRenderer leg2part3;
    ModelRenderer leg3;
    ModelRenderer leg3part2;
    ModelRenderer leg3part3;
    ModelRenderer leg4;
    ModelRenderer leg4part2;
    ModelRenderer leg4part3;
    ModelRenderer leg5;
    ModelRenderer leg5part2;
    ModelRenderer leg6;
    ModelRenderer leg6part2;
    ModelRenderer thorax;
    ModelRenderer abdomen;
    ModelRenderer head;
    ModelRenderer jaw1;
    ModelRenderer jaw1part2;
    ModelRenderer jaw1tooth1;
    ModelRenderer jaw1tooth2;
    ModelRenderer jaw1tooth3;
    ModelRenderer jaw1tooth4;
    ModelRenderer jaw1tooth5;
    ModelRenderer jaw1tooth6;
    ModelRenderer jaw2;
    ModelRenderer jaw2part2;
    ModelRenderer jaw2tooth1;
    ModelRenderer jaw2tooth2;
    ModelRenderer jaw2tooth3;
    ModelRenderer jaw2tooth4;
    ModelRenderer jaw2tooth5;
    ModelRenderer jaw2tooth6;
    ModelRenderer jaw3;
    ModelRenderer jaw3part2;
    ModelRenderer jaw3tooth1;
    ModelRenderer jaw3tooth2;
    ModelRenderer jaw3tooth3;
    ModelRenderer jaw3tooth4;
    ModelRenderer jaw3tooth5;
    ModelRenderer jaw3tooth6;
    ModelRenderer jaw4;
    ModelRenderer jaw4part2;
    ModelRenderer jaw4tooth1;
    ModelRenderer jaw4tooth2;
    ModelRenderer jaw4tooth3;
    ModelRenderer jaw4tooth4;
    ModelRenderer jaw4tooth5;
    ModelRenderer jaw4tooth6;
    ModelRenderer tonguepart1;
    ModelRenderer tonguepart2;
    ModelRenderer tonguepart3;
    ModelRenderer wing_1;
    ModelRenderer wing_2;
    ModelRenderer wing_3;
    ModelRenderer wing_4;

    public ModelLurkingTerror() {
        this.textureWidth = 256;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 39, 27);
        this.body.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 12);
        this.body.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.body.setTextureSize(256, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg1.addBox(-15.0f, -1.5f, -1.5f, 16, 3, 3);
        this.leg1.setRotationPoint(-4.0f, 10.0f, -1.0f);
        this.leg1.setTextureSize(256, 64);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0f, -0.5759587f, -0.1919862f);
        this.leg1part2 = new ModelRenderer((ModelBase)this, 58, 0);
        this.leg1part2.addBox(-15.0f, -1.5f, -1.5f, 3, 8, 3);
        this.leg1part2.setRotationPoint(-4.0f, 10.0f, -1.0f);
        this.leg1part2.setTextureSize(256, 64);
        this.leg1part2.mirror = true;
        this.setRotation(this.leg1part2, 0.0f, -0.5759587f, -0.1919862f);
        this.leg1part3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg1part3.addBox(-15.0f, -1.0f, -1.0f, 2, 8, 2);
        this.leg1part3.setRotationPoint(-4.0f, 10.0f, -1.0f);
        this.leg1part3.setTextureSize(256, 64);
        this.leg1part3.mirror = true;
        this.setRotation(this.leg1part3, 0.0f, -0.5759587f, -0.6753082f);
        this.leg2 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg2.addBox(-1.0f, -1.5f, -1.5f, 16, 3, 3);
        this.leg2.setRotationPoint(4.0f, 10.0f, -1.0f);
        this.leg2.setTextureSize(256, 64);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0f, 0.5759587f, 0.1919862f);
        this.leg2part2 = new ModelRenderer((ModelBase)this, 58, 0);
        this.leg2part2.addBox(12.0f, -1.5f, -1.5f, 3, 8, 3);
        this.leg2part2.setRotationPoint(4.0f, 10.0f, -1.0f);
        this.leg2part2.setTextureSize(256, 64);
        this.leg2part2.mirror = true;
        this.setRotation(this.leg2part2, 0.0f, 0.5759587f, 0.1919862f);
        this.leg2part3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg2part3.addBox(13.0f, -1.0f, -1.0f, 2, 8, 2);
        this.leg2part3.setRotationPoint(4.0f, 10.0f, -1.0f);
        this.leg2part3.setTextureSize(256, 64);
        this.leg2part3.mirror = true;
        this.setRotation(this.leg2part3, 0.0f, 0.5759587f, 0.6753028f);
        this.leg3 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg3.addBox(-15.0f, -1.5f, -1.5f, 16, 3, 3);
        this.leg3.setRotationPoint(-4.0f, 10.0f, 1.0f);
        this.leg3.setTextureSize(256, 64);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0f, 0.2792527f, -0.1919862f);
        this.leg3part2 = new ModelRenderer((ModelBase)this, 58, 0);
        this.leg3part2.addBox(-15.0f, -1.5f, -1.5f, 3, 8, 3);
        this.leg3part2.setRotationPoint(-4.0f, 10.0f, 1.0f);
        this.leg3part2.setTextureSize(256, 64);
        this.leg3part2.mirror = true;
        this.setRotation(this.leg3part2, 0.0f, 0.2792527f, -0.1919862f);
        this.leg3part3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg3part3.addBox(-15.0f, -1.0f, -1.0f, 2, 8, 2);
        this.leg3part3.setRotationPoint(-4.0f, 10.0f, 1.0f);
        this.leg3part3.setTextureSize(256, 64);
        this.leg3part3.mirror = true;
        this.setRotation(this.leg3part3, 0.0f, 0.2792527f, -0.6753028f);
        this.leg4 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg4.addBox(-1.0f, -1.5f, -1.5f, 16, 3, 3);
        this.leg4.setRotationPoint(4.0f, 10.0f, 1.0f);
        this.leg4.setTextureSize(256, 64);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0f, -0.2792527f, 0.1919862f);
        this.leg4part2 = new ModelRenderer((ModelBase)this, 58, 0);
        this.leg4part2.addBox(12.0f, -1.5f, -1.5f, 3, 8, 3);
        this.leg4part2.setRotationPoint(4.0f, 10.0f, 1.0f);
        this.leg4part2.setTextureSize(256, 64);
        this.leg4part2.mirror = true;
        this.setRotation(this.leg4part2, 0.0f, -0.2792527f, 0.1919862f);
        this.leg4part3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg4part3.addBox(13.0f, -1.0f, -1.0f, 2, 8, 2);
        this.leg4part3.setRotationPoint(4.0f, 10.0f, 1.0f);
        this.leg4part3.setTextureSize(256, 64);
        this.leg4part3.mirror = true;
        this.setRotation(this.leg4part3, 0.0f, -0.2792527f, 0.6753028f);
        this.leg5 = new ModelRenderer((ModelBase)this, 119, 0);
        this.leg5.addBox(-4.0f, -1.5f, -1.5f, 25, 3, 3);
        this.leg5.setRotationPoint(4.0f, 10.0f, 4.0f);
        this.leg5.setTextureSize(256, 64);
        this.leg5.mirror = true;
        this.setRotation(this.leg5, 0.0f, -1.134359f, 0.3407057f);
        this.leg5part2 = new ModelRenderer((ModelBase)this, 18, 9);
        this.leg5part2.addBox(18.0f, -1.5f, -1.5f, 3, 10, 3);
        this.leg5part2.setRotationPoint(4.0f, 10.0f, 4.0f);
        this.leg5part2.setTextureSize(256, 64);
        this.leg5part2.mirror = true;
        this.setRotation(this.leg5part2, 0.0f, -1.134359f, 0.3407057f);
        this.leg6 = new ModelRenderer((ModelBase)this, 119, 0);
        this.leg6.addBox(-21.0f, -1.5f, -1.5f, 25, 3, 3);
        this.leg6.setRotationPoint(-4.0f, 10.0f, 4.0f);
        this.leg6.setTextureSize(256, 64);
        this.leg6.mirror = true;
        this.setRotation(this.leg6, 0.0f, 1.134359f, -0.3407057f);
        this.leg6part2 = new ModelRenderer((ModelBase)this, 18, 9);
        this.leg6part2.addBox(-21.0f, -1.5f, -1.5f, 3, 10, 3);
        this.leg6part2.setRotationPoint(-4.0f, 10.0f, 4.0f);
        this.leg6part2.setTextureSize(256, 64);
        this.leg6part2.mirror = true;
        this.setRotation(this.leg6part2, 0.0f, 1.134359f, -0.3407057f);
        this.thorax = new ModelRenderer((ModelBase)this, 0, 42);
        this.thorax.addBox(-2.0f, -2.0f, -6.0f, 4, 4, 18);
        this.thorax.setRotationPoint(0.0f, 10.0f, 9.0f);
        this.thorax.setTextureSize(256, 64);
        this.thorax.mirror = true;
        this.setRotation(this.thorax, -0.2602503f, 0.0f, 0.0f);
        this.abdomen = new ModelRenderer((ModelBase)this, 118, 18);
        this.abdomen.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 16);
        this.abdomen.setRotationPoint(0.0f, 13.0f, 20.0f);
        this.abdomen.setTextureSize(256, 64);
        this.abdomen.mirror = true;
        this.setRotation(this.abdomen, 0.0f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 27, 48);
        this.head.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 5);
        this.head.setRotationPoint(0.0f, 10.0f, -8.0f);
        this.head.setTextureSize(256, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.jaw1 = new ModelRenderer((ModelBase)this, 96, 31);
        this.jaw1.addBox(-1.0f, -1.0f, -13.0f, 1, 2, 14);
        this.jaw1.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1.setTextureSize(256, 64);
        this.jaw1.mirror = true;
        this.setRotation(this.jaw1, 0.0f, 0.4089647f, 0.0f);
        this.jaw1part2 = new ModelRenderer((ModelBase)this, 39, 17);
        this.jaw1part2.addBox(-1.1f, -2.0f, -5.0f, 1, 4, 5);
        this.jaw1part2.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1part2.setTextureSize(256, 64);
        this.jaw1part2.mirror = true;
        this.setRotation(this.jaw1part2, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth1 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth1.addBox(0.0f, -0.5f, -13.0f, 1, 1, 1);
        this.jaw1tooth1.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth1.setTextureSize(256, 64);
        this.jaw1tooth1.mirror = true;
        this.setRotation(this.jaw1tooth1, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth2 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth2.addBox(0.0f, -0.5f, -11.0f, 1, 1, 1);
        this.jaw1tooth2.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth2.setTextureSize(256, 64);
        this.jaw1tooth2.mirror = true;
        this.setRotation(this.jaw1tooth2, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth3 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth3.addBox(0.0f, -0.5f, -9.0f, 1, 1, 1);
        this.jaw1tooth3.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth3.setTextureSize(256, 64);
        this.jaw1tooth3.mirror = true;
        this.setRotation(this.jaw1tooth3, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth4 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth4.addBox(0.0f, -0.5f, -7.0f, 1, 1, 1);
        this.jaw1tooth4.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth4.setTextureSize(256, 64);
        this.jaw1tooth4.mirror = true;
        this.setRotation(this.jaw1tooth4, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth5 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth5.addBox(0.0f, -1.5f, -4.5f, 1, 1, 1);
        this.jaw1tooth5.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth5.setTextureSize(256, 64);
        this.jaw1tooth5.mirror = true;
        this.setRotation(this.jaw1tooth5, 0.0f, 0.4089647f, 0.0f);
        this.jaw1tooth6 = new ModelRenderer((ModelBase)this, 39, 27);
        this.jaw1tooth6.addBox(0.0f, 0.5f, -4.5f, 1, 1, 1);
        this.jaw1tooth6.setRotationPoint(-2.0f, 10.0f, -8.0f);
        this.jaw1tooth6.setTextureSize(256, 64);
        this.jaw1tooth6.mirror = true;
        this.setRotation(this.jaw1tooth6, 0.0f, 0.4089647f, 0.0f);
        this.jaw2 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2.addBox(0.0f, -1.0f, -13.0f, 1, 2, 14);
        this.jaw2.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2.setTextureSize(256, 64);
        this.jaw2.mirror = true;
        this.setRotation(this.jaw2, 0.0f, -0.4089656f, 0.0f);
        this.jaw2part2 = new ModelRenderer((ModelBase)this, 39, 7);
        this.jaw2part2.addBox(0.1f, -2.0f, -5.0f, 1, 4, 5);
        this.jaw2part2.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2part2.setTextureSize(256, 64);
        this.jaw2part2.mirror = true;
        this.setRotation(this.jaw2part2, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth1 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth1.addBox(-1.0f, -0.5f, -13.0f, 1, 1, 1);
        this.jaw2tooth1.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth1.setTextureSize(256, 64);
        this.jaw2tooth1.mirror = true;
        this.setRotation(this.jaw2tooth1, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth2 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth2.addBox(-1.0f, -0.5f, -11.0f, 1, 1, 1);
        this.jaw2tooth2.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth2.setTextureSize(256, 64);
        this.jaw2tooth2.mirror = true;
        this.setRotation(this.jaw2tooth2, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth3 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth3.addBox(-1.0f, -0.5f, -9.0f, 1, 1, 1);
        this.jaw2tooth3.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth3.setTextureSize(256, 64);
        this.jaw2tooth3.mirror = true;
        this.setRotation(this.jaw2tooth3, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth4 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth4.addBox(-1.0f, -0.5f, -7.0f, 1, 1, 1);
        this.jaw2tooth4.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth4.setTextureSize(256, 64);
        this.jaw2tooth4.mirror = true;
        this.setRotation(this.jaw2tooth4, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth5 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth5.addBox(-1.0f, -1.5f, -4.5f, 1, 1, 1);
        this.jaw2tooth5.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth5.setTextureSize(256, 64);
        this.jaw2tooth5.mirror = true;
        this.setRotation(this.jaw2tooth5, 0.0f, -0.4089656f, 0.0f);
        this.jaw2tooth6 = new ModelRenderer((ModelBase)this, 96, 48);
        this.jaw2tooth6.addBox(-1.0f, 0.5f, -4.5f, 1, 1, 1);
        this.jaw2tooth6.setRotationPoint(2.0f, 10.0f, -8.0f);
        this.jaw2tooth6.setTextureSize(256, 64);
        this.jaw2tooth6.mirror = true;
        this.setRotation(this.jaw2tooth6, 0.0f, -0.4089656f, 0.0f);
        this.jaw3 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3.addBox(-1.0f, -1.0f, -13.0f, 2, 1, 14);
        this.jaw3.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3.setTextureSize(256, 64);
        this.jaw3.mirror = true;
        this.setRotation(this.jaw3, -0.4089647f, 0.0f, 0.0f);
        this.jaw3part2 = new ModelRenderer((ModelBase)this, 0, 27);
        this.jaw3part2.addBox(-2.0f, -1.0f, -5.0f, 4, 1, 5);
        this.jaw3part2.setRotationPoint(0.0f, 7.9f, -8.0f);
        this.jaw3part2.setTextureSize(256, 64);
        this.jaw3part2.mirror = true;
        this.setRotation(this.jaw3part2, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth1 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth1.addBox(-0.5f, 0.0f, -13.0f, 1, 1, 1);
        this.jaw3tooth1.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth1.setTextureSize(256, 64);
        this.jaw3tooth1.mirror = true;
        this.setRotation(this.jaw3tooth1, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth2 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth2.addBox(-0.5f, 0.0f, -11.0f, 1, 1, 1);
        this.jaw3tooth2.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth2.setTextureSize(256, 64);
        this.jaw3tooth2.mirror = true;
        this.setRotation(this.jaw3tooth2, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth3 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth3.addBox(-0.5f, 0.0f, -9.0f, 1, 1, 1);
        this.jaw3tooth3.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth3.setTextureSize(256, 64);
        this.jaw3tooth3.mirror = true;
        this.setRotation(this.jaw3tooth3, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth4 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth4.addBox(-0.5f, 0.0f, -7.0f, 1, 1, 1);
        this.jaw3tooth4.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth4.setTextureSize(256, 64);
        this.jaw3tooth4.mirror = true;
        this.setRotation(this.jaw3tooth4, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth5 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth5.addBox(-1.5f, 0.0f, -4.5f, 1, 1, 1);
        this.jaw3tooth5.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth5.setTextureSize(256, 64);
        this.jaw3tooth5.mirror = true;
        this.setRotation(this.jaw3tooth5, -0.4089647f, 0.0f, 0.0f);
        this.jaw3tooth6 = new ModelRenderer((ModelBase)this, 95, 16);
        this.jaw3tooth6.addBox(0.5f, 0.0f, -4.5f, 1, 1, 1);
        this.jaw3tooth6.setRotationPoint(0.0f, 8.0f, -8.0f);
        this.jaw3tooth6.setTextureSize(256, 64);
        this.jaw3tooth6.mirror = true;
        this.setRotation(this.jaw3tooth6, -0.4089647f, 0.0f, 0.0f);
        this.jaw4 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4.addBox(-1.0f, 0.0f, -13.0f, 2, 1, 14);
        this.jaw4.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4.setTextureSize(256, 64);
        this.jaw4.mirror = true;
        this.setRotation(this.jaw4, 0.4089656f, 0.0f, 0.0f);
        this.jaw4part2 = new ModelRenderer((ModelBase)this, 0, 20);
        this.jaw4part2.addBox(-2.0f, 0.0f, -5.0f, 4, 1, 5);
        this.jaw4part2.setRotationPoint(0.0f, 12.1f, -8.0f);
        this.jaw4part2.setTextureSize(256, 64);
        this.jaw4part2.mirror = true;
        this.setRotation(this.jaw4part2, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth1 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth1.addBox(-0.5f, -1.0f, -13.0f, 1, 1, 1);
        this.jaw4tooth1.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth1.setTextureSize(256, 64);
        this.jaw4tooth1.mirror = true;
        this.setRotation(this.jaw4tooth1, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth2 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth2.addBox(-0.5f, -1.0f, -11.0f, 1, 1, 1);
        this.jaw4tooth2.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth2.setTextureSize(256, 64);
        this.jaw4tooth2.mirror = true;
        this.setRotation(this.jaw4tooth2, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth3 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth3.addBox(-0.5f, -1.0f, -9.0f, 1, 1, 1);
        this.jaw4tooth3.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth3.setTextureSize(256, 64);
        this.jaw4tooth3.mirror = true;
        this.setRotation(this.jaw4tooth3, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth4 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth4.addBox(-0.5f, -1.0f, -7.0f, 1, 1, 1);
        this.jaw4tooth4.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth4.setTextureSize(256, 64);
        this.jaw4tooth4.mirror = true;
        this.setRotation(this.jaw4tooth4, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth5 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth5.addBox(-1.5f, -1.0f, -4.5f, 1, 1, 1);
        this.jaw4tooth5.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth5.setTextureSize(256, 64);
        this.jaw4tooth5.mirror = true;
        this.setRotation(this.jaw4tooth5, 0.4089656f, 0.0f, 0.0f);
        this.jaw4tooth6 = new ModelRenderer((ModelBase)this, 95, 0);
        this.jaw4tooth6.addBox(0.5f, -1.0f, -4.5f, 1, 1, 1);
        this.jaw4tooth6.setRotationPoint(0.0f, 12.0f, -8.0f);
        this.jaw4tooth6.setTextureSize(256, 64);
        this.jaw4tooth6.mirror = true;
        this.setRotation(this.jaw4tooth6, 0.4089656f, 0.0f, 0.0f);
        this.tonguepart1 = new ModelRenderer((ModelBase)this, 24, 34);
        this.tonguepart1.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5);
        this.tonguepart1.setRotationPoint(1.6f, 9.3f, -15.0f);
        this.tonguepart1.setTextureSize(256, 64);
        this.tonguepart1.mirror = true;
        this.setRotation(this.tonguepart1, 1.041001f, 1.264073f, -1.07818f);
        this.tonguepart2 = new ModelRenderer((ModelBase)this, 0, 46);
        this.tonguepart2.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5);
        this.tonguepart2.setRotationPoint(0.0f, 10.0f, -11.0f);
        this.tonguepart2.setTextureSize(256, 64);
        this.tonguepart2.mirror = true;
        this.setRotation(this.tonguepart2, -0.1858931f, -0.2230717f, 0.669215f);
        this.tonguepart3 = new ModelRenderer((ModelBase)this, 24, 27);
        this.tonguepart3.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5);
        this.tonguepart3.setRotationPoint(0.2f, 11.3f, -19.0f);
        this.tonguepart3.setTextureSize(256, 64);
        this.tonguepart3.mirror = true;
        this.setRotation(this.tonguepart3, -0.2602503f, 0.3717861f, -1.07818f);
        this.wing_1 = new ModelRenderer((ModelBase)this, 108, 42);
        this.wing_1.addBox(-4.0f, 0.0f, 0.0f, 8, 0, 22);
        this.wing_1.setRotationPoint(-2.0f, 6.0f, -5.0f);
        this.wing_1.setTextureSize(256, 64);
        this.wing_1.mirror = true;
        this.setRotation(this.wing_1, 0.5948578f, -0.9294653f, 0.0f);
        this.wing_2 = new ModelRenderer((ModelBase)this, 141, 42);
        this.wing_2.addBox(-4.0f, 0.0f, 0.0f, 8, 0, 22);
        this.wing_2.setRotationPoint(2.0f, 6.0f, -5.0f);
        this.wing_2.setTextureSize(256, 64);
        this.wing_2.mirror = true;
        this.setRotation(this.wing_2, 0.5948606f, 0.9294576f, 0.0f);
        this.wing_3 = new ModelRenderer((ModelBase)this, 64, 27);
        this.wing_3.addBox(-2.0f, 0.0f, 0.0f, 4, 0, 18);
        this.wing_3.setRotationPoint(-2.0f, 6.0f, -1.0f);
        this.wing_3.setTextureSize(256, 64);
        this.wing_3.mirror = true;
        this.setRotation(this.wing_3, 0.3346075f, -0.4089647f, 0.0f);
        this.wing_4 = new ModelRenderer((ModelBase)this, 153, 17);
        this.wing_4.addBox(-2.0f, 0.0f, 0.0f, 4, 0, 18);
        this.wing_4.setRotationPoint(2.0f, 6.0f, -1.0f);
        this.wing_4.setTextureSize(256, 64);
        this.wing_4.mirror = true;
        this.setRotation(this.wing_4, 0.3346075f, 0.4089656f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        LurkingTerror e = (LurkingTerror)entity;
        float newangle = 0.0f;
        float legspeed = 0.7f;
        float mouthspeed = 0.9f;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        newangle = f2 * legspeed * this.wingspeed % 6.2831855f;
        newangle = Math.abs(newangle);
        if (newangle < r.rf1) {
            r.ri1 = 0;
            if (e.worldObj.rand.nextInt(3) == 1) {
                r.ri1 |= 1;
            }
            if (e.worldObj.rand.nextInt(3) == 1) {
                r.ri1 |= 2;
            }
            if (e.worldObj.rand.nextInt(4) == 1) {
                r.ri1 |= 4;
            }
            if (e.worldObj.rand.nextInt(4) == 1) {
                r.ri1 |= 8;
            }
            if (e.worldObj.rand.nextInt(6) == 1) {
                r.ri1 |= 16;
            }
            if (e.worldObj.rand.nextInt(6) == 1) {
                r.ri1 |= 32;
            }
        }
        r.rf1 = newangle;
        newangle = f2 * mouthspeed * this.wingspeed % 6.2831855f;
        if ((newangle = Math.abs(newangle)) < r.rf2) {
            r.ri2 = 0;
            if (e.worldObj.rand.nextInt(20) == 1) {
                r.ri2 |= 1;
            }
            if (e.getAttacking() != 0) {
                r.ri2 = 1;
            }
        }
        r.rf2 = newangle;
        newangle = 0.0f;
        if ((r.ri1 & 1) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.25f;
        }
        this.leg2.rotateAngleZ = this.leg2part2.rotateAngleZ = 0.191f + newangle;
        this.leg2part3.rotateAngleZ = 0.675f + newangle;
        newangle = 0.0f;
        if ((r.ri1 & 2) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.25f;
        }
        this.leg1.rotateAngleZ = this.leg1part2.rotateAngleZ = -0.191f + newangle;
        this.leg1part3.rotateAngleZ = -0.675f + newangle;
        newangle = 0.0f;
        if ((r.ri1 & 4) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.15f;
        }
        this.leg4.rotateAngleZ = this.leg4part2.rotateAngleZ = 0.191f + newangle;
        this.leg4part3.rotateAngleZ = 0.675f + newangle;
        newangle = 0.0f;
        if ((r.ri1 & 8) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.15f;
        }
        this.leg3.rotateAngleZ = this.leg3part2.rotateAngleZ = -0.191f + newangle;
        this.leg3part3.rotateAngleZ = -0.675f + newangle;
        newangle = 0.0f;
        if ((r.ri1 & 16) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.1f;
        }
        this.leg6.rotateAngleZ = this.leg6part2.rotateAngleZ = -0.34f + newangle;
        newangle = 0.0f;
        if ((r.ri1 & 32) != 0) {
            newangle = MathHelper.sin((float)(f2 * legspeed * this.wingspeed)) * 3.1415927f * 0.1f;
        }
        this.leg5.rotateAngleZ = this.leg5part2.rotateAngleZ = 0.34f + newangle;
        newangle = 0.0f;
        if ((r.ri2 & 1) != 0) {
            newangle = MathHelper.sin((float)(f2 * mouthspeed * this.wingspeed)) * 3.1415927f * 0.35f;
            newangle = Math.abs(newangle);
        }
        this.jaw1.rotateAngleY = newangle;
        this.jaw1part2.rotateAngleY = newangle;
        this.jaw1tooth3.rotateAngleY = this.jaw1tooth5.rotateAngleY = newangle;
        this.jaw1tooth1.rotateAngleY = this.jaw1tooth5.rotateAngleY;
        this.jaw1tooth4.rotateAngleY = this.jaw1tooth6.rotateAngleY = newangle;
        this.jaw1tooth2.rotateAngleY = this.jaw1tooth6.rotateAngleY;
        this.jaw2.rotateAngleY = - newangle;
        this.jaw2part2.rotateAngleY = - newangle;
        this.jaw2tooth3.rotateAngleY = this.jaw2tooth5.rotateAngleY = - newangle;
        this.jaw2tooth1.rotateAngleY = this.jaw2tooth5.rotateAngleY;
        this.jaw2tooth4.rotateAngleY = this.jaw2tooth6.rotateAngleY = - newangle;
        this.jaw2tooth2.rotateAngleY = this.jaw2tooth6.rotateAngleY;
        this.jaw3.rotateAngleX = - newangle;
        this.jaw3part2.rotateAngleX = - newangle;
        this.jaw3tooth3.rotateAngleX = this.jaw3tooth5.rotateAngleX = - newangle;
        this.jaw3tooth1.rotateAngleX = this.jaw3tooth5.rotateAngleX;
        this.jaw3tooth4.rotateAngleX = this.jaw3tooth6.rotateAngleX = - newangle;
        this.jaw3tooth2.rotateAngleX = this.jaw3tooth6.rotateAngleX;
        this.jaw4.rotateAngleX = newangle;
        this.jaw4part2.rotateAngleX = newangle;
        this.jaw4tooth3.rotateAngleX = this.jaw4tooth5.rotateAngleX = newangle;
        this.jaw4tooth1.rotateAngleX = this.jaw4tooth5.rotateAngleX;
        this.jaw4tooth4.rotateAngleX = this.jaw4tooth6.rotateAngleX = newangle;
        this.jaw4tooth2.rotateAngleX = this.jaw4tooth6.rotateAngleX;
        this.tonguepart3.rotateAngleX = 0.0f;
        this.tonguepart2.rotateAngleX = 0.0f;
        this.tonguepart1.rotateAngleX = 0.0f;
        this.tonguepart3.rotateAngleY = 0.0f;
        this.tonguepart2.rotateAngleY = 0.0f;
        this.tonguepart1.rotateAngleY = 0.0f;
        this.tonguepart3.rotateAngleZ = 0.0f;
        this.tonguepart2.rotateAngleZ = 0.0f;
        this.tonguepart1.rotateAngleZ = 0.0f;
        this.tonguepart1.rotationPointX = this.tonguepart3.rotationPointX = this.tonguepart2.rotationPointX;
        this.tonguepart1.rotationPointY = this.tonguepart3.rotationPointY = this.tonguepart2.rotationPointY;
        this.tonguepart1.rotationPointZ = this.tonguepart2.rotationPointZ - newangle * 5.0f;
        this.tonguepart3.rotationPointZ = this.tonguepart2.rotationPointZ - newangle * 10.0f;
        this.thorax.rotateAngleX = newangle = MathHelper.sin((float)(f2 * 0.1f * this.wingspeed)) * 3.1415927f * 0.06f;
        this.abdomen.rotationPointY = (float)((double)this.thorax.rotationPointY - Math.sin(newangle) * 14.0);
        newangle = MathHelper.cos((float)(f2 * 1.4f * this.wingspeed)) * 3.1415927f * 0.2f;
        this.wing_1.rotateAngleX = 0.455f + newangle;
        this.wing_2.rotateAngleX = 0.455f + newangle;
        this.wing_3.rotateAngleX = 0.455f - newangle;
        this.wing_4.rotateAngleX = 0.455f - newangle;
        e.setRenderInfo(r);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg1part2.render(f5);
        this.leg1part3.render(f5);
        this.leg2.render(f5);
        this.leg2part2.render(f5);
        this.leg2part3.render(f5);
        this.leg3.render(f5);
        this.leg3part2.render(f5);
        this.leg3part3.render(f5);
        this.leg4.render(f5);
        this.leg4part2.render(f5);
        this.leg4part3.render(f5);
        this.leg5.render(f5);
        this.leg5part2.render(f5);
        this.leg6.render(f5);
        this.leg6part2.render(f5);
        this.thorax.render(f5);
        this.abdomen.render(f5);
        this.head.render(f5);
        this.jaw1.render(f5);
        this.jaw1part2.render(f5);
        this.jaw1tooth1.render(f5);
        this.jaw1tooth2.render(f5);
        this.jaw1tooth3.render(f5);
        this.jaw1tooth4.render(f5);
        this.jaw1tooth5.render(f5);
        this.jaw1tooth6.render(f5);
        this.jaw2.render(f5);
        this.jaw2part2.render(f5);
        this.jaw2tooth1.render(f5);
        this.jaw2tooth2.render(f5);
        this.jaw2tooth3.render(f5);
        this.jaw2tooth4.render(f5);
        this.jaw2tooth5.render(f5);
        this.jaw2tooth6.render(f5);
        this.jaw3.render(f5);
        this.jaw3part2.render(f5);
        this.jaw3tooth1.render(f5);
        this.jaw3tooth2.render(f5);
        this.jaw3tooth3.render(f5);
        this.jaw3tooth4.render(f5);
        this.jaw3tooth5.render(f5);
        this.jaw3tooth6.render(f5);
        this.jaw4.render(f5);
        this.jaw4part2.render(f5);
        this.jaw4tooth1.render(f5);
        this.jaw4tooth2.render(f5);
        this.jaw4tooth3.render(f5);
        this.jaw4tooth4.render(f5);
        this.jaw4tooth5.render(f5);
        this.jaw4tooth6.render(f5);
        this.tonguepart1.render(f5);
        this.tonguepart2.render(f5);
        this.tonguepart3.render(f5);
        this.wing_1.render(f5);
        this.wing_2.render(f5);
        this.wing_3.render(f5);
        this.wing_4.render(f5);
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

