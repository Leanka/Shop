package frompythontojava.onlineshop.part3;

import java.util.Scanner;

public class View{

    public String getInput(Object message){
        Scanner input = new Scanner(System.in);
        String user_input;
        
        do{
            System.out.print(message);
            user_input = input.nextLine();
        }while(user_input.trim().length() == 0);

        return user_input;
    }

    public void print(Object message){
        System.out.println(message);
    }

    public void print(){
        print("");
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showList(Object [] list){
        for(Object item: list){
            print(String.valueOf(item));
        }
    }

    public void holdTillKeyPressed(){
        Scanner input = new Scanner(System.in);
        print();
        System.out.print("Press any key to continue");
        input.nextLine();        
    }


}