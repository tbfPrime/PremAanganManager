/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.time.chrono.ChronoLocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
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
    public static boolean alertConfirmation(String message){
        Utility.log("LocalUtility | alertConfirmation");
        return Utility.alert(Alert.AlertType.CONFIRMATION, Labels.labelTag.ALERT_CONFIRMATION.getLabel(), message, Utility.getPathCSS(Settings.getAlertCSS()));
    }
    public static boolean alertConfirmationFieldIsEmpty(){
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
    public static boolean validateNumeric(String value){
        Utility.log("LocalUtility | validateNumeric | value: " + value);
        try{
            Utility.log("LocalUtility | validateNumeric | String is a proper Number: " + Double.parseDouble(value));
            return true;
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | validateNumeric | Error: " + e);
            return false;
        }
    }
    public static boolean validateDOB(ChronoLocalDate dob){
        Utility.log("LocalUtility | validateDOB | dob: " + dob);
        return (dob.isEqual(Settings.getDOBMaximum()) || dob.isEqual(Settings.getDOBMinimum()) || (dob.isBefore(Settings.getDOBMaximum()) && dob.isAfter(Settings.getDOBMinimum())));
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
    public static void ensureVisible(ScrollPane pane, Node node) {
        double width = pane.getContent().getBoundsInLocal().getWidth();
        double height = pane.getContent().getBoundsInLocal().getHeight();
        double x = node.getBoundsInParent().getMaxX();
        double y = node.getBoundsInParent().getMaxY();
        pane.setVvalue(y/height);
        pane.setHvalue(x/width);
        node.requestFocus();
    }
}
