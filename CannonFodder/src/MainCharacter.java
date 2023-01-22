import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends Character implements Actions {
    private Armor armor;
    private List<Item> inventory;



    public MainCharacter(String name ,int strength, int vitality, int intelligence) {
        super(strength, vitality, intelligence,name);
        this.inventory = new ArrayList<>();
    }

    public MainCharacter(String fighter, int strength, int vitality, int intelligence, ArrayList arrayList) {
        super();
    }

    //TODO: eğer karakterin silahı yoksa bu method çalışmaz
    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - getWeapon().damage(this));
        System.out.println(this.getName() + " does " + getWeapon().damage(this) + " damage.");
        if (character.getHp()<=0){
            System.out.println(character.getName() + " is dead " );
        }else {
            System.out.println( character.getName() + " has " + character.getHp()+ " HP left");
        }
    }

    @Override
    public void pick(Weapon weapon) {
        if (!weapon.isHasOwner()) {
            inventory.add(weapon);
            weapon.setHasOwner(true);
            System.out.println(this.getName() + " picks " + weapon.getName());
        }

    }

    @Override
    public void wield(Weapon weapon, Character character) {
        for (int i = 0; i < inventory.size(); i++) {
            if (weapon.getName() == inventory.get(i).getName()) {
                character.setWeapon(weapon);
                System.out.println(this.getName() + " is now wearing " + weapon.getName());
            }

        }


    }


    @Override
    public void wear(Armor armor, MainCharacter mainCharacter) {
        for (int i = 0; i < inventory.size(); i++) {
            if (armor.getName() == inventory.get(i).getName()) {
                mainCharacter.setArmor(armor);
                System.out.println(this.getName() + " is now wearing " + armor.getName());
            }

        }

    }

    @Override
    public void examine(Weapon weapon) {
        System.out.println(weapon.getName()+ " has "+ weapon.getValue() + " damage");
        System.out.println(weapon.getWeight()+ " unit of weight ");

    }

    @Override
    public void listInventory() {
        System.out.println(this.getClass().getName() + " wields " + this.getWeapon().getName() + " wears " + this.armor.getName());
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print(inventory.get(i).getName());
        }

    }


    //TODO yapılacaktır



    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public boolean isDead() {
        if (getHp()<=0){
            System.out.println(this.getName() + " can not be used anymore");
            return true;
        }
        else {
            return false;
        }
    }


}
