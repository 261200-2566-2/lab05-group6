public class Headband extends Accessories{
    private double hbDef = 1.2;
    public void upgrade() {
        super.upgrade();
        hbDef *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }
    public double getHbDef() {
        return hbDef;
    }
}
