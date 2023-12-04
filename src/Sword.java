public class Sword extends Accessories{
    private double swordDmg = 1;
    @Override
    public void upgrade() {
        super.upgrade();
        swordDmg *= 1+0.2*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }
    public double getSwordDmg(){ return swordDmg; }
}
