package com.example.HPFX;

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
    protected void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("intro-view.fxml"));
        StackPane root = fxmlLoader.load();
        Stage stage = (Stage) startingText.getScene().getWindow();
        boolean wasFullScreen = stage.isFullScreen(); // Save the current state of the full screen mode
        Scene introScene = new Scene(root);
        stage.setScene(introScene);
        stage.setTitle("Harry Potter Introduction");
        stage.setFullScreen(wasFullScreen); // Restore the full screen mode
        stage.show();

        // Pass the text to the next scene
        IntroController introController = fxmlLoader.getController();
        introController.setLabelText("* Music *");
    }
}
