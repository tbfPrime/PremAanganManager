/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import premaanganmanager.base.controller.Utility;

/**
 * Local Utility wrappers
 * @author TBF
 */
public class LocalUtility {
    // public methods
    public static boolean alertNone(String title, String message){
        Utility.log("LocalUtility | alertNone");
        return Utility.alert(Alert.AlertType.NONE, title, message, Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertInfo(String message){
        Utility.log("LocalUtility | alertInfo");
        return Utility.alert(Alert.AlertType.INFORMATION, Labels.labelTag.ALERT_INFO.getLabel(), message, Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertWarning(String message){
        Utility.log("LocalUtility | alertWarning");
        return Utility.alert(Alert.AlertType.WARNING, Labels.labelTag.ALERT_WARNING.getLabel(), message, Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertWarningFieldIsEmpty(String message){
        Utility.log("LocalUtility | alertWarningFieldIsEmpty");
        String msg = message + " " + Labels.labelTag.ALERT_MESSAGE_IS_EMPTY.getLabel();
        return Utility.alert(Alert.AlertType.WARNING, Labels.labelTag.ALERT_WARNING.getLabel(), msg, Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertError(String message){
        Utility.log("LocalUtility | alertError");
        return Utility.alert(Alert.AlertType.ERROR, Labels.labelTag.ALERT_ERROR.getLabel(), Labels.labelTag.ALERT_MESSAGE_ERROR_SAVE.getLabel(), Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertErrorSave(){
        Utility.log("LocalUtility | alertErrorSave");
        return Utility.alert(Alert.AlertType.ERROR, Labels.labelTag.ALERT_ERROR.getLabel(), Labels.labelTag.ALERT_MESSAGE_ERROR_SAVE.getLabel(), Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertConfirmationFieldIsEmpty(String message){
        Utility.log("LocalUtility | alertConfirmationFieldIsEmpty");
        return Utility.alert(Alert.AlertType.CONFIRMATION, Labels.labelTag.ALERT_CONFIRMATION.getLabel(), Labels.labelTag.ALERT_MESSAGE_CONFIRM_FIELD_EMPTY.getLabel(), Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean validateEmail(String value){
        Utility.log("LocalUtility | validateEmail | value: " + value);
        String emailPattern = "(.)(.*)([@])(.)(.*)([.])(.)(.*)";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(value);
        return m.find();
    }
    public static boolean validateReferenceNo(String value){
        Utility.log("LocalUtility | validateReferenceNo | value: " + value);
        String referenceNoPattern = "(^\\D\\d{" + Settings.getReferenceNoLength() + "}$)";
        Pattern p = Pattern.compile(referenceNoPattern);
        Matcher m = p.matcher(value);
        return m.find();
    }
    public static boolean validateEnrollmentNo(String value){
        Utility.log("LocalUtility | validateEnrollmentNo | value: " + value);
        String enrollmentNoPattern = "(^\\d{" + Settings.getEnrollmentNoLength() + "}$)";
        Pattern p = Pattern.compile(enrollmentNoPattern);
        Matcher m = p.matcher(value);
        return m.find();
    }
    public static boolean isNumeric(String value){
        Utility.log("LocalUtility | isNumeric | value: " + value);
        try{
            Utility.log("LocalUtility | isNumeric | String is a proper Number: " + Double.parseDouble(value));
            return true;
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | isNumeric | Error: " + e);
            return false;
        }
    }
    public static Integer convertStringToInteger(String value){
        Utility.log("LocalUtility | convertStringToInteger | value: " + value);
        try{
            return Integer.parseInt(value);
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | convertStringToInteger | Error: " + e);
            return null;
        }        
    }
}
