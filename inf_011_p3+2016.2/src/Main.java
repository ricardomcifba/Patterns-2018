
import interfaces.ICliente;


public class Main {
    
    public static void main (String[] args){
        ICliente cliente1 = new ClientePessoaFisica();
        cliente1.setEndereco("Rua tal");
        cliente1.setTelefone("1111-2222");
        cliente1.setCNPJ("123.123.123/0001-11");
        cliente1.save(); 
        cliente1.notifyObservers();
        
    }
}
