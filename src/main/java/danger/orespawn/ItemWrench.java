/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.AntRobot
 *  danger.orespawn.ItemWrench
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.SpiderRobot
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.AntRobot;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.SpiderRobot;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemWrench
extends Item {
    public ItemWrench(int i) {
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setMaxDamage(100);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity != null && entity instanceof SpiderRobot && entity.riddenByEntity == null) {
            EntityLiving e = (EntityLiving)entity;
            float h = e.getMaxHealth() - e.getHealth();
            e.setDead();
            this.dropItem(player.worldObj, e, OreSpawnMain.SpiderRobotKit, 1, (int)h);
            for (int var3 = 0; var3 < 8; ++var3) {
                float f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                float f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                float f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("smoke", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
                f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("explode", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
                f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("reddust", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
            }
            player.worldObj.playSoundAtEntity((Entity)player, "random.explode", 0.5f, 1.5f);
        } else if (entity != null && entity instanceof AntRobot && entity.riddenByEntity == null) {
            AntRobot e = (AntRobot)entity;
            if (e.getOwned() == 0) {
                if (e.getHealth() / e.getMaxHealth() > 0.5f) {
                    return false;
                }
                e.setOwned();
            }
            float h = e.getMaxHealth() - e.getHealth();
            e.setDead();
            this.dropItem(player.worldObj, (EntityLiving)e, OreSpawnMain.AntRobotKit, 1, (int)h);
            for (int var3 = 0; var3 < 8; ++var3) {
                float f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                float f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                float f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("smoke", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
                f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("explode", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
                f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
                f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
                player.worldObj.spawnParticle("reddust", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0, 0.0, 0.0);
            }
            player.worldObj.playSoundAtEntity((Entity)player, "random.explode", 0.5f, 1.5f);
        } else {
            return false;
        }
        stack.damageItem(2, (EntityLivingBase)player);
        if (stack.stackSize <= 0) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        }
        return true;
    }

    private void dropItem(World world, EntityLiving e, Item index, int par1, int par2) {
        if (world.isRemote) {
            return;
        }
        ItemStack is = new ItemStack(index, par1, 0);
        is.setItemDamage(par2);
        EntityItem var3 = new EntityItem(world, e.posX, e.posY + 1.0, e.posZ, is);
        world.spawnEntityInWorld((Entity)var3);
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

