/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes & Eugenia Bernate Thomas
 */
public class AppContainer {
    public UIControl uiControl;
    public HomeController homeController;
    public BrowseController browseController;
    public AddController addController;
    public SearchController searchController;
    public SettingsController settingsController;
    
    
    private Scene appContainerScene;
    private BorderPane root;
    
    // Menu
    @FXML
    private ToggleButton menuHomeButton, menuBrowseButton, menuAddButton, menuSearchButton, menuSettingsButton;
    
    // Header
    @FXML
    private Text headerText;    
    @FXML
    private ComboBox logoutComboBox;
    
    // Menu
    @FXML
    public void homeButtonAction(){
        System.out.println("AppContainer | homeButtonAction");
        displayScreen(screenTag.HOME);
    }
    @FXML
    public void browseButtonAction(){
        System.out.println("AppContainer | browseButtonAction");
        displayScreen(screenTag.BROWSE);
    }
    @FXML
    public void addButtonAction(){
        System.out.println("AppContainer | addButtonAction");
        displayScreen(screenTag.ADD);
    }
    @FXML
    public void searchButtonAction(){
        System.out.println("AppContainer | searchButtonAction");
        displayScreen(screenTag.SEARCH);
    }
    @FXML
    public void settingsButtonAction(){
        System.out.println("AppContainer | settingsButtonAction");
        displayScreen(screenTag.SETTINGS);
    }
    
    // Header
    @FXML
    public void logoutComboBoxButtonAction(){
        System.out.println("AppContainer | logoutComboBoxButtonAction | Value: " + logoutComboBox.getValue().toString());
        if(logoutComboBox.getValue().toString().equalsIgnoreCase(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_SWITCH_ADMIN))){
            uiControl.logoutToAdminScreen();
        } else if(logoutComboBox.getValue().toString().equalsIgnoreCase(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT))){
            uiControl.logoutToGuestAdminScreen();
        }
    }
    
    // Contructor with params
    public AppContainer(UIControl uiControl){
        this.uiControl = uiControl;
        
        homeController = new HomeController(this);
        browseController = new BrowseController(this);
        addController = new AddController(this);
        searchController = new SearchController();
        settingsController = new SettingsController();
    }
    
    public enum screenTag{
        // Main Menu
        HOME, BROWSE, ADD, SEARCH, SETTINGS,
        
        // Add
        ADD_STUDENT, 
        
        // Browse
        BROWSE_STUDENT_TABLE, BROWSE_TEACHER_TABLE, BROWSE_SUBJECT_TABLE, BROWSE_ATTENDANCE_TABLE,
        BROWSE_COURSE_TABLE, BROWSE_BATCH_TABLE, BROWSE_CLASS_TABLE, BROWSE_TIMETABLE_TABLE,
        
        // Browse Records
        BROWSE_STUDENT_RECORD
    }
    
    // Main Screen Display wrapper
    public void displayScreen(screenTag tag){
        switch(tag){
            case HOME: setHomeScreen(); break;
            case BROWSE: setBrowseScreen(); break;
            case ADD: setAddScreen(); break;
            case SEARCH: setSearchScreen(); break;
            case SETTINGS: setSettingsScreen(); break;
            case ADD_STUDENT: setAddStudentScreen(); break;
            case BROWSE_STUDENT_TABLE:
            case BROWSE_TEACHER_TABLE:
            case BROWSE_SUBJECT_TABLE:
            case BROWSE_ATTENDANCE_TABLE:
            case BROWSE_COURSE_TABLE:
            case BROWSE_BATCH_TABLE:
            case BROWSE_CLASS_TABLE:
            case BROWSE_TIMETABLE_TABLE: setBrowseTableScreen(tag); break;
            case BROWSE_STUDENT_RECORD: setBrowseStudentRecordScreen(); break;
        }
    }
    
    public Scene setAppContainer(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AppContainer.fxml"));
            loader.setController(this);
            root = loader.load();
            appContainerScene = new Scene(root, uiControl.settings.getAppWidth(), uiControl.settings.getAppHeight());
            setAppContainerData();
            return appContainerScene;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setLoginGuestAdminScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public void setHeaderText(String value){
        headerText.setText(value);
    }
    
    // Private Functions
    private void setAppContainerData(){
        setLogOutComboBox();
        setAppContainerGraphics();
        setAppContainerLabels();
        setAppContainerStyling();
    }
    
    private void setAppContainerGraphics(){
        Path graphicPath;
        double graphicTextGap = 0;
        double graphicOpacity = 0.7;
        
        graphicPath = Paths.get(uiControl.settings.pngDir,uiControl.settings.png_menuHome);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuHomeButton.setGraphic(graphic);
            menuHomeButton.setContentDisplay(ContentDisplay.TOP);
            menuHomeButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(uiControl.settings.pngDir,uiControl.settings.png_menuAdd);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuAddButton.setGraphic(graphic);
            menuAddButton.setContentDisplay(ContentDisplay.TOP);
            menuAddButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(uiControl.settings.pngDir,uiControl.settings.png_menuBrowse);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuBrowseButton.setGraphic(graphic);
            menuBrowseButton.setContentDisplay(ContentDisplay.TOP);
            menuBrowseButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(uiControl.settings.pngDir,uiControl.settings.png_menuSearch);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuSearchButton.setGraphic(graphic);
            menuSearchButton.setContentDisplay(ContentDisplay.TOP);
            menuSearchButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(uiControl.settings.pngDir,uiControl.settings.png_menuSettings);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuSettingsButton.setGraphic(graphic);
            menuSettingsButton.setContentDisplay(ContentDisplay.TOP);
            menuSettingsButton.setGraphicTextGap(graphicTextGap);
        }
    }
    
    private void setAppContainerStyling(){
        uiControl.setToggleButtonStyle(menuHomeButton);
        uiControl.setToggleButtonStyle(menuAddButton);
        uiControl.setToggleButtonStyle(menuBrowseButton);
        uiControl.setToggleButtonStyle(menuSearchButton);
        uiControl.setToggleButtonStyle(menuSettingsButton);
    }
    
    private void setLogOutComboBox(){
        logoutComboBox.getItems().addAll(
                uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_SWITCH_ADMIN),
                uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT));
    }
    
    private void setHomeScreen(){
        root.setCenter(homeController.setHome());
    }
    
    private void setBrowseScreen(){
        root.setCenter(browseController.setBrowseScreenMenu());
    }
    
    private void setAddScreen(){
        root.setCenter(addController.setAddScreenMenu());
    }
    
    private void setSearchScreen(){
        root.setCenter(searchController.setSearch());
    }
    
    private void setSettingsScreen(){
        root.setCenter(settingsController.setSettings());
    }
    
    private void setAddStudentScreen(){
        root.setCenter(addController.setAddStudentScreen());
    }
    
    private void setBrowseTableScreen(screenTag tag){
        root.setCenter(browseController.setBrowseTable(tag));
    }

    private void setBrowseStudentRecordScreen(){
        root.setCenter(browseController.setBrowseStudentRecord());
    }
    
    private void setAppContainerLabels(){
        menuHomeButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_HOME));
        menuBrowseButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_BROWSE));
        menuAddButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_ADD));
        menuSearchButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_SEARCH));
        menuSettingsButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_SETTINGS));
//        headerText.setText(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_WELCOME_TITLE));
        logoutComboBox.setPromptText(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT));
    }
}
