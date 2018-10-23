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
     
        MyClient cliente = new MyClient();
        cliente.setSortStrategy(new QuickSort());
        cliente.sort(); // Exibe na tela: “ordenando com o QuickSort”
        cliente.setSortStrategy(new MergeSort());
        cliente.sort(); // Exibe na tela: “ordenando com o MergeSort”
    }

}
