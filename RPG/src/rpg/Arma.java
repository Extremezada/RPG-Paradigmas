package rpg;
public class Arma {
    private int ataqueDefesa;
    private double peso;
    private String tipo;
    private String posicaoArma;
    
    public Arma(int ataqueDefesa, double peso, String tipo, String posicaoArma){
        this.ataqueDefesa = ataqueDefesa;
        this.peso = peso;
        this.tipo = tipo;
        this.posicaoArma = posicaoArma;
    }

    public int getAtaqueDefesa() {
        return this.ataqueDefesa;
    }

    public void setAtaqueDefesa(int ataqueDefesa) {
        this.ataqueDefesa = ataqueDefesa;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getPosicaoArma() {
        return posicaoArma;
    }
    public void setPosicaoArma(String posicaoArma) {
        this.posicaoArma = posicaoArma;
    }
    
    @Override
    public String toString(){
        return "\tArma: "+ this.tipo + "\tAtaque: "+ this.getAtaqueDefesa() + "\tPeso: " +this.peso;
    }
}
