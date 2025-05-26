package com.example.events;

import com.example.events.evenement.Concert;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.events.jsonmanipulation.ConcertSerialisation;

public class test extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ConcertSerialisation ser= new ConcertSerialisation();
        Concert concert = new Concert("MK", "minks","Douala", 150, "MINKS", "RAP");
        ser.addConcert(concert);
    }
}
