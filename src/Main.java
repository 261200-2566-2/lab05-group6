public class Main {
    public static void main(String[] args) {
        Human a = new Human("A");
//        for(boolean b : a.humanAcc){
//            System.out.print(b + " ");
//        }
//        a.equip("sword");
//        System.out.println();
//        for(boolean b : a.humanAcc){
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        a.equip("xxx");
//        for(boolean b : a.humanAcc){
//            System.out.print(b + " ");
//        }
        Elf b = new Elf("B");
        b.stealth();
        b.showInfo();
        a.attack(b);
        a.showInfo();
        b.showInfo();
//        System.out.println((int)Math.floor(Math.random()*2));
    }
}

