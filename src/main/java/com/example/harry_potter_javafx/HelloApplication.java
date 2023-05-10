package com.example.harry_potter_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-view.fxml"));
        StackPane root = fxmlLoader.load();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Harry Potter at Home");
        stage.setScene(scene);
        stage.setFullScreen(true); // Full screen
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
