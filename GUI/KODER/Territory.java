package KODER;

public class Territory extends Ownable {
    private int rent;
    private TerritorysController TC;
    
    public Territory(int id, String name, String Colour, int price, int rent,
        int IH, int IIH, int IIIH, int IVH, int HO, int BH) {
        super(name, price);
        this.rent = rent;
        TC = new TerritorysController(id, Colour,
            new int[] { IH, IIH, IIIH, IVH, HO });
    }
    
    @Override
    public int getRent(Players p){
        return (getOwnedBy()?rent*2:rent);
    }
    
    public String getColour(){
        return TC.getColor();
    }
    
    public int getId() {
        return TC.getId();
    }
    public boolean[] GetHouse() {
        return TC.giveHouses();
    }
    
    public boolean getOwnedBy(){
        boolean colorsOwned=true;
        int[] sameColor=TC.GetOtherGrounds();
        for(int i=1;i<=sameColor.length;i++) if(TC.getOwner(sameColor[i-1]-1)!=this.owner.getPlayer()) colorsOwned=false;
        return colorsOwned;
    }
}
