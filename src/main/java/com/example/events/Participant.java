
package com.example.events;

//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;

public class Participant implements ParticipantObserver{
    public String id;
    public String nom;
    public String email;

    //@JsonCreator
    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //@Override
            // public void miseAJour(String message, Evenement evenement) {
        //System.out.println("Notification pour " + nom + ": " + message);
        // Simulation d'envoi d'email
    //envoyerNotification(message, evenement);
    // }
}
