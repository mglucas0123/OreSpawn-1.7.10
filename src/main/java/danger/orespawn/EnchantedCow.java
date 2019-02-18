/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.EnchantedCow
 *  danger.orespawn.RedCow
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.RedCow;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantedCow
extends RedCow {
    public EnchantedCow(World world) {
        super(world);
    }

    private void dropEnchantedGoldenApple() {
        EntityItem var3 = new EntityItem(this.worldObj, this.posX, this.posY + 1.0, this.posZ, new ItemStack(Items.golden_apple, 1, 1));
        this.worldObj.spawnEntityInWorld((Entity)var3);
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3 = this.rand.nextInt(4) + this.rand.nextInt(1 + par2);
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.apple, 1);
        }
        this.dropItem(Items.golden_apple, 2);
        this.dropEnchantedGoldenApple();
        super.dropFewItems(par1, par2);
    }

    public EntityCow createChild(EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    public EnchantedCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
        return new EnchantedCow(this.worldObj);
    }
}

