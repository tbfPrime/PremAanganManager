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
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.UIControl;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class P_Login{    
    private UIControl uiControl;
    private Scene loginScene;
    
    private String admin1Username = "admin1";
    private String admin2Username = "admin2";
    private String admin3Username = "admin3";
    
    private String username;
    private String password;
    
    private enum adminTag{ ADMIN1, ADMIN2, ADMIN3 }
    
    @FXML
    private Text loginTitleText, loginSubtitle1Text, loginSubtitle2Text; //, passwordLabelText;
    
    @FXML
    private Button guestButton, adminButton, backButton, loginButton;
    
    @FXML
    private ToggleButton admin1Button, admin2Button, admin3Button;
    
    @FXML
    private PasswordField passwordField;
    
    // Constructor to P_Login Scene. Takes UIControl object as param.
    public P_Login(UIControl uiControl) {
        Utility.log("login() with params constructed.");
        this.uiControl = uiControl;
    }
    
    // Action on clicking Guest button
    @FXML
    public void guestButtonAction(){
        Utility.log("Login | guestButtonAction");
        String temp = "Student: ? saved successfully!";
        
        Utility.log("Show >> " + temp.replace("?", "Sushil Kumar Pandey"));
        loginAsGuest();
    }
    
    // Action on clicking Admin button
    @FXML
    public void adminButtonAction(){
        Utility.log("Login | adminButtonAction");
        displayLoginAdminOnlyScene();
    }
    
    // Action on clicking Admin1 button
    @FXML
    public void admin1ButtonAction(){
        Utility.log("Login | admin1ButtonAction");
        selectAdminButton(adminTag.ADMIN1);
    }
    
    // Action on clicking Admin2 button
    @FXML
    public void admin2ButtonAction(){
        Utility.log("Login | admin2ButtonAction");
        selectAdminButton(adminTag.ADMIN2);
    }
    
    // Action on clicking Admin3 button
    @FXML
    public void admin3ButtonAction(){
        Utility.log("Login | admin3ButtonAction");
        selectAdminButton(adminTag.ADMIN3);
    }
 
    // Action on clicking Back button on Admin only screen
    @FXML
    public void backButtonAction(){
        Utility.log("Login | backButtonAction");
        displayLoginGuestAdminScene();
    }
    
    // Action on clicking P_Login button on Admin only screen
    @FXML
    public void loginButtonAction(){
        Utility.log("Login | loginButtonAction");
        loginAction();
    }
                
    // Creates  and returns the P_Login Scene with Guest and Admin buttons.
    public Scene setLoginGuestAdminScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/LoginGuestAdmin.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            loginScene = new Scene(root, uiControl.p_settings.getAppWidth(), uiControl.p_settings.getAppHeight());
            setLoginGuestAdminData();
            return loginScene;
        } catch (IOException e) {
            Utility.log("Error | Login | createLoginScene | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Creates  and returns the P_Login Scene with Admin only buttons.
    public Scene setLoginAdminOnlyScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/LoginAdminOnly.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            loginScene = new Scene(root, uiControl.p_settings.getAppWidth(), uiControl.p_settings.getAppHeight());
            setLoginAdminOnlyData();
            return loginScene;
        } catch (IOException e) {
            Utility.log("Error | Login | createLoginScene | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private functions  
    private void setLoginGuestAdminData(){
        setLoginGuestAdminLabels();
        setLoginGuestAdminStyling();
    }
    
    private void setLoginAdminOnlyData(){
        setLoginAdminOnlyLabels();
        setLoginAdminOnlyStyling();
    }
    
    private void setLoginGuestAdminStyling(){
        Utility.log("Login | setLoginGuestAdminStyling");
        
        uiControl.setButtonStyle(guestButton);
        uiControl.setButtonStyle(adminButton);

//        admin1Button.getStylesheets().add(getClass().getResource("P_Login.css").toExternalForm());
//        admin2Button.getStylesheets().add(getClass().getResource("P_Login.css").toExternalForm());
//        admin3Button.getStylesheets().add(getClass().getResource("P_Login.css").toExternalForm());
//        
//        admin1Button.setId("AdminNormal");
//        admin2Button.setId("AdminNormal");
//        admin3Button.setId("AdminNormal");
    }
    
    private void setLoginGuestAdminLabels(){
//        loginTitleText.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.LOGIN_GUEST_ADMIN_TITLE));
//        loginSubtitle1Text.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.LOGIN_GUEST_ADMIN_SUBTITLE));
        guestButton.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.GUEST));
        adminButton.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.ADMIN));
    }
    
    
    private void setLoginAdminOnlyStyling(){
        Utility.log("Login | setLoginAdminOnlyStyling");
        
        uiControl.setToggleButtonStyle(admin1Button);
        uiControl.setToggleButtonStyle(admin2Button);
        uiControl.setToggleButtonStyle(admin3Button);
        uiControl.setButtonStyle(backButton);
        uiControl.setButtonStyle(loginButton);
    }
    
    private void setLoginAdminOnlyLabels(){
//        loginTitleText.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.LOGIN_GUEST_ADMIN_TITLE));
//        loginSubtitle2Text.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.LOGIN_ADMIN_SUBTITLE));
        admin1Button.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.ADMIN1));
        admin2Button.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.ADMIN2));
        admin3Button.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.ADMIN3));
        passwordField.setPromptText(uiControl.p_settings.labels.getLabel(Labels.labelTag.PASSWORD_PROMPT));
        backButton.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.BACK));
        loginButton.setText(uiControl.p_settings.labels.getLabel(Labels.labelTag.LOGIN));
    }
    
    private void displayLoginAdminOnlyScene(){
        uiControl.setLoginAdminOnlyScene();
    }
    
    private void displayLoginGuestAdminScene(){
        uiControl.setLoginGuestAdminScene();
    }
    
    private void selectAdminButton(adminTag tag){
        admin1Button.setSelected(false);
        admin2Button.setSelected(false);
        admin3Button.setSelected(false);
        
        admin1Button.setId("ButtonNormal");
        admin2Button.setId("ButtonNormal");
        admin3Button.setId("ButtonNormal");
        
        switch(tag){
            case ADMIN1: 
                admin1Button.setSelected(true);
                admin1Button.setId("ButtonSelected");
                username = admin1Username; 
                passwordField.setPromptText(uiControl.p_settings.labels.getLabel(Labels.labelTag.PASSWORD_PROMPT_FOR) + uiControl.p_settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR) + " " + admin1Button.getText());
                break;
            case ADMIN2: 
                admin2Button.setSelected(true);
                admin2Button.setId("ButtonSelected");
                username = admin2Username; 
                passwordField.setPromptText(uiControl.p_settings.labels.getLabel(Labels.labelTag.PASSWORD_PROMPT_FOR) + uiControl.p_settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR) + " " + admin2Button.getText());
                break;
            case ADMIN3: 
                admin3Button.setSelected(true);
                admin3Button.setId("ButtonSelected");
                username = admin3Username; 
                passwordField.setPromptText(uiControl.p_settings.labels.getLabel(Labels.labelTag.PASSWORD_PROMPT_FOR) + uiControl.p_settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR) + " " + admin3Button.getText());
                break;
        }
    }
    
    private void loginAsGuest(){
        username = "guest";
        loginAction();
    }
    
    private boolean verifyLogin(){
        Utility.log("Login | verifyLogin");
        
        if(username != null && username.equalsIgnoreCase("guest")){ password = "guest"; }
        else{ password = passwordField.getText(); }
        
        if(password.length() == 0){ Utility.log("No Password entered. Exiting."); return false; }
        
        return uiControl.uiModel.isLoginCorrect(username, password);
    }
    
    private void loginAction(){
        if(verifyLogin()){ uiControl.setAppContainer(); }
        else{ Utility.log("Login | verifyLogin | Failed to verify login"); }
    }
}
