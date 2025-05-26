package com.example.events;

public interface EventObservable {
    void ajouterObserver(ParticipantObserver observer);
    void supprimerObserver(ParticipantObserver observer);
    void notifierObservers(String message);
}
