
import interfaces.IStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
class MyClient {

    public MyClient() {
        
    }
    
    private IStrategy sorter;
    
    public void setSortStrategy(IStrategy strategy){
        sorter = strategy;
    }

    public void sort(){
        System.out.println("Ordenado com o " + sorter.ordenar());
    }
}
