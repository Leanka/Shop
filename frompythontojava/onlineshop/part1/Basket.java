package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Basket{
    private ArrayList <Product> productList;
    private ProductIterator iterator = new ProductIterator();

    public Iterator getIterator(){
        return this.iterator;
    }

    public void addProduct(Product product){
        ;
    }

    public boolean removeProduct(Product product){
        return false;
    }
    
    private class ProductIterator implements Iterator{
        private int index = 0;

        public boolean hasNext(){
            if(index < productList.size()){
                return true;
            }
            return false;
        }
        public Object next(){
            return null;
        }
    }
}
