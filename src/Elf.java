public class Elf extends Characters{
    private Bow bow = new Bow();
    private Headband headband = new Headband();
    private boolean[] elfAcc = new boolean[4];
    private boolean isStealthAct;
    public Elf(String n){
        setName(n);
        setCType("Elf");
        setAtk(12);
        setDef(3);
        setSpeed(10);
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Equipped Items:");
        System.out.print("   Bow: ");
        if(elfAcc[0]) System.out.println("Level " + bow.getLevel());
        else System.out.println("-");
        System.out.print("   Headband: ");
        if (elfAcc[1]) System.out.println("Level " + headband.getLevel());
        else System.out.println("-");
        System.out.print("   Ring: ");
        if (elfAcc[2]) System.out.println("Level " + getRing().getLevel());
        else System.out.println("-");
        System.out.print("   Boots: ");
        if (elfAcc[3]) System.out.println("Level " + getBoots().getLevel());
        else System.out.println("-");
        System.out.println("--------------------------------------------------------");
    }
    @Override
    public void equip(String a) {
        switch(a.toLowerCase()){
            case "bow":
                if(!elfAcc[0]){
                    elfAcc[0] = true;
                    setAtk(getAtk()+bow.getBowDmg());
                    System.out.println("You have equipped the bow.");
                }System.out.println("You already have a bow equipped.");
                break;
            case "headband":
                if(!elfAcc[1]){
                    elfAcc[1] = true;
                    setDef(getDef()+headband.getHbDef());
                    System.out.println("You have equipped the headband.");
                }System.out.println("You already have a headband equipped.");
                break;
            case "ring":
                if(!elfAcc[2]){
                    elfAcc[2] = true;
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println("You have equipped the ring.");
                }else System.out.println("You already have a ring equipped.");
                break;
            case "boots":
                if(!elfAcc[3]){
                    elfAcc[3] = true;
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println("You have equipped the boots.");
                }else System.out.println("You already have boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    @Override
    public void unEquip(String a) {
        switch(a.toLowerCase()){
            case "bow":
                if(elfAcc[0]){
                    elfAcc[0] = false;
                    setAtk(getAtk()-bow.getBowDmg());
                    System.out.println("You have unequipped the bow.");
                }else System.out.println("You don't have a sword bow.");
                break;
            case "headband":
                if(elfAcc[1]){
                    elfAcc[1] = false;
                    setDef(getDef()-headband.getHbDef());
                    System.out.println("You have unequipped the headband.");
                }else System.out.println("You don't have a headband equipped.");
                break;
            case "ring":
                if(elfAcc[2]){
                    elfAcc[2] = false;
                    setMana(getMana()-getRing().getBoostMana());
                    System.out.println("You have unequipped the ring.");
                }else System.out.println("You don't have a ring equipped.");
                break;
            case "boots":
                if(elfAcc[3]){
                    elfAcc[3] = false;
                    setSpeed(getSpeed()-getBoots().getฺBoostSpeed());
                    System.out.println("You have unequipped the boots.");
                }else System.out.println("You don't have boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    @Override
    public void upgrade(String a) {
        switch(a.toLowerCase()){
            case "bow":
                if(getMoney() >= bow.getUpgradePrice()){
                    setMoney(getMoney()-bow.getUpgradePrice());
                    bow.upgrade();
                    setAtk(getAtk()+ bow.getBowDmg());
                    System.out.println("The bow has been upgraded to LV." + bow.getLevel());
                }else System.out.println("There is not enough money to upgrade the bow.");
                break;
            case "headband":
                if(getMoney() >= headband.getUpgradePrice()){
                    setMoney(getMoney()-headband.getUpgradePrice());
                    headband.upgrade();
                    setDef(getDef()+headband.getHbDef());
                    System.out.println("The shield has been upgraded to LV." + headband.getLevel());
                }else System.out.println("There is not enough money to upgrade the shield.");
                break;
            case "ring":
                if(getMoney() >= getRing().getUpgradePrice()){
                    setMoney(getMoney()-getRing().getUpgradePrice());
                    getRing().upgrade();
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println("The ring has been upgraded to LV." + getRing().getLevel());
                } System.out.println("There is not enough money to upgrade the ring.");
                break;
            case "boots":
                if(getMoney() >= getBoots().getUpgradePrice()){
                    setMoney(getMoney()-getBoots().getUpgradePrice());
                    getBoots().upgrade();
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println("The boots has been upgraded to LV." + getBoots().getLevel());
                } System.out.println("There is not enough money to upgrade the boots.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    public void stealth(){
        if(getMana() >= 30){
            setMana(getMana()-30);
            isStealthAct = true;
            setSpeed(getSpeed()*1.5);
            System.out.println("Stealth is activated.");
        }
    }
    @Override
    public void beAttacked(double oppAtk) {
        if(isStealthAct){
            int random = (int)Math.floor(Math.random()*2);
            if(random == 1) oppAtk = 0;
        }
        super.beAttacked(oppAtk);
        if(isStealthAct){
            isStealthAct = false;
            setSpeed(getDef()/1.5);
        }
    }
}
