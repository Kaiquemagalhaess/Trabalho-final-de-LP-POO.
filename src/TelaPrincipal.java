import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
    private JPanel panel;
    private JButton buttonVerCarrinho;
    private JButton buttonAdicionarProduto;
    private JButton buttonFinalizarCompra;
    private Carrinho carrinho;

    public TelaPrincipal(JFrame frame) {
        carrinho = new Carrinho();
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Bem-vindo ao Sistema de Compras");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        buttonVerCarrinho = new JButton("Ver Carrinho");
        buttonAdicionarProduto = new JButton("Adicionar Produto");
        buttonFinalizarCompra = new JButton("Finalizar Compra");

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(buttonVerCarrinho, gbc);

        gbc.gridx = 1;
        panel.add(buttonAdicionarProduto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(buttonFinalizarCompra, gbc);

        buttonVerCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(frame, carrinho);
                frame.setContentPane(telaCarrinho.getPanel());
                frame.revalidate();
            }
        });

        buttonAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] frutas = {"Banana", "Maçã", "Laranja", "Uva", "Pera"};
                double[] precos = {1.0, 1.5, 2.0, 2.5, 3.0};
                String produtoEscolhido = (String) JOptionPane.showInputDialog(
                        panel,
                        "Selecione o produto:",
                        "Adicionar Produto",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        frutas,
                        frutas[0]
                );

                if (produtoEscolhido != null) {
                    for (int i = 0; i < frutas.length; i++) {
                        if (produtoEscolhido.equals(frutas[i])) {
                            Produto produto = new Produto(i, frutas[i], precos[i]);
                            carrinho.adicionarItem(new ItemVenda(produto, 1));
                            JOptionPane.showMessageDialog(panel, "Produto adicionado ao carrinho!");
                            break;
                        }
                    }
                }
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

    public JPanel getPanel() {
        return panel;
    }
}
