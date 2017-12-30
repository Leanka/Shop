package frompythontojava.onlineshop.part2;

public class Order implements Orderable{
    private int id = 0;
    private String status = "status";
    private static int idCounter = 0;

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