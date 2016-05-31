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
import premaanganmanager.base.controller.background.Dummy;
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
        appContainer.displayScreen(AppContainer.screenTag.BROWSE_TABLE);
    }
    
    public BrowseController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    public void setBrowseDummyTable(){
        idColumn = new TableColumn();
        dummyValueColumn = new TableColumn();
        
//        Dummy d1 = new Dummy();
//        Dummy d2 = new Dummy();
//        
//        d1.setId(90);
//        d1.setDummyValue("Big");
//        
//        d2.setId(100);
//        d2.setDummyValue("Small");
        
        final ObservableList data = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchAllDummy());
//        final ObservableList data =  FXCollections.observableArrayList(
//                d2,d1
//        );
        
        
        idColumn.setCellValueFactory(new PropertyValueFactory<Dummy,Integer>("id"));
        dummyValueColumn.setCellValueFactory(new PropertyValueFactory<Dummy,String>("dummyValue"));
        
        idColumn.setText("ID");
        dummyValueColumn.setText("Dummy Value");
        
        browseTable.setItems(data);
        browseTable.getColumns().addAll(idColumn,dummyValueColumn);
    }
    
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
    
    public AnchorPane setBrowseTable(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/BrowseTable.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            return homeBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    private void setBrowseScreenMenuLabels(){
        browseStudentButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT));
    }
}
