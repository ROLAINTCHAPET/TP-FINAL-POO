package com.example.events.jsonmanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.events.evenement.Conference;
import com.example.events.personnes.Organisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.scene.control.Alert;

public class OrganisateurSerialisation {
    public static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    public String filePath = "/home/ghost/Downloads/events/Organisateur.json";
    public File file = new File(filePath) ;
    public OrganisateurSerialisation() {
        // Créer le fichier s'il n'existe pas
        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
                // Écrire un tableau vide si le fichier est nouveau
                objectMapper.writeValue(file, new Organisateur[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ajouter une conference au fichier
    public void addOrganisateur(Organisateur org) throws IOException {
        List<Organisateur> orgs = getAllOrganisateur();
        orgs.add(org);
        saveAllOrganisateur(orgs);
    }


    // Obtenir tous les organisateurs du fichier
    public List<Organisateur> getAllOrganisateur() throws IOException {
        Organisateur[] personnesArray = objectMapper.readValue(file, Organisateur[].class);
        return new ArrayList<>(Arrays.asList(personnesArray));
    }

    // Sauvegarder tous les organisateurs dans le fichier
    public void saveAllOrganisateur(List<Organisateur> orgs) throws IOException {
        objectMapper.writeValue(file, orgs);
    }

    // Mettre à jour une personne
    public void updateOrganisateur(Organisateur updatedOrganisateur) throws IOException {
        List<Organisateur> orgs = getAllOrganisateur();
        orgs.removeIf(p -> p.getId().equals(updatedOrganisateur.getId()));
        orgs.add(updatedOrganisateur);
        saveAllOrganisateur(orgs);
    }

    // Supprimer un organisateur
    public void deleteOrganisateur(Organisateur organisateur) throws IOException {
        List<Organisateur> orgs = getAllOrganisateur();

        if (orgs.contains(organisateur)){
            orgs.remove(orgs);
            saveAllOrganisateur(orgs);
        }
    }

    public Organisateur rechercherParMotDePasse(String motDePasse) {
        try {
            List<Organisateur> organisateurs = getAllOrganisateur();
            for (Organisateur org : organisateurs) {
                if (org.getMotDePasse().equals(motDePasse)) {
                    return org;
                }
            }

            // Si aucun mot de passe ne correspond
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText(null);
            alert.setContentText("Aucun organisateur trouvé avec ce mot de passe. Vous n'avez Certainement pas de compte, creez en un");
            alert.showAndWait();
            return null;

        } catch (IOException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de lecture");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de lire les données des organisateurs.");
            alert.showAndWait();
            return null;
        }
    }
}
