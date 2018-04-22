package Modelos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int id;

    private String descricao;

    private List<Pedido> pedido;

    private static int gencodigo = 1;
    private int gencodigoPedido = 1;
    private static List<Mesa> ListMesa;

    public int gerarCodigoPedido() {
        int cod = gencodigoPedido;
        gencodigoPedido++;
        return cod;
    }

    public Mesa() {
        this.id = gerarCodigo();
        this.descricao = "Mesa " + id;
        this.pedido = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void gerarPedido() {
        Pedido p = new Pedido(this, LocalTime.now());
        p.gerarItemPedido();
        this.pedido.add(p);
    }
    
    public void gerarPedidoNovo() {
        Pedido p = new Pedido(this, LocalTime.now());
        this.pedido.add(p);
    }
    
    public Pedido criarPedido() {
        Pedido p = new Pedido(this, LocalTime.now());
        return p;
    }

    public static int gerarCodigo() {
        int cod = gencodigo;
        gencodigo++;
        return cod;
    }

    public static List<Mesa> getSampleDataMesa() {
        if (ListMesa == null) {
            ListMesa = new ArrayList<>();
            for (int i = 0; i <= 4; i++) {
                Mesa m = new Mesa();
                m.gerarPedido();
                ListMesa.add(m);
            }
            return ListMesa;
        }
        return ListMesa;
    }
    
    public static Mesa getMesaByID(Integer id){
        for(Mesa m : ListMesa){
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
    
    public Pedido getPedidoByID(Integer id){
        for(Pedido p : pedido){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
}
