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
        LOGINTITLE, LOGIN, GUEST, ADMIN, ADMIN1, ADMIN2, ADMIN3, KEY        
    }
    
    // List of all  labels used in PAM
    private String l_LoginTitle, l_Login, l_Guest, l_Admin, l_Admin1, l_Admin2, l_Admin3, l_Key;
    
    // public functions.
    public void setLabel(labelTag tag, String value){
        switch(tag){
            case LOGINTITLE: l_LoginTitle = value; break;
            case LOGIN: l_Login = value; break;
            case GUEST: l_Guest = value; break;
            case ADMIN: l_Admin = value; break;
            case ADMIN1: l_Admin1 = value; break;
            case ADMIN2: l_Admin2 = value; break;
            case ADMIN3: l_Admin3 = value; break;
            case KEY: l_Key = value; break;
        }
    }
    
    public String getLabel(labelTag tag){
        switch(tag){
            case LOGINTITLE: return l_LoginTitle;
            case LOGIN: return l_Login;
            case GUEST: return l_Guest;
            case ADMIN: return l_Admin;
            case ADMIN1: return l_Admin1;
            case ADMIN2: return l_Admin2;
            case ADMIN3: return l_Admin3;
            case KEY: return l_Key;
        }
        return "NA";
    }
    
    // Sets all labels to default value.
    public final void setDefaultValuesToAllLabels(){
        setLabel(Labels.labelTag.LOGINTITLE, "Prem Aangan Manager");
        setLabel(Labels.labelTag.LOGIN, "Login");
        setLabel(Labels.labelTag.GUEST, "Guest");
        setLabel(Labels.labelTag.ADMIN, "Admin");
        setLabel(Labels.labelTag.ADMIN1, "Admin 1");
        setLabel(Labels.labelTag.ADMIN2, "Admin 2");
        setLabel(Labels.labelTag.ADMIN3, "Admin 3");
        setLabel(Labels.labelTag.KEY, "Key");
    }
}
