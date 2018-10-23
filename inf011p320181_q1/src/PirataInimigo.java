
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class PirataInimigo extends Inimigo {
    
    private String nome;
    
    public PirataInimigo(String nome) {
        super(nome);
    }


    @Override
    public void obterSuperPoderes(int i) {
        System.out.println("Obetendo supor poderes de "+ i +" facas.");
    }


 
}
