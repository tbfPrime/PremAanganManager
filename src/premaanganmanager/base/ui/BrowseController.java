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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.background.FamilyInfo;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.base.controller.background.StudentFamilyInfo;
import premaanganmanager.configurable.Labels;

/**
 * FXML Controller class
 *
 * @author Trevor Fernandes
 */
public class BrowseController{
    
    private final AppContainer appContainer;
    private Student currentStudent;
    
    private String currentTableTag;
    private int currentTableMinId, currentTableMaxId, currentPage, totalPageCount;
    
    @FXML
    private TableView browseTable;
    
    // Browse
    @FXML
    private Button browseStudentButton;
    
    // Browse Table
    @FXML
    private Button browseStudentBackButton, browseTablePreviousPageButton, browseTableNextPageButton;
    @FXML
    private Text browseTablePageIndicator;
    
    // Browse Student Record
    @FXML
    private ImageView browseStudentRecordPhoto;
    
    @FXML
    private Text browsePersonalDetails, browseCourseDetails, browseEmergencyContactDetails, browseFamilyMemberDetails;
    @FXML
    private Text browseStudentRecordNameData;
    @FXML
    private Text browseStudentRecordAddress, browseStudentRecordAddressData;
    @FXML
    private Text browseStudentRecordEmail, browseStudentRecordEmailData;
    @FXML
    private Text browseStudentRecordDOB, browseStudentRecordDOBData;
    @FXML
    private Text browseStudentRecordPlaceOfBirth, browseStudentRecordPlaceOfBirthData;
    @FXML
    private Text browseStudentRecordReligion, browseStudentRecordReligionData;
    @FXML
    private Text browseStudentRecordEducationalBackground, browseStudentRecordEducationalBackgroundData;
    @FXML
    private Text browseStudentRecordLanguages, browseStudentRecordLanguagesData;
    @FXML
    private Text browseStudentRecordHobbies, browseStudentRecordHobbiesData;
    @FXML
    private Text browseStudentRecordCourseName, browseStudentRecordCourseNameData;
    @FXML
    private Text browseStudentRecordClassName, browseStudentRecordClassNameData;
    @FXML
    private Text browseStudentRecordReferenceNo, browseStudentRecordReferenceNoData;
    @FXML
    private Text browseStudentRecordEnrollmentNo, browseStudentRecordEnrollmentNoData;
    @FXML
    private Text browseStudentRecordEmergencyContactName, browseStudentRecordEmergencyContactNameData;
    @FXML
    private Text browseStudentRecordEmergencyContactTelNo, browseStudentRecordEmergencyContactTelNoData;
    @FXML
    private Text browseStudentRecordFamilyMemberName, browseStudentRecordFamilyMemberNameData1, browseStudentRecordFamilyMemberNameData2, browseStudentRecordFamilyMemberNameData3, browseStudentRecordFamilyMemberNameData4, browseStudentRecordFamilyMemberNameData5, browseStudentRecordFamilyMemberNameData6;
    @FXML
    private Text browseStudentRecordFamilyMemberRelationship, browseStudentRecordFamilyMemberRelationshipData1, browseStudentRecordFamilyMemberRelationshipData2, browseStudentRecordFamilyMemberRelationshipData3, browseStudentRecordFamilyMemberRelationshipData4, browseStudentRecordFamilyMemberRelationshipData5, browseStudentRecordFamilyMemberRelationshipData6;
    @FXML
    private Text browseStudentRecordFamilyMemberAge, browseStudentRecordFamilyMemberAgeData1, browseStudentRecordFamilyMemberAgeData2, browseStudentRecordFamilyMemberAgeData3, browseStudentRecordFamilyMemberAgeData4, browseStudentRecordFamilyMemberAgeData5, browseStudentRecordFamilyMemberAgeData6;
    @FXML
    private Text browseStudentRecordFamilyMemberOccupation, browseStudentRecordFamilyMemberOccupationData1, browseStudentRecordFamilyMemberOccupationData2, browseStudentRecordFamilyMemberOccupationData3, browseStudentRecordFamilyMemberOccupationData4, browseStudentRecordFamilyMemberOccupationData5, browseStudentRecordFamilyMemberOccupationData6;
    @FXML
    private Text browseStudentRecordFamilyMemberOccupationalAddress, browseStudentRecordFamilyMemberOccupationalAddressData1, browseStudentRecordFamilyMemberOccupationalAddressData2, browseStudentRecordFamilyMemberOccupationalAddressData3, browseStudentRecordFamilyMemberOccupationalAddressData4, browseStudentRecordFamilyMemberOccupationalAddressData5, browseStudentRecordFamilyMemberOccupationalAddressData6; 
    @FXML
    private Text browseStudentRecordFamilyMemberOccupationalTelNo, browseStudentRecordFamilyMemberOccupationalTelNoData1, browseStudentRecordFamilyMemberOccupationalTelNoData2, browseStudentRecordFamilyMemberOccupationalTelNoData3, browseStudentRecordFamilyMemberOccupationalTelNoData4, browseStudentRecordFamilyMemberOccupationalTelNoData5, browseStudentRecordFamilyMemberOccupationalTelNoData6;
    
