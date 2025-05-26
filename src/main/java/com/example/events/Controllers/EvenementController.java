package com.example.events.Controllers;

import com.example.events.jsonmanipulation.OrganisateurSerialisation;
import com.example.events.personnes.Organisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.example.events.evenement.Concert;
import com.example.events.evenement.Conference;
import com.example.events.jsonmanipulation.ConferenceSerialisation;
import com.example.events.personnes.Intervenant;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.ConcertSerialisation;

import java.time.LocalDate;
import java.util.ArrayList;

public class EvenementController {

    @FXML
    public ComboBox<String> cbType;

    @FXML
    public TextField tfCapacite;

    @FXML
    public TextField tfDate;

    @FXML
    public TextField tfLieu;

    @FXML
    public TextField tfNom;

    @FXML
    public void enregistrerEvenement(ActionEvent event) throws Exception {
        String nom = tfNom.getText();
        String date = tfDate.getText();
        String lieu = tfLieu.getText();
        String capaciteStr = tfCapacite.getText();
        String type = (String) cbType.getValue();

        // Vérification des champs
        if (nom.isEmpty() || date == null || lieu.isEmpty() || capaciteStr.isEmpty() || type == null) {
            showAlert("Tous les champs sont obligatoires.");
            return;
        }

        int capacite;
        try {
            capacite = Integer.parseInt(capaciteStr);
            if (capacite <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            showAlert("La capacité doit être un entier positif.");
            return;
        }

        // Traitement selon le type
        if (type.equals("Concert")) {
            System.out.println("Création d’un Concert : " + nom);
            Concert concert = new Concert(nom, date, lieu, capacite, "default", "default");
            registerConcert(concert);
            // ✅ Boîte de dialogue de succès
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Événement créé avec succès !");
            successAlert.showAndWait();

            // ✅ Fermer la fenêtre après confirmation
            ((Stage) tfNom.getScene().getWindow()).close();

        } else if (type.equals("Conférence")) {
            System.out.println("Création d’une Conférence : " + nom);
            // Création d’une Conférence ici
        } else {
            showAlert("Type d’événement inconnu.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void registerConcert(Concert concert)throws Exception {
        ConcertSerialisation ser= new ConcertSerialisation();
        ser.addConcert(concert);

    }

}
