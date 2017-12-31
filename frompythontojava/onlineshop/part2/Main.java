package frompythontojava.onlineshop.part2;

public class Main {
    public static void print(String message){
        System.out.println(message);
    }

    public static void print(){
        System.out.println();
    }

    public static void main(String[] args) {
    
    //Order
    print();
    print("   ---> Test Order class");

    Order firstOrder = new Order();

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


    // print("Initial order status. STATUS: " + firstOrder.getStatus());
    // print("Call pay() on new order. STATUS: " + firstOrder.getStatus());
    // firstOrder.pay();
    // print("Call checkout() on new order. STATUS: " + firstOrder.getStatus());
    // firstOrder.checkout();
    // print("Call checkout() on checked order. STATUS: " + firstOrder.getStatus());
    // firstOrder.checkout();
    // print("Call pay() checked order. STATUS: " + firstOrder.getStatus());
    // firstOrder.pay();
    // print("Call pay() payed order. STATUS: " + firstOrder.getStatus());
    // firstOrder.pay();
    
    //CheckoutProcess
    print();
    print("   ---> Test CheckoutProcess & PaymentProcess class");

    PaymentProcess paymentProcess = new PaymentProcess();
    CheckoutProcess checkoutProcess = new CheckoutProcess();
    Order secondOrder = new Order();

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

    

    }
}
