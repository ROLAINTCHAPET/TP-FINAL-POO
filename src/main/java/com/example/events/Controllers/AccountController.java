package com.example.events.Controllers;

import com.example.events.jsonmanipulation.OrganisateurSerialisation;
import com.example.events.personnes.Organisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import com.example.events.evenement.Concert;
import com.example.events.evenement.Conference;
import com.example.events.jsonmanipulation.ConferenceSerialisation;
import com.example.events.personnes.Intervenant;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.ConcertSerialisation;

import java.util.ArrayList;

public class AccountController{

    @FXML
    private TextField passwd;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNom;

    @FXML
    public void enregistrerOrganisateur() throws Exception{
        System.out.println("test");
        String nom = tfNom.getText();
        String email = tfEmail.getText();
        String motDePasse = passwd.getText();

        if (motDePasse == null || motDePasse.trim().isEmpty()) {
            // Affiche une boîte de dialogue d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le mot de passe est obligatoire !");
            alert.showAndWait();
            return;
        }


        System.out.println("Nom : " + nom);
        System.out.println("Email : " + email);
        System.out.println("Mot de passe : " + motDePasse);
        Organisateur organisateur = new Organisateur(nom,nom,email,motDePasse);
        registerOrganisateurinjson(organisateur);

    }
    public void registerOrganisateurinjson(Organisateur organisateur)throws Exception {
        OrganisateurSerialisation ser= new OrganisateurSerialisation();
        ser.addOrganisateur(organisateur);

    }
}
