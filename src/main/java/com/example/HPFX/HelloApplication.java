package com.example.HPFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-view.fxml"));
        StackPane root = fxmlLoader.load();
        Scene startingScene = new Scene(root);

        // Set the stage to be full screen
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setWidth(screenBounds.getWidth());
        stage.setHeight(screenBounds.getHeight());

        stage.setTitle("Harry Potter at Home");
        stage.setScene(startingScene);
        stage.show();

        // Play the background music
        String audioFile = Objects.requireNonNull(getClass().getResource("/hp.mp3")).toExternalForm();
        Media backgroundMusic = new Media(audioFile);
        MediaPlayer backgroundMedia = new MediaPlayer(backgroundMusic);
        backgroundMedia.setVolume(0.5);  // 50% volume
        backgroundMedia.setCycleCount(MediaPlayer.INDEFINITE);  // Repeat indefinitely
        backgroundMedia.setAutoPlay(true);  // Autoplay when program starts
    }

    public static void main(String[] args) {
        launch();
    }
}
