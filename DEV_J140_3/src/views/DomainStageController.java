/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import repositories.PersonRepositoryInterface;
import repositories.Repository;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static views.PersonStageController.person;



/**
 *
 * @author vlaaku
 */
public class DomainStageController implements Initializable {
    @FXML
    private TableView<DomainTable> table;
    @FXML
    private TableColumn<DomainTable, Integer> idColumn;
    @FXML
    private TableColumn<DomainTable, String> webnameColumn;
    @FXML
    private TableColumn<DomainTable, String> domainnameColumn;
    @FXML
    private TableColumn<DomainTable, String> ipColumn;
    @FXML
    private TableColumn<DomainTable, Timestamp> dateregColumn;
    @FXML
    private TableColumn<DomainTable, String> countryregColumn;
    
    private PersonRepositoryInterface personRepositoryInterface;
    private PersonStageController personStageController;
   
    
    public DomainStageController (){
        personRepositoryInterface = new Repository();
        personStageController = new PersonStageController();
    }
     

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         ObservableList<DomainTable> observableList = FXCollections.observableArrayList();
              
        personRepositoryInterface.getDomainByPerson(person).forEach(domain -> {     
            observableList.add(new DomainTable(
                    domain.getId(), 
                    domain.getWebname(), 
                    domain.getDomainname(), 
                    domain.getIp(), 
                    domain.getDatereg(), 
                    domain.getCountryreg()));
                    
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, Integer>("id"));              
        webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));                        
        domainnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainname"));                      
        ipColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("ip"));              
        dateregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, Timestamp>("datereg"));
        countryregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("countryreg"));
        
        table.setItems(observableList);
    }   
}
