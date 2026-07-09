import java.util.Scanner;


public class EntradaDados {
    private Scanner sc = new Scanner(System.in);

    public Usuario obterDados() {
         Usuario usuario = obterUsuario();
         obterDespesas(usuario);
         obterMetas(usuario);
        return usuario;
    }

    public Usuario obterUsuario() {
        System.out.println("========================================");
        System.out.println("           DADOS DO USUARIO             ");
        System.out.println("========================================");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        System.out.println("Escolha o gênero: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        System.out.println("3 - Outro");
        int genero = sc.nextInt();
        System.out.println("========================================");
        System.out.println("      DADOS FINANCEIROS DO USUARIO      ");
        System.out.println("========================================");
        System.out.print("Digite seu salario: ");
        double salario = sc.nextDouble(); sc.nextLine();
        Usuario usuario = new Usuario(nome, sobrenome, idade, genero, salario);
        return usuario;
    }


    public void obterDespesas(Usuario usuario) {
        System.out.print("Quantas despesas você quer adicionar? ");
        int qtdDespesas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdDespesas; i++) {
            System.out.println("Despesa #" + (i+1));
            System.out.print("Nome: ");

            String nomeDespesa = sc.nextLine();
            System.out.print("Valor: ");
            double valorDespesa = sc.nextDouble();
            sc.nextLine();
            Despesa despesa = new Despesa(nomeDespesa, valorDespesa);
            usuario.adicionarDespesa(despesa);
        }
    }

    public void obterMetas(Usuario usuario) {
        System.out.println("========================================");
        System.out.println("           METAS DO USUARIO             ");
        System.out.println("========================================");
        System.out.print("Quantas metas você quer adicionar? ");
        int qtdMetas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdMetas; i++) {
            System.out.println("Meta #" + (i+1));
            System.out.print("Nome: ");
            String nomeMeta = sc.nextLine();
            System.out.print("Valor: ");
            Double valorObjeto = sc.nextDouble();
            sc.nextLine();
            Meta meta = new Meta(nomeMeta, valorObjeto);
            usuario.adicionarMeta(meta);
        }
        sc.close();
    }

    }


