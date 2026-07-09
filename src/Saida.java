public class Saida {
    public void mostrarDados(Usuario usuario, AnaliseFinanceira analise) {
        System.out.println("========================================");
        System.out.println("           DADOS DO USUARIO             ");
        System.out.println("========================================");
        System.out.println("Nome: " + usuario.getNomeCompleto());
        System.out.println("Idade: " + usuario.getIdade());
        System.out.println("Gênero: " + usuario.getGeneroTexto());

        System.out.println();

        System.out.println("========================================");
        System.out.println("              DESPESAS                  ");
        System.out.println("========================================");
        for (Despesa despesa : usuario.getDespesas()) {
            System.out.println("Nome: " + despesa.getNomeDespesa());
            System.out.printf("Valor: R$ %.2f\n", despesa.getValorDespesa());
            System.out.println("----------------------------------------");
        }

        System.out.printf("Total de Despesas: R$ %.2f\n", usuario.getSomaDespesas());

        System.out.println();

        System.out.println("========================================");
        System.out.println("                 METAS                  ");
        System.out.println("========================================");
        for (Meta meta : usuario.getMetas()) {
            System.out.println("Nome: " + meta.getNomeObjeto());
            System.out.printf("Valor: R$ %.2f\n", meta.getValorObjeto());
            System.out.printf("Valor Guardado: R$ %.2f\n", meta.getValorGuardado());
            System.out.println("----------------------------------------");
        }

        System.out.println();

        System.out.println("========================================");
        System.out.println("        INFORMAÇÔES FINANCEIRAS         ");
        System.out.println("========================================");
        System.out.printf("Sálario: R$ %.2f\n", usuario.getSalario());
        System.out.printf("Saldo: R$ %.2f\n", usuario.getSaldo());
        System.out.printf("Salario Anual R$ %.2f\n", usuario.getSalarioAnual());
        System.out.printf("Percentual de Gastos: %.2f%%\n", usuario.getPercentualGasto());
        System.out.printf("Percentual livre: %.2f%%\n", usuario.getPercentualLivre());

        System.out.println();

        System.out.println("========================================");
        System.out.println("          ANALISE FINANCEIRA            ");
        System.out.println("========================================");

        System.out.printf(analise.getSituacao(usuario));
    }
}
