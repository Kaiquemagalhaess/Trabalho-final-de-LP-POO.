import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
    private JPanel panel;
    private JButton buttonCarrinho;
    private JButton buttonProduto1;
    private JButton buttonProduto2;
    private JButton buttonProduto3;

    public TelaPrincipal(JFrame frame) {
        panel = new JPanel();
        buttonCarrinho = new JButton("Ver Carrinho");
        buttonProduto1 = new JButton("Produto 1");
        buttonProduto2 = new JButton("Produto 2");
        buttonProduto3 = new JButton("Produto 3");

        panel.add(buttonProduto1);
        panel.add(buttonProduto2);
        panel.add(buttonProduto3);
        panel.add(buttonCarrinho);

        buttonCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(frame);
                frame.setContentPane(telaCarrinho.getPanel());
                frame.revalidate();
            }
        });


        buttonProduto1.addActionListener(e -> adicionarAoCarrinho(1));
        buttonProduto2.addActionListener(e -> adicionarAoCarrinho(2));
        buttonProduto3.addActionListener(e -> adicionarAoCarrinho(3));
    }

    private void adicionarAoCarrinho(int produtoId) {

        System.out.println("Produto " + produtoId + " adicionado ao carrinho!");
    }

    public JPanel getPanel() {
        return panel;
    }
}
