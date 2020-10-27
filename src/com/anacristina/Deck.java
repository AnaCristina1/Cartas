package com.anacristina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    private HashMap<String,String> palos = new HashMap<String, String>();
    private ArrayList<Card> mazo = new ArrayList<Card>();
    private String strFormat = "Queda %s";
    int a;
    public ArrayList<Card> getMazo(){

        return mazo;
    }
    public void mazo(){
        palos.put("Diamante","rojo");
        palos.put("Trebol", "Negro");
        palos.put("Pica","Negro");
        palos.put("corazon","rojo");
    }
    public void construir(){
        mazo();
        for (Map.Entry<String,String>palo:palos.entrySet()){
            var paloCard =palo.getKey();
            var color = palo.getValue();

            for (int i = 1; i<=13; i++){
                Card card =new Card(paloCard,color);
                card.setValor(i);
                mazo.add(card);
            }
        }
    }
    public void barajear(){
        Collections.shuffle(mazo);
        System.out.println("se mezclo el deck");
    }
    public void head() throws Exception{
        var card = mazo.get((mazo.size()-1));
        mazo.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat, mazo.size()));
        a= mazo.size();
        if (a==0){
            throw new Exception("Se han agotado las cartas");
        } return;
    }
    private Card azar(){
        var max = mazo.size() -1;
        var rd= (int)Math.floor(Math.random()*(0-max+1)+max);
        return mazo.get(rd);
    }
    public Card pick() throws Exception{
        var card =azar();
        mazo.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,mazo.size()));
        a= mazo.size();
        if (a==0){
            throw new Exception("Se han agotado las cartas");
        }
        return card;
    }
    private void printHand (ArrayList<Card> cards){
        for (var card :cards) System.out.println(card.toString());
    }
    public void hand() throws Exception {
        var cards = new ArrayList<Card>();
        if (mazo.isEmpty()) {
            throw new Exception("Se han agotado las cartas");
        }
        else if (mazo.size()<5) {
            throw new Exception("Quedan pocas cartas");
        }
        else {

            for (int i = 1; i <= 5; i++) {

                cards.add(pick());
            }
        }


    }
}