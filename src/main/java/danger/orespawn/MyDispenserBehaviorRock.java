/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EntityThrownRock
 *  danger.orespawn.MyDispenserBehaviorRock
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.BlockDispenser
 *  net.minecraft.dispenser.BehaviorProjectileDispense
 *  net.minecraft.dispenser.IBlockSource
 *  net.minecraft.dispenser.IPosition
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.EntityThrownRock;
import danger.orespawn.OreSpawnMain;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class MyDispenserBehaviorRock
extends BehaviorProjectileDispense {
    MyDispenserBehaviorRock() {
    }

    public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack) {
        World world = par1IBlockSource.getWorld();
        IPosition iposition = BlockDispenser.func_149939_a((IBlockSource)par1IBlockSource);
        EnumFacing enumfacing = BlockDispenser.func_149937_b((int)par1IBlockSource.getBlockMetadata());
        IProjectile iprojectile = this.getProjectileEntity(world, iposition);
        iprojectile.setThrowableHeading((double)enumfacing.getFrontOffsetX(), (double)((float)enumfacing.getFrontOffsetY() + 0.1f), (double)enumfacing.getFrontOffsetZ(), this.func_82500_b(), this.func_82498_a());
        EntityThrownRock r = (EntityThrownRock)iprojectile;
        if (par2ItemStack.getItem() == OreSpawnMain.MySmallRock) {
            r.setRockType(1);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyRock) {
            r.setRockType(2);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyRedRock) {
            r.setRockType(3);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyGreenRock) {
            r.setRockType(4);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyBlueRock) {
            r.setRockType(5);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyPurpleRock) {
            r.setRockType(6);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MySpikeyRock) {
            r.setRockType(7);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyTNTRock) {
            r.setRockType(8);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalRedRock) {
            r.setRockType(9);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalGreenRock) {
            r.setRockType(10);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalBlueRock) {
            r.setRockType(11);
        }
        if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalTNTRock) {
            r.setRockType(12);
        }
        world.spawnEntityInWorld((Entity)iprojectile);
        par2ItemStack.splitStack(1);
        return par2ItemStack;
    }

    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        EntityThrownRock entityarrow = new EntityThrownRock(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return entityarrow;
    }
}

