package frompythontojava.onlineshop.part3;

public class Shop{
    private View view = new View();
    private Stock stock;
    private Client client;
    private Staff staff;
    
    public Shop(){
        this.stock = new Stock();
        this.staff = new Staff(this.stock);
        this.client = new Client(this.stock);
    }

    public void shopOptions(){
        String [] list = {"Shop options:",
                        "  1.Log in as staff member",
                        "  2.Log in as client",
                        "  0.Exit",
                        ""};
        
        boolean toContinue = true;
        do{
            this.view.clearScreen();
            this.view.showList(list);
            String userChoice = this.view.getInput("Choose option: ");

            if(userChoice.equals("0")){
                toContinue = false;
            }else if(userChoice.equals("1")){
                this.staff.startShopping();
            }else if(userChoice.equals("2")){
                this.client.startShopping();
            }else{
                this.view.print("Incorrect choice.");
                this.view.holdTillKeyPressed();
            }
        }while(toContinue);
    }
}
