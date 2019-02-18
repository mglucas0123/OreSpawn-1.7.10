/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.AntRobot
 *  danger.orespawn.ItemSpiderRobotKit
 *  danger.orespawn.MobStats
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
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
import danger.orespawn.AntRobot;
import danger.orespawn.MobStats;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class ItemSpiderRobotKit
extends Item {
    public ItemSpiderRobotKit(int i) {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
        if (i == OreSpawnMain.BaseItemID + 471) {
            this.setMaxDamage(OreSpawnMain.SpiderRobot_stats.health);
        } else {
            this.setMaxDamage(OreSpawnMain.AntRobot_stats.health);
        }
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        Entity ent;
        if (par3World.isRemote) {
            return true;
        }
        String name = null;
        name = "Robot Spider";
        if (par1ItemStack.getItem() == OreSpawnMain.AntRobotKit) {
            name = "Robot Red Ant";
        }
        if ((ent = ItemSpiderRobotKit.spawnCreature((World)par3World, (int)0, (String)name, (double)((double)par4 + 0.5), (double)((double)par5 + 1.01), (double)((double)par6 + 0.5))) != null) {
            EntityLiving e = (EntityLiving)ent;
            e.setHealth((float)(this.getMaxDamage() - this.getDamage(par1ItemStack)));
            if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
                ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
            }
            par3World.playSoundAtEntity((Entity)par2EntityPlayer, "random.explode", 1.0f, par3World.rand.nextFloat() * 0.2f + 0.9f);
            if (ent instanceof AntRobot) {
                AntRobot a = (AntRobot)ent;
                a.setOwned();
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = name == null ? EntityList.createEntityByID((int)par1, (World)par0World) : EntityList.createEntityByName((String)name, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

