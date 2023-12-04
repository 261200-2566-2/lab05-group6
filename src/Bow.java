public class Bow extends Accessories{
    private double bowDmg = 1.2;
    @Override
    public void upgrade() {
        super.upgrade();
        bowDmg *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }

    public double getBowDmg() {
        return bowDmg;
    }
}
