package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess{

    protected void action(Orderable item){
        if(item.pay()){
            System.out.println("Status has been succesfully changed to " + ((Order)item).getStatus());
        }else if(((Order)item).getStatus().equals("new")){
            System.out.println("Invalid operation: Order has not been checked. Check order before paying.");
        }else if(((Order)item).getStatus().equals("payed")){
            System.out.println("Order was already checked and payed.");
        }
    }

    
}