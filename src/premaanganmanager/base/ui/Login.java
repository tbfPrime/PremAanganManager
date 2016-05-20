/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package premaanganmanager.base.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class Login{    
    private UIControl uiControl;
    private Scene loginScene;
    
    private String admin1Username = "admin1";
    private String admin2Username = "admin2";
    private String admin3Username = "admin3";
    
    private String username;
    private String password;
    
    private enum adminTag{ ADMIN1, ADMIN2, ADMIN3 }
    
    @FXML
    private Text o_LoginTitle, o_LoginSubtitle, o_Key;
    
    @FXML
    private Button o_Guest, o_Admin, o_Admin1, o_Admin2, o_Admin3, o_Back, o_Login;
    
    @FXML
    private PasswordField o_PasswordField;
    
    // Constructor to Login Scene. Takes UIControl object as param.
    public Login(UIControl uiControl) {
        System.out.println("login() with params constructed.");
        this.uiControl = uiControl;
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
    
    // Action on clicking Admin1 button
    public void admin1ButtonAction(){
        System.out.println("Login | admin1ButtonAction");
        selectAdminButton(adminTag.ADMIN1);
    }
    
    // Action on clicking Admin2 button
    public void admin2ButtonAction(){
        System.out.println("Login | admin2ButtonAction");
        selectAdminButton(adminTag.ADMIN2);
    }
    
    // Action on clicking Admin3 button
    public void admin3ButtonAction(){
        System.out.println("Login | admin3ButtonAction");
        selectAdminButton(adminTag.ADMIN3);
    }
 
    // Action on clicking Back button on Admin only screen
    public void backButtonAction(){
        System.out.println("Login | backButtonAction");
        displayLoginGuestAdminScene();
    }
    
    // Action on clicking Login button on Admin only screen
    public void loginButtonAction(){
        System.out.println("Login | loginButtonAction");
        if(verifyLogin()){ uiControl.setAppContainer(); };
    }
                
    // Creates  and returns the Login Scene with Guest and Admin buttons.
    public Scene setLoginGuestAdminScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/LoginGuestAdmin.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            loginScene = new Scene(root);
            setLoginGuestAdminLabels();
            return loginScene;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
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
            loginScene = new Scene(root);
            setLoginAdminOnlyLabels();
            return loginScene;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | Login | createLoginScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private functions    
    private void setLoginGuestAdminLabels(){
        o_LoginTitle.setText(uiControl.settings.labels.getLabel(Labels.labelTag.LOGINTITLE));
        o_LoginSubtitle.setText(uiControl.settings.labels.getLabel(Labels.labelTag.LOGINSUBTITLE));
        o_Guest.setText(uiControl.settings.labels.getLabel(Labels.labelTag.GUEST));
        o_Admin.setText(uiControl.settings.labels.getLabel(Labels.labelTag.ADMIN));
    }
    
    private void setLoginAdminOnlyLabels(){
        o_LoginTitle.setText(uiControl.settings.labels.getLabel(Labels.labelTag.LOGINTITLE));
        o_LoginSubtitle.setText(uiControl.settings.labels.getLabel(Labels.labelTag.LOGINSUBTITLE));
        o_Admin1.setText(uiControl.settings.labels.getLabel(Labels.labelTag.ADMIN1));
        o_Admin2.setText(uiControl.settings.labels.getLabel(Labels.labelTag.ADMIN2));
        o_Admin3.setText(uiControl.settings.labels.getLabel(Labels.labelTag.ADMIN3));
        o_Key.setText(uiControl.settings.labels.getLabel(Labels.labelTag.KEY));
        o_PasswordField.setPromptText(uiControl.settings.labels.getLabel(Labels.labelTag.PASSWORDPROMPT));
        o_Back.setText(uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
        o_Login.setText(uiControl.settings.labels.getLabel(Labels.labelTag.LOGIN));
    }
    
    private void displayLoginAdminOnlyScene(){
        uiControl.setLoginAdminOnlyScene();
    }
    
    private void displayLoginGuestAdminScene(){
        uiControl.setLoginGuestAdminScene();
    }
    
    private void selectAdminButton(adminTag tag){
        String defaultColor = "#000000";
        String selectedColor = "red";
        
        o_Admin1.setTextFill(Paint.valueOf(defaultColor));
        o_Admin2.setTextFill(Paint.valueOf(defaultColor));
        o_Admin3.setTextFill(Paint.valueOf(defaultColor));
        
        switch(tag){
            case ADMIN1: o_Admin1.setTextFill(Paint.valueOf(selectedColor)); username = admin1Username; break;
            case ADMIN2: o_Admin2.setTextFill(Paint.valueOf(selectedColor)); username = admin2Username; break;
            case ADMIN3: o_Admin3.setTextFill(Paint.valueOf(selectedColor)); username = admin3Username; break;
        }
    }
    
    private boolean verifyLogin(){
        System.out.println("Login | verifyLogin");
        password = o_PasswordField.getText();
        if(password.length() == 0){ System.out.println("No Password entered. Exiting."); return false; }
        try { return uiControl.uiModel.isLoginCorrect(username, password); }
        catch (SQLException ex) { Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex); return false; }
    }
}
