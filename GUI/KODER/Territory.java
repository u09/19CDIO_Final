package KODER;

public class Territory extends Ownable{
    private int rent;
    private String colour;
    
    public Territory(String name,String Colour,int price,int rent, int IH, int IIH, int IIIH,int IVH,int HO,int BH){
        super(name,price);
<<<<<<< HEAD
=======
        this.setRent(rent);
        this.setColour(Colour);
    }
    public void setColour(String colour){
        this.colour=colour;
    }
    public String getColour(){
        return this.colour;
>>>>>>> origin/master
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
