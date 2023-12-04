public class Main {
    public static void main(String[] args) {
        Human a = new Human("A");
        Elf b = new Elf("B");
        a.showInfo();
        b.showInfo();

        a.equip("sword");
        a.upgrade("sword");
        a.showInfo();

        a.attack(b);
        b.showInfo();

        a.unEquip("sword");
        b.equip("bow");

        a.strength();
        b.attack(a);
        a.showInfo();
        b.showInfo();
    }
}

