package danger.orespawn;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

public class GirlfriendOverlayGui extends Gui
{
  private Minecraft mc;
  private static final ResourceLocation texture = new ResourceLocation("orespawn", "girlfriendgui.png");

  public GirlfriendOverlayGui(Minecraft mc)
  {
    this.mc = mc;
  }

  @SubscribeEvent
  public void onRenderOverlay(RenderGameOverlayEvent event) {
    if ((event.isCancelable()) || (event.type != RenderGameOverlayEvent.ElementType.HOTBAR)) {
      return;
    }

    int u = 0;
    int v = 0;
    String outstring = null;
    int color = 16725044;
    FontRenderer fr = this.mc.fontRenderer;

    int barWidth = 182;

    int barHeight = 5;

    float gfHealth = 0.0F;

    Entity entity = null;
    EntityPlayer player = null;

    if ((this.mc.gameSettings.hideGUI) || (this.mc.currentScreen != null)) {
      return;
    }

    player = this.mc.thePlayer;

    if (player == null)
    {
      return;
    }

    OreSpawnMain.current_dimension = player.worldObj.provider.dimensionId;
    if (this.mc.gameSettings.fancyGraphics)
      OreSpawnMain.FastGraphicsLeaves = 0;
    else {
      OreSpawnMain.FastGraphicsLeaves = 1;
    }

    if (OreSpawnMain.GuiOverlayEnable == 0) {
      return;
    }

    entity = this.mc.pointedEntity;

    if (entity == null) {
      entity = OreSpawnMain.getPointedAtEntity(this.mc.theWorld, player, 16.0D);
      if (entity == null) return;
      if (!(entity instanceof EntityLivingBase)) return;
    }

    if ((entity instanceof Girlfriend)) {
      Girlfriend gf = null;
      gf = (Girlfriend)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.passenger != 0) return;

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "Girlfriend";
      }

