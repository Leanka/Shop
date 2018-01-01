package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part2.Order;
import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.Iterator;
import frompythontojava.onlineshop.part2.PaymentProcess;
import frompythontojava.onlineshop.part2.CheckoutProcess;

public class Client{
    private final int INCORRECT_INPUT = -1;
    private View view = new View();
    private Basket basket;
    private Order order;
    private Stock stock;


    public Client(Stock stock){
        this.basket = new Basket();
        this.order = new Order();
        this.stock = stock;
    }


    public void startShopping(){
        String [] list = {"Client options:",
                        "  1.Product & category options",
                        "  2.Basket options",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            this.view.clearScreen();
            showClientsInfo();
            this.view.showList(list);
            String userChoice = this.view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                productAndCategoryOptions();
            }else if(userChoice.equals("2")){
                baskeOptions();
            }else{
                this.view.print("Incorrect choice.");
            }
        }while(toContinue);
    }

    private void productAndCategoryOptions(){
        String [] list = {"Product & category options:",
                        "  1.Show all products",
                        "  2.Show all products by category",
                        "  3.Show all categories",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            this.view.clearScreen();
            showClientsInfo();
            this.view.showList(list);
            String userChoice = this.view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                this.stock.showAllProduct();
                this.view.holdTillKeyPressed();
            }else if(userChoice.equals("2")){
                this.stock.showAllProductsInCategory();
                this.view.holdTillKeyPressed();
            }else if(userChoice.equals("3")){
                this.stock.showAllCategories();
                this.view.holdTillKeyPressed();
            }else{
                this.view.print("Incorrect choice.");
                this.view.holdTillKeyPressed();
            }
        }while(toContinue);
    }

    private void baskeOptions(){
        String [] list = {"Basket options:",
                        "  1.Add product to basket",
                        "  2.Remove product From basket",
                        "  3.Check my basket",
                        "  4.Pay",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            this.view.clearScreen();
            showClientsInfo();
            this.view.showList(list);
            String userChoice = this.view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                addProductToBasket();
            }else if(userChoice.equals("2")){
                removeProductFromBasket();
            }else if(userChoice.equals("3")){
                checkoutBasket();
                showMyBasket();
                this.view.holdTillKeyPressed();
            }else if(userChoice.equals("4")){
                pay();
                this.view.holdTillKeyPressed();
            }else{
                this.view.print("Incorrect choice.");
                this.view.holdTillKeyPressed();
            }
        }while(toContinue);
    }

    private void pay(){
        if(this.basket.getBasketQuantity() == 0){
            this.view.print("Nothing to pay for");
            return;
        }

        PaymentProcess paymentProcess = new PaymentProcess();
        paymentProcess.process(this.order);

        if(this.order.getStatus().equals("payed")){
            this.view.print("Order number " + this.order.getId() + " has been payed.");
            this.view.print("Your basket is empty!");
            this.basket.clearBasket();
            setNewOrder();
        }
    }

    private void checkoutBasket(){
        if(this.basket.getBasketQuantity() == 0){
            this.view.print("Nothing to check");
            return;
        }
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        checkoutProcess.process(this.order);
    }

    private void showOrderStatus(){
        this.view.print("Order (ID:" + this.order.getId() + ") status: " + this.order.getStatus());
    }
    private void showBasketStatus(){
        this.view.print("Basket quantity: " + this.basket.getBasketQuantity());
    }

    private void showClientsInfo(){
        showBasketStatus();
        showOrderStatus();
        this.view.print();
    }

    private void addProductToBasket(){
        Product chosenProduct = this.stock.getProduct();
        if(chosenProduct == this.stock.getPRODUCT()){
            this.view.print("Incorrect product choice. Operation terminated");
            this.view.holdTillKeyPressed();
        }else{
            this.basket.addProduct(chosenProduct);
            this.stock.removeProduct(chosenProduct);
            this.order.resetStatus();
        }
    }

    private void removeProductFromBasket(){
        if(this.basket.getBasketQuantity() == 0){
            this.view.print("Basket is empty.");
            this.view.holdTillKeyPressed();
            return;
        }

        Product chosenProduct = getProductFromBasket();

        if(chosenProduct == this.stock.getPRODUCT()){
            this.view.print("Incorrect product choice. Operation terminated");
            this.view.holdTillKeyPressed();
            return;
        }

        if(this.basket.removeProduct(chosenProduct)){
            this.stock.getPRODUCT().addProduct(chosenProduct);
            this.order.resetStatus();
        }
    }

    private Product getProductFromBasket(){
        showMyBasket();

        Integer productId = this.stock.getNumberFromUser("Pass Product ID: ");
        if(productId == this.INCORRECT_INPUT){
            this.view.print("Incorrect product choice. Operation terminated");
            return this.stock.getPRODUCT();
        }

        Product chosenProduct = this.stock.getPRODUCT();
        Iterator iterateBasket = this.basket.getIterator();
        while(iterateBasket.hasNext()){
            Product productInBasket = (Product)iterateBasket.next();
            if(productId.equals(productInBasket.getID())){
                chosenProduct = productInBasket;
            }
        }
        return chosenProduct;
    }

    private void showMyBasket(){
        if(this.basket.getBasketQuantity() == 0){
            this.view.print("No products in basket");
            return;
        }

        Iterator iterateBasket = this.basket.getIterator();

        this.view.print();
        this.view.print("Products in your basket:");
        while(iterateBasket.hasNext()){
            Product productInBasket = (Product)iterateBasket.next();
            this.view.print(productInBasket.toString());
        }
        this.view.print();     
    }

    public void setNewOrder(){
        this.order = new Order();
    }

}
