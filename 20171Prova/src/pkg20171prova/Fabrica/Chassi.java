
package pkg20171prova.Fabrica;

import java.util.ArrayList;
import pkg20171prova.Interfaces.IChassi;

public class Chassi implements IChassi {
    
    private ArrayList<Chassi> chassi = new ArrayList<Chassi>();
    private int count = 0;

    public Chassi() {
    }

    @Override
    public IChassi createChassi() {
        return new Chassi();
    }

}
