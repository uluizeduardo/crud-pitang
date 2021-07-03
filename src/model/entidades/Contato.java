package model.entidades;

public class Contato {
    private Integer ddd;
    private String numero;
    private String tipo;

    public Contato(){

    }

    public Contato(Integer ddd, String numero, String tipo) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "ddd=" + ddd +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
