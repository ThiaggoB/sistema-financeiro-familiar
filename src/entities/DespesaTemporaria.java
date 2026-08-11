package entities;

import entities.enums.CategoriaDespesa;
import entities.enums.StatusDespesa;

import java.time.LocalDate;

public class DespesaTemporaria extends Despesa{
    private int quantidadeParcelas;
    private int parcelasRestantes;
    private Frequencia frequencia;

    public DespesaTemporaria(String nomeDespesa, Double valorDespesa, CategoriaDespesa categoriaDespesa, LocalDate dataDespesas, int quantidadeParcelas, Frequencia frequencia) {
        super(nomeDespesa, valorDespesa, categoriaDespesa, dataDespesas);
        this.quantidadeParcelas = quantidadeParcelas;
        this.parcelasRestantes = quantidadeParcelas;
        this.frequencia = frequencia;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }



    @Override
    public void renovarVencimento() {

        parcelasRestantes--;

        if (parcelasRestantes > 0) {
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
    }

    @Override
    public final String obterTipo() {
        return "Temporária";
    }

    @Override
    public final String obterInformacoesExtras() {
        return "Quantidade de parcelas: " + quantidadeParcelas + "\n" + "Quantidade de parcelas restantes: " + parcelasRestantes;
    }

    @Override
    public boolean deveEncerrar() {
        return parcelasRestantes == 0;
    }

    @Override
    public void atualizarStatus() {
        if (parcelasRestantes == 0) {
           status = StatusDespesa.CONCLUIDO;
        }
    }
}

