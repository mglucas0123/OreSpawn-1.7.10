/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.UltimateSword
 *  danger.orespawn.WeaponStats
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.Boyfriend;
import danger.orespawn.Girlfriend;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.WeaponStats;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class UltimateSword
extends ItemSword {
    private int swingtimer = 0;
    private boolean leaf = false;

    public UltimateSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (this == OreSpawnMain.MyChainsaw) {
            return;
        }
        if (this != OreSpawnMain.MyBattleAxe) {
            par1ItemStack.addEnchantment(Enchantment.sharpness, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.smite, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.knockback, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.fireAspect, 1 + OreSpawnMain.UltimateSwordMagic / 3);
        } else {
            par1ItemStack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
        }
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (this == OreSpawnMain.MyChainsaw && entityLiving != null && this.swingtimer == 0) {
            entityLiving.playSound("orespawn:chainsawshort", 1.0f, entityLiving.worldObj.rand.nextFloat() * 0.2f + 0.9f);
            this.swingtimer = 50;
        }
        return false;
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        if (this == OreSpawnMain.MyChainsaw) {
            return;
        }
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.looting.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            if (this != OreSpawnMain.MyBattleAxe) {
                stack.addEnchantment(Enchantment.sharpness, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.smite, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.baneOfArthropods, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.knockback, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.fireAspect, 1 + OreSpawnMain.UltimateSwordMagic / 3);
            } else {
                stack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            }
        }
    }

    public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
        if (this == OreSpawnMain.MyChainsaw) {
            if (this.swingtimer > 0) {
                --this.swingtimer;
            }
            if (par2World.isRemote && this.swingtimer > 0) {
                float f = 1.0f;
                float dx = (float)((double)f * Math.cos(Math.toRadians(par3Entity.rotationYaw + 90.0f + 45.0f)));
                float dz = (float)((double)f * Math.sin(Math.toRadians(par3Entity.rotationYaw + 90.0f + 45.0f)));
                if (par2World.rand.nextInt(8) == 0) {
                    par2World.spawnParticle("flame", par3Entity.posX + (double)dx, par3Entity.posY, par3Entity.posZ + (double)dz, (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f), (double)(par2World.rand.nextFloat() / 10.0f), (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
                if (par2World.rand.nextInt(2) == 0) {
                    par2World.spawnParticle("smoke", par3Entity.posX + (double)dx, par3Entity.posY, par3Entity.posZ + (double)dz, (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f), (double)(par2World.rand.nextFloat() / 10.0f), (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
                if (par2World.rand.nextInt(10) == 0) {
                    par2World.spawnParticle("fireworksSpark", par3Entity.posX + (double)dx, par3Entity.posY, par3Entity.posZ + (double)dz, (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f), (double)(par2World.rand.nextFloat() / 5.0f), (double)((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
            }
            return;
        }
        int lvl = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.looting.effectId, (ItemStack)stack);
        if (lvl <= 0) {
            if (this != OreSpawnMain.MyBattleAxe) {
                stack.addEnchantment(Enchantment.sharpness, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.smite, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.baneOfArthropods, OreSpawnMain.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.knockback, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.fireAspect, 1 + OreSpawnMain.UltimateSwordMagic / 3);
            } else {
                stack.addEnchantment(Enchantment.looting, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            }
        }
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityLiving);
        return true;
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
        if (this == OreSpawnMain.MyChainsaw && player != null) {
            this.findSomethingToHit(player);
        }
        return false;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 9000;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }

    private void findSomethingToHit(EntityPlayer player) {
        List var5 = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, player.boundingBox.expand(5.0, 5.0, 5.0));
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (!this.isSuitableTarget(var4, false, player)) continue;
            var4.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), (float)OreSpawnMain.chainsaw_stats.damage);
        }
    }

    private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2, EntityPlayer player) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == player) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (OreSpawnMain.ultimate_sword_pvp == 0) {
            EntityTameable t;
            if (par1EntityLiving instanceof EntityPlayer || par1EntityLiving instanceof Girlfriend || par1EntityLiving instanceof Boyfriend) {
                return false;
            }
            if (par1EntityLiving instanceof EntityTameable && (t = (EntityTameable)par1EntityLiving).isTamed()) {
                return false;
            }
        }
        if (!this.MyCanSee(par1EntityLiving, player)) {
            return false;
        }
        return true;
    }

    public boolean MyCanSee(EntityLivingBase e, EntityPlayer player) {
        int nblks = 10;
        double cx = player.posX;
        double cz = player.posZ;
        float startx = (float)cx;
        float starty = (float)(player.posY + 1.399999976158142);
        float startz = (float)cz;
        float dx = (float)((e.posX - (double)startx) / 10.0);
        float dy = (float)((e.posY + (double)(e.height / 2.0f) - (double)starty) / 10.0);
        float dz = (float)((e.posZ - (double)startz) / 10.0);
        if ((double)Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks = (int)((float)nblks * Math.abs(dx));
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if ((double)Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks = (int)((float)nblks * Math.abs(dy));
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if ((double)Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks = (int)((float)nblks * Math.abs(dz));
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            Block bid = player.worldObj.getBlock((int)(startx += dx), (int)(starty += dy), (int)(startz += dz));
            if (bid == Blocks.air) continue;
            return false;
        }
        return true;
    }

    public boolean canHarvestBlock(Block par1Block) {
        return this.canCrush(par1Block);
    }

    private boolean canCrush(Block blockID) {
        if (this == OreSpawnMain.MyChainsaw) {
            if (blockID == Blocks.web) {
                return true;
            }
            if (blockID == Blocks.log) {
                return true;
            }
            if (blockID == Blocks.leaves) {
                return true;
            }
            if (blockID == Blocks.planks) {
                return true;
            }
            if (blockID == Blocks.sapling) {
                return true;
            }
            if (blockID == Blocks.tallgrass) {
                return true;
            }
            if (blockID == Blocks.cactus) {
                return true;
            }
            if (blockID == OreSpawnMain.CrystalPlanksBlock) {
                return true;
            }
            if (blockID == OreSpawnMain.MyAppleLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MySkyTreeLog) {
                return true;
            }
            if (blockID == OreSpawnMain.MyDT) {
                return true;
            }
            if (blockID == OreSpawnMain.MyExperienceLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MyScaryLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MyCherryLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MyPeachLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MyCrystalLeaves) {
                return true;
            }
            if (blockID == OreSpawnMain.MyCrystalLeaves2) {
                return true;
            }
            if (blockID == OreSpawnMain.MyCrystalLeaves3) {
                return true;
            }
            if (blockID == OreSpawnMain.MyCrystalTreeLog) {
                return true;
            }
            return false;
        }
        return blockID == Blocks.web;
    }

    private boolean isLeaves(Block blockID) {
        if (blockID == Blocks.web) {
            return true;
        }
        if (blockID == Blocks.leaves) {
            return true;
        }
        if (blockID == Blocks.sapling) {
            return true;
        }
        if (blockID == Blocks.tallgrass) {
            return true;
        }
        if (blockID == OreSpawnMain.MyAppleLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyExperienceLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyScaryLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyCherryLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyPeachLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyCrystalLeaves) {
            return true;
        }
        if (blockID == OreSpawnMain.MyCrystalLeaves2) {
            return true;
        }
        if (blockID == OreSpawnMain.MyCrystalLeaves3) {
            return true;
        }
        return false;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
        if (this == OreSpawnMain.MyChainsaw && !par2World.isRemote) {
            for (int i = -5; i <= 5; ++i) {
                for (int j = -5; j <= 10; ++j) {
                    for (int k = -5; k <= 5; ++k) {
                        Block bid = par2World.getBlock(par4 + i, par5 + j, par6 + k);
                        if (this.leaf) {
                            if (!this.isLeaves(bid)) continue;
                            this.dropItemRand(par2World, Item.getItemFromBlock((Block)bid), 1, par4 + i, par5 + j, par6 + k);
                            par2World.setBlock(par4 + i, par5 + j, par6 + k, Blocks.air);
                            continue;
                        }
                        if (!this.canCrush(bid)) continue;
                        this.dropItemRand(par2World, Item.getItemFromBlock((Block)bid), 1, par4 + i, par5 + j, par6 + k);
                        par2World.setBlock(par4 + i, par5 + j, par6 + k, Blocks.air);
                    }
                }
            }
        }
        return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
    }

    private ItemStack dropItemRand(World world, Item index, int par1, int x, int y, int z) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(world, (double)(x + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5)), (double)y + 1.0 + (double)world.rand.nextInt(5), (double)(z + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5)), is);
        if (var3 != null) {
            world.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        if (par2Block != null && this == OreSpawnMain.MyChainsaw) {
            this.leaf = this.isLeaves(par2Block);
            if (par2Block.getMaterial() == Material.wood || par2Block.getMaterial() == Material.plants || par2Block.getMaterial() == Material.vine) {
                return OreSpawnMain.chainsaw_stats.efficiency;
            }
            if (this.canCrush(par2Block)) {
                return OreSpawnMain.chainsaw_stats.efficiency;
            }
        }
        return 2.0f;
    }
}

