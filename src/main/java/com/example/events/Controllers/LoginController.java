package com.example.events.Controllers;

import com.example.events.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.OrganisateurSerialisation;
import com.example.events.personnes.Organisateur;

import com.example.events.evenement.Concert;
import com.example.events.evenement.Conference;
import com.example.events.jsonmanipulation.ConferenceSerialisation;
import com.example.events.personnes.Intervenant;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.ConcertSerialisation;

import java.util.ArrayList;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField mdp;
    @FXML
    void OpenAccueil(ActionEvent event) throws IOException {
            OrganisateurSerialisation ser = new OrganisateurSerialisation();
            Organisateur organisateur  = ser.rechercherParMotDePasse(mdp.getText());
            if (organisateur!= null){
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("events-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900,900);
                stage.setTitle("Gestion d'evenements");
                stage.setScene(scene);
                stage.show();
            }
    }

    @FXML
    void CreateAccount(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("account.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900,900);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }



    }




