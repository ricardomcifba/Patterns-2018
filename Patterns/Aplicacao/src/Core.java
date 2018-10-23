
import interfaces.ICore;
import interfaces.IDBController;
import interfaces.IPluginController;
import interfaces.IUIController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Core implements ICore{

    private IDBController bd;
    private IPluginController plugin;
    private IUIController ui;
       
    public Core() {
        this.bd = new DBController();
        this.plugin = new PluginController();
        this.ui = new UIController();
    }

    @Override
    public IUIController getUIController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDBController getDBController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPluginController getPluginController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
