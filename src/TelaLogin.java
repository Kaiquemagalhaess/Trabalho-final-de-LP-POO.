import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TelaLogin {
    private JPanel panel;
    private JTextField textFieldLoginUsername;
    private JPasswordField passwordFieldLogin;
    private JButton buttonLogin;
    private JTextField textFieldRegisterUsername;
    private JPasswordField passwordFieldRegister;
    private JButton buttonRegistrar;
    private static Map<String, String> userDatabase = new HashMap<>();

    public TelaLogin(JFrame frame) {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Sistema de Compras");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(loginLabel, gbc);

        gbc.gridwidth = 1;

        JLabel loginUsernameLabel = new JLabel("Nome:");
        textFieldLoginUsername = new JTextField(20);
        JLabel loginPasswordLabel = new JLabel("Senha:");
        passwordFieldLogin = new JPasswordField(20);
        buttonLogin = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginUsernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(textFieldLoginUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginPasswordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordFieldLogin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonLogin, gbc);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldLoginUsername.getText();
                String password = new String(passwordFieldLogin.getPassword());

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                    frame.setContentPane(telaPrincipal.getPanel());
                    frame.revalidate();
                } else {
                    JOptionPane.showMessageDialog(panel, "Credenciais inválidas!");
                }
            }
        });

        JLabel registerLabel = new JLabel("Registro:");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(registerLabel, gbc);

        gbc.gridwidth = 1;

        JLabel registerUsernameLabel = new JLabel("Nome:");
        textFieldRegisterUsername = new JTextField(20);
        JLabel registerPasswordLabel = new JLabel("Senha:");
        passwordFieldRegister = new JPasswordField(20);
        buttonRegistrar = new JButton("Registrar");

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(registerUsernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(textFieldRegisterUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(registerPasswordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordFieldRegister, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonRegistrar, gbc);

        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldRegisterUsername.getText();
                String password = new String(passwordFieldRegister.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    userDatabase.put(username, password);
                    JOptionPane.showMessageDialog(panel, "Registrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Preencha todos os campos!");
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
