module com.example.events {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;

    opens com.example.events to javafx.fxml;
    exports com.example.events;
    exports com.example.events.evenement;
    opens com.example.events.evenement to javafx.fxml;
    exports com.example.events.personnes;
    opens com.example.events.personnes to javafx.fxml;
    exports com.example.events.Controllers;
    opens com.example.events.Controllers to javafx.fxml;
}