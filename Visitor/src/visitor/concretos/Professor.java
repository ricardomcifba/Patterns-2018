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
public class Professor implements IElements {

    public Professor(String nome, int pub) {
        this.nome = nome;
        this.pub = pub;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPub() {
        return pub;
    }

    public void setPub(int pub) {
        this.pub = pub;
    }

    private String nome;
    private int pub;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitorProfessor(this);
    }

}
