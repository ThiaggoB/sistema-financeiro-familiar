import java.util.Scanner;

public class EntradaeSaidadedados {
    public static void main(String[ ]args) {
        Scanner scanner = new Scanner(System.in);
//       ENTRADA

        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        String nomecompleto = nome.concat(" ").concat(sobrenome);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite seu salario: ");
        double salarioMensal = scanner.nextDouble();

        System.out.print("Digite o valor de suas despesas: ");
        double despesas = scanner.nextDouble();

        double saldo = salarioMensal - despesas;
    }

    }
