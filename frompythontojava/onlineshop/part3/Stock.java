package frompythontojava.onlineshop.part3;

import java.util.ArrayList;

import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;

public class Stock{
    private Product product = new Product();
    private ArrayList <ProductCategory> productCategory = new ArrayList <ProductCategory>();
    private View view = new View();

    //menu
    public void productOptions(){
        String [] list = {"Product options:",
                        "  1.Add new product",
                        "  2.Remove product",
                        "  3.Show all products",
                        "  0.Exit",
                        ""};
        view.showList(list);
    }

    public void categoryOptions(){
        ;
    }

    public void browseOptions(){
        ;
    }
    //
    private void addNewProduct(){
        ;
    }

    private void removeProduct(){
        ;
    }

    private void showAllProduct(){
        ;
    }
    //
    private void addNewCategory(){
        ;
    }

    private void removeCategory(){
        ;
    }

    private void showAllCategories(){
        ;
    }
    //
    private Product getProduct(){
        return new Product();
    }

    private Product getCategory(){
        return new Product();
    }

    private Product getProductByCategory(){
        return new Product();
    }

    private void checkProductAvailability(){
        ;
    }

    
}