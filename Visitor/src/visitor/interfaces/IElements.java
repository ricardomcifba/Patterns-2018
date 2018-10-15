/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.interfaces;

/**
 *
 * @author aluno
 */
public interface IElements {
    
    public void accept(IVisitor visitor);
    
}
