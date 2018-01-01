package frompythontojava.onlineshop.part3;

public class Staff{
    private View view = new View();
    private Stock stock;
    
    public Staff(Stock stock){
        this.stock = stock;
    }

    public void startShopping(){
        String [] list = {"Staff options:",
                        "  1.Product options",
                        "  2.Category options",
                        "  3.Browse options",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.clearScreen();
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                productOptions();
            }else if(userChoice.equals("2")){
                categoryOptions();
            }else if(userChoice.equals("3")){
                browseOptions();
            }else{
                view.print("Incorrect choice.");
            }
        }while(toContinue);
    }

    private void productOptions(){
        String [] list = {"Product options:",
                        "  1.Add new product",
                        "  2.Remove product",
                        "  3.Show all products",
                        "  4.Show all products by category",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.clearScreen();
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                this.stock.createNewProduct();
                view.holdTillKeyPressed();
            }else if(userChoice.equals("2")){
                this.stock.removeProduct();
                view.holdTillKeyPressed();
            }else if(userChoice.equals("3")){
                this.stock.showAllProduct();
                view.holdTillKeyPressed();
            }else if(userChoice.equals("4")){
                this.stock.showAllProductsInCategory();
            }else{
                view.print("Incorrect choice.");
                view.holdTillKeyPressed();
            }
        }while(toContinue);
    }

    private void categoryOptions(){
        String [] list = {"Category options:",
                        "  1.Add new category",
                        "  2.Add new featured product category",
                        "  3.Show all categories",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.clearScreen();
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                this.stock.addNewCategory();
                view.holdTillKeyPressed();
            }else if(userChoice.equals("2")){
                this.stock.addNewFeaturedCategory();
                view.holdTillKeyPressed();
            }else if(userChoice.equals("3")){
                this.stock.showAllCategories();
                view.holdTillKeyPressed();
            }else{
                view.print("Incorrect choice.");
                view.holdTillKeyPressed();
            }
        }while(toContinue);
    }

    private void browseOptions(){
        String [] list = {"Browse options:",
                        "  1.Check product availability",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            view.clearScreen();
            view.showList(list);
            String userChoice = view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                this.stock.checkProductAvailability();
                view.holdTillKeyPressed();
            }else{
                view.print("Incorrect choice.");
                view.holdTillKeyPressed();
            }
        }while(toContinue);
    }
}