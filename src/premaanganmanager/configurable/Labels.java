/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trevor Fernandes
 */
public class Labels {
    // public enum to get/set lables from this file.
    public enum labelTag{
        // Common labels.
// Common labels.
// Common labels.
// Common labels.
// Common labels.
// Common labels.
// Common labels.
// Common labels.
        APPLICATION_TITLE,BACK,                                                 // Application wide
        MENU_HOME, MENU_BROWSE, MENU_ADD, MENU_SEARCH, MENU_SETTINGS,           // Menu labels.
        HEADER_TITLE, HEADER_LOGOUT, HEADER_SWITCH_ADMIN,                       // Header labels.
        
        // Login
        LOGIN_TITLE, LOGIN_SUBTITLE1, LOGIN_SUBTITLE2, LOGIN_HELP1, LOGIN_HELP2, LOGIN_ERROR1,    // Login labels common to both the login screens.
        GUEST, ADMIN,                                                           // Login Guest Admin specific labels.
        ADMIN1, ADMIN2, ADMIN3, PASSWORD, PASSWORD_PROMPT, LOGIN,                    // Admin only specific labels.
        
        // Home and 'About this software'
        HOME_TITLE, HOME_SUBTITLE1, HOME_SUBTITLE2, HOME_SUBTITLE3,             // Home labels.
        HOME_ABOUT_THIS_SOFTWARE,
    }
    
    // List of all  labels used in PAM
    // Common labels.
    private String l_ApplicationTitle, l_Back;
    private String l_MenuHome, l_MenuBrowse, l_MenuAdd, l_MenuSearch, l_MenuSettings;
    private String l_HeaderTitle, l_HeaderLogout, l_HeaderSwitchAdmin;

    // Login
    private String l_LoginTitle, l_LoginSubtitle1, l_LoginSubtitle2, l_LoginHelp, l_Guest, l_Admin, l_Admin1, l_Admin2, l_Admin3, l_Key, l_PasswordPrompt, l_Login;
    
    // Home and 'About this software'
    private String l_HomeTitle, l_HomeSubtitle1, l_HomeSubtitle2, l_HomeSubtitle3, l_HomeAboutThisSoftware;
    
    
    // public functions.
    public void setLabel(labelTag tag, String value){
        switch(tag){
            case APPLICATION_TITLE: l_ApplicationTitle = value; break;
            case BACK: l_Back = value; break;
            
            case MENU_HOME: l_MenuHome = value; break;
            case MENU_BROWSE: l_MenuBrowse = value; break;
            case MENU_ADD: l_MenuAdd = value; break;
            case MENU_SEARCH: l_MenuSearch = value; break;
            case MENU_SETTINGS: l_MenuSettings = value; break;
            
            case HEADER_TITLE: l_HeaderTitle = value; break;
            case HEADER_LOGOUT: l_HeaderLogout = value; break;
            case HEADER_SWITCH_ADMIN: l_HeaderSwitchAdmin = value; break;

            case LOGIN_TITLE: l_LoginTitle = value; break;
            case LOGIN_SUBTITLE1: l_LoginSubtitle1 = value; break;
            case LOGIN_SUBTITLE2: l_LoginSubtitle2 = value; break;
            case LOGIN_HELP1: l_LoginHelp = value; break;
            case GUEST: l_Guest = value; break;
            case ADMIN: l_Admin = value; break;
            case ADMIN1: l_Admin1 = value; break;
            case ADMIN2: l_Admin2 = value; break;
            case ADMIN3: l_Admin3 = value; break;
            case PASSWORD: l_Key = value; break;
            case PASSWORD_PROMPT: l_PasswordPrompt = value; break;
            case LOGIN: l_Login = value; break;
            
            case HOME_TITLE: l_HomeTitle = value; break;
            case HOME_SUBTITLE1: l_HomeSubtitle1 = value; break;
            case HOME_SUBTITLE2: l_HomeSubtitle2 = value; break;
            case HOME_SUBTITLE3: l_HomeSubtitle3 = value; break;
            case HOME_ABOUT_THIS_SOFTWARE: l_HomeAboutThisSoftware = value; break;
        }
    }
    
    public String getLabel(labelTag tag){
        switch(tag){
            case APPLICATION_TITLE: return l_ApplicationTitle; 
            case BACK: return l_Back;

            case MENU_HOME: return l_MenuHome;
            case MENU_BROWSE: return l_MenuBrowse;
            case MENU_ADD: return l_MenuAdd;
            case MENU_SEARCH: return l_MenuSearch;
            case MENU_SETTINGS: return l_MenuSettings;
            
            case HEADER_TITLE: return l_HeaderTitle;
            case HEADER_LOGOUT: return l_HeaderLogout;
            case HEADER_SWITCH_ADMIN: return l_HeaderSwitchAdmin;
            
            case LOGIN_TITLE: return l_LoginTitle;
            case LOGIN_SUBTITLE1: return l_LoginSubtitle1;
            case LOGIN_SUBTITLE2: return l_LoginSubtitle2;
            case LOGIN_HELP1: return l_LoginHelp;
            case GUEST: return l_Guest;
            case ADMIN: return l_Admin;
            case ADMIN1: return l_Admin1;
            case ADMIN2: return l_Admin2;
            case ADMIN3: return l_Admin3;
            case PASSWORD: return l_Key;
            case PASSWORD_PROMPT: return l_PasswordPrompt;
            case LOGIN: return l_Login;
            
            case HOME_TITLE: return l_HomeTitle;
            case HOME_SUBTITLE1: return l_HomeSubtitle1;
            case HOME_SUBTITLE2: return l_HomeSubtitle2;
            case HOME_SUBTITLE3: return l_HomeSubtitle3;
            case HOME_ABOUT_THIS_SOFTWARE: return l_HomeAboutThisSoftware;
        }
        return "NA";
    }
//    
//    // Sets all labels to default value
//    public final void setDefaultValuesToAllLabels() throws SQLException{
//        setLabel(labelTag.APPLICATION_TITLE, "Prem Aangan Manager 1.0");
//        setLabel(labelTag.BACK, "Back");
//        
//        setLabel(Labels.labelTag.LOGIN_TITLE, "Prem Aangan Manager");
//        setLabel(labelTag.LOGIN_SUBTITLE1, "Login To Start");
//        setLabel(labelTag.LOGIN_HELP1, "Please click on one of the above login options to begin.");
//        setLabel(Labels.labelTag.GUEST, "Guest");
//        setLabel(Labels.labelTag.ADMIN, "Admin");
//        setLabel(Labels.labelTag.ADMIN1, "Admin 1");
//        setLabel(Labels.labelTag.ADMIN2, "Admin 2");
//        setLabel(Labels.labelTag.ADMIN3, "Admin 3");
//        setLabel(Labels.labelTag.PASSWORD, "Key");
//        setLabel(labelTag.PASSWORD_PROMPT, "Enter Admin Key");
//        setLabel(Labels.labelTag.LOGIN, "Login");
//        
//        setLabel(Labels.labelTag.MENU_HOME, "Home");
//        setLabel(Labels.labelTag.MENU_BROWSE, "Browse");
//        setLabel(Labels.labelTag.MENU_ADD, "Add");
//        setLabel(Labels.labelTag.MENU_SEARCH, "Search");
//        setLabel(Labels.labelTag.MENU_SETTINGS, "Settings");
//        
//        setLabel(Labels.labelTag.HEADER_TITLE, "Home");
//        
//        
//        try{
////            ResultSet result = ui
//        } catch(Exception e){
//            System.err.println("Labels | setDefaultValuesToAllLabels | Error " + e);
//        }
//    }
}
