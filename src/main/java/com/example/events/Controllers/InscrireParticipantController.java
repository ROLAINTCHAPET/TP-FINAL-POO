package com.example.events.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InscrireParticipantController {

    @FXML
    private TextField emailTextField;

    @FXML
    private ComboBox<?> evenementComboBox;

    @FXML
    private Button inscrireButton;

    @FXML
    private TextField name_event;

    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    private Button resetButton;

    @FXML
    void handleInscription(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {

    }

}
