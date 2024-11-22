import java.io.*;
import java.util.ArrayList;

public class ArquivoUtils {

    public static void salvarAlunos(ArrayList<Aluno> alunos, String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(alunos);
        }
    }

    public static ArrayList<Aluno> lerAlunos(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (ArrayList<Aluno>) ois.readObject();
        }
    }
}
