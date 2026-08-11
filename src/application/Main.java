package application;
import entities.Historico;
import entities.Usuario;
import services.AnaliseFinanceira;
import services.GerenciadorListas;
import view.EntradaDados;
import view.Menu;
import view.Saida;


public class Main {
    public static void main(String[]args) {
        EntradaDados entrada = new EntradaDados();;
        Usuario usuario = entrada.obterUsuario();
        Saida saida = new Saida();
        AnaliseFinanceira analise = new AnaliseFinanceira();
        Historico historico = new Historico();
        GerenciadorListas gerenciador = new GerenciadorListas(usuario, historico);
        gerenciador.atualizarDespesa();
        gerenciador.atualizarMeta();
        Menu menu = new Menu(usuario, entrada, analise, saida, historico, gerenciador);
        menu.executar();

    }
}