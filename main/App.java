import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SistemaCadastro sistema = new SistemaCadastro();
        JFrame frame = new JFrame("Sistema de Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre componentes

        // Nome
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nomeLabel, gbc);
        gbc.gridx = 1;
        panel.add(nomeField, gbc);

        // CPF
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(cpfLabel, gbc);
        gbc.gridx = 1;
        panel.add(cpfField, gbc);

        // Matrícula
        JLabel matriculaLabel = new JLabel("Matrícula:");
        JTextField matriculaField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(matriculaLabel, gbc);
        gbc.gridx = 1;
        panel.add(matriculaField, gbc);

        // InputVerifier para garantir que apenas números sejam inseridos
        InputVerifier numberVerifier = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                return text.matches("\\d+");  // Verifica se o texto contém apenas dígitos
            }
        };

        cpfField.setInputVerifier(numberVerifier);
        matriculaField.setInputVerifier(numberVerifier);

        // Botões
        JButton cadastrarButton = new JButton("Cadastrar Aluno");
        cadastrarButton.addActionListener(e -> {
            if (!cpfField.getInputVerifier().verify(cpfField) || !matriculaField.getInputVerifier().verify(matriculaField)) {
                JOptionPane.showMessageDialog(frame, "CPF e Matrícula devem conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String matricula = matriculaField.getText();
            sistema.cadastrarAluno(nome, cpf, matricula);
            JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!");
        });

        JButton listarButton = new JButton("Listar Alunos");
        listarButton.addActionListener(e -> {
            StringBuilder alunosInfo = new StringBuilder();
            for (Aluno aluno : sistema.getAlunos()) {
                alunosInfo.append("Nome: ").append(aluno.getNome())
                        .append(", CPF: ").append(aluno.getCpf())
                        .append(", Matrícula: ").append(aluno.getMatricula()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, alunosInfo.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
        });

        // Centralizando os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(listarButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
