package com.example.events.jsonmanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.example.events.evenement.Concert;

public class ConcertSerialisation {

        private static final ObjectMapper objectMapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        private String filePath = "/home/ghost/Downloads/events/events.json";

        public ConcertSerialisation() {
            // Créer le fichier s'il n'existe pas
            try {
                if (!Files.exists(Paths.get(filePath))) {
                    Files.createFile(Paths.get(filePath));
                    // Écrire un tableau vide si le fichier est nouveau
                    objectMapper.writeValue(new File(filePath), new Concert[0]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Ajouter un concert au fichier
        public void addConcert(Concert concert) throws IOException {
            List<Concert> concerts = getAllConcerts();
            concerts.add(concert);
            saveAllConcerts(concerts);
        }


        // Obtenir tous les concert du fichier
        public List<Concert> getAllConcerts() throws IOException {
            Concert[] personnesArray = objectMapper.readValue(new File(filePath), Concert[].class);
            return new ArrayList<>(Arrays.asList(personnesArray));
        }

        // Sauvegarder toutes les conferences dans le fichier
        public void saveAllConcerts(List<Concert> concerts) throws IOException {
            objectMapper.writeValue(new File(filePath), concerts);
        }

        // Mettre à jour une personne
        public void updateConcert(Concert updatedConcert) throws IOException {
            List<Concert> concerts = getAllConcerts();
            concerts.removeIf(p -> p.getId().equals(updatedConcert.getId()));
            concerts.add(updatedConcert);
            saveAllConcerts(concerts);
        }

        // Supprimer une conference
        public void deleteConcert(Concert concert) throws IOException {
            List<Concert> concerts = getAllConcerts();

            if (concerts.contains(concert)){
                concerts.remove(concert);
                saveAllConcerts(concerts);
            }
        }
    }

