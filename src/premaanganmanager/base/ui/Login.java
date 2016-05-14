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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.MainController;

/**
 *
 * @author Trevor Fernandes
 */
public class Login implements Initializable{    
    private MainController o_MainController;
    private UIControl o_UIControl;
    private Labels o_Label;
    private Scene o_LoginScene;
    
    @FXML
    private Text o_LoginTitle, o_Login, o_Key;
    
    @FXML
    private Button o_Guest, o_Admin, o_Admin1, o_Admin2, o_Admin3;
    
    @FXML
    private PasswordField o_PasswordField;
    
    // Constructor to Login Scene. Takes UIControl object as param.
    public Login(UIControl o_UIControl) {
        System.out.println("login() with params constructed.");
        this.o_UIControl = o_UIControl;
        o_MainController = o_UIControl.getMainControllerRef();
        setLabelReference();
    }
    
    @Override
    public void initialize(URL location,ResourceBundle resources){
//        setLoginLabels();
    }
        
    // Creates  and returns the Login Scene with Guest and Admin buttons.
    public Scene setLoginGuestAdminScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/LoginGuestAdmin.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            o_LoginScene = new Scene(root);
            setLoginGuestAdminLabels();
            return o_LoginScene;
//            o_LoginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | Login | createLoginScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Creates  and returns the Login Scene with Admin only buttons.
    public Scene setLoginAdminOnlyScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/LoginAdminOnly.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            o_LoginScene = new Scene(root);
            setLoginAdminOnlyLabels();
            return o_LoginScene;
//            o_LoginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | Login | createLoginScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Action on clicking Guest button
    public void guestButtonAction(){
        System.out.println("Login | guestButtonAction");
    }
    
    // Action on clicking Admin button
    public void adminButtonAction(){
        System.out.println("Login | adminButtonAction");
        displayLoginAdminOnlyScene();
    }
 
    
    // Private functions
    private void setLabelReference(){ o_Label = this.o_UIControl.getLabelsReference(); }
    
    private void setLoginGuestAdminLabels(){
        o_LoginTitle.setText(o_Label.getLabel(Labels.labelTag.LOGINTITLE));
        o_Login.setText(o_Label.getLabel(Labels.labelTag.LOGIN));
        o_Guest.setText(o_Label.getLabel(Labels.labelTag.GUEST));
        o_Admin.setText(o_Label.getLabel(Labels.labelTag.ADMIN));
    }
    
    private void setLoginAdminOnlyLabels(){
        o_LoginTitle.setText(o_Label.getLabel(Labels.labelTag.LOGINTITLE));
        o_Login.setText(o_Label.getLabel(Labels.labelTag.LOGIN));
        o_Admin1.setText(o_Label.getLabel(Labels.labelTag.ADMIN1));
        o_Admin2.setText(o_Label.getLabel(Labels.labelTag.ADMIN2));
        o_Admin3.setText(o_Label.getLabel(Labels.labelTag.ADMIN3));
        o_Key.setText(o_Label.getLabel(Labels.labelTag.KEY));
        o_PasswordField.setPromptText(o_Label.getLabel(Labels.labelTag.PASSWORDPROMPT));
    }
    
    private void displayLoginAdminOnlyScene(){
        o_MainController.setLoginAdminOnlyScene();
    }
}
