/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2017.pkg1;

import interfaces.IMotor;


public class Prova20171 {

    
    public static void main(String[] args) {
        
        MyFactory f = MyFactory.getInstance(4,3,2);
        
        IMotor m1 = f.createMotor();
        IMotor m2 = f.createMotor();
        IMotor m3 = f.createMotor();
        IMotor m4 = f.createMotor();
    
}
