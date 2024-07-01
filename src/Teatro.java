import java.util.Date;

public class Teatro extends Evento{

    public Teatro(String peca, Date data, String local, double preco){
        super(peca, data, local, preco, 250);
    }

    public int dispMeia(){
        int contador = 0;

        for (int i = 0; i < this.ingressos.length; i++){
            if (this.ingressos[i].getClass() == IMeia.class) contador++;
        }

        return (int) ((250 * 0.2) - contador);
    }
}