      gfHealth = gf.getGirlfriendHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof Boyfriend)) {
      Boyfriend gf = null;
      gf = (Boyfriend)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.passenger != 0) return;

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "Boyfriend";
      }

      gfHealth = gf.getBoyfriendHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof ThePrince)) {
      ThePrince gf = null;
      gf = (ThePrince)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "The Toddler Prince";
      }

      gfHealth = gf.getHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof ThePrincess)) {
      ThePrincess gf = null;
      gf = (ThePrincess)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "The Toddler Princess";
      }

      gfHealth = gf.getHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof ThePrinceTeen)) {
      ThePrinceTeen gf = null;
      gf = (ThePrinceTeen)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "The Young Prince";
      }
      if (gf.getActivity() != 0) return;

      gfHealth = gf.getHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof ThePrinceAdult)) {
      ThePrinceAdult gf = null;
      gf = (ThePrinceAdult)entity;

      if (!gf.func_152114_e(player))
      {
        return;
      }

      if (gf.hasCustomNameTag()) outstring = gf.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "The Young Adult Prince";
      }
      if (gf.getActivity() != 0) return;

      gfHealth = gf.getHealth() / gf.getMaxHealth();
    }

    if ((entity instanceof Dragon)) {
      Dragon df = null;
      df = (Dragon)entity;

      if (df.hasCustomNameTag()) outstring = df.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "Dragon";
      }
      if (df.getActivity() != 0) return;

      gfHealth = df.getDragonHealth() / df.getMaxHealth();
    }

    if ((entity instanceof EmperorScorpion)) {
      EmperorScorpion e = (EmperorScorpion)entity;
      outstring = "Emperor Scorpion";
      gfHealth = e.getEmperorScorpionHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Basilisk)) {
      Basilisk e = (Basilisk)entity;
      outstring = "Basilisk";
      gfHealth = e.getBasiliskHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Mothra)) {
      Mothra e = (Mothra)entity;
      outstring = "Mothra!";
      gfHealth = e.getMothraHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Spyro)) {
      Spyro e = (Spyro)entity;
      if (e.hasCustomNameTag()) outstring = e.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "Baby Dragon";
      }

      gfHealth = e.getSpyroHealth() / e.getMaxHealth();
    }

    if ((entity instanceof WormLarge)) {
      WormLarge e = (WormLarge)entity;
      if (!e.noClip) {
        outstring = "Worm";
        gfHealth = e.getHealth() / e.getMaxHealth();
      }
    }

    if ((entity instanceof Alien)) {
      Alien e = (Alien)entity;
      outstring = "Alien!";
      gfHealth = e.getAlienHealth() / e.getMaxHealth();
    }

    if ((entity instanceof WaterDragon)) {
      WaterDragon e = (WaterDragon)entity;
      if (e.hasCustomNameTag()) outstring = e.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "WaterDragon";
      }
      gfHealth = e.getWaterDragonHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Kraken)) {
      Kraken e = (Kraken)entity;
      outstring = "Kraken";
      gfHealth = e.getKrakenHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Cephadrome)) {
      Cephadrome e = (Cephadrome)entity;
      outstring = "Cephadrome";
      gfHealth = e.getCephadromeHealth() / e.getMaxHealth();
      if (e.getActivity() != 0) return;
    }

    if ((entity instanceof TrooperBug)) {
      TrooperBug e = (TrooperBug)entity;
      outstring = "Jumpy Bug";
      gfHealth = e.getTrooperBugHealth() / e.getMaxHealth();
    }

    if ((entity instanceof SpitBug)) {
      SpitBug e = (SpitBug)entity;
      outstring = "Spit Bug";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof PitchBlack)) {
      PitchBlack e = (PitchBlack)entity;
      outstring = "Nightmare";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Alosaurus)) {
      Alosaurus e = (Alosaurus)entity;
      outstring = "Alosaurus";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Nastysaurus)) {
      Nastysaurus e = (Nastysaurus)entity;
      outstring = "Nastysaurus";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof TRex)) {
      TRex e = (TRex)entity;
      outstring = "T. Rex";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Kyuubi)) {
      Kyuubi e = (Kyuubi)entity;
      outstring = "Kyuubi";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Robot2)) {
      Robot2 e = (Robot2)entity;
      outstring = "Robo-Pounder";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Robot4)) {
      Robot4 e = (Robot4)entity;
      outstring = "Robo-Warrior";
      gfHealth = e.getRobot4Health() / e.getMaxHealth();
    }

    if ((entity instanceof Triffid)) {
      Triffid e = (Triffid)entity;
      outstring = "Triffid";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Godzilla)) {
      Godzilla e = (Godzilla)entity;
      outstring = "Mobzilla";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Vortex)) {
      Vortex e = (Vortex)entity;
      outstring = "Vortex";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Irukandji)) {
      Irukandji e = (Irukandji)entity;
      outstring = "Irukandji";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Mantis)) {
      Mantis e = (Mantis)entity;
      outstring = "Mantis";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof HerculesBeetle)) {
      HerculesBeetle e = (HerculesBeetle)entity;
      outstring = "Hercules Beetle";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof TheKing)) {
      TheKing e = (TheKing)entity;
      outstring = "The King";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof TheQueen)) {
      TheQueen e = (TheQueen)entity;
      outstring = "The Queen";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof SeaViper)) {
      SeaViper e = (SeaViper)entity;
      outstring = "Sea Viper";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof SeaMonster)) {
      SeaMonster e = (SeaMonster)entity;
      outstring = "Sea Monster";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Molenoid)) {
      Molenoid e = (Molenoid)entity;
      outstring = "Molenoid";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof CaterKiller)) {
      CaterKiller e = (CaterKiller)entity;
      outstring = "CaterKiller";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Leon)) {
      Leon e = (Leon)entity;
      if (e.hasCustomNameTag()) outstring = e.getCustomNameTag();
      if ((outstring == null) || (outstring.equals(""))) {
        outstring = "Leonopteryx";
      }
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Hammerhead)) {
      Hammerhead e = (Hammerhead)entity;
      outstring = "Hammerhead";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof BandP)) {
      BandP e = (BandP)entity;
      if (e.getWhat() == 0)
        outstring = "Banker";
      else {
        outstring = "Politician";
      }
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof SpiderRobot)) {
      SpiderRobot e = (SpiderRobot)entity;
      outstring = "Giant Robot Spider";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof GiantRobot)) {
      GiantRobot e = (GiantRobot)entity;
      outstring = "Jeffery";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof AntRobot)) {
      AntRobot e = (AntRobot)entity;
      outstring = "Giant Robot Red Ant";
      gfHealth = e.getHealth() / e.getMaxHealth();
    }

    if ((entity instanceof Crab)) {
      Crab e = (Crab)entity;
      float myf = e.getCrabScale();
      if (myf > 0.75F) {
        outstring = "Very Large Crab";
        gfHealth = e.getHealth() / e.getMaxHealth();
      }

    }

    if (outstring == null) {
      return;
    }

    ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
    int width = res.getScaledWidth();
    int barWidthFilled = (int)(gfHealth * (barWidth + 1));

    int x = width / 2 - barWidth / 2;

    int y = 25;

    if ((player.isInsideOfMaterial(Material.water)) || (player.getTotalArmorValue() > 0)) {
      y -= 10;
    }

    fr.drawStringWithShadow(outstring, width / 2 - fr.getStringWidth(outstring) / 2, y - 10, color);

    this.mc.renderEngine.bindTexture(texture);

    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

    drawTexturedModalRect(x, y, u, v, barWidth, barHeight);

    if (barWidthFilled > 0)
      drawTexturedModalRect(x, y, u, v + barHeight, barWidthFilled, barHeight);
  }
}