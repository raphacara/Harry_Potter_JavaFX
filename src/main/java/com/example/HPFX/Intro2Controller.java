package com.example.HPFX;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.Random;

public class Intro2Controller {

    @FXML
    private StackPane housePane;

    @FXML
    private ImageView houseImage;

    @FXML
    private Label houseLabel;

    @FXML
    private StackPane petPane;

    @FXML
    private ImageView petImage;

    @FXML
    private Label petLabel;

    @FXML
    private StackPane wandPane;

    @FXML
    private ImageView wandImage;

    @FXML
    private Label wandLabel;

    private static final String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    private static final String[] HOUSE_IMAGES = {"/gryffindor.jpeg", "/hufflepuff.jpeg", "/ravenclaw.jpeg", "/slytherin.jpeg"};

    private static final String[] PET_NAMES = {"Cat", "Owl", "Toad"};
    private static final String[] PET_IMAGES = {"/cat.jpeg", "/owl.jpeg", "/toad.jpeg"};

    private static final String[] WAND_CORES = {"Dragon Core", "Unicorn Core", "Phoenix Core"};
    private static final String[] WAND_IMAGES = {"/dragon.jpeg", "unicorn.jpeg", "phoenix.jpeg"};
    private static final int WAND_MIN_LENGTH = 25;
    private static final int WAND_MAX_LENGTH = 35;

    private boolean houseAssigned = false;
    private boolean petAssigned = false;
    private boolean wandAssigned = false;

    public void initialize() {
        housePane.setOnMouseClicked(this::assignRandomHouse);
        petPane.setOnMouseClicked(this::assignRandomPet);
        wandPane.setOnMouseClicked(this::assignRandomWand);
    }

    private void assignRandomHouse(MouseEvent mouseEvent) {
        if (houseAssigned) {
            return; // Exit the method if a house has already been assigned
        }

        Random random = new Random();
        int index = random.nextInt(HOUSE_NAMES.length);

        String houseName = HOUSE_NAMES[index];
        String houseImageURL = HOUSE_IMAGES[index];

        houseImage.setImage(new Image(houseImageURL));
        houseLabel.setText(houseName);

        houseAssigned = true;
    }

    private void assignRandomPet(MouseEvent mouseEvent) {
        if (petAssigned) {
            return; // Exit the method if a pet has already been assigned
        }

        Random random = new Random();
        int index = random.nextInt(PET_NAMES.length);

        String petName = PET_NAMES[index];
        String petImageURL = PET_IMAGES[index];

        petImage.setImage(new Image(petImageURL));
        petLabel.setText(petName);

        petAssigned = true;
    }

    private void assignRandomWand(MouseEvent mouseEvent) {
        if (wandAssigned) {
            return; // Exit the method if a wand has already been assigned
        }

        Random random = new Random();
        int index = random.nextInt(WAND_CORES.length);
        int wandLength = random.nextInt(WAND_MAX_LENGTH - WAND_MIN_LENGTH + 1) + WAND_MIN_LENGTH;

        String wandCore = WAND_CORES[index];
        String wandLengthText = wandLength + "cm";
        String wandImageURL = WAND_IMAGES[index];

        wandImage.setImage(new Image(wandImageURL));
        wandLabel.setText(wandCore + " (" + wandLengthText + ")");

        wandAssigned = true;
    }
}