/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.User;
import repositories.Repository;
import views.PersonStage;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label labelWelcom;
    @FXML
    private Label labelUserName;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private Label labelPassword;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button btn;
    @FXML
    private HBox addbutton;
    @FXML
    private Text actionText;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelWelcom.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        
        btn.setOnAction(ActionEvent -> {
            List<User> users = new Repository().getUsers();
            for (User user : users) {
                if (textFieldUserName.getText().equals(user.getUserName())
                        && passwordField.getText().equals(user.getPassword())) {
                    try {
                        new PersonStage().init();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    actionText.setFill(Color.RED);
                    actionText.setText("Пароль или логин не верный");
                }
            }
        });
    }    
    
}
