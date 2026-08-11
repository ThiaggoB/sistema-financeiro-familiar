package services;

import entities.Usuario;

public class AnaliseFinanceira {

    public String getSituacao(Usuario usuario) {
        if (usuario.getSaldo() >= 1000) {
            return "Situação: Normal\nRecomendação: Operações podem seguir sem restrições.\n";
        } else if (usuario.getSaldo() >= 200) {
            return "Situação: Atenção\nRecomendação: Monitorar despesas e evitar novos gastos.\n";
        } else {
            return "Situação: Crítica\nRecomendação: Reduzir despesas ou aumentar receitas imediatamente.\n";
        }
    }
    }



