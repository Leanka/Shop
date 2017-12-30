package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static Integer idCounter = 0;
    private static ArrayList <Product> productList = new ArrayList<Product>();

    public Product(){
        this.ID = idCounter++;

        productList.add(this);
    }

    public Product(String name, Float defaulPrice, ProductCategory productCategory){
        this.name = name;
        this.defaultPrice = defaulPrice;
        this.productCategory = productCategory;
        this.ID = idCounter++;

        productList.add(this);
    }

    public String toString(){
        if(this.name == null){
            return "ID:" + this.ID + ",name:UNKNOWN PRODUCT";
        }else{
            return "ID:" + this.ID + 
                    ",name:" +this.name + 
                    ",price: " + this.defaultPrice + "," + 
                    this.productCategory.getInfo();    
        }
        
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

}