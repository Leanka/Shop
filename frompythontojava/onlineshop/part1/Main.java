package frompythontojava.onlineshop.part1;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ProductCategory prodCatTest = new ProductCategory();
        Product productTest = new Product();
        Basket basketTest = new Basket();

        ProductCategory cakesCategory = new ProductCategory("Cakes");
        Date currentDate = Calendar.getInstance().getTime();

        FeaturedProductCategory fpc = new FeaturedProductCategory("Chocolate cakes", currentDate);

        Product applePie = new Product("Apple pie", (float) 3.14, cakesCategory); //(float) 3.14 or 3.14f
        Product bananaPie = new Product("Banana pie", (float) 7.14, cakesCategory);
        Product brownie = new Product("Brownie", (float) 9.14, fpc);
        Product chocolatePie = new Product("Chocolate pie", (float) 5.14, fpc);
        Product carmelPie = new Product("Carmel pie", (float) 6.5, fpc);
        Product berryPie = new Product("Berry pie", (float) 14, cakesCategory);
        
        //Date
        System.out.println();
        System.out.println("   --->Date instance checking:");

        if(currentDate instanceof Date){
            System.out.println("currentDate IS an instance of Date");
            FeaturedProductCategory featuredProductCategory = new FeaturedProductCategory("Fruit Cakes", currentDate);
            
            //ProductCategory
            System.out.println();
            System.out.println("   --->ProductCategory instance checking:");

            if(featuredProductCategory instanceof ProductCategory){
                System.out.println("featuredProductCategory IS an instance of ProductCategory");
            }
            if(featuredProductCategory instanceof FeaturedProductCategory){
                System.out.println("featuredProductCategory IS an instance of FeaturedProductCategory");
            }
            if(!(cakesCategory instanceof FeaturedProductCategory)){
                System.out.println("cakesCategory (ProductCategory) IS NOT an instance of FeaturedProductCategory");
            }
            System.out.println();
            System.out.println("fpc.toString(): " + fpc.toString());
            System.out.println("fpc.getInfo(): " + fpc.getInfo());
    
            System.out.println();
            System.out.println("cakesCategory.toString(): " + cakesCategory.toString());
            System.out.println("cakesCategory.getInfo(): " + cakesCategory.getInfo());
            
            System.out.println();
            System.out.println("   --->Check ProductCategory & FeaturedProductCategory identity & equality:");
            System.out.println("fpc: " + fpc);
            System.out.println("cakesCategory: " + cakesCategory);
            
            System.out.println("cakesCategory == fpc: " + String.valueOf(cakesCategory == fpc));
            System.out.println("cakesCategory.equals(fpc): " + cakesCategory.equals(fpc));
    
            System.out.println("fpc == fpc: " + String.valueOf(fpc == fpc));
            System.out.println("fpc.equals(fpc): " + fpc.equals(fpc));

            System.out.println();
            System.out.println("   --->ProductCategory id counter checking:");
            System.out.println("  Id count: " + ProductCategory.getIdCounter());

            System.out.println("  Call ProductCategory constructor with no parameters.");
            ProductCategory testIdCount = new ProductCategory();

            System.out.println("  Call FeaturedProductCategory constructor wich inherits from ProductCategory.");
            FeaturedProductCategory testIdCountFeaturedPC = new FeaturedProductCategory("Food", currentDate);

            System.out.println("  Id count: " + ProductCategory.getIdCounter());


        }else{
            System.out.println("Is not an instance of Date");
        }

        //Product
        System.out.println();
        System.out.println("   --->Product instance checking:");

        if(applePie.getAllProducts() instanceof ArrayList){
            System.out.println("getAllProducts from Product class returns an ArrayList");
        }else{
            System.out.println("getAllProducts from Product class IS NOT returning an ArrayList");
        }

        ArrayList <Product> productsByCategory = brownie.getAllProductsBy(cakesCategory);
        
        if(productsByCategory instanceof ArrayList){
            System.out.println("getAllProductsBy from Product class returns an ArrayList");
        }else{
            System.out.println("getAllProductsBy from Product class IS NOT returning an ArrayList");
        }

        System.out.println();
        System.out.println("   --->Product getAllProductsBy() checking:");
        for(int index = 0; index < productsByCategory.size(); ++index){
            Product product = productsByCategory.get(index);
            System.out.println("  Products by | " + product.toString());
        }
        
        System.out.println();
        System.out.println("   --->Product id counter checking:");
        System.out.println("  Id count: " + Product.getIdCounter());

        System.out.println("  Call Product constructor with no parameters.");
        Product testProductIdCount = new Product();

        System.out.println("  Call Product constructor with parameters.");
        Product testProductIdCount2 = new Product("Strudel", (float) 10, cakesCategory);;

        System.out.println("  Id count: " + Product.getIdCounter());
        
        System.out.println();
        System.out.println("   --->Product getAllProducts() checking:");
        ArrayList <Product> allProducts = brownie.getAllProducts();        
        for(int index = 0; index < allProducts.size(); ++index){
            Product product = allProducts.get(index);
            System.out.println("  Products by | " + product.toString());
        }

        //Basket & Iterator
        System.out.println();
        System.out.println("   --->Basket & Iterator instance checking:");

        Basket myBasket = new Basket();
        frompythontojava.onlineshop.part1.Iterator iterProduct = myBasket.getIterator();

        if(iterProduct instanceof Iterator){
            System.out.println("getIterator from " + myBasket.getClass().getSimpleName() + " IS returning Iterator instance");
        }

        myBasket.addProduct(applePie);
        myBasket.addProduct(bananaPie);
        myBasket.addProduct(chocolatePie);
        myBasket.addProduct(brownie);
        myBasket.addProduct(carmelPie);
        myBasket.addProduct(berryPie);
        myBasket.addProduct(brownie);
        
        
        //iteration
        System.out.println();
        System.out.println("   --->Iterator checking:");
        while(iterProduct.hasNext()){
            Product product = (Product)iterProduct.next();
            System.out.println("  Iterator usage | " + product.toString());
        }

        System.out.println();
        System.out.println("  Delete product:");
        if(myBasket.removeProduct(bananaPie)){
            System.out.println("  Product removed");
        }

        System.out.println();
        System.out.println("   --->New iterator checking:");
        for(int i = 0; i < 2; ++i){
            frompythontojava.onlineshop.part1.Iterator secondIteration = myBasket.getIterator();
            while(secondIteration.hasNext()){
                Product product = (Product)secondIteration.next();
                System.out.println("  New Iterator usage | " + product.toString());
            }

            System.out.println();
            System.out.println("  Delete product:");
            if(myBasket.removeProduct(brownie)){
                System.out.println("   Product removed");
            }else{
                System.out.println("   No such product in basket");
            }
            System.out.println();
        }
    }
}
