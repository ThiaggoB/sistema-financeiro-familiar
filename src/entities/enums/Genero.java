package entities.enums;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return descricao;
    }
}
