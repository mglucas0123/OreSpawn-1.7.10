/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.CritterCage
 *  danger.orespawn.EntityCage
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.EntityCage;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public class CritterCage
extends Item {
    public int cage_id = 0;

    public CritterCage(int i, int j) {
        this.cage_id = j;
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        CritterCage cc = (CritterCage)OreSpawnMain.CageEmpty;
        if (this.cage_id == cc.cage_id) {
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
                --par1ItemStack.stackSize;
            }
            par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld((Entity)new EntityCage(par2World, par3EntityPlayer, this.cage_id));
            }
        }
        return par1ItemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        CritterCage cc = (CritterCage)OreSpawnMain.CageEmpty;
        if (this.cage_id == cc.cage_id) {
            return false;
        }
        for (int var3 = 0; var3 < 6; ++var3) {
            par2EntityPlayer.worldObj.spawnParticle("smoke", (double)((float)par4 + 0.5f), (double)((float)par5 + 1.25f), (double)((float)par6 + 0.5f), 0.0, 0.0, 0.0);
            par2EntityPlayer.worldObj.spawnParticle("explode", (double)((float)par4 + 0.5f), (double)((float)par5 + 1.25f), (double)((float)par6 + 0.5f), 0.0, 0.0, 0.0);
            par2EntityPlayer.worldObj.spawnParticle("reddust", (double)((float)par4 + 0.5f), (double)((float)par5 + 1.25f), (double)((float)par6 + 0.5f), 0.0, 0.0, 0.0);
        }
        par2EntityPlayer.worldObj.playSoundAtEntity((Entity)par2EntityPlayer, "random.explode", 1.0f, 1.5f);
        if (par3World.isRemote) {
            return true;
        }
        int entityID = 0;
        int skelly_type = 0;
        String name = null;
        switch (this.cage_id) {
            case 161: {
                entityID = 52;
                break;
            }
            case 162: {
                entityID = 65;
                break;
            }
            case 163: {
                entityID = 92;
                break;
            }
            case 164: {
                entityID = 90;
                break;
            }
            case 165: {
                entityID = 94;
                break;
            }
            case 166: {
                entityID = 93;
                break;
            }
            case 167: {
                entityID = 50;
                break;
            }
            case 188: {
                skelly_type = 1;
            }
            case 168: {
                entityID = 51;
                break;
            }
            case 169: {
                entityID = 54;
                break;
            }
            case 170: {
                entityID = 55;
                break;
            }
            case 171: {
                entityID = 56;
                break;
            }
            case 172: {
                entityID = 57;
                break;
            }
            case 173: {
                entityID = 58;
                break;
            }
            case 174: {
                entityID = 59;
                break;
            }
            case 175: {
                entityID = 60;
                break;
            }
            case 176: {
                entityID = 62;
                break;
            }
            case 177: {
                entityID = 66;
                break;
            }
            case 178: {
                entityID = 91;
                break;
            }
            case 179: {
                entityID = 95;
                break;
            }
            case 180: {
                entityID = 96;
                break;
            }
            case 181: {
                entityID = 98;
                break;
            }
            case 182: {
                entityID = 61;
                break;
            }
            case 184: {
                entityID = 63;
                break;
            }
            case 185: {
                entityID = 97;
                break;
            }
            case 186: {
                entityID = 99;
                break;
            }
            case 187: {
                entityID = 64;
                break;
            }
            case 253: {
                entityID = 100;
                break;
            }
            case 217: {
                entityID = 120;
                break;
            }
            case 183: {
                name = "Girlfriend";
                break;
            }
            case 215: {
                name = "Boyfriend";
                break;
            }
            case 189: {
                name = "Apple Cow";
                break;
            }
            case 190: {
                name = "Golden Apple Cow";
                break;
            }
            case 191: {
                name = "Enchanted Golden Apple Cow";
                break;
            }
            case 208: {
                name = "Mothra";
                break;
            }
            case 209: {
                name = "Alosaurus";
                break;
            }
            case 210: {
                name = "Cryolophosaurus";
                break;
            }
            case 211: {
                name = "Camarasaurus";
                break;
            }
            case 212: {
                name = "Velocity Raptor";
                break;
            }
            case 213: {
                name = "Hydrolisc";
                break;
            }
            case 214: {
                name = "Basilisk";
                break;
            }
            case 220: {
                name = "Dragonfly";
                break;
            }
            case 222: {
                name = "Emperor Scorpion";
                break;
            }
            case 224: {
                name = "Scorpion";
                break;
            }
            case 226: {
                name = "CaveFisher";
                break;
            }
            case 228: {
                name = "Baby Dragon";
                break;
            }
            case 230: {
                name = "Baryonyx";
                break;
            }
            case 232: {
                name = "WTF?";
                break;
            }
            case 234: {
                name = "Bird";
                break;
            }
            case 236: {
                name = "Kyuubi";
                break;
            }
            case 238: {
                name = "Alien";
                break;
            }
            case 240: {
                name = "Attack Squid";
                break;
            }
            case 242: {
                name = "Water Dragon";
                break;
            }
            case 244: {
                name = "The Kraken";
                break;
            }
            case 246: {
                name = "Lizard";
                break;
            }
            case 248: {
                name = "Cephadrome";
                break;
            }
            case 250: {
                name = "Dragon";
                break;
            }
            case 252: {
                name = "Bee";
                break;
            }
            case 255: {
                name = "Firefly";
                break;
            }
            case 256: {
                name = "Chipmunk";
                break;
            }
            case 257: {
                name = "Gazelle";
                break;
            }
            case 258: {
                name = "Ostrich";
                break;
            }
            case 259: {
                name = "Jumpy Bug";
                break;
            }
            case 260: {
                name = "Spit Bug";
                break;
            }
            case 261: {
                name = "Stink Bug";
                break;
            }
            case 268: {
                name = "Creeping Horror";
                break;
            }
            case 269: {
                name = "Terrible Terror";
                break;
            }
            case 270: {
                name = "Cliff Racer";
                break;
            }
            case 271: {
                name = "Triffid";
                break;
            }
            case 272: {
                name = "Nightmare";
                break;
            }
            case 273: {
                name = "Lurking Terror";
                break;
            }
            case 281: {
                name = "Small Worm";
                break;
            }
            case 283: {
                name = "Large Worm";
                break;
            }
            case 282: {
                name = "Medium Worm";
                break;
            }
            case 284: {
                name = "Cassowary";
                break;
            }
            case 285: {
                name = "Cloud Shark";
                break;
            }
            case 286: {
                name = "Gold Fish";
                break;
            }
            case 287: {
                name = "Leaf Monster";
                break;
            }
            case 296: {
                name = "Ender Knight";
                break;
            }
            case 297: {
                name = "Ender Reaper";
                break;
            }
            case 300: {
                name = "Beaver";
                break;
            }
            case 323: {
                name = "Crystal Urchin";
                break;
            }
            case 319: {
                name = "Flounder";
                break;
            }
            case 322: {
                name = "Skate";
                break;
            }
            case 313: {
                name = "Rotator";
                break;
            }
            case 315: {
                name = "Peacock";
                break;
            }
            case 316: {
                name = "Fairy";
                break;
            }
            case 317: {
                name = "Dungeon Beast";
                break;
            }
            case 314: {
                name = "Vortex";
                break;
            }
            case 318: {
                name = "Rat";
                break;
            }
            case 320: {
                name = "Whale";
                break;
            }
            case 321: {
                name = "Irukandji";
                break;
            }
            case 345: {
                name = "T. Rex";
                break;
            }
            case 346: {
                name = "Hercules Beetle";
                break;
            }
            case 347: {
                name = "Mantis";
                break;
            }
            case 348: {
                name = "Stinky";
                break;
            }
            case 150: {
                name = "Easter Bunny";
                break;
            }
            case 151: {
                name = "CaterKiller";
                break;
            }
            case 152: {
                name = "Molenoid";
                break;
            }
            case 153: {
                name = "Sea Monster";
                break;
            }
            case 154: {
                name = "Sea Viper";
                break;
            }
            case 357: {
                name = "Leonopteryx";
                break;
            }
            case 359: {
                name = "Hammerhead";
                break;
            }
            case 361: {
                name = "Rubber Ducky";
                break;
            }
            case 216: {
                name = "Crystal Apple Cow";
                break;
            }
            case 218: {
                name = "Criminal";
                break;
            }
            case 373: {
                name = "Brutalfly";
                break;
            }
            case 374: {
                name = "Nastysaurus";
                break;
            }
            case 375: {
                name = "Pointysaurus";
                break;
            }
            case 376: {
                name = "Cricket";
                break;
            }
            case 377: {
                name = "Frog";
                break;
            }
            case 382: {
                name = "Spider Driver";
                break;
            }
            case 384: {
                name = "Crab";
                break;
            }
        }
        if (entityID != 0 || name != null) {
            Entity ent = null;
            ent = CritterCage.spawnCreature((World)par3World, (int)entityID, (String)name, (double)((double)par4 + 0.5), (double)((double)par5 + 1.1), (double)((double)par6 + 0.5));
            if (ent != null) {
                ent.dropItem(OreSpawnMain.CageEmpty, 1);
                if (entityID == 51 && skelly_type != 0) {
                    EntitySkeleton sk = (EntitySkeleton)ent;
                    sk.setSkeletonType(skelly_type);
                }
                if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
                    ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
                }
            }
        } else {
            return false;
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = name == null ? EntityList.createEntityByID((int)par1, (World)par0World) : EntityList.createEntityByName((String)name, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            if ((par1 == 100 || par1 == 120) && var8 instanceof EntityLiving) {
                EntityLiving sk = (EntityLiving)var8;
                sk.onSpawnWithEgg((IEntityLivingData)null);
            }
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("OreSpawn:" + this.getUnlocalizedName().substring(5));
    }
}

