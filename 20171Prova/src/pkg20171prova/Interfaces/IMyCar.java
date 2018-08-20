/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171prova.Interfaces;

/**
 *
 * @author e127787
 */
public interface IMyCar {

    public IMotor createMotor();
    public IChassi createChassi();
    public IPneu createPneu();

    public void setQtdPneus(int pneu);

    public void setQtdChassi(int chassi);

    public void setQtdMotor(int motor);

    public int getQtdMotor();
    
    public int getQtdChassi();
    
    public int getQtdPneu();
    
}
