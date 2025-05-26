
package com.example.events.evenement;

import com.example.events.personnes.Participant;


import java.util.List;
import java.time.LocalDateTime;


public abstract class Evenement {

        public String id;
        public String nom;
        public LocalDateTime date;
        public String lieu;
        public int capaciteMax;
        protected List<Participant> participants;


    public Evenement() {
        // Obligatoire pour Jackson
    }

    public Evenement(String id, String nom, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }


    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

        public int getCapaciteMax() {
            return capaciteMax;
        }

        public void setCapaciteMax(int capaciteMax) {
            this.capaciteMax = capaciteMax;
        }

        public String getLieu() {
            return lieu;
        }

        public void setLieu(String lieu) {
            this.lieu = lieu;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



    public abstract void ajouterParticipant();
    public abstract void annuler();
    public abstract void afficherDetails();


}
