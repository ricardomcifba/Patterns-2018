/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.concretos;

import command.interfaces.*;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 * 
 * Aqui, o command concreto que será implementado
 * pelo programador, escrevi um System.out.println()
 * apenas para não deixar o método em branco
 * 
 */
public class Transferencia extends IOperacao {

    @Override
    protected void transfer() {
        System.out.println("Transferencia executada");
    }

    @Override
    protected void distransfer() {
        System.out.println("Transferencia disfeita");
    }
    
}
