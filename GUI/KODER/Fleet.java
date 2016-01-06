package KODER;

public class Fleet extends Ownable{
    private int rent;
    
    public Fleet(String name,int price, int rent){
        super(name,price);
        setRent(rent);
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        this.rent=rent;
    }
}
