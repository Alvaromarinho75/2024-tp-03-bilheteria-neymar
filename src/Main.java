import jdk.jfr.internal.EventWriterMethod;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static Evento[] eventos = new Evento[3];

    public static boolean menuInicial(){
        // Caixa de Opções
        Object[] options = {"Criar um evento", "Participar de um evento", "Exibir receita", "Exibir detalhes"};
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "NJ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch(escolha){
            case 0:
                Evento novoEvento = null;
                Date dataAux;
                Double precoAux;
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Object[] optionsT = {"Filme", "Concerto", "Teatro"};

                int escolhaT = JOptionPane.showOptionDialog(null, "Qual o tipo do evento?", "NJ",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsT, optionsT[0]);

                String entradaN = JOptionPane.showInputDialog("Digite o nome do evento:");

                if(entradaN == null) return true;
                if (!entradaN.isEmpty()) {
                    String entradaD = JOptionPane.showInputDialog("Digite a data do evento: (dd/MM/yyyy)");

                    if(entradaD == null) return true;
                    if (!entradaD.isEmpty()) {
                        try {
                            dataAux = formato.parse(entradaD);
                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, "Formato de data invalido!");
                            break;
                        }

                        String entradaL = JOptionPane.showInputDialog("Digite o local do evento:");

                        if(entradaL == null) return true;
                        if (!entradaL.isEmpty()) {

                            String entradaP = JOptionPane.showInputDialog("Qual sera o preco dos ingressos?");

                            if(entradaP == null) return true;
                            if(!entradaP.isEmpty()) {
                                precoAux = Double.parseDouble(entradaP);

                                switch(escolhaT){
                                    case 0:
                                        novoEvento = new Filme(entradaN, dataAux, entradaL, precoAux);
                                        break;

                                    case 1:
                                        novoEvento = new Concerto(entradaN, dataAux, entradaL, precoAux);
                                        break;

                                    case 2:
                                        novoEvento = new Teatro(entradaN, dataAux, entradaL, precoAux);
                                        break;
                                }

                                if(novoEvento != null) {
                                    adicionarEvento(novoEvento);
                                    JOptionPane.showMessageDialog(null, "Evento criado com sucesso!");
                                }
                                    else JOptionPane.showMessageDialog(null, "Erro ao criar evento!");

                            } else JOptionPane.showMessageDialog(null, "Preco invalido!");
                        } else JOptionPane.showMessageDialog(null, "Local invalido!");
                    }  else JOptionPane.showMessageDialog(null, "Data invalida!");
                } else JOptionPane.showMessageDialog(null, "Nome invalido!");

                break;

            case 1:
                // a ser implementado
            break;

            case 2:
                // a ser implementado
                break;

            case 3:
                // a ser implementado
                break;

            case 4:
                // a ser implementado
                break;

            default:
                return true;
        }
        return false;
    }

    public static void adicionarEvento(Evento novoEvento) {
        int tamanhoAtual = eventos.length;
        boolean adicionado = false;

        for (int i = 0; i < tamanhoAtual; i++) {
            if (eventos[i] == null) {
                eventos[i] = novoEvento;
                adicionado = true;
                break;
            }
        }

        if (!adicionado) {
            eventos = (Evento[]) Evento.expande(eventos);
            eventos[tamanhoAtual] = novoEvento;
        }
    }

    public static void main(String[] args) {
        boolean sair = false;

        JOptionPane.showMessageDialog(null, "Seja bem-vindo a bilheteria NJ!");

        while(!sair){
            sair = menuInicial();
        }
    }
}
