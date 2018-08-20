
package pkg20171prova.Fabrica;

import pkg20171prova.Interfaces.IChassi;
import pkg20171prova.Interfaces.IMotor;
import pkg20171prova.Interfaces.IMyCar;
import pkg20171prova.Interfaces.IPneu;

public class Car implements IMyCar{    
        
    private int qtdPneus;
    private int qtdChassi;
    private int qtdMotor;

    public void setQtdPneus(int qtdPneus) {
        this.qtdPneus = qtdPneus;
    }

    public void setQtdChassi(int qtdChassi) {
        this.qtdChassi = qtdChassi;
    }

    public void setQtdMotor(int qtdMotor) {
        this.qtdMotor = qtdMotor;
    }

    public int getQtdPneu() {
        return qtdPneus;
    }

    public int getQtdChassi() {
        return qtdChassi;
    }

    public int getQtdMotor() {
        return qtdMotor;
    }
    
    private Car(){
    
    }  

    public static IMyCar getInstance(int pneu, int chassi, int motor) {
        
        Car car = new Car();
        
        car.setQtdPneus(pneu);
        car.setQtdChassi(chassi);
        car.setQtdMotor(motor);
        Pneu.initialize(car.getQtdPneu());
        Chassi.initialize(car.getQtdChassi());
        Motor.initialize(car.getQtdMotor());
        return car;
    }
    
        
    
    public IPneu createPneu(){
        return Pneu.getInstance(); //mudar para
    }
    
    public IChassi createChassi(){
        return Chassi.getInstance();// mudar para getInstance();
    }
    
    public IMotor createMotor(){
        return Motor.getInstance();
    }
    
}
