public abstract class Weapon extends Item {

    public Weapon(String name, int weight, int value) {
        super(name, weight, value);
    }
    public abstract int damage(Character character);

}
