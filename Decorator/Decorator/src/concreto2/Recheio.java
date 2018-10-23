package concreto2;
import core.Decorator;

public class Recheio extends Decorator {

    @Override
    public void assar() {
        super.assar();
        System.out.println("Adicionou recheio.");

    }
}
