import java.util.ArrayList;
import java.util.List;

public class Character {
    private int strength;
    private int vitality;
    private int intelligence;
    private int hp;
    private Weapon weapon;
    private String name;




    public Character(int strength, int vitality, int intelligence,String name) {
        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.hp = (int) ((0.7 * getVitality() + 0.2 * getStrength() + 0.1 * getIntelligence()) * 10);
        this.name=name;
    }

    public Character() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weapon.setHasOwner(true);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getStrength() {
        return strength;
    }

    public int getVitality() {
        return vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public boolean isDead(){
        if (getHp()<=0){
            System.out.println("This character can not be used anymore");
            return true;
        }
        else {
            return false;
        }


    }
}
