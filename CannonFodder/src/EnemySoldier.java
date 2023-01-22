import java.util.Random;

public class EnemySoldier extends Character {

    private String name;

    public EnemySoldier(String name, int strenght, int vitality, int intelligence) {
        super(strenght, vitality, intelligence, name);

        Random random = new Random();
      // random.nextInt(12);
        int upperBound=13;
        int int_random=random.nextInt(upperBound);
        Weapon weapon = null;
        //burayı yap
        if (int_random == 1){
            weapon = new Sword("Dagger", 1, 2);
        }else if (int_random==2){
           weapon = new Sword("Long Sword", 2, 3);
        }
        else if (int_random==3){
            weapon = new Sword("Long Sword", 2, 3);
        }
        else if (int_random==4){
         weapon = new Sword("Destiny's Song", 3, 3);
        }
        else if (int_random == 5){
         weapon = new Sword("Nightfall", 2, 4);
        }
         else if (int_random == 6){
            weapon = new Sword("Dagger", 1, 2);
        }
         else if (int_random == 7){
           weapon = new Shield("Dragonheart", 1, 1);
        }
         else if (int_random==8){
            weapon = new Shield("PromisedAegis", 2, 3);
        }
         else if (int_random==9){
          weapon = new Wand("Mercy", 1, 2);
        }
         else if (int_random==10){
           weapon = new Wand("Phantom", 2, 2);
        }
         else if (int_random==11){
          weapon = new Wand("Frostguard", 1, 1);
        }
         else if (int_random==12){
            weapon= new Shield("Dragonheart", 1, 1);
        }else {
            weapon = new Sword("Long Sword", 2, 3);

        }





        this.setWeapon(weapon);


    }


    public void attack(Character character) {
        character.setHp(character.getHp() - getWeapon().damage(this));
        System.out.println(this.getName() + " attack " + character.getName());
        System.out.println(this.getName() + " does " + getWeapon().damage(this) + " damage ");
        System.out.println(character.getName() + " has " + character.getHp() + " HP left ");
    }


    @Override
    public boolean isDead() {
        if (getHp() <= 0) {
            System.out.println(this.getName() + " " + this.getWeapon().getName() + " drops ");
            this.getWeapon().setHasOwner(false);


            return true;
        } else {
            return false;
        }

    }
}

