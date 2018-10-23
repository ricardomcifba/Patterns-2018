/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Main {

    public static void main(String[] args) {
        Inimigo inimigo1 = new UrsoInimigo("Urso"); // Ganha super-poderes atirando mel nos jogadores
        Inimigo inimigo2 = new PirataInimigo("Pirata"); // Ganha super-poderes atirando faca nos jogadores
        Player jogador1 = new Jogador("Jogador 1");
        Player jogador2 = new Jogador("Jogador 2");
        inimigo1.addSubscriber(jogador1);
        inimigo1.addSubscriber(jogador2);
        inimigo2.addSubscriber(jogador1);
        inimigo2.addSubscriber(jogador2);
        inimigo1.obterSuperPoderes(10); // Deve aparecer na tela:
        //-Obtendo super - poderes de 10 mels
                //- Jogador1 perseguindo inimigo1 com 10 mels
                //- Jogador2 perseguindo inimigo1 com 10 mels 
        inimigo2.obterSuperPoderes(20); // Deve aparecer na tela:
        //-Obtendo super - poderes de 20 facas
                //- Jogador1 perseguindo inimigo2 com 20 facas
                //- Jogador2 perseguindo inimigo2 com 20 facas
        
    }

}
