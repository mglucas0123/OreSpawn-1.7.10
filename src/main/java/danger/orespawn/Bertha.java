/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.Bertha
 *  danger.orespawn.BerthaHit
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.BerthaHit;
import danger.orespawn.Boyfriend;
import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Bertha
extends ItemSword {
    public Bertha(int par1, Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(9000);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (this == OreSpawnMain.MyRoyal) {
            par1ItemStack.addEnchantment(Enchantment.unbreaking, 5);
        } else if (this != OreSpawnMain.MyHammy) {
            par1ItemStack.addEnchantment(Enchantment.knockback, 5);
            par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, 1);
            par1ItemStack.addEnchantment(Enchantment.fireAspect, 1);
        }
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.knockback.effectId, (ItemStack)stack);
        if (lvl == 0) {
            lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.unbreaking.effectId, (ItemStack)stack);
        }
        if (lvl <= 0) {
            if (this == OreSpawnMain.MyRoyal) {
                stack.addEnchantment(Enchantment.unbreaking, 5);
            } else if (this != OreSpawnMain.MyHammy) {
                stack.addEnchantment(Enchantment.knockback, 5);
                stack.addEnchantment(Enchantment.baneOfArthropods, 1);
                stack.addEnchantment(Enchantment.fireAspect, 1);
            }
        }
    }

    public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
        this.onUsingTick(stack, (EntityPlayer)null, 0);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity != null && OreSpawnMain.big_bertha_pvp == 0) {
            EntityTameable t;
            if (entity instanceof EntityPlayer || entity instanceof Girlfriend || entity instanceof Boyfriend) {
                return true;
            }
            if (entity instanceof EntityTameable && (t = (EntityTameable)entity).isTamed()) {
                return true;
            }
        }
        return false;
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving != null && entityLiving instanceof EntityPlayer && !entityLiving.worldObj.isRemote) {
            EntityPlayer p = (EntityPlayer)entityLiving;
            double xzoff = 2.0;
            double yoff = 1.55;
            BerthaHit lb = new BerthaHit(p.worldObj, (EntityLivingBase)p);
            lb.setLocationAndAngles(p.posX - xzoff * Math.sin(Math.toRadians(p.rotationYawHead)), p.posY + yoff, p.posZ + xzoff * Math.cos(Math.toRadians(p.rotationYawHead)), p.rotationYawHead, p.rotationPitch);
            lb.motionX *= 2.0;
            lb.motionY *= 2.0;
            lb.motionZ *= 2.0;
            if (this == OreSpawnMain.MyRoyal) {
                lb.setHitType(2);
            }
            if (this == OreSpawnMain.MyHammy) {
                lb.setHitType(3);
            }
            p.worldObj.spawnEntityInWorld((Entity)lb);
            stack.damageItem(1, (EntityLivingBase)p);
        }
        return false;
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityLiving);
        return true;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 9000;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

