public class ItemVenda {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public ItemVenda(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }
}
