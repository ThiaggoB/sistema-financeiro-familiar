package view;

import entities.Despesa;
import entities.Historico;
import entities.Meta;
import entities.Usuario;
import services.AnaliseFinanceira;
import services.GerenciadorListas;

public class Menu {
    private final Usuario usuario;
    private final EntradaDados entrada;
    private final Saida saida;
    private final AnaliseFinanceira analise;
    private final Historico historico;
    private final GerenciadorListas gerenciador;

    public Menu(Usuario usuario, EntradaDados entrada, AnaliseFinanceira analise, Saida saida, Historico historico, GerenciadorListas gerenciador) {
        this.usuario = usuario;
        this.entrada = entrada;
        this.analise = analise;
        this.saida = saida;
        this.historico = historico;
        this.gerenciador = gerenciador;
    }

    public void executar() {
        int opcaoPrincipal;
        do {
            System.out.println("=========================");
            System.out.println("          MENU           ");
            System.out.println("=========================");
            System.out.println("1 - Perfil");
            System.out.println("2 - Despesas");
            System.out.println("3 - Metas");
            System.out.println("4 - Relatório");
            System.out.println("5 - Analise Financeira");
            System.out.println("6 - exibir Histórico");
            System.out.println("7 - Atualizar Sistema");
            System.out.println("0 - Sair");
            opcaoPrincipal = entrada.obterOpcao();

            switch (opcaoPrincipal) {
                case 0 -> System.out.println("Sistema encerrado com sucesso." + "\n" + "Até logo!");
                case 1 -> menuPerfil();
                case 2 -> menuDespesa();
                case 3 -> menuMeta();
                case 4 -> menuRelatorio();
                case 5 -> menuAnalise();
                case 6 -> menuHistorico();
                case 7 -> gerenciador.atualizarDespesa();
                case 8 -> gerenciador.atualizarMeta();
                default -> System.out.println("Opção inválida");
            }
        } while (opcaoPrincipal != 0);
    }

    private void menuPerfil() {
            int opcaoPerfil;
            do {
                saida.mostrarUsuario(usuario);
                System.out.println("0 - Voltar");
                opcaoPerfil = entrada.obterOpcao();
            } while (opcaoPerfil != 0);
    }

    private void menuDespesa() {
        int opcaoDespesa;
        do {
            System.out.println("=========================");
            System.out.println("        Despesas         ");
            System.out.println("=========================");
            System.out.println("1 - Listar");
            System.out.println("2 - Adicionar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Cancelar");
            System.out.println("0 - Voltar");
            opcaoDespesa = entrada.obterOpcao();
            switch (opcaoDespesa) {
                case 0 -> System.out.print("Voltando ao Menu Principal");
                case 1 -> {
                    saida.mostrarDespesas(usuario);
                    entrada.pause();
                }
                case 2 -> {
                    Despesa despesa = entrada.obterDespesa();
                    usuario.adicionarDespesa(despesa);
                    saida.mostrarDespesas(usuario);
                    entrada.pause();
                }
                case 3 -> {
                    if (usuario.getDespesas().size() == 0) {
                        System.out.println("Não há despesas cadastradas.");
                        entrada.pause();
                    } else {
                        saida.mostrarDespesas(usuario);
                        System.out.print("Qual despesa deseja remover? ");
                        int indice = entrada.obterIndice();
                        indice--;
                        usuario.removerDespesas(indice);
                        saida.mostrarDespesas(usuario);
                        entrada.pause();
                    }
                }
                case 4 -> {
                    if (usuario.getDespesas().size() == 0) {
                        System.out.println("Não há despesas cadastradas.");
                        entrada.pause();
                    } else {
                        saida.mostrarDespesas(usuario);
                        System.out.print("Qual despesa deseja alterar? ");
                        int indiceAlterar = entrada.obterIndice();
                        indiceAlterar--;
                        Despesa despesa = usuario.getDespesas().get(indiceAlterar);
                        System.out.println("Novo valor: ");
                        double novoValor = entrada.obterValor();
                        despesa.alterarValorDespesa(novoValor);
                        saida.mostrarDespesas(usuario);
                        entrada.pause();
                    }
                }
                case 5 -> {
                    if (usuario.getDespesas().size() == 0) {
                        System.out.println("Não há despesas cadastradas.");
                        entrada.pause();
                    } else {
                    saida.mostrarDespesas(usuario);
                    System.out.print("Qual despesa deseja cancelar? ");
                    int indiceCancelar = entrada.obterIndice();
                    indiceCancelar--;
                    Despesa despesa = usuario.getDespesas().get(indiceCancelar);
                    despesa.cancelar();
                    gerenciador.moverCanceladaDespesa(indiceCancelar);
                    entrada.pause();
                    }
                }
                default -> System.out.println("Opção inválida");
            }

        } while (opcaoDespesa != 0);
    }

