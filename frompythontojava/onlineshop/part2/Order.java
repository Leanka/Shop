package frompythontojava.onlineshop.part2;

public class Order implements Orderable{
    private int id;
    private String status = "status";
    private static int idCounter = 0;

    public Order(){
        this.id = idCounter++;
    }
    public String getStatus(){
        return this.status;
    }

    @Override
    public boolean checkout(){
        return true;
    }

    @Override
    public boolean pay(){
        return true;        
    }
}