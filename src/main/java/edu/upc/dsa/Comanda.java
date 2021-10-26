package edu.upc.dsa;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comanda {

    private Client client;
    public List<ListarPedidos> comanda = new ArrayList<>();
    private String producte;

    Comanda(Client c){
        this.client = c;
        this.producte = "Comanda realitzada: "+ LocalDateTime.now()+"\n";
    }

    public void addLlistaComandes(int c, String nom){
        ListarPedidos product  = new ListarPedidos(c, nom);
        this.comanda.add(product);
    }

    public void ServirComanda(HashMap<String,Product> cataleg){
        for(int i=0; i<comanda.size();i++){
            ListarPedidos element = comanda.get(i);
            Product product = cataleg.get(element.getName());
            product.addnumV(element.getCan());
        }
        this.producte+= "Entrega: "+LocalDateTime.now();
        client.addComanda(producte,comanda);
    }

}
