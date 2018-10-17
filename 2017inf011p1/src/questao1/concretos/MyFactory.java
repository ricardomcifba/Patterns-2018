/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1.concretos;

import questao1.interfaces.IFactory;
import java.util.ArrayList;
import java.util.HashMap;
import questao1.interfaces.IPneu;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 */
public class MyFactory implements IFactory {
    
    private static IFactory singleton = null;
    
    private HashMap<String, Object> listaPrototipos = new HashMap<String, Object>();
    
    private HashMap<String, Integer> numeroMaximoPrototipo = new HashMap<String, Integer>();
    
    private HashMap<String, Integer> contagemAtual = new HashMap<String, Integer>();
    
    private ArrayList<Object> prototipos = new ArrayList<Object>();

    public static IFactory getInstance() {
        
        if( singleton == null  ) {
        
            singleton = new MyFactory();
            
        }
        
        return singleton;
        
    }
    
    private MyFactory() {
    
        //Operacoes de Inicializaçao vem aqui.
        
    }

    @Override
    public void addPrototype( String nome, Object prototipo, int quantidadeMaxima ) {
        
        this.listaPrototipos.put( nome, prototipo );
        this.numeroMaximoPrototipo.put( nome, quantidadeMaxima );
        this.contagemAtual.put( nome, 0 );
        
    }

    @Override
    public IPneu create( String nomeProduto ) {
        
        Object created = null;
         
        if ( this.listaPrototipos.containsKey( nomeProduto ) == true ) {
            
            if( this.contagemAtual.get( nomeProduto ) < this.numeroMaximoPrototipo.get( nomeProduto ) ) {
            
                created = new Pneu();
                
                this.prototipos.add( created );
                
                this.contagemAtual.put( nomeProduto , this.contagemAtual.get( nomeProduto ) + 1 );

            }
            
            else {
                
                created = this.prototipos.get( this.contagemAtual.get( nomeProduto ) % this.prototipos.size() );
                
                this.contagemAtual.put( nomeProduto , this.contagemAtual.get( nomeProduto ) + 1 );
            
            }
            
        
        }
        
        //Cast para a questao em especifico
        return ( IPneu ) created;
        
    }

    
}
