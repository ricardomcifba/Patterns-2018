
package observer;

import concetos.Professor;
import concetos.Aluno;

public class Observer {

    public static void main(String[] args) {
        Professor p1 = new Professor("Jowaner", "Gerência de Projetos", "Curso sobre Metodologias Ágeis");
        Professor p2 = new Professor("Pablo", "Banco de Dados", "Curso sobre Data Warehouse");
        p1.addObserver(new Aluno("Elis"));
        p1.addObserver(new Aluno("Ricardo"));
        p2.addObserver(new Aluno("Michele"));
        p2.addObserver(new Aluno("Fabricio"));

        //Modo Push
        System.out.println("Modo Push:");
        p1.notifyObservers(p1.getMsg());

        //Modo Pull
        System.out.println("\nModo Pull:");
        //Para alterar o estado
        p2.getMsg();
        p2.notifyObservers();
    }

}
