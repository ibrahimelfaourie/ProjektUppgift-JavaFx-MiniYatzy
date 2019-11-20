package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    Button button;

    final int TURNS = 7;
    final int DICE = 5;
    int playedTurns = 0;
    public boolean[] reRoll = new boolean[DICE];
    int[] dice = new int[DICE];
    int round = 0;
    int scorePlayer1[] = new int[TURNS];
    int scorePlayer2[] = new int[TURNS];
    Button kastaAlla;

    String spelare1;
    String spelare2;
    int score1 = 0;
    int score2 = 0;
    // 12 stycken s1sp1
    @FXML
    CheckBox valjEtt;
    @FXML
    CheckBox valjTva;
    @FXML
    CheckBox valjTre;
    @FXML
    CheckBox valjFyra;
    @FXML
    CheckBox valjFem;
    @FXML
    Button sparaEttor1;
    @FXML
    Button sparaTvaor1;
    @FXML
    Button sparaTreor1;
    @FXML
    Button sparaFyror1;
    @FXML
    Button sparaFemmor1;
    @FXML
    Button sparaSexor1;
    @FXML
    Button sparaEttor2;
    @FXML
    Button sparaTvaor2;
    @FXML
    Button sparaTreor2;
    @FXML
    Button sparaFyror2;
    @FXML
    Button sparaFemmor2;
    @FXML
    Button sparaSexor2;
    @FXML
    Label s1spc1;
    @FXML
    Label s1spc2;
    @FXML
    Button chanceButton1;
    @FXML
    Button chanceButton2;
    @FXML
    Label s1sp1;
    @FXML
    Label s1sp2;
    @FXML
    Label s1sp3;
    @FXML
    Label s1sp4;
    @FXML
    Label s1sp5;
    @FXML
    Label s1sp6;

    @FXML
    Label s2sp1;
    @FXML
    Label s2sp2;
    @FXML
    Label s2sp3;
    @FXML
    Label s2sp4;
    @FXML
    Label s2sp5;
    @FXML
    Label s2sp6;


    @FXML
    Label s1Total;
    @FXML
    Label s2Total;

    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    @FXML
    Label spelare2Namn;
    @FXML
    Label spelare1Namn;
    @FXML
    Label showDicesText = new Label();


    // Anropar metoden rollAllDice och printar ut det i Labeln "showDicesText"
    // sedan på runda 2 och 3 gör vi en reroll där vi väljer vad vi ska kasta
    public void kastaAllaTarningar(ActionEvent event) {
        kastaAlla = (Button) event.getSource();
        if (round == 0) {
            Dice.rollAllDice(dice);
            showDicesText.setText(Arrays.toString(dice));
            kastaAlla.setText("Kasta igen");
            round = round + 1;
        } else if (round == 1) {
            kastaIgen();
            round = round + 1;
        } else if (round == 2) {
            kastaIgen();
            kastaAlla.setDisable(true);
            showDicesText.setText(Arrays.toString(dice) + "\n Välj kategori att spara i");
            round = 0;

        }


    }

    // reroll metod som vi använder i kastaAllatärningar
    public void kastaIgen() {
        for (int i = 0; i < DICE; i++) {
            if (reRoll[i]) {
                dice[i] = (int) (Math.random() * 6.0) + 1;
            }

        }
        showDicesText.setText(Arrays.toString(dice));

    }

    public void valjEttKlickad(ActionEvent event) {
        CheckBox v1 = (CheckBox) event.getSource();
        if (v1.isSelected()) {
            reRoll[0] = true;
        } else {
            reRoll[0] = false;
        }

    }

    public void valjTvaKlickad(ActionEvent event) {
        CheckBox v2 = (CheckBox) event.getSource();
        if (v2.isSelected()) {
            reRoll[1] = true;
        } else {
            reRoll[1] = false;
        }

    }

    public void valjTreKlickad(ActionEvent event) {
        CheckBox v3 = (CheckBox) event.getSource();
        if (v3.isSelected()) {
            reRoll[2] = true;
        } else {
            reRoll[2] = false;
        }

    }

    public void valjFyraKlickad(ActionEvent event) {
        CheckBox v4 = (CheckBox) event.getSource();
        if (v4.isSelected()) {
            reRoll[3] = true;
        } else {
            reRoll[3] = false;
        }

    }

    public void valjFemKlickad(ActionEvent event) {
        CheckBox v5 = (CheckBox) event.getSource();
        if (v5.isSelected()) {
            reRoll[4] = true;
        } else {
            reRoll[4] = false;
        }

    }


    //
    public void kategoriEttSpelareEtt(ActionEvent event) {
        scorePlayer1[0] = Dice.sumOfDice(dice, 1);
        sparaEttor1 = (Button) event.getSource();
        sparaEttor1.setText("Vald");
        sparaEttor1.setDisable(true);
        playedTurns = playedTurns + 1;
        s1sp1.setText(String.valueOf(scorePlayer1[0]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriTvaSpelareEtt(ActionEvent event) {
        scorePlayer1[1] = Dice.sumOfDice(dice, 2);
        sparaTvaor1 = (Button) event.getSource();
        sparaTvaor1.setText("Vald");
        sparaTvaor1.setDisable(true);
        playedTurns = playedTurns + 1;
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        showDicesText.setText(spelare2 + " Det är din tur");
        s1sp2.setText(String.valueOf(scorePlayer1[1]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();

    }

    public void kategoriTreSpelareEtt(ActionEvent event) {
        scorePlayer1[2] = Dice.sumOfDice(dice, 3);
        sparaTreor1 = (Button) event.getSource();
        sparaTreor1.setText("Vald");
        sparaTreor1.setDisable(true);
        playedTurns = playedTurns + 1;
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        showDicesText.setText(spelare2 + " Det är din tur");
        s1sp3.setText(String.valueOf(scorePlayer1[2]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriFyraSpelareEtt(ActionEvent event) {
        scorePlayer1[3] = Dice.sumOfDice(dice, 4);
        sparaFyror1 = (Button) event.getSource();
        sparaFyror1.setText("Vald");
        sparaFyror1.setDisable(true);
        playedTurns = playedTurns + 1;
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        showDicesText.setText(spelare2 + " Det är din tur");
        s1sp4.setText(String.valueOf(scorePlayer1[3]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriFemSpelareEtt(ActionEvent event) {
        scorePlayer1[4] = Dice.sumOfDice(dice, 5);
        sparaFemmor1 = (Button) event.getSource();
        sparaFemmor1.setText("Vald");
        sparaFemmor1.setDisable(true);
        playedTurns = playedTurns + 1;
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        showDicesText.setText(spelare2 + " Det är din tur");
        s1sp5.setText(String.valueOf(scorePlayer1[4]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();
    }


    public void kategoriSexSpelareEtt(ActionEvent event) {
        scorePlayer1[5] = Dice.sumOfDice(dice, 6);
        sparaSexor1 = (Button) event.getSource();
        sparaSexor1.setText("Vald");
        sparaSexor1.setDisable(true);
        playedTurns = playedTurns + 1;
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        showDicesText.setText(spelare2 + " Det är din tur");
        s1sp6.setText(String.valueOf(scorePlayer1[5]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        updateScore();
        uncheckBoxes();
    }


    public void kategoriEttSpelareTva(ActionEvent event) {
        scorePlayer2[0] = Dice.sumOfDice(dice, 1);
        sparaEttor2 = (Button) event.getSource();
        sparaEttor2.setText("Vald");
        sparaEttor2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp1.setText(String.valueOf(scorePlayer2[0]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriTvaSpelareTva(ActionEvent event) {
        scorePlayer2[1] = Dice.sumOfDice(dice, 2);
        sparaTvaor2 = (Button) event.getSource();
        sparaTvaor2.setText("Vald");
        sparaTvaor2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp2.setText(String.valueOf(scorePlayer2[1]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriTreSpelareTva(ActionEvent event) {
        scorePlayer2[2] = Dice.sumOfDice(dice, 3);
        sparaTreor2 = (Button) event.getSource();
        sparaTreor2.setText("Vald");
        sparaTreor2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp3.setText(String.valueOf(scorePlayer2[2]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriFyraSpelareTva(ActionEvent event) {
        scorePlayer2[3] = Dice.sumOfDice(dice, 4);
        sparaFyror2 = (Button) event.getSource();
        sparaFyror2.setText("Vald");
        sparaFyror2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp4.setText(String.valueOf(scorePlayer2[3]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriFemSpelareTva(ActionEvent event) {
        scorePlayer2[4] = Dice.sumOfDice(dice, 5);
        sparaFemmor2 = (Button) event.getSource();
        sparaFemmor2.setText("Vald");
        sparaFemmor2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp5.setText(String.valueOf(scorePlayer2[4]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriSexSpelareTva(ActionEvent event) {
        scorePlayer2[5] = Dice.sumOfDice(dice, 6);
        sparaSexor2 = (Button) event.getSource();
        sparaSexor2.setText("Vald");
        sparaSexor2.setDisable(true);
        playedTurns = playedTurns + 1;
        s2sp6.setText(String.valueOf(scorePlayer2[5]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        updateScore();
        uncheckBoxes();
    }

    public void kategoriChanceSpelareEtt(ActionEvent event) {
        scorePlayer1[TURNS - 1] = Score.calculateChance(dice);
        playedTurns = playedTurns + 1;
        s1spc1.setText(String.valueOf(scorePlayer1[TURNS - 1]));
        score1 = Score.calculateTotalScore(scorePlayer1);
        s1Total.setText(String.valueOf(score1));
        chanceButton1.setText("Vald");
        chanceButton1.setDisable(true);
        updateScore();
        uncheckBoxes();
    }


    public void kategoriChanceSpelareTva(ActionEvent event) {
        scorePlayer2[TURNS - 1] = Score.calculateChance(dice);
        playedTurns = playedTurns + 1;
        s1spc2.setText(String.valueOf(scorePlayer1[TURNS - 1]));
        score2 = Score.calculateTotalScore(scorePlayer2);
        s2Total.setText(String.valueOf(score2));
        chanceButton2.setText("Vald");
        chanceButton2.setDisable(true);
        updateScore();
        uncheckBoxes();

    }

    public void uncheckBoxes() {
        valjEtt.setSelected(false);
        valjTva.setSelected(false);
        valjTre.setSelected(false);
        valjFyra.setSelected(false);
        valjFem.setSelected(false);
    }

    public void updateScore() {
        if (playedTurns < 14) {
            kastaAlla.setDisable(false);
            kastaAlla.setText("Kasta");
            if (playedTurns % 2 == 0) {
                showDicesText.setText(spelare1 + " Det är din tur");
            } else {
                showDicesText.setText(spelare2 + ", det är din tur");
            }
        } else {
            if (score1 > score2) {
                showDicesText.setText(spelare1 + " Har vunnit!");
            } else if (score2 > score1) {
                showDicesText.setText(spelare2 + " Har vunnit!");

            } else {
                showDicesText.setText("Det blev lika!");
            }
        }
    }


    public void setPlayerNames(String spelare1, String spelare2) {
        this.spelare1 = spelare1;
        this.spelare2 = spelare2;
    }

    public void showPlayer1name(ActionEvent event) {
        spelare1 = textField1.getText();

        spelare1Namn.setText(spelare1);
        showDicesText.setText(spelare1 + " Det är din tur");
    }

    public void showPlayer2name(ActionEvent event) {
        spelare2 = textField2.getText();

        spelare2Namn.setText(spelare2);
    }

    public void spelaNyttSpel() {
        score1 = 0;
        score2 = 0;
        scorePlayer1 = new int[TURNS];
        scorePlayer2 = new int[TURNS];
        kastaAlla.setDisable(false);
        kastaAlla.setText("Kasta");
        sparaEttor1.setDisable(false);
        sparaEttor2.setDisable(false);
        sparaTvaor1.setDisable(false);
        sparaTvaor2.setDisable(false);
        sparaTreor1.setDisable(false);
        sparaTreor2.setDisable(false);
        sparaFyror1.setDisable(false);
        sparaFyror2.setDisable(false);
        sparaFemmor1.setDisable(false);
        sparaFemmor2.setDisable(false);
        sparaSexor1.setDisable(false);
        sparaSexor2.setDisable(false);
        chanceButton1.setDisable(false);
        chanceButton2.setDisable(false);
        sparaEttor1.setText("Ta poäng");
        sparaEttor2.setText("Ta poäng");
        sparaTvaor1.setText("Ta poäng");
        sparaTvaor2.setText("Ta poäng");
        sparaTreor1.setText("Ta poäng");
        sparaTreor2.setText("Ta poäng");
        sparaFyror1.setText("Ta poäng");
        sparaFyror2.setText("Ta poäng");
        sparaFemmor1.setText("Ta poäng");
        sparaFemmor2.setText("Ta poäng");
        sparaSexor1.setText("Ta poäng");
        sparaSexor2.setText("Ta poäng");
        chanceButton1.setText("Ta poäng");
        chanceButton2.setText("Ta poäng");
        s1sp1.setText("?");
        s1sp2.setText("?");
        s1sp3.setText("?");
        s1sp4.setText("?");
        s1sp5.setText("?");
        s1sp6.setText("?");
        s2sp1.setText("?");
        s2sp2.setText("?");
        s2sp3.setText("?");
        s2sp4.setText("?");
        s2sp5.setText("?");
        s2sp6.setText("?");
        s1spc1.setText("?");
        s1spc2.setText("?");
        s1Total.setText("0");
        s2Total.setText("0");
        showDicesText.setText(spelare1 + ", det är din tur");

    }


}

