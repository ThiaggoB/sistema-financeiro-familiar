package entities;

import entities.enums.Genero;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    // ==========================
    // ATRIBUTOS
    // ==========================

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Double salario;
    private Genero genero;
    private List<Meta> metas = new ArrayList<>();
    private  List<Despesa> despesas = new ArrayList<>();


    public Usuario(String nome, String sobrenome, LocalDate dataNascimento,Genero genero, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }


    // ==========================
    // GETTERS E SETTERS
    // ==========================

   public void setNome(String nome) {
       this.nome = nome;
   }
    public String getNome() {
        return nome;
    }

   public void setSobrenome(String sobrenome) {
       this.sobrenome = sobrenome;
   }
    public String getSobrenome() {
        return sobrenome;
    }

   public double getSalario() {
        return salario;
   }

    public Genero getGenero() {
        return genero;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    // ==========================
    // DESPESAS
    // ==========================

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public void removerDespesas(int indice) {
        despesas.remove(indice);
    }

    public void removerDespesas(Despesa despesa) {
        despesas.remove(despesa);
    }


    public double getSomaDespesas() {
        double soma = 0.0;
        for (Despesa despesas1 : despesas) {
            soma += despesas1.getValorDespesa();
        }
        return soma;

    }

    // ==========================
    // METAS
    // ==========================

    public void adicionarMeta(Meta meta){
        metas.add(meta);
    }

    public void removerMetas(int indice) {
        metas.remove(indice);
    }

    // ==========================
    // MÉTODOS
    // ==========================

    public Period getIdade() {
      return Period.between(dataNascimento, LocalDate.now());
    }


    public double getSaldo() {
        return getSalario() - getSomaDespesas();
    }
    public double getSalarioAnual() {
        return getSalario() * 12;
    }
    public double getPercentualGasto (){
        return (getSomaDespesas() / getSalario()) * 100;

    }
    public double getPercentualLivre()  {
        return ((getSalario() - getSomaDespesas()) / getSalario()) * 100;

    }

    public  String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

}

