package view;

import entities.Despesa;
import entities.Historico;
import entities.Meta;
import entities.Usuario;
import services.AnaliseFinanceira;

import java.time.format.DateTimeFormatter;

public class Saida {

        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyy");

        public void mostrarUsuario(Usuario usuario) {
            System.out.println("========================================");
            System.out.println("           DADOS DO USUARIO             ");
            System.out.println("========================================");
            System.out.println("Nome: " + usuario.getNomeCompleto());
            System.out.println("Idade: " + usuario.getIdade().getYears());
            System.out.println("Gênero: " + usuario.getGenero());

        }

        public void mostrarDespesas(Usuario usuario) {

            System.out.println("========================================");
            System.out.println("              DESPESAS                  ");
            System.out.println("========================================");
            for (int i=0; i<usuario.getDespesas().size(); i++) {
                Despesa despesa = usuario.getDespesas().get(i);
                System.out.println("Despesa " + (i+1));
                System.out.println("Nome: " + despesa.getNomeDespesa());
                System.out.println("Categoria: " + despesa.getCategoriaDespesa());
                System.out.println("Tipo: " + despesa.obterTipo());
                System.out.println(despesa.obterInformacoesExtras());
                System.out.printf("Valor: R$ %.2f\n", despesa.getValorDespesa());
                System.out.println("Data: " + despesa.getDataDespesas().format(data));
                System.out.println("Status: " + despesa.getStatus());
                System.out.println("----------------------------------------");
            }
            System.out.printf("Total de Despesas: R$ %.2f\n", usuario.getSomaDespesas());
        }
        public void mostrarMetas(Usuario usuario) {
            System.out.println("========================================");
            System.out.println("                 METAS                  ");
            System.out.println("========================================");
            for (int i=0; i<usuario.getMetas().size(); i++) {
                Meta meta = usuario.getMetas().get(i);
                System.out.println("Meta " + (i+1));
                System.out.println("Nome: " + meta.getNomeObjeto());
                System.out.printf("Valor: R$ %.2f\n", meta.getValorObjeto());
                System.out.printf("Valor Guardado: R$ %.2f\n", meta.getValorGuardado());
                System.out.printf("Progresso: %.2f%%\n", meta.getProgresso());
                System.out.printf("Faltam: %.2f\n", meta.getValorRestante());
                System.out.println("Stattus: " + meta.getStatusMeta());
                System.out.println("----------------------------------------");
            }

        }

        public void mostrarFinancas(Usuario usuario) {
            System.out.println("========================================");
            System.out.println("        INFORMAÇÔES FINANCEIRAS         ");
            System.out.println("========================================");
            System.out.printf("Sálario: R$ %.2f\n", usuario.getSalario());
            System.out.printf("Saldo: R$ %.2f\n", usuario.getSaldo());
            System.out.printf("Salario Anual R$ %.2f\n", usuario.getSalarioAnual());
            System.out.printf("Percentual de Gastos: %.2f%%\n", usuario.getPercentualGasto());
            System.out.printf("Percentual livre: %.2f%%\n", usuario.getPercentualLivre());

        }
        public void mostrarAnalise(Usuario usuario, AnaliseFinanceira analise) {
        System.out.println("========================================");
        System.out.println("          ANALISE FINANCEIRA            ");
        System.out.println("========================================");

        System.out.printf(analise.getSituacao(usuario));
    }

    public void mostrarHistoricoDespesa(Historico historico) {

        System.out.println("========================================");
        System.out.println("           HISTÓRICO DESPESA            ");
        System.out.println("========================================");
        for (int i=0; i<historico.getDespesas().size(); i++) {
            Despesa despesa = historico.getDespesas().get(i);
            System.out.println("Despesa " + (i+1));
            System.out.println("Nome: " + despesa.getNomeDespesa());
            System.out.println("Categoria: " + despesa.getCategoriaDespesa());
            System.out.println("Tipo: " + despesa.obterTipo());
            System.out.println(despesa.obterInformacoesExtras());
            System.out.printf("Valor: R$ %.2f\n", despesa.getValorDespesa());
            System.out.println("Data: " + despesa.getDataDespesas().format(data));
            System.out.println("Status: " + despesa.getStatus());
            System.out.println("----------------------------------------");
        }
        System.out.printf("Total de Despesas: R$ %.2f\n", historico.getSomaDespesas());
    }

    public void mostrarHistoricoMetas(Historico historico) {
        System.out.println("========================================");
        System.out.println("                 METAS                  ");
        System.out.println("========================================");
        for (int i=0; i<historico.getMetas().size(); i++) {
            Meta meta = historico.getMetas().get(i);
            System.out.println("Meta " + (i+1));
            System.out.println("Nome: " + meta.getNomeObjeto());
            System.out.printf("Valor: R$ %.2f\n", meta.getValorObjeto());
            System.out.printf("Valor Guardado: R$ %.2f\n", meta.getValorGuardado());
            System.out.printf("Progresso: %.2f%%\n", meta.getProgresso());
            System.out.printf("Faltam: %.2f\n", meta.getValorRestante());
            System.out.println("Stattus: " + meta.getStatusMeta());
            System.out.println("----------------------------------------");
        }
    }
}
