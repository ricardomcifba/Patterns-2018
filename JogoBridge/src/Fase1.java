
import interfaces.Fase;
import interfaces.IBackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Fase1 extends Fase {
    
    public Fase1 (IBackEnd backend){
        super(backend);
    }

    @Override
    public void useBackEnd() {
        System.out.println("Iniciou fase 1");
        backend.draw();
        backend.playSound();
        backend.action();
    }
}
