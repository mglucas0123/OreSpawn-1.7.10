/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.EntityThrownRock
 *  danger.orespawn.RenderThrownRock
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
import danger.orespawn.EntityThrownRock;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderThrownRock
extends Render {
    private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "textures/items/rocksmall.png");
    private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "textures/items/rock.png");
    private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "textures/items/rockred.png");
    private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "textures/items/rockgreen.png");
    private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "textures/items/rockblue.png");
    private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "textures/items/rockpurple.png");
    private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "textures/items/rockspikey.png");
    private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "textures/items/rocktnt.png");
    private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "textures/items/rockcrystalred.png");
    private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "textures/items/rockcrystalgreen.png");
    private static final ResourceLocation texture11 = new ResourceLocation("orespawn", "textures/items/rockcrystalblue.png");
    private static final ResourceLocation texture12 = new ResourceLocation("orespawn", "textures/items/rockcrystaltnt.png");

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.bindTexture(this.getEntityTexture(par1Entity));
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glEnable((int)32826);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Tessellator var10 = Tessellator.instance;
        this.func_77026_a(var10, 0, par1Entity.rotationPitch);
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    private void func_77026_a(Tessellator par1Tessellator, int par2, float par3) {
        float var3 = (float)(par2 % 16 * 16 + 0) / 16.0f;
        float var4 = (float)(par2 % 16 * 16 + 16) / 16.0f;
        float var5 = (float)(par2 / 16 * 16 + 0) / 16.0f;
        float var6 = (float)(par2 / 16 * 16 + 16) / 16.0f;
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
        EntityThrownRock r = (EntityThrownRock)entity;
        if (r.getRockType() == 1) {
            return texture1;
        }
        if (r.getRockType() == 2) {
            return texture2;
        }
        if (r.getRockType() == 3) {
            return texture3;
        }
        if (r.getRockType() == 4) {
            return texture4;
        }
        if (r.getRockType() == 5) {
            return texture5;
        }
        if (r.getRockType() == 6) {
            return texture6;
        }
        if (r.getRockType() == 7) {
            return texture7;
        }
        if (r.getRockType() == 8) {
            return texture8;
        }
        if (r.getRockType() == 9) {
            return texture9;
        }
        if (r.getRockType() == 10) {
            return texture10;
        }
        if (r.getRockType() == 11) {
            return texture11;
        }
        if (r.getRockType() == 12) {
            return texture12;
        }
        return texture1;
    }
}

