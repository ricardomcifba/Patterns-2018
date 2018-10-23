
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aluno
 */
public abstract class Inimigo extends Observable {

    private String nome;

    private ArrayList<Player> players = new ArrayList<Player>();
    
    public Inimigo(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void obterSuperPoderes(int i);

    public void addSubscriber(Player jogador1) {
        players.add(jogador1);
    }

    public void notifyObserver() {
        for (int i = 0; i < players.size(); i++) {
            this.players.get(i).update(this, players.get(i));
        }
    }
}
