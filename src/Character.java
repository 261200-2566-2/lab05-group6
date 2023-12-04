public interface Character {
    void showInfo();
    void attack(Characters opp);
    void beAttacked(double oppAtk);
    void equip(String a);
    void unEquip(String a);
    void upgrade(String a);
    boolean isDead();
    String getName();
    void setName(String n);
    void setCType(String s);
    int getLevel();
    int getMoney();
    void setMoney(int m);
    int getMana();
    void setMana(int m);
    double getAtk();
    void setAtk(double a);
    double getDef();
    void setDef(double d);
    double getSpeed();
    void setSpeed(double s);
    Ring getRing();
    Boots getBoots();
}
