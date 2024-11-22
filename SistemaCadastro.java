import java.util.ArrayList;

public class SistemaCadastro {
    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;

    public SistemaCadastro() {
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, String cpf, String matricula) {
        Aluno aluno = new Aluno(nome, cpf, matricula);
        alunos.add(aluno);
    }

    public void cadastrarDisciplina(String nome, String codigo) {
        Disciplina disciplina = new Disciplina(nome, codigo);
        disciplinas.add(disciplina);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            aluno.mostrarInfo();
        }
    }

    public void listarDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println("Nome: " + disciplina.getNome() + ", Código: " + disciplina.getCodigo());
        }
    }
}
