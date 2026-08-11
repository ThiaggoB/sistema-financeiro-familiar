package entities;

import entities.enums.CategoriaDespesa;
import entities.enums.StatusDespesa;

import java.time.LocalDate;

public abstract class Despesa {
      private String nomeDespesa;
      private Double valorDespesa;
      protected StatusDespesa status;
      private CategoriaDespesa categoriaDespesa;
      protected LocalDate dataDespesas;
      protected int diaVencimento;

    public Despesa() {
    }

    public Despesa(String nomeDespesa, Double valorDespesa, CategoriaDespesa categoriaDespesa, LocalDate dataDespesas) {
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
        this.categoriaDespesa = categoriaDespesa;
        this.dataDespesas = dataDespesas;
        this.status = StatusDespesa.ATIVA;
        this.diaVencimento = dataDespesas.getDayOfMonth();
    }

    public LocalDate getDataDespesas() {
        return dataDespesas;
    }

    public void setDataDespesas(LocalDate dataDespesas) {
        this.dataDespesas = dataDespesas;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public Double getValorDespesa() {
        return valorDespesa;
    }

    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public StatusDespesa getStatus() {
        return status;
    }

    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public void alterarValorDespesa(double novoValor) {
        valorDespesa = novoValor;
    }

    public void cancelar() {
        status = StatusDespesa.CANCELADA;
    }

    public abstract String obterTipo();


    public abstract String obterInformacoesExtras();

    public abstract void renovarVencimento();


    public abstract boolean deveEncerrar();


    public abstract void atualizarStatus();

}

