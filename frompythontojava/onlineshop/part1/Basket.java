package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

import frompythontojava.onlineshop.part1.Iterator;

public class Basket{
    private ArrayList <Product> productList;
    private Iterator iterator; //? bez new? skoro nie ma konstruktora, to nie powinno byc tu?

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