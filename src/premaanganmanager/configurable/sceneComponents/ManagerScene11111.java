/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import premaanganmanager.configurable.SceneContainer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class ManagerScene11111{ // extends ScreenParent{
    // public member variables
    public CommonMenu commonMenu;
    public CommonHeader commonHeader;
    public ActiveScreenContainer activeScreenContainer;
    
    // constructor
//    public ManagerScene11111(SceneContainer sceneContainer){
//        super(sceneContainer);
//        commonMenu = new CommonMenu(this);
//        commonHeader = new CommonHeader(this);
//        activeScreenContainer = new ActiveScreenContainer(this);
//
//        uiControl.getPropertyChangeSupport().addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                updateActiveScreen((UIControl.screenTag)evt.getNewValue());
//            }
//        });
//    }
    
    // private methods
    private void updateActiveScreen(UIControl.screenTag tag){
        commonHeader.setHeaderText(tag.getSubtitle());
//        activeScreenContainer.commonScreenFootControls.updateControls(tag);
    }
}
