package com.example.HPFX;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class IntroController {
    private String playerName = "You";
    private String[] texts = {
            "Welcome in the Wizarding World, a world full of magic, hidden away for those who do not know magic, muggles.",
            "And you were a muggle, until today. Because today your door got kicked in by a half-giant.",
            "HAGRID - Hey, you! What's your name ?",
    };

    private String[] generateTexts2() {
        return new String[] {
                "HAGRID  -  So you are " + playerName + " ! Sorry, I didn't introduce myself, I am Hagrid.",
                "HAGRID  -  I was looking for you, and I have a letter for you :"
        };
    }

    private int textIndex = 0;

    @FXML
    private Label nextText;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button nextButton;

    @FXML
    private TextArea letterTextArea;

    @FXML
    public Button continueButton;

    @FXML
    public VBox box;

    @FXML
    protected void onNextButtonClick() {
        if (textIndex < texts.length) {
            animateLabelText();
            textIndex++;
        } else {
            if (Objects.equals(playerName, "You")) {
            displayPlayerMessage();
            } else {
                nextButton.setVisible(false); // Masque le bouton "Next"
                nextText.setVisible(false); // Masque le texte précédent
                // Display the letter content
                String letterContent = "Dear " + playerName + ",\n\n"
                        + "We are happy to inform you that you have been accepted at the Hogwarts Witchcraft School.\n"
                        + "You are therefore invited to join our community of wizards and witches for an unforgettable school year.\n\n"
                        + "Please find enclosed a list of all the necessary books and equipment.\n"
                        + "You will join the school in the middle of the year,\n"
                        + "So your House, Pet and Wand will magically be assigned to you upon your arrival.\n\n"
                        + "Sincerely,\n"
                        + "Albus Dumbledore, Headmaster of Hogwarts";
                letterTextArea.setText(letterContent);
                box.setVisible(true); // Masque le texte précédent
            }
        }
    }

    @FXML
    protected void onNameTextFieldAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            nameTextField.setVisible(false); // Cacher le champ de texte du nom
            nameLabel.setVisible(false); // Cacher le label du nom

            // Continue the story
            continueStory();
        }
    }

    @FXML
    protected void continueStory() {
        playerName = nameTextField.getText();
        System.out.println("Player name: " + playerName);
        texts = generateTexts2();
        textIndex = 0;
        nextText.setText("Oh!");
        nextButton.setVisible(true); // Masque le bouton "Next"
        nextText.setVisible(true); // Masque le texte précédent
        // Vérifie si le joueur a saisi un nom
        if (playerName.isEmpty()) {
            playerName = "dumb";
        }
    }

    public void initialize() {
        nameLabel.setVisible(false); // Masque le label pour le message du joueur au début
        nameTextField.setVisible(false); // Masque le champ de texte pour le nom du joueur au début
        box.setVisible(false); // Masque le texte précédent
    }

    public void setLabelText(String text) {
        nextText.setText(text);
    }

    public void animateLabelText() {
        final int duration = 10; // Durée de l'animation en millisecondes
        final StringProperty labelTextProperty = nextText.textProperty();
        nextText.setText(""); // Définit le texte initial comme une chaîne vide
        String currentText = texts[textIndex]; // Récupère le texte actuel à partir du tableau

        Timeline timeline = new Timeline();

        // Parcourir chaque lettre du texte
        for (int i = 0; i < currentText.length(); i++) {
            KeyValue keyValue = new KeyValue(labelTextProperty, currentText.substring(0, i + 1));
            KeyFrame keyFrame = new KeyFrame(Duration.millis(duration * (i + 1)), keyValue);
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    public void displayPlayerMessage() {
        nextButton.setVisible(false); // Masque le bouton "Next"
        nextText.setVisible(false); // Masque le texte précédent

        nameLabel.setVisible(true); // Affiche le label pour le message du joueur
        nameLabel.setText("Enter your name:"); // Définit le texte du label pour le message du joueur
        nameTextField.setVisible(true); // Affiche le champ de texte pour le nom du joueur
    }

    public void onContinueButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("intro2-view.fxml"));
        StackPane root = fxmlLoader.load();
        Stage stage = (Stage) continueButton.getScene().getWindow();
        boolean wasFullScreen = stage.isFullScreen(); // Save the current state of the full screen mode
        Scene intro2Scene = new Scene(root);
        stage.setScene(intro2Scene);
        stage.setTitle("Harry Potter Introduction");
        stage.setFullScreen(wasFullScreen); // Restore the full screen mode
        stage.show();
    }

}