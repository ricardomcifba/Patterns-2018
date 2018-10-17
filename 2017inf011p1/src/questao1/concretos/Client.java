/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1.concretos;

import questao1.interfaces.*;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 */
public class Client {
            
    public static void main( String[] args ) {
    
        IFactory f = MyFactory.getInstance();
        
        IPneu pneu = new Pneu();
        
        f.addPrototype("Pneu", pneu, 2);
        
        IPneu m1 = f.create("Pneu");
        IPneu m2 = f.create("Pneu");
        IPneu m3 = f.create("Pneu");
        IPneu m4 = f.create("Pneu");
        
    }
    
}
