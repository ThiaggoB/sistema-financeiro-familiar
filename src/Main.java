<<<<<<< HEAD

public class Main {
    public static void main(String[]args) {
        EntradaDados entrada = new EntradaDados();;
        Usuario usuario = entrada.obterDados();
        AnaliseFinanceira analise = new AnaliseFinanceira();
        Saida saidaDados = new Saida();
        saidaDados.mostrarDados(usuario, analise);
    }
}

=======
import javax.print.DocFlavor;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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



//        SAIDA
        System.out.println("Nome: " + nomecompleto);
        System.out.println("Idade : " + idade);
        System.out.println("Salario : R$ " + salarioMensal);
        System.out.println("Despesas: R$ " + despesas);

        System.out.println("Salario restante: R$ " + saldo);
        System.out.println("Salario Anual: R$ " + salarioMensal * 12 );

        if (saldo > 1000) {
            System.out.println("Saldo em conta dentro da normalidade. Operações seguem sem restrições ou riscos iminentes. R$ " + saldo);
        } else if (saldo >= 200) {
            System.out.println("Atenção: O saldo em conta está reduzindo. Recomenda-se monitorar os próximos custos ou repor fundos em breve para evitar interrupções. R$ " + saldo);
        } else {
            System.out.println("⚠️ Risco crítico: Saldo em conta insuficiente ou próximo ao esgotamento. Ação imediata necessária para evitar falhas nas transações. R$ " + saldo);
        }
        scanner.close();
    }
}
>>>>>>> 7cfb0262d99e5c9b089909112c714a72b5945b02