    private void menuMeta()  {
            int opcaoMeta;
            do {
                System.out.println("=========================");
                System.out.println("           Metas         ");
                System.out.println("=========================");
                System.out.println("1 - Listar");
                System.out.println("2 - Adicionar");
                System.out.println("3 - Remover");
                System.out.println("4 - Guardar Valor na meta");
                System.out.println("5 - Alterar Valor da meta");
                System.out.println("6 - Cancelar");
                System.out.println("0 - Voltar");
                opcaoMeta = entrada.obterOpcao();

                switch (opcaoMeta) {
                    case 0 ->
                        System.out.println("Voltando ao Menu Principal");

                    case 1 -> {
                        saida.mostrarMetas(usuario);
                        entrada.pause();
                    }

                    case 2 -> {
                        Meta meta = entrada.obterMeta();
                        usuario.adicionarMeta(meta);
                        saida.mostrarMetas(usuario);
                        entrada.pause();
                    }

                    case 3 -> {
                        if (usuario.getMetas().size() == 0) {
                            System.out.print("Não há metas cadastradas.");
                            entrada.pause();
                        }else {
                            saida.mostrarMetas(usuario);
                            System.out.print("Qual meta deseja remover: ");
                            int indice = entrada.obterIndice();
                            indice--;
                            usuario.removerMetas(indice);
                            saida.mostrarMetas(usuario);
                            entrada.pause();
                        }
                    }

                    case 4 -> {
                        if (usuario.getMetas().size() == 0) {
                            System.out.println("Não há metas cadastradas.");
                            entrada.pause();
                        }else {
                            saida.mostrarMetas(usuario);
                            System.out.print("Deseja guardar valor em qual meta? ");

                            int indiceGuardar = entrada.obterIndice();
                            indiceGuardar--;
                            Meta meta = usuario.getMetas().get(indiceGuardar);
                            System.out.print("Valor guardado: ");
                            double valorAdicionado = entrada.obterValor();
                            meta.adicionarValorGuardado(valorAdicionado);
                            gerenciador.atualizarMeta();
                            saida.mostrarMetas(usuario);
                            entrada.pause();
                        }

                    }

                    case 5 -> {
                        saida.mostrarMetas(usuario);
                        System.out.print("Deseja alterar valor de qual meta? ");
                        int indiceAlterar = entrada.obterIndice();
                        indiceAlterar--;
                        Meta meta = usuario.getMetas().get((indiceAlterar));
                        System.out.print("Indique o novo valor: ");
                        double novoValor = entrada.obterValor();
                        meta.alterarValorObjeto(novoValor);
                        gerenciador.atualizarMeta();
                    }
                    case 6 -> {
                        if (usuario.getMetas().size() == 0) {
                            System.out.println("Não há metas cadastradas.");
                            entrada.pause();
                        } else {
                            saida.mostrarMetas(usuario);
                            System.out.print("Qual despesa meta cancelar? ");
                            int indiceCancelar = entrada.obterIndice();
                            indiceCancelar--;
                            Meta meta = usuario.getMetas().get(indiceCancelar);
                            meta.cancelar();
                            gerenciador.moverCanceladaMeta(indiceCancelar);
                            entrada.pause();
                        }
                    }
                    default -> System.out.println("Opção inválida");
                }

            }while (opcaoMeta != 0);
    }

    private void menuRelatorio() {
        int opcaoRelatorio;
        do {
            saida.mostrarFinancas(usuario);
            System.out.println("0 - Voltar");
            opcaoRelatorio = entrada.obterOpcao();
        } while (opcaoRelatorio != 0);

    }

    private void menuAnalise() {
        int opcaoAnalise;
        do {
            saida.mostrarAnalise(usuario, analise);
            System.out.println("0 - Voltar");
            opcaoAnalise = entrada.obterOpcao();
        }while (opcaoAnalise != 0);
    }

    private void menuHistorico() {
        int opcaoHistorico;

        do {
            System.out.println("0 - Voltar");
            System.out.println("1 - Histórico de Despesas");
            System.out.println("2 - Histórico de Metas");
            opcaoHistorico = entrada.obterOpcao();

            switch (opcaoHistorico) {
                case 0 -> System.out.println("Voltando ao Menu Principal");
                case 1 -> {
                    saida.mostrarHistoricoDespesa(historico);
                    entrada.pause();
                }
                case 2 -> {
                    saida.mostrarHistoricoMetas(historico);
                    entrada.pause();
                }
            }
        }while (opcaoHistorico != 0);

    }
}