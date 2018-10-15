/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.concretos;

import java.util.ArrayList;
import visitor.concretos.Professor;
import visitor.interfaces.IElements;
import visitor.interfaces.IVisitor;
import visitor.interfaces.IVisitor;

/**
 *
 * @author aluno
 */
class VisitorMediaPublicacoes implements IVisitor {

    public VisitorMediaPublicacoes() {
        this.totalPubProfessor = 0;
        this.qtdProfessor = 0;
    }

    private double totalPubProfessor;
    private int qtdProfessor;

    @Override
    public void visitorAluno(Aluno a) {

    }

    @Override
    public void visitorProfessor(Professor p) {
        totalPubProfessor += p.getPub();
        qtdProfessor++;
    }

    public double mediaPub() {
        return ((totalPubProfessor) / (qtdProfessor));
    }

}
