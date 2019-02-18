/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.DispenserBehaviorOreSpawnEgg
 *  danger.orespawn.ItemSpawnEgg
 *  net.minecraft.block.BlockDispenser
 *  net.minecraft.dispenser.BehaviorDefaultDispenseItem
 *  net.minecraft.dispenser.IBlockSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.ItemSpawnEgg;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorOreSpawnEgg
extends BehaviorDefaultDispenseItem {
    DispenserBehaviorOreSpawnEgg() {
    }

    public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack) {
        EnumFacing enumfacing = BlockDispenser.func_149937_b((int)par1IBlockSource.getBlockMetadata());
        double d0 = par1IBlockSource.getX() + (double)enumfacing.getFrontOffsetX() * 2.0;
        double d1 = (float)par1IBlockSource.getYInt() + 0.2f;
        double d2 = par1IBlockSource.getZ() + (double)enumfacing.getFrontOffsetZ() * 2.0;
        Item it = par2ItemStack.getItem();
        if (it instanceof ItemSpawnEgg) {
            ItemSpawnEgg ise = (ItemSpawnEgg)it;
            Entity entity = ItemSpawnEgg.spawn_something((int)ise.my_id, (World)par1IBlockSource.getWorld(), (double)((int)d0), (double)((int)d1), (double)((int)d2));
            if (entity instanceof EntityLivingBase && par2ItemStack.hasDisplayName()) {
                ((EntityLiving)entity).setCustomNameTag(par2ItemStack.getDisplayName());
            }
        }
        par2ItemStack.splitStack(1);
        return par2ItemStack;
    }
}

