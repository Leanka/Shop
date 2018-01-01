package frompythontojava.onlineshop.part3;

import java.util.ArrayList;

import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;
import frompythontojava.onlineshop.part1.FeaturedProductCategory;
import frompythontojava.onlineshop.part1.ExpirationDate;
import java.util.Date;

public class Stock{
    private final Product PRODUCT = new Product();  // field is used to get acces to Product static field and as a flag (indicates incorrect choice)
    private View view = new View();
    private ArrayList <ProductCategory> productCategory = new ArrayList <ProductCategory>();
    private final int INCORRECT_INPUT = -1;
    private final ProductCategory CATEGORY = new ProductCategory();

    public Stock(){
        //Add some test Categories & products for testing purpose

        ProductCategory fruits = new ProductCategory("Fruits");
        ProductCategory vegetables = new ProductCategory("Vegetable");
        
        this.productCategory.add(fruits);
        this.productCategory.add(vegetables);
        this.productCategory.add(new ProductCategory("Baked goods"));

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
        if(chosenCategory == this.CATEGORY){
            this.view.print("Adding product terminated.");
            return;
        }
        String name = this.view.getInput("Pass new products name: ");
        
        float price;
        try{
            price = Float.valueOf(view.getInput("Pass new products price: "));
        }catch(NumberFormatException errorMessage){
            this.view.print(errorMessage);
            this.view.print("Adding product terminated.");
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
        if(chosenProduct == this.PRODUCT){
            this.view.print("Incorrect product choice. Operation terminated");
        }else{
            this.PRODUCT.removeProduct(chosenProduct);
        } 
    }

    public void removeProduct(Product chosenProduct){
            this.PRODUCT.removeProduct(chosenProduct);

    }

    public void showAllProduct(){
        ArrayList <Product> productList = this.PRODUCT.getAllProducts();
        this.view.print("All products:");
        for(int index = 0; index < productList.size(); ++index){
            this.view.print(productList.get(index).toString());
        }
        view.print();
    }
    
    public void addNewCategory(){
        String categoryName = view.getInput("Pass category name: ");
        this.productCategory.add(new ProductCategory(categoryName));
    }

    public void addNewFeaturedCategory(){
        String categoryName = view.getInput("Pass category name: ");

        ExpirationDate getDate = new ExpirationDate();
        Date expirationDate = getDate.getEspiriationDate();
        productCategory.add(new FeaturedProductCategory(categoryName, expirationDate));
    }

    public void showAllCategories(){
        this.view.print("All categories:");
        for(int index = 0; index < this.productCategory.size(); ++index){
            this.view.print("ID: " + this.productCategory.get(index).getID() + 
                        ". " + this.productCategory.get(index).getInfo());
        }
        this.view.print();
    }

    public Integer getNumberFromUser(String message){
        Integer itemId = INCORRECT_INPUT;
        try{
            itemId = Integer.valueOf(view.getInput(message));
        }catch(NumberFormatException errorMessage){
            this.view.print(errorMessage);
            this.view.print("Getting input terminated.");
        }
        return itemId;
    }

    public Product getProduct(){
        showAllProduct();
        Integer productId = getNumberFromUser("Pass Products ID: ");
        if(productId == this.INCORRECT_INPUT){
            return this.PRODUCT;
        }

        ArrayList <Product> productsList = this.PRODUCT.getAllProducts();
        for(int index = 0; index < productsList.size(); ++index){
            if(productId.equals(productsList.get(index).getID())){
                return productsList.get(index);
            }
        }
        return this.PRODUCT;
    }

    public ProductCategory getCategory(){
        showAllCategories();
        Integer categoryId = getNumberFromUser("Pass category ID: ");
        if(categoryId == this.INCORRECT_INPUT){
            return this.CATEGORY;
        }

        for(int index = 0; index < this.productCategory.size(); ++index){
            if(categoryId.equals(this.productCategory.get(index).getID())){
                return this.productCategory.get(index);
            }
        }
        return this.CATEGORY;
    }
    public void showAllProductsInCategory(){
        ProductCategory chosenCategory = getCategory();
        if(chosenCategory == this.CATEGORY){
            this.view.print("Adding product terminated.");
            return;
        }

        ArrayList <Product> allProductsByChosenCategory = PRODUCT.getAllProductsBy(chosenCategory);
        if(allProductsByChosenCategory.size() == 0){
            this.view.print("No products in " + chosenCategory.getName() + " category");
            return;
        }

        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            view.print(chosenCategory.toString() + allProductsByChosenCategory.get(index).toString());
        } 
    }

    public Product getProductByCategory(){
        ProductCategory chosenCategory = getCategory();
        if(chosenCategory == this.CATEGORY){
            return this.PRODUCT;
        }

        ArrayList <Product> allProductsByChosenCategory = this.PRODUCT.getAllProductsBy(chosenCategory);
        if(allProductsByChosenCategory.size() == 0){
            this.view.print("No products in " + chosenCategory.getName() + " category");
            return this.PRODUCT;
        }
        
        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            view.print(chosenCategory.toString() + allProductsByChosenCategory.get(index).toString());
        }
        
        Integer productId = getNumberFromUser("Pass Product ID: ");
        if(productId == this.INCORRECT_INPUT){
            return this.PRODUCT;
        }
        for(int index = 0; index < allProductsByChosenCategory.size(); ++index){
            if(productId.equals(allProductsByChosenCategory.get(index).getID())){
                return allProductsByChosenCategory.get(index);
            }
        }
        return this.PRODUCT;
    }

    public void checkProductAvailability(){
        String productName = view.getInput("Pass wanted products name: ");

        ArrayList <Product> productsList = this.PRODUCT.getAllProducts();
        int itemCounter = 0;
        for(int index = 0; index < productsList.size(); ++index){
            if(productName.equalsIgnoreCase(productsList.get(index).getName())){
                ++itemCounter;
            }
        }
        if(itemCounter == 0){
            this.view.print("No such product in the stock");
        }else{
            this.view.print("There are " + itemCounter + " " + productName + " in the stock.");
        }
    }  
}