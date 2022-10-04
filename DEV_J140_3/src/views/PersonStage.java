/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import repositories.Repository;
import repositories.PersonRepositoryInterface;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class PersonStage extends Stage{
      
    
    private PersonRepositoryInterface personRepositoryInterface;
    
    public PersonStage(){
        personRepositoryInterface = new Repository();
        
    }
        
    public void init() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PersonStage.fxml"));
       
        Scene scene = new Scene(root);
                
        setTitle("Persons");
        setScene(scene);
        show();
    }
}
