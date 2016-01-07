package KODER;

public class Territory extends Ownable{
    private int rent;
    
    public Territory(String name,int price,int rent, int IH, int IIH, int IIIH,int IVH,int HO,int BH){
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
