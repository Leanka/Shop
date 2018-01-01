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
        
        boolean toContinue = true;
        do{
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                createNewProduct();
            }else if(userChoice.equals("2")){
                removeProduct(); 
            }else if(userChoice.equals("3")){
                showAllProduct();
            }else{
                view.print("Incorrect choice.");
            }
        }while(toContinue);
    }

    public void categoryOptions(){
        String [] list = {"Category options:",
                        "  1.Add new category",
                        "  2.Add new featured product category",
                        "  3.Show all categories",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                addNewCategory();
            }else if(userChoice.equals("2")){
                addNewFeaturedCategory();
            }else if(userChoice.equals("3")){
                showAllCategories();
            }else{
                view.print("Incorrect choice.");
            }
        }while(toContinue);
    }

    public void browseOptions(){
        String [] list = {"Browse options:",
                        "  1.browse all products",
                        "  2.browse products by category",
                        "  3.Check product availability",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                getProduct();
            }else if(userChoice.equals("2")){
                getProductByCategory();
            }else if(userChoice.equals("3")){
                checkProductAvailability();
            }else{
                view.print("Incorrect choice.");
            }
        }while(toContinue);
    }
    //
    private void createNewProduct(){
        ProductCategory productCategory = getCategory();
        String name = view.getInput("Pass new products name: ");
        float price;
        try{
            price = Float.valueOf(view.getInput("Pass new products price: "));
        }catch(NumberFormatException error_message){
            view.print(error_message);
            view.print("Adding product terminated.");
            return;
        }

        new Product(name, price, productCategory);

    }

    private void removeProduct(){
        this.product.removeProduct(getProduct()); //zabezpieczyć przed złym wyborem/mozliwosc wycofania sie
    }

    private void showAllProduct(){
        ArrayList <Product> productList = product.getAllProducts();
        view.print("All products:");
        for(int index = 0; index < productList.size(); ++index){
            view.print(productList.get(index).toString());
        }
        view.print();
    }
    //
    private void addNewCategory(){
        ; //choice feat or not
    }

    private void addNewFeaturedCategory(){
        ; //choice feat or not
    }

    private void showAllCategories(){
        ;
    }
    //
    private Product getProduct(){
        return new Product();
    }

    private ProductCategory getCategory(){
        return new ProductCategory();
    }

    private Product getProductByCategory(){
        return new Product();
    }

    private void checkProductAvailability(){
        ;
    }

    
}