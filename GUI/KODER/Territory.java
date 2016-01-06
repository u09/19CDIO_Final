package KODER;

public class Territory extends Ownable{
    private int rent;
    
    public Territory(String name,int price,int rent){
        super(name,price);
        this.setRent(rent);
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        this.rent=rent;
    }
}
