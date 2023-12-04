public class Boots extends Accessories{
    private double boostSpeed = 1;
    @Override
    public void upgrade() {
        super.upgrade();
        boostSpeed *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*2);
    }
    public double getฺBoostSpeed(){
        return boostSpeed;
    }
}
