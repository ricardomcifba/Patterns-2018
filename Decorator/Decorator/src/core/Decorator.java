package core;
import interfaces.IComponents;

public abstract class Decorator implements IComponents {

    IComponents component;
    
    public void assar() {
        component.assar();
    }
    
    public void setIComponents(IComponents component){
        this.component = component;
    }
    
}

