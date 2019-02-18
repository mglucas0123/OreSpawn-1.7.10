/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.RenderSpinner
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSpinner
extends Render {
    public int spinItemIconIndex = 160;
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "spinners.png");

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glEnable((int)32826);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Tessellator var10 = Tessellator.instance;
        this.func_77026_a(var10, this.spinItemIconIndex, par1Entity.rotationPitch);
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    private void func_77026_a(Tessellator par1Tessellator, int par2, float par3) {
        float var3 = (float)(par2 % 16 * 16 + 0) / 256.0f;
        float var4 = (float)(par2 % 16 * 16 + 16) / 256.0f;
        float var5 = (float)(par2 / 16 * 16 + 0) / 256.0f;
        float var6 = (float)(par2 / 16 * 16 + 16) / 256.0f;
        float var7 = 1.0f;
        float var8 = 0.5f;
        float var9 = 0.25f;
        GL11.glRotatef((float)(180.0f - this.renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(- this.renderManager.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)par3, (float)0.0f, (float)0.0f, (float)1.0f);
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0f, 1.0f, 0.0f);
        par1Tessellator.addVertexWithUV((double)(0.0f - var8), (double)(0.0f - var9), 0.0, (double)var3, (double)var6);
        par1Tessellator.addVertexWithUV((double)(var7 - var8), (double)(0.0f - var9), 0.0, (double)var4, (double)var6);
        par1Tessellator.addVertexWithUV((double)(var7 - var8), (double)(var7 - var9), 0.0, (double)var4, (double)var5);
        par1Tessellator.addVertexWithUV((double)(0.0f - var8), (double)(var7 - var9), 0.0, (double)var3, (double)var5);
        par1Tessellator.draw();
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}

