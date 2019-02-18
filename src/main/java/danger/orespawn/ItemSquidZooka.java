/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.AttackSquid
 *  danger.orespawn.ItemSquidZooka
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.AttackSquid;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class ItemSquidZooka
extends Item {
    public ItemSquidZooka(int i) {
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
            return par1ItemStack;
        }
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.explode", 0.5f, 0.5f);
        if (!par2World.isRemote) {
            double xzoff = 2.5;
            double yoff = 1.65;
            Entity e = ItemSquidZooka.spawnCreature((World)par2World, (String)"Attack Squid", (double)(par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 15.0f))), (double)(par3EntityPlayer.posY + yoff), (double)(par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 15.0f))));
            if (e instanceof AttackSquid) {
                AttackSquid a = (AttackSquid)e;
                a.setWasShot();
            }
            float f = 3.6f;
            e.motionX = (- MathHelper.sin((float)(par3EntityPlayer.rotationYaw / 180.0f * 3.1415927f))) * MathHelper.cos((float)(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f)) * f;
            e.motionZ = MathHelper.cos((float)(par3EntityPlayer.rotationYaw / 180.0f * 3.1415927f)) * MathHelper.cos((float)(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f)) * f;
            e.motionY = (- MathHelper.sin((float)(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f))) * f;
            e.motionX += (double)(par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
            e.motionY += (double)(par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
            e.motionZ += (double)(par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
        }
        par3EntityPlayer.swingItem();
        par3EntityPlayer.addVelocity(Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.45, 0.1, Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.45);
        par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
        return par1ItemStack;
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

