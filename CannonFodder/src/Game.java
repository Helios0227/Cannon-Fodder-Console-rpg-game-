import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Game {

    List<EnemySoldier> enemySoldierList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public void game() throws Exception {
        boolean isMainCTurn = true;
        Scanner scanner = new Scanner(System.in);
        int level = 0;
        int highScore = level + 1;
        File file = new File("HighScores.txt");
        file.createNewFile();
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner1 = new Scanner(file);
        int enemyCount = (int) Math.pow(2, level);
        int enemyIndex = 1;
        boolean isMainCharacterTurn = true;
        List<EnemySoldier> enemySoldierList = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        Shield shield3 = new Shield("Revenge", 1, 2);
        Wand wand3 = new Wand("IceAge", 1, 1);
        Sword sword5 = new Sword("Excalibur", 1, 2);
        Sword sword = new Sword("Dagger", 1, 2);
        Sword sword1 = new Sword("Long Sword", 2, 3);
        Sword sword2 = new Sword("Destiny's Song", 3, 3);
        Sword sword3 = new Sword("Nightfall", 2, 4);
        Shield shield = new Shield("Dragonheart", 1, 1);
        Shield shield1 = new Shield("Colossus", 1, 2);
        Shield shield2 = new Shield("PromisedAegis", 2, 3);
        Wand wand = new Wand("Mercy", 1, 2);
        Wand wand1 = new Wand("Frostguard", 1, 1);
        Wand wand2 = new Wand("Phantom", 2, 2);
        Armor armor = new Armor("ChestplateofSilent Hell", 1, 2);
        Armor armor1 = new Armor("VestofHallowedWars", 2, 3);
        Armor armor2 = new Armor("HeirloomofIceMagic", 1, 1);
        itemList.add(armor);
        itemList.add(armor1);
        itemList.add(armor2);
        itemList.add(wand);
        itemList.add(wand1);
        itemList.add(wand2);
        itemList.add(shield);
        itemList.add(shield1);
        itemList.add(shield2);
        itemList.add(sword);
        itemList.add(sword1);
        itemList.add(sword2);
        itemList.add(sword3);
        itemList.add(wand3);
        itemList.add(shield3);

        Random random = new Random();
        Fighter fighter = new Fighter("Fighter", random.nextInt(4) + 6, random.nextInt(4) + 3, random.nextInt(4) + 1);
        Tank tank = new Tank("Tank", random.nextInt(4) + 1, random.nextInt(4) + 6, random.nextInt(4) + 3);
        Healer healer = new Healer("Healer", random.nextInt(4) + 3, random.nextInt(4) + 1, random.nextInt(4) + 6);
        EnemySoldier enemySoldier = new EnemySoldier("Enemy" + enemyIndex, random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(4) + 1);
        enemySoldierList.add(enemySoldier);
        fighter.setWeapon(sword5);
        tank.setWeapon(shield3);
        healer.setWeapon(wand3);
        fighter.setArmor(armor);
        tank.setArmor(armor1);
        healer.setArmor(armor2);
        System.out.println("This game was made with string split. You should do the user input with this in mind. for example you must type Fighter attack Enemy1. ");
        System.out.println("If you don't type properly, the game will be over.");
        System.out.println("If you type EXİT game will be terminated");
        System.out.println("Fighter created with S : " + fighter.getStrength() + " V : " + fighter.getVitality() + " I : " + fighter.getIntelligence() + " THe Hp is :" + fighter.getHp() + " Fighter wields  " + fighter.getWeapon().getName() + ", with " + fighter.getWeapon().getValue() + " damage and " + fighter.getWeapon().getWeight() + " units of weight");
        System.out.println("Tank created with S :" + tank.getStrength() + " V : " + tank.getVitality() + " I : " + tank.getIntelligence() + "The HP is :" + tank.getHp() + " Tank Wields " + tank.getWeapon().getName() + ", with " + tank.getWeapon().getValue() + " damage  and " + tank.getWeapon().getWeight() + " units of weight");
        System.out.println("Healer created with S : " + healer.getStrength() + " V : " + healer.getVitality() + " I : " + healer.getIntelligence() + " THe Hp is :" + healer.getHp() + " Healer Wields " + healer.getWeapon().getName() + ", with " + healer.getWeapon().getValue() + " damage and" + healer.getWeapon().getWeight() + " units of weight");
        System.out.println("Creating level " + level + " with " + enemyCount + " enemy soldier");
        System.out.println("Entering level " + level + ";" + fighter.getName() + " enters." + tank.getName() + " enters." + healer.getName() + " enters.");
        for (EnemySoldier e : enemySoldierList) {
            System.out.println(e.getName() + " enters.");
        }

        while (!fighter.isDead() || !tank.isDead() || !healer.isDead()) {
            if (isMainCharacterTurn || enemySoldierList.size() == 0) {
                String command = scanner.nextLine();
                String[] list = command.split(" ");
                EnemySoldier enemySoldier1 = null;
                Item item = null;
                if (list[0].equals("EXIT")) {
                    System.out.println("Program Terminated");
                    break;
                }
                if (list[0].equals("Fighter")) {
                    if (list[1].equals("attack")) {
                        for (int i = 0; i < enemySoldierList.size(); i++) {
                            if (enemySoldierList.get(i).getName().equals(list[2])) {
                                enemySoldier1 = enemySoldierList.get(i);
                            }
                        }
                        if (enemySoldier1 == null) {
                            throw new Exception("Enemy Not Found");
                        }
                        fighter.attack(enemySoldier1);
                        if (enemySoldier1.isDead()) {
                            enemySoldierList.remove(enemySoldier1);
                        }
                        isMainCharacterTurn = false;
                    } else if (list[1].equals("examine")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }

                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        fighter.examine((Weapon) item);


                        isMainCharacterTurn = false;
                    }
                    //TODO
                    else if (list[1].equals("pick")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }


                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        fighter.pick((Weapon) item);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("wield")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }


                        fighter.wield((Weapon) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("Wear")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Armor)) {
                            throw new Exception("It has to be a Armor");
                        }


                        fighter.wear((Armor) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("ListInventory")) {
                        if (list[2].equals("Fighter")) {
                            fighter.listInventory();
                        }

                    }
                    //TODO
                       else if (list[1].equals("SpecialAction")) {
                            if (fighter.getWeapon() instanceof Sword) {
                                if (list[2].equals("Sword")){
                                    System.out.println("Fighter used special power of ");
                                    isMainCharacterTurn=true;
                                }
                            } else if (fighter.getWeapon() instanceof Shield) {
                                if (list[2].equals("Shield")){
                                    System.out.println("Fighter used special power of shield");
                                    isMainCTurn=true;
                                }

                            } else if (fighter.getWeapon() instanceof Wand) {
                                if (list[2].equals("Tank")) {
                                    tank.setHp(tank.getHp() + fighter.getWeapon().getValue());
                                    System.out.println("Tank healed by : " + fighter.getWeapon().getValue());
                                } else if (list[2].equals("Healer")) {
                                    healer.setHp(healer.getHp() + fighter.getWeapon().getValue());
                                    System.out.println("Healer healed by : " + fighter.getWeapon().getValue());
                                } else if (list[2].equals("Fighter")) {
                                    fighter.setHp(fighter.getHp() + fighter.getWeapon().getValue());
                                    System.out.println("Fighter healed by : " + fighter.getWeapon().getValue());
                                }

                            }
                            isMainCharacterTurn = false;
                        }


                }
                if (list[0].equals("Tank")) {
                    if (list[1].equals("attack")) {
                        for (int i = 0; i < enemySoldierList.size(); i++) {
                            if (enemySoldierList.get(i).getName().equals(list[2])) {
                                enemySoldier1 = enemySoldierList.get(i);
                            }
                        }
                        if (enemySoldier1 == null) {
                            throw new Exception("Enemy Not Found");
                        }
                        tank.attack(enemySoldier1);
                        if (enemySoldier1.isDead()) {
                            enemySoldierList.remove(enemySoldier1);
                        }
                        isMainCharacterTurn = false;
                    } else if (list[1].equals("examine")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        tank.examine((Weapon) item);


                        isMainCharacterTurn = false;
                    }
                    //TODO
                    else if (list[1].equals("pick")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        tank.pick((Weapon) item);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("wield")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }


                        tank.wield((Weapon) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("Wear")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Armor)) {
                            throw new Exception("It has to be a Armor");
                        }


                        tank.wear((Armor) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("ListInventory")) {
                        if (list[2].equals("Tank")) {
                            tank.listInventory();
                        }

                    }
                    //TODO
                           else if (list[1].equals("Special Action")) {
                                if (tank.getWeapon() instanceof Sword) {
                                    if (list[2].equals("Sword")){
                                        System.out.println("Tank used special power of sword");
                                        isMainCTurn=true;
                                    }
                                } else if (tank.getWeapon() instanceof Shield) {
                                    if (list[2].equals("Shield")){
                                        System.out.println("Tank used special power of shield");
                                        isMainCTurn=true;
                                    }


                                } else if (tank.getWeapon() instanceof Wand) {
                                    if (list[2].equals("Tank")) {
                                        tank.setHp(tank.getHp() + fighter.getWeapon().getValue());
                                        System.out.println("Tank healed by : " + tank.getWeapon().getValue());
                                    } else if (list[2].equals("Healer")) {
                                        healer.setHp(healer.getHp() + fighter.getWeapon().getValue());
                                        System.out.println("Healer healed by : " + tank.getWeapon().getValue());
                                    } else if (list[2].equals("Fighter")) {
                                        fighter.setHp(fighter.getHp() + tank.getWeapon().getValue());
                                        System.out.println("Fighter healed by : " + tank.getWeapon().getValue());
                                    }

                                }


                                isMainCharacterTurn = false;
                            }
                }


                if (list[0].equals("Healer")) {
                    if (list[1].equals("attack")) {
                        for (int i = 0; i < enemySoldierList.size(); i++) {
                            if (enemySoldierList.get(i).getName().equals(list[2])) {
                                enemySoldier1 = enemySoldierList.get(i);
                            }
                        }

                        if (enemySoldier1 == null) {
                            throw new Exception("Enemy Not Found");
                        }
                        healer.attack(enemySoldier1);
                        if (enemySoldier1.isDead()) {
                            enemySoldierList.remove(enemySoldier1);
                        }
                        isMainCharacterTurn = false;
                    } else if (list[1].equals("examine")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        healer.examine((Weapon) item);


                        isMainCharacterTurn = false;
                    }
                    //TODO
                    else if (list[1].equals("pick")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }
                        healer.pick((Weapon) item);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("wield")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Weapon)) {
                            throw new Exception("It has to be a Weapon");
                        }


                        healer.wield((Weapon) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("Wear")) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getName().equals(list[2])) {
                                item = itemList.get(i);
                            }
                        }
                        if (item == null) {
                            throw new Exception("Item not found");
                        }
                        if (!(item instanceof Armor)) {
                            throw new Exception("It has to be a Armor");
                        }


                        healer.wear((Armor) item, fighter);


                        isMainCharacterTurn = false;
                    } else if (list[1].equals("ListInventory")) {
                        if (list[2].equals("Healer")) {
                            healer.listInventory();
                        }

                    }
                    //TODO
                           else if (list[1].equals("Special Action")) {

                                if (healer.getWeapon() instanceof Sword) {
                                    if (list[2].equals("Sword")) {
                                        System.out.println("Healer used special power of sword");
                                        isMainCharacterTurn = true;
                                    }
                                } else if (healer.getWeapon() instanceof Shield) {
                                    if (list[2].equals("Shield")) {
                                        System.out.println("Healer used special power of shield");
                                        isMainCharacterTurn = true;
                                    }

                                } else if (healer.getWeapon() instanceof Wand) {
                                    if (list[2].equals("Tank")) {
                                        tank.setHp(tank.getHp() + healer.getWeapon().getValue());
                                        System.out.println("Tank healed by : " + healer.getWeapon().getValue());
                                    } else if (list[2].equals("Healer")) {
                                        healer.setHp(healer.getHp() + healer.getWeapon().getValue());
                                        System.out.println("Healer healed by : " + healer.getWeapon().getValue());
                                    } else if (list[2].equals("Fighter")) {
                                        fighter.setHp(fighter.getHp() + healer.getWeapon().getValue());
                                        System.out.println("Fighter healed by : " + healer.getWeapon().getValue());
                                    }
                                    isMainCharacterTurn = false;
                                }

                            }

                }


                if (enemySoldierList.size() > 0) {
                    if (!isMainCharacterTurn && !tank.isDead()) {
                        enemySoldierList.get(0).attack(tank);
                        isMainCharacterTurn = true;
                    } else if (!isMainCharacterTurn && !fighter.isDead()) {
                        enemySoldier.attack(fighter);
                        isMainCharacterTurn = true;
                    } else if (!isMainCharacterTurn && !healer.isDead()) {
                        enemySoldier.attack(healer);
                        isMainCharacterTurn = true;
                    }
                }


                if (command.equals("NEXT")) {
                    isMainCharacterTurn = true;
                    level++;
                    enemyCount = (int) Math.pow(2, level);
                    for (int i = 0; i < enemyCount; i++) {
                        enemyIndex++;
                        EnemySoldier enemy = new EnemySoldier("Enemy" + enemyIndex, random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(4) + 1);
                        enemySoldierList.add(enemy);
                    }
                    System.out.println("Creating level " + level + " with " + enemyCount + " enemy soldier");
                    System.out.println("Entering level  " + level + ";" + fighter.getName() + " enters." + tank.getName() + " enters." + healer.getName() + " enters.");
                    for (EnemySoldier e : enemySoldierList) {
                        System.out.println(e.getName() + " enters.");
                    }

                }

            }


        }
        arrayList.add(String.valueOf(highScore));
        while (scanner1.hasNextLine()) {
            String s = scanner1.nextLine();
            String[] arrays = s.split(" ");
            arrayList.add((arrays[1]));
        }
        Collections.reverse(arrayList);
        FileOutputStream fout=new FileOutputStream("HighScores.txt");
        for (int i=0;i<arrayList.size();i++){
            fout.write(49 + i);
            fout.write(46);
            fout.write(32);
            byte b[]=arrayList.get(i).getBytes();
            fout.write(b);
            fout.write(10);
        }

    }

}


