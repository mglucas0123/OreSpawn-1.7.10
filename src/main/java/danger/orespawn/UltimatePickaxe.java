/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.UltimatePickaxe
 *  net.minecraft.block.Block
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.Boyfriend;
import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class UltimatePickaxe
extends ItemPickaxe {
    private int weaponDamage = 15;

    public UltimatePickaxe(int par1, Item.ToolMaterial par2) {
        super(par2);
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
        par1ItemStack.addEnchantment(Enchantment.fortune, 5);
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.efficiency.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.efficiency, 5);
            stack.addEnchantment(Enchantment.fortune, 5);
        }
    }

    public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
        this.onUsingTick(stack, (EntityPlayer)null, 0);
    }

    public boolean canHarvestBlock(Block par1Block) {
        return true;
    }

    public int getDamageVsEntity(Entity par1Entity) {
        if (par1Entity instanceof Girlfriend) {
            return 1;
        }
        if (par1Entity instanceof Boyfriend) {
            return 1;
        }
        if (par1Entity instanceof EntityPlayer) {
            return 1;
        }
        return this.weaponDamage;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity != null && OreSpawnMain.ultimate_sword_pvp == 0) {
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

    private ItemStack dropItemAnItem(World world, int x, int y, int z, Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(world, (double)x, (double)y, (double)z, is);
        if (var3 != null) {
            world.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
        if ((double)par3.getBlockHardness(par2World, par4, par5, par6) != 0.0) {
            par1ItemStack.damageItem(1, par7EntityLivingBase);
        }
        if (!par2World.isRemote) {
            if (par3 == Blocks.iron_ore && par2World.rand.nextInt(2) != 0) {
                this.dropItemAnItem(par2World, par4, par5, par6, Items.iron_ingot, 1 + par2World.rand.nextInt(2));
            }
            if (par3 == Blocks.gold_ore && par2World.rand.nextInt(2) != 0) {
                this.dropItemAnItem(par2World, par4, par5, par6, Items.gold_ingot, 1 + par2World.rand.nextInt(2));
            }
            if (par3 == Blocks.stone && par2World.rand.nextInt(100) == 2) {
                int i = par2World.rand.nextInt(10);
                if (i == 0) {
                    this.dropItemAnItem(par2World, par4, par5, par6, Items.diamond, 1);
                }
                if (i == 1) {
                    this.dropItemAnItem(par2World, par4, par5, par6, Items.emerald, 1);
                }
                if (i == 2) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyAmethyst, 1);
                }
                if (i == 3) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyRuby, 1);
                }
                if (i == 4) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.UraniumNugget, 1);
                }
                if (i == 5) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.TitaniumNugget, 1);
                }
            }
        }
        return true;
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

