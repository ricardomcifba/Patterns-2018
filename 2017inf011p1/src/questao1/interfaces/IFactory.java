/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1.interfaces;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 */
public interface IFactory {
                
    public void addPrototype( String nome, Object prototipo, int quantidadeMaxima );
    
    public IPneu create( String nomeProduto );
    
    
}
