package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Basket{
    private ArrayList <Product> productList;
    private ProductIterator iterator = new ProductIterator();

    public Iterator getIterator(){
        return new ProductIterator();
    }

    public void addProduct(Product product){
        ;
    }

    public boolean removeProduct(Product product){
        return false;
    }
}
