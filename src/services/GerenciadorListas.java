package services;

import entities.Despesa;
import entities.Historico;
import entities.Meta;
import entities.Usuario;
import entities.enums.StatusDespesa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorListas {
    private Usuario usuario;
    private Historico historico;

    public GerenciadorListas(Usuario usuario, Historico historico) {
        this.usuario = usuario;
        this.historico = historico;
    }


    private void executarVencimento(Despesa despesa) {
        if (LocalDate.now().isEqual(despesa.getDataDespesas()) || LocalDate.now().isAfter(despesa.getDataDespesas())) {
            despesa.renovarVencimento();
        }
    }


    public void atualizarDespesa() {
        List<Despesa> despesaEncerradas = new ArrayList<>();
        for (Despesa despesa : usuario.getDespesas()) {
            while (LocalDate.now().isEqual(despesa.getDataDespesas()) || LocalDate.now().isAfter(despesa.getDataDespesas())) {
                if (despesa.getStatus() == StatusDespesa.CONCLUIDO) {
                    break;
                } else {
                    executarVencimento(despesa);
                    modificarDespesa(despesa, despesaEncerradas);
                }
            }
        }
        for (Despesa despesa : despesaEncerradas) {
            usuario.getDespesas().remove(despesa);
        }

    }


    private void modificarDespesa(Despesa despesa, List<Despesa> despesaEncerradas) {
        despesa.atualizarStatus();
        if (despesa.deveEncerrar()) {
            historico.addDespesa(despesa);
            despesaEncerradas.add(despesa);
        }
    }


    public void moverCanceladaDespesa(int indice) {
        Despesa despesa = usuario.getDespesas().get(indice);
        usuario.removerDespesas(indice);
        historico.addDespesa(despesa);
    }

    public void atualizarMeta() {
        List<Meta> metaEncerrada = new ArrayList<>();
        for (Meta meta : usuario.getMetas()) {
            modificarMeta(meta, metaEncerrada);
        }
        for (Meta meta : metaEncerrada) {
            usuario.getMetas().remove(meta);
        }
    }

    private void modificarMeta(Meta meta, List<Meta> metaEncerrada) {
        if (meta.atualizarStatus()) {
            historico.addMeta(meta);
            metaEncerrada.add(meta);
        }
    }

    public void moverCanceladaMeta(int indice) {
        entities.Meta meta = usuario.getMetas().get(indice);
        usuario.removerMetas(indice);
        historico.addMeta(meta);
    }
}