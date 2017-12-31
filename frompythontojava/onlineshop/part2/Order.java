package frompythontojava.onlineshop.part2;

public class Order implements Orderable{
    private int id;
    private String status;
    private static int idCounter = 0;

    public Order(){
        this.status = "new";
        this.id = idCounter++;
    }
    public String getStatus(){
        return this.status;
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
        return true;        
    }
}