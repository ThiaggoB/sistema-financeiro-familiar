package entities.enums;

public enum StatusDespesa {
    ATIVA("Ativa"),
    CANCELADA("Cancelada"),
    CONCLUIDO("Concluido");

    private String descricao;

    StatusDespesa(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return descricao;
    }
}
