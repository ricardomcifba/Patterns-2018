package pkg20171prova.Fabrica;

import java.util.ArrayList;
import pkg20171prova.Interfaces.IPneu;

public class Pneu implements IPneu {

    private static final ArrayList<Pneu> pneu = new ArrayList<Pneu>();
    private static int countPneu = 0;
    private static int maximo;

    public static void initialize(int valor) {
        maximo = valor;
    }

    public static synchronized Pneu getInstance() {

        Pneu instancia = null;

        if (maximo == pneu.size()) {
            instancia = pneu.get(countPneu % maximo);
        } else {
            instancia = new Pneu();
            pneu.add(instancia);
        }
        countPneu++;
        return instancia;
    }

    @Override
    public Pneu createPneu() {
        return new Pneu();
    }

}
