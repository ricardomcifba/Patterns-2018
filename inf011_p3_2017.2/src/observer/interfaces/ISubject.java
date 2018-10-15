
package observer.interfaces;

/**
 *
 * A interface de ISubject do padrão Observer
 * 
 * A mudança do nome do método se deu a conflitos
 * com um já existente no JAVA
 * 
 */
public interface ISubject {
    
    public void addObserver( IObserver observer );
    
    public void remove(IObserver observer);

    //Devido a conflitos com os métodos em JAVA, o nome foi modificado para notifyObserver
    public void notifyObserver();
    
    public void undo();
    
    public void redo() ;
    
}
