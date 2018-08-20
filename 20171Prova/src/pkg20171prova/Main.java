
package pkg20171prova;

import pkg20171prova.Interfaces.IMotor;
import pkg20171prova.Fabrica.Car;
import pkg20171prova.Fabrica.Chassi;
import pkg20171prova.Fabrica.Motor;
import pkg20171prova.Fabrica.Pneu;
import pkg20171prova.Interfaces.IMyCar;

public class Main {
    
    public static void main(String[] args) {
        
        IMyCar carro = Car.getInstance(4,3,2);
        
        //Pneu.initialize(carro.getQtdPneu());
        //Chassi.initialize(carro.getQtdChassi());
        Motor.initialize(carro.getQtdMotor());
        
       IMotor m1 = carro.createMotor();
        IMotor m2 = carro.createMotor();
        IMotor m3 = carro.createMotor();
        IMotor m4 = carro.createMotor();
        IMotor m5 = carro.createMotor();
        IMotor m6 = carro.createMotor();
        IMotor m7 = carro.createMotor();
        IMotor m8 = carro.createMotor();
        
        System.out.println(carro.getQtdMotor());
        
        System.out.println(m1+" \n" + m2+" \n"  +m3+" \n"  + m4);
        System.out.println(m5+" \n" + m6+" \n"  +m7+" \n"  + m8);
        
    }
    
}
