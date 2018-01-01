package frompythontojava.onlineshop.part1;

import java.util.GregorianCalendar;
import java.util.Date;
import java.time.LocalDate;
import frompythontojava.onlineshop.part3.View;


public class ExpirationDate{
    private View view = new View();
    private final int INCORRECT_DATE = -1;  //returning negative value indicates incorrect data (replacement of boolean)

    public int getMonthDay(){  //przekazywać miesiąc i rok żeby spr czy dzień mieści się w zasięgu danego mca
        int day;
        try{
            do{
                day = Integer.valueOf(view.getInput("Pass expiration date day (00): "));
            }while(day < 1 || day > 31);    
        }catch(NumberFormatException errorMessage){
            view.print(errorMessage);
            view.print("Incorrect data");
            return INCORRECT_DATE;
        }
        return day;
    }

    public int getMonth(){
        int month;
        try{
            do{
                month = Integer.valueOf(view.getInput("Pass expiration date month (00): "));
            }while(month < 1 || month > 12);    
        }catch(NumberFormatException errorMessage){
            view.print(errorMessage);
            view.print("Incorrect data");
            return INCORRECT_DATE;
        }
        return month-1; //as months start at 0 not at 1
    }

    public int getYear(){
        int currentYear = LocalDate.now().getYear();
        int year;
        try{
            do{
                year = Integer.valueOf(view.getInput("Pass expiration date year (0000): "));
            }while(year < currentYear);    
        }catch(NumberFormatException errorMessage){
            view.print(errorMessage);
            view.print("Incorrect data");
            return INCORRECT_DATE;
        }
        return year;
    }

    public Date getCurrentDate(){
        return new GregorianCalendar().getTime();
    }

    public Date getSettedDate(int year, int month, int day){
        return new GregorianCalendar(year, month, day).getTime();
    }

    public Date getEspiriationDate(){
        Date chosenDate = getCurrentDate();
        
        int year = getYear();
        if(year < 0){
            view.print("Incorrect year. Current date setted");
        }else{
            int month = getMonth();
            if(month < 0){
                view.print("Incorrect month. Current date setted");
            }else{
                int day = getMonthDay();
                if(day < 0){
                    view.print("Incorrect day. Current date setted");
                }else{
                    chosenDate = getSettedDate(year, month, day);
                }
            }
        }
        return chosenDate;
    }
}