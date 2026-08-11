package entities.enums;

public enum StatusMeta {
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluida"),
    CANCELADA("Cancelada");

    private String descricao;

    StatusMeta(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return descricao;
    }
}

