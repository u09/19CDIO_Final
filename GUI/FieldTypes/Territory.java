package FieldTypes;

import KODER.Ownable;
import KODER.Players;
import KODER.TerritorysController;

public class Territory extends Ownable {
    /* Noter til denne klasse:
     * getOwnedBy metoden kører igennem alle de veje med den samme farve og tjekker
     */ 
    private int rent;
    private TerritorysController TC;

    // Konstruktør med 5 forskellige parametre
    public Territory(int id, String name, String Colour, int price, int rent) {
        // Henter navnet og prisen fra Field array og giver videre til superklassen Ownable.
        super(name, price);
        // Henter lejen fra Field arrayet, og sørger for den kun bliver herinde
        this.rent = rent; 
        // Opretter objekt af TerritorysController
        TC = new TerritorysController(id, Colour); 
    }
    
    public String getColour(){
        return TC.getColor();
    }
    // Bruges ikke
    public int getId() {
        return TC.getId();
    }
    
    @Override
    public int getRent(Players p){
        return (getOwnedBy()?rent*2:rent);
    }
    
    /**Metode som tjekker om felter af samme farve er ejet af en eller flere spiller, 
     * ud fra feltet nuværende spiller er landet på.
     * @return boolean colorsOwned
    */
    public boolean getOwnedBy(){
        boolean colorsOwned=true;
        // Vi laver et array, med numrene på de ensfarvede felter, med enten 2 eller 3 værdier
        int[] sameColor=TC.GetOtherGrounds(); 
        // For loop som løber igennem sameColor og tjekker om ejeren af et felt, også er ejeren af de andre af samme farve. 
        // Hvis ikke man ejer alle felter af samme farve, bliver colorsOwned false 
        for(int i=1;i<=sameColor.length;i++) if(TC.getOwner(sameColor[i-1]-1)!=this.owner.getPlayer()) colorsOwned=false;
        return colorsOwned;
    }
}
