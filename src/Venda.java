import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemVenda> itens;

    public Venda(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}
