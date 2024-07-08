import java.util.Date;

public abstract class Evento {

    private String nome;
    private Date Data;
    private String local;
    private double precoIngresso;
    private static int quantidadeIngresso = 0;
    protected Ingresso[] ingressos;

    public Evento(String nome, Date Data, String local, double precoIngresso, int maxIngressos) {
        this.nome = nome;
        this.Data = Data;
        this.local = local;
        this.precoIngresso = precoIngresso;

        this.ingressos = new Ingresso[maxIngressos];
    }

    public int dispIngresso() {
        int contador = 0;

        for (int i = 0; i < ingressos.length; i++) {
            if (ingressos[i] == null) contador++;
        }

        return contador;
    }

    public void compraIngresso(int valor) {
        this.ingressos[quantidadeIngresso] = null;
    }

    public static Object[] expande(Object[] array){
        Object[] aux = new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
        }

        array = aux;

        return array;
    }
}
