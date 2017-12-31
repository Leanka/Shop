package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess{
    public void process(Orderable item){
        stepBefore();
        action(item);
        stepAfter();
    }
    public void stepBefore(){
        System.out.println("stepBefore placeholder");
    }
    abstract protected void action(Orderable item);
    
    public void stepAfter(){
        System.out.println("stepAfter placeholder");
    }
}