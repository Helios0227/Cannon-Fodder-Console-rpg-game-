public class Sword extends Weapon {
    public Sword(String name, int weight, int value) {
        super(name, weight, value);
    }



    @Override
    public int damage(Character character) {
        return getValue()*character.getStrength();
    }
}
