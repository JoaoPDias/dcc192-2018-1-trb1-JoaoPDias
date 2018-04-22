package Modelos;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class ItemPedido {

    private int id;
    private Pedido pedido;

    private Produto produto;

    private int quantidade;
    private Double valorTotal;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        Number n = 0;
        try {
            n = df.parse(df.format(produto.getValor() * quantidade));
        } catch (ParseException ex) {
            System.out.println("Erro na conversão");
        }
        return n.doubleValue();
    }

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        setQuantidade(quantidade);
        this.id = this.pedido.gerarCodigoItem();
        this.valorTotal = this.getValorTotal();
        this.pedido.setValorTotal(this.pedido.getValorTotal());
    }
     public ItemPedido(Integer id,Pedido pedido, Produto produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        setQuantidade(quantidade);
        this.id =id;
        this.valorTotal = this.getValorTotal();
        this.pedido.setValorTotal(this.pedido.getValorTotal());
    }
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;
        }
    }

    @Override
    public String toString() {
        return "Item: " + getProduto().toString() + " x " + getQuantidade() + " = R$ " + getValorTotal();
    }

}
