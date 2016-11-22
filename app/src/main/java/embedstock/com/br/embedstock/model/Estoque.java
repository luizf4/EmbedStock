package embedstock.com.br.embedstock.model;

public class Estoque {

    private Long id_Estoque;
    private Long id_Produto;
    private int quantidade;
    private String local;
    private Produto produto;

    public Estoque(Long id_Estoque, Long id_Produto, String local, int quantidade) {
        this.id_Estoque = id_Estoque;
        this.id_Produto = id_Produto;
        this.local = local;
        this.quantidade = quantidade;
    }

    public Long getId_Estoque() {
        return id_Estoque;
    }

    public void setId_Estoque(Long id_Estoque) {
        this.id_Estoque = id_Estoque;
    }

    public Long getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(Long id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
