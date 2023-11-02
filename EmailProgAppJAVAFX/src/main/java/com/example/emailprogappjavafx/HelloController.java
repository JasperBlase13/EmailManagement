package com.example.emailprogappjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button creatBTN;

    @FXML
    private BorderPane scenePane;

    @FXML
    private TextField tx1;

    @FXML
    private PasswordField tx2;

    Stage stage;

    //NonFXML variables

   private String username = "Jasper.Blase";
    private String password = "LoveJesus13";

    String getText1, getText2;

    @FXML
    public void showATTerminal(ActionEvent event) throws IOException {

        getText1 = tx1.getText();
        getText2 = tx2.getText();


        if(getText1.equals(username) && getText2.equals(password))
        {
            Stage stage2 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateEmail.fxml" ));
            Scene scene2 = new Scene(fxmlLoader.load());
            stage2.setTitle("Email Creation and Management App");
            stage2.setScene(scene2);
            stage2.show();
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();

        }

        else
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("WRONG EMAIL OR PASSWORD!");
            error.show();
        }





    }




}