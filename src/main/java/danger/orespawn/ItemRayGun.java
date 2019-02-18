/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemRayGun
 *  danger.orespawn.LaserBall
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.LaserBall;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemRayGun
extends Item {
    public ItemRayGun(int i) {
        this.maxStackSize = 1;
        this.setMaxDamage(50);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
            return par1ItemStack;
        }
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "fireworks.launch", 3.5f, 0.5f);
        if (!par2World.isRemote) {
            double xzoff = 1.0;
            double yoff = 1.55;
            LaserBall lb = new LaserBall(par2World, (EntityLivingBase)par3EntityPlayer);
            lb.setSpecial();
            lb.setLocationAndAngles(par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)), par3EntityPlayer.posY + yoff, par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)), par3EntityPlayer.rotationYawHead, par3EntityPlayer.rotationPitch);
            lb.motionX *= 3.0;
            lb.motionY *= 3.0;
            lb.motionZ *= 3.0;
            par2World.spawnEntityInWorld((Entity)lb);
        }
        par3EntityPlayer.swingItem();
        par3EntityPlayer.addVelocity(Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 1.5, 0.3, Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 1.5);
        par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
        return par1ItemStack;
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

