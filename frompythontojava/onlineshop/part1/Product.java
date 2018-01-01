package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private final Integer ID;
    private static Integer idCounter = 0;
    private static ArrayList <Product> productList = new ArrayList<Product>();

    public Product(){
        this.name = "NONE";
        this.defaultPrice = 0.0f;
        this.productCategory = new ProductCategory();
        this.ID = ++idCounter;
    }

    public Product(String name, Float defaulPrice, ProductCategory productCategory){
        this.name = name;
        this.defaultPrice = defaulPrice;
        this.productCategory = productCategory;
        this.ID = ++idCounter;

        addProduct(this);
    }

    public String toString(){
        return "ID:" + this.ID + 
                ",name:" +this.name + 
                ",price: " + this.defaultPrice + "," + 
                this.productCategory.getInfo();    
        
    }

    public ArrayList <Product> getAllProducts(){
        return productList;
    }

    public ArrayList <Product> getAllProductsBy(ProductCategory productCategory){
        ArrayList <Product> productsByCategory = new ArrayList<Product>();
        for(int index = 0; index < productList.size(); ++index){
            Product product = productList.get(index);
            if(productCategory == product.productCategory){
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public static Integer getIdCounter(){
        return idCounter;
    }

    public boolean removeProduct(Product porductToRemove){
        if(productList.remove(porductToRemove)){
            return true;
        }
        return false;
    }

    public void addProduct(Product porductToAdd){
        productList.add(porductToAdd);
    }

    public Integer getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public Float getDefaultPrice(){
        return this.defaultPrice;
    }
}
