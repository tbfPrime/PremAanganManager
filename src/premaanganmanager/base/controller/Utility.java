/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.FileChooser;

/**
 * Utility contains independent utility functions.
 * 
 * @author Trevor Fernandes
 */
public class Utility {
    
    // public methods    
    public static String getPathCSS(String value){ return Utility.class.getResource(UIControl.getCSSDir() + value).toExternalForm(); }
    public static URL getPathFXML(String value){ return Utility.class.getResource(UIControl.getFXMLDir() + value); }
    public static void log(String value){ if(UIControl.LOG){ System.out.println(getLogHead() + "LOG: " + value); }}
    public static void errorLog(String value){ if(UIControl.LOG){ System.err.println(getLogHead() + "ERROR LOG: " + value); }}
    public static boolean alert(Alert.AlertType type, String title, String message, String styleCSS){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        
        DialogPane d = alert.getDialogPane();
        d.getStylesheets().add(styleCSS);
        d.getStyleClass().add("alert");
        
        alert.setHeaderText(null);
        
        try{
            Optional<ButtonType> result = alert.showAndWait();
            return (result.get() == ButtonType.OK);
        } catch(Exception e){
            errorLog("alert | " + e);
            return false;
        }
    }
    public static void configureFileChooserForImages(FileChooser fileChooser){
        fileChooser.setTitle("Dummy Title Image File Chooser");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png")
        );
    }
    public static String getFileExtensionFromString(String filePath){
        Utility.log("Utility | getFileExtensionFromString | filePath: " + filePath);
        int i = filePath.lastIndexOf(".");
        if(i > 0){ return filePath.substring(i+1); }
        else{ Utility.log("Utility | getFileExtensionFromString | Incorrect filePath format."); return ""; }
    }
    
    private static String getLogHead(){
        return "Utlilty | " + new SimpleDateFormat("E | hh:mm:ss:SSS").format(new Date()) + " | ";
    }
}
