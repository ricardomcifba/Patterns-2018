package interfaces;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public abstract class ICliente { 
    
    private ArrayList<Subject> clientes = new ArrayList<Subject>();
    private String endereco;
    private String telefone;
    private String cnpj;
    
     public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void save(){
        
        this.notifyObservers();
        
    }
 
    public void notifyObservers(){
        for(int i = 0; i < clientes.size();i++){
            
        }
    }
    
    protected abstract void coisa();
    
}
