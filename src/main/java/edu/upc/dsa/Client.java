package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private ArrayList<String> pedidos = new ArrayList<>();
    private List<List<ListarPedidos>> comandes = new ArrayList<>();

    Client (String n){
        this.name = n;
    }

    public ArrayList<String> listarpedidos(){
        return pedidos;
    }

    public void addComanda (String p, List<ListarPedidos> l){
        pedidos.add(p);
        comandes.add(l);
    }
}
