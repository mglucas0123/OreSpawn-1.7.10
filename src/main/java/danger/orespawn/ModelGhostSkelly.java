/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.GhostSkelly
 *  danger.orespawn.ModelGhostSkelly
 *  danger.orespawn.RenderInfo
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import danger.orespawn.GhostSkelly;
import danger.orespawn.RenderInfo;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ModelGhostSkelly
extends ModelBase {
    ModelRenderer body;
    ModelRenderer shirt;
    ModelRenderer head;
    ModelRenderer stem;
    ModelRenderer rarm;
    ModelRenderer larm;
    ModelRenderer rsleeve;
    ModelRenderer lsleeve;
    ModelRenderer lchains;
    ModelRenderer rchains;

    public ModelGhostSkelly() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(0.0f, 0.0f, 0.0f, 1, 21, 1);
        this.body.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.shirt = new ModelRenderer((ModelBase)this, 42, 43);
        this.shirt.addBox(-2.0f, 0.0f, -2.0f, 5, 12, 5);
        this.shirt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.shirt.setTextureSize(128, 64);
        this.shirt.mirror = true;
        this.setRotation(this.shirt, 0.0f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 40, 29);
        this.head.addBox(-3.0f, 0.0f, -3.0f, 7, 5, 7);
        this.head.setRotationPoint(0.0f, -6.0f, 0.0f);
        this.head.setTextureSize(128, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.stem = new ModelRenderer((ModelBase)this, 49, 23);
        this.stem.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.stem.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.stem.setTextureSize(128, 64);
        this.stem.mirror = true;
        this.setRotation(this.stem, 0.1745329f, 0.0f, 0.1745329f);
        this.rarm = new ModelRenderer((ModelBase)this, 26, 0);
        this.rarm.addBox(-14.0f, 0.0f, 0.0f, 15, 1, 1);
        this.rarm.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.rarm.setTextureSize(128, 64);
        this.rarm.mirror = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.0f);
        this.larm = new ModelRenderer((ModelBase)this, 63, 0);
        this.larm.addBox(0.0f, 0.0f, 0.0f, 15, 1, 1);
        this.larm.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.larm.setTextureSize(128, 64);
        this.larm.mirror = true;
        this.setRotation(this.larm, 0.0f, 0.0f, 0.0f);
        this.rsleeve = new ModelRenderer((ModelBase)this, 31, 7);
        this.rsleeve.addBox(-11.0f, 0.0f, -1.0f, 9, 8, 3);
        this.rsleeve.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.rsleeve.setTextureSize(128, 64);
        this.rsleeve.mirror = true;
        this.setRotation(this.rsleeve, 0.0f, 0.0f, 0.0f);
        this.lsleeve = new ModelRenderer((ModelBase)this, 71, 7);
        this.lsleeve.addBox(3.0f, 0.0f, -1.0f, 9, 8, 3);
        this.lsleeve.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.lsleeve.setTextureSize(128, 64);
        this.lsleeve.mirror = true;
        this.setRotation(this.lsleeve, 0.0f, 0.0f, 0.0f);
        this.lchains = new ModelRenderer((ModelBase)this, 98, 0);
        this.lchains.addBox(11.0f, -1.0f, 0.0f, 3, 16, 1);
        this.lchains.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.lchains.setTextureSize(128, 64);
        this.lchains.mirror = true;
        this.setRotation(this.lchains, 0.0f, 0.0f, 0.0f);
        this.rchains = new ModelRenderer((ModelBase)this, 12, 0);
        this.rchains.addBox(-13.0f, -1.0f, 0.0f, 3, 10, 1);
        this.rchains.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.rchains.setTextureSize(128, 64);
        this.rchains.mirror = true;
        this.setRotation(this.rchains, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GhostSkelly e = (GhostSkelly)entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float newrf1 = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        this.lsleeve.rotateAngleZ = this.lchains.rotateAngleZ = MathHelper.cos((float)(f2 * 0.2f)) * 3.1415927f * 0.05f;
        this.larm.rotateAngleZ = this.lchains.rotateAngleZ;
        this.rsleeve.rotateAngleZ = this.rchains.rotateAngleZ = MathHelper.cos((float)(f2 * 0.22f)) * 3.1415927f * 0.05f;
        this.rarm.rotateAngleZ = this.rchains.rotateAngleZ;
        this.lsleeve.rotateAngleY = this.lchains.rotateAngleY = MathHelper.cos((float)(f2 * 0.24f)) * 3.1415927f * 0.05f;
        this.larm.rotateAngleY = this.lchains.rotateAngleY;
        this.rsleeve.rotateAngleY = this.rchains.rotateAngleY = MathHelper.cos((float)(f2 * 0.26f)) * 3.1415927f * 0.05f;
        this.rarm.rotateAngleY = this.rchains.rotateAngleY;
        newangle = MathHelper.cos((float)(f2 * 0.05f)) * 3.1415927f * 2.0f;
        newrf1 = f2 * 0.05f % 6.2831855f;
        newrf1 = Math.abs(newrf1);
        if (newrf1 < r.rf2) {
            r.ri2 = 0;
            if (e.worldObj.rand.nextInt(3) == 1) {
                r.ri2 |= 1;
            }
        }
        r.rf2 = newrf1;
        if ((r.ri2 & 1) == 0) {
            newangle = 0.0f;
        }
        this.head.rotateAngleY = newangle;
        e.setRenderInfo(r);
        GL11.glPushMatrix();
        GL11.glEnable((int)2977);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)0.75f, (float)0.75f, (float)0.75f, (float)0.25f);
        this.body.render(f5);
        this.shirt.render(f5);
        this.head.render(f5);
        this.stem.render(f5);
        this.rarm.render(f5);
        this.larm.render(f5);
        this.rsleeve.render(f5);
        this.lsleeve.render(f5);
        this.lchains.render(f5);
        this.rchains.render(f5);
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

