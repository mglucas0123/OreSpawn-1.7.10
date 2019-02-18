/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.Fairy
 *  danger.orespawn.FairySword
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
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
import danger.orespawn.Fairy;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class FairySword
extends ItemSword {
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;

    public FairySword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.maxStackSize = 1;
        this.setMaxDamage(1300);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public String getMaterialName() {
        return "Fairy";
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
        int var2 = 5;
        if (par2EntityLiving != null && !par2EntityLiving.worldObj.isRemote) {
            int num = 1 + par2EntityLiving.worldObj.rand.nextInt(3);
            for (int i = 0; i < num; ++i) {
                Fairy r = null;
                r = (Fairy)FairySword.spawnCreature((World)par2EntityLiving.worldObj, (int)0, (String)"Fairy", (double)(par2EntityLiving.posX + (double)(par2EntityLiving.worldObj.rand.nextFloat() - par2EntityLiving.worldObj.rand.nextFloat()) * 0.5), (double)(par2EntityLiving.posY + (double)par2EntityLiving.worldObj.rand.nextFloat() + 0.01), (double)(par2EntityLiving.posZ + (double)(par2EntityLiving.worldObj.rand.nextFloat() - par2EntityLiving.worldObj.rand.nextFloat()) * 0.5));
                if (r == null) continue;
                r.setOwner(par3EntityLiving);
            }
        }
        par1ItemStack.damageItem(1, par3EntityLiving);
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

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 3000;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

