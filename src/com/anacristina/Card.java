package com.anacristina;

public class Card {
    private String valor;
    private String palo;
    private String color;

    Card (String palo, String color, String valor){

        this.valor = valor;
        this.palo = palo;
        this.color = color;
    }
    Card (String palo,String color){
        this.palo = palo;
        this.color = color;
    }
    public String getPalo(){
        return palo;
    }
    public void setPalo(String palo){
        this.palo = palo;
    }
    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        if (valor <= 10){
            if (valor==1)this.valor = "A";
            this.valor=valor.toString();
        }
        else {
            if (valor==11)this.valor = "J";
            else if (valor==12)this.valor="Q";
            else this.valor="k";

        }
    }
    @Override
    public String toString(){
        return "valor="+valor+", palo="+palo+",color="+color;
    }
}

