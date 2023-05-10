package com.example.harry_potter_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label startingText;

    @FXML
    protected void onStartButtonClick() {
        // Load the new FXML file for the intro scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("intro-view.fxml"));
        StackPane root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Stage stage = (Stage) startingText.getScene().getWindow();
        Scene introScene = new Scene(root, 800, 600);
        stage.setScene(introScene);
        stage.setTitle("Harry Potter Introduction");
        stage.setFullScreen(true); // Full screen
        stage.show();
    }
}
