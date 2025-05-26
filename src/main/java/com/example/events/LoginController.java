package com.example.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNom;

    @FXML
    void OpenAccueil(ActionEvent event) throws IOException {
            if (tfNom.getText()==""){
                System.out.println("Entrez votre nom");
            }
            else{
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("events-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900,900);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
            }
    }

}

