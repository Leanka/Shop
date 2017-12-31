package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess implements Orderable{
    public void process(Orderable item){
        ;
    }
    public void stepBefore(){
        ;
    }
    abstract protected void action(Orderable item);
    
    public void setpAfter(){
        ;
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