    @FXML
    private StackPane browseStudentRecordPhotoStackPane;
    
    @FXML
    private VBox browseStudentRecordFMD0VBox;
    @FXML
    private HBox browseStudentRecordStudentNameHBox;
    @FXML
    private HBox browseStudentRecordFMD0HBox;
    @FXML
    private HBox browseStudentRecordFMD00HBox, browseStudentRecordFMD01HBox, browseStudentRecordFMD02HBox, browseStudentRecordFMD03HBox, browseStudentRecordFMD04HBox, browseStudentRecordFMD05HBox;
    @FXML
    private HBox browseStudentRecordFMD10HBox, browseStudentRecordFMD11HBox, browseStudentRecordFMD12HBox, browseStudentRecordFMD13HBox, browseStudentRecordFMD14HBox, browseStudentRecordFMD15HBox;
    @FXML
    private HBox browseStudentRecordFMD20HBox, browseStudentRecordFMD21HBox, browseStudentRecordFMD22HBox, browseStudentRecordFMD23HBox, browseStudentRecordFMD24HBox, browseStudentRecordFMD25HBox;
    @FXML
    private HBox browseStudentRecordFMD30HBox, browseStudentRecordFMD31HBox, browseStudentRecordFMD32HBox, browseStudentRecordFMD33HBox, browseStudentRecordFMD34HBox, browseStudentRecordFMD35HBox;
    @FXML
    private HBox browseStudentRecordFMD40HBox, browseStudentRecordFMD41HBox, browseStudentRecordFMD42HBox, browseStudentRecordFMD43HBox, browseStudentRecordFMD44HBox, browseStudentRecordFMD45HBox;
    @FXML
    private HBox browseStudentRecordFMD50HBox, browseStudentRecordFMD51HBox, browseStudentRecordFMD52HBox, browseStudentRecordFMD53HBox, browseStudentRecordFMD54HBox, browseStudentRecordFMD55HBox;
    @FXML
    private HBox browseStudentRecordFMD60HBox, browseStudentRecordFMD61HBox, browseStudentRecordFMD62HBox, browseStudentRecordFMD63HBox, browseStudentRecordFMD64HBox, browseStudentRecordFMD65HBox;
    @FXML
    private HBox browseStudentRecordSectionHeaderPersonalDetailsHBox;
    @FXML
    private HBox browseStudentRecordSectionHeaderCourseDetailsHBox;
    @FXML
    private HBox browseStudentRecordSectionHeaderEmergencyContactDetailsHBox;
    @FXML
    private HBox browseStudentRecordSectionHeaderFamilyMemberDetailsHBox;
    
    @FXML
    private Button browseStudentRecordBackButton, browseStudentRecordPrintButton;
    
