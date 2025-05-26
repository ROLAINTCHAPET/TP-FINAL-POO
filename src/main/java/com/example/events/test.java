package com.example.events;

import com.example.events.evenement.Concert;
import com.example.events.evenement.Conference;
import com.example.events.jsonmanipulation.ConferenceSerialisation;
import com.example.events.personnes.Intervenant;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.ConcertSerialisation;

import java.util.ArrayList;

public class test extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ConcertSerialisation ser= new ConcertSerialisation();
        ConferenceSerialisation conf= new ConferenceSerialisation();

        Concert concert = new Concert("MK", "minks","Douala", 150, "MINKS", "RAP");
        ser.addConcert(concert);

        ArrayList<String> intervenants = new ArrayList<String>();
        intervenants.add("TCHAPET");
        Conference conference = new Conference("conference", "AI CONF ","Douala", 150, "IA", intervenants);
        conf.addConference(conference);
    }
}
