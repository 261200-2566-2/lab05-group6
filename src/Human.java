public class Human extends Characters{
    private Sword sword = new Sword();
    private Shield shield = new Shield();
    private boolean[] humanAcc = new boolean[4];
    boolean isStrengthAct;
    public Human(String n){
        setName(n);
        setCType("Human");
        setAtk(10);
        setDef(5);
        setSpeed(10);
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Equipped Items:");
        System.out.print("   Sword: ");
        if(humanAcc[0]) System.out.println("Level " + sword.getLevel());
        else System.out.println("-");
        System.out.print("   Shield: ");
        if (humanAcc[1]) System.out.println("Level " + shield.getLevel());
        else System.out.println("-");
        System.out.print("   Ring: ");
        if (humanAcc[2]) System.out.println("Level " + getRing().getLevel());
        else System.out.println("-");
        System.out.print("   Boots: ");
        if (humanAcc[3]) System.out.println("Level " + getBoots().getLevel());
        else System.out.println("-");
        System.out.println("--------------------------------------------------------");
    }
    @Override
    public void equip(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(!humanAcc[0]){
                    humanAcc[0] = true;
                    setAtk(getAtk()+sword.getSwordDmg());
                    System.out.println(getName() + " has equipped the sword.");
                }else System.out.println(getName() + " already has a sword equipped.");
                break;
            case "shield":
                if(!humanAcc[1]){
                    humanAcc[1] = true;
                    setDef(getDef()+shield.getShieldDef());
                    System.out.println(getName() + " has equipped the shield.");
                }else System.out.println(getName() + " already has a shield equipped.");
                break;
            case "ring":
                if(!humanAcc[2]){
                    humanAcc[2] = true;
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println(getName() + " has equipped the ring.");
                }else System.out.println(getName() + " already has a ring equipped.");
                break;
            case "boots":
                if(!humanAcc[3]){
                    humanAcc[3] = true;
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println(getName() + " has equipped the boots.");
                }else System.out.println(getName() + " already has boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    @Override
    public void unEquip(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(humanAcc[0]){
                    humanAcc[0] = false;
                    setAtk(getAtk()-sword.getSwordDmg());
                    System.out.println(getName() + " has unequipped the sword.");
                }else System.out.println(getName() + " doesn't have a sword equipped.");
                break;
            case "shield":
                if(humanAcc[1]){
                    humanAcc[1] = false;
                    setDef(getDef()-shield.getShieldDef());
                    System.out.println(getName() + " has unequipped the shield.");
                }else System.out.println(getName() + " doesn't have a shield equipped.");
                break;
            case "ring":
                if(humanAcc[2]){
                    humanAcc[2] = false;
                    setMana(getMana()-getRing().getBoostMana());
                    System.out.println(getName() + " has unequipped the ring.");
                }else System.out.println(getName() + " doesn't have a ring equipped.");
                break;
            case "boots":
                if(humanAcc[3]){
                    humanAcc[3] = false;
                    setSpeed(getSpeed()-getBoots().getฺBoostSpeed());
                    System.out.println(getName() + " has unequipped the boots.");
                }else System.out.println(getName() + " doesn't have boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    @Override
    public void upgrade(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(getMoney() >= sword.getUpgradePrice()){
                    setMoney(getMoney()-sword.getUpgradePrice());
                    sword.upgrade();
                    setAtk(getAtk()+ sword.getSwordDmg());
                    System.out.println(getName() + "'s sword has been upgraded to Level " + sword.getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the sword.");
                break;
            case "shield":
                if(getMoney() >= shield.getUpgradePrice()){
                    setMoney(getMoney()-shield.getUpgradePrice());
                    shield.upgrade();
                    setDef(getDef()+ shield.getShieldDef());
                    System.out.println(getName() + "'s shield has been upgraded to Level " + shield.getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the shield.");
                break;
            case "ring":
                if(getMoney() >= getRing().getUpgradePrice()){
                    setMoney(getMoney()-getRing().getUpgradePrice());
                    getRing().upgrade();
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println(getName() + "'s ring has been upgraded to Level " + getRing().getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the ring.");
                break;
            case "boots":
                if(getMoney() >= getBoots().getUpgradePrice()){
                    setMoney(getMoney()-getBoots().getUpgradePrice());
                    getBoots().upgrade();
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println(getName() + "'s boots has been upgraded to Level " + getBoots().getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the boots.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    public void strength(){
        if(getMana() >= 30){
            setMana(getMana()-30);
            isStrengthAct = true;
            setDef(getDef()*2);
            System.out.println("Strength is activated.");
        }
    }
    @Override
    public void beAttacked(double oppAtk) {
        super.beAttacked(oppAtk);
        if(isStrengthAct){
            isStrengthAct = false;
            setDef(getDef()/2);
        }
    }
}
