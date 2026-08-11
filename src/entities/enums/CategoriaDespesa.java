package entities.enums;

    public enum CategoriaDespesa {

        ALIMENTACAO("Alimentação"),
        MORADIA("Moradia"),
        TRANSPORTE("Transporte"),
        SAUDE("Saúde"),
        EDUCACAO("Educação"),
        LAZER("Lazer"),
        CONTAS("Contas"),
        IMPOSTOS("Impostos"),
        OUTROS("Outros");

        private final String descricao;

        CategoriaDespesa(String descricao) {
            this.descricao = descricao;
        }

        public String toString() {
            return descricao;
        }
    }