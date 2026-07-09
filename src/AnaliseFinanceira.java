public class AnaliseFinanceira {

    public String getSituacao(Usuario usuario) {
        if (usuario.getSaldo() >= 1000) {
            return "Situação: Normal\nRecomendação: Operações podem seguir sem restrições.";
        } else if (usuario.getSaldo() >= 200) {
            return "Situação: Atenção\nRecomendação: Monitorar despesas e evitar novos gastos.";
        } else {
            return "Situação: Crítica\nRecomendação: Reduzir despesas ou aumentar receitas imediatamente.";
        }
    }
    }



