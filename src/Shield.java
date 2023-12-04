public class Shield extends Accessories{
    private double shieldDef = 1.5;
    public void upgrade() {
        super.upgrade();
        shieldDef *= 1+0.05*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }
    public double getShieldDef(){ return shieldDef; }
}
