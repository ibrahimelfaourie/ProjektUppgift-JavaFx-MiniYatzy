package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mini Yatzy");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {





       // Game.playOneGame(namePlayer1, playerOneScores, namePlayer2, playerTwoScores, scan);





        launch(args);
    }


    }

