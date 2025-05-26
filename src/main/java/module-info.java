module com.example.events {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;

    opens com.example.events to javafx.fxml;
    exports com.example.events;
    exports com.example.events.evenement;
    opens com.example.events.evenement to javafx.fxml;
}