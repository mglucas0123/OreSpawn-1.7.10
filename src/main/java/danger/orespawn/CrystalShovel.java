/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.CrystalShovel
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockMycelium
 *  net.minecraft.block.BlockSand
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemTool
 *  net.minecraft.util.IIcon
 */
package danger.orespawn;

import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.OreSpawnMain;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;

public class CrystalShovel
extends ItemTool {
    public static final Set blocksEffectiveAgainst = Sets.newHashSet((Object[])new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, Blocks.mycelium, OreSpawnMain.CrystalGrass});

    public CrystalShovel(int par1, Item.ToolMaterial par2) {
        super(1.0f, par2, blocksEffectiveAgainst);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean canHarvestBlock(Block par1Block) {
        return par1Block == Blocks.snow;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

