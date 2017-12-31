package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess{
    protected void action(Orderable item){
        if(item.pay()){
            System.out.println("Status has been succesfully changed to " + ((Order)item).getStatus());
        }else{
            System.out.println("Invalid operation. Current status (" + ((Order)item).getStatus() + ") requiers different action.");
        }
    }

    
}