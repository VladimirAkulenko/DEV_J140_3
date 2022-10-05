/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import models.Domain;
import repositories.PersonRepositoryInterface;
import repositories.Repository;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Person;



/**
 *
 * @author vlaaku
 */
public class PersonStageController implements Initializable {
    @FXML
    private TableView<PersonTable> table;
    @FXML
    private TableColumn<PersonTable, Integer> idColumn;
    @FXML
    private TableColumn<PersonTable, String> jobtitleColumn;
    @FXML
    private TableColumn<PersonTable, String> firstnamelastnameColumn;
    @FXML
    private TableColumn<PersonTable, String> phoneColumn;
    @FXML
    private TableColumn<PersonTable, String> emailColumn;
    @FXML
    private TableColumn<PersonTable, Integer> numberofdomainsColumn;
    
    public static Person person;
    private PersonRepositoryInterface personRepositoryInterface;

     
    
    public PersonStageController (){
        personRepositoryInterface = new Repository();
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ObservableList<PersonTable> observableList = FXCollections.observableArrayList();
         personRepositoryInterface.getPersons().forEach(person -> {
            List<Domain> domainListOfPerson = new Repository().getDomainByPerson(person);
           
            int numberOfDomain = personRepositoryInterface.getDomainByPerson(person).size();
            observableList.add(new PersonTable(person.getId(), 
                    person.getJobtitle(), 
                    person.getFirstnamelastname(), 
                    person.getPhone(), 
                    person.getEmail(), 
                    numberOfDomain));
        });
        
        
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobtitle"));
        
        firstnamelastnameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstnamelastname"));
        
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        
        numberofdomainsColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("numberofdomains"));
        
        table.setItems(observableList);
        
        table.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                try {
                    person = personRepositoryInterface.getPersonById(table.getSelectionModel().getSelectedItem().getId());
                    new DomainStage().init();
                } catch (IOException ex) {
                    Logger.getLogger(PersonStageController.class.getName()).log(Level.SEVERE, null, ex);                  
                }
            }
    });
    }

}
