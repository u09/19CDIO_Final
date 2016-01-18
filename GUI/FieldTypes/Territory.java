package FieldTypes;

import KODER.Ownable;
import KODER.Players;
import KODER.TerritorysController;

public class Territory extends Ownable {
    /* Noter til denne klasse:
     * getOwnedBy metoden kører igennem alle de veje med den samme farve og tjekker
     * 
     */ 
    private int rent;
    private TerritorysController TC;
    
    public Territory(int id, String name, String Colour, int price, int rent) {
        super(name, price);
        this.rent = rent;
        TC = new TerritorysController(id, Colour);
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
    
    public boolean getOwnedBy(){
        boolean colorsOwned=true;
        int[] sameColor=TC.GetOtherGrounds();
        for(int i=1;i<=sameColor.length;i++) if(TC.getOwner(sameColor[i-1]-1)!=this.owner.getPlayer()) colorsOwned=false;
        return colorsOwned;
    }
}
