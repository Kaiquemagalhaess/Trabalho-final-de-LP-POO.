import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Compras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            TelaLogin telaLoginRegistro = new TelaLogin(frame);
            frame.setContentPane(telaLoginRegistro.getPanel());
            frame.setVisible(true);
        });
    }
}
