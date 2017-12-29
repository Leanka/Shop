package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID = 1;
    private static ArrayList productList;

    public Product(){
        ;
    }

    public Product(String name, Float defaulPrice, ProductCategory productCategory){
        this.name = name;
        this.defaultPrice = defaulPrice;
        this.productCategory = productCategory;
        this.ID = ID;
    }

    public String toString(){
        return "ID:" + this.ID + ",name:" +this.name + ",price: " + this.defaultPrice + ",category: " + this.productCategory;
    }

    public ArrayList getAllProducts(){
        return new ArrayList();
    }

    public ArrayList getAllProductsBy(ProductCategory productCategory){
        return new ArrayList ();
    }
}