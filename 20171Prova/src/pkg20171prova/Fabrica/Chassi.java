
package pkg20171prova.Fabrica;

import java.util.ArrayList;
import pkg20171prova.Interfaces.IChassi;

public class Chassi implements IChassi {
    
    private static final ArrayList<Chassi> chassi = new ArrayList<Chassi>();
    private static int countChassi = 0;
    private static int maximo; 
    
    public static void initialize(int valor){
        maximo = valor;
    } 

    public static synchronized Chassi getInstance() {

        Chassi instancia = null;

        if (maximo == chassi.size()) {
            instancia = chassi.get(countChassi % maximo);
        } else {
            instancia = new Chassi();
            chassi.add(instancia);
        }
        countChassi++;
        return instancia;
    }
    @Override
    public IChassi createChassi() {
        return new Chassi();
    }

}
