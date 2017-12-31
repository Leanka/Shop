package frompythontojava.onlineshop.part1;

import java.util.Date;

public class FeaturedProductCategory extends ProductCategory{
    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate){
        super.setName(name);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getInfo(){
        return super.getInfo() + "date" + this.expirationDate.toString() + ",";
    }

}