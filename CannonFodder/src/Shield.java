public class Shield extends Weapon{
    public Shield(String name, int weight, int value) {
        super(name, weight, value);
    }


    @Override
    public int damage(Character character) {
        return getValue()*character.getVitality();
    }
}
