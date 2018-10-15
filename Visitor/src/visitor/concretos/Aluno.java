/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.concretos;

import visitor.interfaces.IElements;
import visitor.interfaces.IVisitor;

/**
 *
 * @author aluno
 */
public class Aluno implements IElements {

    public Aluno(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    private String nome;
    private float nota;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitorAluno(this);
    }

}
