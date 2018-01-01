package frompythontojava.onlineshop.part2;

public class CheckoutProcess extends AbstractProcess{

    protected void action(Orderable item){
        if(item.checkout()){
            System.out.println("Status has been succesfully changed to " + ((Order)item).getStatus());
        }else if(((Order)item).getStatus().equals("checked")){
            System.out.println("Invalid operation: Order was already checked.");
        }else if(((Order)item).getStatus().equals("payed")){
            System.out.println("Order was already checked and payed.");
        }
    }
    
}