import java.util.Date;

public class Filme extends Evento{

    public Filme(String titulo, Date data, String local, double preco){
        super(titulo, data, local, preco, 200);
    }

}
