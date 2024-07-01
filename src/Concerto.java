import java.util.Date;

public class Concerto extends Evento{

    public Concerto(String nome, Date data, String local, double preco){
        super(nome, data, local, preco, 150);
    }

    public int dispVip(){
        int contador = 0;

        for (int i = 0; i < this.ingressos.length; i++){
            if (this.ingressos[i].getClass() == IVip.class) contador++;
        }

        return (int) ((250 * 0.1) - contador);
    }
}
