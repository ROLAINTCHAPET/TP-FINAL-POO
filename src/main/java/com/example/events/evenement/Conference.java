package com.example.events.evenement;

import com.example.events.Intervenant;
import com.example.events.SystemedeNotification;

import java.util.List;

public class Conference extends Evenement {

    public String theme;
    public List<Intervenant> intervenants ;

        public Conference(String id, String nom, String lieu, int capaciteMax,String theme, List<Intervenant> intervenants) {
            super(id, nom, lieu, capaciteMax);
            this.theme = theme;
        this.intervenants = intervenants;
    }


    public List<Intervenant> getIntervenants() {
        return intervenants;
    }

    public void setIntervenants(List<Intervenant> intervenants) {
        this.intervenants = intervenants;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    @Override
    public void ajouterParticipant() {

    }

    @Override
    public void annuler() {
        SystemedeNotification systeme = new SystemedeNotification();
        // systeme.envoyerNotification();

    }

    @Override
    public void afficherDetails() {

    }
}
