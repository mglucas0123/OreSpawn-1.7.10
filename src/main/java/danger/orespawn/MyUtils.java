/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  danger.orespawn.Boyfriend
 *  danger.orespawn.Cephadrome
 *  danger.orespawn.Cockateil
 *  danger.orespawn.Cricket
 *  danger.orespawn.Dragon
 *  danger.orespawn.Dragonfly
 *  danger.orespawn.Elevator
 *  danger.orespawn.EntityAnt
 *  danger.orespawn.EntityButterfly
 *  danger.orespawn.EntityMosquito
 *  danger.orespawn.Firefly
 *  danger.orespawn.GammaMetroid
 *  danger.orespawn.Ghost
 *  danger.orespawn.GhostSkelly
 *  danger.orespawn.Girlfriend
 *  danger.orespawn.KingHead
 *  danger.orespawn.Leon
 *  danger.orespawn.Mothra
 *  danger.orespawn.MyUtils
 *  danger.orespawn.PurplePower
 *  danger.orespawn.QueenHead
 *  danger.orespawn.RockBase
 *  danger.orespawn.Spyro
 *  danger.orespawn.Stinky
 *  danger.orespawn.Termite
 *  danger.orespawn.TheKing
 *  danger.orespawn.ThePrince
 *  danger.orespawn.ThePrinceAdult
 *  danger.orespawn.ThePrinceTeen
 *  danger.orespawn.ThePrincess
 *  danger.orespawn.TheQueen
 *  danger.orespawn.WaterDragon
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityVillager
 */
package danger.orespawn;

import danger.orespawn.Boyfriend;
import danger.orespawn.Cephadrome;
import danger.orespawn.Cockateil;
import danger.orespawn.Cricket;
import danger.orespawn.Dragon;
import danger.orespawn.Dragonfly;
import danger.orespawn.Elevator;
import danger.orespawn.EntityAnt;
import danger.orespawn.EntityButterfly;
import danger.orespawn.EntityMosquito;
import danger.orespawn.Firefly;
import danger.orespawn.GammaMetroid;
import danger.orespawn.Ghost;
import danger.orespawn.GhostSkelly;
import danger.orespawn.Girlfriend;
import danger.orespawn.KingHead;
import danger.orespawn.Leon;
import danger.orespawn.Mothra;
import danger.orespawn.PurplePower;
import danger.orespawn.QueenHead;
import danger.orespawn.RockBase;
import danger.orespawn.Spyro;
import danger.orespawn.Stinky;
import danger.orespawn.Termite;
import danger.orespawn.TheKing;
import danger.orespawn.ThePrince;
import danger.orespawn.ThePrinceAdult;
import danger.orespawn.ThePrinceTeen;
import danger.orespawn.ThePrincess;
import danger.orespawn.TheQueen;
import danger.orespawn.WaterDragon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;

/*
 * Exception performing whole class analysis ignored.
 */
public class MyUtils {
    public MyUtils() {
    }

    public static boolean isRoyalty(Entity e) {
        if (!(e instanceof EntityLivingBase)) {
            return false;
        }
        if (e instanceof ThePrince) {
            return true;
        }
        if (e instanceof ThePrinceTeen) {
            return true;
        }
        if (e instanceof ThePrinceAdult) {
            return true;
        }
        if (e instanceof ThePrincess) {
            return true;
        }
        if (e instanceof TheKing) {
            return true;
        }
        if (e instanceof KingHead) {
            return true;
        }
        if (e instanceof TheQueen) {
            return true;
        }
        if (e instanceof QueenHead) {
            return true;
        }
        if (e instanceof PurplePower) {
            return true;
        }
        return false;
    }

    public static boolean isAttackableNonMob(EntityLivingBase par1EntityLiving) {
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Leon) {
            return true;
        }
        if (par1EntityLiving instanceof Dragon) {
            return true;
        }
        if (par1EntityLiving instanceof Spyro) {
            return true;
        }
        if (MyUtils.isRoyalty((Entity)par1EntityLiving)) {
            return true;
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            return true;
        }
        if (par1EntityLiving instanceof Cephadrome) {
            return true;
        }
        if (par1EntityLiving instanceof WaterDragon) {
            return true;
        }
        if (par1EntityLiving instanceof Girlfriend) {
            return true;
        }
        if (par1EntityLiving instanceof Boyfriend) {
            return true;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return true;
        }
        if (par1EntityLiving instanceof Stinky) {
            return true;
        }
        return false;
    }

    public static boolean isIgnoreable(EntityLivingBase par1EntityLiving) {
        if (par1EntityLiving instanceof RockBase) {
            return true;
        }
        if (par1EntityLiving instanceof EntityAnt) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMosquito) {
            return true;
        }
        if (par1EntityLiving instanceof Dragonfly) {
            return true;
        }
        if (par1EntityLiving instanceof Firefly) {
            return true;
        }
        if (par1EntityLiving instanceof Cricket) {
            return true;
        }
        if (par1EntityLiving instanceof Cockateil) {
            return true;
        }
        if (par1EntityLiving instanceof Termite) {
            return true;
        }
        if (par1EntityLiving instanceof Ghost) {
            return true;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return true;
        }
        if (par1EntityLiving instanceof Elevator) {
            return true;
        }
        return false;
    }
}

