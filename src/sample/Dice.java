package sample;

import javafx.scene.image.ImageView;

import java.util.Scanner;

public class Dice {


    final static int DICE = 5;
    final static int TURNS = 6;

   // Den räknar ut total poäng för en kategori
    public static int sumOfDice(int[] dice, int number){
        int sum = 0;
        int index = 0;
        while (index<dice.length){
            if(dice[index] == number){
                sum = sum+dice[index];
            }
            index = index +1;
        }
        return sum;
    }
    //visar värdet på alla tärningar för kastet
    public static void showDice(int[] dice){

        int index = 0;
        while (index<DICE){
            System.out.println((index+1) + ". " + dice[index]);
            index = index+1;
        }

    }

    // kastar alla tärningar
    // parameter "dice" värdet på dom kastatde tärningarna sparas i arrayen

    public static void rollAllDice(int dice []){
        int index = 0;
        while (index<dice.length){
            dice[index] = (int)(Math.random() * TURNS)+1;
            index = index +1;
        }
    }
    // Denna metod gör vi en Reroll
    public static void reRollDice(int [] dice, Scanner scan){

        System.out.println("Which dice would you like to reroll?, enter -1 if you do not wish to reroll");
        String inputLine = scan.nextLine();

        Scanner line = new Scanner(inputLine);

        while (line.hasNextInt()){
            int reRollValue = line.nextInt(); // unit indexed

            if(reRollValue == -1)
                return; // we get out of there since we dont walt to reroll when we type -1
            if (reRollValue <= 0 || reRollValue >DICE) { // if the value is out of range we tell it is not a legal value
                System.out.println("That is not a legal value, no dice will be rolled again");
            } else {
                dice[reRollValue-1] =(int)(Math.random()*6.0) +1; // otherwise we reroll dice

            }

        }




    }






}
