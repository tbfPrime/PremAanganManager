/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package premaanganmanager.base.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class Login implements Initializable{    
    private Labels o_Label;
    private UIControl o_UIControl;
    private Scene o_LoginScene;
    
    @FXML
    private Text o_LoginTitle, o_Login;
    
    @FXML
    private Button o_Guest, o_Admin;
    
    // Constructor to Login Scene. Takes UIControl object as param.    
    public Login(){
        
    }
    public Login(UIControl o_UIControl) {
        System.out.println("login() with params constructed.");
        this.o_UIControl = o_UIControl;
        createLoginScene();
    }
    
    public void guestLogin(ActionEvent event){
    }
    
    // Creates and returns the Login Scene.
    public void createLoginScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Login.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            o_LoginScene = new Scene(root);
//            o_LoginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | Login | createLoginScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Scene getLoginScene(){
        try{
            if(o_LoginScene != null){ return o_LoginScene; }
            else{ System.out.println("Login scene is not initialized."); return null; }
        } catch(Exception e){
            System.out.println("Login scene is not initialized | " + e);
            return null;
        }
    }
    
    @Override
    public void initialize(URL location,ResourceBundle resources){
        setLoginLabels();
    }
    
    private void setLoginLabels(){
        o_Label = this.o_UIControl.getLabelsReference();
        
        o_LoginTitle.setText(o_Label.getLabel(Labels.labelTag.LOGINTITLE));
        o_Login.setText(o_Label.getLabel(Labels.labelTag.LOGIN));
        o_Guest.setText(o_Label.getLabel(Labels.labelTag.GUEST));
        o_Admin.setText(o_Label.getLabel(Labels.labelTag.ADMIN));
    }
}
