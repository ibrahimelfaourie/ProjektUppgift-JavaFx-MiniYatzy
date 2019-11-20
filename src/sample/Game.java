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
        // spela spelet i omgångar
        int turns = 0;


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

        // räkna ut vinnare
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


        Score.showCurrentScoreCard(score);


        Dice.rollAllDice(dice);


        Dice.showDice(dice);


        Dice.reRollDice(dice, scan);


        Dice.showDice(dice);


        Dice.reRollDice(dice, scan);


        Dice.showDice(dice);

        // Vifrågar spelaren vilken kategore att spara i
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
        // spara i kategorin
        score[category] = Dice.sumOfDice(dice, category+1); // category is unit indexed in the method
*/
    }


