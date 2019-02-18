/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemNetherLost
 *  net.minecraft.block.Block
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class ItemNetherLost
extends Item {
    public ItemNetherLost(int par1) {
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.sharpness, 2);
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.sharpness.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.sharpness, 2);
        }
    }

    public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
        Block i;
        Item it;
        ItemStack is;
        EntityLivingBase e = null;
        EntityPlayer p = null;
        this.onUsingTick(stack, (EntityPlayer)null, 0);
        if (par2World == null) {
            return;
        }
        if (par3Entity != null && par3Entity instanceof EntityLivingBase && (e = (EntityLivingBase)par3Entity) instanceof EntityPlayer && (is = (p = (EntityPlayer)e).getCurrentEquippedItem()) != null && (it = is.getItem()) != null && it instanceof ItemNetherLost && par2World.provider.dimensionId == -1 && (i = par2World.getBlock((int)p.posX, (int)p.posY - 1, (int)p.posZ)) == Blocks.netherrack) {
            par2World.setBlock((int)p.posX, (int)p.posY - 1, (int)p.posZ, Blocks.quartz_block);
        }
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 3000;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

