/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.configurable.Labels;

/**
 * FXML Controller class
 *
 * @author Trevor Fernandes
 */
public class BrowseController{
    
    private AppContainer appContainer;
    
    @FXML
    private TableView browseTable;
    private TableColumn idColumn;
    private TableColumn dummyValueColumn;
    
    @FXML
    private Button browseStudentButton;
    
    @FXML
    private void browseStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_TABLE);
    }
    
    // Constructor
    public BrowseController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    // Public functions
    public AnchorPane setBrowseScreenMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Browse.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            setBrowseScreenMenuLabels();
            return homeBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setBrowseTable(AppContainer.screenTag tag){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/BrowseTable.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            dispayTable(tag);
            return homeBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // private functions
    private void dispayTable(AppContainer.screenTag tag){
        switch(tag){
            case BROWSE_STUDENT_TABLE: displayStudentTable(); break;
        }
    }
    
    private void displayStudentTable(){
        TableColumn col_id = new TableColumn();
        TableColumn col_firstName = new TableColumn();
        TableColumn col_middleName = new TableColumn();
        TableColumn col_lastName = new TableColumn();
        TableColumn col_address = new TableColumn();
        TableColumn col_email = new TableColumn();
        TableColumn col_dob = new TableColumn();
        TableColumn col_placeOfBirth = new TableColumn();
        TableColumn col_religion = new TableColumn();
        TableColumn col_otherReligion = new TableColumn();
        TableColumn col_educationalBackground = new TableColumn();
        TableColumn col_languages = new TableColumn();
        TableColumn col_hobbies = new TableColumn();
        TableColumn col_emergencyContactPerson = new TableColumn();
        TableColumn col_emergencyContactTelNo = new TableColumn();
        
        col_id.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_ID));
        col_firstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME));
        col_middleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME));
        col_lastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME));
        col_address.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ADDRESS));
        col_email.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMAIL));
        col_dob.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH));
        col_placeOfBirth.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH));
        col_religion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_RELIGION));
        col_otherReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OTHER_RELIGION));
        col_educationalBackground.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND));
        col_languages.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LANGUAGES));
        col_hobbies.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_HOBBIES));
        col_emergencyContactPerson.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON));
        col_emergencyContactTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO));
        
        final ObservableList data = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchAllStudent());
        
        col_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        col_middleName.setCellValueFactory(new PropertyValueFactory<Student,String>("middleName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        col_address.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        col_email.setCellValueFactory(new PropertyValueFactory<Student,String>("email_id"));
        col_dob.setCellValueFactory(new PropertyValueFactory<Student,String>("dob"));
        col_placeOfBirth.setCellValueFactory(new PropertyValueFactory<Student,String>("placeOfBirth"));
        col_religion.setCellValueFactory(new PropertyValueFactory<Student,String>("religion"));
        col_otherReligion.setCellValueFactory(new PropertyValueFactory<Student,String>("otherReligion"));
        col_educationalBackground.setCellValueFactory(new PropertyValueFactory<Student,String>("educationalBackground"));
        col_languages.setCellValueFactory(new PropertyValueFactory<Student,String>("languages"));
        col_hobbies.setCellValueFactory(new PropertyValueFactory<Student,String>("hobbies"));
        col_emergencyContactPerson.setCellValueFactory(new PropertyValueFactory<Student,String>("emergencyContactPerson"));
        col_emergencyContactTelNo.setCellValueFactory(new PropertyValueFactory<Student,String>("emergencyContactNumber"));
        
        browseTable.setItems(data);
        browseTable.getColumns().addAll(
                col_id,col_firstName,col_middleName,col_lastName,
                col_address,col_email,col_dob,col_placeOfBirth,
                col_religion,col_otherReligion,col_educationalBackground,col_languages,col_hobbies,
                col_emergencyContactPerson,col_emergencyContactTelNo);
    }

    private void setBrowseScreenMenuLabels(){
        browseStudentButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT));
    }
}
