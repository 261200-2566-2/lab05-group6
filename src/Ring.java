public class Ring extends Accessories{
    private int boostMana = 1;
    @Override
    public void upgrade() {
        super.upgrade();
        boostMana *= 2;
        setUpgradePrice(getUpgradePrice()*2);
    }
    public int getBoostMana(){
        return boostMana;
    }
}
