package Experiments;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class HelloHashMap {

    public static void main(String[] args) {
        int[] numbers = new int[] {10, 20, 33, 44, 55};

        System.out.println(numbers[2]);

        HashMap<String, String> fruitToColour = new HashMap<>();

        fruitToColour.put("apple", "red");
        fruitToColour.put("apple", "green");
        fruitToColour.put("pear", "green");
        fruitToColour.put("blueberry", "blue");
        fruitToColour.put("tomato", "red");

        System.out.println("Enter Name Of The Fruit (enter quit to exit program): ");

        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

            String fruit = input.nextLine();

            if (fruit.equalsIgnoreCase("quit")) break;

            String colour = fruitToColour.get(fruit);

            System.out.println(colour);
        }

        //Key/Value pairs

        String[] fruit = new String[] {
                "apple",
                "Apple",
                "Pear",
                "Blueberry",
                "Tomato",
        };

        String[] colour = new String[] {
                "red",
                "green",
                "green",
                "blue",
                "red",
        };

        String key = "Apple";

        for (int i = 0; 1 < fruit.length; i++) {
            if (fruit[i] == key) {
                System.out.println(colour[i]);
                break;
            }
        }

    }
}
