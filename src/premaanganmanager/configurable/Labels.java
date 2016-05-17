/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

/**
 *
 * @author Trevor Fernandes
 */
public class Labels {
    // public enum to get/set lables from this file.
    public enum labelTag{
        APPLICATIONTITLE, LOGINTITLE, LOGINSUBTITLE, LOGINHELP, GUEST, ADMIN, ADMIN1, ADMIN2, ADMIN3, KEY, PASSWORDPROMPT, BACK, LOGIN
    }
    
    // List of all  labels used in PAM
    private String l_ApplicationTitle, l_LoginTitle, l_LoginSubtitle, l_LoginHelp, l_Guest, l_Admin, l_Admin1, l_Admin2, l_Admin3, l_Key, l_PasswordPrompt, l_Back, l_Login;
    
    // public functions.
    public void setLabel(labelTag tag, String value){
        switch(tag){
            case APPLICATIONTITLE: l_ApplicationTitle = value; break;
            case LOGINTITLE: l_LoginTitle = value; break;
            case LOGINSUBTITLE: l_LoginSubtitle = value; break;
            case LOGINHELP: l_LoginHelp = value; break;
            case GUEST: l_Guest = value; break;
            case ADMIN: l_Admin = value; break;
            case ADMIN1: l_Admin1 = value; break;
            case ADMIN2: l_Admin2 = value; break;
            case ADMIN3: l_Admin3 = value; break;
            case KEY: l_Key = value; break;
            case PASSWORDPROMPT: l_PasswordPrompt = value; break;
            case BACK: l_Back = value; break;
            case LOGIN: l_Login = value; break;
        }
    }
    
    public String getLabel(labelTag tag){
        switch(tag){
            case APPLICATIONTITLE: return l_ApplicationTitle; 
            case LOGINTITLE: return l_LoginTitle;
            case LOGINSUBTITLE: return l_LoginSubtitle;
            case LOGINHELP: return l_LoginHelp;
            case GUEST: return l_Guest;
            case ADMIN: return l_Admin;
            case ADMIN1: return l_Admin1;
            case ADMIN2: return l_Admin2;
            case ADMIN3: return l_Admin3;
            case KEY: return l_Key;
            case PASSWORDPROMPT: return l_PasswordPrompt;
            case BACK: return l_Back;
            case LOGIN: return l_Login;
        }
        return "NA";
    }
    
    // Sets all labels to default value.
    public final void setDefaultValuesToAllLabels(){
        setLabel(labelTag.APPLICATIONTITLE, "Prem Aangan Manager 1.0");
        setLabel(Labels.labelTag.LOGINTITLE, "Prem Aangan Manager");
        setLabel(labelTag.LOGINSUBTITLE, "Login To Start");
        setLabel(labelTag.LOGINHELP, "Please click on one of the above login options to begin.");
        setLabel(Labels.labelTag.GUEST, "Guest");
        setLabel(Labels.labelTag.ADMIN, "Admin");
        setLabel(Labels.labelTag.ADMIN1, "Admin 1");
        setLabel(Labels.labelTag.ADMIN2, "Admin 2");
        setLabel(Labels.labelTag.ADMIN3, "Admin 3");
        setLabel(Labels.labelTag.KEY, "Key");
        setLabel(labelTag.PASSWORDPROMPT, "Enter Admin Key");
        setLabel(labelTag.BACK, "Back");
        setLabel(Labels.labelTag.LOGIN, "Login");
    }
}
