

package com.example.events;


import java.util.ArrayList;
import java.util.List;
import com.example.events.EventManagementController;
public class SystemedeNotification implements  NotificationService{

    private final List<Participant> participants;

    public SystemedeNotification() {
        participants = new ArrayList<>();// On pourra faieeeeeeeeeeeere evoluer le code de telle enseigne qu'un partivipant puisse s'inscrire

    }

    //@Override
    //public void envoyerNotification(String message, Evenement evenement) {
    // this.participants.forEach(participant -> participant.miseajour(message,evenement));
    //EventManagementController.

    //}





}
