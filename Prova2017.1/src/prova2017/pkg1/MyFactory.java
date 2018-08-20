/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2017.pkg1;

import interfaces.IMotor;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
class MyFactory {
    
    private static final ArrayList <MyFactory> instanciaPneu = new ArrayList<MyFactory>();
    private static final ArrayList <MyFactory> instanciaChassi = new ArrayList<MyFactory>();
    private static final ArrayList <MyFactory> instanciaMotor = new ArrayList<MyFactory>();
    private int countPneu = 0;
    private int countChassi = 0;
    private int countMotor = 0;

    static MyFactory getInstance(int pneu, int chassi, int motor) {
        return null;
    }

    IMotor createMotor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    
}
