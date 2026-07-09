public class Meta {
    private String nomeMeta;
    private Double valorObjeto;
    private double valorGuardado;

    public Meta(String nomeMeta, Double valorObjeto) {
        this.nomeMeta = nomeMeta;
        this.valorObjeto = valorObjeto;
        this.valorGuardado = 0.0;
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

    public void alterarValorObjeto(double novoValor) {
         valorObjeto = novoValor;
    }

    public void adicionarValorGuardado(double valorAdicionado) {
        valorGuardado += valorAdicionado;
    }

}
