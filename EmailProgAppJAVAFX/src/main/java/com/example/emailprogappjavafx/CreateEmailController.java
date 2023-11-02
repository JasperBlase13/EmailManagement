package com.example.emailprogappjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CreateEmailController implements Initializable {


    @FXML
    private BorderPane scenepane;
    private Stage stage;
    @FXML
    private Label label1;


    @FXML
    private TextField tx1;

    @FXML
    private TextField tx2;

    @FXML
    private ChoiceBox<String> Department;


    @FXML
    private TableView<Email> EmailTable;

    @FXML
    private TableColumn<Email, String> ID;

    @FXML
    private TableColumn<Email, String> FirstName;
    @FXML
    private TableColumn<Email, String> LastName;
    @FXML
    private TableColumn<Email, String> Department1;
    @FXML
    private TableColumn<Email, String> Email1;

    @FXML
    private TableColumn<Email, String> Password;




    //Variables for java itself.

    String[] DepartmentChoice = {"Sales", "Development", "Accounting"};
    String departmentChoice = " ";



   // EmailObjectInitializer em = new EmailObjectInitializer();





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Email.resetMailCapacity();

        ID.setCellValueFactory(new PropertyValueFactory<Email, String>("ID"));
        FirstName.setCellValueFactory(new PropertyValueFactory<Email, String>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<Email, String>("LastName"));
        Department1.setCellValueFactory(new PropertyValueFactory<Email, String>("department"));
        Email1.setCellValueFactory(new PropertyValueFactory<Email, String>("email"));
        Password.setCellValueFactory(new PropertyValueFactory<Email, String>("password"));


        Department.getItems().addAll(DepartmentChoice);
        Department.setOnAction(this::ChooseDepartment);
        label1.setText(" ");
        SetData();
    }

    private void SetData()
    {
        ID.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        ID.setOnEditCommit(event -> {
           Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
           email.setID(event.getNewValue());

        });

        FirstName.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        FirstName.setOnEditCommit(event -> {
            Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
            email.setFirstName(event.getNewValue());

        });

        LastName.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        LastName.setOnEditCommit(event -> {
            Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
            email.setLastName(event.getNewValue());

        });

        Department1.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        Department1.setOnEditCommit(event -> {
            Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
            email.setDepartment(event.getNewValue());

        });
        Email1.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        Email1.setOnEditCommit(event -> {
            Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
            email.setEmail(event.getNewValue());

        });

        Password.setCellFactory(TextFieldTableCell.<Email>forTableColumn());
        Password.setOnEditCommit(event -> {
            Email email = event.getTableView().getItems().get(event.getTablePosition().getRow());
            email.setPassword(event.getNewValue());

        });

    }



    @FXML
    public void deleteData(ActionEvent event){

        TableView.TableViewSelectionModel<Email> selectionModel = EmailTable.getSelectionModel();
        if(selectionModel.isEmpty())
        {
            System.out.println("You have not selected a data to delete");
        }

        ObservableList<Integer> List = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[List.size()];
        selectedIndices = List.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length -1; i >=0; i--)
        {
            selectionModel.clearSelection(selectedIndices[i].intValue());
            EmailTable.getItems().remove(selectedIndices[i].intValue());
        }
    }




    @FXML
    public void ChooseDepartment(ActionEvent event)
    {
        departmentChoice = Department.getValue();
    }

    public void ClearDepartment()
    {
        Department.setValue(" ");
    }



    @FXML
    public void checkFnameLname(ActionEvent event)
    {
        boolean contains1;
        boolean contains2;
        String fname =tx1.getText();
        String lname = tx2.getText();
        contains1 = Checkfnamelname(fname);
        contains2 = Checkfnamelname(lname);

        if(contains1 && contains2 && (departmentChoice.contains("Sales")|| departmentChoice.contains("Accounting") || departmentChoice.contains("Development")))
        {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("You are about to add another email");
            alert.setContentText("First Name: " + fname + " \n" + "Last Name: " + lname + " \n" + "Department: " + departmentChoice);


            if(alert.showAndWait().get() == ButtonType.OK)
            {
                int check = Email.EmailAccountsCheck();
                if(check < 4) {
                    tx1.setText(" ");
                    tx2.setText(" ");
                    label1.setText("Email Added!");
                    Email newEmail = new Email(fname, lname, departmentChoice);
                    EmailTable.getItems().add(newEmail);
                    ClearDepartment();
                    if(check == 3)
                    {
                        Alert alert2 = new Alert(Alert.AlertType.WARNING);
                        alert2.setTitle("Warning");
                        alert2.setHeaderText("Capacity Reached. Delete Emails");
                        alert2.show();
                    }

                }
                else
                {
                    label1.setText("Email Capacity Reached");
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Error");
                    alert2.setHeaderText("Capacity Reached. Delete Emails");
                    alert2.show();
                }

            }

        }
        else{
            label1.setText("Invalid.");
        }

    }

    @FXML
    public void cancelButton(ActionEvent event) throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainWindow.fxml" ));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage2.setTitle("Email Creation and Management App");
        stage2.setScene(scene2);
        stage2.show();


        stage = (Stage) scenepane.getScene().getWindow();
        stage.close();
    }


    boolean Checkfnamelname (String name)
    {
        boolean DoesNotContain = true;
        boolean isCorrect = true;
        boolean isContain = false;
        boolean noInput = false;



        while(isCorrect)
        {

            char[] checkStr1 = name.toCharArray();

            if(checkStr1.length < 1)
            {
                noInput = true;
            }
            else
            {
                for(char c : checkStr1)
                {
                    if (Character.isDigit(c))
                    {
                        isContain = true;
                    }
                }
            }


            if(noInput)
            {
                System.out.println("No input");
                System.out.println("Enter Again: ");
                DoesNotContain = false;
                isCorrect = false;
            }
            else if(isContain)
            {
                System.out.println("No input");
                System.out.println("Enter Again: ");
                DoesNotContain = false;
                isCorrect = false;
            }

            else
            {
                System.out.println("Name meets requiremnts");
                DoesNotContain = true;
                isCorrect = false;
            }
        }
        return DoesNotContain;
    }






}
