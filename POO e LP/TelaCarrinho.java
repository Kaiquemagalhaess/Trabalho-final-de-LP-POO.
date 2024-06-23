import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCarrinho {
    private JPanel panel;
    private JButton buttonPagamento;
    private JButton buttonVoltar;
    private JTextArea textAreaCarrinho;
    private List<ItemVenda> carrinho;

    public TelaCarrinho(JFrame frame, List<ItemVenda> carrinho) {
        this.carrinho = carrinho;

        panel = new JPanel(new BorderLayout());
        buttonPagamento = new JButton("Finalizar pedido");
        buttonVoltar = new JButton("Voltar para Vitrine");
        textAreaCarrinho = new JTextArea(10, 30);
        textAreaCarrinho.setEditable(false);

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(buttonPagamento);
        panelBotoes.add(buttonVoltar);

        panel.add(new JScrollPane(textAreaCarrinho), BorderLayout.CENTER);
        panel.add(panelBotoes, BorderLayout.SOUTH);

        buttonPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento telaPagamento = new TelaPagamento(frame, carrinho);
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

        atualizarCarrinho();
    }

    private void atualizarCarrinho() {
        StringBuilder carrinhoText = new StringBuilder("Itens no carrinho:\n");
        for (ItemVenda item : carrinho) {
            carrinhoText.append(item.getNome()).append(" - ").append(item.getPreco()).append(" x ").append(item.getQuantidade()).append("\n");
        }
        textAreaCarrinho.setText(carrinhoText.toString());
    }

    public JPanel getPanel() {
        return panel;
    }
}
