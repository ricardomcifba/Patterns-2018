/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.concretos;

import java.util.ArrayList;
import visitor.concretos.Aluno;
import visitor.interfaces.IVisitor;
import visitor.interfaces.IVisitor;

/**
 *
 * @author aluno
 */
class VisitorMediaNota implements IVisitor {

    public VisitorMediaNota() {
        this.totalNotaAluno = 0;
        this.qtdAluno = 0;
    }

    private double totalNotaAluno;
    private int qtdAluno;

    @Override
    public void visitorAluno(Aluno a) {
        totalNotaAluno += a.getNota();
        qtdAluno++;
    }

    @Override
    public void visitorProfessor(Professor p) {

    }

    public double mediaNota() {
        return ((totalNotaAluno) / (qtdAluno));
    }

}
