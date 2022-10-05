/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import models.Domain;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Person;

/**
 *
 * @author USER
 */
public class DomainStage extends Stage{

    private Person person;
    
    public DomainStage(){}
    
    public DomainStage(Person person) {
        this.person = person;

    }
 
  
    public void init() throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("DomainStage.fxml"));
        initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
                
        setTitle("Domain");
        setScene(scene);
        show();
    }
}
