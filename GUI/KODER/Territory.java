package KODER;

public class Territory extends Ownable{
    private int rent;
    
    public Territory(String name,int price,int rent, int IH, int IIH, int IIIH,int IVH,int HO,int BH){
        super(name,price);
    }
    
    @Override
    public int getRent(Players p){
        this.setRent(rent,p);
        return this.rent;
    }
    
    private void setRent(int rent,Players p){
        this.rent=rent;
    }
}
