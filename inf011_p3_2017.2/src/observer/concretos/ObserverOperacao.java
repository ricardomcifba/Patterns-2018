/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.concretos;

import observer.interfaces.IObserver;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 * O observer Concreto, que implementa
 * IObserver
 * 
 */
public class ObserverOperacao implements IObserver {

    @Override
    public void update() {
        System.out.println("Operacao mudou!");
    }
    
}
