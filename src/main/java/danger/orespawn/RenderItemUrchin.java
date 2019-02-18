package danger.orespawn;

import net.minecraft.entity.Entity;

public class RenderItemUrchin extends RenderSpinner
{
  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
  {
    if ((par1Entity instanceof BerthaHit)) {
      return;
    }
    if ((par1Entity instanceof SunspotUrchin)) {
      SunspotUrchin var2 = (SunspotUrchin)par1Entity;
      this.spinItemIconIndex = var2.getUrchinIndex();
    }
    if ((par1Entity instanceof WaterBall)) {
      WaterBall var2 = (WaterBall)par1Entity;
      this.spinItemIconIndex = var2.getWaterBallIndex();
    }
    if ((par1Entity instanceof InkSack)) {
      InkSack var2 = (InkSack)par1Entity;
      this.spinItemIconIndex = var2.getInkSackIndex();
    }
    if ((par1Entity instanceof LaserBall)) {
      LaserBall var2 = (LaserBall)par1Entity;
      this.spinItemIconIndex = var2.getLaserBallIndex();
    }
    if ((par1Entity instanceof IceBall)) {
      IceBall var2 = (IceBall)par1Entity;
      this.spinItemIconIndex = var2.getIceBallIndex();
    }
    if ((par1Entity instanceof Acid)) {
      Acid var2 = (Acid)par1Entity;
      this.spinItemIconIndex = var2.getAcidIndex();
    }
    if ((par1Entity instanceof DeadIrukandji)) {
      DeadIrukandji var2 = (DeadIrukandji)par1Entity;
      this.spinItemIconIndex = var2.getIrukandjiIndex();
    }
    super.doRender(par1Entity, par2, par4, par6, par8, par9);
  }
}