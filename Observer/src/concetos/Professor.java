/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concetos;

import java.util.Observable;

/**
 *
 * @author Aluno
 */
public class Professor extends Observable {
    private String nome;
    private String disciplina;
    private String msg;

    public Professor(String nome, String disciplina, String msg) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.msg = msg;
    }

    public String getMsg() {
        this.setChanged();
        return this.msg;
    }

    public String toString() {
        return nome + ": " + disciplina;
    }
}
