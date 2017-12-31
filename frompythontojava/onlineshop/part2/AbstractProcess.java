package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess implements Orderable{
    public void process(Orderable item){
        stepBefore();
        action(item);
        stepAfter();
    }
    public void stepBefore(){
        ;
    }
    abstract protected void action(Orderable item);
    
    public void stepAfter(){
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