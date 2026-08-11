package entities;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Despesa> despesas = new ArrayList<>();
    private List<Meta> metas = new ArrayList<>();

    public Historico() {
    }

    public Historico(List<Despesa> despesas, List<Meta> metas) {
        this.despesas = despesas;
        this.metas = metas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void addDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public void addMeta(Meta meta) {
        metas.add(meta);
    }

    public double getSomaDespesas() {
        double soma = 0.0;
        for (Despesa despesas1 : despesas) {
            soma += despesas1.getValorDespesa();
        }
        return soma;
    }
}
