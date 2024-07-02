import javax.swing.*;


public class Main {

    public static Evento[] eventos = new Evento[3];

    public static void menuInicial(){
        // Caixa de Opções
        Object[] options = {"Criar um evento", "Participar de um evento", "Exibir receita", "Exibir detalhes"};
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "NJ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch(escolha){
            case 0:
            break;

            case 1:
                for(Evento evento : eventos);
            break;
        }
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Seja bem-vindo a bilheteria NJ!");

        menuInicial();
    }
}
