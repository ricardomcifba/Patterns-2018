/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.concretos;

import java.util.ArrayList;
import java.util.List;
import visitor.concretos.*;
import visitor.concretos.Aluno;
import visitor.concretos.Professor;
import visitor.interfaces.IElements;
import visitor.interfaces.IVisitor;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<IVisitor> visitors = new ArrayList<IVisitor>();
        List<IElements> pessoas = new ArrayList<IElements>();

        VisitorMediaPublicacoes medPublicacoes = new VisitorMediaPublicacoes();
        VisitorMediaNota medNota = new VisitorMediaNota();

        visitors.add(medPublicacoes);
        visitors.add(medNota);

        pessoas.add(new Aluno("Rick", 9.8f));
        pessoas.add(new Aluno("Liandro", 9.9f));
        pessoas.add(new Aluno("Paulo", 10));
        pessoas.add(new Professor("Sandro", 5));
        pessoas.add(new Professor("Jowaner", 7));

        for (IVisitor v : visitors) {
            for (IElements e : pessoas) {
                e.accept(v);
            }
        }
        
        System.out.println(medPublicacoes.mediaPub());
        System.out.println(medNota.mediaNota());

    }
    
}
