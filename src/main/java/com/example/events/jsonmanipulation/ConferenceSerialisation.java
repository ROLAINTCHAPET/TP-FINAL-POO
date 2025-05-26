package com.example.events.jsonmanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.events.evenement.Conference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.example.events.evenement.Concert;

public class ConferenceSerialisation {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    private String filePath = "/home/ghost/Downloads/events/conference.json";
    File file = new File(filePath) ;
    public ConferenceSerialisation() {
        // Créer le fichier s'il n'existe pas
        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
                // Écrire un tableau vide si le fichier est nouveau
                objectMapper.writeValue(file, new Conference[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ajouter une conference au fichier
    public void addConference(Conference conference) throws IOException {
        List<Conference> conferencelist = getAllConference();
        conferencelist.add(conference);
        saveAllConference(conferencelist);
    }


    // Obtenir tous les concert du fichier
    public List<Conference> getAllConference() throws IOException {
        Conference[] personnesArray = objectMapper.readValue(file, Conference[].class);
        return new ArrayList<>(Arrays.asList(personnesArray));
    }

    // Sauvegarder toutes les conferences dans le fichier
    public void saveAllConference(List<Conference> conferencelist) throws IOException {
        objectMapper.writeValue(file, conferencelist);
    }

    // Mettre à jour une personne
    public void updateConference(Conference updatedConference) throws IOException {
        List<Conference> conferences = getAllConference();
        conferences.removeIf(p -> p.getId().equals(updatedConference.getId()));
        conferences.add(updatedConference);
        saveAllConference(conferences);
    }

    // Supprimer une conference
    public void deleteConference(Conference conference) throws IOException {
        List<Conference> conferenceList = getAllConference();

        if (conferenceList.contains(conference)){
            conferenceList.remove(conference);
            saveAllConference(conferenceList);
        }
    }
}

