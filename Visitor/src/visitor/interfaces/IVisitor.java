/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.interfaces;

import visitor.concretos.Aluno;
import visitor.concretos.Professor;

/**
 *
 * @author aluno
 */
public interface IVisitor {
    
    public void visitorAluno(Aluno a);
    public void visitorProfessor(Professor p);
    
}
