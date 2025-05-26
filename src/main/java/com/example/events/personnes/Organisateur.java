

package com.example.events.personnes;


import com.example.events.evenement.Evenement;

import java.util.List;

public class Organisateur extends Participant {

    public String motDePasse;
    public List<Evenement> evenementsOrganises;

    public List<Evenement> getEvenementsOrganises() {
        return evenementsOrganises;
    }

    public void setEvenementsOrganises(List<Evenement> evenementsOrganises) {
        this.evenementsOrganises = evenementsOrganises;
    }
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Organisateur(){
        super();
    }

    public Organisateur(String id, String nom, String email, String motDePasse) {
        super(id, nom, email);
        setMotDePasse(motDePasse);
    }


    public void ajouterEvenementOrganisé(Evenement e){
        this.evenementsOrganises.add(e);
            }

    public void supprimerEvenementOrganise(Evenement e) {
        this.evenementsOrganises.remove(e);
    }
}