    // Browse
    @FXML
    private void browseStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_TABLE);
    }
    
    // Browse Table
    // Student
    @FXML
    private void browseTablePreviousAction(){
        System.out.println("BrowseController | browseTablePreviousAction");
        previousPage();
    }
    @FXML
    private void browseTableNextAction(){
        System.out.println("BrowseController | browseTableNextAction");
        nextPage();
    }
    @FXML
    private void browseStudentBackAction(){
        System.out.println("BrowseController | browseSrudentBackAction");
        appContainer.displayScreen(AppContainer.screenTag.BROWSE);
    }
    
    // Browse Student Record
    // Back to list of student records
    @FXML
    private void browseStudentRecordBackAction(){
        System.out.println("BrowseController | browseStudentRecordBackAction");
        appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_TABLE);
    }
    
    // Print Student Record
    @FXML
    private void browseStudentRecordPrintAction(){
        System.out.println("BrowseController | browseStudentRecordPrintAction");
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
            AnchorPane browseTableBase = loader.load();
            setBrowseTableData(tag);
            return browseTableBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseTable | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setBrowseStudentRecord(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/BrowseStudentRecord.fxml"));
            loader.setController(this);
            AnchorPane browseStudentRecordBase = loader.load();
            browseStudentRecordBase.getStylesheets().add(getClass().getResource("BrowseStudentRecord.css").toExternalForm());
            setBrowseStudentRecordData();
            return browseStudentRecordBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseStudentRecord | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // private functions
    private void setBrowseTableData(AppContainer.screenTag tag){
        dispayTable(tag);
        setBrowseTableLabels();
    }
    
    private void setBrowseStudentRecordData(){
        populateStudentData();
        setBrowseStudentRecordID();
        setBrowseStudentRecordScreenLabels();
    }
    
    private void dispayTable(AppContainer.screenTag tag){
        currentTableTag = tag.toString();
        switch(tag){
            case BROWSE_STUDENT_TABLE: setBrowseStudentScreenLabels(); displayStudentTable(); break;
        }
    }
    
    private void setPagingConditions(){
        System.out.println("BrowseController | setPagingConditions");
        
        browseTablePageIndicator.setText(currentPage + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_OF) + " " + totalPageCount);
        browseTablePreviousPageButton.setDisable(currentPage <= 1);
        browseTableNextPageButton.setDisable(currentPage == totalPageCount);
    }
    
    private void firstPage(){
        System.out.println("BrowseController | firstPage");
        currentTableMaxId = currentTableMinId = totalPageCount = currentPage = 0;
        nextPage();
    }
    
    private void nextPage(){
        System.out.println("BrowseController | nextPage | currentTableMinId: " + currentTableMinId + " | currentTableMaxId: " + currentTableMaxId);
        switch(AppContainer.screenTag.valueOf(currentTableTag)){
            case BROWSE_STUDENT_TABLE:
                if(totalPageCount == 0){ totalPageCount = (int)Math.ceil(((double)appContainer.uiControl.uiModel.fetchStudentCount() / appContainer.uiControl.settings.tableMaxItems)); }
                if(totalPageCount > 0 && currentPage <= totalPageCount){
                    final ObservableList data = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchNextStudentInLimit(currentTableMaxId,appContainer.uiControl.settings.tableMaxItems));
                    if(data.size() > 0){
                        currentPage++;
                        Student student = (Student)data.get(0);
                        currentTableMinId = student.getStudentId();
                        
                        student = (Student)data.get(data.size() - 1);
                        currentTableMaxId = student.getStudentId();
                        
                        browseTable.setItems(data);
                    } else{ System.out.println("BrowseController | nextPage | Data size is 0. No Data to display."); }
                } else{ System.out.println("BrowseController | nextPage | totalPageCount is 0. No data to fetch."); }
                break;
        }
        
        setPagingConditions();
        System.out.println("BrowseController | nextPage | currentTableMinId: " + currentTableMinId + " | currentTableMaxId: " + currentTableMaxId);
    }
    
    private void previousPage(){
        System.out.println("BrowseController | previousPage | currentTableMinId: " + currentTableMinId + " | currentTableMaxId: " + currentTableMaxId);
        switch(AppContainer.screenTag.valueOf(currentTableTag)){
            case BROWSE_STUDENT_TABLE:
                if(totalPageCount > 0 && currentPage >= 0){
                    final ObservableList data = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchPreviousStudentInLimit(currentTableMinId,appContainer.uiControl.settings.tableMaxItems));
                    if(data.size() > 0){
                        currentPage--;
                        Student student = (Student)data.get(0);
                        currentTableMinId = student.getStudentId();
                        
                        student = (Student)data.get(data.size() - 1);
                        currentTableMaxId = student.getStudentId();
                        
                        browseTable.setItems(data);
                    } else{ System.out.println("BrowseController | nextPage | No Data to display."); }
                }
                break;
        }
        
        setPagingConditions();
        System.out.println("BrowseController | nextPage | currentTableMinId: " + currentTableMinId + " | currentTableMaxId: " + currentTableMaxId);
    }
    
    private void displayStudentTable(){
        TableColumn col_id = new TableColumn();
        TableColumn col_firstName = new TableColumn();
        TableColumn col_middleName = new TableColumn();
        TableColumn col_lastName = new TableColumn();
        TableColumn col_dob = new TableColumn();
        TableColumn col_referenceNo = new TableColumn();
        TableColumn col_enrollmentNo = new TableColumn();
        TableColumn col_date = new TableColumn();
        
        col_id.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_ID));
        col_firstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME));
        col_middleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME));
        col_lastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME));
        col_dob.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH));
        col_referenceNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_REFERENCE_NUMBER));
        col_enrollmentNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER));
        col_date.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE));
        
        col_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        col_middleName.setCellValueFactory(new PropertyValueFactory<Student,String>("middleName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        col_dob.setCellValueFactory(new PropertyValueFactory<Student,String>("dob"));
        col_referenceNo.setCellValueFactory(new PropertyValueFactory<Student,String>("referenceNumber"));
        col_enrollmentNo.setCellValueFactory(new PropertyValueFactory<Student,String>("enrollmentNumber"));
        col_date.setCellValueFactory(new PropertyValueFactory<Student,String>("date"));
        
        // Get Doubleclick event
        browseTable.setRowFactory(tv -> {
            TableRow<Student> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())){
                    Student rowData = row.getItem();
                    System.out.println("onMouseClicked >> " + rowData);
                    currentStudent = rowData;
                    appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_RECORD);
                }
            });
            return row;
        });
        
