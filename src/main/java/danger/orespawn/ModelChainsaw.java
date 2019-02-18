/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelChainsaw
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 */
package danger.orespawn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelChainsaw
extends ModelBase {
    ModelRenderer engine;
    ModelRenderer handle1;
    ModelRenderer handle2;
    ModelRenderer handle3;
    ModelRenderer muffler;
    ModelRenderer blade1;
    ModelRenderer blade2;
    ModelRenderer tooth;
    float toothpos = 0.0f;
    int toothdir = 0;
    float toothpos1 = 7.0f;
    int toothdir1 = 0;
    float toothpos2 = 14.0f;
    int toothdir2 = 0;
    float toothpos3 = 20.0f;
    int toothdir3 = 1;
    float toothpos4 = 13.0f;
    int toothdir4 = 1;
    float toothpos5 = 6.0f;
    int toothdir5 = 1;

    public ModelChainsaw() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.engine = new ModelRenderer((ModelBase)this, 0, 19);
        this.engine.addBox(-2.0f, -4.0f, -4.0f, 4, 7, 8);
        this.engine.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.engine.setTextureSize(64, 64);
        this.engine.mirror = true;
        this.setRotation(this.engine, 0.0f, 0.0f, 0.0f);
        this.handle1 = new ModelRenderer((ModelBase)this, 49, 0);
        this.handle1.addBox(0.0f, -3.0f, 3.0f, 1, 1, 5);
        this.handle1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.handle1.setTextureSize(64, 64);
        this.handle1.mirror = true;
        this.setRotation(this.handle1, -0.1919862f, 0.0f, 0.0f);
        this.handle2 = new ModelRenderer((ModelBase)this, 50, 13);
        this.handle2.addBox(0.0f, 2.0f, 4.0f, 1, 1, 4);
        this.handle2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.handle2.setTextureSize(64, 64);
        this.handle2.mirror = true;
        this.setRotation(this.handle2, 0.0f, 0.0f, 0.0f);
        this.handle3 = new ModelRenderer((ModelBase)this, 52, 7);
        this.handle3.addBox(0.0f, -2.0f, 7.0f, 1, 4, 1);
        this.handle3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.handle3.setTextureSize(64, 64);
        this.handle3.mirror = true;
        this.setRotation(this.handle3, -0.0872665f, 0.0f, 0.0f);
        this.muffler = new ModelRenderer((ModelBase)this, 14, 0);
        this.muffler.addBox(-3.0f, 0.0f, 1.0f, 1, 3, 3);
        this.muffler.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.muffler.setTextureSize(64, 64);
        this.muffler.mirror = true;
        this.setRotation(this.muffler, 0.0f, 0.0f, 0.0f);
        this.blade1 = new ModelRenderer((ModelBase)this, 0, 35);
        this.blade1.addBox(0.0f, -2.0f, -28.0f, 1, 4, 24);
        this.blade1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.blade1.setTextureSize(64, 64);
        this.blade1.mirror = true;
        this.setRotation(this.blade1, 0.0f, 0.0f, 0.0f);
        this.blade2 = new ModelRenderer((ModelBase)this, 0, 8);
        this.blade2.addBox(0.0f, -2.5f, -2.5f, 1, 5, 5);
        this.blade2.setRotationPoint(0.0f, 0.0f, -28.0f);
        this.blade2.setTextureSize(64, 64);
        this.blade2.mirror = true;
        this.setRotation(this.blade2, 0.0f, 0.0f, 0.0f);
        this.tooth = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth.addBox(0.0f, -1.0f, -0.5f, 1, 1, 1);
        this.tooth.setRotationPoint(0.0f, -2.0f, -5.0f);
        this.tooth.setTextureSize(64, 64);
        this.tooth.mirror = true;
        this.setRotation(this.tooth, 0.0f, 0.0f, 0.0f);
    }

    public void render() {
        float f5 = 1.0f;
        this.renderTooth(f5);
        this.renderTooth1(f5);
        this.renderTooth2(f5);
        this.renderTooth3(f5);
        this.renderTooth4(f5);
        this.renderTooth5(f5);
        this.blade2.rotateAngleX = (float)((double)this.blade2.rotateAngleX + 0.10471975511965977);
        if ((double)this.blade2.rotateAngleX > 6.283185307179586) {
            this.blade2.rotateAngleX = 0.0f;
        }
        this.engine.render(f5);
        this.handle1.render(f5);
        this.handle2.render(f5);
        this.handle3.render(f5);
        this.muffler.render(f5);
        this.blade1.render(f5);
        this.blade2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void renderTooth(float f5) {
        if (this.toothdir == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos;
            this.toothpos += 0.5f;
            if (this.toothpos > 21.0f) {
                this.toothpos = 21.0f;
                this.toothdir = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos;
            this.toothpos -= 0.5f;
            if (this.toothpos < 0.0f) {
                this.toothpos = 0.0f;
                this.toothdir = 0;
            }
        }
        this.tooth.render(f5);
    }

    private void renderTooth1(float f5) {
        if (this.toothdir1 == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos1;
            this.toothpos1 += 0.5f;
            if (this.toothpos1 > 21.0f) {
                this.toothpos1 = 21.0f;
                this.toothdir1 = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos1;
            this.toothpos1 -= 0.5f;
            if (this.toothpos1 < 0.0f) {
                this.toothpos1 = 0.0f;
                this.toothdir1 = 0;
            }
        }
        this.tooth.render(f5);
    }

    private void renderTooth2(float f5) {
        if (this.toothdir2 == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos2;
            this.toothpos2 += 0.5f;
            if (this.toothpos2 > 21.0f) {
                this.toothpos2 = 21.0f;
                this.toothdir2 = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos2;
            this.toothpos2 -= 0.5f;
            if (this.toothpos2 < 0.0f) {
                this.toothpos2 = 0.0f;
                this.toothdir2 = 0;
            }
        }
        this.tooth.render(f5);
    }

    private void renderTooth3(float f5) {
        if (this.toothdir3 == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos3;
            this.toothpos3 += 0.5f;
            if (this.toothpos3 > 21.0f) {
                this.toothpos3 = 21.0f;
                this.toothdir3 = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos3;
            this.toothpos3 -= 0.5f;
            if (this.toothpos3 < 0.0f) {
                this.toothpos3 = 0.0f;
                this.toothdir3 = 0;
            }
        }
        this.tooth.render(f5);
    }

    private void renderTooth4(float f5) {
        if (this.toothdir4 == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos4;
            this.toothpos4 += 0.5f;
            if (this.toothpos4 > 21.0f) {
                this.toothpos4 = 21.0f;
                this.toothdir4 = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos4;
            this.toothpos4 -= 0.5f;
            if (this.toothpos4 < 0.0f) {
                this.toothpos4 = 0.0f;
                this.toothdir4 = 0;
            }
        }
        this.tooth.render(f5);
    }

    private void renderTooth5(float f5) {
        if (this.toothdir5 == 0) {
            this.tooth.rotationPointY = -2.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos5;
            this.toothpos5 += 0.5f;
            if (this.toothpos5 > 21.0f) {
                this.toothpos5 = 21.0f;
                this.toothdir5 = 1;
            }
        } else {
            this.tooth.rotationPointY = 3.0f;
            this.tooth.rotationPointZ = -5.0f - this.toothpos5;
            this.toothpos5 -= 0.5f;
            if (this.toothpos5 < 0.0f) {
                this.toothpos5 = 0.0f;
                this.toothdir5 = 0;
            }
        }
        this.tooth.render(f5);
    }
}

