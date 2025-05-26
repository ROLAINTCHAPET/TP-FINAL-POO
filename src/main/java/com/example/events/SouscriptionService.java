

package com.example.events;


import com.example.events.personnes.Participant;

public interface SouscriptionService {
    void souscrire(Participant participant);
    void desouscrire(Participant participant);
}
