package KODER;

public class Territory extends Ownable{
    private int rent;
    private String colour;
    
    public Territory(String name,String Colour,int price,int rent, int IH, int IIH, int IIIH,int IVH,int HO,int BH){
        super(name,price);
        this.setRent(rent);
        this.setColour(Colour);
    }
    public void setColour(String colour){
        this.colour=colour;
    }
    public String getColour(){
        return this.colour;
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        this.rent=rent;
    }
}
