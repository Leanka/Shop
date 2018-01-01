package frompythontojava.onlineshop.part3;

import java.util.ArrayList;

import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;
import frompythontojava.onlineshop.part1.FeaturedProductCategory;
import frompythontojava.onlineshop.part1.ExpirationDate;
import java.util.Date;

public class Stock{
    private final Product PRODUCT = new Product();
    private ArrayList <ProductCategory> productCategory = new ArrayList <ProductCategory>();
    private View view = new View();
    private final int INCORRECT_INPUT = -1;
    private final ProductCategory CATEGORY = new ProductCategory();

    public Stock(){
        //Add some test Categories & products for testing purpose

        ProductCategory fruits = new ProductCategory("Fruits");
        ProductCategory vegetables = new ProductCategory("Vegetable");
        
        productCategory.add(fruits);
        productCategory.add(vegetables);
        productCategory.add(new ProductCategory("Baked goods"));

        new Product("Apple", 1.05f, fruits);
        new Product("Mango", 13.50f, fruits);
        new Product("Carrot", 2.35f, vegetables);
        new Product("Garlic", 0.99f, vegetables);
        new Product("Onion", 1.00f, vegetables);
        
    }

    public Product getPRODUCT(){
        return this.PRODUCT;
    }
    
    public void createNewProduct(){
        ProductCategory chosenCategory = getCategory();
        if(chosenCategory == CATEGORY){
            view.print("Adding product terminated.");
            return;
        }
        String name = view.getInput("Pass new products name: ");
        
        float price;
        try{
            price = Float.valueOf(view.getInput("Pass new products price: "));
        }catch(NumberFormatException errorMessage){
            view.print(errorMessage);
            view.print("Adding product terminated.");
            return;
        }

        Integer itemCount = getNumberFromUser("How many products would you like to add? ");
        while(itemCount > 0){
            new Product(name, price, chosenCategory);
            --itemCount;
        }

    }

    public void removeProduct(){
        Product chosenProduct = getProduct();
        if(chosenProduct == PRODUCT){
            view.print("Incorrect product choice. Operation terminated");
        }else{
            this.PRODUCT.removeProduct(chosenProduct);
        } 
    }

    public void removeProduct(Product chosenProduct){
            this.PRODUCT.removeProduct(chosenProduct);

    }

    public void showAllProduct(){
        ArrayList <Product> productList = PRODUCT.getAllProducts();
        view.print("All products:");
        for(int index = 0; index < productList.size(); ++index){
            view.print(productList.get(index).toString());
        }
        view.print();
    }
    
    public void addNewCategory(){
        String categoryName = view.getInput("Pass category name: ");
        productCategory.add(new ProductCategory(categoryName));
    }

    public void addNewFeaturedCategory(){
        String categoryName = view.getInput("Pass category name: ");

        ExpirationDate getDate = new ExpirationDate();
        Date expirationDate = getDate.getEspiriationDate();
        productCategory.add(new FeaturedProductCategory(categoryName, expirationDate));
    }

    public void showAllCategories(){
        view.print("All categories:");
        for(int index = 0; index < productCategory.size(); ++index){
            view.print("ID: " + productCategory.get(index).getID() + 
                        ". " + productCategory.get(index).getInfo());
        }
        view.print();
    }

    public Integer getNumberFromUser(String message){
        Integer itemId = INCORRECT_INPUT;
        try{
            itemId = Integer.valueOf(view.getInput(message));
        }catch(NumberFormatException errorMessage){
            view.print(errorMessage);
            view.print("Getting input terminated.");
        }
        return itemId;
    }

    public Product getProduct(){
        showAllProduct();
        Integer productId = getNumberFromUser("Pass Products ID: ");
        if(productId == INCORRECT_INPUT){
            return PRODUCT;
        }

        ArrayList <Product> productsList = this.PRODUCT.getAllProducts();
        for(int index = 0; index < productsList.size(); ++index){
            if(productId.equals(productsList.get(index).getID())){
                return productsList.get(index);
            }
        }
        return PRODUCT;
    }

    public ProductCategory getCategory(){
        showAllCategories();
        Integer categoryId = getNumberFromUser("Pass category ID: ");
        if(categoryId == INCORRECT_INPUT){
            return CATEGORY;
        }

        for(int index = 0; index < productCategory.size(); ++index){
            if(categoryId.equals(productCategory.get(index).getID())){
                return productCategory.get(index);
            }
        }
        return CATEGORY;
    }
    public void showAllProductsInCategory(){
        ProductCategory chosenCategory = getCategory();
        if(chosenCategory == CATEGORY){
            view.print("Adding product terminated.");
            return;
        }

        ArrayList <Product> allProductsByChosenCategory = PRODUCT.getAllProductsBy(chosenCategory);
        if(allProductsByChosenCategory.size() == 0){
            view.print("No products in " + chosenCategory.getName() + " category");
            return;
        }

        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            view.print(chosenCategory.toString() + allProductsByChosenCategory.get(index).toString());
        } 
    }

    public Product getProductByCategory(){
        ProductCategory chosenCategory = getCategory();
        if(chosenCategory == CATEGORY){
            return PRODUCT;
        }

        ArrayList <Product> allProductsByChosenCategory = PRODUCT.getAllProductsBy(chosenCategory);
        if(allProductsByChosenCategory.size() == 0){
            view.print("No products in " + chosenCategory.getName() + " category");
            return PRODUCT;
        }
        
        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            view.print(chosenCategory.toString() + allProductsByChosenCategory.get(index).toString());
        }
        
        Integer productId = getNumberFromUser("Pass Product ID: ");
        if(productId == INCORRECT_INPUT){
            return PRODUCT;
        }
        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            if(productId.equals(allProductsByChosenCategory.get(index).getID())){
                return allProductsByChosenCategory.get(index);
            }
        }
        return PRODUCT;
    }

    public void checkProductAvailability(){
        String productName = view.getInput("Pass wanted products name: ");

        ArrayList <Product> productsList = this.PRODUCT.getAllProducts();
        int itemCounter = 0;
        for(int index = 0; index < productsList.size(); ++index){
            if(productName.equals(productsList.get(index).getName())){
                ++itemCounter;
            }
        }
        if(itemCounter == 0){
            view.print("No such product in the stock");
        }else{
            view.print("There are " + itemCounter + " " + productName + " in the stock.");
        }
    }  
}