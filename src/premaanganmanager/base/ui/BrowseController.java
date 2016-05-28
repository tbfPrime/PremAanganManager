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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import premaanganmanager.base.controller.background.Dummy;

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
    
    public BrowseController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    public void setBrowseTable(){
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
    
    public AnchorPane setBrowseHome(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Browse.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            setBrowseTable();
            return homeBase;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
