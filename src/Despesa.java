public class Despesa {
      private String nomeDespesa;
      private Double valorDespesa;

    public Despesa(String nomeDespesa, Double valorDespesa) {
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
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

    public void alterarValorDespesa(double novoValor) {
        valorDespesa = novoValor;
    }
}
