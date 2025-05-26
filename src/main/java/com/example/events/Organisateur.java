

package com.example.events;


import com.example.events.evenement.Evenement;

import java.util.List;

public class Organisateur extends Participant{

    public List<Evenement> evenementsOrganises;

    public List<Evenement> getEvenementsOrganises() {
        return evenementsOrganises;
    }

    public void setEvenementsOrganises(List<Evenement> evenementsOrganises) {
        this.evenementsOrganises = evenementsOrganises;
    }



    public Organisateur(String id, String nom, String email) {
        super(id, nom, email);
    }


    public void ajouterEvenementOrganisé(Evenement e){
        this.evenementsOrganises.add(e);
            }

    public void supprimerEvenementOrganise(Evenement e) {
        this.evenementsOrganises.remove(e);
    }
}