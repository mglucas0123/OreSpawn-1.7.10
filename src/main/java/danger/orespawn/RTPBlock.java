/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.RTPBlock
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class RTPBlock
extends Block {
    public RTPBlock(int i) {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public void onEntityWalking(World world, int par2, int par3, int par4, Entity par5Entity) {
        if (par5Entity instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par5Entity;
            EntityPlayerMP mp = null;
            if (par5Entity instanceof EntityPlayerMP) {
                mp = (EntityPlayerMP)par5Entity;
            }
            int x = par2;
            int y = par3;
            int z = par4;
            boolean found = false;
            block0 : for (int tries = 0; tries < 1000 && !found; ++tries) {
                x = world.rand.nextInt(2) == 0 ? par2 + 16 + world.rand.nextInt(8) - world.rand.nextInt(8) : par2 - 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
                z = world.rand.nextInt(2) == 0 ? par4 + 16 + world.rand.nextInt(8) - world.rand.nextInt(8) : par4 - 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
                for (y = par3 - 4; y <= par3 + 4; ++y) {
                    if (!world.getBlock(x, y - 1, z).getMaterial().isSolid() || world.getBlock(x, y, z) != Blocks.air || world.getBlock(x, y + 1, z) != Blocks.air) continue;
                    found = true;
                    continue block0;
                }
            }
            if (found) {
                if (mp != null) {
                    mp.playerNetServerHandler.setPlayerLocation((double)((float)x + 0.5f), (double)y, (double)((float)z + 0.5f), p.rotationYaw, 0.0f);
                } else {
                    p.setLocationAndAngles((double)((float)x + 0.5f), (double)y, (double)((float)z + 0.5f), p.rotationYaw, 0.0f);
                }
                for (int var3 = 0; var3 < 6; ++var3) {
                    world.spawnParticle("smoke", (double)((float)x + 0.5f), (double)((float)y + 2.25f), (double)((float)z + 0.5f), 0.0, 0.0, 0.0);
                    world.spawnParticle("explode", (double)((float)x + 0.5f), (double)((float)y + 2.25f), (double)((float)z + 0.5f), 0.0, 0.0, 0.0);
                    world.spawnParticle("reddust", (double)((float)x + 0.5f), (double)((float)y + 2.25f), (double)((float)z + 0.5f), 0.0, 0.0, 0.0);
                }
                p.worldObj.playSoundAtEntity((Entity)p, "random.explode", 1.0f, 1.5f);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

