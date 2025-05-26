package com.example.events.Controllers;

import com.example.events.HelloApplication;
import com.example.events.evenement.Concert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.events.evenement.Concert;
import com.example.events.jsonmanipulation.ConcertSerialisation;


import java.io.IOException;
import java.util.List;

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
    private TableView<Concert> tableConcerts;

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
    void handleBtnNouvelEvenement(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("eventcreate.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400,400);
        stage.setTitle("Gestion des Evenements!");
        stage.setScene(scene);
        stage.show();
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
    @FXML
    public void initialize() throws IOException {
        colConcertNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colConcertArtiste.setCellValueFactory(new PropertyValueFactory<>("artiste"));
        colConcertDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colConcertLieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        colConcertCapacite.setCellValueFactory(new PropertyValueFactory<>("capaciteMaximale"));

        // Exemple : charger des concerts fictifs

        ConcertSerialisation ser = new ConcertSerialisation();
        List<Concert> CONCERTLIST = ser.getAllConcerts();

        tableConcerts.setItems(FXCollections.observableArrayList(CONCERTLIST));
    }

}
