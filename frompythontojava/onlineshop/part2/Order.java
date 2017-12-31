package frompythontojava.onlineshop.part2;

public class Order implements Orderable{
    private int id;
    private String status;
    private static int idCounter = 0;

    public Order(){
        this.status = "new";
        this.id = ++idCounter;
    }
    public String getStatus(){
        return this.status;
    }

    public static int getIdCounter(){  //make it static for tests (so it could be reached from static context)
        return idCounter;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public boolean checkout(){
        if(this.status.equals("new")){
            this.status = "checked";
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(){
        if(this.status.equals("checked")){
            this.status = "payed";
            return true;
        }
        return false;        
    }
}