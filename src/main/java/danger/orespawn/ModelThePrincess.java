/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelThePrincess
 *  danger.orespawn.ThePrincess
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.ThePrincess;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelThePrincess
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer body;
    ModelRenderer neck1;
    ModelRenderer neck;
    ModelRenderer neckbase;
    ModelRenderer head;
    ModelRenderer Rleg1;
    ModelRenderer Lleg1;
    ModelRenderer snout;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer Lwing;
    ModelRenderer Rwing;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer Lneck1;
    ModelRenderer Lneck;
    ModelRenderer Lhead;
    ModelRenderer Lsnout;
    ModelRenderer Rneck1;
    ModelRenderer Rneck;
    ModelRenderer Rhead;
    ModelRenderer Rsnout;
    ModelRenderer headfin;
    ModelRenderer Lheadfin;
    ModelRenderer Rheadfin;
    ModelRenderer Backfin;
    ModelRenderer Rwing2;
    ModelRenderer Rwing3;
    ModelRenderer Lwing2;
    ModelRenderer Lwing3;
    ModelRenderer Ljaw;
    ModelRenderer jaw;
    ModelRenderer Rjaw;
    ModelRenderer Lpower;
    ModelRenderer Cpower;
    ModelRenderer Rpower;

    public ModelThePrincess(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer((ModelBase)this, 59, 34);
        this.body.addBox(-7.0f, -3.0f, -3.0f, 13, 8, 8);
        this.body.setRotationPoint(0.5f, 15.0f, 1.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.neck1 = new ModelRenderer((ModelBase)this, 20, 45);
        this.neck1.addBox(-1.5f, -2.0f, -1.0f, 3, 1, 4);
        this.neck1.setRotationPoint(0.0f, 15.0f, -5.0f);
        this.neck1.setTextureSize(64, 32);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, 0.0f, 0.0f, 0.0f);
        this.neck = new ModelRenderer((ModelBase)this, 20, 31);
        this.neck.addBox(-1.5f, -8.0f, -1.0f, 3, 8, 3);
        this.neck.setRotationPoint(0.0f, 14.0f, -6.0f);
        this.neck.setTextureSize(64, 32);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, 0.0f);
        this.neckbase = new ModelRenderer((ModelBase)this, 0, 76);
        this.neckbase.addBox(-4.5f, -4.0f, 0.0f, 9, 6, 3);
        this.neckbase.setRotationPoint(0.0f, 17.0f, 5.0f);
        this.neckbase.setTextureSize(64, 32);
        this.neckbase.mirror = true;
        this.setRotation(this.neckbase, 0.0f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 20, 20);
        this.head.addBox(-2.0f, -3.0f, -3.5f, 4, 4, 5);
        this.head.setRotationPoint(0.0f, 7.0f, -6.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.Rleg1 = new ModelRenderer((ModelBase)this, 0, 58);
        this.Rleg1.addBox(-1.5f, 0.0f, -2.0f, 3, 8, 4);
        this.Rleg1.setRotationPoint(6.0f, 16.0f, 1.0f);
        this.Rleg1.setTextureSize(64, 32);
        this.Rleg1.mirror = true;
        this.setRotation(this.Rleg1, 0.0f, 0.0f, 0.0f);
        this.Lleg1 = new ModelRenderer((ModelBase)this, 15, 58);
        this.Lleg1.addBox(-1.5f, 0.0f, -2.0f, 3, 8, 4);
        this.Lleg1.setRotationPoint(-6.0f, 16.0f, 1.0f);
        this.Lleg1.setTextureSize(64, 32);
        this.Lleg1.mirror = true;
        this.setRotation(this.Lleg1, 0.0f, 0.0f, 0.0f);
        this.snout = new ModelRenderer((ModelBase)this, 20, 11);
        this.snout.addBox(-1.5f, -2.0f, -8.5f, 3, 3, 5);
        this.snout.setRotationPoint(0.0f, 7.0f, -6.0f);
        this.snout.setTextureSize(64, 32);
        this.snout.mirror = true;
        this.setRotation(this.snout, 0.0f, 0.0f, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 0, 86);
        this.tail2.addBox(-3.0f, -2.5f, 0.0f, 6, 4, 7);
        this.tail2.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.tail2.setTextureSize(64, 32);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, -0.3839724f, 0.0f, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 0, 98);
        this.tail3.addBox(-2.0f, -2.0f, 0.0f, 4, 3, 6);
        this.tail3.setRotationPoint(0.0f, 18.2f, 13.0f);
        this.tail3.setTextureSize(64, 32);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, -0.2094395f, 0.0f, 0.0f);
        this.tail4 = new ModelRenderer((ModelBase)this, 0, 108);
        this.tail4.addBox(-1.5f, -1.5f, 0.0f, 3, 2, 5);
        this.tail4.setRotationPoint(0.0f, 19.5f, 18.0f);
        this.tail4.setTextureSize(64, 32);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, -0.0698132f, 0.0f, 0.0f);
        this.Lwing = new ModelRenderer((ModelBase)this, 59, 0);
        this.Lwing.addBox(-22.0f, 0.0f, -3.0f, 22, 0, 10);
        this.Lwing.setRotationPoint(-6.0f, 12.6f, 0.0f);
        this.Lwing.setTextureSize(64, 32);
        this.Lwing.mirror = true;
        this.setRotation(this.Lwing, 0.0f, 0.0f, 0.4014257f);
        this.Rwing = new ModelRenderer((ModelBase)this, 59, 66);
        this.Rwing.addBox(0.0f, 0.0f, -3.0f, 22, 0, 10);
        this.Rwing.setRotationPoint(6.0f, 12.6f, 0.0f);
        this.Rwing.setTextureSize(64, 32);
        this.Rwing.mirror = true;
        this.setRotation(this.Rwing, 0.0f, 0.0f, -0.4014257f);
        this.Tail5 = new ModelRenderer((ModelBase)this, 0, 116);
        this.Tail5.addBox(-3.0f, 0.0f, 0.0f, 6, 2, 4);
        this.Tail5.setRotationPoint(0.0f, 18.0f, 22.0f);
        this.Tail5.setTextureSize(64, 32);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        this.Tail6 = new ModelRenderer((ModelBase)this, 0, 123);
        this.Tail6.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Tail6.setRotationPoint(0.0f, 18.0f, 26.0f);
        this.Tail6.setTextureSize(64, 32);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 0.0f, 0.0f, 0.0f);
        this.Lneck1 = new ModelRenderer((ModelBase)this, 0, 45);
        this.Lneck1.addBox(-1.5f, -2.0f, -1.0f, 3, 1, 4);
        this.Lneck1.setRotationPoint(4.5f, 15.0f, -5.0f);
        this.Lneck1.setTextureSize(64, 32);
        this.Lneck1.mirror = true;
        this.setRotation(this.Lneck1, 0.0f, 0.0f, 0.0f);
        this.Lneck = new ModelRenderer((ModelBase)this, 0, 30);
        this.Lneck.addBox(-1.5f, -8.0f, -1.0f, 3, 8, 3);
        this.Lneck.setRotationPoint(4.5f, 14.0f, -6.0f);
        this.Lneck.setTextureSize(64, 32);
        this.Lneck.mirror = true;
        this.setRotation(this.Lneck, 0.0f, 0.0f, 0.0f);
        this.Lhead = new ModelRenderer((ModelBase)this, 0, 20);
        this.Lhead.addBox(-2.0f, -3.0f, -3.5f, 4, 4, 5);
        this.Lhead.setRotationPoint(4.5f, 7.0f, -6.0f);
        this.Lhead.setTextureSize(64, 32);
        this.Lhead.mirror = true;
        this.setRotation(this.Lhead, -0.0174533f, 0.0f, 0.0f);
        this.Lsnout = new ModelRenderer((ModelBase)this, 0, 11);
        this.Lsnout.addBox(-1.5f, -2.0f, -8.5f, 3, 3, 5);
        this.Lsnout.setRotationPoint(4.5f, 7.0f, -6.0f);
        this.Lsnout.setTextureSize(64, 32);
        this.Lsnout.mirror = true;
        this.setRotation(this.Lsnout, 0.0f, 0.0f, 0.0f);
        this.Rneck1 = new ModelRenderer((ModelBase)this, 40, 45);
        this.Rneck1.addBox(-1.5f, -2.0f, -1.0f, 3, 1, 4);
        this.Rneck1.setRotationPoint(-4.5f, 15.0f, -5.0f);
        this.Rneck1.setTextureSize(64, 32);
        this.Rneck1.mirror = true;
        this.setRotation(this.Rneck1, 0.0f, 0.0f, 0.0f);
        this.Rneck = new ModelRenderer((ModelBase)this, 40, 31);
        this.Rneck.addBox(-1.5f, -8.0f, -1.0f, 3, 8, 3);
        this.Rneck.setRotationPoint(-4.5f, 14.0f, -6.0f);
        this.Rneck.setTextureSize(64, 32);
        this.Rneck.mirror = true;
        this.setRotation(this.Rneck, 0.0f, 0.0f, 0.0f);
        this.Rhead = new ModelRenderer((ModelBase)this, 40, 20);
        this.Rhead.addBox(-2.0f, -3.0f, -3.5f, 4, 4, 5);
        this.Rhead.setRotationPoint(-4.5f, 7.0f, -6.0f);
        this.Rhead.setTextureSize(64, 32);
        this.Rhead.mirror = true;
        this.setRotation(this.Rhead, 0.0f, 0.0f, 0.0f);
        this.Rsnout = new ModelRenderer((ModelBase)this, 40, 11);
        this.Rsnout.addBox(-1.5f, -2.0f, -8.5f, 3, 3, 5);
        this.Rsnout.setRotationPoint(-4.5f, 7.0f, -6.0f);
        this.Rsnout.setTextureSize(64, 32);
        this.Rsnout.mirror = true;
        this.setRotation(this.Rsnout, 0.0f, 0.0f, 0.0f);
        this.headfin = new ModelRenderer((ModelBase)this, 20, 0);
        this.headfin.addBox(-0.5f, -3.0f, 1.0f, 1, 4, 3);
        this.headfin.setRotationPoint(0.0f, 7.0f, -6.0f);
        this.headfin.setTextureSize(64, 32);
        this.headfin.mirror = true;
        this.setRotation(this.headfin, -0.122173f, 0.0f, 0.0f);
        this.Lheadfin = new ModelRenderer((ModelBase)this, 0, 0);
        this.Lheadfin.addBox(-0.5f, -3.0f, 1.0f, 1, 4, 3);
        this.Lheadfin.setRotationPoint(4.5f, 7.0f, -6.0f);
        this.Lheadfin.setTextureSize(64, 32);
        this.Lheadfin.mirror = true;
        this.setRotation(this.Lheadfin, -0.122173f, 0.0f, 0.0f);
        this.Rheadfin = new ModelRenderer((ModelBase)this, 40, 0);
        this.Rheadfin.addBox(-0.5f, -3.0f, 1.0f, 1, 4, 3);
        this.Rheadfin.setRotationPoint(-4.5f, 7.0f, -6.0f);
        this.Rheadfin.setTextureSize(64, 32);
        this.Rheadfin.mirror = true;
        this.setRotation(this.Rheadfin, -0.122173f, 0.0f, 0.0f);
        this.Backfin = new ModelRenderer((ModelBase)this, 35, 57);
        this.Backfin.addBox(-0.5f, 0.0f, 0.0f, 1, 3, 5);
        this.Backfin.setRotationPoint(0.0f, 12.0f, -1.0f);
        this.Backfin.setTextureSize(64, 32);
        this.Backfin.mirror = true;
        this.setRotation(this.Backfin, 0.5061455f, 0.0f, 0.0f);
        this.Rwing2 = new ModelRenderer((ModelBase)this, 59, 77);
        this.Rwing2.addBox(0.0f, 0.0f, -3.0f, 12, 0, 10);
        this.Rwing2.setRotationPoint(6.0f, 12.6f, 0.0f);
        this.Rwing2.setTextureSize(64, 32);
        this.Rwing2.mirror = true;
        this.setRotation(this.Rwing2, 0.0f, 0.0f, -0.6981317f);
        this.Rwing3 = new ModelRenderer((ModelBase)this, 59, 88);
        this.Rwing3.addBox(0.0f, 0.0f, -3.0f, 10, 0, 10);
        this.Rwing3.setRotationPoint(6.0f, 12.6f, 0.0f);
        this.Rwing3.setTextureSize(64, 32);
        this.Rwing3.mirror = true;
        this.setRotation(this.Rwing3, 0.0f, 0.0f, -0.0698132f);
        this.Lwing2 = new ModelRenderer((ModelBase)this, 59, 11);
        this.Lwing2.addBox(-12.0f, 0.0f, -3.0f, 12, 0, 10);
        this.Lwing2.setRotationPoint(-6.0f, 12.6f, 0.0f);
        this.Lwing2.setTextureSize(64, 32);
        this.Lwing2.mirror = true;
        this.setRotation(this.Lwing2, 0.0f, 0.0f, 0.6981317f);
        this.Lwing3 = new ModelRenderer((ModelBase)this, 59, 22);
        this.Lwing3.addBox(-10.0f, 0.0f, -3.0f, 10, 0, 10);
        this.Lwing3.setRotationPoint(-6.0f, 12.6f, 0.0f);
        this.Lwing3.setTextureSize(64, 32);
        this.Lwing3.mirror = true;
        this.setRotation(this.Lwing3, 0.0f, 0.0f, 0.0698132f);
        this.Ljaw = new ModelRenderer((ModelBase)this, 30, 70);
        this.Ljaw.addBox(-1.5f, 1.0f, -5.0f, 3, 1, 5);
        this.Ljaw.setRotationPoint(4.5f, 7.0f, -7.0f);
        this.Ljaw.setTextureSize(64, 32);
        this.Ljaw.mirror = true;
        this.setRotation(this.Ljaw, 0.2443461f, 0.0f, 0.0f);
        this.jaw = new ModelRenderer((ModelBase)this, 30, 80);
        this.jaw.addBox(-1.5f, 1.0f, -5.0f, 3, 1, 5);
        this.jaw.setRotationPoint(0.0f, 7.0f, -7.0f);
        this.jaw.setTextureSize(64, 32);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.2443461f, 0.0f, 0.0f);
        this.Rjaw = new ModelRenderer((ModelBase)this, 30, 90);
        this.Rjaw.addBox(-1.5f, 1.0f, -5.0f, 3, 1, 5);
        this.Rjaw.setRotationPoint(-4.5f, 7.0f, -7.0f);
        this.Rjaw.setTextureSize(64, 32);
        this.Rjaw.mirror = true;
        this.setRotation(this.Rjaw, 0.2443461f, 0.0f, 0.0f);
        this.Lpower = new ModelRenderer((ModelBase)this, 30, 100);
        this.Lpower.addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4);
        this.Lpower.setRotationPoint(4.5f, 17.0f, -5.0f);
        this.Lpower.setTextureSize(128, 128);
        this.Lpower.mirror = true;
        this.setRotation(this.Lpower, 0.0f, 0.0f, 0.0f);
        this.Cpower = new ModelRenderer((ModelBase)this, 50, 100);
        this.Cpower.addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4);
        this.Cpower.setRotationPoint(0.0f, 17.0f, -5.0f);
        this.Cpower.setTextureSize(128, 128);
        this.Cpower.mirror = true;
        this.setRotation(this.Cpower, 0.0f, 0.0f, 0.0f);
        this.Rpower = new ModelRenderer((ModelBase)this, 70, 100);
        this.Rpower.addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4);
        this.Rpower.setRotationPoint(-4.5f, 17.0f, -5.0f);
        this.Rpower.setTextureSize(128, 128);
        this.Rpower.mirror = true;
        this.setRotation(this.Rpower, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float h3;
        float d3;
        ThePrincess c = (ThePrincess)entity;
        float hf = 0.0f;
        float newangle = 0.0f;
        int current_activity = c.getActivity();
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = (double)f1 > 0.1 || c.getAttacking() != 0 ? MathHelper.cos((float)(f2 * 2.3f * this.wingspeed)) * 3.1415927f * 0.4f * f1 : MathHelper.cos((float)(f2 * 0.3f * this.wingspeed)) * 3.1415927f * 0.04f;
        this.Rwing.rotateAngleZ = newangle - 0.4f;
        this.Rwing2.rotateAngleZ = newangle - 0.6f;
        this.Rwing3.rotateAngleZ = newangle - 0.2f;
        this.Lwing.rotateAngleZ = - newangle + 0.4f;
        this.Lwing2.rotateAngleZ = - newangle + 0.6f;
        this.Lwing3.rotateAngleZ = - newangle + 0.2f;
        newangle = (double)f1 > 0.1 ? MathHelper.cos((float)(f2 * 2.0f * this.wingspeed)) * 3.1415927f * 0.25f * f1 : 0.0f;
        if (current_activity != 2 || c.getAttacking() != 0) {
            this.Rleg1.rotateAngleX = newangle;
            this.Lleg1.rotateAngleX = - newangle;
        } else {
            this.Rleg1.rotateAngleX = newangle = -1.0f;
            this.Lleg1.rotateAngleX = newangle;
        }
        newangle = MathHelper.cos((float)(f2 * 0.9f * this.wingspeed)) * 3.1415927f * 0.06f;
        if (c.isSitting()) {
            newangle = 0.0f;
        }
        if (c.getAttacking() != 0) {
            newangle = MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.12f;
        }
        this.tail2.rotateAngleY = newangle;
        this.tail3.rotationPointZ = this.tail2.rotationPointZ + (float)Math.cos(this.tail2.rotateAngleY) * 6.0f;
        this.tail3.rotationPointX = this.tail2.rotationPointX + (float)Math.sin(this.tail2.rotateAngleY) * 6.0f;
        this.tail3.rotateAngleY = newangle * 1.6f;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ + (float)Math.cos(this.tail3.rotateAngleY) * 5.0f;
        this.tail4.rotationPointX = this.tail3.rotationPointX + (float)Math.sin(this.tail3.rotateAngleY) * 5.0f;
        this.tail4.rotateAngleY = newangle * 2.6f;
        this.Tail5.rotationPointZ = this.tail4.rotationPointZ + (float)Math.cos(this.tail4.rotateAngleY) * 4.0f;
        this.Tail5.rotationPointX = this.tail4.rotationPointX + (float)Math.sin(this.tail4.rotateAngleY) * 4.0f;
        this.Tail5.rotateAngleY = newangle * 3.6f;
        this.Tail6.rotationPointZ = this.Tail5.rotationPointZ + (float)Math.cos(this.Tail5.rotateAngleY) * 4.0f;
        this.Tail6.rotationPointX = this.Tail5.rotationPointX + (float)Math.sin(this.Tail5.rotateAngleY) * 4.0f;
        this.Tail6.rotateAngleY = newangle * 4.6f;
        float h2 = h3 = f3 * 2.0f / 3.0f;
        float h1 = h3;
        float d2 = d3 = f4 * 2.0f / 3.0f;
        float d1 = d3;
        if (h1 < 0.0f) {
            h2 = h3 = h1 / 2.0f;
            d2 = d3 = d1 / 2.0f;
        } else {
            h2 = h1 = h3 / 2.0f;
            d2 = d1 = d3 / 2.0f;
        }
        this.head.rotateAngleY = (float)Math.toRadians(h2);
        this.snout.rotateAngleY = (float)Math.toRadians(h2);
        this.headfin.rotateAngleY = (float)Math.toRadians(h2);
        this.jaw.rotateAngleY = (float)Math.toRadians(h2);
        this.jaw.rotationPointZ = this.snout.rotationPointZ - (float)Math.cos(this.snout.rotateAngleY);
        this.jaw.rotationPointX = this.snout.rotationPointX - (float)Math.sin(this.snout.rotateAngleY);
        this.neck.rotateAngleY = (float)Math.toRadians(h2) / 2.0f;
        this.Lhead.rotateAngleY = (float)Math.toRadians(h1);
        this.Lsnout.rotateAngleY = (float)Math.toRadians(h1);
        this.Lheadfin.rotateAngleY = (float)Math.toRadians(h1);
        this.Ljaw.rotateAngleY = (float)Math.toRadians(h1);
        this.Ljaw.rotationPointZ = this.Lsnout.rotationPointZ - (float)Math.cos(this.Lsnout.rotateAngleY);
        this.Ljaw.rotationPointX = this.Lsnout.rotationPointX - (float)Math.sin(this.Lsnout.rotateAngleY);
        this.Lneck.rotateAngleY = (float)Math.toRadians(h1) / 2.0f;
        this.Rhead.rotateAngleY = (float)Math.toRadians(h3);
        this.Rsnout.rotateAngleY = (float)Math.toRadians(h3);
        this.Rheadfin.rotateAngleY = (float)Math.toRadians(h3);
        this.Rjaw.rotateAngleY = (float)Math.toRadians(h3);
        this.Rjaw.rotationPointZ = this.Rsnout.rotationPointZ - (float)Math.cos(this.Rsnout.rotateAngleY);
        this.Rjaw.rotationPointX = this.Rsnout.rotationPointX - (float)Math.sin(this.Rsnout.rotateAngleY);
        this.Rneck.rotateAngleY = (float)Math.toRadians(h3) / 2.0f;
        float Rjx = 0.0f;
        float jx = 0.0f;
        float Ljx = 0.0f;
        if (c.getAttacking() != 0) {
            newangle = MathHelper.cos((float)(f2 * 1.9f * this.wingspeed)) * 3.1415927f * 0.2f;
            Ljx = 0.2f + newangle;
            newangle = MathHelper.cos((float)(f2 * 2.1f * this.wingspeed)) * 3.1415927f * 0.2f;
            Rjx = 0.2f + newangle;
            newangle = MathHelper.cos((float)(f2 * 2.3f * this.wingspeed)) * 3.1415927f * 0.2f;
            jx = 0.2f + newangle;
        }
        this.head.rotateAngleX = (float)Math.toRadians(d2);
        this.snout.rotateAngleX = (float)Math.toRadians(d2);
        this.headfin.rotateAngleX = (float)Math.toRadians(d2);
        this.jaw.rotateAngleX = (float)Math.toRadians(d2) + jx;
        this.Lhead.rotateAngleX = (float)Math.toRadians(d1);
        this.Lsnout.rotateAngleX = (float)Math.toRadians(d1);
        this.Lheadfin.rotateAngleX = (float)Math.toRadians(d1);
        this.Ljaw.rotateAngleX = (float)Math.toRadians(d1) + Ljx;
        this.Rhead.rotateAngleX = (float)Math.toRadians(d3);
        this.Rsnout.rotateAngleX = (float)Math.toRadians(d3);
        this.Rheadfin.rotateAngleX = (float)Math.toRadians(d3);
        this.Rjaw.rotateAngleX = (float)Math.toRadians(d3) + Rjx;
        d1 = c.getHead1Ext();
        d2 = c.getHead2Ext();
        d3 = c.getHead3Ext();
        this.Lneck.rotateAngleX = (float)Math.toRadians(d1);
        this.neck.rotateAngleX = (float)Math.toRadians(d2);
        this.Rneck.rotateAngleX = (float)Math.toRadians(d3);
        this.Lsnout.rotationPointY = this.Ljaw.rotationPointY = (this.Lhead.rotationPointY = this.Lneck.rotationPointY - (float)Math.cos(this.Lneck.rotateAngleX) * 7.0f);
        this.Lheadfin.rotationPointY = this.Ljaw.rotationPointY;
        this.Lsnout.rotationPointZ = this.Ljaw.rotationPointZ = (this.Lhead.rotationPointZ = this.Lneck.rotationPointZ - (float)Math.sin(this.Lneck.rotateAngleX) * 7.0f);
        this.Lheadfin.rotationPointZ = this.Ljaw.rotationPointZ;
        this.Lsnout.rotationPointX = this.Ljaw.rotationPointX = (this.Lhead.rotationPointX = this.Lneck.rotationPointX - (float)Math.sin(this.Lneck.rotateAngleY) * 7.0f * (float)Math.sin(this.Lneck.rotateAngleX));
        this.Lheadfin.rotationPointX = this.Ljaw.rotationPointX;
        this.Rsnout.rotationPointY = this.Rjaw.rotationPointY = (this.Rhead.rotationPointY = this.Rneck.rotationPointY - (float)Math.cos(this.Rneck.rotateAngleX) * 7.0f);
        this.Rheadfin.rotationPointY = this.Rjaw.rotationPointY;
        this.Rsnout.rotationPointZ = this.Rjaw.rotationPointZ = (this.Rhead.rotationPointZ = this.Rneck.rotationPointZ - (float)Math.sin(this.Rneck.rotateAngleX) * 7.0f);
        this.Rheadfin.rotationPointZ = this.Rjaw.rotationPointZ;
        this.Rsnout.rotationPointX = this.Rjaw.rotationPointX = (this.Rhead.rotationPointX = this.Rneck.rotationPointX - (float)Math.sin(this.Rneck.rotateAngleY) * 7.0f * (float)Math.sin(this.Rneck.rotateAngleX));
        this.Rheadfin.rotationPointX = this.Rjaw.rotationPointX;
        this.snout.rotationPointY = this.jaw.rotationPointY = (this.head.rotationPointY = this.neck.rotationPointY - (float)Math.cos(this.neck.rotateAngleX) * 7.0f);
        this.headfin.rotationPointY = this.jaw.rotationPointY;
        this.snout.rotationPointZ = this.jaw.rotationPointZ = (this.head.rotationPointZ = this.neck.rotationPointZ - (float)Math.sin(this.neck.rotateAngleX) * 7.0f);
        this.headfin.rotationPointZ = this.jaw.rotationPointZ;
        this.snout.rotationPointX = this.jaw.rotationPointX = (this.head.rotationPointX = this.neck.rotationPointX - (float)Math.sin(this.neck.rotateAngleY) * 7.0f * (float)Math.sin(this.neck.rotateAngleX));
        this.headfin.rotationPointX = this.jaw.rotationPointX;
        this.Lpower.rotateAngleX += 0.03f;
        if ((double)this.Lpower.rotateAngleX > 3.141592653589793) {
            this.Lpower.rotateAngleX = (float)((double)this.Lpower.rotateAngleX - 6.283185307179586);
        }
        this.Cpower.rotateAngleX += 0.04f;
        if ((double)this.Cpower.rotateAngleX > 3.141592653589793) {
            this.Cpower.rotateAngleX = (float)((double)this.Cpower.rotateAngleX - 6.283185307179586);
        }
        this.Rpower.rotateAngleX += 0.05f;
        if ((double)this.Rpower.rotateAngleX > 3.141592653589793) {
            this.Rpower.rotateAngleX = (float)((double)this.Rpower.rotateAngleX - 6.283185307179586);
        }
        this.Lpower.rotateAngleY += 0.035f;
        if ((double)this.Lpower.rotateAngleY > 3.141592653589793) {
            this.Lpower.rotateAngleY = (float)((double)this.Lpower.rotateAngleY - 6.283185307179586);
        }
        this.Cpower.rotateAngleY += 0.046f;
        if ((double)this.Cpower.rotateAngleY > 3.141592653589793) {
            this.Cpower.rotateAngleY = (float)((double)this.Cpower.rotateAngleY - 6.283185307179586);
        }
        this.Rpower.rotateAngleY += 0.065f;
        if ((double)this.Rpower.rotateAngleY > 3.141592653589793) {
            this.Rpower.rotateAngleY = (float)((double)this.Rpower.rotateAngleY - 6.283185307179586);
        }
        this.Lpower.rotateAngleZ += 0.05f;
        if ((double)this.Lpower.rotateAngleZ > 3.141592653589793) {
            this.Lpower.rotateAngleZ = (float)((double)this.Lpower.rotateAngleZ - 6.283185307179586);
        }
        this.Cpower.rotateAngleZ += 0.13f;
        if ((double)this.Cpower.rotateAngleZ > 3.141592653589793) {
            this.Cpower.rotateAngleZ = (float)((double)this.Cpower.rotateAngleZ - 6.283185307179586);
        }
        this.Rpower.rotateAngleZ += 0.03f;
        if ((double)this.Rpower.rotateAngleZ > 3.141592653589793) {
            this.Rpower.rotateAngleZ = (float)((double)this.Rpower.rotateAngleZ - 6.283185307179586);
        }
        this.body.render(f5);
        this.neck1.render(f5);
        this.neck.render(f5);
        this.neckbase.render(f5);
        this.head.render(f5);
        this.Rleg1.render(f5);
        this.Lleg1.render(f5);
        this.snout.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
        this.Tail5.render(f5);
        this.Tail6.render(f5);
        this.Lneck1.render(f5);
        this.Lneck.render(f5);
        this.Lhead.render(f5);
        this.Lsnout.render(f5);
        this.Rneck1.render(f5);
        this.Rneck.render(f5);
        this.Rhead.render(f5);
        this.Rsnout.render(f5);
        this.headfin.render(f5);
        this.Lheadfin.render(f5);
        this.Rheadfin.render(f5);
        this.Backfin.render(f5);
        this.Ljaw.render(f5);
        this.jaw.render(f5);
        this.Rjaw.render(f5);
        GL11.glPushMatrix();
        GL11.glEnable((int)2977);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)0.75f, (float)0.75f, (float)0.75f, (float)0.55f);
        this.Rwing2.render(f5);
        this.Rwing3.render(f5);
        this.Lwing2.render(f5);
        this.Lwing3.render(f5);
        this.Lwing.render(f5);
        this.Rwing.render(f5);
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
        this.Lpower.render(f5);
        this.Cpower.render(f5);
        this.Rpower.render(f5);
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

