package frompythontojava.onlineshop.part1;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ProductCategory prodCatTest = new ProductCategory();
        Product productTest = new Product();
        Basket basketTest = new Basket();
        ProductIterator productIteratorTest = new ProductIterator();

        Basket basket = new Basket();
        basket.getIterator();
        basket.addProduct(new Product());
        if(!(basket.removeProduct(new Product()))){
            System.out.println("Product removed");
        }
        ProductCategory cakesCategory = new ProductCategory("Cakes");

        Date currentDate = Calendar.getInstance().getTime();
        if(currentDate instanceof Date){
            System.out.println("currentDate IS an instance of Date");
            FeaturedProductCategory featuredProductCategory = new FeaturedProductCategory("Fruit Cakes", currentDate);
            if(featuredProductCategory instanceof ProductCategory){
                System.out.println("featuredProductCategory IS an instance of ProductCategory");
            }
            if(featuredProductCategory instanceof FeaturedProductCategory){
                System.out.println("featuredProductCategory IS an instance of FeaturedProductCategory");
            }
            if(!(cakesCategory instanceof FeaturedProductCategory)){
                System.out.println("cakesCategory IS NOT an instance of ProductCategory");
            }
        }else{
            System.out.println("Is not an instance of Date");
        }

        Product applePie = new Product("Apple pie", (float) 3.14, cakesCategory); //(float) 3.14 or 3.14f
        Product bananaPie = new Product("Banana pie", (float) 7.14, cakesCategory);
        System.out.println(applePie.toString());
        System.out.println(bananaPie.toString());

        if(applePie.getAllProducts() instanceof ArrayList){
            System.out.println("getAllProducts from Product class returns an ArrayList");
        }else{
            System.out.println("getAllProducts from Product class IS NOT returning an ArrayList");
        }

        if(bananaPie.getAllProductsBy(cakesCategory) instanceof ArrayList){
            System.out.println("getAllProductsBy from Product class returns an ArrayList");
        }else{
            System.out.println("getAllProductsBy from Product class IS NOT returning an ArrayList");
        }

        Basket myBasket = new Basket();
        if(myBasket.getIterator() instanceof ProductIterator && myBasket.getIterator() instanceof Iterator){
            System.out.println("getIterator from " + myBasket.getClass().getSimpleName() + " IS returning Iterator & ProductIterator instance");
        }else{
            System.out.println("getIterator from " + myBasket.getClass().getSimpleName() + " IS NOT returning Iterator & ProductIterator instance");
        }
        myBasket.addProduct(applePie);
        myBasket.removeProduct(applePie);
    }
}
