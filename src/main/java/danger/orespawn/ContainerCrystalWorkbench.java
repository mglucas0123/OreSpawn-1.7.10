/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ContainerCrystalWorkbench
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryCraftResult
 *  net.minecraft.inventory.InventoryCrafting
 *  net.minecraft.inventory.Slot
 *  net.minecraft.inventory.SlotCrafting
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.CraftingManager
 *  net.minecraft.world.World
 */
package danger.orespawn;

import danger.orespawn.OreSpawnMain;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerCrystalWorkbench
extends Container {
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerCrystalWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        int i1;
        int l;
        this.craftMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.craftResult = new InventoryCraftResult();
        this.worldObj = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        this.addSlotToContainer((Slot)new SlotCrafting(par1InventoryPlayer.player, (IInventory)this.craftMatrix, this.craftResult, 0, 124, 35));
        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 3; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }
        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }
        for (l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, l, 8 + l * 18, 142));
        }
        this.onCraftMatrixChanged((IInventory)this.craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory par1IInventory) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 9; ++i) {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
                if (itemstack == null) continue;
                par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != OreSpawnMain.CrystalWorkbenchBlock ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5, (double)this.posY + 0.5, (double)this.posZ + 0.5) <= 64.0;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 >= 10 && par2 < 37 ? !this.mergeItemStack(itemstack1, 37, 46, false) : (par2 >= 37 && par2 < 46 ? !this.mergeItemStack(itemstack1, 10, 37, false) : !this.mergeItemStack(itemstack1, 10, 46, false))) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
        return itemstack;
    }

    public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot) {
        return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
    }
}

