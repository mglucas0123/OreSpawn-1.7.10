/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.FMLClientHandler
 *  danger.orespawn.ModelSquidZooka
 *  danger.orespawn.RenderSquidZooka
 *  danger.orespawn.RenderSquidZooka$1
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  org.lwjgl.opengl.GL11
 */
package danger.orespawn;

import cpw.mods.fml.client.FMLClientHandler;
import danger.orespawn.ModelSquidZooka;
import danger.orespawn.RenderSquidZooka;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSquidZooka
implements IItemRenderer {
    protected ModelSquidZooka modelSquidZooka = new ModelSquidZooka();
    private static final ResourceLocation texture = new ResourceLocation("orespawn", "SquidZookatexture.png");

    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        switch (type.ordinal()) {
            case 1: {
                return true;
            }
            case 2: {
                return true;
            }
        }
        return false;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public /* varargs */ void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object ... data) {
        switch (type.ordinal()) {
            case 1: {
                this.renderSwordF5(2.0f, 8.0f, 2.0f, 0.35f);
                break;
            }
            case 2: {
                this.renderSword(4.0f, 2.0f, 2.0f, 0.35f);
                break;
            }
        }
    }

    private void renderSword(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef((float)-30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)scale, (float)scale, (float)scale);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
        this.modelSquidZooka.render();
        GL11.glPopMatrix();
    }

    private void renderSwordF5(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)scale, (float)scale, (float)scale);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
        this.modelSquidZooka.render();
        GL11.glPopMatrix();
    }
}

