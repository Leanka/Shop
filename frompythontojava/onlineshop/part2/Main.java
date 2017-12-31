package frompythontojava.onlineshop.part2;

import java.util.ArrayList;

public class Main {
    private static ArrayList <Order> myOrders = new ArrayList<Order>();

    private static void print(Object message){
        System.out.println(message);
    }

    private static void print(){
        System.out.println();
    }

    private static void showOrdersIdList(){
        print();
        print("  Current Orders id list:");
        for(int index = 0; index < myOrders.size(); ++index){
            print(myOrders.get(index).getId());
        }
        print("Max id is now: " + Order.getIdCounter());
    }

    private static void addOrders(int number){
        print();
        print("  Add " + String.valueOf(number) + " Order instances to orders list.");
        for(int start = number; start > 0; --start){
            myOrders.add(new Order());
        }
    }

    public static void main(String[] args) {
    
    //Order
    print();
    print("   ---> Test Order class");

    Order firstOrder = new Order();
    myOrders.add(firstOrder);

    print();
    if(firstOrder instanceof Orderable){
        print("Order instance IS an instance of Orderable interface");
    }else{
        print("Order instance IS  NOT an instance of Orderable interface");
    }

    print();
    print("Initial order status. STATUS: " + firstOrder.getStatus());
    firstOrder.pay();
    print("Call pay() on new order. STATUS: " + firstOrder.getStatus());
    firstOrder.checkout();
    print("Call checkout() on new order. STATUS: " + firstOrder.getStatus());
    firstOrder.checkout();
    print("Call checkout() on checked order. STATUS: " + firstOrder.getStatus());
    firstOrder.pay();
    print("Call pay() on checked order. STATUS: " + firstOrder.getStatus());
    firstOrder.pay();
    print("Call pay() on payed order. STATUS: " + firstOrder.getStatus());
    
    //CheckoutProcess & PaymentProcess
    print();
    print("   ---> Test CheckoutProcess & PaymentProcess class");

    PaymentProcess paymentProcess = new PaymentProcess();
    CheckoutProcess checkoutProcess = new CheckoutProcess();
    Order secondOrder = new Order();
    myOrders.add(secondOrder);

    print();
    if(paymentProcess instanceof PaymentProcess && paymentProcess instanceof AbstractProcess){
        print("PaymentProcess instance IS an instance of PaymentProcess class and AbstractProcess abstract class.");
    }else{
        print("PaymentProcess instance IS NOT an instance of PaymentProcess class and AbstractProcess abstract class.");
        
    }

    if(checkoutProcess instanceof CheckoutProcess && checkoutProcess instanceof AbstractProcess){
        print("CheckoutProcess instance IS an instance of CheckoutProcess class and AbstractProcess abstract class.");
    }else{
        print("CheckoutProcess instance IS NOT an instance of CheckoutProcess class and AbstractProcess abstract class.");
        
    }

    print();
    print("   Call paymentProcess.process(secondOrder):");
    paymentProcess.process(secondOrder);
    print("   Order status after action: " + secondOrder.getStatus());

    print();    
    print("   Call checkoutProcess.process(secondOrder):");
    checkoutProcess.process(secondOrder);
    print("   Order status after action: " + secondOrder.getStatus());

    print();
    print("   Call checkoutProcess.process(secondOrder):");
    checkoutProcess.process(secondOrder);
    print("   Order status after action: " + secondOrder.getStatus());

    print();
    print("   Call paymentProcess.process(secondOrder):");
    paymentProcess.process(secondOrder);
    print("Order status after action: " + secondOrder.getStatus());

    print();
    print("   Call paymentProcess.process(secondOrder):");
    paymentProcess.process(secondOrder);
    print("   Order status after action: " + secondOrder.getStatus());

    print();
    print("   Call checkoutProcess.process(secondOrder):");
    checkoutProcess.process(secondOrder);
    print("   Order status after action: " + secondOrder.getStatus());
    

    //Orders id correctness
    print();
    print("   --->Test Order id correctness");
    
    addOrders(2);
    showOrdersIdList();

    print();
    print("  Remove Order with id 2 and 3.");
    myOrders.remove(2);
    myOrders.remove(1);
    showOrdersIdList();

    addOrders(5);
    showOrdersIdList();
    }
}
