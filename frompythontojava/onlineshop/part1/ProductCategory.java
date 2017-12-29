package frompythontojava.onlineshop.part1;


public class ProductCategory{
    private String name;
    private Integer ID;

    public ProductCategory(){
        ;
    }

    public ProductCategory(String name){
        System.out.println(name + " from " + this.getClass().getSimpleName() + " class.");
        
    }
}