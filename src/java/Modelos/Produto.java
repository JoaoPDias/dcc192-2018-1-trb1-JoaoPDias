package Modelos;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private Integer id;

    private String descricao;

    private Double valor;

    private static int gencodigo = 0;
    private static List<Produto> ListProdutos;

    public Produto() {
    }

    public Produto(String descricao, Double valor) {
        this.id = gerarCodigo();
        this.descricao = descricao;
        setValor(valor);
    }

    public Produto(Integer id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        setValor(valor);
    }

    public static int gerarCodigo() {
        int cod = gencodigo;
        gencodigo++;
        return cod;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            Number n = 0;
            try {
                n = df.parse(df.format(valor));
            } catch (ParseException ex) {
                System.out.println("Erro na conversão");
            }
            this.valor = n.doubleValue();
        } else {
            throw new NumberFormatException();
        }
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + "; Valor: R$ " + valor;
    }

    public Produto clonar() {
        Produto p = new Produto();
        p.setId(this.id);
        p.setDescricao(this.descricao);
        p.setValor(this.valor);
        return p;
    }

    public static List<Produto> getSampleData() {
        if (ListProdutos == null) {
            ListProdutos = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Produto p = new Produto("Produto " + i, (45.8 * i + 1) / 3);
                ListProdutos.add(p);
            }
            return ListProdutos;

        }
        return ListProdutos;
    }

    public static Produto getProdutoByID(Integer id) {
        for (Produto p : ListProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
