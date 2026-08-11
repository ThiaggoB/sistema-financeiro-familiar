package entities;

import entities.enums.CategoriaDespesa;
import entities.enums.StatusDespesa;

import java.time.LocalDate;

public class DespesaUnica extends Despesa {

    public DespesaUnica(String nomeDespesa, Double valorDespesa, CategoriaDespesa categoriaDespesa, LocalDate dataDespesas) {
        super(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas);
    }

    @Override
    public String obterTipo() {
        return "Única";
    }
    @Override
    public String obterInformacoesExtras() {
        return "Sem informações extras";
    }

    @Override
    public void renovarVencimento() {
    }

    @Override
    public void atualizarStatus() {
        status = StatusDespesa.CONCLUIDO;
    }

    @Override
    public boolean deveEncerrar() {
        return LocalDate.now().isEqual(dataDespesas) || LocalDate.now().isAfter(dataDespesas);
    }

}

