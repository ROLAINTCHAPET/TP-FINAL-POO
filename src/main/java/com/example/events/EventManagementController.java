package com.example.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EventManagementController {

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnEffacerNotifications;

    @FXML
    private Button btnEvenements;

    @FXML
    private Button btnNouveauConcert;

    @FXML
    private Button btnNouvelEvenement;

    @FXML
    private Button btnNouvelleConference;

    @FXML
    private Button btnParticipants;

    @FXML
    private Button btnRapports;

    @FXML
    private ScrollPane notifid;


    @FXML
    private TableColumn<?, ?> colConcertActions;

    @FXML
    private TableColumn<?, ?> colConcertArtiste;

    @FXML
    private TableColumn<?, ?> colConcertCapacite;

    @FXML
    private TableColumn<?, ?> colConcertDate;

    @FXML
    private TableColumn<?, ?> colConcertLieu;

    @FXML
    private TableColumn<?, ?> colConcertNom;

    @FXML
    private TableColumn<?, ?> colConferenceActions;

    @FXML
    private TableColumn<?, ?> colConferenceDate;

    @FXML
    private TableColumn<?, ?> colConferenceDuree;

    @FXML
    private TableColumn<?, ?> colConferenceLieu;

    @FXML
    private TableColumn<?, ?> colConferenceNom;

    @FXML
    private TableColumn<?, ?> colConferenceOrateur;

    @FXML
    private Label lblDateHeure;

    @FXML
    private Label lblNbConcerts;

    @FXML
    private Label lblNbConferences;

    @FXML
    private Label lblNbNotifications;

    @FXML
    private Label lblStatut;

    @FXML
    private Label lblTotalParticipants;

    @FXML
    private ListView<?> listProchainsEvenements;

    @FXML
    private RadioButton rbConcerts;

    @FXML
    private RadioButton rbConferences;

    @FXML
    private RadioButton rbTous;

    @FXML
    private TabPane tabPaneEvenements;

    @FXML
    private TableView<?> tableConcerts;

    @FXML
    private TableView<?> tableConferences;

    @FXML
    private VBox vboxNotifications;

    @FXML
    private BorderPane rootPane;


    @FXML
    private void handleBtnAccueil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilevents.fxml"));
            Parent accueilView = loader.load();
            rootPane.setCenter(accueilView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBtnEffacerNotifications(ActionEvent event) {

    }

    @FXML
    void handleBtnEvenements(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("events-view.fxml"));
            Parent eventsview = loader.load();
            rootPane.setCenter(eventsview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBtnNouveauConcert(ActionEvent event) {

    }

    @FXML
    void handleBtnNouvelEvenement(ActionEvent event) {

    }

    @FXML
    void handleBtnNouvelleConference(ActionEvent event) {

    }

    @FXML
    void handleBtnParticipants(ActionEvent event) {

    }

    @FXML
    void handleBtnRapports(ActionEvent event) {

    }

    @FXML
    void handleFilterConcerts(ActionEvent event) {

    }

    @FXML
    void handleFilterConferences(ActionEvent event) {

    }

    @FXML
    void handleFilterTous(ActionEvent event) {

    }

    @FXML
    void openregistrationpage(ActionEvent event)throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InscrireParticipant.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400,400);
        stage.setTitle("Gestion des Evenements!");
        stage.setScene(scene);
        stage.show();
    }

}
