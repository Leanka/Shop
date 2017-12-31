package frompythontojava.onlineshop.part1;


public class ProductCategory{
    private String name;
    private final Integer ID;
    private static Integer idCounter = 0;

    public ProductCategory(){
        this.name = "UNKNOWN CATEGORY";
        this.ID = ++idCounter;
    }

    public ProductCategory(String name){
        this.name = name;
        this.ID = ++idCounter;  
    }

    public String toString(){
        return this.getClass().getSimpleName() + ",";
    }

    public String getInfo(){
        return "category:" + this.name + ",";
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static Integer getIdCounter(){
        return idCounter;
    }

    public Integer getID(){
        return this.ID;
    }
}