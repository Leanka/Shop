package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Basket{
    private ArrayList <Product> productList = new ArrayList<Product>();

    public Iterator getIterator(){
        return new ProductIterator();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public boolean removeProduct(Product product){
        if(productList.remove(product)){
            return true;
        }else{
            return false;
        }
    }

    public int getBasketQuantity(){
        return this.productList.size();
    }

    public void clearBasket(){
        productList.clear();
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
