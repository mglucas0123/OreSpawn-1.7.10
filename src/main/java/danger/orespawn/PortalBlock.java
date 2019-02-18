/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.PortalBlock
 *  net.minecraft.block.BlockPortal
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 */
package danger.orespawn;

import java.util.Random;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PortalBlock
extends BlockPortal {
    public PortalBlock(int i, int j) {
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
    }

    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4) {
        return false;
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity) {
    }
}

