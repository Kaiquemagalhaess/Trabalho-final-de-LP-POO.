import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal {
    private JPanel panel;
    private JButton buttonCarrinho;
    private JButton buttonProduto1;
    private JButton buttonProduto2;
    private JButton buttonProduto3;
    private JTextArea textAreaCarrinho;

    private static List<ItemVenda> carrinho = new ArrayList<>();

    public TelaPrincipal(JFrame frame) {
        panel = new JPanel(new BorderLayout());
        textAreaCarrinho = new JTextArea(10, 30);
        textAreaCarrinho.setEditable(false);

        JPanel panelProdutos = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonProduto1 = new JButton("Maçã");
        buttonProduto2 = new JButton("Banana");
        buttonProduto3 = new JButton("Abacaxi");

        panelProdutos.add(buttonProduto1);
        panelProdutos.add(buttonProduto2);
        panelProdutos.add(buttonProduto3);

        JPanel panelBotoes = new JPanel();
        buttonCarrinho = new JButton("Ver Carrinho");
        panelBotoes.add(buttonCarrinho);

        panel.add(panelProdutos, BorderLayout.CENTER);
        panel.add(panelBotoes, BorderLayout.SOUTH);
        panel.add(new JScrollPane(textAreaCarrinho), BorderLayout.EAST);

        buttonCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(frame, carrinho);
                frame.setContentPane(telaCarrinho.getPanel());
                frame.revalidate();
            }
        });

        buttonProduto1.addActionListener(e -> adicionarAoCarrinho(1, "Maçã", 2.5));
        buttonProduto2.addActionListener(e -> adicionarAoCarrinho(2, "Banana", 1.2));
        buttonProduto3.addActionListener(e -> adicionarAoCarrinho(3, "Abacaxi", 3.0));
    }

    private void adicionarAoCarrinho(int produtoId, String nome, double preco) {
        ItemVenda item = new ItemVenda(produtoId, nome, preco, 1);
        carrinho.add(item);
        textAreaCarrinho.append("Produto " + nome + " adicionado ao carrinho!\n");
    }

    public JPanel getPanel() {
        return panel;
    }
}
