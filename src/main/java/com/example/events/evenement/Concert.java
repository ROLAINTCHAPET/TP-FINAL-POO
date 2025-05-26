
package com.example.events.evenement;

public class Concert extends Evenement {

    public String artiste;
    public String genreMusical;

    public Concert() {
        super();
    }

    public Concert(String id, String nom, String lieu, int capaciteMax,String artiste, String genreMusical) {
        super(id, nom, lieu, capaciteMax);
        this.artiste = artiste;
        this.genreMusical = genreMusical;

    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getGenreMusical() {
        return genreMusical;
    }

    public void setGenreMusical(String genreMusical) {
        this.genreMusical = genreMusical;
    }



    @Override
    public void ajouterParticipant() {

    }

    @Override
    public void annuler() {

    }

    @Override
    public void afficherDetails() {

    }
}
