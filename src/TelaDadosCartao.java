import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDadosCartao {
    private JPanel panel;
    private JTextField textFieldNumeroCartao;
    private JTextField textFieldNomeTitular;
    private JTextField textFieldDataValidade;
    private JTextField textFieldCodigoSeguranca;
    private JButton buttonConfirmar;
    private JButton buttonCancelar;

    public TelaDadosCartao(JFrame frame, Carrinho carrinho) {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNumeroCartao = new JLabel("Número do Cartão:");
        textFieldNumeroCartao = new JTextField(20);

        JLabel labelNomeTitular = new JLabel("Nome do Titular:");
        textFieldNomeTitular = new JTextField(20);

        JLabel labelDataValidade = new JLabel("Data de Validade (MM/AA):");
        textFieldDataValidade = new JTextField(6);

        JLabel labelCodigoSeguranca = new JLabel("Código de Segurança:");
        textFieldCodigoSeguranca = new JTextField(4);

        buttonConfirmar = new JButton("Confirmar");
        buttonCancelar = new JButton("Cancelar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelNumeroCartao, gbc);

        gbc.gridx = 1;
        panel.add(textFieldNumeroCartao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelNomeTitular, gbc);

        gbc.gridx = 1;
        panel.add(textFieldNomeTitular, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelDataValidade, gbc);

        gbc.gridx = 1;
        panel.add(textFieldDataValidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelCodigoSeguranca, gbc);

        gbc.gridx = 1;
        panel.add(textFieldCodigoSeguranca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonConfirmar, gbc);

        gbc.gridx = 1;
        panel.add(buttonCancelar, gbc);

        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCartao = textFieldNumeroCartao.getText();
                String nomeTitular = textFieldNomeTitular.getText();
                String dataValidade = textFieldDataValidade.getText();
                String codigoSeguranca = textFieldCodigoSeguranca.getText();

                if (numeroCartao.isEmpty() || nomeTitular.isEmpty() || dataValidade.isEmpty() || codigoSeguranca.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Preencha todos os campos!");
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
