package entities;

public enum Frequencia {
    DIARIA ("Diária"),
    SEMANAL ("Semanal"),
    MENSAL ("Mensal"),
    ANUAL ("ANUAL");

    private String descircao;

    Frequencia(String descircao) {
        this.descircao = descircao;
    }

    public String toString() {
        return descircao;
    }
}
