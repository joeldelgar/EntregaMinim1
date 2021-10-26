package edu.upc.dsa;

import java.util.List;

public interface ProductManager {
    public List<Product> llistaProductesOrdenats();
    public void ferComanda();
    public void servirComanda();
    public List<String> comandesCliente(String nom);
    public List<Product> llistaproductesV();
    public int numComandes();
    public void addProduct(String nom, double preu);
    public void addClient(String nom);
    public Client BuscaClient (String nom);
}
