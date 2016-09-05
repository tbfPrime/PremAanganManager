/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

/**
 *
 * @author Trevor Fernandes
 */
public interface FootControlInterface {
    public default void back(){
        throw new UnsupportedOperationException("FootControlInterface | back | Not supported yet.");
    }
    public default void save(){
        throw new UnsupportedOperationException("FootControlInterface | save | Not supported yet.");
    }
    public default void print(){
        throw new UnsupportedOperationException("FootControlInterface | print | Not supported yet.");
    }
}
