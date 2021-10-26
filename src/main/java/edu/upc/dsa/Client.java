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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<String> pedidos) {
        this.pedidos = pedidos;
    }

    public List<List<ListarPedidos>> getComandes() {
        return comandes;
    }

    public void setComandes(List<List<ListarPedidos>> comandes) {
        this.comandes = comandes;
    }
}
