import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin {
    private JPanel panel;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    public TelaLogin(JFrame frame) {
        panel = new JPanel();
        textFieldUsername = new JTextField(20);
        passwordField = new JPasswordField(20);
        buttonLogin = new JButton("Login");

        panel.add(new JLabel("Nome:"));
        panel.add(textFieldUsername);
        panel.add(new JLabel("Senha:"));
        panel.add(passwordField);
        panel.add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de autenticação
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("joaoemax") && password.equals("1234")) {
                    TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                    frame.setContentPane(telaPrincipal.getPanel());
                    frame.revalidate();
                } else {
                    JOptionPane.showMessageDialog(panel, "Credenciais inválidas!");
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
