/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import command.concretos.Transferencia;
import command.interfaces.IOperacao;

import observer.concretos.ObserverOperacao;
import observer.interfaces.*;


/**
 *
 * @author aluno
 */
public class Cliente {
    
    public static void main(String[] args) {
    
        IOperacao operacao = new Transferencia();
        
        IObserver observer = new ObserverOperacao();
        
        ( (ISubject) operacao ).addObserver(observer);
        
        operacao.redo();
        
        operacao.undo();
        
        
    }
    
}
