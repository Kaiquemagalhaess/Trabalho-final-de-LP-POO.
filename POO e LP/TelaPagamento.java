import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaPagamento {
    private JPanel panel;
    private JTextField textFieldNumeroCartao;
    private JTextField textFieldNomeTitular;
    private JTextField textFieldValidade;
    private JTextField textFieldCVC;
    private JButton buttonConfirmarPagamento;
    private JButton buttonVoltar;
    private List<ItemVenda> carrinho;

    public TelaPagamento(JFrame frame, List<ItemVenda> carrinho) {
        this.carrinho = carrinho;

        panel = new JPanel(new GridLayout(6, 2, 10, 10));
        textFieldNumeroCartao = new JTextField();
        textFieldNomeTitular = new JTextField();
        textFieldValidade = new JTextField();
        textFieldCVC = new JTextField();
        buttonConfirmarPagamento = new JButton("Confirmar Pagamento");
        buttonVoltar = new JButton("Voltar");

        panel.add(new JLabel("Número do Cartão:"));
        panel.add(textFieldNumeroCartao);
        panel.add(new JLabel("Nome do Titular:"));
        panel.add(textFieldNomeTitular);
        panel.add(new JLabel("Validade (MM/AA):"));
        panel.add(textFieldValidade);
        panel.add(new JLabel("CVC:"));
        panel.add(textFieldCVC);
        panel.add(buttonConfirmarPagamento);
        panel.add(buttonVoltar);

        buttonConfirmarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Pagamento confirmado com sucesso!");
                TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                frame.setContentPane(telaPrincipal.getPanel());
                frame.revalidate();
            }
        });

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento telaPagamento = new TelaPagamento(frame, carrinho);
                frame.setContentPane(telaPagamento.getPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}


