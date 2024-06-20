import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarrinho {
    private JPanel panel;
    private JButton buttonPagamento;
    private JButton buttonVoltar;
    private JTextArea textAreaCarrinho;

    public TelaCarrinho(JFrame frame) {
        panel = new JPanel();
        buttonPagamento = new JButton("Finalizar pedido");
        buttonVoltar = new JButton("Voltar para Vitrine");
        textAreaCarrinho = new JTextArea(10, 30);
        textAreaCarrinho.setEditable(false);

        panel.add(new JScrollPane(textAreaCarrinho));
        panel.add(buttonPagamento);
        panel.add(buttonVoltar);

        buttonPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento telaPagamento = new TelaPagamento(frame);
                frame.setContentPane(telaPagamento.getPanel());
                frame.revalidate();
            }
        });

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                frame.setContentPane(telaPrincipal.getPanel());
                frame.revalidate();
            }
        });

        // Atualizar visualização do carrinho
        textAreaCarrinho.setText("Itens no carrinho:\n Produto 1\n Produto 2\n Produto 3");
    }

    public JPanel getPanel() {
        return panel;
    }
}
