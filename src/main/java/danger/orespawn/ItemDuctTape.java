/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.ItemDuctTape
 *  net.minecraft.block.Block
 *  net.minecraft.block.Block$SoundType
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemDuctTape
extends Item {
    private Block field_150935_a;

    public ItemDuctTape(int par1, Block par2Block) {
        this.field_150935_a = par2Block;
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        int i1;
        Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
        if (block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1) {
            p_77648_7_ = 1;
        } else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
            if (p_77648_7_ == 0) {
                --p_77648_5_;
            }
            if (p_77648_7_ == 1) {
                ++p_77648_5_;
            }
            if (p_77648_7_ == 2) {
                --p_77648_6_;
            }
            if (p_77648_7_ == 3) {
                ++p_77648_6_;
            }
            if (p_77648_7_ == 4) {
                --p_77648_4_;
            }
            if (p_77648_7_ == 5) {
                ++p_77648_4_;
            }
        }
        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
        }
        if (p_77648_1_.stackSize == 0) {
            return false;
        }
        if (p_77648_3_.canPlaceEntityOnSide(this.field_150935_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_) && p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150935_a, i1 = this.field_150935_a.onBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0), 3)) {
            if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150935_a) {
                this.field_150935_a.onBlockPlacedBy(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (EntityLivingBase)p_77648_2_, p_77648_1_);
                this.field_150935_a.onPostBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
            }
            p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5f), (double)((float)p_77648_5_ + 0.5f), (double)((float)p_77648_6_ + 0.5f), this.field_150935_a.stepSound.func_150496_b(), (this.field_150935_a.stepSound.getVolume() + 1.0f) / 2.0f, this.field_150935_a.stepSound.getPitch() * 0.8f);
            --p_77648_1_.stackSize;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

