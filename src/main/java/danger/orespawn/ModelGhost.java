/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelGhost
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelGhost
extends ModelBase {
    ModelRenderer HeadAndBody;
    ModelRenderer LArm;
    ModelRenderer RArm;

    public ModelGhost() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.HeadAndBody = new ModelRenderer((ModelBase)this, 0, 0);
        this.HeadAndBody.addBox(-3.0f, 0.0f, -3.0f, 6, 21, 6);
        this.HeadAndBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.HeadAndBody.setTextureSize(64, 64);
        this.HeadAndBody.mirror = true;
        this.setRotation(this.HeadAndBody, 0.0f, 0.0f, 0.0f);
        this.LArm = new ModelRenderer((ModelBase)this, 34, 0);
        this.LArm.addBox(-1.0f, -1.0f, -1.0f, 2, 11, 2);
        this.LArm.setRotationPoint(3.0f, 6.0f, 0.0f);
        this.LArm.setTextureSize(64, 64);
        this.LArm.mirror = true;
        this.setRotation(this.LArm, 0.0f, 0.0f, -0.3316126f);
        this.RArm = new ModelRenderer((ModelBase)this, 25, 0);
        this.RArm.addBox(-1.0f, -1.0f, -1.0f, 2, 11, 2);
        this.RArm.setRotationPoint(-3.0f, 6.0f, 0.0f);
        this.RArm.setTextureSize(64, 64);
        this.RArm.mirror = true;
        this.setRotation(this.RArm, 0.0f, 0.0f, 0.3316126f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.LArm.rotateAngleZ = -0.33f + MathHelper.cos((float)(f2 * 0.3f)) * 3.1415927f * 0.05f;
        this.RArm.rotateAngleZ = 0.33f + MathHelper.cos((float)(f2 * 0.32f)) * 3.1415927f * 0.05f;
        this.LArm.rotateAngleX = -0.33f + MathHelper.cos((float)(f2 * 0.34f)) * 3.1415927f * 0.05f;
        this.RArm.rotateAngleX = 0.33f + MathHelper.cos((float)(f2 * 0.36f)) * 3.1415927f * 0.05f;
        GL11.glPushMatrix();
        GL11.glEnable((int)2977);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)0.75f, (float)0.75f, (float)0.75f, (float)0.25f);
        this.HeadAndBody.render(f5);
        this.LArm.render(f5);
        this.RArm.render(f5);
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

