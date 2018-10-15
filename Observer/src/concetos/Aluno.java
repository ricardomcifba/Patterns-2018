package concetos;

import java.util.Observable;
import java.util.Observer;

public class Aluno implements Observer {
    private String nome;
    
    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        if (Professor.class.isInstance(arg0)) {
            if (arg1 != null) {
                System.out.println("Aluno:" + this.nome + "\nNotificado por: " + (Professor) arg0 + "\nMensagem: " + (String) arg1 + "\n---------------------------------------------------------------");
            } 
            else {
                System.out.println("Aluno:" + this.nome + "\nNotificado por: " + (Professor) arg0 + "\n---------------------------------------------------------------");
            }
        }
    }

}
