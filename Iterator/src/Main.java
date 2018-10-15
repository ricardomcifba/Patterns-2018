
import iterator.UseIterator;
import iterator.Sapato;
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
public class Main {
    
    public static void main (String[] args){
        
        Sapato s1 = new Sapato("Kildare", 30);
        Sapato s2 = new Sapato("Adidas", 31);
        Sapato s3 = new Sapato("Topper", 32);
        Sapato s4 = new Sapato("Penalty", 30);
        Sapato s5 = new Sapato("XXX", 34);
        
        ArrayList <Sapato> sapatos = new ArrayList<Sapato>();
        
        sapatos.add(s1);
        sapatos.add(s2);
        sapatos.add(s3);
        sapatos.add(s4);
        sapatos.add(s5);
        
        
        UseIterator it = new UseIterator(sapatos, "getValor", ">", 29 ); 
       
       for (it.first();it.hasNext();it.next()){
           //implementar método compare(Object)
           System.out.println(it.next());
       }
        
    }
    
}
