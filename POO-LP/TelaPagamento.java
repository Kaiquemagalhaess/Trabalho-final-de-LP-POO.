import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento {
    private JPanel panel;
    private JTextField textFieldCartao;
    private JButton buttonFinalizar;
    private JButton buttonVoltar;

    public TelaPagamento(JFrame frame) {
        panel = new JPanel();
        textFieldCartao = new JTextField(20);
        buttonFinalizar = new JButton("Finalizar Pagamento");
        buttonVoltar = new JButton("Voltar para o Carrinho");

        panel.add(new JLabel("Número do Cartão:"));
        panel.add(textFieldCartao);
        panel.add(buttonFinalizar);
        panel.add(buttonVoltar);

        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Pagamento realizado com sucesso!");
                TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                frame.setContentPane(telaPrincipal.getPanel());
                frame.revalidate();
            }
        });

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(frame);
                frame.setContentPane(telaCarrinho.getPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
