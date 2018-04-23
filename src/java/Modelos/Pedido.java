package Modelos;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {

    private int id;

    private String descricao;

    private int gencodigoItem = 1;

    private Mesa mesa;

    private LocalTime hora_abertura;

    private LocalTime hora_fechamento;

    private List<ItemPedido> itemPedido;
    private Double valorTotal;
    private boolean fechado;

    public int getGencodigoItem() {
        return gencodigoItem;
    }

    public void setGencodigoItem(int gencodigoItem) {
        this.gencodigoItem = gencodigoItem;
    }
    public Pedido(Mesa mesa, LocalTime hora_abertura) {
        this.mesa = mesa;
        this.hora_abertura = hora_abertura;
        this.id = this.mesa.gerarCodigoPedido();
        this.descricao = "Pedido " + id;
        this.itemPedido = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getHora_abertura() {
        String abertura = hora_abertura.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        return abertura;
    }

    public void setHora_abertura(LocalTime hora_abertura) {
        this.hora_abertura = hora_abertura;
    }

    public String getHora_fechamento() {
        if (this.hora_fechamento == null) {
            return "Pedido Aberto";
        }
        String fechamento = hora_fechamento.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        return fechamento;

    }

    public void setHora_fechamento(LocalTime hora_fechamento) {
        this.hora_fechamento = hora_fechamento;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public Double getValorTotal() {
        Double valorTotal = 0.0;
        for (ItemPedido item : itemPedido) {
            valorTotal += item.getValorTotal();
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        Number n = 0;
        try {
            n = df.parse(df.format(valorTotal));
        } catch (ParseException ex) {
            System.out.println("Erro na conversão");
        }
        return n.doubleValue();
    }
    
    public void setValorTotal(Double valorTotal){
        this.valorTotal = valorTotal;
    }
    public void adicionarItem(ItemPedido i) {
        itemPedido.add(i);
        this.setValorTotal(this.getValorTotal());
    }

    public void removerItem(ItemPedido i) {
        itemPedido.remove(i);
        this.setValorTotal(this.getValorTotal());
    }

    public int gerarCodigoItem() {
        int cod = gencodigoItem;
        gencodigoItem++;
        return cod;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\n Descrição:" + descricao + "\n Mesa: " + mesa + "\n Hora de Abertura: " + hora_abertura.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + "\n Hora de fechamento: " + hora_fechamento.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + "\n Valor Total: R$ " + getValorTotal();
    }

    public void gerarItemPedido() {
        Random r = new Random();
        ItemPedido ip = new ItemPedido(this, Produto.getSampleData().get(r.nextInt(10)), r.nextInt(50));
        this.getItemPedido().add(ip);
        this.setValorTotal(this.getValorTotal());
    }

    public ItemPedido getItemPedidoById(Integer id) {
        for (ItemPedido it : itemPedido) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }

    public void setItemPedidoById(ItemPedido item) {
        for (ItemPedido it : itemPedido) {
            if (it.getId() == item.getId()) {
                Integer index = itemPedido.indexOf(it);
                itemPedido.set(index, item);
                this.setValorTotal(this.getValorTotal());
            }
        }
    }

    public boolean removeItemPedidoById(ItemPedido item) {
        for (ItemPedido it : itemPedido) {
            if (it.getId() == item.getId()) {
                ((ArrayList) itemPedido).remove(it);
                this.setValorTotal(this.getValorTotal());
                return true;
            }
        }
        return false;
    }
    
  
}
