
package pkg20171prova.Fabrica;

import java.util.ArrayList;
import pkg20171prova.Interfaces.IPneu;


public class Pneu implements IPneu {
    
    private ArrayList<Pneu> pneu = new ArrayList<Pneu>();

    protected Pneu() {
        
    }

    @Override
    public Pneu createPneu() {
        return new Pneu();
    }
     
    
}
