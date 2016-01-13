package KODER;

public class Territory extends Ownable{
    private int rent;
    private TerritorysController TC;
    
    public Territory(int id,String name,String Colour,int price,int rent, int IH, int IIH, int IIIH,int IVH,int HO,int BH){
        super(name,price);
        this.rent=rent;
        TC=new TerritorysController(id,Colour,new int[]{IH,IIH,IIIH,IVH,HO});
    }
    
    @Override
    public int getRent(Players p){
        this.setRent(rent,p);
        return this.rent;
    }
    
    private void setRent(int rent,Players p){
        this.rent=rent;
    }
    
    public String getColour(){
        return TC.getColor();
    }
    
    public int getId(){
        return TC.getId();
    }
    public boolean[] GetHouse(){
        return TC.giveHouses();
    }
}