//        browseTable.setItems(data);
        browseTable.getColumns().addAll(
                col_id,col_firstName,col_middleName,col_lastName,
                col_dob, col_referenceNo, col_enrollmentNo, col_date
        );
        
        firstPage();
        
        // Code to get selected item in table.
//        browseTable.getSelectionModel().selectedItemProperty().addListener((oldValue) -> {
//            //Check whether item is selected and set value of selected item to Label
//            if (browseTable.getSelectionModel().getSelectedItem() != null) {
//                System.out.println("BrowseController | #################  | old: " + oldValue);
////                lblTool.setText(newValue.getTool());
//            }
//        });
    }
    
    private void setBrowseStudentRecordID(){
        browseStudentRecordPhotoStackPane.setId("PhotoStackPane");
        browseStudentRecordStudentNameHBox.setId("RecordHeaderHBox");
        browseStudentRecordSectionHeaderPersonalDetailsHBox.setId("SectionHeader");
        browseStudentRecordSectionHeaderCourseDetailsHBox.setId("SectionHeader");
        browseStudentRecordSectionHeaderEmergencyContactDetailsHBox.setId("SectionHeader");
        browseStudentRecordSectionHeaderFamilyMemberDetailsHBox.setId("SectionHeader");
        
        browseStudentRecordFMD0VBox.setId("FamilyMemberCellHBox");
        
        browseStudentRecordFMD0HBox.setId("FamilyMemberHeaderHBox");

        browseStudentRecordFMD00HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD01HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD02HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD03HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD04HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD05HBox.setId("FamilyMemberCellHBox");
        
        browseStudentRecordFMD10HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD11HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD12HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD13HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD14HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD15HBox.setId("FamilyMemberCellHBox");        
        
        browseStudentRecordFMD20HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD21HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD22HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD23HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD24HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD25HBox.setId("FamilyMemberCellHBox");        

        browseStudentRecordFMD30HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD31HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD32HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD33HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD34HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD35HBox.setId("FamilyMemberCellHBox");        

        browseStudentRecordFMD40HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD41HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD42HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD43HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD44HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD45HBox.setId("FamilyMemberCellHBox");        

        browseStudentRecordFMD50HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD51HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD52HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD53HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD54HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD55HBox.setId("FamilyMemberCellHBox");        

        browseStudentRecordFMD60HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD61HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD62HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD63HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD64HBox.setId("FamilyMemberCellHBox");
        browseStudentRecordFMD65HBox.setId("FamilyMemberCellHBox");                
    }
    
    private void populateStudentData(){
        System.out.println("BrowseController | populateStudentData");
        
        String name = (!currentStudent.getFirstName().isEmpty()) ? (" " + currentStudent.getFirstName()) : "";
        name += (currentStudent.getMiddleName() == null || currentStudent.getMiddleName().isEmpty()) ? "" : (" " + currentStudent.getMiddleName());
        name += (currentStudent.getLastName() == null || currentStudent.getLastName().isEmpty()) ? "" : (" " + currentStudent.getLastName());
        
        browseStudentRecordNameData.setText(name);
        
        try{
            Path studentPhotoPath = Paths.get(appContainer.uiControl.settings.photosDir, (appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_STUDENT_PHOTO_PREFIX) + currentStudent.getStudentId() + "." + currentStudent.getStudentPhotoId()));
            File studentPhoto = new File(studentPhotoPath.toUri());
            System.out.println("Value of student photo: " + studentPhotoPath.toUri().toURL().toString());
            if(studentPhoto.exists()){ browseStudentRecordPhoto.setImage(new Image(studentPhotoPath.toUri().toURL().toString())); }
            else{ 
                Path studentPlaceHolderPhotoPath = Paths.get(appContainer.uiControl.settings.placeHoldersDir, appContainer.uiControl.settings.placeHolderStudentPhoto);
                browseStudentRecordPhoto.setImage(new Image(studentPlaceHolderPhotoPath.toUri().toURL().toString()));
            }
        } catch(Exception e){
            System.err.println("BrowseController | populateStudentData | Error: " + e);
        }
        
        currentStudent = appContainer.uiControl.uiModel.fetchStudentByID(currentStudent.getStudentId());
        
        if(currentStudent.getAddress() != null && !currentStudent.getAddress().isEmpty()){ browseStudentRecordAddressData.setText(currentStudent.getAddress()); }
        if(currentStudent.getEmailId() != null && !currentStudent.getEmailId().isEmpty()){ browseStudentRecordEmailData.setText(currentStudent.getEmailId()); }
        if(currentStudent.getDob() != null && !currentStudent.getDob().isEmpty()){ browseStudentRecordDOBData.setText(currentStudent.getDob()); }
        if(currentStudent.getPlaceOfBirth() != null && !currentStudent.getPlaceOfBirth().isEmpty()){ browseStudentRecordPlaceOfBirthData.setText(currentStudent.getPlaceOfBirth()); }
        if(currentStudent.getEducationalBackground() != null && !currentStudent.getEducationalBackground().isEmpty()){ browseStudentRecordEducationalBackgroundData.setText(currentStudent.getEducationalBackground()); }
        if(currentStudent.getLanguages() != null && !currentStudent.getLanguages().isEmpty()){ browseStudentRecordLanguagesData.setText(currentStudent.getLanguages()); }
        if(currentStudent.getHobbies() != null && !currentStudent.getHobbies().isEmpty()){ browseStudentRecordHobbiesData.setText(currentStudent.getHobbies()); }
        if(currentStudent.getReferenceNumber() != null && !currentStudent.getReferenceNumber().isEmpty()){ browseStudentRecordReferenceNoData.setText(currentStudent.getReferenceNumber()); }
        if(currentStudent.getEnrollmentNumber() != null && !currentStudent.getEnrollmentNumber().isEmpty()){ browseStudentRecordEnrollmentNoData.setText(currentStudent.getEnrollmentNumber()); }
        if(currentStudent.getEmergencyContactPerson() != null && !currentStudent.getEmergencyContactPerson().isEmpty()){ browseStudentRecordEmergencyContactNameData.setText(currentStudent.getEmergencyContactPerson()); }
        if(currentStudent.getEmergencyContactNumber() != null && !currentStudent.getEmergencyContactNumber().isEmpty()){ browseStudentRecordEmergencyContactTelNoData.setText(currentStudent.getEmergencyContactNumber()); }

        if(currentStudent.getReligionId() != null && !currentStudent.getReligionId().toString().isEmpty()){ browseStudentRecordReligionData.setText(appContainer.uiControl.uiModel.fetchReligionNameByID(currentStudent.getReligionId())); }        
        
        List studentFamilyInfoList = appContainer.uiControl.uiModel.fetchFamilyInfo(currentStudent.getStudentId());
        
        int familyMemberCount = studentFamilyInfoList.size();
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(0);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData1.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData1.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData1.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData1.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData1.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData1.setText(familyInfo.getContactNumber()); }
        }
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(1);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData2.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData2.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData2.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData2.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData2.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData2.setText(familyInfo.getContactNumber()); }
        }
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(2);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData3.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData3.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData3.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData3.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData3.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData3.setText(familyInfo.getContactNumber()); }
        }
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(3);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData4.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData4.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData4.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData4.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData4.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData4.setText(familyInfo.getContactNumber()); }
        }
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(4);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData5.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData5.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData5.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData5.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData5.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData5.setText(familyInfo.getContactNumber()); }
        }
        
        if(familyMemberCount-- >= 1){
            StudentFamilyInfo studentFamilyInfo = (StudentFamilyInfo)studentFamilyInfoList.get(5);
            FamilyInfo familyInfo = appContainer.uiControl.uiModel.fetchFamilyInfoByID(studentFamilyInfo.getFamilyInfoId());
            if(familyInfo != null && familyInfo.getName() != null && !familyInfo.getName().isEmpty()){ browseStudentRecordFamilyMemberNameData6.setText(familyInfo.getName()); }
            if(familyInfo != null && familyInfo.getAge() != null && !familyInfo.getAge().toString().isEmpty()){ browseStudentRecordFamilyMemberAgeData6.setText(familyInfo.getAge().toString()); }
            if(familyInfo != null && familyInfo.getRelationship() != null && !familyInfo.getRelationship().isEmpty()){ browseStudentRecordFamilyMemberRelationshipData6.setText(familyInfo.getRelationship()); }
            if(familyInfo != null && familyInfo.getOccupation() != null && !familyInfo.getOccupation().isEmpty()){ browseStudentRecordFamilyMemberOccupationData6.setText(familyInfo.getOccupation()); }
            if(familyInfo != null && familyInfo.getOccupationalAddress() != null && !familyInfo.getOccupationalAddress().isEmpty()){ browseStudentRecordFamilyMemberOccupationalAddressData6.setText(familyInfo.getOccupationalAddress()); }
            if(familyInfo != null && familyInfo.getContactNumber() != null && !familyInfo.getContactNumber().isEmpty()){ browseStudentRecordFamilyMemberOccupationalTelNoData6.setText(familyInfo.getContactNumber()); }
        }
        
        setStudentRecordProperties();
    }
    
    private void setStudentRecordProperties(){
//        browseStudentRecordFirstName.wrappingWidthProperty().bind(browseStudentRecordStudentNameHBox.widthProperty());
    }

    private void setBrowseScreenMenuLabels(){
        appContainer.setHeaderText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_BROWSE_TITLE));
        
        browseStudentButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT));
    }
    
    private void setBrowseStudentScreenLabels(){
        appContainer.setHeaderText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_BROWSE_STUDENT_TITLE));
        
        browseStudentBackButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
    }
    
    private void setBrowseTableLabels(){
        browseTablePreviousPageButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_PREVIOUS));
        browseTableNextPageButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_NEXT));
    }
    
    private void setBrowseStudentRecordScreenLabels(){
        browseStudentRecordBackButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
        browseStudentRecordPrintButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.PRINT));
        
        browsePersonalDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_PERSONAL_DETAILS));
        browseCourseDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_COURSE_DETAILS));
        browseEmergencyContactDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_EMERGENCY_CONTACT_DETAILS));
        browseFamilyMemberDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_FAMILY_MEMBER_DETAILS));
        
        browseStudentRecordAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordEmail.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMAIL) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordDOB.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordPlaceOfBirth.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_RELIGION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordEducationalBackground.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordLanguages.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LANGUAGES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordHobbies.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_HOBBIES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordCourseName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT_COURSE_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordClassName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT_CLASS_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordReferenceNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_REFERENCE_NUMBER) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordEnrollmentNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordEmergencyContactName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordEmergencyContactTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        browseStudentRecordFamilyMemberName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        browseStudentRecordFamilyMemberRelationship.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        browseStudentRecordFamilyMemberAge.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        browseStudentRecordFamilyMemberOccupation.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        browseStudentRecordFamilyMemberOccupationalAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        browseStudentRecordFamilyMemberOccupationalTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
    }
}