/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.concretos;

import questao2.concretos.*;
import questao2.interfaces.Target;
/**
 *
 * @author Paulo Ricardo Miranda Fontes
 */
public class Client {
    
    public static void main( String[] args ) {
        
        Target target = new AdapterObj( new Adaptee() );
        
        target.play( "Teste1", 54000 );
        
    }
    
}
