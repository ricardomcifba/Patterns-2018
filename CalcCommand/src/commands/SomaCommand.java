/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import interfaces.ICommand;
import receiver.Calculadora;

/**
 *
 * @author e127787
 */
public class SomaCommand implements ICommand {

    private Calculadora calc;
    private int state;

    public SomaCommand(Calculadora calc, int state) {
        this.calc = calc;
        this.state = state;
    }

    @Override
    public void redo() {
        this.calc.somar(this.state);
    }

    @Override
    public void undo() {
        this.calc.subtrair(this.state);
    }

}
