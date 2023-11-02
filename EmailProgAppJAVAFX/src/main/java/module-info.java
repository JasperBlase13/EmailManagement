module com.example.emailprogappjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emailprogappjavafx to javafx.fxml;
    exports com.example.emailprogappjavafx;
}