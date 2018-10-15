/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.interfaces;

import java.util.ArrayList;
import observer.interfaces.IObserver;
import observer.interfaces.ISubject;

/**
 *
 *
 * Command + Template Method + Observer Cada Command Concreto implementa seu
 * execute os métodos Undo e Redo são os template method que chamam o execute (
 * que é protected e abstrato ) e então, de forma padronizada ( template )
 * notificam os subjects ( Observer )
 *
 * Note que a mudança do nome do metodo Notify é necessária devido ao JAVA, que
 * já possui tal método em object.
 *
 */
public abstract class IOperacao implements ISubject {

    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    @Override
    public void addObserver(IObserver observer) {

        observers.add(observer);

    }

    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    protected abstract void transfer();

    protected abstract void distransfer();

    public void undo() {

        this.distransfer();

        this.notifyObserver();

    }

    public void redo() {

        this.transfer();

        this.notifyObserver();

    }

    //Devido a conflitos com os métodos do JAVA, o nome foi modificado para notifyObserver
    @Override
    public void notifyObserver() {

        for (int i = 0; i < observers.size(); i++) {
            this.observers.get(i).update();
        }

    }

}
