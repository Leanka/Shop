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
        if(productList.remove(product)){
            return true;
        }else{
            return false;
        }
    }
    
    private class ProductIterator implements Iterator{
        private int index = 0;

        @Override
        public boolean hasNext(){
            if(index < productList.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next(){
            if(this.hasNext()){
                return productList.get(index++);
            }
            return null;
        }
    }
}
