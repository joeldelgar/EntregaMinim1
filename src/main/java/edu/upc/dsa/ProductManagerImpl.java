package edu.upc.dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager{

    private Queue<Comanda> servei = new LinkedList<Comanda>();
    private HashMap<String,Product> cataleg = new HashMap<>();
    private HashMap<String,Client> clients = new HashMap<>();

    final static Logger logger = Logger.getLogger(String.valueOf(ProductManagerImpl.class));

    private static ProductManagerImpl manager;
    private ProductManagerImpl(){}

    public static ProductManagerImpl getInstance(){
        if(manager==null){
            manager=new ProductManagerImpl();
        }
        return manager;
    }


    @Override
    public List<Product> llistaProductesOrdenats() {
        return null;


    @Override
    public void ferComanda(Comanda comanda) {
        servei.add(comanda);
    }

    @Override
    public void servirComanda() {
        Comanda c = servei.poll();
        c.ServirComanda(cataleg);
    }

    @Override
    public List<String> comandesCliente(String nom) {
        return clients.get(nom).listarpedidos();
    }

    @Override
    public List<Product> llistaproductesV() {
        return null;
    }

    @Override
    public int numComandes() {
        return servei.size();
    }

    @Override
    public void addProduct(String nom, double preu) {
        cataleg.put(nom,new Product(nom,preu));
    }

    @Override
    public void addClient(String nom) {
        clients.put(nom, new Client(nom));
    }

    @Override
    public Client BuscaClient(String nom) {
        return clients.get(nom);
    }


}
