package frompythontojava.onlineshop.part1;

import java.util.ArrayList;
import frompythontojava.onlineshop.part1.ProductIterator;  //Potrzebne?

public class Basket{
    private ArrayList <Product> productList;
    private ProductIterator iterator; //? bez new? skoro nie ma konstruktora, to nie powinno byc tu?

    public Iterator getIterator(){
        return this.iterator; //new Iterator?
    }

    public void addProduct(Product product){
        ;
    }

    public boolean removeProduct(Product product){
        ;
    }
}
