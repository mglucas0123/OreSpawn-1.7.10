/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemCreeperLauncher
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemCreeperLauncher
extends Item {
    public ItemCreeperLauncher(int i) {
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setMaxDamage(1);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity != null && entity instanceof EntityCreeper) {
            for (int var3 = 0; var3 < 6; ++var3) {
                float f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                float f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                float f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("smoke", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, (double)(f2 / 4.0f), 0.0);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("explode", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, (double)(f2 / 4.0f), 0.0);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("reddust", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, (double)(f2 / 4.0f), 0.0);
            }
        } else {
            return false;
        }
        player.worldObj.playSoundAtEntity((Entity)player, "fireworks.launch", 2.0f, 1.2f);
        EntityLiving e = (EntityLiving)entity;
        e.addVelocity(0.0, 4.5, 0.0);
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

