/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.PoisonSword
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PoisonSword
extends ItemSword {
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;

    public PoisonSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.maxStackSize = 1;
        this.setMaxDamage(1300);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.sharpness, 1);
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.sharpness.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.sharpness, 1);
        }
    }

    public String getMaterialName() {
        return "Emerald";
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
        int var2 = 5;
        if (par2EntityLiving != null) {
            var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
            var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, var2 * 20, 0));
            var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, var2 * 20, 0));
        }
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 3000;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

