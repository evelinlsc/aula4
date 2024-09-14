import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

class Tarefa {
    // Atributos privados
    private String titulo;
    private String descricao;
    private String prazo; 
    private int prioridade;

    //
    private boolean isPrazoValido (String prazo){
        try {
            LocalDate.parse(prazo);
            return true;
        } catch (DateTimeParseException e ) {
            return false;
        }
    }
    //desafio 2
   
      

    // Construtor 1
    public Tarefa(String titulo, String descricao, String prazo, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
    }
    // Construtor 2
    public Tarefa(String titulo,String prazo ){
        this.titulo = titulo;
        this.prazo = prazo;
        this.prioridade = 0;
        this.descricao = "";
    //Desafio 1
    }
    public Tarefa(String titulo, int prioridade){
        this.titulo = titulo;
        this.prazo = "";
        this.prioridade = prioridade;
        this.descricao = "";
    }
    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.descricao = new String();
        this.prazo = "";
        this.prioridade = 0;
    }

    // Métodos Get e Set
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade<=5){
            this.prioridade = prioridade;
    
        } else{
            System.out.println("Prioridade alta!");
        }
    }
    public String getPrazo(){
        return this.prazo;
    }
    public void setPrazo (String prazo){
        if (isPrazoValido(prazo)){
            this.prazo = prazo;

        }else{
            System.out.println("Prazo invalído!");
        }
    }

    // Implementar getters e settes para os outros atributos
    public void exibirDetalhes() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Prazo: " + this.prazo);
        System.out.println("Prioridade: " + this.prioridade);
    }
    public long calcularDiasRestantes() {
        LocalDate dataPrazo = LocalDate.parse 
        (this.prazo);
        LocalDate hoje = LocalDate.now();
        return ChronoUnit.DAYS.between(hoje,dataPrazo);

    }
}

    

public class Main {
    public static void main(String[] args){
        Tarefa tarefa1 = new Tarefa("Estudar POO", "Revisar os conceitos de classes e objetos", "06-09-2024", 1);
        System.out.println("=== Imprimindo detalhes da Tarefa 1ª " + tarefa1.getTitulo());
        tarefa1.exibirDetalhes();

        Tarefa tarefa2 = new Tarefa("Estudar para a prova","2024-09-27");
        System.out.println("=== Imprimindo detalhes da Tarefa 2ª:" + tarefa2.getTitulo());
        tarefa2.exibirDetalhes();
 
        System.out.println("Dias restantes: " + tarefa2.calcularDiasRestantes());
        tarefa1.setPrazo("2024-08-32");

        //Desafio 1 e 2
        System.out.println("========================");
        Tarefa tarefa3 = new Tarefa("POO");
        tarefa3.exibirDetalhes();
        tarefa3.setPrioridade(7);
    }
}