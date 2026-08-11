package view;

import entities.*;
import entities.enums.CategoriaDespesa;
import entities.DespesaUnica;
import entities.Frequencia;
import entities.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class EntradaDados {
    private Scanner sc = new Scanner(System.in);

    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Genero obterGenero() {
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        System.out.println("3 - Outro");
        System.out.print("Escolha uma opcão: ");
        int opcao = sc.nextInt();

        return switch (opcao) {
            case 1 -> Genero.MASCULINO;
            case 2 -> Genero.FEMININO;
            case 3 -> Genero.OUTRO;
            default -> null;
        };
    }

    public Frequencia obterFrequencia() {
        System.out.println("1 - Diária");
        System.out.println("2 - Semanal");
        System.out.println("3 - Mensal");
        System.out.println("4 - Anual");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt(); sc.nextLine();

        return switch (opcao) {
            case 1 -> Frequencia.DIARIA;
            case 2 -> Frequencia.SEMANAL;
            case 3 -> Frequencia.MENSAL;
            case 4 -> Frequencia.ANUAL;
            default -> null;
        };
    }

    public CategoriaDespesa obterCategoria() {
        System.out.println("Categoria de Despesas:");
        System.out.println("1 - Alimentação");
        System.out.println("2 - Moradia");
        System.out.println("3 - Transporte");
        System.out.println("4 - Saúde");
        System.out.println("5 - Conta");
        System.out.println("6 - Educação");
        System.out.println("7 - Lazer");
        System.out.println("8 - Outros");

        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt(); sc.nextLine();

        return switch (opcao) {
            case 1 -> CategoriaDespesa.ALIMENTACAO;
            case 2 -> CategoriaDespesa.MORADIA;
            case 3 -> CategoriaDespesa.TRANSPORTE;
            case 4 -> CategoriaDespesa.SAUDE;
            case 5 -> CategoriaDespesa.CONTAS;
            case 6 -> CategoriaDespesa.EDUCACAO;
            case 7 -> CategoriaDespesa.LAZER;
            case 8 -> CategoriaDespesa.OUTROS;
            default -> null;
        };
    }


    public Usuario obterUsuario() {
        System.out.println("========================================");
        System.out.println("           DADOS DO USUARIO             ");
        System.out.println("========================================");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.print("Digite sua data de Nascimento: ");
        LocalDate dataNascimento = LocalDate.parse(sc.next(), date);
        Genero genero = obterGenero();
        System.out.print("Digite seu salario: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        return new Usuario(nome, sobrenome, dataNascimento, genero, salario);
    }

    public Despesa obterDespesa() {

        System.out.println("========================");
        System.out.println("      Nova despesa      ");
        System.out.println("========================");
        System.out.print("Nome: ");
        String nomeDespesa = sc.nextLine();
        CategoriaDespesa categoriaDespesa = obterCategoria();
        System.out.print("Valor: ");
        double valorDespesa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Data: ");
        LocalDate dataDespesas = LocalDate.parse(sc.nextLine(), date);

        System.out.println("Tipos de Despesa:");
        System.out.println("1 - Recorrente");
        System.out.println("2 - Temporaria");
        System.out.println("3 - Unica");

        System.out.print("Escolha uma opção: ");
        int tipoDespesa = sc.nextInt(); sc.nextLine();

        switch (tipoDespesa) {
            case 1 -> {
                Frequencia frequencia = obterFrequencia();
                return new DespesaRecorrente(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas, frequencia);
            }
            case 2 -> {
                System.out.print("Informe a quantidade de parcelas: ");
                int quantidadeParcelas = sc.nextInt(); sc.nextLine();
                Frequencia frequencia = obterFrequencia();
                return new DespesaTemporaria(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas, quantidadeParcelas, frequencia);
            }
            case 3 ->{
                return new DespesaUnica(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas);
            }
            default -> {
               return null;
            }
        }
    }


    public Meta obterMeta() {
        System.out.println("========================================");
        System.out.println("           METAS DO USUARIO             ");
        System.out.println("========================================");

        System.out.print("Nome: ");
        String nomeMeta = sc.nextLine();
        System.out.print("Valor: ");
        Double valorObjeto = sc.nextDouble();
        sc.nextLine();
        return new Meta(nomeMeta, valorObjeto);
    }

    public int obterIndice() {
        int indice = sc.nextInt();
        sc.nextLine();
        return indice;
    }

    public int obterOpcao() {
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public double obterValor() {
        double novoValor = sc.nextDouble();
        sc.nextLine();
        return novoValor;
    }

    public void pause() {
        System.out.print("Pressione ENTER para continuar");
        sc.nextLine();
    }
}









