package sample;

import java.util.Arrays;

public class Score {

    final static int TURNS = 7;
    final static int DICE = 5;

    // Den räknar totala score för alla rundor
    public static int calculateTotalScore(int[] score) {
        int sum = 0;
        int index = 0;
        // Add up everything that is not -1
        while (index < score.length) {
            // scores of -1 flag unused rows
            if (score[index] != -1) {
                sum = sum + score[index];
            }
            index = index + 1;
        }
        return sum;
    }
// räknar ut chance kategorin
    public static int calculateChance(int[] dice) {
        int chanceSum = 0;
        for (int i = 0; i <dice.length; i++) {
            chanceSum += dice[i];
        }
        return chanceSum;
        }
/*
    public static void showCurrentScoreCard(int[] score) {
        int count = 0;
        while (count < score.length) {
            if (score[count] != -1)
                System.out.println("Current score for die " + (count + 1) + " is " + score[count]);

            else
                System.out.println("Category " + (count+1) + " has not been used yet");
            count = count +1;

        }
    }

/*
    int[] playerOneScores;
    int[] playerTwoScores;


    playerOneScores = new int[TURNS];
    playerTwoScores = new int[TURNS];


        Arrays.fill(playerOneScores, -1);
        Arrays.fill(playerTwoScores, -1);
        */

}



