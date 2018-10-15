/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiver;

/**
 *
 * @author e127787
 */
public class Calculadora {
    
    private int total;
    private int valor;

    public Calculadora() {
        this.setTotal(0);
        this.setValor(0);
    }

    public void setTotal(int total) {
        this.total = total;
    }
  
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int getTotal() {
        return total;
    }

    public int getValor() {
        return valor;
    }

    public void somar( int valor ) {
        this.total += valor;
    };
    
    public void subtrair( int valor ) {
        this.total -= valor;
    };
    
    public void multiplicar(int valor){
        this.total *= valor;
    }
    
        public void dividir(int valor){
        this.total /= (double) valor;
    }
}
