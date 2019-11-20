package sample;

import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);


    final static int TURNS = 6;
    final static int DICE = 5;

    int[] playerOneScores;
    int[] playerTwoScores;
/*
    public static  void playOneGame(String name1 , int[] player1Score, String name2, int[] player2Score, Scanner scan) {
        // play the game in turns
        int turns = 0;

        // the game has one turn for every possible outcome
        while (turns<TURNS){

            // players alternate playing
            System.out.println(name1+ " it is your turn");
            playOneTurn(player1Score, scan);

            System.out.println(name2 + " it is your turn");
            playOneTurn(player2Score, scan);

            turns = turns+1;
            // Spelet startar med omgång 0 och efter första omgång ökas det med 1 gång och
            // while loopen stannar när det blivit totalt 6 gånger

        }

        // find the winner
        int score1 = Score.calculateTotalScore(player1Score);
        System.out.println(name1 + " your score is " + score1);
        int score2 = Score.calculateTotalScore(player2Score);
        System.out.println(name2 + " your score is " + score2);

        if(score1 > score2){
            System.out.println("Congragulation " + name1);
        }else if(score2 > score1){
            System.out.println("Congratulation " + name2);
        }else{
            System.out.println("its a tie");
        }
    }
/*
    public static void playOneTurn(int[] score, Scanner scan) {

        int[] dice = new int[DICE];

        // show the user their score card
        Score.showCurrentScoreCard(score);

        // roll all of the dices
        Dice.rollAllDice(dice);

        // show the dice to the user
        Dice.showDice(dice);

        // let them reroll dice
        Dice.reRollDice(dice, scan);

        // show the dice to the user
        Dice.showDice(dice);

        // let them reroll the dice again
        Dice.reRollDice(dice, scan);

        // show the user the dice
        Dice.showDice(dice);

        // ask them for a category to score
        System.out.println("which category would you like to score in");
        int category = scan.nextInt(); // unit indexed
        scan.nextLine();
        category = category -1; // zero indexed

        while (category<0||category>=TURNS || score[category] != -1){
            System.out.println("That is not a legal category, remember you cannot re score in a category");
            System.out.println("Please enter the category you would like to score in");
            category = scan.nextInt(); // unit indexed
            scan.nextLine(); //
            category = category -1; // zero indexed
        }
        // score the category
        score[category] = Dice.sumOfDice(dice, category+1); // category is unit indexed in the method
*/
    }


