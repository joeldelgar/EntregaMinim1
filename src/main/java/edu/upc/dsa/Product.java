package edu.upc.dsa;

public class Product implements Comparable<Product> {

    //Atributs ------------------------------------------------------------------------
    public String product;
    public double price;
    public int numV;

    //Constructors --------------------------------------------------------------------
    public Product(String prod, double pri){
        this.product = prod;
        this.price = pri;
        this.numV =0;
    }

    public Product(){}


    //Setters i Getters ---------------------------------------------------------------

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getNumV() {
        return numV;
    }

    //Funció per incrementar el nombre de productes que s'han venut
    public void addnumV(int c){
        numV= numV+c;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
