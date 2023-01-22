public interface Actions {
    void attack(Character character);

    void pick(Weapon weapon);

    void wield(Weapon weapon, Character character);

    void wear(Armor armor, MainCharacter mainCharacter);

    void examine(Weapon weapon);

    void listInventory();

}
