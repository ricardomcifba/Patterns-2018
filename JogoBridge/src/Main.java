/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import interfaces.Fase;
import BackEnds.BE1;
import BackEnds.BE2;

/**
 *
 * @author Aluno
 */
public class Main {
    
    public static void main(String[] args) {
        
        Fase fase1 = new Fase1(new BE1());
        fase1.useBackEnd();
        
        Fase fase2 = new Fase2(new BE2());
        fase2.useBackEnd();
        
        Fase fase1Extra = new Fase1(new BE2());
        fase1Extra.useBackEnd();        
    }
    
    
}
