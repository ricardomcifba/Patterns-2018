package interfaces;


import interfaces.IBackEnd;



/**
 *
 * @author Aluno
 */
public abstract class Fase {
    
    protected IBackEnd backend;
    
    public Fase(IBackEnd backend){
        this.backend = backend;                
    }
    
    public abstract void useBackEnd();
    
}
