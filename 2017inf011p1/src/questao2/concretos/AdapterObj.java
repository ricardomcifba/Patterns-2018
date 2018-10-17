/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.concretos;
import questao2.interfaces.Target;

/**
 *
 * @author Paulo Ricardo Miranda Fontes
 */
public class AdapterObj implements Target{
    
    private Adaptee adaptee;

    public AdapterObj( Adaptee adaptee ) {
    
        this.setAdaptee( adaptee );
        
    }

    @Override
    public boolean play( String nomeDoArquivo, int velocidade ) {
        
        //Basicamente, se nenhum dos metodos da classe Adaptee lançar uma Exception
        //ele conseguiu executar o arquivo
        
        this.adaptee.abrirArquivo( nomeDoArquivo );
        this.adaptee.setVelocidade( velocidade );
        this.adaptee.play();

        return true;
        
    }
    
    
    private void setAdaptee( Adaptee adaptee ) {
        
        this.adaptee = adaptee;
        
    }
}
