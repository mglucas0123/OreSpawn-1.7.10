/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.EntityThrownRock
 *  danger.orespawn.ItemRock
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.RockBase
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
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
import danger.orespawn.EntityThrownRock;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.RockBase;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemRock
extends Item {
    public ItemRock(int i) {
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        if (!par2World.isRemote) {
            if (this == OreSpawnMain.MySmallRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 1));
            }
            if (this == OreSpawnMain.MyRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 2));
            }
            if (this == OreSpawnMain.MyRedRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 3));
            }
            if (this == OreSpawnMain.MyGreenRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 4));
            }
            if (this == OreSpawnMain.MyBlueRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 5));
            }
            if (this == OreSpawnMain.MyPurpleRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 6));
            }
            if (this == OreSpawnMain.MySpikeyRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 7));
            }
            if (this == OreSpawnMain.MyTNTRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 8));
            }
            if (this == OreSpawnMain.MyCrystalRedRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 9));
            }
            if (this == OreSpawnMain.MyCrystalGreenRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 10));
            }
            if (this == OreSpawnMain.MyCrystalBlueRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 11));
            }
            if (this == OreSpawnMain.MyCrystalTNTRock) {
                par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 12));
            }
        }
        return par1ItemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            Entity e;
            if (x < 0) {
                ++x;
            }
            if (z < 0) {
                ++z;
            }
            if ((e = this.spawnCreature(world, "Rock", (double)x, (double)y + 1.01, (double)z)) != null) {
                RockBase r = (RockBase)e;
                if (this == OreSpawnMain.MySmallRock) {
                    r.placeRock(1);
                }
                if (this == OreSpawnMain.MyRock) {
                    r.placeRock(2);
                }
                if (this == OreSpawnMain.MyRedRock) {
                    r.placeRock(3);
                }
                if (this == OreSpawnMain.MyGreenRock) {
                    r.placeRock(4);
                }
                if (this == OreSpawnMain.MyBlueRock) {
                    r.placeRock(5);
                }
                if (this == OreSpawnMain.MyPurpleRock) {
                    r.placeRock(6);
                }
                if (this == OreSpawnMain.MySpikeyRock) {
                    r.placeRock(7);
                }
                if (this == OreSpawnMain.MyTNTRock) {
                    r.placeRock(8);
                }
                if (this == OreSpawnMain.MyCrystalRedRock) {
                    r.placeRock(9);
                }
                if (this == OreSpawnMain.MyCrystalGreenRock) {
                    r.placeRock(10);
                }
                if (this == OreSpawnMain.MyCrystalBlueRock) {
                    r.placeRock(11);
                }
                if (this == OreSpawnMain.MyCrystalTNTRock) {
                    r.placeRock(12);
                }
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    private Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            if (par2 > 0.0) {
                par2 += 0.5;
            }
            if (par2 < 0.0) {
                par2 -= 0.5;
            }
            if (par6 > 0.0) {
                par6 += 0.5;
            }
            if (par6 < 0.0) {
                par6 -= 0.5;
            }
            var8.setLocationAndAngles(par2, par4 + 0.01, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
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

