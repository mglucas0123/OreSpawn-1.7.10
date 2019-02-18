/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.LeafMonster
 *  danger.orespawn.ModelLeafMonster
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package danger.orespawn;

import danger.orespawn.LeafMonster;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLeafMonster
extends ModelBase {
    ModelRenderer body;
    ModelRenderer larm;
    ModelRenderer rarm;
    ModelRenderer lleg;
    ModelRenderer rleg;

    public ModelLeafMonster() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer((ModelBase)this, 32, 32);
        this.body.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.larm = new ModelRenderer((ModelBase)this, 64, 0);
        this.larm.addBox(0.0f, -16.0f, -8.0f, 16, 16, 16);
        this.larm.setRotationPoint(8.0f, -8.0f, 0.0f);
        this.larm.setTextureSize(64, 32);
        this.larm.mirror = true;
        this.setRotation(this.larm, 0.0f, 0.0f, 0.0f);
        this.rarm = new ModelRenderer((ModelBase)this, 0, 0);
        this.rarm.addBox(-16.0f, -16.0f, -8.0f, 16, 16, 16);
        this.rarm.setRotationPoint(-8.0f, -8.0f, 0.0f);
        this.rarm.setTextureSize(64, 32);
        this.rarm.mirror = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.0f);
        this.lleg = new ModelRenderer((ModelBase)this, 64, 64);
        this.lleg.addBox(0.0f, 0.0f, -8.0f, 16, 16, 16);
        this.lleg.setRotationPoint(8.0f, 8.0f, 0.0f);
        this.lleg.setTextureSize(64, 32);
        this.lleg.mirror = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        this.rleg = new ModelRenderer((ModelBase)this, 0, 64);
        this.rleg.addBox(-16.0f, 0.0f, -8.0f, 16, 16, 16);
        this.rleg.setRotationPoint(-8.0f, 8.0f, 0.0f);
        this.rleg.setTextureSize(64, 32);
        this.rleg.mirror = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        LeafMonster lm = (LeafMonster)entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (lm.getAttacking() == 0) {
            this.body.rotationPointY = 16.0f;
            this.rarm.rotationPointY = 8.0f;
            this.larm.rotationPointY = 8.0f;
            this.rarm.rotateAngleY = 0.0f;
            this.larm.rotateAngleY = 0.0f;
            this.rarm.rotateAngleX = 0.0f;
            this.larm.rotateAngleX = 0.0f;
            this.lleg.rotateAngleX = 0.0f;
            this.rleg.rotateAngleX = 0.0f;
        } else {
            this.body.rotationPointY = 0.0f;
            this.rarm.rotationPointY = -8.0f;
            this.larm.rotationPointY = -8.0f;
            float newangle = (double)f1 > 0.1 ? MathHelper.cos((float)(f2 * 0.95f)) * 3.1415927f * 0.25f * f1 : 0.0f;
            this.lleg.rotateAngleX = newangle;
            this.rleg.rotateAngleX = - newangle;
            newangle = MathHelper.cos((float)(f2 * 0.7f)) * 3.1415927f * 0.55f;
            this.rarm.rotateAngleY = - Math.abs(newangle);
            this.larm.rotateAngleY = Math.abs(newangle);
            this.rarm.rotateAngleX = - Math.abs(newangle);
            this.larm.rotateAngleX = - Math.abs(newangle);
        }
        this.body.render(f5);
        this.larm.render(f5);
        this.rarm.render(f5);
        this.lleg.render(f5);
        this.rleg.render(f5);
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

