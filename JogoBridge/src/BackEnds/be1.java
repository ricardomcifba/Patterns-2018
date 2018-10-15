/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnds;

import interfaces.IBackEnd;

/**
 *
 * @author Aluno
 */
public class BE1 implements IBackEnd {

    @Override
    public void draw() {
        System.out.println("Desenhou Back-End 1");
    }

    @Override
    public void playSound() {
        System.out.println("Reproduziu som do Back-End 1");
    }

    @Override
    public void action() {
        System.out.println("Implementou uma ação Back-End 1");
    }
    
}
