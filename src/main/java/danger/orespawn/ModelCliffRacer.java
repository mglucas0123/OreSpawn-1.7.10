/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelCliffRacer
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

public class ModelCliffRacer
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer Body;
    ModelRenderer Fins;
    ModelRenderer LWing;
    ModelRenderer RWing;
    ModelRenderer Tail;
    ModelRenderer TailEnd;
    ModelRenderer Head;
    ModelRenderer Beak;

    public ModelCliffRacer(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Body = new ModelRenderer((ModelBase)this, 0, 52);
        this.Body.addBox(0.0f, 0.0f, 0.0f, 3, 1, 10);
        this.Body.setRotationPoint(-1.0f, 15.0f, -4.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        this.Fins = new ModelRenderer((ModelBase)this, 0, 40);
        this.Fins.addBox(0.0f, -4.0f, 0.0f, 1, 6, 3);
        this.Fins.setRotationPoint(0.0f, 15.0f, -1.0f);
        this.Fins.setTextureSize(64, 64);
        this.Fins.mirror = true;
        this.setRotation(this.Fins, 0.0f, 0.0f, 0.0f);
        this.LWing = new ModelRenderer((ModelBase)this, 0, 31);
        this.LWing.addBox(0.0f, 0.0f, 0.0f, 7, 1, 6);
        this.LWing.setRotationPoint(2.0f, 15.0f, -2.0f);
        this.LWing.setTextureSize(64, 64);
        this.LWing.mirror = true;
        this.setRotation(this.LWing, 0.0f, 0.0f, 0.0f);
        this.RWing = new ModelRenderer((ModelBase)this, 39, 0);
        this.RWing.addBox(-7.0f, 0.0f, 0.0f, 7, 1, 6);
        this.RWing.setRotationPoint(-1.0f, 15.0f, -2.0f);
        this.RWing.setTextureSize(64, 64);
        this.RWing.mirror = true;
        this.setRotation(this.RWing, 0.0f, 0.0f, 0.0f);
        this.Tail = new ModelRenderer((ModelBase)this, 0, 16);
        this.Tail.addBox(0.0f, 0.0f, 0.0f, 1, 1, 9);
        this.Tail.setRotationPoint(0.0f, 15.0f, 6.0f);
        this.Tail.setTextureSize(64, 64);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
        this.TailEnd = new ModelRenderer((ModelBase)this, 0, 10);
        this.TailEnd.addBox(0.0f, -1.0f, 9.0f, 2, 2, 2);
        this.TailEnd.setRotationPoint(-0.5f, 15.0f, 6.0f);
        this.TailEnd.setTextureSize(64, 64);
        this.TailEnd.mirror = true;
        this.setRotation(this.TailEnd, 0.0f, 0.0f, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 28, 21);
        this.Head.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Head.setRotationPoint(-0.5f, 14.0f, -6.0f);
        this.Head.setTextureSize(64, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Beak = new ModelRenderer((ModelBase)this, 0, 0);
        this.Beak.addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Beak.setRotationPoint(0.0f, 14.5f, -8.0f);
        this.Beak.setTextureSize(64, 64);
        this.Beak.mirror = true;
        this.setRotation(this.Beak, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.LWing.rotateAngleZ = newangle = MathHelper.cos((float)(f2 * 1.3f * this.wingspeed)) * 3.1415927f * 0.25f;
        this.RWing.rotateAngleZ = - newangle;
        this.Body.render(f5);
        this.Fins.render(f5);
        this.LWing.render(f5);
        this.RWing.render(f5);
        this.Tail.render(f5);
        this.TailEnd.render(f5);
        this.Head.render(f5);
        this.Beak.render(f5);
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

