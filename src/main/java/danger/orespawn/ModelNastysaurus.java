/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelNastysaurus
 *  danger.orespawn.Nastysaurus
 *  danger.orespawn.RenderInfo
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.Nastysaurus;
import danger.orespawn.RenderInfo;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModelNastysaurus
extends ModelBase {
    private float wingspeed = 1.0f;
    ModelRenderer lclaw1;
    ModelRenderer body;
    ModelRenderer leftleg1;
    ModelRenderer tail1;
    ModelRenderer leftleg2;
    ModelRenderer body2;
    ModelRenderer leftleg3;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer lclaw2;
    ModelRenderer lclaw3;
    ModelRenderer lclaw4;
    ModelRenderer lclaw5;
    ModelRenderer lclaw6;
    ModelRenderer lclaw7;
    ModelRenderer neck3;
    ModelRenderer head3;
    ModelRenderer jaw1;
    ModelRenderer tooth1;
    ModelRenderer tooth2;
    ModelRenderer tooth3;
    ModelRenderer tooth4;
    ModelRenderer tooth5;
    ModelRenderer jaw5;
    ModelRenderer head7;
    ModelRenderer tooth6;
    ModelRenderer tooth7;
    ModelRenderer tooth8;
    ModelRenderer tooth9;
    ModelRenderer tooth10;
    ModelRenderer tooth11;
    ModelRenderer tooth12;
    ModelRenderer tooth13;
    ModelRenderer rightleg1;
    ModelRenderer rightleg2;
    ModelRenderer tooth14;
    ModelRenderer tooth15;
    ModelRenderer tooth16;
    ModelRenderer tooth17;
    ModelRenderer tooth18;
    ModelRenderer tooth19;
    ModelRenderer tooth20;
    ModelRenderer tooth21;
    ModelRenderer tooth22;
    ModelRenderer tooth23;
    ModelRenderer rightleg3;
    ModelRenderer rclaw2;
    ModelRenderer rclaw4;
    ModelRenderer rclaw1;
    ModelRenderer rclaw5;
    ModelRenderer rclaw7;
    ModelRenderer rclaw3;
    ModelRenderer rclaw6;
    ModelRenderer neck1;
    ModelRenderer neck2;
    ModelRenderer tail4;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;

    public ModelNastysaurus(float f1) {
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 256;
        this.lclaw1 = new ModelRenderer((ModelBase)this, 300, 111);
        this.lclaw1.addBox(-3.0f, 0.0f, -3.0f, 2, 3, 6);
        this.lclaw1.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw1.setTextureSize(512, 256);
        this.lclaw1.mirror = true;
        this.setRotation(this.lclaw1, 0.0f, 0.6632251f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 407, 3);
        this.body.addBox(-6.0f, -12.0f, -9.0f, 12, 17, 9);
        this.body.setRotationPoint(0.0f, -2.0f, 9.0f);
        this.body.setTextureSize(512, 256);
        this.body.mirror = true;
        this.setRotation(this.body, -0.3141593f, 0.0f, 0.0f);
        this.leftleg1 = new ModelRenderer((ModelBase)this, 300, 0);
        this.leftleg1.addBox(-3.0f, -4.0f, -21.0f, 6, 11, 11);
        this.leftleg1.setRotationPoint(9.0f, 2.0f, 26.0f);
        this.leftleg1.setTextureSize(512, 256);
        this.leftleg1.mirror = true;
        this.setRotation(this.leftleg1, -0.5759587f, 0.0f, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 400, 75);
        this.tail1.addBox(-6.0f, -6.0f, 0.0f, 10, 12, 14);
        this.tail1.setRotationPoint(1.0f, -5.0f, 22.0f);
        this.tail1.setTextureSize(512, 256);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, -0.1745329f, 0.0f, 0.0f);
        this.leftleg2 = new ModelRenderer((ModelBase)this, 300, 23);
        this.leftleg2.addBox(-3.0f, -10.0f, -5.0f, 5, 13, 7);
        this.leftleg2.setRotationPoint(9.0f, 2.0f, 26.0f);
        this.leftleg2.setTextureSize(512, 256);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.9773844f, 0.0f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 400, 39);
        this.body2.addBox(0.0f, -3.0f, -3.0f, 12, 18, 16);
        this.body2.setRotationPoint(-6.0f, -11.0f, 10.0f);
        this.body2.setTextureSize(512, 256);
        this.body2.mirror = true;
        this.setRotation(this.body2, -0.1047198f, 0.0f, 0.0f);
        this.leftleg3 = new ModelRenderer((ModelBase)this, 300, 51);
        this.leftleg3.addBox(-1.0f, -19.0f, 0.0f, 4, 18, 6);
        this.leftleg3.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.leftleg3.setTextureSize(512, 256);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.5235988f, 0.0f, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 400, 103);
        this.tail2.addBox(-4.0f, -4.0f, 0.0f, 8, 10, 12);
        this.tail2.setRotationPoint(0.0f, -4.0f, 35.0f);
        this.tail2.setTextureSize(512, 256);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, -0.1396263f, 0.0f, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 400, 127);
        this.tail3.addBox(-3.0f, -3.0f, 0.0f, 6, 8, 12);
        this.tail3.setRotationPoint(0.0f, -3.0f, 46.0f);
        this.tail3.setTextureSize(512, 256);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, -0.1396263f, 0.0f, 0.0f);
        this.lclaw2 = new ModelRenderer((ModelBase)this, 300, 76);
        this.lclaw2.addBox(-1.0f, -1.0f, -6.0f, 4, 4, 13);
        this.lclaw2.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw2.setTextureSize(512, 256);
        this.lclaw2.mirror = true;
        this.setRotation(this.lclaw2, 0.0f, 0.0f, 0.0f);
        this.lclaw3 = new ModelRenderer((ModelBase)this, 300, 95);
        this.lclaw3.addBox(2.0f, 0.0f, -6.0f, 2, 3, 10);
        this.lclaw3.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw3.setTextureSize(512, 256);
        this.lclaw3.mirror = true;
        this.setRotation(this.lclaw3, 0.0f, -0.6632251f, 0.0f);
        this.lclaw4 = new ModelRenderer((ModelBase)this, 308, 123);
        this.lclaw4.addBox(0.0f, 0.0f, -10.0f, 2, 3, 4);
        this.lclaw4.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw4.setTextureSize(512, 256);
        this.lclaw4.mirror = true;
        this.setRotation(this.lclaw4, 0.0f, 0.0f, 0.0f);
        this.lclaw5 = new ModelRenderer((ModelBase)this, 300, 123);
        this.lclaw5.addBox(-2.5f, 1.0f, -5.0f, 1, 2, 2);
        this.lclaw5.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw5.setTextureSize(512, 256);
        this.lclaw5.mirror = true;
        this.setRotation(this.lclaw5, 0.0f, 0.6632251f, 0.0f);
        this.lclaw6 = new ModelRenderer((ModelBase)this, 322, 123);
        this.lclaw6.addBox(2.5f, 1.0f, -9.0f, 1, 2, 3);
        this.lclaw6.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw6.setTextureSize(512, 256);
        this.lclaw6.mirror = true;
        this.setRotation(this.lclaw6, 0.0f, -0.6632251f, 0.0f);
        this.lclaw7 = new ModelRenderer((ModelBase)this, 333, 123);
        this.lclaw7.addBox(0.0f, 1.0f, 7.0f, 1, 2, 3);
        this.lclaw7.setRotationPoint(7.0f, 21.0f, 11.0f);
        this.lclaw7.setTextureSize(512, 256);
        this.lclaw7.mirror = true;
        this.setRotation(this.lclaw7, 0.0f, 0.0f, 0.0f);
        this.neck3 = new ModelRenderer((ModelBase)this, 375, 23);
        this.neck3.addBox(-3.0f, -3.0f, -6.0f, 6, 6, 8);
        this.neck3.setRotationPoint(0.0f, -24.0f, -9.0f);
        this.neck3.setTextureSize(512, 256);
        this.neck3.mirror = true;
        this.setRotation(this.neck3, -0.2443461f, 0.0f, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 130, 32);
        this.head3.addBox(-3.0f, -6.0f, -15.0f, 6, 6, 17);
        this.head3.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.head3.setTextureSize(512, 256);
        this.head3.mirror = true;
        this.setRotation(this.head3, -0.2443461f, 0.0f, 0.0f);
        this.jaw1 = new ModelRenderer((ModelBase)this, 143, 114);
        this.jaw1.addBox(-3.0f, 1.0f, -14.0f, 6, 3, 15);
        this.jaw1.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.jaw1.setTextureSize(512, 256);
        this.jaw1.mirror = true;
        this.setRotation(this.jaw1, 0.1919862f, 0.0f, 0.0f);
        this.tooth1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth1.addBox(-3.0f, 0.0f, -14.0f, 1, 3, 1);
        this.tooth1.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth1.setTextureSize(512, 256);
        this.tooth1.mirror = true;
        this.setRotation(this.tooth1, -0.2443461f, 0.0f, 0.0f);
        this.tooth2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth2.addBox(-0.5f, 0.0f, -14.0f, 1, 2, 1);
        this.tooth2.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth2.setTextureSize(512, 256);
        this.tooth2.mirror = true;
        this.setRotation(this.tooth2, -0.2443461f, 0.0f, 0.0f);
        this.tooth3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth3.addBox(2.0f, 0.0f, -14.0f, 1, 3, 1);
        this.tooth3.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth3.setTextureSize(512, 256);
        this.tooth3.mirror = true;
        this.setRotation(this.tooth3, -0.2443461f, 0.0f, 0.0f);
        this.tooth4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth4.addBox(-2.0f, 0.0f, -12.0f, 1, 3, 1);
        this.tooth4.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth4.setTextureSize(512, 256);
        this.tooth4.mirror = true;
        this.setRotation(this.tooth4, -0.2443461f, 0.0f, 0.0f);
        this.tooth5 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth5.addBox(1.0f, 0.0f, -12.0f, 1, 3, 1);
        this.tooth5.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth5.setTextureSize(512, 256);
        this.tooth5.mirror = true;
        this.setRotation(this.tooth5, -0.2443461f, 0.0f, 0.0f);
        this.jaw5 = new ModelRenderer((ModelBase)this, 151, 135);
        this.jaw5.addBox(-4.0f, 1.0f, -4.0f, 8, 4, 7);
        this.jaw5.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.jaw5.setTextureSize(512, 256);
        this.jaw5.mirror = true;
        this.setRotation(this.jaw5, 0.1919862f, 0.0f, 0.0f);
        this.head7 = new ModelRenderer((ModelBase)this, 185, 34);
        this.head7.addBox(-4.0f, -7.0f, -3.0f, 8, 7, 10);
        this.head7.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.head7.setTextureSize(512, 256);
        this.head7.mirror = true;
        this.setRotation(this.head7, -0.2443461f, 0.0f, 0.0f);
        this.tooth6 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth6.addBox(-3.0f, 0.0f, -10.0f, 1, 2, 1);
        this.tooth6.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth6.setTextureSize(512, 256);
        this.tooth6.mirror = true;
        this.setRotation(this.tooth6, -0.2443461f, 0.0f, 0.0f);
        this.tooth7 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth7.addBox(2.0f, 0.0f, -10.0f, 1, 2, 1);
        this.tooth7.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth7.setTextureSize(512, 256);
        this.tooth7.mirror = true;
        this.setRotation(this.tooth7, -0.2443461f, 0.0f, 0.0f);
        this.tooth8 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth8.addBox(-2.0f, 0.0f, -8.0f, 1, 2, 1);
        this.tooth8.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth8.setTextureSize(512, 256);
        this.tooth8.mirror = true;
        this.setRotation(this.tooth8, -0.2443461f, 0.0f, 0.0f);
        this.tooth9 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth9.addBox(1.0f, 0.0f, -8.0f, 1, 2, 1);
        this.tooth9.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth9.setTextureSize(512, 256);
        this.tooth9.mirror = true;
        this.setRotation(this.tooth9, -0.2443461f, 0.0f, 0.0f);
        this.tooth10 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth10.addBox(-3.0f, 0.0f, -6.0f, 1, 2, 1);
        this.tooth10.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth10.setTextureSize(512, 256);
        this.tooth10.mirror = true;
        this.setRotation(this.tooth10, -0.2443461f, 0.0f, 0.0f);
        this.tooth11 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth11.addBox(2.0f, 0.0f, -6.0f, 1, 2, 1);
        this.tooth11.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth11.setTextureSize(512, 256);
        this.tooth11.mirror = true;
        this.setRotation(this.tooth11, -0.2443461f, 0.0f, 0.0f);
        this.tooth12 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth12.addBox(-2.0f, 0.0f, -4.0f, 1, 1, 1);
        this.tooth12.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth12.setTextureSize(512, 256);
        this.tooth12.mirror = true;
        this.setRotation(this.tooth12, -0.2443461f, 0.0f, 0.0f);
        this.tooth13 = new ModelRenderer((ModelBase)this, -1, 0);
        this.tooth13.addBox(1.0f, 0.0f, -4.0f, 1, 1, 1);
        this.tooth13.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth13.setTextureSize(512, 256);
        this.tooth13.mirror = true;
        this.setRotation(this.tooth13, -0.2443461f, 0.0f, 0.0f);
        this.rightleg1 = new ModelRenderer((ModelBase)this, 246, 0);
        this.rightleg1.addBox(-2.0f, -4.0f, -21.0f, 6, 11, 11);
        this.rightleg1.setRotationPoint(-10.0f, 2.0f, 26.0f);
        this.rightleg1.setTextureSize(512, 256);
        this.rightleg1.mirror = true;
        this.setRotation(this.rightleg1, -0.5934119f, 0.0f, 0.0f);
        this.rightleg2 = new ModelRenderer((ModelBase)this, 250, 24);
        this.rightleg2.addBox(-1.0f, -10.0f, -5.0f, 5, 13, 7);
        this.rightleg2.setRotationPoint(-10.0f, 2.0f, 26.0f);
        this.rightleg2.setTextureSize(512, 256);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.9773844f, 0.0f, 0.0f);
        this.tooth14 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth14.addBox(0.5f, -2.0f, -14.0f, 1, 3, 1);
        this.tooth14.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth14.setTextureSize(512, 256);
        this.tooth14.mirror = true;
        this.setRotation(this.tooth14, 0.1919862f, 0.0f, 0.0f);
        this.tooth15 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth15.addBox(-1.5f, -2.0f, -14.0f, 1, 3, 1);
        this.tooth15.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth15.setTextureSize(512, 256);
        this.tooth15.mirror = true;
        this.setRotation(this.tooth15, 0.1919862f, 0.0f, 0.0f);
        this.tooth16 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth16.addBox(2.0f, -1.0f, -12.0f, 1, 2, 1);
        this.tooth16.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth16.setTextureSize(512, 256);
        this.tooth16.mirror = true;
        this.setRotation(this.tooth16, 0.1919862f, 0.0f, 0.0f);
        this.tooth17 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth17.addBox(-3.0f, -1.0f, -12.0f, 1, 2, 1);
        this.tooth17.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth17.setTextureSize(512, 256);
        this.tooth17.mirror = true;
        this.setRotation(this.tooth17, 0.1919862f, 0.0f, 0.0f);
        this.tooth18 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth18.addBox(1.0f, -1.0f, -10.0f, 1, 2, 1);
        this.tooth18.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth18.setTextureSize(512, 256);
        this.tooth18.mirror = true;
        this.setRotation(this.tooth18, 0.1919862f, 0.0f, 0.0f);
        this.tooth19 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth19.addBox(-2.0f, -1.0f, -10.0f, 1, 2, 1);
        this.tooth19.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth19.setTextureSize(512, 256);
        this.tooth19.mirror = true;
        this.setRotation(this.tooth19, 0.1919862f, 0.0f, 0.0f);
        this.tooth20 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth20.addBox(-3.0f, -1.0f, -8.0f, 1, 2, 1);
        this.tooth20.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth20.setTextureSize(512, 256);
        this.tooth20.mirror = true;
        this.setRotation(this.tooth20, 0.1919862f, 0.0f, 0.0f);
        this.tooth21 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth21.addBox(2.0f, -1.0f, -8.0f, 1, 2, 1);
        this.tooth21.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth21.setTextureSize(512, 256);
        this.tooth21.mirror = true;
        this.setRotation(this.tooth21, 0.1919862f, 0.0f, 0.0f);
        this.tooth22 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth22.addBox(1.0f, 0.0f, -6.0f, 1, 1, 1);
        this.tooth22.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth22.setTextureSize(512, 256);
        this.tooth22.mirror = true;
        this.setRotation(this.tooth22, 0.1919862f, 0.0f, 0.0f);
        this.tooth23 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tooth23.addBox(-2.0f, 0.0f, -6.0f, 1, 1, 1);
        this.tooth23.setRotationPoint(0.0f, -26.0f, -14.0f);
        this.tooth23.setTextureSize(512, 256);
        this.tooth23.mirror = true;
        this.setRotation(this.tooth23, 0.1919862f, 0.0f, 0.0f);
        this.rightleg3 = new ModelRenderer((ModelBase)this, 250, 47);
        this.rightleg3.addBox(-2.0f, -19.0f, 0.0f, 4, 18, 6);
        this.rightleg3.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rightleg3.setTextureSize(512, 256);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.5235988f, 0.0f, 0.0f);
        this.rclaw2 = new ModelRenderer((ModelBase)this, 250, 76);
        this.rclaw2.addBox(-2.0f, -1.0f, -6.0f, 4, 4, 13);
        this.rclaw2.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw2.setTextureSize(512, 256);
        this.rclaw2.mirror = true;
        this.setRotation(this.rclaw2, 0.0f, 0.0f, 0.0f);
        this.rclaw4 = new ModelRenderer((ModelBase)this, 247, 123);
        this.rclaw4.addBox(-1.0f, 0.0f, -10.0f, 2, 3, 4);
        this.rclaw4.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw4.setTextureSize(512, 256);
        this.rclaw4.mirror = true;
        this.setRotation(this.rclaw4, 0.0f, 0.0f, 0.0f);
        this.rclaw1 = new ModelRenderer((ModelBase)this, 250, 111);
        this.rclaw1.addBox(2.0f, 0.0f, -3.0f, 2, 3, 6);
        this.rclaw1.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw1.setTextureSize(512, 256);
        this.rclaw1.mirror = true;
        this.setRotation(this.rclaw1, 0.0f, -0.6632251f, 0.0f);
        this.rclaw5 = new ModelRenderer((ModelBase)this, 261, 123);
        this.rclaw5.addBox(2.5f, 1.0f, -5.0f, 1, 2, 2);
        this.rclaw5.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw5.setTextureSize(512, 256);
        this.rclaw5.mirror = true;
        this.setRotation(this.rclaw5, 0.0f, -0.6632251f, 0.0f);
        this.rclaw7 = new ModelRenderer((ModelBase)this, 283, 123);
        this.rclaw7.addBox(0.0f, 1.0f, 7.0f, 1, 2, 3);
        this.rclaw7.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw7.setTextureSize(512, 256);
        this.rclaw7.mirror = true;
        this.setRotation(this.rclaw7, 0.0f, 0.0f, 0.0f);
        this.rclaw3 = new ModelRenderer((ModelBase)this, 250, 95);
        this.rclaw3.addBox(-3.0f, 0.0f, -6.0f, 2, 3, 10);
        this.rclaw3.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw3.setTextureSize(512, 256);
        this.rclaw3.mirror = true;
        this.setRotation(this.rclaw3, 0.0f, 0.6632251f, 0.0f);
        this.rclaw6 = new ModelRenderer((ModelBase)this, 270, 123);
        this.rclaw6.addBox(-2.5f, 1.0f, -9.0f, 1, 2, 3);
        this.rclaw6.setRotationPoint(-8.0f, 21.0f, 11.0f);
        this.rclaw6.setTextureSize(512, 256);
        this.rclaw6.mirror = true;
        this.setRotation(this.rclaw6, 0.0f, 0.6632251f, 0.0f);
        this.neck1 = new ModelRenderer((ModelBase)this, 45, 0);
        this.neck1.addBox(-5.0f, -6.0f, -14.0f, 10, 12, 15);
        this.neck1.setRotationPoint(0.0f, -9.0f, 5.0f);
        this.neck1.setTextureSize(512, 256);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, -0.837758f, 0.0f, 0.0f);
        this.neck2 = new ModelRenderer((ModelBase)this, 48, 29);
        this.neck2.addBox(-4.5f, -4.0f, -10.0f, 9, 9, 10);
        this.neck2.setRotationPoint(0.0f, -19.0f, -2.0f);
        this.neck2.setTextureSize(512, 256);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, -0.7853982f, 0.0f, 0.0f);
        this.tail4 = new ModelRenderer((ModelBase)this, 400, 150);
        this.tail4.addBox(-2.0f, -3.0f, 0.0f, 4, 6, 16);
        this.tail4.setRotationPoint(0.0f, -1.0f, 56.0f);
        this.tail4.setTextureSize(512, 256);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, -0.1396263f, 0.0f, 0.0f);
        this.Spike1 = new ModelRenderer((ModelBase)this, 0, 100);
        this.Spike1.addBox(-2.0f, -16.0f, -1.0f, 4, 16, 18);
        this.Spike1.setRotationPoint(0.0f, -4.0f, 7.0f);
        this.Spike1.setTextureSize(512, 256);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, 0.5061455f, 0.0f, 0.0f);
        this.Spike2 = new ModelRenderer((ModelBase)this, 0, 72);
        this.Spike2.addBox(-1.5f, -12.0f, 0.0f, 3, 12, 10);
        this.Spike2.setRotationPoint(0.0f, 0.0f, 29.0f);
        this.Spike2.setTextureSize(512, 256);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, 0.4886922f, 0.0f, 0.0f);
        this.Spike3 = new ModelRenderer((ModelBase)this, 0, 44);
        this.Spike3.addBox(-1.0f, -7.0f, 0.0f, 2, 8, 7);
        this.Spike3.setRotationPoint(0.0f, -2.0f, 41.0f);
        this.Spike3.setTextureSize(512, 256);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, 0.5934119f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Nastysaurus e = (Nastysaurus)entity;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float pscale = 2.0f;
        float tailspeed = 0.0f;
        float tailamp = 0.0f;
        float clawZ = 15.0f;
        float clawY = 21.0f;
        float clawZamp = 5.0f * pscale;
        float clawYamp = 2.0f * pscale;
        float pi4 = 0.7853982f;
        r = e.getRenderInfo();
        f3 %= 360.0f;
        f3 *= 0.35f;
        this.neck2.rotateAngleY = (float)Math.toRadians(f3) * 0.5f;
        this.neck3.rotateAngleY = this.head7.rotateAngleY = (this.head3.rotateAngleY = (float)Math.toRadians(f3));
        this.jaw1.rotateAngleY = this.jaw5.rotateAngleY = this.head3.rotateAngleY;
        this.tooth4.rotateAngleY = this.tooth5.rotateAngleY = this.head3.rotateAngleY;
        this.tooth3.rotateAngleY = this.tooth5.rotateAngleY;
        this.tooth2.rotateAngleY = this.tooth5.rotateAngleY;
        this.tooth1.rotateAngleY = this.tooth5.rotateAngleY;
        this.tooth9.rotateAngleY = this.tooth10.rotateAngleY = this.head3.rotateAngleY;
        this.tooth8.rotateAngleY = this.tooth10.rotateAngleY;
        this.tooth7.rotateAngleY = this.tooth10.rotateAngleY;
        this.tooth6.rotateAngleY = this.tooth10.rotateAngleY;
        this.tooth14.rotateAngleY = this.tooth15.rotateAngleY = this.head3.rotateAngleY;
        this.tooth13.rotateAngleY = this.tooth15.rotateAngleY;
        this.tooth12.rotateAngleY = this.tooth15.rotateAngleY;
        this.tooth11.rotateAngleY = this.tooth15.rotateAngleY;
        this.tooth19.rotateAngleY = this.tooth20.rotateAngleY = this.head3.rotateAngleY;
        this.tooth18.rotateAngleY = this.tooth20.rotateAngleY;
        this.tooth17.rotateAngleY = this.tooth20.rotateAngleY;
        this.tooth16.rotateAngleY = this.tooth20.rotateAngleY;
        this.tooth22.rotateAngleY = this.tooth23.rotateAngleY = this.head3.rotateAngleY;
        this.tooth21.rotateAngleY = this.tooth23.rotateAngleY;
        if (e.getAttacking() != 0) {
            newangle = MathHelper.cos((float)(f2 * 0.85f * this.wingspeed)) * 3.1415927f * 0.16f;
            newangle += 0.5f;
        } else {
            newangle = f2 * 0.7f * this.wingspeed % 6.2831855f;
            if ((newangle = Math.abs(newangle)) < r.rf1) {
                r.ri1 = 0;
                if (e.worldObj.rand.nextInt(20) == 1) {
                    r.ri1 |= 1;
                }
            }
            r.rf1 = newangle;
            if (r.ri1 != 0) {
                newangle = MathHelper.sin((float)(f2 * 0.85f * this.wingspeed)) * 3.1415927f * 0.16f;
                newangle += 0.5f;
            } else {
                newangle = pi4 / 4.0f;
            }
        }
        this.jaw1.rotateAngleX = this.jaw5.rotateAngleX = newangle;
        this.tooth14.rotateAngleX = this.tooth15.rotateAngleX = newangle;
        this.tooth19.rotateAngleX = this.tooth20.rotateAngleX = newangle;
        this.tooth18.rotateAngleX = this.tooth20.rotateAngleX;
        this.tooth17.rotateAngleX = this.tooth20.rotateAngleX;
        this.tooth16.rotateAngleX = this.tooth20.rotateAngleX;
        this.tooth22.rotateAngleX = this.tooth23.rotateAngleX = newangle;
        this.tooth21.rotateAngleX = this.tooth23.rotateAngleX;
        float t1 = 0.0f;
        float t2 = 0.0f;
        if ((double)f1 > 0.001) {
            newangle = MathHelper.cos((float)(f2 * this.wingspeed / pscale));
            t1 = MathHelper.sin((float)(f2 * this.wingspeed / pscale));
        } else {
            newangle = 0.0f;
            t1 = 0.0f;
            t2 = 0.0f;
        }
        if (t1 > 0.0f) {
            t2 = t1 * clawYamp * f1;
            this.lclaw1.rotationPointY = clawY - t2;
        } else {
            this.lclaw1.rotationPointY = clawY;
        }
        this.lclaw6.rotationPointZ = this.lclaw7.rotationPointZ = (this.lclaw1.rotationPointZ = clawZ + clawZamp * newangle * f1);
        this.lclaw5.rotationPointZ = this.lclaw7.rotationPointZ;
        this.lclaw4.rotationPointZ = this.lclaw7.rotationPointZ;
        this.lclaw3.rotationPointZ = this.lclaw7.rotationPointZ;
        this.lclaw2.rotationPointZ = this.lclaw7.rotationPointZ;
        this.lclaw6.rotationPointY = this.lclaw7.rotationPointY = this.lclaw1.rotationPointY;
        this.lclaw5.rotationPointY = this.lclaw7.rotationPointY;
        this.lclaw4.rotationPointY = this.lclaw7.rotationPointY;
        this.lclaw3.rotationPointY = this.lclaw7.rotationPointY;
        this.lclaw2.rotationPointY = this.lclaw7.rotationPointY;
        this.leftleg3.rotationPointZ = this.lclaw1.rotationPointZ;
        this.leftleg3.rotationPointY = this.lclaw1.rotationPointY;
        this.leftleg3.rotateAngleX = -0.523f + newangle * 3.1415927f * 0.15f * f1;
        this.leftleg1.rotateAngleX = -0.576f + newangle * 3.1415927f * 0.06f * f1;
        this.leftleg2.rotateAngleX = 0.977f + newangle * 3.1415927f * 0.06f * f1;
        this.leftleg1.rotationPointY = this.leftleg2.rotationPointY = this.leftleg3.rotationPointY - (float)Math.cos(this.leftleg3.rotateAngleX) * 17.0f;
        this.leftleg1.rotationPointZ = this.leftleg2.rotationPointZ = this.leftleg3.rotationPointZ - (float)Math.sin(this.leftleg3.rotateAngleX) * 17.0f;
        t1 = 0.0f;
        t2 = 0.0f;
        if ((double)f1 > 0.001) {
            newangle = MathHelper.cos((float)(f2 * this.wingspeed / pscale + pi4 * 4.0f));
            t1 = MathHelper.sin((float)(f2 * this.wingspeed / pscale + pi4 * 4.0f));
        } else {
            newangle = 0.0f;
            t1 = 0.0f;
            t2 = 0.0f;
        }
        if (t1 > 0.0f) {
            t2 = t1 * clawYamp * f1;
            this.rclaw1.rotationPointY = clawY - t2;
        } else {
            this.rclaw1.rotationPointY = clawY;
        }
        this.rclaw6.rotationPointZ = this.rclaw7.rotationPointZ = (this.rclaw1.rotationPointZ = clawZ + clawZamp * newangle * f1);
        this.rclaw5.rotationPointZ = this.rclaw7.rotationPointZ;
        this.rclaw4.rotationPointZ = this.rclaw7.rotationPointZ;
        this.rclaw3.rotationPointZ = this.rclaw7.rotationPointZ;
        this.rclaw2.rotationPointZ = this.rclaw7.rotationPointZ;
        this.rclaw6.rotationPointY = this.rclaw7.rotationPointY = this.rclaw1.rotationPointY;
        this.rclaw5.rotationPointY = this.rclaw7.rotationPointY;
        this.rclaw4.rotationPointY = this.rclaw7.rotationPointY;
        this.rclaw3.rotationPointY = this.rclaw7.rotationPointY;
        this.rclaw2.rotationPointY = this.rclaw7.rotationPointY;
        this.rightleg3.rotationPointZ = this.rclaw1.rotationPointZ;
        this.rightleg3.rotationPointY = this.rclaw1.rotationPointY;
        this.rightleg3.rotateAngleX = -0.523f + newangle * 3.1415927f * 0.15f * f1;
        this.rightleg1.rotateAngleX = -0.576f + newangle * 3.1415927f * 0.06f * f1;
        this.rightleg2.rotateAngleX = 0.977f + newangle * 3.1415927f * 0.06f * f1;
        this.rightleg1.rotationPointY = this.rightleg2.rotationPointY = this.rightleg3.rotationPointY - (float)Math.cos(this.rightleg3.rotateAngleX) * 17.0f;
        this.rightleg1.rotationPointZ = this.rightleg2.rotationPointZ = this.rightleg3.rotationPointZ - (float)Math.sin(this.rightleg3.rotateAngleX) * 17.0f;
        this.lclaw1.rotateAngleX = 0.0f;
        this.lclaw7.rotateAngleX = 0.0f;
        this.lclaw6.rotateAngleX = 0.0f;
        this.lclaw5.rotateAngleX = 0.0f;
        this.lclaw4.rotateAngleX = 0.0f;
        this.lclaw3.rotateAngleX = 0.0f;
        this.lclaw2.rotateAngleX = 0.0f;
        this.rclaw1.rotateAngleX = 0.0f;
        this.rclaw7.rotateAngleX = 0.0f;
        this.rclaw6.rotateAngleX = 0.0f;
        this.rclaw5.rotateAngleX = 0.0f;
        this.rclaw4.rotateAngleX = 0.0f;
        this.rclaw3.rotateAngleX = 0.0f;
        this.rclaw2.rotateAngleX = 0.0f;
        if (e.getAttacking() != 0) {
            tailspeed = 0.76f;
            tailamp = 0.25f;
        } else {
            tailspeed = 0.26f;
            tailamp = 0.08f;
        }
        this.tail3.rotateAngleY = MathHelper.cos((float)(f2 * tailspeed * this.wingspeed)) * 3.1415927f * tailamp / 2.0f;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ + (float)Math.cos(this.tail3.rotateAngleY) * 11.0f;
        this.tail4.rotationPointX = this.tail3.rotationPointX + (float)Math.sin(this.tail3.rotateAngleY) * 11.0f;
        this.tail4.rotateAngleY = MathHelper.cos((float)(f2 * tailspeed * this.wingspeed)) * 3.1415927f * tailamp;
        e.setRenderInfo(r);
        this.lclaw1.render(f5);
        this.body.render(f5);
        this.leftleg1.render(f5);
        this.tail1.render(f5);
        this.leftleg2.render(f5);
        this.body2.render(f5);
        this.leftleg3.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.lclaw2.render(f5);
        this.lclaw3.render(f5);
        this.lclaw4.render(f5);
        this.lclaw5.render(f5);
        this.lclaw6.render(f5);
        this.lclaw7.render(f5);
        this.neck3.render(f5);
        this.head3.render(f5);
        this.jaw1.render(f5);
        this.tooth1.render(f5);
        this.tooth2.render(f5);
        this.tooth3.render(f5);
        this.tooth4.render(f5);
        this.tooth5.render(f5);
        this.jaw5.render(f5);
        this.head7.render(f5);
        this.tooth6.render(f5);
        this.tooth7.render(f5);
        this.tooth8.render(f5);
        this.tooth9.render(f5);
        this.tooth10.render(f5);
        this.tooth11.render(f5);
        this.tooth12.render(f5);
        this.tooth13.render(f5);
        this.rightleg1.render(f5);
        this.rightleg2.render(f5);
        this.tooth14.render(f5);
        this.tooth15.render(f5);
        this.tooth16.render(f5);
        this.tooth17.render(f5);
        this.tooth18.render(f5);
        this.tooth19.render(f5);
        this.tooth20.render(f5);
        this.tooth21.render(f5);
        this.tooth22.render(f5);
        this.tooth23.render(f5);
        this.rightleg3.render(f5);
        this.rclaw2.render(f5);
        this.rclaw4.render(f5);
        this.rclaw1.render(f5);
        this.rclaw5.render(f5);
        this.rclaw7.render(f5);
        this.rclaw3.render(f5);
        this.rclaw6.render(f5);
        this.neck1.render(f5);
        this.neck2.render(f5);
        this.tail4.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
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
