/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import interfaces.Iterator;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class UseIterator <T> implements Iterator{

    private List<?> objeto;
    private String op;
    private String propriedade;
    private Object valor;
    private int position;
    //private ArrayList<String[]> criterios;    
    public UseIterator(List<?> objeto, String op, String propriedade,  Object valor) {
        
        this.objeto = objeto;
        this.op = op;
        this.propriedade = propriedade;
        this.valor = valor;
        this.position = 0;
    }
    
//    public void iteratorMPPM(Collection<?> c, String prop, String op, int valor){
//            
//    }

    @Override
    public boolean hasNext() {
        if( position >= objeto.size()) {
            return false;
            
	}
        return true;
    }

    @Override
    public Object next() {
     
        if(!compare(objeto.get(position) )){// retornar a propriedade do objeto
            return null;
        }              
        return objeto.get(position);
       
    }
    
    public void first(){
        if(objeto.isEmpty())
            return;
        next();
    }
    
       
    public boolean compare(Object obj){
        
        if(op == "==")
            return obj == valor;
        
        if(op == "!=")
            return obj != valor;
            
//        if(op == ">")
//            return objeto.toArray()[position] > obj;
//            
//        if(op == "<")
//            return objeto.toArray()[position] < obj;
            
        return false;
    } 
    
}
