/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.UltimateArrow
 *  danger.orespawn.UltimateBow
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.UltimateArrow;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class UltimateBow
extends Item {
    public UltimateBow(int par1) {
        this.maxStackSize = 1;
        this.setMaxDamage(1000);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.power, 5);
        par1ItemStack.addEnchantment(Enchantment.flame, 3);
        par1ItemStack.addEnchantment(Enchantment.punch, 2);
        par1ItemStack.addEnchantment(Enchantment.infinity, 1);
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.infinity.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.power, 5);
            stack.addEnchantment(Enchantment.flame, 3);
            stack.addEnchantment(Enchantment.punch, 2);
            stack.addEnchantment(Enchantment.infinity, 1);
        }
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
        int var10;
        UltimateArrow var8 = new UltimateArrow(par2World, par3EntityPlayer, 3.0f);
        if (par2World.rand.nextInt(4) == 1) {
            var8.setIsCritical(true);
        }
        if ((var10 = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)par1ItemStack)) > 0) {
            var8.setKnockbackStrength(var10);
        }
        if (EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)par1ItemStack) > 0) {
            var8.setFire(100);
        }
        par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 1.2f) + 0.5f);
        var8.canBePickedUp = 2;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity)var8);
        }
    }

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 9000;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    public int getItemEnchantability() {
        return 50;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

