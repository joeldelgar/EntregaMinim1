package edu.upc.dsa;

public class ListarPedidos {
    private int can;
    private String name;

    ListarPedidos(int c, String n){
        this.can = c;
        this.name = n;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
