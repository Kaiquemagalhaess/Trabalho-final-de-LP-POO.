import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarrinho {
    private JPanel panel;
    private JButton buttonVoltar;
    private JButton buttonFinalizarCompra;
    private JTextArea textAreaCarrinho;

    public TelaCarrinho(JFrame frame, Carrinho carrinho) {
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        textAreaCarrinho = new JTextArea(20, 50);
        textAreaCarrinho.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaCarrinho);
        panel.add(scrollPane, BorderLayout.CENTER);

        atualizarCarrinho(carrinho);

        JPanel buttonPanel = new JPanel();
        buttonVoltar = new JButton("Voltar");
        buttonFinalizarCompra = new JButton("Finalizar Compra");

        buttonPanel.add(buttonVoltar);
        buttonPanel.add(buttonFinalizarCompra);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                frame.setContentPane(telaPrincipal.getPanel());
                frame.revalidate();
            }
        });

        buttonFinalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento telaPagamento = new TelaPagamento(frame, carrinho);
                frame.setContentPane(telaPagamento.getPanel());
                frame.revalidate();
            }
        });
    }

    private void atualizarCarrinho(Carrinho carrinho) {
        StringBuilder sb = new StringBuilder();
        for (ItemVenda item : carrinho.getItens()) {
            sb.append("Produto: ").append(item.getProduto().getNome())
                    .append(" - Quantidade: ").append(item.getQuantidade())
                    .append(" - Subtotal: R$").append(item.getSubtotal()).append("\n");
        }
        sb.append("Total: R$").append(carrinho.calcularTotal());
        textAreaCarrinho.setText(sb.toString());
    }

    public JPanel getPanel() {
        return panel;
    }
}
