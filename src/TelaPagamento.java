import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento {
    private JPanel panel;
    private JComboBox<String> comboBoxPagamento;
    private JButton buttonConfirmar;
    private JButton buttonCancelar;

    public TelaPagamento(JFrame frame, Carrinho carrinho) {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelPagamento = new JLabel("Selecione a forma de pagamento:");
        comboBoxPagamento = new JComboBox<>(new String[]{"Cartão de Crédito", "Boleto", "Pix"});
        buttonConfirmar = new JButton("Confirmar");
        buttonCancelar = new JButton("Cancelar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        panel.add(labelPagamento, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(comboBoxPagamento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(buttonConfirmar, gbc);

        gbc.gridx = 1;
        panel.add(buttonCancelar, gbc);

        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoPagamento = (String) comboBoxPagamento.getSelectedItem();

                if (metodoPagamento.equals("Cartão de Crédito")) {
                    TelaDadosCartao telaDadosCartao = new TelaDadosCartao(frame, carrinho);
                    frame.setContentPane(telaDadosCartao.getPanel());
                    frame.revalidate();
                } else {
                    JOptionPane.showMessageDialog(panel, "Compra finalizada com sucesso!");
                    TelaPrincipal telaPrincipal = new TelaPrincipal(frame);
                    frame.setContentPane(telaPrincipal.getPanel());
                    frame.revalidate();
                }
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(frame, carrinho);
                frame.setContentPane(telaCarrinho.getPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
