import java.util.ArrayList;

public class Aluno extends Pessoa implements Cadastravel, Listavel {
    private String matricula;
    private ArrayList<String> disciplinas;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
        this.disciplinas = new ArrayList<>();
    }

    @Override
    public void cadastrar() {
        // Implementação do método cadastrar
    }

    @Override
    public void listar() {
        // Implementação do método listar
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nome: " + getNome() + ", CPF: " + getCpf() + ", Matrícula: " + matricula);
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public ArrayList<String> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(ArrayList<String> disciplinas) { this.disciplinas = disciplinas; }
}
