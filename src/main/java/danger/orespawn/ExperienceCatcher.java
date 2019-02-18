/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ExperienceCatcher
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import java.util.Iterator;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ExperienceCatcher
extends Item {
    public ExperienceCatcher(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
      par2EntityPlayer.swingItem();
      System.out.printf("x, y,z, 7,8,9,10 == %d, %d, %d - %d, %f, %f, %f\n", new Object[] { Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(par7), Float.valueOf(par8), Float.valueOf(par9), Float.valueOf(par10) });
      if (!par2EntityPlayer.worldObj.isRemote) {
        AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(x - 0.5D + par8, y, z - 0.5D + par10, x + 0.5D + par8, y + 2.0D, z + 0.5D + par10);
        List var5 = world.getEntitiesWithinAABB(EntityXPOrb.class, bb);
        Iterator var2 = var5.iterator();
        while (var2.hasNext())
        {
          Entity var3 = (Entity)var2.next();
          if ((var3 instanceof EntityXPOrb))
          {
            EntityXPOrb ex = (EntityXPOrb)var3;

            if ((ex.getXpValue() < 3) || (world.rand.nextInt(5) == 1)) {
              continue;
            }
            var3.setDead();

            EntityItem var4 = null;
            ItemStack is = new ItemStack(Items.experience_bottle, 1, 0);
            var4 = new EntityItem(par2EntityPlayer.worldObj, par8 + x, y + 1.0D, par10 + z, is);
            if (var4 != null) par2EntityPlayer.worldObj.spawnEntityInWorld(var4);

            is = new ItemStack(Items.string, 1, 0);
            var4 = new EntityItem(par2EntityPlayer.worldObj, par8 + x, y + 1.0D, par10 + z, is);
            if (var4 != null) par2EntityPlayer.worldObj.spawnEntityInWorld(var4);

            is = new ItemStack(Items.stick, 1, 0);
            var4 = new EntityItem(par2EntityPlayer.worldObj, par8 + x, y + 1.0D, par10 + z, is);
            if (var4 != null) par2EntityPlayer.worldObj.spawnEntityInWorld(var4);

            if (!par2EntityPlayer.capabilities.isCreativeMode)
            {
              par1ItemStack.stackSize -= 1;
            }
            return true;
          }

        }

        EntityItem var4 = null;
        ItemStack is = new ItemStack(OreSpawnMain.MyExperienceCatcher, 1, 0);
        var4 = new EntityItem(par2EntityPlayer.worldObj, par8 + x, y + 1.0D, par10 + z, is);
        if (var4 != null) par2EntityPlayer.worldObj.spawnEntityInWorld(var4);

        par1ItemStack.stackSize -= 1;
      }

      return true;
    }


    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.swingItem();
        return par1ItemStack;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

