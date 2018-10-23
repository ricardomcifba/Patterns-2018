
import interfaces.ICliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class ClientePessoaFisica extends ICliente{
    
    public ClientePessoaFisica() {
        super();
    }

    @Override
    public void save() {
        System.out.println("Cliente salvo com sucesso;");
    }

    @Override
    public void notifyObservers() {
        
    }

    @Override
    protected void coisa() {
        System.out.println("Feito alguma coisa");
    }


    
}
