package entities;

import entities.enums.CategoriaDespesa;
import entities.enums.StatusDespesa;

import java.time.LocalDate;

public class DespesaRecorrente extends Despesa {
    private Frequencia frequencia;

    public DespesaRecorrente(String nomeDespesa, Double valorDespesa, CategoriaDespesa categoriaDespesa, LocalDate dataDespesas, Frequencia frequencia) {
        super(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas);
        this.frequencia = frequencia;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }


    @Override
    public void atualizarStatus(){
    }

    @Override
   public void renovarVencimento() {
       switch (frequencia) {
           case Frequencia.DIARIA -> {
               LocalDate dataDespesas = getDataDespesas().plusDays(1);
               setDataDespesas(dataDespesas);
           }
           case Frequencia.SEMANAL -> {
               LocalDate dataDespesas = getDataDespesas().plusWeeks(1);
               setDataDespesas(dataDespesas);
           }
           case Frequencia.MENSAL -> {
               LocalDate prximoMes = getDataDespesas().plusMonths(1);
               int ultimoDiaMes = prximoMes.lengthOfMonth();
               int diaValido = Math.min(diaVencimento, ultimoDiaMes);
               LocalDate novaData = prximoMes.withDayOfMonth(diaValido);
               setDataDespesas(novaData);
           }
           case Frequencia.ANUAL -> {
               LocalDate dataDespesas = getDataDespesas().plusYears(1);
               setDataDespesas(dataDespesas);
           }
       }
   }

    @Override
    public final String obterTipo() {
        return "Recorrente";
    }

    @Override
    public final String obterInformacoesExtras() {
        return "Frequência: " + frequencia;
    }

    @Override
    public boolean deveEncerrar() {
       return status == StatusDespesa.CANCELADA;

    }
}
