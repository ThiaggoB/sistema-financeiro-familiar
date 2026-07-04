public class Saida {
    public void mostrarDados(Usuario usuario, AnaliseFinanceira analise) {
        System.out.println("Nome: " + usuario.getNomeCompleto());
        System.out.println("Idade: " + usuario.getIdade());
        System.out.println("Gênero: " + usuario.getGeneroTexto());
        System.out.printf("Sálario: R$ %.2f\n", usuario.getSalario());
        System.out.printf("Despesas: R$ %.2f\n", usuario.getDespesas());
        System.out.printf("Saldo: R$ %.2f\n", usuario.getSaldo());
        System.out.printf("Salario Anual R$ %.2f\n", usuario.getSalarioAnual());
        System.out.printf("Percentual de Gastos: %.2f%%\n", usuario.getPercentualGasto());
        System.out.printf("Percentual livre: %.2f%%\n", usuario.getPercentualLivre());
        System.out.printf(analise.gerSituacao(usuario));
    }
}
