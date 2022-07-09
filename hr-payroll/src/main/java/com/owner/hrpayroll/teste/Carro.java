package com.owner.hrpayroll.teste;

public class Carro {

    private String marca;
    private String cor;

    public Carro(String marca, String cor) {
        this.marca = marca;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String modificar() {
        return "Motor trocado!!" + marca + cor;
    }
}
