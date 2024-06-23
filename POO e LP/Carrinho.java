import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemVenda> itens;

    public Carrinho() {
        itens = new ArrayList<>();
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
