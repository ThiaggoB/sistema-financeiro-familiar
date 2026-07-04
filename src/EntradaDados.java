import java.util.Scanner;

public class EntradaDados {
    public Usuario obterDados() {
        Scanner sc = new Scanner(System.in);
        Usuario usuario;
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

        System.out.print("Digite seu salario: ");
        double salario = sc.nextDouble(); sc.nextLine();

        System.out.print("Deseja digitar despesas inicias? (s/n): ");
        String SimOuNao = sc.nextLine();
        if(SimOuNao.equals("s")) {
            System.out.print("Digite sua despesa: ");
            double despesas = sc.nextDouble();
            usuario = new Usuario(nome, sobrenome, idade, genero, salario, despesas);
        } else {
            usuario = new Usuario(nome, sobrenome, idade, genero, salario);
        }


        sc.close();

        return usuario;
    }
}

