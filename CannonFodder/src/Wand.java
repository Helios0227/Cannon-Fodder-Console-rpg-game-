public class Wand extends Weapon{
    public Wand(String name, int weight, int value) {
        super(name, weight, value);
    }


    @Override
    public int damage(Character character) {
        return getValue()*character.getIntelligence();
    }
}
