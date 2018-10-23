
import java.util.Observable;
import java.util.Observer;
import javafx.beans.InvalidationListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aluno
 */
public class Jogador extends Player implements Observer{

    private String nome;
    
    public Jogador(String nome) {
        super(nome);
    }
    

    @Override
    public void update(Observable o, Object arg) {
    if (Inimigo.class.isInstance(o)) {
            if (arg != null) {
                System.out.println("Jogador" + this.nome + "perseguindo" + (Inimigo) o + (String) arg );
            } 
            else {
                System.out.println("Aluno:" + this.nome + "\nNotificado por: " + (Inimigo) arg);
            }
        }
    }





}
