
package pkg20171prova.Fabrica;

import java.util.ArrayList;
import pkg20171prova.Interfaces.IMotor;

public class Motor implements IMotor{
    
    private static final ArrayList<Motor> instMotor = new ArrayList<Motor>();
    private static int countMotor = 0;
    private static int maximo; 
    
    public static void initialize(int valor){
        maximo = valor;
    }    
    protected Motor() {
            
    }    
    public static synchronized Motor getInstance(){
        
        Motor instancia = null;
        
        if(maximo == instMotor.size())
            instancia = instMotor.get(countMotor%maximo);
        else{
            instancia = new Motor();
            instMotor.add(instancia);
        }
        countMotor++;
        return instancia;
    }

    public IMotor createMotor() {
        return Motor.getInstance();
    }
    
    /*public String toString(){
        return ("O Maximo é " + maximo+ "count" +countMotor);
    }*/
}
    