package frompythontojava.onlineshop.part3;

import java.util.Scanner;

public class View{

    public String getInput(Object message){
        Scanner input = new Scanner(System.in);
        String user_input;
        
        do{
            print(message);
            user_input = input.nextLine();
        }while(user_input.trim().length() == 0);

        input.close();
        return user_input;
    }

    public void print(Object message){
        System.out.println(message);
    }

}