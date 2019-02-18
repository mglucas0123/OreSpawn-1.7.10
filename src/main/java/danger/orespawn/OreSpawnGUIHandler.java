/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.IGuiHandler
 *  danger.orespawn.ContainerCrystalFurnace
 *  danger.orespawn.ContainerCrystalWorkbench
 *  danger.orespawn.CrystalFurnaceGUI
 *  danger.orespawn.CrystalWorkbenchGUI
 *  danger.orespawn.OreSpawnGUIHandler
 *  danger.orespawn.TileEntityCrystalFurnace
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.common.network.IGuiHandler;
import danger.orespawn.ContainerCrystalFurnace;
import danger.orespawn.ContainerCrystalWorkbench;
import danger.orespawn.CrystalFurnaceGUI;
import danger.orespawn.CrystalWorkbenchGUI;
import danger.orespawn.TileEntityCrystalFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class OreSpawnGUIHandler
implements IGuiHandler {
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0: {
                if (!(tileEntity instanceof TileEntityCrystalFurnace)) break;
                return new ContainerCrystalFurnace(player.inventory, (TileEntityCrystalFurnace)tileEntity);
            }
            case 1: {
                return new ContainerCrystalWorkbench(player.inventory, world, x, y, z);
            }
        }
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0: {
                if (!(tileEntity instanceof TileEntityCrystalFurnace)) break;
                return new CrystalFurnaceGUI(player.inventory, (TileEntityCrystalFurnace)tileEntity);
            }
            case 1: {
                return new CrystalWorkbenchGUI(player.inventory, world, x, y, z);
            }
        }
        return null;
    }
}

