public class Usuario {

    // ==========================
    // ATRIBUTOS
    // ==========================

    private String nome;
    private String sobrenome;
    private int idade;
    private double salario;
    private double despesas;
    private int genero;

    public Usuario(String nome, String sobrenome, int idade, int genero, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.idade = idade;
        this.genero = genero;
    }

    public Usuario(String nome, String sobrenome, int idade, int genero, double salario, double despesas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.idade = idade;
        this.genero = genero;
        this.despesas = despesas;
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

   public void setIdade(int idade) {
       this.idade = idade;
   }
   public int getIdade() {
       return idade;
   }

    public void setSalario(double salario) {
       this.salario = salario;
   }
   public double getSalario() {
       return salario;
   }


   public void setDespesas(double despesas) {
       this.despesas = despesas;
   }
   public double getDespesas() {
       return despesas;
   }


    public void setGenero(int genero) {
        this.genero = genero;
    }

    // ==========================
    // MÉTODOS
    // ==========================

    public double getSaldo() {
        return getSalario() - getDespesas();
    }
    public double getSalarioAnual() {
        return getSalario() * 12;
    }
    public double getPercentualGasto (){
        return (getDespesas() / getSalario()) * 100;

    }
    public double getPercentualLivre()  {
        return ((getSalario() - getDespesas()) / getSalario()) * 100;

    }

    public  String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public String getGeneroTexto(){
        return switch (genero) {
            case 1 -> "Masculino";
            case 2 -> "Feminino";
            case 3 -> "Outro";
            default -> "Não Informado";
        };
    }
}
