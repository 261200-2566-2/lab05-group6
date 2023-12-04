public class Characters implements Character{
    private String name;
    private String cType;
    private int level = 1;
    private int money = 1000;
    private int hp = 100;
    private int mana = 0;
    private double atk;
    private double def;
    private double speed;
    private Ring ring = new Ring();
    private Boots boots = new Boots();
    @Override
    public void showInfo(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Type: " + cType);
        System.out.println("Level: " + level);
        System.out.println("Money: $ " + money);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
        System.out.println("Speed: " + speed);
    }
    public void attack(Characters opp){
        if(opp.isDead()) return;
        opp.beAttacked(atk);
        if(mana >= 0) mana -= (int) atk/10;
        if(mana < 0) mana = 0;
        if(opp.isDead()){
            level++;
            money += opp.getMoney()*opp.getLevel();
            hp = 100+5*level;
            if(mana < 100) mana += 10*(level-1);
            speed *= 1.1;
        }
    }
    public void beAttacked(double oppAtk){
        double dmg = 0;
        if(oppAtk > def) dmg = oppAtk-def;
        hp -= (int) dmg;
        if(hp <= 0){
            hp = 0;
        }
    }
    public void equip(String a){}
    public void unEquip(String a){}
    public void upgrade(String a){}
    public boolean isDead(){ return hp <= 0; }
    public void setName(String n){ name = n; }
    public void setCType(String s){ cType = s; }
    public int getLevel() { return level; }
    public int getMoney() { return money; }
    public void setMoney(int m) { money = m; }
    public int getMana() { return mana; }
    public void setMana(int m) { mana = m; }
    public double getAtk() { return atk; }
    public void setAtk(double a) { atk = a; }
    public double getDef() { return def; }
    public void setDef(double d) { def = d; }
    public double getSpeed() { return speed; }
    public void setSpeed(double s) { speed = s; }
    public Ring getRing() { return ring; }
    public Boots getBoots(){ return boots; }
}
