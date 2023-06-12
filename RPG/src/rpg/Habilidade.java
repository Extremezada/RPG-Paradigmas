package rpg;

public class Habilidade {
    private String nome, descricao;
    private int poderMinimo;
    private String tipoAtributo;

    public Habilidade(String nome, String descricao, int poderMinimo, String tipoAtributo ){
        this.nome = nome;
        this.descricao = descricao;
        this.poderMinimo = poderMinimo;
        this.tipoAtributo = tipoAtributo;
    }

    public String getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(String tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getPoderMinimo() {
        return poderMinimo;
    }
    public void setPoderMinimo(int poderMinimo) {
        this.poderMinimo = poderMinimo;
    }


}
