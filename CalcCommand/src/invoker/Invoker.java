package invoker;

import interfaces.ICommand;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e127787
 */
public class Invoker {

    private ArrayList<ICommand> redoCommand = new ArrayList<ICommand>();
    private int position;
    
    public Invoker(){
        this.position = -1;
    }

    public void execute(ICommand c) {
        
        redoCommand.add(c);
        c.redo();
        ++position;
        System.out.println("Redo:" + c.toString() + "\tPosicao:" + position );
        
    }

    public void unexecute() {
        
        System.out.println("Undo1:" + redoCommand.get(position) + "\tPosicao:" + position );

        if(redoCommand.isEmpty() == false && position >= 0){
            position--;
            redoCommand.get(position).undo();
            
        }
        
        System.out.println("Undo2:" + redoCommand.get(position) + "\tPosicao:" + position );

    }

}
