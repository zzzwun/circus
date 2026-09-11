package circus;

import circus.animal.*;
import circus.equipment.Equipment;
import circus.equipment.Cannon;
import circus.equipment.Ladder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println("Number of animals in the circus: " + animals.length);

        /*for (Animal a : animals) {
            System.out.println(a);
        }*/

        System.out.println("(Using Array) Number of animals in the circus: " + animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        //printAllAnimals(animalArrayList);

        System.out.println("Add a new elephant");
        animalArrayList.add(new Elephant("StrongOne"));
        System.out.println("(Using ArrayList) Number of animals in the circus: " + animalArrayList.size());

        printAllAnimals(animalArrayList);

        Parrot andy = new Parrot("Andy");
        animalArrayList.add(andy);

        printAllAnimals(animalArrayList);
//        System.out.println("(Using ArrayList) Number of animals in the circus: " + animalArrayList.size());
//        System.out.println("Position of Andy in the AL is " + animalArrayList.indexOf(andy));

        Animal candidate = findAnimalReference(animalArrayList, "Polly");
        System.out.println("Position of candidate in the AL is " + animalArrayList.indexOf(candidate));

        animalArrayList.sort(Animal.animalNameComparator);

        //makeAnimalsTalk();
        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printAllAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    private static Animal findAnimalReference(ArrayList<Animal> animals, String nameOfAnimal) {
        for (Animal a : animals) {
            if (a.name == nameOfAnimal) {
                return a;
            }
        }
        return null;
    }

}