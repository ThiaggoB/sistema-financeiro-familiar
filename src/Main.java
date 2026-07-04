
public class Main {
    public static void main(String[]args) {
        EntradaDados entrada = new EntradaDados();;
        Usuario usuario = entrada.obterDados();
        AnaliseFinanceira analise = new AnaliseFinanceira();
        Saida saidaDados = new Saida();
        saidaDados.mostrarDados(usuario, analise);
    }
}

