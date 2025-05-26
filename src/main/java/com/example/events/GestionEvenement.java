/*package com.example.events;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Collectors;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GestionEvenement {
    private static volatile GestionEvenements instance;
    private final Map<String, Evenement> evenements;
    private final ObjectMapper objectMapper;

    // private GestionEvenements() {
    // this.evenements = new HashMap<>();
        this.objectMapper = new ObjectMapper();
        //this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public GestionEvenement(Map<String, Evenement> evenements, ObjectMapper objectMapper) {
        this.evenements = evenements;
        this.objectMapper = objectMapper;
    }

    public static GestionEvenements getInstance() {
        if (instance == null) {
            synchronized (GestionEvenements.class) {
                if (instance == null) {
                    instance = new GestionEvenements();
                }
            }
        }
        return instance;
    }

    public void ajouterEvenement(Evenement evenement) throws EvenementDejaExistantException {
        if (evenements.containsKey(evenement.getId())) {
            throw new EvenementDejaExistantException("Événement avec l'ID " + evenement.getId() + " existe déjà");
        }
        evenements.put(evenement.getId(), evenement);
        System.out.println("Événement ajouté: " + evenement.getNom());
    }

    public boolean supprimerEvenement(String id) {
        Evenement evenement = evenements.remove(id);
        if (evenement != null) {
            evenement.annuler();
            System.out.println("Événement supprimé: " + evenement.getNom());
            return true;
        }
        return false;
    }

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    public List<Evenement> obtenirTousEvenements() {
        return new ArrayList<>(evenements.values());
    }

    public List<Evenement> rechercherParNom(String nom) {
        return evenements.values().stream()
                .filter(e -> e.getNom().toLowerCase().contains(nom.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Evenement> rechercherParLieu(String lieu) {
        return evenements.values().stream()
                .filter(e -> e.getLieu().toLowerCase().contains(lieu.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Sérialisation JSON
    public void sauvegarderJSON(String fichier) throws IOException {
        List<Evenement> listeEvenements = new ArrayList<>(evenements.values());
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fichier), listeEvenements);
        System.out.println("Événements sauvegardés en JSON: " + fichier);
    }

    public void chargerJSON(String fichier) throws IOException {
        File file = new File(fichier);
        if (file.exists()) {
            List<Evenement> listeEvenements = objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Evenement.class));

            evenements.clear();
            for (Evenement evenement : listeEvenements) {
                evenements.put(evenement.getId(), evenement);
            }
            System.out.println("Événements chargés depuis JSON: " + fichier);
        }
    }

    // Méthodes avec Streams et Lambdas
    public List<Evenement> filtrerEvenements(java.util.function.Predicate<Evenement> predicate) {
        return evenements.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, Long> statistiquesParType() {
        return evenements.values().stream()
                .collect(Collectors.groupingBy(
                        e -> e.getClass().getSimpleName(),
                        Collectors.counting()
                ));
    }

    public double moyenneParticipants() {
        return evenements.values().stream()
                .mapToInt(e -> e.getParticipants().size())
                .average()
                .orElse(0.0);
    }
}*/
