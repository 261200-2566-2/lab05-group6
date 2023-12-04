public class Accessories implements Accessory{
    private int level = 1;
    private int upgradePrice = 100;
    public void upgrade() {
        level++;
    }
    public int getLevel(){
        return level;
    }
    public int getUpgradePrice() {
        return upgradePrice;
    }
    public void setUpgradePrice(int p) {
        upgradePrice = p;
    }
}
