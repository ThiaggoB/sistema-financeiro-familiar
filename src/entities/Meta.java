package entities;

import entities.enums.StatusMeta;

public class Meta {
    private String nomeMeta;
    private Double valorObjeto;
    private double valorGuardado;
    private StatusMeta status;



    public Meta(String nomeMeta, Double valorObjeto) {
        this.nomeMeta = nomeMeta;
        this.valorObjeto = valorObjeto;
        this.valorGuardado = 0.0;
        this.status = StatusMeta.EM_ANDAMENTO;
    }

    public String getNomeObjeto() {
        return nomeMeta;
    }

    public double getValorObjeto() {
        return valorObjeto;
    }

    public Double getValorGuardado() {
        return valorGuardado;
    }

    public StatusMeta getStatusMeta() {
        return status;
    }

    public void alterarValorObjeto(double novoValor) {
         valorObjeto = novoValor;
    }

    public void adicionarValorGuardado(double valorAdicionado) {
        valorGuardado += valorAdicionado;
    }

    public double getValorRestante() {
        return valorObjeto - valorGuardado;
    }

    public  double getProgresso() {
        return (valorGuardado / valorObjeto) * 100;
    }

    public boolean atualizarStatus() {
        if (valorObjeto <= valorGuardado) {
            status = StatusMeta.CONCLUIDA;
        }
        return valorObjeto <= valorGuardado;
    }


    public void cancelar() {
        status = StatusMeta.CANCELADA;
    }


}
